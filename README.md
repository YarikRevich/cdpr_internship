# Online games store

A simple web-application written only for practical task for internship in Intellias

## Setup


## Tutorial

You can access web-application only via JSON interface.
In order to test its functionality, you should before of all run wep-application locally:

```
./mvnw clean install # builds java project

java -jar target/practicaltest* # runs built jar file
```

Default address of web-application is **localhost:8080**

In general, there exist such endpoints

| Name | Parameters | Description
|------|-------------|------------
|users/createUser| userId(long): id of the user |Creates new user
|users/deleteUser| userId(long): id of the user |Deletes user
|users/getAllUsers| - |Lists all users
|products/createProduct| productId(long): id of the product |Creates new product
|products/deleteProduct| productId(long): id of the product |Deletes product
|products/getAllProducts| - |Lists all products
|transactions/buyProduct| userId(long): id of the user; productId(long): id of the product |Creates new transaction
|transactions/getAllProductsByUserId| id(long): id of the user |Lists all products, bought by user with certain id
|transactions/getAllUsersByProductId| id(long): id of the product |Lists all users, who bought product with certain id

Then, you can use further "curl" requests to check if everything works fine 

```
//Test of users/createUser endpoint
curl -d '{"firstName": "Yaroslav", "secondName": "Svitlytskyi", "moneyAmount": 1000}' -H "Content-Type: application/json" -X POST http://localhost:8080/users/createUser

//Test of users/deleteUser endpoint
curl -d '{"id": 1}' -H "Content-Type: application/json" -X DELETE http://localhost:8080/users/deleteUser

//Test of users/getAllUsers endpoint
curl -H "Content-Type: application/json" -X GET http://localhost:8080/users/getAllUsers

//Test of products/createProduct endpoint
curl -d '{"name": "apple", "price": 200}' -H "Content-Type: application/json" -X POST http://localhost:8080/products/createProduct

//Test of products/deleteProduct endpoint
curl -d '{"id": 1}' -H "Content-Type: application/json" -X DELETE http://localhost:8080/products/deleteProduct

//Test of products/getAllProducts endpoint
curl -H "Content-Type: application/json" -X GET http://localhost:8080/products/getAllProducts

//Test of transactions/buyProduct endpoint
curl -d '{"userId": "1", "productId": "2"}' -H "Content-Type: application/json" -X POST http://localhost:8080/transactions/buyProduct

//Test of transactions/getAllProductsByUserId endpoint
curl -d '{"id": "1"}' -H "Content-Type: application/json" -X POST http://localhost:8080/transactions/getAllProductsByUserId

//Test of transactions/getAllUsersByProductId endpoint
curl -d '{"id": "2"}' -H "Content-Type: application/json" -X POST http://localhost:8080/transactions/getAllUsersByProductId
```