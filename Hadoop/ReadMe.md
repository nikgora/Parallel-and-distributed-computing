For HADOOP\
git clone https://github.com/big-data-europe/docker-hadoop \
E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop>docker-compose up -d\
time="2024-09-19T11:19:52+02:00" level=warning msg="E:\\Parallel-and-distributed-computing\\Hadoop\\docker-hadoop\\docker-compose.yml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"\
[+] Running 28/28\
 ✔ datanode Pulled                                                                                               125.1s\
   ✔ 3ca2ec07878c Pull complete                                                                                  122.5s\
   ✔ 26c2dd45430e Pull complete                                                                                  122.6s\
   ✔ 13c9c87a46cb Pull complete                                                                                  122.7s\
 ✔ historyserver Pulled                                                                                          125.1s\
   ✔ b2dc88cebe05 Pull complete                                                                                  122.5s\
   ✔ 13b908760168 Pull complete                                                                                  122.6s\
   ✔ 0991d53828a1 Pull complete                                                                                  122.8s\
 ✔ resourcemanager Pulled                                                                                        125.1s\
   ✔ 3192219afd04 Pull complete                                                                                   26.6s\
   ✔ 7127a1d8cced Pull complete                                                                                   64.4s\
   ✔ 883a89599900 Pull complete                                                                                   64.4s\
   ✔ 77920a3e82af Pull complete                                                                                   64.5s\
   ✔ 92329e81aec4 Pull complete                                                                                  122.2s\
   ✔ f373218fec59 Pull complete                                                                                  122.3s\
   ✔ aa53513fe997 Pull complete                                                                                  122.3s\
   ✔ 8b1800105b98 Pull complete                                                                                  122.4s\
   ✔ c3a84a3e49c8 Pull complete                                                                                  122.5s\
   ✔ a65640a64a76 Pull complete                                                                                  122.5s\
   ✔ b0d764123f3e Pull complete                                                                                  122.6s\
   ✔ b04394ddb35d Pull complete                                                                                  122.8s\
 ✔ nodemanager1 Pulled                                                                                           125.0s\
   ✔ beaa171f32f6 Pull complete                                                                                  122.6s\
   ✔ 50dda04de8a9 Pull complete                                                                                  122.7s\
 ✔ namenode Pulled                                                                                               125.1s\
   ✔ facffb3a6de3 Pull complete                                                                                  122.5s\
   ✔ c71a6df73788 Pull complete                                                                                  122.7s\
   ✔ 73b8c0ccb707 Pull complete                                                                                  122.8s\
[+] Running 9/9\
 ✔ Network docker-hadoop_default                Created                                                            0.1s\
 ✔ Volume "docker-hadoop_hadoop_namenode"       Created                                                            0.0s\
 ✔ Volume "docker-hadoop_hadoop_datanode"       Created                                                            0.0s\
 ✔ Volume "docker-hadoop_hadoop_historyserver"  Created                                                            0.0s\
 ✔ Container historyserver                      Started                                                            2.4s\
 ✔ Container datanode                           Started                                                            2.5s\
 ✔ Container nodemanager                        Started                                                            2.6s\
 ✔ Container namenode                           Started                                                            2.6s\
 ✔ Container resourcemanager                    Started                                                            2.4s\

E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop>docker exec -it namenode bash\
root@1ac7ab746329:/#\
\
root@1ac7ab746329:/# hdfs dfs -ls / \
Found 1 items\
drwxr-xr-x   - root supergroup          0 2024-09-19 09:22 /rmstate\
root@1ac7ab746329:/# exit\
exit\
\
What's next:\
    Try Docker Debug for seamless, persistent debugging tools in any container or image → docker debug namenode\
    Learn more at https://docs.docker.com/go/debug-cli/ \
\
]E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop>docker cp ../name.txt namenode:/tmp\
Successfully copied 2.05kB to namenode:/tmp\
\
E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop>docker exec -it namenode bash\
root@1ac7ab746329:/# hdfs dfs -mkdir -p /user/root\
root@1ac7ab746329:/# hdfs dfs -ls /user/\
Found 1 items\
drwxr-xr-x   - root supergroup          0 2024-09-19 09:38 /user/root\
root@1ac7ab746329:/# hdfs dfs -mkdir /user/root/input\
root@1ac7ab746329:/# cd /tmp\
root@1ac7ab746329:/tmp# hdfs dfs -put name.txt /user/root/input\
2024-09-19 09:39:54,676 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\
ostTrusted = false\
root@1ac7ab746329:~ # hdfs dfs -cat /user/root/input/name.txt\
2024-09-19 09:44:51,889 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\
Mykola Goraroot@1ac7ab746329:~#\
