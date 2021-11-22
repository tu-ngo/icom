# I-Commerce Online Shopping Web Application 

## Architecture

[Architecture](icom_architecture.png)

[Components](components.png)

[DB schema](icommerce_db_schema.png)

## Build

```
./mvnw package
```

## Unit tests
```
./mvnw verify
```

### Data Driven Testing
Spock is a Data Driven Testing framework for Java and Groovy applications.

[Spock framework](https://spockframework.org/spock/docs/1.0/data_driven_testing.html)

## Extended tests
```
./mvnw verify -P extended-test
```

## Modules

* [REST API](restapi/README.md) 
* [DTO](dto/README.md)
* [DB Layer](db-layer/README.md)
* [HTTP Workers](datawarehouse-workers/README.md)
* [WEB UI](web-ui/README.md)

## End-to-End tests
TBD

## Kafka 

```shell
wget https://dlcdn.apache.org/kafka/3.0.0/kafka_2.13-3.0.0.tgz
tar xvzf kafka_2.13-3.0.0.tgz
mv kafka_2.13-3.0.0 kafka
cd kafka

# Start the ZooKeeper service
# Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start the Kafka broker service
bin/kafka-server-start.sh config/server.properties
```

Connecting to kafka on remote host:
```shell
# Change hostname in config/server.properties
listeners=PLAINTEXT://your.host.name:9092
```

### Create topic

Create topic
```shell
bin/kafka-topics.sh --create --topic a-topic-name --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```
Verify your created topic
```shell
bin/kafka-topics.sh --describe --topic a-topic-name --bootstrap-server localhost:9092
```

List all topics
```shell
bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
```


Write message to topic
```shell
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic a-topic-name
```

Read messages in a topic
```shell
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic rubik-hack.input --from-beginning
```


Delete a topic
```shell
bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic rubik-hack.input
```

## MySQL
Steps:
* Install local Mysql 
* Setup MySQL schema
[DDL](./db-layer/mysql_create_schema.sql)


## Docker & binary packaging

```bash
./mvnw clean verify -P boot,docker -DskipTests
```


## TODO
* Build docker image for restapi, workers, web-ui
* Add contract-test, integration test for each module
* Build kubernetes chart for application 
