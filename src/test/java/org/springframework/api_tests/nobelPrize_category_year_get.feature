# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /nobelPrize/{category}/{year}_get for http method type GET 
# RoostTestHash=adfce3f1d2
# 
# 

# ********RoostGPT********
Feature: Nobel Prize Information Retrieval

Background:
  * def urlBase = karate.properties['url.base'] || 'http://localhost:8080'
  * url urlBase
  * def authToken = karate.properties['AUTH_TOKEN']
  * configure headers = { Authorization: '#(authToken)' }

Scenario Outline: Get Nobel Prize information for a specific category and year
  Given path '2.1/nobelPrize', <category>, <year>
  When method get
  Then status 200
  And match response contains { nobelPrize: '#object' }
  And match response.nobelPrize contains { awardYear: <year> }
  And match response.nobelPrize.categoryFullName contains { en: '#string', se: '#string' }
  And match response.nobelPrize.dateAwarded == '#regex \\d{4}-\\d{2}-\\d{2}'
  And match response.nobelPrize.prizeAmount == '#number'
  And match response.nobelPrize.prizeAmountAdjusted == '#number'
  And match response.nobelPrize.topMotivation contains { en: '#string', se: '#string' }
  And match each response.nobelPrize.laureates contains { id: '#number', name: '#object', portion: '#string', sortOrder: '#string', motivation: '#object', links: '#array' }

  Examples:
    | category | year |
    | 'che'    | 1989 |
    | 'eco'    | 2003 |
    | 'lit'    | 2011 |
    | 'pea'    | 1999 |
    | 'phy'    | 1967 |
    | 'med'    | 1984 |

Scenario: Bad Request when invalid category is provided
  Given path '2.1/nobelPrize', 'invalid', '2020'
  When method get
  Then status 400
  And match response == { code: '400', message: 'Invalid category provided' }

Scenario: Not Found when the resource does not exist
  Given path '2.1/nobelPrize', 'che', '1800'
  When method get
  Then status 404
  And match response == { code: '404', message: 'Resource not found' }

Scenario: Unprocessable Entity when semantic errors are present
  Given path '2.1/nobelPrize', 'lit', 'abcd'
  When method get
  Then status 422
  And match response == { code: '422', message: 'Semantic errors in request' }
