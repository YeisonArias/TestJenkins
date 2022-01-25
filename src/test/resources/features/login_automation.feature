Feature: Login en la APP
  Como usuario
  Quiero acceder a la APP
  A traves de la Pagina de Acceso

  @LoginDataTable
  Scenario: Autenticacion Exitosa
    Given que quiero ingresar a la APP
    When ingreso el usuario y la clave
    |user |pass |
    |demo1|demo1|
    |demo2|demo2|
    |demo3|demo3|
    |demo4|demo4|
    Then verifico el mensaje de Bienvenida
    |mensaje    |
    |Metis      |