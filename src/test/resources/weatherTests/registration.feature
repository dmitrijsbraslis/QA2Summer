Feature: Testing registration API

  Scenario Outline: Checking password validation
    Given client:
      | email       | rr@rr.rr                 |
      | phone       | 123456789                |
      | pwd         | <password>               |
      | birthDate   | 1988-06-25T00:00:00.000Z |
      | description | Some test description    |

    And client address is:
      | country | US        |
      | city    | New York  |
      | state   | John Doe  |
      | zip     | LV-1011   |
      | street  | Ropazu 10 |

    When we register user
    And we register user

    Then response is:
      | result  | <result>  |
      | details | <details> |

    Examples:
      | password  | result | details              |
      | 1111aaaaa | true   | none                 |
#      | 111111иии | false  | Field pwd bad format |
#      |           | false  | Field XXX missed     |


  Scenario Outline: Checking age validation
    Given client:
      | email       | rr@rr.rr                 |
      | phone       | 123456789                |
      | pwd         | sfdfsd235345               |
      | birthDate   | <birthDate> |
      | description | Some test description    |

    And client address is:
      | country | US        |
      | city    | New York  |
      | state   | John Doe  |
      | zip     | LV-1011   |
      | street  | Ropazu 10 |

    When we register user

    Then response is:
      | result  | <result>  |
      | details | <details> |

    Examples:
      | birthDate  | result | details              |
    |            |        |                      |