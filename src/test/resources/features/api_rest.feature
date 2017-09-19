@Ready
Feature: Testing Api Rest on http://fakerestapi.azurewebsites.net


  #GET
  @start_this
  Scenario Outline: Making a correct GET call to API entry without parameters

    When the next GET end-point "<point>"
    Then the response status code should be 200
    And check if the field "<field>" contains the value "<value>" for id <id>

    Examples:
      | point           | field    | value                                                                 | id |
      | api/Users       | UserName | User 3                                                                | 3  |
      | api/Activities  | Title    | Activity 12                                                           | 12 |
      | api/CoverPhotos | Url      | https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 4&w=250&h=350 | 4  |

  @start_this
  Scenario Outline: Making a correct GET call to API entry with parameters

    Given the next GET end-point "<point>" and the ID <id>

    When the response status code should be 200

    Then check if the field "<field>" contains the value "<value>" if id <id>

    Examples:
      | point           | field    | value       | id |
      | api/Users       | UserName | User 3      | 3  |
      | api/Activities  | Title    | Activity 12 | 12 |
      | api/CoverPhotos | IDBook   | 12          | 12 |


  #POST
  @start_this
  Scenario Outline: Making a POST call, inserting the following data

    Given the next POST end-point "<point>"
    When split the string of fields "<fieldsArray>" and string of values "<valuesArray>"
    And send the POST call
    Then the response post status code should be 200
    And returned id is the same <id>
    And the values of the fields are correctly
    Examples:
      | id | point          | fieldsArray                   | valuesArray                                              |
      | 2  | api/Users      | ID#!UserName#!Password        | 2#!Servidor#!pass1234                                    |
      | 12 | api/Activities | ID#!Title#!DueDate#!Completed | 12#!Actividad12#!2017-09-15T06:51:04.4391246+00:00#!true |

  @start_this
  Scenario Outline: Making a fail POST call with a wrong entry-point
    Given the next POST end-point "<point>"
    And send the POST call
    Then the response post status code should be 404
    Examples:
      | point               |
      | api/UsersWrong      |
      | api/ActivitiesWrong |

  @start_this
  Scenario Outline: Making a fail POST call with wrong parameter names, api should reject the post with error message

    Given the next POST end-point "<point>"
    When split the string of fields "<fieldsArray>" and string of values "<valuesArray>"
    And send the POST call
    Then the response post status code should be 400
    Examples:
      | point          | fieldsArray                       | valuesArray                                              |
      | api/Users      | ID#!UserName#!contrasenya         | 2#!Servidor#!pass1234                                    |
      | api/Activities | ID#!titulitis#!DueDate#!Completed | 12#!Actividad12#!2017-09-15T06:51:04.4391246+00:00#!true |

#    TO PASS ARRAYS:
#    @test
#    Scenario: Test array values
#      Then I test array values "username,password"


  #POST
  @start_this
  Scenario Outline: Inserting books in the DB

    Given the next entry point"<point>" with our database
    When and adding the next data "<fieldsArray>" with values "<valuesArray>"
    And send the the data to the server
    Then the response of the server should be 200
    And the returned identificator of the book is the same <id>
    And we check the data
    #JAJAJAJAJJAJA
    Examples:
      | id | point     | fieldsArray                                             | valuesArray                                                                            |
      | 2  | api/Books | ID#!Title#!Description#!PageCount#!Excerpt#!PublishDate | 2#!El burraco#!Un libro mu bonito#!402#!I dont know#!2017-10-25T06:51:04.4391246+00:00 |
      | 12 | api/Books | ID#!Title#!PageCount#!PublishDate                       | 12#!La cabrilla#!617#!2017-10-23T06:51:04.4391246+00:00                                |