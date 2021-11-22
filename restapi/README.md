# I-Commerce online shopping REST API

### OpenAPI specification
The REST API is specified using OAS3 files located in [openapi directory](src/main/resources/openapi).<br/>

[OpenAPI definition](http://localhost:8080/api-docs.yaml)
[Swagger UI](http://localhost:8080/swagger-ui.html)


## Running REST API on the local computer

Modify `~/.spring-boot-devtools.properties`:
```properties
instance=your-instance
instance-fqdn=${instance}.na.intgdc.com

gdc.c4.hostname=${instance-fqdn}
gdc.gcf.host=${instance-fqdn}
eureka.client.serviceUrl.defaultZone=http://${instance-fqdn}:8761/eureka/

gdc.logging.appender=CONSOLE
```

### From IDE

Run main method in REST API application `com.nab.icommerce.RestApiApplication`.

### From console

Install multi-module dependencies to local repository:
```
./mvnw clean install -DskipTests -am -pl datawarehouse-restapi
```

Run Spring Boot on `localhost` port 8203:
```bash
./mvnw spring-boot:run -pl datawarehouse-restapi
```

## Testing

### Isolated tests
Run from `datawarehouse-restapi` folder
```
USER_UID=$(id -u) USER_GID=$(id -g) docker-compose -f docker-compose-isolated.yaml up  --abort-on-container-exit
```

### Testing application has been deployed successfully


```
curl -X POST -d '{ "brand": {  "code": "BMW", "name": "BMW", "description": "BMW auto brand" } }' \
 -H 'Content-Type: application/json' http://localhost:8080/icom/brands/
 
 
curl -H 'Content-Type: application/json' http://localhost:8080/icom/brands/

```

```
curl -H 'Accept: application/json' -H 'X-GDC-PUBLIC-USER-ID: 876ec68f5630b38de65852ed5d6236ff' \
    http://localhost:8203/gdc/datawarehouse | jq .
```

### Listing instances

```
curl -H 'Accept: application/json' -H 'X-GDC-PUBLIC-USER-ID: 876ec68f5630b38de65852ed5d6236ff' \
    http://localhost:8203/gdc/datawarehouse/instances | jq .
```

### Creating new instance

```
curl -H 'Accept: application/json' -H 'Content-Type: application/json' \
    -H 'X-GDC-PUBLIC-USER-ID: 876ec68f5630b38de65852ed5d6236ff' \
    http://localhost:8203/gdc/datawarehouse/instances \
    -d '{"instance": {"title": "New I-Commerce online shopping", "authorizationToken": "vertica", "description": "I-Commerce online shopping Description", "environment": "TESTING"}}' \
    | jq .
```

### Getting task status

```
curl -H 'Accept: application/json' -H 'X-GDC-PUBLIC-USER-ID: 876ec68f5630b38de65852ed5d6236ff' \
    http://localhost:8203/gdc/datawarehouse/executions/229fe5d5db56587b5ea67d842215ee6907bdd8448623258700000025 | jq .
```
