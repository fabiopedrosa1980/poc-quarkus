# Configuração

Projeto exemplo com Quarkus Java
Informações: https://quarkus.io/ .

## Rodando em dev mode

Use o seguite comando do Maven:
```
./mvnw quarkus:dev
```

## Empacotando e rodando

A plicação é empacotada usando `./mvnw package`.
Isso produz o executável `poc-quarkus-1.0.0-SNAPSHOT-runner.jar` no diretorio `/target`.

Para rodar a aplicação `java -jar target/poc-quarkus-1.0.0-SNAPSHOT-runner.jar`.

## Criando o executável nativo

Voce cria usando: `./mvnw package -Pnative`.

Or pelo Docker: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

Rodando a imagem nativa: `./target/poc-quarkus-1.0.0-SNAPSHOT-runner`

Para saber mais como gerar imagens nativas acesse: https://quarkus.io/guides/building-native-image-guide .
