# Autenticação Java Spring Boot + JWT
 
Projeto de autenticação usando **JWT** (Java + Spring) com **H2 database** em memória para fins de estudo. (inspirado no da Fernanda Kipper)

> **Importante**: Devido ao uso de um banco em memória e configurações simplificadas, algumas práticas de segurança podem não ter sido seguidas à risca.

---

## ✨ Funcionalidades

- **Registro de usuários**: Cria novos usuários e armazena-os no banco H2.
- **Login com JWT**: Gera e valida tokens JWT para acesso a rotas protegidas.
- **Proteção de rotas**: Somente usuários autenticados podem acessar endpoints privados.
- **Banco de dados em memória**: Facilita o teste local, sem necessidade de setup de servidor de BD.

---

## 🚀 Tecnologias

- Java 17 + Spring Boot 3.x  
- H2 Database (banco em memória)  
- Maven (gerenciador de dependências)  
- JWT (para autenticação)

---

## 📦 Pré-requisitos

- Java 17 ou superior  
- Maven instalado localmente (ou outra forma de build Java)

---

## 🔧 Configuração e Execução

**Clonar o repositório:**

```bash
git clone https://github.com/nicolaszprado/auth-project-nicolasz.git
```

**Entrar na pasta do projeto:**

```bash
cd auth-project-nicolasz
```

**Executar o projeto (via Maven):**

```bash
mvn spring-boot:run
```

**Ou gerar o `jar` e rodar:**

```bash
mvn clean install
java -jar target/*.jar
```

**Acessar a aplicação:**

Por padrão, a API estará disponível em:

```bash
http://localhost:8080
```

---

## 🔑 Endpoints Principais

> Observação: Ajuste nomes e rotas de acordo com o seu código real.

### `POST /auth/register`

Registra um novo usuário.  
Exemplo de body:

```json
{
  "username": "exemplo",
  "email": "teste@gmail.com",
  "password": "senha"
}
```

---

### `POST /auth/login`

Retorna token JWT se usuário e senha estiverem corretos.  
Exemplo de body:

```json
{
  "username": "exemplo",
  "password": "senha"
}
```

---

### `GET /users`

Lista todos os usuários cadastrados (rota protegida por token JWT).  
Enviar no header:

```http
Authorization: Bearer <seu_token>
```
---

## ⚙️ Configurações Extras

### Banco de Dados

O projeto utiliza um banco em memória (H2). Assim que a aplicação é finalizada, os dados se perdem.  
Se quiser **persistir** dados, considere configurar o H2 em modo file ou trocar para outro DB (PostgreSQL, MySQL etc.).

### Variáveis de Ambiente

Caso precise personalizar a porta, secret key do JWT etc., você pode configurar no `application.properties` ou usar variáveis de ambiente e injeção via `application.yml`.

---

## 🗒️ Observações Importantes

- **Segurança**: Por ser um projeto de estudos, a segurança é **simplificada**. Em um ambiente real, utilize práticas adicionais (criptografia mais robusta de senhas, HTTPS, proteção contra XSS, CSRF etc.).
- **Token JWT**: Verifique sempre se o token não expirou antes de acessar rotas privadas.

---


## 📄 Licença

Este projeto está sob a licença **MIT**.  
Sinta-se à vontade para clonar, estudar e adaptar conforme desejar.

---

## Autor

Inspiração: https://www.youtube.com/watch?v=tJCyNV1G0P4 (https://github.com/Fernanda-Kipper)

Feito com ❤️ por [nicolaszprado](https://github.com/nicolaszprado).
