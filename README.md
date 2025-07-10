# 🚀 PROYECTO DE AUTOMATIZACIÓN DE PRUEBAS

**Tecnologías utilizadas:**

* Java 18
* Screenplay
* Gradle
* Cucumber
* Selenium
* Rest Assured
* DTO
* MySQL Connector
* JUnit
* SonarQube

---

**⚠️ IMPORTANTE:** *Leer el documento "README DE CONFIGURACIÓN.pdf" antes de ejecutar.*

Este proyecto es un punto de partida para automatizar pruebas utilizando la librería **Serenity BDD** con el patrón de diseño **Screenplay**, implementando versiones actualizadas:

* Serenity: `4.2.15`
* Gradle: `8.10`
* Cucumber: `7.10.1`

---

**📚 Documentación oficial:**

* Serenity Screenplay: https://serenity-bdd.github.io/theserenitybook/latest/serenity-screenplay.html
* Repositorio oficial Serenity Core: https://github.com/serenity-bdd/serenity-core

---

**🔧 Consideraciones opcionales:**

1. **Revisar archivos base:**

    * `settings.gradle`
    * `build.gradle`
    * `serenity.conf`

   Asegúrate de completar los *TODO* (nombre del proyecto, dependencias, versiones, etc.).

2. **Eliminar la carpeta `.git`** si vas a subir el proyecto a otro repositorio.

3. **Verificar los drivers** configurados en `src/test/resources/serenity.conf`.

4. **Actualizar este `README.md`** si haces modificaciones relevantes.

---

**📁 Estructura de carpetas clave:**

📁 libs         → Inclusión de .jar personalizados  
📁 ci           → Jenkinsfile o archivos YAML para CI/CD  
📁 gradle       → Wrapper de Gradle  
📁 src          → Arquitectura principal del proyecto de automatización  
📁 target       → Reportes generados por las pruebas

---

¡Este proyecto está diseñado para ayudarte a crear un portafolio sólido de automatización de pruebas!