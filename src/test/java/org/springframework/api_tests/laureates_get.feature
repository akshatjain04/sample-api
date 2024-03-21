# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /laureates_get for http method type GET 
# RoostTestHash=bb9ad621b1
# 
# 

# ********RoostGPT********
Feature: Nobel Prize Laureates API Test

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
  * url urlBase
  * def authToken = karate.properties['AUTH_TOKEN']
  * header Authorization = 'Bearer ' + authToken

Scenario Outline: Get Laureates with valid query parameters
  Given path '/2.1/laureates'
  And param <Parameter> = <Value>
  When method get
  Then status 200
  And match response.laureates[*].id contains only '#number'
  And match each response.laureates[*].laureateIfPerson.knownName.en == '#string'
  And match each response.laureates[*].nobelPrizes[*].awardYear == '#number'

  Examples:
    | Parameter             | Value          |
    | offset                | 1              |
    | limit                 | 1              |
    | sort                  | 'asc'          |
    | ID                    | 456            |
    | name                  | 'Marie Curie'  |
    | gender                | 'female'       |
    | motivation            | 'radiation'    |
    | affiliation           | 'University'   |
    | residence             | 'Paris'        |
    | birthDate             | 1867           |
    | birthDateTo           | '1867-11-07'   |
    | deathDate             | '1934-07-04'   |
    | deathDateTo           | 1934           |
    | foundedDate           | '1905-06-15'   |
    | birthCity             | 'Warsaw'       |
    | birthCountry          | 'Poland'       |
    | birthContinent        | 'Europe'       |
    | deathCity             | 'Sallanches'   |
    | deathCountry          | 'France'       |
    | deathContinent        | 'Europe'       |
    | foundedCity           | 'Berlin'       |
    | foundedCountry        | 'Germany'      |
    | foundedContinent      | 'Europe'       |
    | HeadquartersCity      | 'Geneva'       |
    | HeadquartersCountry   | 'Switzerland'  |
    | HeadquartersContinent | 'Europe'       |
    | nobelPrizeYear        | 1903           |
    | yearTo                | 1905           |
    | nobelPrizeCategory    | 'phy'          |
    | format                | 'json'         |
    | csvLang               | 'en'           |

Scenario: Get Laureates with invalid parameters
  Given path '/2.1/laureates'
  And param limit = 'invalid'
  When method get
  Then status 400

Scenario: Get Laureates with non-existent resource
  Given path '/2.1/laureates'
  And param ID = 999999
  When method get
  Then status 404

Scenario: Get Laureates with unprocessable entity
  Given path '/2.1/laureates'
  And param birthDate = 'invalid-date'
  When method get
  Then status 422
