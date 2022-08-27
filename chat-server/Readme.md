
## Apache Kafka Chat App Backend

![ss](https://user-images.githubusercontent.com/57284119/187040762-62fe95d1-bb72-43eb-ab4b-92774e7998f3.png)



## Proje Çalıştırmadan Önce Apache Kafkayı çalışır hale getiriniz

*Zookeeper start
```shell script
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

*Kafka Start
```shell script
kafka-server-start .\config\server.properties
```

*Topic oluşturma*
```
.\bin\windows\kafka-topics.bat --create --topic testtopic --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1

```

*Topic Listeleme*
```shell script
.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
```


