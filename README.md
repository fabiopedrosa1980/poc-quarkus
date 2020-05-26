# Configuração

Projeto exemplo com Quarkus Java
Informações: https://quarkus.io/ .

API de Clientes com as seguintes extensions:
- quarkus-resteasy
- quarkus-resteasy-jsonb
- quarkus-jdbc-postgresql
- quarkus-hibernate-orm-panache
- quarkus-hibernate-validator
- quarkus-smallrye-openapi
- quarkus-oidc
- quarkus-smallrye-opentracing
- quarkus-smallrye-fault-tolerance
- quarkus-smallrye-health

## Configure o Postgres com Docker

Use o seguinte comando do Docker para baixar a imagem:
```
docker pull postgres
```
Executando o banco 
```
docker run --name quarkus -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=teste  -d postgres
```

## Configure o Keycloak com Docker

Use o seguinte comando do Docker para baixar a imagem:
```
docker pull jboss/keycloak
```
Executando o Keycloak 
```
docker run --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak
```
## Acessando o Keycloak

- Link: http://localhost:8080
- Importe o arquivo realm com os usuarios e permissoes qaurkus-realm.json 

## Configure o Jaeger com Docker

Use o seguinte comando do Docker para baixar a imagem:
```
docker pull jaegertracing/all-in-one
```
Executando o Jaeger 
```
docker run -d --name jaeger \
    -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
    -p 5775:5775/udp \
    -p 6831:6831/udp \
    -p 6832:6832/udp \
    -p 5778:5778 \
    -p 16686:16686 \
    -p 14268:14268 \
    -p 14250:14250 \
    -p 9411:9411 \
    jaegertracing/all-in-one
```

## Rodando em dev mode

Use o seguite comando do Maven:
```
./mvnw quarkus:dev
```

## Empacotando e rodando

A aplicação é empacotada usando `./mvnw package`.
Isso produz o executável `poc-quarkus-1.0.0-SNAPSHOT-runner.jar` no diretorio `/target`.

Para rodar a aplicação `java -jar target/poc-quarkus-1.0.0-SNAPSHOT-runner.jar`.

## Criando o executável nativo

Voce cria usando: `./mvnw package -Pnative`.

Ou pelo Docker: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

Rodando a imagem nativa: `./target/poc-quarkus-1.0.0-SNAPSHOT-runner`

Para saber mais como gerar imagens nativas acesse: https://quarkus.io/guides/building-native-image-guide .

## Acessando o Jaeger

- Link: http://localhost:16686
- Escolha o service
- clique em Find Traces

## Acessando o Health

- Link Principal: http://localhost:8081/health
- Ready http://localhost:8081/health/ready
- Live http://localhost:8081/health/live


