# Project Springboot-RabbitMq

### This project is for study proposal to learn how use Springboot 3.0.1 version and RabbitMq for asynchronous messaging.
### RabbitMQ is used throughout Docker_Compose:
1)create a docker-compose.yml:

```version: '3.8'
services:
rabbitmq:
image: rabbitmq:3.9-management
container_name: rabbitmq
ports:
- 5672:5672 # (erlang) communication between the nodes and CLI tool
- 15672:15672 # communication with the web management API
environment:
- RABBITMQ_DEFAULT_USER={userName}
- RABBITMQ_DEFAULT_PASS={passwd}

    restart: always
```
2) Open terminal tab and go to docker-compose.yml directory and run "docker-compose up".