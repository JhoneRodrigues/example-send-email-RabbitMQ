# Send email

### O que é?
Após uma requisição de Post para cadastrar determinado cliente, o microservice User armazenará os dados, produzirá uma mensagem de email e enviará para o Broker (RabbitMQ) de forma assíncrona, que consequentemente, estará esperando essa mensagem para consumi-las e repassar para o microsservice email. Respectivamente, após ouvir a mensagem, o email de "Cadastro concluído" será enviado ao usuário e banco de dados.

### Tecnologias utilizadas
<ul>
  <li>Java</li>
  <li>Spring Boot</li>
  <li>JPA / Hibernate</li>
  <li>RabbitMQ</li>
  <li>Maven</li>
  <li>PostgreSQL</li>
  <li>Lombok</li>
</ul>

## <b> Vamos nos conectar..!</b><img src="https://github.com/0xAbdulKhalid/0xAbdulKhalid/raw/main/assets/mdImages/handshake.gif" width ="80">
<a href="https://www.linkedin.com/in/jhonerodrigues/" target="_blank">
<img src="https://img.shields.io/badge/linkedin:  jhone rodrigues-%2300acee.svg?color=405DE6&style=for-the-badge&logo=linkedin&logoColor=white" alt=linkedin style="margin-bottom: 5px;"/>
</a>
