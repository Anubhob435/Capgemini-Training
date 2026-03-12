# Spring Framework Notes

## What is Spring?

* **Spring is open source:** While building any web application/networking app we do not need to purchase any license from any vendor (like Apache). It is free.

* **Light weight:** We can use any particular of all the spring modules to build an app.

* **Java based framework**

---

## Spring Modules

1. Spring Core
2. Spring JDBC
3. Spring Data JPA
4. Spring ORM
5. Spring Web MVC
6. Spring Boot: It is auto configuration of embedded server.
7. Spring REST API: Used to implement restful webservices for distributed application (Application built with different language). Using XML, JSON format
8. Spring AoP (Aspect Oriented Programming)
9. Spring Security
10. Spring Cloud

---

## Why Spring?

1. Open Source
2. Light weight
3. It is used to reduce the complexities faced while developing the application.

### Complexities

* Establish Connection
* Create platform
* Begin the transaction
* Commit the transaction
* Creation of object of the class





---

## Spring Core

Basic module of Spring which give complete info about the IoC and Dependency Injection.

**IoC - Inversion of Controller**

### Comparison: IoC vs JVM

| Task of IoC | Task of JVM |
|-------------|-------------|
| Creation of the **Bean** of the class | Creation of the **object** of the class |
| Injecting the values into the Primitive | Injecting the values into the Primitive |
| Injecting the values into the Non Primitive | Injecting the values into the Non Primitive |
| Managing the **Bean** | Managing the **Object** |
| Bean Life cycle | Execution of line by line code |

---

### Definitions

* **Object:** If the object or instance is created by the JVM we call it **Object.**

* **Bean:** If the object is created without using new keyword by the IoC container we call it as **Bean.**

---

### Why the container is named as Inversion of Controller?

Because it reverses the traditional way of creating the object, managing the objects **(Beans specifically)** by using **new keyword.**

---

### 3 IoC Containers

#### 1. BeanFactory (I)

It is a supermost interface used to develop stand alone app (that runs without internet on the local machine), to perform 5 Task of IoC container and it understands only XML Configuration.

#### 2. ApplicationContext (I) (extends BeanFactory)

It is an extension of BeanFactory interface used to develop stand alone app (that runs without internet on the local machine), to perform 5 Task of IoC container and it understands all three Configurations.

#### 3. WebApplicationContext (I) (extends ApplicationContext)

It is an extension of BeanFactory interface used to develop stand alone app (that runs without internet on the local machine), to perform 5 Task of IoC container and it understands all three Configurations.

---

### How many ways we can create Bean?

We can use anyone of the following:

* XML configuration
* Java Based Configuration
* Annotation Configuration
* **More 2 can be used for SpringBoot:** application.properties, application.xml

---

## BeanFactory (I)

### Implementation class:

**XmlBeanFactory(C)** - [Reference](https://media.geeksforgeeks.org/wp-content/uploads/20260227111947198575/DifferenceBetweenBeanFactory-andApplicationContext.webp)

* It is the implementation class of BeanFactory.
* It is used to upcast the object of BeanFactory.
* It is used to show the path of XML configuration.

---

## ApplicationContext (I)

### Implementation classes:

#### FileSystemXmlApplicationContext(C)

[Reference](https://media.geeksforgeeks.org/wp-content/uploads/20260227111947198575/DifferenceBetweenBeanFactory-andApplicationContext.webp)

* It is the implementation class of ApplicationContext.
* It is used to upcast the object of ApplicationContext.
* It is used to show the XML configuration, which is present inside the system but outside the project.

#### ClassPathXmlApplicationContext(C)

* It is the implementation class of ApplicationContext.
* It is used to upcast the object of ApplicationContext.
* It is used to show the path of XML configuration, which is present inside the project.

#### AnnotationConfigApplicationContext(C)

* It is the implementation class of ApplicationContext.
* It is used to upcast the object of ApplicationContext.
* It is used to show the path of Component class (Annotation and java based configuration).

---

**Note:** To get the IoC container of the implementation classes we need to import Spring context dependency.







