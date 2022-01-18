# Highnote Demo App

This is a simple CRUD Java SpringBoot Application

## Objective

The objective of this application is to create the skeleton for a KYC product. KYC stands for Know Your Customer. In order to allow a person to transact
money on a fintech company's platform like Highnote it is required to perform due diligence on the end user. This prevents bad actors from sending and receiving funds. 

The API documentation is available in the demo-openapi.yml file. If your IDE does not have an Open Api plugin editor, then open up https://editor.swagger.io/ in a browser and copy&paste the contents of demo-openapi.yml.

## Setup

This application uses Docker to spin up a MySQL DB instance

```bash
cd /demo
docker compose up
```

# How to Run
### IDE
Run this Springboot Application by right-clicking the DemoApplication.java

### Command Line
Navigate to the directory that contains the demo folder

```bash
cd /demo
mvn clean install
mvn spring-boot:run
```

## Postman
The API endpoints can be used in postman by importing this link https://www.getpostman.com/collections/42290adac28876de17cf


