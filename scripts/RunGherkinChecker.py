#!/usr/bin/env python3
import argparse
import os
import pathlib
import re
import subprocess
import tarfile
import tempfile
import zipfile

BINDIR = tempfile.gettempdir() + '/GherkinChecker'
WORKSPACE_ENV = 'TICSDEVPATH'

def parse_arguments():
  parser = argparse.ArgumentParser(description='Gherkin Code Checker Tester')
  parser.add_argument('input', help='file/directory to check')
  parser.add_argument('--rule', type=int, nargs='+', help='rules to be checked')
  parser.add_argument('--test', nargs='?', default='default', const='enabled')  
  args = parser.parse_args()
  return args
  
def unzip(sourcefile, targetfile):
  if sourcefile.endswith('.zip'):
    with zipfile.ZipFile(sourcefile, 'r') as zip_ref:
      zip_ref.extractall(targetfile)
  elif sourcefile.endswith('.tar.gz'):
    with tarfile.open(sourcefile, 'r:gz') as zip_ref:
      zip_ref.extractall(targetfile)
  else: 
    print(f'zip file format of {sourcefile} not supported')
    
def get_tics_workspace():
  dir = os.environ.get(WORKSPACE_ENV)
  if dir is None:
    exit(f'Please set the {WORKSPACE_ENV} environment variable')
  return dir
    
def runtests(args, app, rules):
  if os.path.isdir(args.input):
    for rule in args.rule:
      success = True
      testfile = args.input + '/Rule' + str(rule) + '.feature'
      lines = open(testfile, 'r')
      violationlines = []
      linenumber = 0
      for line in lines:
        linenumber += 1
        if '# Violation' in line:
          violationlines.append(str(linenumber))        
      lines.close()
      
      command = app + ' "' + testfile + '" --rule' + str(rule)
      print(command)
      output = subprocess.getoutput(command)
      print(output)  
      linenumbers = re.findall('(\d+):', output)
      for linenumber in linenumbers:
        if linenumber in violationlines:
          violationlines.remove(linenumber)
        else:
          print(f'violation occurred for line {linenumber}, but it shouldn\'t')
          success = False
      for line in violationlines:
        print(f'violation missing for line {line}')
        success = False
      if success:
        print(f'TESTS FOR RULE {rule} HAVE SUCCEEDED!')
      else:
        print(f'TESTS FOR RULE {rule} HAVE FAILED!')
              
    
def main():      
  args = parse_arguments()
  workspace = get_tics_workspace()

  # performing build
  build = subprocess.getoutput(f'cd {workspace}/rules/gherkin/checker && gradlew build')
  print(build)
  if 'BUILD FAILED' in build:
    exit('Build failed, stopping the process')

  # prepare the code checker and run it
  unzip(f'{workspace}/rules/gherkin/checker/app/build/distributions/DutchPickle.zip', BINDIR)
  app = BINDIR + '/DutchPickle/bin/app'
  os.chmod(app, 0o755)
  rules = ''
  if not args.rule is None:
    for rule in args.rule:
      rules += ' --rule' + str(rule)

  # run tests
  if args.test == 'enabled':
    runtests(args, app, rules)
    
  # run single file
  elif os.path.isfile(args.input):
    command = app + ' "' + args.input + '"' + rules
    print(command)
    print(subprocess.getoutput(command))
    
  # run for directory  
  elif os.path.isdir(args.input):
    total = 0
    succeeded = 0
    for file in pathlib.Path(args.input).rglob('*.feature'):
      command = app + ' "' + str(file) + '"' + rules
      print(command)
      output = subprocess.getoutput(command)
      total += 1
      if not output:
        succeeded += 1   
      print(output)
    print(f'success rate: {succeeded}/{total}')
       
main()
