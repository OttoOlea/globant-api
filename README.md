# Globant-Api
    API created with SpringBoot and Maven technologies

## Features
    - Use the marvel-lib lib to consult external api-rest services
    - Record each query of Api Rest services in H2 Database
    - It exposes the following rest services:
        - /v1/globant-api
            - GET /status
            - GET /characters
            - GET /characters/{characterId}
            - GET /history

## Installation

### Compile the project
```bash
mvn clean package
```

### Install and run project
```bash
mvn clean install spring-boot:run
```

## License
[Globant](https://www.globant.com)
