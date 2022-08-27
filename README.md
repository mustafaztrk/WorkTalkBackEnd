
## Apache Kafka Chat App Backend

![ss](https://user-images.githubusercontent.com/57284119/187041127-d1694bfa-f55c-4a15-bd81-71c8ba35fdc4.png)
![ss2](https://user-images.githubusercontent.com/57284119/187041125-48e2c62b-61e9-43f8-a83c-05317305db4a.png)


## Proje Çalıştırmadan Önce Apache Kafkayı çalışır hale getiriniz


![download](https://user-images.githubusercontent.com/57284119/187041181-7d0d35ae-96ed-4781-b6ea-749a2d561b05.png)



https://kafka.apache.org/

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


