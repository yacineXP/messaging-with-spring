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

This project uses Spring to implement asynchronous messaging for the Taco Cloud application. Messages are sent from the website to the kitchens using JMS, RabbitMQ and AMQP, or Kafka. Spring provides support for each of these messaging technologies through the Spring JMS, Spring RabbitMQ, and Spring Kafka libraries.

To receive messages, Spring supports message-driven POJOs. These POJOs can be annotated with the @JmsListener, @RabbitListener, or @KafkaListener annotations to listen for messages on a specific queue or topic. The method annotated with these annotations is called when a message is received on the specified queue or topic.


<div id="code-examples"></div>

## 💻 Code Examples
Here is an example of a Spring JMS message-driven POJO that listens for messages on a specific queue:
```java
@Component
public class OrderMessagingListener {

    private final JmsTemplate jmsTemplate;

    public OrderMessagingListener(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        // Process the order
        System.out.println("Received order: " + order);
        // Send a confirmation message
        jmsTemplate.convertAndSend("tacocloud.order.queue", "Order received");
    }
}
```
In this code example, the ```@JmsListener(destination = "tacocloud.order.queue")``` annotation specifies that this method should listen for messages on the "tacocloud.order.queue" queue. When a message is received, the receiveOrder method is called with the message payload as a parameter. The method processes the order and sends a confirmation message back to the same queue using the ```jmsTemplate.convertAndSend``` method.
<div id="acknowledgements"></div>

## 📚 Acknowledgements 
This project was created with the help of the book **"Spring in Action"** by **Craig Walls** and **Ryan Breidenbach**. Many of the concepts and techniques used in this project were learned from this valuable resource.

