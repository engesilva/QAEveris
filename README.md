# QAEveris

**Resolução dos Exercícios Técnicos**

Automatização utilizando Selenium Web Driver, JUnit, Maven, Cucumber e RestAssured)

### Exercícios

1. Escrever um cenário de testes que valida os valores no carrinho de um produto no website: My Store (automationpractice.com) (Se a automação for feito utilizando a
linguagem gherkin, não é necessário fazer esse exercício)

2. Automatizar um fluxo que valida o valor total da compra na tela 01.Summary

3. Automatizar um get no endpoint https://httpbin.org/get e validar o atributo: url da resposta


Requeriments:
- Eclipse: (https://www.eclipse.org/downloads/) ou IntelliJ IDEA (https://www.jetbrains.com/pt-br/idea/download/) 
- Navegador [Chrome](https://www.google.com/intl/pt-BR_ALL/chrome/)

Observação:
 - Os exercicíos 1 e 2 foram desenvolvidos no mesmo projeto.

Exercício 1 e 2 - pasta "CaseAutomation"

Estrutura
src/main/java/
 - `Generics/` - Métodos genericos.
 - `Pages/` - Componentes/telas/objetos mapeados do teste.

 src/test/java/
 - `Fearure/` - Features do cucumber (Exercício 1)
 - `Runs/` - Arquivos para execuções de teste.
 - `Step/` - Steps para da feature do cucumber.

Execução
 - JUnit: Arquivo RunUnit.java
 - Cucumber: Arquivo RunCucumber

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Exercício 3 - pasta "automacaoAPI"

Estrutura
 - src\test\java\br\com\everis\automacaoAPI- contém o arquivo TestQaEVERIS.java que possui o código fonte


 
