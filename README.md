# 🚀 Portfolio Backend - Spring Boot Architecture

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/technologies/downloads/)
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Deployment-Docker-blue)](https://www.docker.com/)

Este repositorio contiene la lógica de negocio y la API REST para mi ecosistema de Portfolio Profesional. Es una solución robusta diseñada bajo principios de arquitectura limpia y escalabilidad.

## 📋 Tabla de Contenidos
- [Propósito del Proyecto](#proposito-del-proyecto)
- [Stack Tecnológico](#stack-tecnologico)
- [Arquitectura y Buenas Prácticas](#arquitectura-y-buenas-practicas)
- [Configuración de Infraestructura](#configuracion-de-infraestructura)
- [Endpoints de la API](#endpoints-de-la-api)
- [Guía de Ejecución Local](#guia-de-ejecucion-local)

---

## 🎯 Propósito del Proyecto
El objetivo principal de este backend es gestionar la interacción con usuarios externos a través de mi portfolio. Resuelve la persistencia de mensajes de contacto, validación de datos en tiempo real y la exposición segura de servicios para clientes Frontend (Cloudflare Pages).

## 🛠️ Stack Tecnológico
- **Lenguaje:** Java 21 (LTS).
- **Framework:** Spring Boot 3.4.3.
- **Persistencia:** Spring Data JPA con Hibernate.
- **Base de Datos:** PostgreSQL (Neon Serverless para producción / Docker para local).
- **Documentación:** Swagger / OpenAPI 3.
- **Gestor de Dependencias:** Gradle (Kotlin DSL).

## 🏛️ Arquitectura y Buenas Prácticas
Se implementó una estructura de **Capas (N-Tier Architecture)** para asegurar la separación de responsabilidades:

* **Controller Layer:** Manejo de peticiones HTTP y mapeo de endpoints.
* **Service Layer:** Lógica de negocio pura, desacoplada de la infraestructura.
* **Persistence Layer:** Repositorios abstractos para el manejo de datos.
* **DTO Pattern:** Uso de Data Transfer Objects para evitar la exposición directa de entidades de base de datos.
* **Validación de Datos:** Uso de `Spring Boot Starter Validation` para asegurar la integridad de los datos antes de la persistencia.
* **CORS Configuration:** Implementación de políticas de intercambio de recursos para permitir la comunicación segura con el frontend.

## ⚙️ Configuración de Infraestructura
El backend está diseñado para ser **Cloud-Native**.

### Dockerización
Se incluyó un `Dockerfile` optimizado utilizando una imagen base de **Eclipse Temurin 21 (Alpine Linux)**, lo que reduce el peso de la imagen y mejora los tiempos de despliegue en servicios como Render.

### Variables de Entorno
Para cumplir con las 12-factor apps, las credenciales sensibles no están "hardcodeadas". El sistema inyecta dinámicamente:
- `DATABASE_URL`: Endpoint de conexión JDBC.
- `DATABASE_USER`: Usuario autenticado.
- `DATABASE_PASSWORD`: Credencial de acceso.

## 🛰️ Endpoints de la API
| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `POST` | `/api/v1/contactos` | Recibe y valida un nuevo mensaje de contacto. |
| `GET` | `/swagger-ui/index.html` | Documentación interactiva de la API. |

## 🚀 Guía de Ejecución Local

### Prerrequisitos
- Docker & Docker Compose.
- JDK 21.

### Pasos
1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/Alberto-Zompantzi/portfolio-backend.git](https://github.com/Alberto-Zompantzi/portfolio-backend.git)