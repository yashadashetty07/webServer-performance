# Java Socket Server Performance Testing 🚀

This project demonstrates performance testing across 3 types of server architectures written in Java:

1. ✅ Single-threaded Server  
2. 🔁 Multi-threaded Server  
3. ⚙️ Thread Pool-based Server  

The testing was done using Apache JMeter to simulate 600,000 client connections within 60 seconds.  
This stress test highlights how different server architectures handle extreme concurrent load conditions.



## 🔧 Project Structure

bash
.
├── sServer.java             # Single-threaded Server
├── sClient.java             # Single-threaded Client
├── multiThreadedServer/
│   ├── Server.java          # Multi-threaded Server
│   └── Client.java          # Multi-threaded Clients (100 threads)
├── threadPoolServer/
│   └── tServer.java         # Thread Pool Server
└── jmeter/                  # (optional) Store your JMeter .jmx test plans here




## 📊 JMeter Performance Testing

Apache JMeter was used to simulate 600,000 virtual users over 60 seconds, with each client attempting to establish a socket connection to the server.

 Test Setup:
- Thread Group: 600,000 users
- Ramp-Up Period: 60 seconds
- Loop Count: 1
- Sampler: TCP Sampler (port: 8010, server: localhost)
- Payload: Simple client message (e.g., "Hello from Client")



 💡 Server Type Comparison

|-----------------------|---------------------|----------------------------------|-----------------------------------|
| Server Type           | Behavior Under Load | Strengths                        | Weaknesses                        |
|-----------------------|---------------------|----------------------------------|-----------------------------------|
| Single-threaded       | Frequent failures   | Simple, easy to implement        | Blocks after 1 connection         |
| Multi-threaded        | Moderate success    | Better concurrency               | Risk of too many threads          |
| Thread Pool-based     | Highest stability   | Controlled scalability, efficient| Needs tuning of thread pool size  |
|-----------------------|---------------------|----------------------------------|-----------------------------------|


## 🛠️ How to Run

 🖥️ Compile

bash
javac sServer.java sClient.java
javac multiThreadedServer/*.java
javac threadPoolServer/tServer.java


 ▶️ Run Servers

- Single-threaded:  
  bash
  java sServer
  

- Multi-threaded:  
  bash
  java multiThreadedServer.Server
  

- Thread Pool Server (with pool size = 100):  
  bash
  java threadPoolServer.tServer
  

 ▶️ Run Clients (Manual Mode)

- Single-threaded Client:  
  bash
  java sClient
  

- Multi-threaded Clients (100):  
  bash
  java multiThreadedServer.Client
  


## ⚙️ JMeter Load Test Steps

1. Launch Apache JMeter.
2. Create a Thread Group:
   - Number of Threads (users): 600000
   - Ramp-up Period: 60 seconds
   - Loop Count: 1
3. Add TCP Sampler:
   - Server Name or IP: localhost
   - Port Number: 8010
   - Text to send: "Hello from Client"
4. Add Listeners:
   - View Results Tree
   - Summary Report
   - Aggregate Report
5. Start the test and observe:
   - Response time
   - Error %, throughput, active threads
6. Compare performance across all 3 server types.

## 📎 Technologies Used

- Java SE 21
- Apache JMeter 5.6.3
- Java Threads & Executors
- TCP Socket Programming


## 📂 GitHub Repo

🔗 [GitHub Repository](https://github.com/yashadashetty07/webServer-performance)


## 📬 Contact

If you're learning server performance, concurrency, or Java backend systems, feel free to connect or contribute!
