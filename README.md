# Integration REST SOAP Gateway

## Descripción

Integration REST SOAP Gateway es una aplicación Spring Boot que actúa como un gateway de integración entre clientes REST y servicios SOAP. Permite consumir servicios web SOAP y exponerlos a través de APIs REST, facilitando la modernización de arquitecturas heredadas.

## Características

- Convertidor de REST a SOAP
- Configuración centralizada de clientes SOAP
- Soporte para WSDL y servicios web XML
- Inyección de dependencias con Spring
- Construcción con Maven

## Requisitos Previos

- Java 17 o superior
- Maven 3.8.0 o superior
- Git

## Instalación

1. **Clonar el repositorio:**

```bash
git clone https://github.com/zetdev0612/integration-rest-soap-gateway.git
cd integration-rest-soap-gateway
```

2. **Compilar el proyecto:**

```bash
mvn clean install
```

3. **Ejecutar la aplicación:**

```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Estructura del Proyecto

```
integration-rest-soap-gateway/
├── src/
│   ├── main/
│   │   ├── java/com/zetdev/integration/gateway/
│   │   │   ├── controller/          # Controladores REST
│   │   │   ├── service/             # Lógica de negocio
│   │   │   ├── soap/
│   │   │   │   ├── client/          # Clientes SOAP
│   │   │   │   ├── config/          # Configuración SOAP
│   │   │   │   └── endpoint/        # Endpoints SOAP
│   │   │   └── IntegrationRestSoapGatewayApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── wsdl/                # Archivos WSDL
│   └── test/
├── pom.xml
└── README.md
```

## Dependencias Principales

- **Spring Boot 4.0.1**: Framework principal
- **Spring Web Services**: Soporte SOAP
- **Apache HttpClient 4.5.14**: Cliente HTTP
- **JAXB**: Serialización XML
- **Lombok**: Reducción de código boilerplate
- **WSDL4J 1.6.3**: Manejo de WSDL

## Configuración

### Propiedades de Aplicación

Edita `src/main/resources/application.properties`:

```properties
server.port=8080
```

### Configuración SOAP

La configuración del cliente SOAP se encuentra en `SoapClientConfig.java`:

```java
@Configuration
public class SoapClientConfig {
    @Bean
    public WebServiceTemplate webServiceTemplate() {
        // Configuración del cliente SOAP
    }
}
```

## API Endpoints

### Documentación API

Los endpoints disponibles pueden ser consultados directamente en el controlador `AccountController.java`:

```java
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    // Endpoints disponibles
}
```

### Ejemplos de Uso

Para consumir los endpoints disponibles, realiza solicitudes HTTP a:

```
GET  /api/accounts/{id}
POST /api/accounts
PUT  /api/accounts/{id}
DELETE /api/accounts/{id}
```

## Construcción y Pruebas

### Ejecutar pruebas unitarias

```bash
mvn test
```

### Compilar sin ejecutar pruebas

```bash
mvn clean package -DskipTests
```

### Generar JAR ejecutable

```bash
mvn clean package
java -jar target/integration-rest-soap-gateway-0.0.1-SNAPSHOT.jar
```

## Licencia

Este proyecto está disponible bajo licencia no especificada. Consulta el archivo `LICENSE` para más detalles.

## Autor

Desarrollado por zetdev0612
