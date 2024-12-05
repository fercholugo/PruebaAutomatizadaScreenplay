

@RecruitmentModule
Feature: Modulo Recruitment en OrangeHRM

  @AddCandidate
  Scenario: Agregar un nuevo candidato desde el modulo de Recruitment
    Given el usuario esta la pagina de inicio de sesion de OrangeHRM
    When el usuario ingresa el nombre de usuario "Admin" y la contraseña "admin123"
    And el usuario estando en la dashboard navega al modulo Recruitment
    When el usuario hace clic en Add para agregar un nuevo candidato
    And el usuario diligencia el formulario con la siguiente informacion:
      | FirstName | LastName | Email | ContactNumber | Keyword | Vacancy |
      | Fernando | Lugo | fernandolugo@gmail.com | 3112223333 | 19342400 | test |
    And el usuario hace clic en Save
    Then el candidato debe aparecer en la lista de candidatos






