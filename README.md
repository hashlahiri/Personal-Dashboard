### Personal-Project-Dashboard
Welcome to the Personal-Project-Dashboard, a robust and dynamic dashboard powered by Spring Boot and MongoDB. This project is designed with backend developers in mind, providing a convenient platform for working with JSON and string objects through OPEN API integrations.

### Features
* Spring Boot Backend: Leverage the simplicity and power of Spring Boot for your backend services.
* MongoDB Integration: Enjoy the flexibility of MongoDB for efficient data storage and retrieval.
* OPEN API Integration: Connect to various OPEN APIs to collect and display dashboard data.
* Weather Data: Utilize multiple OpenWeatherMap APIs with stable, error-handled controller flows that return JSON responses for weather data visualization.
* Json Comparator: Search for a JSON combination inside another JSON, through a specific algorithm for search
* Kafka: Kafka Producer and Consumer implemented inside [must have pre-installed apache kafka on system]


### Getting Started
To get started with this project, follow these steps:

### Clone the repository:
```
git clone https://github.com/hashlahiri/Personal-Project-Dashboard.git
```

## Kafka Producer and Consumer Configuration:
* Download Apache Kafka on your Windows system.
* Extract the Kafka archive to a directory (e.g., C:\kafka).
* Navigate to the Kafka configuration folder: C:\kafka\config.

### Edit the server.properties file:
* Search for the property logs and set it to C:\kafka\logs.

### Edit the zookeeper.properties file:
* Search for the property logs and set it to C:\kafka\logs.

### Start the Kafka Server:
* Open a terminal and navigate to C:\kafka.

### Start Zookeeper:
* .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

### Start the Kafka broker:
* .\bin\windows\kafka-server-start.bat .\config\server.properties

### Create a Kafka Topic and Produce Messages:
* Open another terminal in C:\kafka\bin\windows.
* Create a topic named my-topic:
* kafka-topics.bat --create --bootstrap-server localhost:9092 --topic my-topic

### Start a console producer for the topic:
* kafka-console-producer.bat --broker-list localhost:9092 --topic my-topic

### Listen to the Kafka Topic and Consume Messages:
* Open another terminal in C:\kafka\bin\windows.
* Start a console consumer for the topic:
* kafka-console-consumer.bat --topic my-topic --bootstrap-server localhost:9092 --from-beginning

## Screenshots
Here are some screenshots of the dashboard in action:

* Welcome Page: !Welcome Page
* Weather Data: !Weather Data

## Contributing
Contributions are welcome! If you have any ideas or issues, feel free to open an issue or submit a pull request.

## License
This project is licensed under the MIT License - see the LICENSE.md file for details.

## Acknowledgments
* Spring Boot
* MongoDB
* OpenWeatherMap
* Apache Kafka
* JSON Comparator
