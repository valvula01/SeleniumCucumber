# este simbolo te permite escribir comentario
Feature: feature to test login functionality

    
    Scenario Outline: Probar Login con credenciales validas
  
    Given user is on login page
    When user enters <usuario> and <contrasena>
    And click on login botton
    Then verify user is on dashboard logout
    
    Examples: 
    |usuario   |    contrasena      |
    |tomsmith  |SuperSecretPassword!|
    
    
    
     Scenario Outline: Probar login con credenciales no validas
  
    Given user is on login page
    When user enters <usuario> and <contrasena>
    And click on login botton
    Then verify invalid credentials

    
    Examples: 
    |usuario   |    contrasena      |
    |test      |test                |
    
    
    Scenario Outline: Probar login solo con contrasena
  
    Given user is on login page
    When user enters <usuario> and <contrasena>
    And click on login botton
    Then verify only with password
    
    Examples: 
    |usuario   |    contrasena      |
    |          |SuperSecretPassword!|
    