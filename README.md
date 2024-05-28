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

## Important
When marvel-lib was added as a dependency in globant-api it was showing an import error, for some reason the IDEs did not detect the imports of the new dependency

![Error the import of the dependency](https://github.com/OttoOlea/globant-front-ng/blob/main/src/assets/error_compile_back.png)

![Maven dependency in the Globant-Api](https://github.com/OttoOlea/globant-front-ng/blob/main/src/assets/maven_dependencie_back.png)

## License
[Globant](https://www.globant.com)


