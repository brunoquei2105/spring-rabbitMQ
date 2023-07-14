# Project Springboot-RabbitMq

### This project is for study proposal to learn how use Springboot 3.0.1 version and RabbitMq for asynchronous messaging.
### RabbitMQ is used throughout Docker_Compose:
1)create a docker-compose.yml:

```version: '3.8'
version: '3.8'
services:
  rabbitmq:
    image: rabbitmq:3.9-management
    container_name: rabbitmq
    ports:
      - 5672:5672 # (erlang) communication between the nodes and CLI tool
      - 15672:15672 # communication with the web management API
    environment:
      - RABBITMQ_DEFAULT_USER=admin
      - RABBITMQ_DEFAULT_PASS=admin

    restart: always

  elasticsearch:
    container_name: es-container
    image: docker.elastic.co/elasticsearch/elasticsearch:7.11.0
    environment:
      - xpack.security.enabled=false
      - "discovery.type=single-node"
    networks:
      - elastic-net
    ports:
      - 9200:9200

  kibana:
      container_name: kb-container
      image: docker.elastic.co/kibana/kibana:7.11.0
      environment:
        - ELASTICSEARCH_HOSTS=http://es-container:9200
      networks:
        - elastic-net
      depends_on:
        - elasticsearch
      ports:
        - 5601:5601

networks:
  elastic-net:
      driver: bridge

```
2) Open terminal tab and go to docker-compose.yml directory and run "docker-compose up".