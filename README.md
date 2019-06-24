# Rustico Restaurant Web Application :tada:

Tarea final de la materia "Programación N-Capas"

#### Como correr el proyecto

* Importar el proyecto en **IntelliJ IDEA**, es necesario Java JDK 12
* Modificar el archivo *src/main/resources/application.properties* con los datos correctos del ambiente actual, la contraseña del usuario postgres y el puerto del servidor de postgres:

``` properties
    ***
    spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/tareaNCapas
    spring.datasource.username=postgres
    spring.datasource.password=1235
    ***
```

* En este repositorio está presente *tareaNCapas.backup* el respaldo de la base que se utilizó

* Correr el proyecto desde la interfaz del IDE o desde el archivo *src/main/kotlin/me/nelsoncastro/rustico/RusticoApplicaction.kt*

* Ingresar a localhost:8080
