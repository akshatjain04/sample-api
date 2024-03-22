# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /nobelPrizes_get for http method type GET 
# RoostTestHash=4940f5c55b
# 
# 

# ********RoostGPT********
Feature: Nobel Prizes API Feature

Background:
  * def urlBase = karate.properties['url.base'] || 'http://localhost:8080'
  * url urlBase
  * def authToken = karate.properties['AUTH_TOKEN']
  * header Authorization = 'Bearer ' + authToken

Scenario Outline: Get Nobel Prizes with various query parameters
  Given path '/2.1/nobelPrizes'
  And param offset = <offset>
  And param limit = <limit>
  And param sort = <sort>
  And param nobelPrizeYear = <nobelPrizeYear>
  And param yearTo = <yearTo>
  And param nobelPrizeCategory = <nobelPrizeCategory>
  And param format = <format>
  And param csvLang = <csvLang>
  When method get
  Then status 200
  And assert response.nobelPrizes != null
  And match each response.nobelPrizes[*].awardYear == '#number'
  And match each response.nobelPrizes[*].category.en == '#string'
  And match each response.nobelPrizes[*].dateAwarded == '#regex\\d{4}-\\d{2}-\\d{2}'
  And match each response.nobelPrizes[*].prizeAmount == '#number'
  And match each response.nobelPrizes[*].laureates[*].id == '#number'

  Examples:
    | offset | limit | sort | nobelPrizeYear | yearTo | nobelPrizeCategory | format | csvLang |
    | 1      | 5     | asc  | 2000           | 2020   | che                | json   | en      |
    | 1      | 10    | desc | 1990           | 2000   | lit                | csv    | se      |

Scenario: Get Nobel Prizes without any query parameters
  Given path '/2.1/nobelPrizes'
  When method get
  Then status 200
  And assert response.nobelPrizes != null

Scenario: Get Nobel Prizes with invalid limit parameter
  Given path '/2.1/nobelPrizes'
  And param limit = 'invalid'
  When method get
  Then status 400
  And match response.code == '400'
  And match response.message == 'Invalid parameter'

Scenario: Get Nobel Prizes with year range without specifying nobelPrizeYear
  Given path '/2.1/nobelPrizes'
  And param yearTo = 2020
  When method get
  Then status 422
  And match response.code == '422'
  And match response.message == 'Missing required parameter'
