# Desafio Pamcary

## Como executar

### Instale o docker
É necessário instalar em sua maquina:
- [Docker](https://docs.docker.com/install/linux/docker-ce/ubuntu/) 
- [Docker-Compose](https://docs.docker.com/compose/install/)

No diretorio do projeto **ws-pamcary-client**  execute o comando:
```bash
docker-compose up
```

no arquivo **docker-compose.yaml** estão configurados quatro serviços:
- ws-pamcary-client

### Sobre os serviço
#### ws-pamcary-client
Serviço feito com Java 8 e Spring Boot 
Responsável por direcionar as chamadas para micro serviços especificos de acordo com a requisição recebida através da url
[Repositório do projeto](https://gitlab.com/adaumir-testes/pamcary/ws-pamcary-client.git)

Apos realizar o comando **docker-compose up** para consultar os micro serviços basta acessar a [url](http://localhost:8085/swagger-ui.html)

Caso queira acessar o banco de dados h2 basta acessar a [url](http://localhost:8085/h2)


### Sobre as tecnologias utilizadas

- spring-boot
- java 8
- spring data
- lombok
- graphql
- h2 database
- maven
- docker
- docker-compose
- flyway
- swagger





