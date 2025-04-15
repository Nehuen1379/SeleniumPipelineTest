Feature: Login al sistema

  Scenario: Usuario se loguea exitosamente
    Given que el usuario está en la página de login
    When ingresa su usuario "standard_user" y contraseña "secret_sauce"
    Then debería ver la página principal