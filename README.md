###Create user basket
POST http://localhost:8080/basket/{{userId}}

###Get user basket
GET http://localhost:8080/basket/{{userId}}

###Add product to user basket
POST http://localhost:8080/basket/{{userId}}/add/{{product}}

###List all products
GET http://localhost:8080/products

###List product detail
GET http://localhost:8080/products/{{productId}}

###List product detail
POST http://localhost:8080/order/1

In this project, the hexagonal architecture pattern was utilized to facilitate the use 
of abstractions and dependency inversion.

I used cache to store users baskets.

relational database to store products and promotions

and strategy pattern to solve promotions calculations



#Build com Docker

````shell
$ docker build -t qik-serve .
````

````shell
$ docker run -p 8080:8080 qik-serve
````

1. How long did you spend on the test?
- almost two days
2. What would you add if you had more time?
- Remove old baskets from cache
- add ttl to cache end change cache put for cachable
- would implement all cases for the discount strategy
3. How would you improve the product APIs that you had to consume?
- I didn't consume any API.
4. What did you find most difficult?
- Time left to take the test
