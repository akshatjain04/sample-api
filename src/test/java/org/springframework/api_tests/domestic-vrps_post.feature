# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /domestic-vrps_post for http method type POST 
# RoostTestHash=9b8162301d
# 
# 

# ********RoostGPT********
Feature: Test Domestic VRPs API Endpoints

Background:
    * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
    * url urlBase
    * def authToken = karate.properties['AUTH_TOKEN']

Scenario Outline: Create a domestic VRP with valid consent and data
    Given path '/domestic-vrps'
    And header Authorization = 'Bearer ' + authToken
    And header x-fapi-interaction-id = '<interactionId>'
    And header x-jws-signature = '<jwsSignature>'
    And request <requestBody>
    When method POST
    Then status 201
    And match response contains { Data: '#notnull' }
    And match response contains { Risk: '#notnull' }
    And match response contains { Links: '#notnull' }
    And match response contains { Meta: '#notnull' }
    And match response.Data.DomesticVRPId == '#regex [\\w-]+'
    And match response.Data.ConsentId == '<consentId>'
    And match response.Data.Status == '#regex (AcceptedCreditSettlementCompleted|AcceptedSettlementInProcess|Rejected)'
    And match response.Data.Initiation == <initiation>
    And match response.Data.Instruction == <instruction>
    And match response.Risk.PaymentContextCode == <risk.PaymentContextCode>

    Examples:
        | interactionId                          | jwsSignature | consentId                             | requestBody                                      | initiation                            | instruction                          | risk.PaymentContextCode |
        | 'f8273b70-d5c0-4ef7-b3ba-2b3400fe1956' | 'JWS-SAMPLE' | '9944a9db-2c18-40fc-a611-a28fd85965a1' | read('classpath:examples/domestic-vrp-request.json') | read('classpath:examples/initiation.json') | read('classpath:examples/instruction.json') | 'PispPayee'              |

Scenario: Create a domestic VRP with invalid consent
    Given path '/domestic-vrps'
    And header Authorization = 'Bearer ' + authToken
    And header x-fapi-interaction-id = 'f8273b70-d5c0-4ef7-b3ba-2b3400fe1956'
    And header x-jws-signature = 'JWS-SAMPLE'
    And request read('classpath:examples/domestic-vrp-invalid-consent-request.json')
    When method POST
    Then status 400
    And match response contains { Code: '400' }
    And match response contains { Message: '#string' }
    And match response contains { Errors: '#array' }

Scenario: Unauthorized access to create domestic VRP
    Given path '/domestic-vrps'
    And header Authorization = 'Bearer invalid_token'
    And header x-fapi-interaction-id = 'f8273b70-d5c0-4ef7-b3ba-2b3400fe1956'
    And request read('classpath:examples/domestic-vrp-request.json')
    When method POST
    Then status 401
    And match response contains { Code: '401' }
    And match response contains { Message: '#string' }

Scenario: Access forbidden to create domestic VRP due to missing JWS signature
    Given path '/domestic-vrps'
    And header Authorization = 'Bearer ' + authToken
    And header x-fapi-interaction-id = 'f8273b70-d5c0-4ef7-b3ba-2b3400fe1956'
    And request read('classpath:examples/domestic-vrp-request.json')
    When method POST
    Then status 403
    And match response contains { Code: '403' }
    And match response contains { Message: '#string' }

Scenario: Create domestic VRP with unsupported media type
    Given path '/domestic-vrps'
    And header Authorization = 'Bearer ' + authToken
    And header x-fapi-interaction-id = 'f8273b70-d5c0-4ef7-b3ba-2b3400fe1956'
    And header Content-Type = 'text/plain'
    And request 'Invalid media type'
    When method POST
    Then status 415
    And match response contains { Code: '415' }
    And match response contains { Message: '#string' }

Scenario: Create domestic VRP with server error
    Given path '/domestic-vrps'
    And header Authorization = 'Bearer ' + authToken
    And header x-fapi-interaction-id = 'f8273b70-d5c0-4ef7-b3ba-2b3400fe1956'
    And request read('classpath:examples/domestic-vrp-request.json')
    When method POST
    Then status 500
    And match response contains { Code: '500' }
    And match response contains { Message: '#string' }
