<h1 align="center">
  <br>
<a  href="https://spring.io/"  target="_blank"  rel="noreferrer"> <img  src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg"  alt="spring"  width="180"  height="180"/> </a>
  <br>
  Messaging with Spring [Learning]
  <br>
  <br>
</h1>

<p align="center">
  <a href="#project-description">Project Description</a> |
  <a href="#tech-stack-and-libraries">Tech Stack and Libraries</a> |
  <a href="#how-it-works">How it Works</a> |
  <a href="#code-examples">Code Examples</a> |
  <a href="#acknowledgements">Acknowledgements</a>
</p>



<div id="project-description"></div>

## 🚀 Project Description
This project is based on the "Sending messages asynchronously" chapter of "Spring in Action" book, where I learned how to use Spring to implement asynchronous messaging for the Taco Cloud application. I explored three options that Spring offers for asynchronous messaging: the Java Message Service (JMS), RabbitMQ and Advanced Message Queueing Protocol (AMQP), and Apache Kafka. I also learned about Spring's support for message-driven POJOs, which resemble Enterprise JavaBeans' message-driven beans (MDBs).


<div id="tech-stack-and-libraries"></div>

## 🛠️ Tech Stack and Libraries
- Java Spring
- Spring JMS
- Spring RabbitMQ
- Spring Kafka
- ActiveMQ
- RabbitMQ
- Apache Kafka

<div id="how-it-works"></div>

## ⚙️ How it Works

This project leverages the Spring framework to implement asynchronous messaging in the Taco Cloud application. Asynchronous messaging allows for communication between the website and the kitchens to occur independently of one another, improving the responsiveness and scalability of the system.

To enable this functionality, the application uses the Java Messaging Service (JMS), RabbitMQ with the Advanced Message Queuing Protocol (AMQP), or Kafka messaging technologies, all of which are supported by the Spring framework.

<div id="code-examples"></div>

## 💻 Code Examples
**1. An exemple of JMS messaging implementation:**
```java
@Service
public class JmsOrderMessagingService implements OrderMessagingService {

  private JmsTemplate jms;

  @Autowired
  public JmsOrderMessagingService(JmsTemplate jms) {
    this.jms = jms;
  }

  @Override
  public void sendOrder(TacoOrder order) {
    jms.convertAndSend("tacocloud.order.queue", order,
        this::addOrderSource);
  }
  
  private Message addOrderSource(Message message) throws JMSException {
    message.setStringProperty("X_ORDER_SOURCE", "WEB");
    return message;
  }

}
```
This code snippet shows how to implement an order messaging service using the Java Messaging Service (JMS) in a Spring application. The ```JmsOrderMessagingService``` class implements the ```OrderMessagingService``` interface and provides a ```sendOrder``` method to send ```TacoOrder``` objects to the "tacocloud.order.queue" destination using the ```convertAndSend``` method of the jms object.

**2. An exemple of Kafka messaging implementation:**
```java
@Service
public class KafkaOrderMessagingService
                                  implements OrderMessagingService {
  
  private KafkaTemplate<String, TacoOrder> kafkaTemplate;
  
  @Autowired
  public KafkaOrderMessagingService(
          KafkaTemplate<String, TacoOrder> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }
  
  @Override
  public void sendOrder(TacoOrder order) {
    kafkaTemplate.send("tacocloud.orders.topic", order);
  }
  
}
```
This code snippet shows how to implement an order messaging service using Apache Kafka in a Spring application. The ```KafkaOrderMessagingService``` class implements the ```OrderMessagingService``` interface and provides a ```sendOrder``` method to send ```TacoOrder``` objects to the "tacocloud.orders.topic" topic using the send method of the ```kafkaTemplate``` object.

<div id="acknowledgements"></div>

## 📚 Acknowledgements 
This project was created with the help of the book **"Spring in Action"** by **Craig Walls** and **Ryan Breidenbach**. Many of the concepts and techniques used in this project were learned from this valuable resource.

