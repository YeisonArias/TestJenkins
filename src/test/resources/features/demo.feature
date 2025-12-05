Feature: Test

  @Test
  Scenario: Test
    Given que el usuario ingresa a la PARABANK
    When Test1
    Then Test2

  @Test2
  Scenario: Login Exitoso PARABANK
    Given que el usuario ingresa a la PARABANK
    When el escribe el usuario "john" y la clave "demo"
    Then el ve el mensaje de bienvenida "Welcome John Smith"

  @Test3
  Scenario Outline: Login Exitoso PARABANK
    Given que el usuario ingresa a la PARABANK
    When el escribe el usuario "<user>" y la clave "<password>"
    Then el ve el mensaje de bienvenida "<mensaje>"
    Examples:
    |user |password |mensaje            |
    |john |demo     |Welcome John Smith |
    |john |demo     |Welcome John Smith |
    |john |demo     |Welcome John Smith |