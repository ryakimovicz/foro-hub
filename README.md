# Challenge ONE - Foro Hub 🚀

<p align="center">
  <img src="https://img.shields.io/badge/status-finalizado-brightgreen" alt="Status: Finalizado">
  <img src="https://img.shields.io/badge/Java-21-blue" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring_Boot-3.3-green" alt="Spring Boot 3.3">
</p>

## 📖 Descripción del Proyecto

**Foro Hub** es una API REST que simula el funcionamiento de un foro de discusión, desarrollada como parte del Challenge de Backend del programa **Oracle Next Education (ONE)**. El proyecto se centra en la gestión de tópicos, permitiendo a los usuarios crear, leer, actualizar y eliminar entradas. La API está protegida y requiere autenticación para la mayoría de sus operaciones.

## ✨ Funcionalidades

-   [x] **Autenticación de Usuarios:** Sistema de login que genera un Token JWT para autorizar las peticiones.
-   [x] **CRUD de Tópicos:**
    -   **Crear** un nuevo tópico.
    -   **Listar** todos los tópicos existentes de forma paginada.
    -   **Mostrar** el detalle de un tópico específico por su ID.
    -   **Actualizar** un tópico existente (título y mensaje).
    -   **Eliminar** un tópico de la base de datos.
-   [x] **Validaciones de Negocio:** Se aplican reglas para evitar tópicos duplicados y asegurar que los datos enviados sean válidos.

## 🛠️ Tecnologías Utilizadas

-   **Java 21**
-   **Spring Boot 3**
-   **Spring Data JPA**
-   **Spring Security**
-   **MySQL (Base de Datos Relacional)**
-   **Flyway Migrations**
-   **Maven (Gestor de Dependencias)**
-   **Lombok**
-   **JSON Web Tokens (JWT)**

## ⚙️ Endpoints de la API

| Verbo  | Endpoint             | Descripción                                | Acceso      |
| :----- | :------------------- | :----------------------------------------- | :---------- |
| `POST` | `/login`             | Autentica a un usuario y devuelve un token JWT. | Público     |
| `POST` | `/topicos`           | Registra un nuevo tópico en la base de datos. | Protegido   |
| `GET`  | `/topicos`           | Devuelve una lista paginada de todos los tópicos. | Protegido   |
| `GET`  | `/topicos/{id}`      | Muestra los detalles de un tópico específico. | Protegido   |
| `PUT`  | `/topicos/{id}`      | Actualiza la información de un tópico existente. | Protegido   |
| `DELETE`| `/topicos/{id}`      | Elimina un tópico de la base de datos.     | Protegido   |

## 🚀 Cómo Ejecutar el Proyecto

Sigue estos pasos para ejecutar el proyecto en tu entorno local.

### **Pre-requisitos**

Asegúrate de tener instalados:
-   **Java JDK 21** o superior.
-   **Maven 4** o superior.
-   **MySQL 8** o superior.

### **Instalación**

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/ryakimovicz/foro-hub.git](https://github.com/ryakimovicz/foro-hub.git)
    cd foro-hub
    ```

2.  **Configura la base de datos:**
    -   Abre tu cliente de MySQL y crea una nueva base de datos llamada `foro_hub`.
    -   Abre el archivo `src/main/resources/application.properties`.
    -   Modifica las siguientes líneas con tus credenciales de MySQL:
        ```properties
        spring.datasource.username=root
        spring.datasource.password=tu-contraseña
        ```

3.  **Ejecuta la aplicación:**
    -   Puedes ejecutar el proyecto directamente desde tu IDE (ej. IntelliJ IDEA).
    -   O puedes usar Maven en la terminal desde la raíz del proyecto:
        ```bash
        mvn spring-boot:run
        ```
    Al iniciar, Flyway creará automáticamente las tablas necesarias en la base de datos.

## 👨‍💻 Autor

**Román Yakimovicz**

-   [LinkedIn](https://www.linkedin.com/in/ryakimovicz/)
-   [GitHub](https://github.com/ryakimovicz/)

---