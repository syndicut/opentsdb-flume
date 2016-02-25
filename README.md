opentsdb-flume
=======

Module for flume, allows to write incoming events
directly to OpenTSDB. Source module allows to 
emulate OpenTSDB server and accept incoming events.

How To Build:
============

1. Build opentsdb using pom.xml
2. Use install-opentsdb-pom.sh path/where/opentsdb/built, this script installs
opentsdb into local repo directory
3. Build with mvn install

Config example:
============
tsdbflume.sinks.sink1.type = ru.yandex.opentsdb.flume.OpenTSDBSink2
tsdbflume.sinks.sink1.batchSize = 6000
tsdbflume.sinks.sink1.states = 5000
tsdbflume.sinks.sink1.zkquorum = zookeeper-node1.example.com,zookeeper-node2.example.com,zookeeper-node3.example.com
tsdbflume.sinks.sink1.zkpath = /zk_base_name/hbase
tsdbflume.sinks.sink1.channel = channel1
