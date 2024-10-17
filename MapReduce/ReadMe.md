# MapReduce Task: Count "Attribute, Case, and Vote Lines" in `anonymous-msweb.data`

## Task Description

Write a MapReduce job that will calculate the number of "Attribute, Case, and Vote Lines" for the dataset `anonymous-msweb.data`.

[Download the dataset here.](https://archive.ics.uci.edu/dataset/4/anonymous+microsoft+web+data)

## Solution Steps

Follow the steps below to set up the Hadoop environment with Docker, upload the dataset, and execute the MapReduce job.

### Step 1: Navigate to the Project Directory

```bash
cd "E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop"
```

### Step 2: Start the Docker Containers

Start the Hadoop cluster using Docker Compose:

```bash
docker-compose up -d
```

### Step 3: Create Directory for Files in the Namenode Container

Run the following command to create a directory for storing data and the MapReduce job inside the Namenode container:

```bash
docker exec namenode mkdir -p /home/hadoop
```

### Step 4: Copy the Dataset to the Namenode Container

Copy the dataset file anonymous-msweb.data from your local machine to the Namenode container:

```bash
docker cp "E:\Parallel-and-distributed-computing\MapReduce\anonymous-msweb.data" namenode:/home/hadoop/
```

### Step 5: Copy the MapReduce Job JAR File

Copy the MapReduce job JAR file MapReduce-1.0-SNAPSHOT.jar to the Namenode container:

```bash
docker cp "E:\Parallel-and-distributed-computing\MapReduce\target\MapReduce-1.0-SNAPSHOT.jar" namenode:/home/hadoop/
```

### Step 6: Access the Namenode Container

Log into the Namenode container to run the following HDFS commands:
```bash
docker exec -it namenode /bin/bash
```

### Step 7: Leave Safe Mode

Before interacting with HDFS, leave safe mode (HDFS may automatically enter safe mode on startup):

```bash
hdfs dfsadmin -safemode leave
```

### Step 8: Clean the HDFS Input Directory (if it exists)

Delete the existing input directory in HDFS (if any) to avoid conflicts:

```bash
hdfs dfs -rm -r /input
```


### Step 9: Create a New Input Directory in HDFS

Create a new directory in HDFS to store the dataset:
```bash
hdfs dfs -mkdir /input
```


### Step 10: Upload the Dataset to HDFS

Upload the dataset to the newly created input directory in HDFS:
```bash
hdfs dfs -put /home/hadoop/anonymous-msweb.data /input/
```

### Step 11: Clean the HDFS Output Directory (if it exists)

Remove any existing output directory in HDFS to avoid conflicts with the results:
```bash
hdfs dfs -rm -r /output/result
```


### Step 12: Run the MapReduce Job

Run the MapReduce job using the uploaded dataset:
```bash
yarn jar /home/hadoop/MapReduce-1.0-SNAPSHOT.jar Main /input/anonymous-msweb.data /output/result
```

### Step 13: View the Results

Once the job completes, view the results by reading the output file in HDFS:
```bash
hdfs dfs -cat /output/result/part-r-00000
```




### Program Result

Windows PowerShell
Copyright (C) Microsoft Corporation. All rights reserved.

Install the latest PowerShell for new features and improvements! https://aka.ms/PSWindows

PS E:\Parallel-and-distributed-computing\MapReduce> cd "E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop"\
PS E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop> docker-compose up -d\
time="2024-10-17T11:12:38+02:00" level=warning msg="E:\\Parallel-and-distributed-computing\\Hadoop\\docker-hadoop\\docker-compose.yml: the attribute `version` is obsolete, it will be ignored, please remove it to avoid potential confusion"\
[+] Running 5/5\
✔ Container nodemanager      Started                                                                                                                                                                                                                                                                          1.0s\
✔ Container datanode         Started                                                                                                                                                                                                                                                                          0.6s\
✔ Container historyserver    Started                                                                                                                                                                                                                                                                          0.8s\
✔ Container resourcemanager  Started                                                                                                                                                                                                                                                                          0.6s\
✔ Container namenode         Started                                                                                                                                                                                                                                                                          0.9s\
PS E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop> docker exec namenode mkdir -p /home/hadoop\
PS E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop> docker cp "E:\Parallel-and-distributed-computing\MapReduce\anonymous-msweb.data" namenode:/home/hadoop/\
Successfully copied 1.42MB to namenode:/home/hadoop/\
PS E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop> docker cp "E:\Parallel-and-distributed-computing\MapReduce\target\MapReduce-1.0-SNAPSHOT.jar" namenode:/home/hadoop/\
Successfully copied 6.14kB to namenode:/home/hadoop/\
PS E:\Parallel-and-distributed-computing\Hadoop\docker-hadoop> docker exec -it namenode /bin/bash\
root@1ac7ab746329:/# hdfs dfsadmin -safemode leave\
Safe mode is OFF\
root@1ac7ab746329:/# hdfs dfs -rm -r /input

root@1ac7ab746329:/# hdfs dfs -mkdir /input
 
root@1ac7ab746329:/# hdfs dfs -put /home/hadoop/anonymous-msweb.data /input/\
2024-10-17 09:23:52,819 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\

root@1ac7ab746329:/# yarn jar /home/hadoop/MapReduce-1.0-SNAPSHOT.jar Main /input/anonymous-msweb.data /output/result\
2024-10-17 09:48:23,545 INFO client.RMProxy: Connecting to ResourceManager at resourcemanager/172.19.0.3:8032\
2024-10-17 09:48:23,758 INFO client.AHSProxy: Connecting to Application History server at historyserver/172.19.0.4:10200\
2024-10-17 09:48:23,978 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.\
2024-10-17 09:48:23,996 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /tmp/hadoop-yarn/staging/root/.staging/job_1729156404657_0001\
2024-10-17 09:48:24,104 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\
2024-10-17 09:48:24,205 INFO input.FileInputFormat: Total input files to process : 1\
2024-10-17 09:48:24,249 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\
2024-10-17 09:48:24,676 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\
2024-10-17 09:48:25,087 INFO mapreduce.JobSubmitter: number of splits:1\
2024-10-17 09:48:25,240 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\
2024-10-17 09:48:25,664 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1729156404657_0001\
2024-10-17 09:48:25,664 INFO mapreduce.JobSubmitter: Executing with tokens: []\
2024-10-17 09:48:25,830 INFO conf.Configuration: resource-types.xml not found\
2024-10-17 09:48:25,830 INFO resource.ResourceUtils: Unable to find 'resource-types.xml'.\
2024-10-17 09:48:26,359 INFO impl.YarnClientImpl: Submitted application application_1729156404657_0001\
2024-10-17 09:48:26,397 INFO mapreduce.Job: The url to track the job: http://resourcemanager:8088/proxy/application_1729156404657_0001/ \
2024-10-17 09:48:26,398 INFO mapreduce.Job: Running job: job_1729156404657_0001\
2024-10-17 09:48:33,478 INFO mapreduce.Job: Job job_1729156404657_0001 running in uber mode : false\
2024-10-17 09:48:33,481 INFO mapreduce.Job:  map 0% reduce 0%\
2024-10-17 09:48:38,524 INFO mapreduce.Job:  map 100% reduce 0%\
2024-10-17 09:48:42,546 INFO mapreduce.Job:  map 100% reduce 100%\
2024-10-17 09:48:42,554 INFO mapreduce.Job: Job job_1729156404657_0001 completed successfully\
2024-10-17 09:48:42,610 INFO mapreduce.Job: Counters: 54\
File System Counters\
FILE: Number of bytes read=56\
FILE: Number of bytes written=458111\
FILE: Number of read operations=0\
FILE: Number of large read operations=0\
FILE: Number of write operations=0\
HDFS: Number of bytes read=1423210\
HDFS: Number of bytes written=36\
HDFS: Number of read operations=8\
HDFS: Number of large read operations=0\
HDFS: Number of write operations=2\
HDFS: Number of bytes read erasure-coded=0\
Job Counters\
Launched map tasks=1\
Launched reduce tasks=1\
Rack-local map tasks=1\
Total time spent by all maps in occupied slots (ms)=6860\
Total time spent by all reduces in occupied slots (ms)=12800\
Total time spent by all map tasks (ms)=1715\
Total time spent by all reduce tasks (ms)=1600\
Total vcore-milliseconds taken by all map tasks=1715\
Total vcore-milliseconds taken by all reduce tasks=1600\
Total megabyte-milliseconds taken by all map tasks=7024640\
Total megabyte-milliseconds taken by all reduce tasks=13107200\
Map-Reduce Framework\
Map input records=131666\
Map output records=131659\
Map output bytes=1186401\
Map output materialized bytes=48\
Input split bytes=112\
Combine input records=131659\
Combine output records=3\
Reduce input groups=3\
Reduce shuffle bytes=48\
Reduce input records=3\
Reduce output records=3\
Spilled Records=6\
Shuffled Maps =1\
Failed Shuffles=0\
Merged Map outputs=1\
GC time elapsed (ms)=63\
CPU time spent (ms)=1290\
Physical memory (bytes) snapshot=579260416\
Virtual memory (bytes) snapshot=13580148736\
Total committed heap usage (bytes)=473956352\
Peak Map Physical memory (bytes)=356077568\
Peak Map Virtual memory (bytes)=5113552896\
Peak Reduce Physical memory (bytes)=223182848\
Peak Reduce Virtual memory (bytes)=8466595840\
Shuffle Errors\
BAD_ID=0\
CONNECTION=0\
IO_ERROR=0\
WRONG_LENGTH=0\
WRONG_MAP=0\
WRONG_REDUCE=0\
File Input Format Counters\
Bytes Read=1423098\
File Output Format Counters\
Bytes Written=36\
root@1ac7ab746329:/# hdfs dfs -cat /output/result/part-r-00000\
2024-10-17 09:54:51,139 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false\
Attribute       294\
Case    32711\
Vote    98654\
root@1ac7ab746329:/#\