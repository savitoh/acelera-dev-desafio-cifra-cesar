# CODENATION - Acelera Dev Desafio Cifra de César

Desafio Cifra de Cesar realizado pelo programa Acelera Dev de Java da Codenation.

## Pré Requisitos

- [JDK 11] ou mais recente.
- [Maven 3.5] ou mais recente.

## Tecnologias Utilizadas

- [Java 11]

## Iniciando o projeto

Clone o projeto com o comando:

```
git clone https://github.com/savitoh/acelera-dev-desafio-cifra-cesar.git
```

Acesse a pasta raiz:

```
cd acelera-dev-desafio-cifra-cesar
```

### Rodando Localmente

Acesse a pasta root do projeto, onde o arquivo pom.xml estar localizado:

1. Execute o comando abaixo para empacotar a APP em um .jar:

```
   mvn clean package  - (Empacota a APP em um .jar)
```

2. Rode o .jar com o comando abaixo. <b>Atenção para propriedade<b>: user-codenation-token. Troque por um valor válido
 
```
   java -jar -Duser-codenation-token={tokenValue} target/acelera-dev-desafio-criptografia-julio-cesar-1.0-SNAPSHOT.jar
```

### Rodando os testes

Acesse a pasta onde o arquivo pom.xml estar localizado:

1. Execute o comando maven abaixo:

```
   mvn test
```

[Java 11]: <https://www.oracle.com/java/technologies/javase-jdk11-downloads.html>
[JDK 11]: <https://www.oracle.com/java/technologies/javase-downloads.html>
[Maven 3.5]: <https://maven.apache.org/download.cgi>
