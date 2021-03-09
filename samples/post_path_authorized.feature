
Feature: post path authorized

  Background:
    * def id = read('classpath:scripts/random_id.js')
    * def getToken = read('classpath:scripts/get_token.js')
    * def baseUrl = (typeof baseUrl !== 'undefined' ? baseUrl : occiautoApiBaseUrl)
    * def path = (typeof path !== 'undefined' ? path : '/customer/validate/rules')
    * def identification = (typeof identification !== 'undefined' ? identification : id(100000,999999999))
    * def parameters = { identification: '#(identification)' }
    * def token = (typeof token !== 'undefined' ? token : getToken(parameters))
    * def authType = (typeof authType !== 'undefined' ? authType : 'Bearer')
    * def traceId = (typeof traceId !== 'undefined' ? traceId : 'bd2613f65fb1d67a')
    * def bodyStr = (typeof bodyStr !== 'undefined' ? bodyStr : '{}')
    * def body = (typeof body !== 'undefined' ? body : karate.toBean(bodyStr, 'net.minidev.json.JSONObject'))
    * def operation = 'POST'

  Scenario: send
    Given url baseUrl
    And header Authorization = authType + ' ' + token
    And header X-Client-Trace-Id = traceId
    And path path
    And request body
    When method post
#    Then status 200
    * call read('classpath:com/peterland/karate/api/model/templates/print/print_request/print_request.feature') { baseUrl: '#(baseUrl)', path: '#(path)', operation: '#(operation)', body: '#(body)', response: '#(response)'}