
@LoginFeature
Feature: Validacion login en OrangeHRM

  @ValidLogin
  Scenario: Iniciar sesion con credenciales validas
    Given el usuario esta la pagina de inicio de sesion de OrangeHRM
    When el usuario ingresa el nombre de usuario "Admin" y la contraseña "admin123"
    And el usuario hace click en el boton iniciar sesion
    Then el usuario debe ser redireccionado al dashboard

  @LoginInvalidCredentials
  Scenario: Iniciar sesion con credenciales invalidas
    Given el usuario esta la pagina de inicio de sesion de OrangeHRM
    When el usuario ingresa el nombre de usuario "UsuarioIncorrecto" y la contraseña "contrasenaIncorrecta"
    And el usuario hace click en el boton iniciar sesion
    Then el usuario debe poder visualizar el mensaje "Invalid credentials"
