A Basic RabbitMq Command Line Application Which sends the msgs in scheduled manner

Steps to execute
1. Before executing the artifacts make sure rabbitmq service is running  (service rabbitmq-server start)
run the following cmds in parallel shells
>> java -jar basics-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,receiver

>> java -jar basics-0.0.1-SNAPSHOT.jar --spring.profiles.active=hello-world,sender
