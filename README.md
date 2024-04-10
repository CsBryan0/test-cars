# DrivePulse

Este é o README do DrivePulse, Teste Técnico da empresa WS Work, que contém informações sobre a estrutura do código, organização e instruções para executar o projeto em sua própria máquina.

## Estrutura do Código

O projeto está estruturado da seguinte maneira:

- **src**: Contém todo o código-fonte do projeto.
  - **controllers**: Controladores responsáveis por lidar com as requisições HTTP.
  - **services**: Serviços que contêm a lógica de negócio da aplicação.
  - **domain**: Modelos que representam os dados do domínio.
  - **repositories**: Repositórios para interagir com o banco de dados.
- **resources**: Contém arquivos de configuração, como arquivos de propriedades.
- **db.migration**: Contém os scripts de migração do banco de dados, usando o Flyway.

## Organização

O código está organizado de forma a facilitar a manutenção e compreensão. Os pacotes estão divididos de acordo com suas responsabilidades funcionais, seguindo o padrão MVC (Model-View-Controller).

## Decisões Tomadas

As principais decisões tomadas durante o desenvolvimento do projeto incluem:

- Utilização do framework Spring Boot devido à sua facilidade de configuração e integração com outras bibliotecas.
- Separação da lógica de negócio nos serviços para garantir uma melhor separação de responsabilidades.
- Utilização do padrão Repository para interação com o banco de dados, facilitando a manutenção e teste das consultas SQL.
- Utilização do Flyway para gerenciar as migrações do banco de dados, garantindo um controle versionado das alterações no esquema do banco.
- Utilização do HSQLDB como banco de dados em memória para desenvolvimento e teste, proporcionando facilidade de configuração e execução de testes unitários.

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias principais:

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework utilizado para desenvolvimento de aplicações Java.
- **Hibernate**: Framework de mapeamento objeto-relacional (ORM) para interação com o banco de dados.
- **Flyway**: Ferramenta para gerenciamento de migrações de banco de dados.
- **HSQLDB**: Banco de dados em memória utilizado para desenvolvimento e teste.

## Como Executar

Para executar o projeto em sua máquina local, siga as instruções abaixo:

1. Certifique-se de ter o JDK e o Maven instalados e configurados corretamente em seu sistema.

2. Clone este repositório em seu computador:

   ```bash
   git clone https://github.com/CsBryan0/test-car.git
   ```
   
3. Navegue até o diretório raiz do projeto:

	 ```bash
	  cd test-cars
	 ```	
4.  Compile o projeto usando o Maven:
   
	  ```bash
	  mvn spring-boot:run
	```
5. Execute a aplicação
     ```bahs
     java -jar target/test-car.jar
    ```

Após seguir essas etapas, a aplicação deve estar em execução em `http://localhost:8080`.
A docuementação da API está sendo feita com o Springdoc-openapi e está disponível em `http://localhost:8080/swagger-ui/index.html` 
