## **Proyecto de Automatización de Pruebas con Screenplay, Selenium y Cucumber**

Este proyecto consiste en la automatización de pruebas funcionales sobre el login y la funcionalidad de crear un candidato y validar si se listo en el módulo de recruitment de la plataforma OrangeHRM, 
utilizando el patrón de diseño Screenplay junto con las herramientas Java, Selenium, Cucumber, Serenity BDD entre otras.

## **Tecnologías y Herramientas**

- Lenguaje: Java
- Framework de Automatización: Screenplay y Serenity BDD
- Pruebas BDD: Cucumber
- Driver Web: Selenium WebDriver
- Gestión de Dependencias: Maven
- IDE: IntelliJ IDEA
- Control de Versiones: Git y GitHub

## **Flujos Automatizados**

- Funcion Inicio de sesion
  - Validación del ingreso exitoso al sistema con los datos proporcionados.
  - Validacion mensaje con credenciales incorrectas.
 
- Funcion Agregar candidato y verificar si se listo en el modulo recruitment
   - Agregar candidato nuevo diligenciando el formulario correspondiente y verificando mensaje de creacion.
   - Validar en lista de candidatos, candidato creado por medio de busqueda del keyword.
 
## **Estructura del Proyecto**

  - El proyecto sigue la estructura típica del patrón Screenplay:
    - FEATURE: Se definen los pasos del escenario de cada flujo en lenguaje Gherkin.
    - RUNNER: Desde donde se ejecutan los flujos y se definen sus configuraciones generales.
    - UI: Es donde se mapean los elementos web del sistema.
    - TASK: Define acciones específicas que un actor puede realizar en la aplicación.
    - STEPDEFINITION: Implementan los pasos definidos en las FEATURES y conecta con nuestras TASKS.
    - QUESTION: Validan estados y mensajes del sistema mediante consultas específicas.
    - INTERACTION Interacciones especiales en este caso implementando la clase Actions.
   
 

  
