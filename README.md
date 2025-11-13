# Respuestas Práctica 6 – Spring Boot y Neon

## 1. ¿Qué es Spring Boot y por qué simplifica el desarrollo web con Java?

Spring Boot es un framework basado en Spring que permite crear aplicaciones Java de manera **rápida y con configuración mínima**.Simplifica el desarrollo porque:

- Proporciona **configuración automática** (auto-configuration) para muchas dependencias y servicios.
- Incluye un **servidor web embebido** (como Tomcat o Jetty), evitando la necesidad de instalar uno externo.
- Facilita la creación de **endpoints REST**, manejo de bases de datos y seguridad con muy poco código.
- Permite empaquetar la aplicación como un **archivo ejecutable (jar)** listo para producción.

En resumen, Spring Boot reduce la complejidad de Spring tradicional y acelera el desarrollo de aplicaciones web.

---

## 2. ¿Qué diferencia hay entre `@RestController` y `@Controller`?

- `@Controller`: Se utiliza para **controladores que devuelven vistas HTML** (páginas web).
  Ejemplo: junto con `Thymeleaf` para renderizar templates.
- `@RestController`: Es un **controlador especializado para APIs REST**, devuelve directamente **JSON o XML** en las respuestas HTTP.
  Internamente combina `@Controller` + `@ResponseBody`, por lo que no necesitas anotarlo en cada método.

**Resumen:**
`@RestController` → APIs REST, `@Controller` → páginas web.

---

## 3. ¿Qué es JPA y cómo ayuda a mapear objetos en una base de datos relacional?

JPA (Java Persistence API) es una **especificación de Java para persistencia de datos** que permite mapear **objetos Java (entidades)** a **tablas de bases de datos relacionales**.

Beneficios:

- Evita escribir consultas SQL manuales para operaciones básicas (CRUD).
- Permite trabajar con **objetos en Java** en lugar de filas y columnas.
- Se integra con frameworks como **Hibernate** para la implementación real del mapeo.
- Facilita la gestión de relaciones entre entidades (`OneToMany`, `ManyToOne`, etc.).

---

## 4. ¿Por qué Neon se considera una base “serverless”?

Neon es considerado “serverless” porque:

- No necesitas **configurar, aprovisionar o mantener servidores** manualmente.
- Escala automáticamente según la carga de trabajo.
- Pagas únicamente por el **uso real** de la base de datos, no por servidores reservados.
- Gestiona backups, seguridad y actualizaciones de forma automática.

---

## 5. ¿Cómo funciona el CORS y por qué fue necesario configurarlo?

CORS (Cross-Origin Resource Sharing) es un mecanismo de seguridad del navegador que **impide que un frontend en un dominio diferente acceda a un backend sin permiso**.

- Funciona agregando **cabeceras HTTP** que indican qué orígenes pueden hacer solicitudes.
- Fue necesario configurarlo porque, en desarrollo, el frontend (por ejemplo `http://localhost:5173`) y el backend (`http://localhost:8080`) están en **dominios diferentes**, y sin CORS el navegador bloquea las solicitudes.

**Resumen:** CORS permite que tu frontend y backend se comuniquen de manera segura cuando no están en el mismo dominio.

---
