@CasosLogin
Feature: Acceder al aplicativo METIS
  Como usuario
  Quiero Autenticarme en la APP Metis
  A traves de la pagina de Acceso a la APP

  @LoginExitoso
  Scenario: Realizar la Autenticacion Exitosa en la APP
    Given que el Usuario quiere acceder a la APP
    When el escribe el usuario demo y la clave demo
    Then el ve el titulo Metis


