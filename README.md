# ssdms - API

- Definir as variável de ambiente no arquivo .env (seguindo o modelo .env.example):


> DB_HOST=ip
>
> DB_USER=user
>
> DB_PASS=password
>

- Configurar as variáveis de ambiente do arquivo .env (linux):

```bash
export $(cat .env | xargs)
```

- Criar o JAR e gerar a imagem da API pelo Maven passando as variáveis de ambiente:

```bash
mvn -DDB_HOST=ip -DDB_USER=user -DDB_PASS=password package -Pdocker
```

- Executar o docker compose:

```bash
docker-compose up -d
```

- Obter todos os produtos

```uri
http://localhost/products
```

- Escalar a API

```bash
docker-compose up -d --scale ssdms-api=2
```

- Acompanhar todos os logs dos containers

```bash
docker-compose logs -t -f
```

- Parar e remover todos os containers

```bash
docker-compose down
```

- Obter a definição OpenAPI em json (OAS3)

```
http://localhost:8080/v3/api-docs
```

- Comando uando o Maven para o flyway reparar última migração:

```bash
mvn flyway:repair -Dflyway.configFiles=src/main/resources/flyway.properties
```
