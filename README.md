# Microservices Project with Spring Cloud

Este proyecto implementa una arquitectura de microservicios utilizando Spring Cloud y Java 21.

## Requisitos Previos

- Java 21
- Maven 3.9+
- PostgreSQL 15+
- Git

## Estructura del Proyecto

```
microservices/
├── api-gateway/
├── config-server/
├── eureka-server/
├── order-service/
└── product-service/
```

## Configuración del Entorno

1. **Bases de Datos**
```sql
CREATE DATABASE productdb;
CREATE DATABASE orderdb;
```

2. **Variables de Entorno**
```bash
export POSTGRES_USERNAME=postgres
export POSTGRES_PASSWORD=password
```

## Instalación y Ejecución

1. **Clonar el Repositorio**
```bash
git clone <repository-url>
cd microservices
```

2. **Compilar los Proyectos**
```bash
# Compilar todos los servicios
./mvnw clean install
```

3. **Orden de Inicio**
```bash
# 1. Iniciar Eureka Server
cd eureka-server
./mvnw spring-boot:run

# 2. Iniciar Config Server
cd ../config-server
./mvnw spring-boot:run

# 3. Iniciar API Gateway
cd ../api-gateway
./mvnw spring-boot:run

# 4. Iniciar Product Service
cd ../product-service
./mvnw spring-boot:run

# 5. Iniciar Order Service
cd ../order-service
./mvnw spring-boot:run
```

## Puertos por Defecto

- Eureka Server: 8761
- Config Server: 8888
- API Gateway: 8080
- Product Service: 8081
- Order Service: 8082

## Endpoints

### Product Service
- POST `/api/products` - Crear producto
- GET `/api/products` - Listar productos
- GET `/api/products/{id}` - Obtener producto
- DELETE `/api/products/{id}` - Eliminar producto

### Order Service
- POST `/api/orders` - Crear orden
- GET `/api/orders` - Listar órdenes
- GET `/api/orders/{id}` - Obtener orden
- PUT `/api/orders/{id}/status` - Actualizar estado

## Configuración de Seguridad

### Eureka Server
- Usuario: eureka
- Contraseña: password

### Config Server
- Usuario: configuser
- Contraseña: configpassword

## Monitoreo

Todos los servicios exponen endpoints de Actuator en `/actuator`:
- `/health` - Estado del servicio
- `/metrics` - Métricas del servicio
- `/info` - Información del servicio

## Docker (Opcional)

```bash
# Construir imágenes
docker-compose build

# Iniciar servicios
docker-compose up -d
```

## Pruebas

```bash
# Ejecutar todas las pruebas
./mvnw test

# Pruebas específicas de un servicio
cd product-service
./mvnw test
```

## Documentación Adicional

- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Netflix Eureka](https://github.com/Netflix/eureka)

## Contribuir

1. Fork del repositorio
2. Crear rama feature (`git checkout -b feature/nueva-caracteristica`)
3. Commit de cambios (`git commit -am 'Añadir nueva característica'`)
4. Push a la rama (`git push origin feature/nueva-caracteristica`)
5. Crear Pull Request

## Solución de Problemas

### Problemas Comunes

1. **Servicios no se registran en Eureka**
   - Verificar que Eureka Server esté corriendo
   - Comprobar configuración de eureka.client.serviceUrl.defaultZone

2. **Errores de Base de Datos**
   - Verificar credenciales en application.yml
   - Comprobar que PostgreSQL esté corriendo
   - Verificar que las bases de datos existan

3. **Problemas de Conexión**
   - Verificar puertos en uso
   - Comprobar configuración de CORS en Gateway
   - Verificar configuración de red

## Licencia

MIT
