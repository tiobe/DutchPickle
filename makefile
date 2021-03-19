# $Id$
# This file is part of the overall build.
.SILENT:
.SUFFIXES:

TICSRULESPATH := $(TICSDEVPATH)/rules

SVNVERSION := $(shell svn info . | sed -n "s/Last Changed Rev: //p")
DAEMON := --no-daemon # to prevent using the Gradle Daemon in CI
GRADLE := $(CURDIR)/checker/gradlew -PSVNVERSION="$(SVNVERSION)" $(DAEMON)
TOOL := DutchPickle

.PHONY: build clean rebuild test unittest package relnotes clean_relnotes publish

all: build

build:
	$(GRADLE) distZip -p checker

clean: clean_relnotes
	$(GRADLE) clean -p checker

rebuild: clean build

test: unittest

unittest:
	$(GRADLE) test -p checker

coveragereport:
	$(GRADLE) test jacocoTestReport
ifneq ($(TESTCOVERAGE_RESULTDIR),)
	$(MKDIR) "$(TESTCOVERAGE_RESULTDIR)/TICSsql"
	cp $(TICSRULESPATH)/TICSsql/build/reports/jacoco/test/jacocoTestReport.xml "$(TESTCOVERAGE_RESULTDIR)/TICSsql/"
endif

package: build
	cp checker/build/distributions/DutchPickle.zip $(TOOL)-$(SVNVERSION).zip

# The SVN repository number from which revisions onwards one must
# collect release notes.
STARTREV := 42270

relnotes:
ifeq ($(OS),Windows_NT)
	svn log --xml -r $(SVNVERSION):$(STARTREV) | msxsl -o $(TOOL)-relnotes.html - svn-log.xslt
else
	svn log --xml -r $(SVNVERSION):$(STARTREV) | xsltproc -o $(TOOL)-relnotes.html svn-log.xslt -
endif

clean_relnotes:
	rm -f $(TOOL)-relnotes.html

DEST = absolem:/home/wilde/ticsweb/pub/codecheckers/$(TOOL)
INSTALLERDEST = absolem:/home/wilde/ticsweb/pub/installer
publish: package relnotes
	scp $(TOOL)-$(SVNVERSION).zip $(TOOL)-relnotes.html $(DEST)
	scp $(TOOL)-$(SVNVERSION).zip $(INSTALLERDEST)/$(TOOL)-latest.zip