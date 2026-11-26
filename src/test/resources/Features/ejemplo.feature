#usamos este simbolo para poner comentario
Feature: Nombre de la funcionalidad a probar ej: funcionalidad Login 

#Los arroba@ en gherkin son para poner lables de @UAT, @SmokeTesting, @critical, @login etcc
Scenario: registrar url y hacer enter

Given estas en el navegador
When poner la url y hacer clic en enter
And  estando dentro de la pagina
Then visualizar logo de bienvenida

# otro caso donde ponemos o enviamos parametros

@UAT
Scenario Outline:
 registrar2 url y hacer enter

Given estas en el navegador
When poner la <url> y hacer clic en enter
And  estando dentro de la pagina
Then visualizar logo de bienvenida

Examples:

|url|
| https:nflmsnflksnfmjkhj|
