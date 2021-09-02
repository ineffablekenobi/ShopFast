# ShopFast

This a project based on Ecommerce. The idea was to create a platform
where multiple sellers can sell all kinds products. Customer can come
here and buy products from any dealers they want.

Dealers can open their own shop here and each shop can have varieties
of products which they can sell to the customers available in the
platform. I also created a tracking system based on both customer and
shop perspective. 

Shop perspective - 
* Keeping track of the products that are being sold
* Keeping track of how much money shop is making
* Keeping track of which products are sold most
* Keeping track of the products generating most revenues

Customer perspective - 

* We keep track of which customer buying which products from the market
* Customer favorite stores
* Items that were added to the cart weren't brought.

The project was implemented using spring boot. I used the maven plugin and 
Mysql based database. This kind of database was perfect for my ideas and the 
project. I did import lombok but avoided it in most cases because I wanted to
have more control over the project.

How to use the api - 

Basics - 

* The api works based on the models that I created which are kept in the
models folder in the project. You will need the models to make request to the api
 


* There are two types of api request. 
    1. Some of them are made using just data
    2. Some of them are made using Json objects
  

  
* You will find the api end points to the controller. In the controller you will be able 
to see what kind of objects or data you need to send to get a response.
  The ones with @requestbody will take a json object and return an output.
  


* The output can be simple data or a Json object. You can see the controller and you will
know what to except.
  