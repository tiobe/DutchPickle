
Feature: js function

  Background:
    * def obj1 = { a: 1, b: 2, c: 3 }
    * def obj2 = { c: 8, d: 5, e: 6 }
    * def obj3 = { a: 7, b: 2, d: 3 }
    And def obj2 =
    """
  {
  "name": "Juan Lopez",
  "mobile": 3172635633,
  "email": "peterdavid_gutierrez@hotmail.com"
  }
  """

  Scenario: execute
    * print obj1
    * print obj2
#    * def append = function(f, s){ for (var i = 0; i < s.length; i++) { f.add(s[i]) }; return f }
#    * def result = append(obj1, obj2)
    * def foo = { a: 1 }
    * def bar = karate.combine(obj1, obj2, obj3)
#    * print id(obj1,obj2)
#    * print result
    * print bar