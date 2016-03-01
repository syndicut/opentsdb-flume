opentsdb-flume
=======

Module for flume, allows to write incoming events
directly to [OpenTSDB](http://opentsdb.net)

How To Build:
============

1. Build opentsdb using pom.xml
2. Use install-opentsdb-pom.sh path/where/opentsdb/built, this script installs
opentsdb into local repo directory
3. Build with mvn install

Config example:
============
```ini
tsdbflume.sources = source1
tsdbflume.sinks = sink1 sink2 sink3 sink4 sink5 sink6 sink7 sink8.
tsdbflume.sinkgroups.g1.sinks = sink1 sink2 sink3 sink4 sink5 sink6 sink7 sink8 sink9.
tsdbflume.sinkgroups.g1.processor.type = load_balance
tsdbflume.channels = channel1

# Describe/configure source1
tsdbflume.sources.source1.type = ru.yandex.opentsdb.flume.OpenTSDBSource
tsdbflume.sources.source1.port = 4444

tsdbflume.sources.source1.batchSize = 2000
tsdbflume.sources.source1.channels = channel1

tsdbflume.channels.channel1.type = FILE
tsdbflume.channels.channel1.checkpointDir = /srv/hd1/opentsdb/flume/checkpoint
tsdbflume.channels.channel1.dataDirs = /srv/hd1//opentsdb/flume/data,/srv/hd2//opentsdb/flume/data
tsdbflume.channels.channel1.transactionCapacity = 200000
tsdbflume.channels.channel1.checkpointInterval = 2000
tsdbflume.channels.channel1.maxFileSize = 2146435071
tsdbflume.channels.channel1.capacity = 1000000

tsdbflume.sinks.sink1.type = ru.yandex.opentsdb.flume.OpenTSDBSink2
tsdbflume.sinks.sink1.batchSize = 6000
tsdbflume.sinks.sink1.states = 5000
tsdbflume.sinks.sink1.zkquorum = zookeeper-node1.example.com,zookeeper-node2.example.com,zookeeper-node3.example.com
tsdbflume.sinks.sink1.zkpath = /zk_base_name/hbase
tsdbflume.sinks.sink1.channel = channel1

```

test it:

```bash
for i in {1..1000};
do
    echo "put sys.cpu.user2233 144764916${i} 50.5 host=webserver01 cpu=0" | nc -vv localhost 4444
done
```