Feature: tarjetas de creditos  


#//define pasos comunes o previos que se ejecutan antes de cada escenario de la característica. 
#aqui vemos un ejemplo con varios escenario esto no va con la automatizacion al menos que configures para ello(esto es para manual)

Background:
Given estas en el navegador
When poner la url y hacer clic en enter

# EL @ para agregar lables @UAT, @SmokeTesting, @critical, @login etc  ojo: solo para identificar casos y su tipo
@UAT
Scenario: registrar url y hacer enter
And  estando dentro de la pagina
Then visualizar logo de bienvenida

@Critical
Scenario: hacer otra accion x

And  estando dentro de la pagina
Then ir sesion ejemplo

Scenario: hacer accion Z

And  presinar buton agrandar
Then agrandarse el objeto ejemplo

#Example es sinonimo de "Scenario" sin parameros Y Examples es para Scenarios Outline que lleven parametros y tablas de datos como ej: abajo
Example: hacer accion A

And  presinar buton agrandar
Then agrandarse el objeto ejemplo

Scenario Outline: registrar2 url y hacer enter

And poner la <url> y hacer clic en enter
And  estando dentro de la pagina
Then visualizar logo de bienvenida

Examples: 
|url|
|https:nflmsnflksnfmjkhj|

