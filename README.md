```markdown
# Projeto de Cadastro de Pessoas

Este é um projeto simples de cadastro de pessoas, desenvolvido em Java utilizando JSF, PrimeFaces,
Hibernate (JPA) e EJB. O banco de dados utilizado para testes é o H2, enquanto o banco de dados PostgreSQL
será utilizado na produção.

## Tecnologias Utilizadas

- **Java 8**
- **JSF (JavaServer Faces)**
- **PrimeFaces**
- **Hibernate (JPA)**
- **EJB (Enterprise JavaBeans)**
- **Banco de Dados:**
  - H2 (para testes)
  - PostgreSQL (para produção)

## Pré-requisitos

Antes de rodar o projeto, é necessário:

1. **Instalar o Maven**: Se ainda não tiver o Maven instalado, siga as instruções de instalação no [site oficial](https://maven.apache.org/install.html).
2. **Instalar o PostgreSQL** (para rodar na produção):
   - Você pode instalar o PostgreSQL a partir do [site oficial](https://www.postgresql.org/download/).
   - Certifique-se de ter um banco de dados PostgreSQL rodando para configurar a conexão de produção.

3. **Instalar o VSCode**:
   - Se não tiver o VSCode, baixe e instale a partir do [site oficial](https://code.visualstudio.com/).
   - Instale as extensões recomendadas para Java no VSCode, como o `Java Extension Pack`.

## Instruções de Execução

### 1. Clonar o Repositório

Clone o repositório do projeto em sua máquina local:

```bash
git clone git@github.com:josivantarcio/projeto-cadPessoas.git
```

### 2. Configurar o Banco de Dados

#### Banco de Dados de Teste (H2):
O banco de dados H2 será utilizado para testes locais. O H2 estará configurado automaticamente para você, sem necessidade de instalação adicional.

#### Banco de Dados de Produção (PostgreSQL):
1. **Crie o banco de dados no PostgreSQL**:
   
   Crie um banco de dados com o nome desejado. Exemplo:
   
   ```sql
   CREATE DATABASE cadastro_pessoas;
   ```

2. **Configure o `persistence.xml`**:
   
   Abra o arquivo `src/main/resources/META-INF/persistence.xml` e configure as credenciais do PostgreSQL:
   
   ```xml
   <persistence-unit name="cadastroPU">
       <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
       <properties>
           <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/cadastro_pessoas"/>
           <property name="javax.persistence.jdbc.user" value="seu_usuario"/>
           <property name="javax.persistence.jdbc.password" value="sua_senha"/>
           <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
           <property name="hibernate.hbm2ddl.auto" value="update"/>
           <property name="hibernate.show_sql" value="true"/>
       </properties>
   </persistence-unit>
   ```

### 3. Compilar e Rodar o Projeto

Com o Maven, você pode compilar e rodar o projeto com os seguintes comandos:

1. **Compilar o projeto:**

   No terminal do VSCode, execute o comando abaixo para compilar o projeto:

   ```bash
   mvn clean install
   ```

2. **Rodar o projeto:**

   Execute o seguinte comando para iniciar o servidor integrado (caso esteja usando um servidor como o `Tomcat` ou `Wildfly`):

   ```bash
   mvn clean package jetty:run
   ```

   Ou, se preferir, você pode usar o **Tomcat** para rodar o WAR gerado em `target/`.

### 4. Acessar a Aplicação

A aplicação estará disponível no navegador através do seguinte endereço:

```
http://localhost:8080/cadPessoas
```

### 5. Testar a Aplicação

A aplicação possui operações de **Cadastro**, **Leitura**, **Edição** e **Exclusão** de pessoas. Você pode testar essas operações diretamente pela interface web fornecida pelo JSF e PrimeFaces.

## Testes

Atualmente, os testes precisam de alguns ajustes para garantir a cobertura total e a execução correta. Caso você identifique ou queira contribuir com ajustes nos testes, ficarei feliz em receber suas contribuições através de **issues**.

Para rodar os testes automatizados (caso tenha implementado), utilize o comando:

```bash
mvn test
```

### 6. Docker (Opcional)

Caso queira rodar o projeto utilizando Docker, o Dockerfile e a configuração do Docker podem ser adicionados para automatizar o processo de execução. Para rodar no Docker, siga os passos de configuração que você adicionar ao Dockerfile, como expor as portas e configurar volumes.

---

**Notas Finais:**

- O banco de dados de produção (PostgreSQL) precisa ser configurado corretamente no arquivo `persistence.xml` para funcionar.
- Certifique-se de que o servidor esteja rodando antes de tentar acessar a aplicação.

---

## Contato

Se tiver dúvidas ou sugestões, fique à vontade para entrar em contato.

**Josevan Oliveira**  
📞 +55 88 99668-6161  
✉️ josivantarcio@msn.com  
🔗 [LinkedIn](https://www.linkedin.com/in/josevanoliveira/)
```
