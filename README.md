[![CI](https://github.com/js-rom/test-app-backend/actions/workflows/ci.yml/badge.svg)](https://github.com/js-rom/test-app-backend/actions/workflows/ci.yml)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=js-rom_test-app-backend&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=js-rom_test-app-backend)
[![CD](https://github.com/js-rom/test-app-backend/actions/workflows/cd-docker-render.yml/badge.svg)](https://github.com/js-rom/test-app-backend/actions/workflows/cd-docker-render.yml)
[![Render](https://img.shields.io/website?url=https%3A%2F%2Ftest-app-backend-owlc.onrender.com)](https://test-app-backend-owlc.onrender.com)

# TestAppFrontend

Esta aplicacion es el Front-end del proyecto final para el ciclo superior de Desarrollo de Aplicaciones Web.

💡 El proyecto consiste en desarrollar una aplicación web para una institución educativa. Esta herramienta permitirá:

- Generar cuestionarios tipo test.
- Ofrecer a los alumnos acceso online a las pruebas.
- Corregir automáticamente los cuestionarios realizados.

🔐 La aplicación contará con dos perfiles de usuario:

📘 Perfil de Administración:
- Gestionar cuestionarios
- Gestionar cursos
- Gestionar alumnos
- Asociar cuestionarios a cursos
- Asociar alumnos a cursos

🎓 Perfil de Alumno:
- Acceder a sus cursos
- Realizar los cuestionarios disponibles
- Consultar sus calificaciones
- Revisar cuestionarios ya realizados

## Tecnologías necesarias
`Java` `Spring` `Maven` `git` `GitHub` `GitHub Actions` `Sonarcloud` `GitHub packages` `Docker` `Render`

##  ▶️ Aplicación
https://test-app-frontend-o1vb.onrender.com

##  ⚙️ Instalación del proyecto
Clonar repositorios, mediante consola:

test-app-backend

```sh

> cd <folder path>
> git clone https://github.com/js-rom/test-app-backend.git
> cd test-app-backend
test-app-backend> docker compose up --build -d
http://localhost:8081/swagger-ui.html
http://localhost:8081/actuator/info

```