# ********RoostGPT********

# Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview
# 
# Feature file generated for /domestic-vrp-consents/{ConsentId}_delete for http method type DELETE 
# RoostTestHash=4bab52de77
# 
# 

# ********RoostGPT********
Feature: Domestic VRP Consents API

Background:
  * def urlBase = karate.properties['url.base'] || karate.get('urlBase', 'http://localhost:8080')
  * url urlBase
  * def authHeader = 'Authorization'
  * def authToken = karate.properties['AUTH_TOKEN']

Scenario Outline: Delete a domestic VRP consent with valid ConsentId
  Given path 'domestic-vrp-consents/', <ConsentId>
  And header authHeader = 'Bearer ' + authToken
  When method delete
  Then status 204

  Examples:
    | ConsentId                               |
    | 9944a9db-2c18-40fc-a611-a28fd85965a1    |

Scenario Outline: Delete a domestic VRP consent with invalid ConsentId leads to 400 Bad Request
  Given path 'domestic-vrp-consents/', <ConsentId>
  And header authHeader = 'Bearer ' + authToken
  When method delete
  Then status 400
  And match response contains 
    """
    { 
      "Code": "#string", 
      "Message": "#string", 
      "Errors": "#array" 
    }
    """
  And match each response.Errors contains 
    """
    { 
      "ErrorCode": "#string", 
      "Message": "#string" 
    }
    """

  Examples:
    | ConsentId    |
    | invalid-id   |

Scenario: Delete a domestic VRP consent without authorization leads to 401 Unauthorized
  Given path 'domestic-vrp-consents/9944a9db-2c18-40fc-a611-a28fd85965a1'
  When method delete
  Then status 401

Scenario: Delete a domestic VRP consent with forbidden access leads to 403 Forbidden
  Given path 'domestic-vrp-consents/9944a9db-2c18-40fc-a611-a28fd85965a1'
  And header authHeader = 'Bearer ' + authToken
  When method delete
  Then status 403

Scenario: Attempt to use an unsupported method like POST leads to 405 Method Not Allowed
  Given path 'domestic-vrp-consents/9944a9db-2c18-40fc-a611-a28fd85965a1'
  And header authHeader = 'Bearer ' + authToken
  When method post
  Then status 405

Scenario: Delete a domestic VRP consent with unsupported media type leads to 415 Unsupported Media Type
  Given path 'domestic-vrp-consents/9944a9db-2c18-40fc-a611-a28fd85965a1'
  And header authHeader = 'Bearer ' + authToken
  And header 'Content-Type' = 'application/xml'
  When method delete
  Then status 415

Scenario: Too many requests to delete a domestic VRP consent leads to 429 Too Many Requests
  Given path 'domestic-vrp-consents/9944a9db-2c18-40fc-a611-a28fd85965a1'
  And header authHeader = 'Bearer ' + authToken
  When method delete
  Then status 429
  And match responseHeaders contains 
    """
    { 
      "Retry-After": "#number" 
    }
    """

Scenario: Server error while deleting a domestic VRP consent leads to 500 Internal Server Error
  Given path 'domestic-vrp-consents/9944a9db-2c18-40fc-a611-a28fd85965a1'
  And header authHeader = 'Bearer ' + authToken
  When method delete
  Then status 500
