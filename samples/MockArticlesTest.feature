Feature: MockArticlesTest

  # Mock the Articles.get to return only 12 articles (in total) and assert that only [12] are returned with [2] page in total
  @WireMockStart @WireMockStop
  Scenario Outline: Mock Articles GET total and result
    When I GET articles with limit
    Then I verify response status is 200
    Then I verify response has 10 articles and 500 articles in total
    When I GET articles with Mock total <mockNum>
    Then I verify response has 10 articles and <mockNum> articles in total

    Examples:
        | mockNum |
        | 12      |