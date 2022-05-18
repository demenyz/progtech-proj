## About this document
We are accepted a commission of creating a fully functional food ordering application.  This document will describe the project under development.
## Project overview


## Technologies used
#### Environment – IntelliJ IDEA
IntelliJ IDEA is an integrated development environment (IDE) written in Java for developing computer software. It is developed by JetBrains (formerly known as IntelliJ), and is available as an Apache 2 Licensed community edition, and in a proprietary commercial edition. Both can be used for commercial development.

#### Web server – Apache
An Apache web server will be used to store the database information, in which we will store the database writen in MySQL structure.

#### Programming language – JAVA
We are going to write our code in Java.

#### Communication – Discord, GitHub, Trello
Discord is a communication software made for voice chat. Since Discord is free we are gonna use this software, because it is not sure that all of us will be in the same room when our company develops the webshop the client asked for. With this we will be able to communicate in real time with our coding partners, and since it has a normal chat function that follows the written messages, it will be easy to trace back with the problems that are brought up during development.

GitHub is a free repository where the project will be stored during development. With this we can share and retrivel the versions of our work, and if something is not working we can reroll the changes so we don't have to start from the beginning.

Trello is a free web-based Kanban-style list-making application. We can create our task boards with several columns and move the tasks between them. Typically columns include task statuses: To Do, In Progress and Done.

#### Data structure store – MySQL
The database structure will be written accordig to the MySQL standards. Recommended version: MySQL 8.0

## Business requirements
#### Scope

- **Goals** We want to bulid a fully working application where we can register in and log in too for order foods. Users need to be logged in to order food. We forward orders to a database where the workers can see the order list.

- **Sub-phases** There would be several phases during the work to finish successfully each tasks:
1. Planning: what we want to create, what would be the best idea. 

2. Documenting: write the documents for the chosen idea. 

3. Create: Start to programming the idea what we already documented,  while doing tests too. 

4. Testing: Doing major overall tests for know how the program working or is it working the way we want it. 

1. Finishing: Handover the finished program to the customer, and present each features, the working of the application and how to use it properly.

- **Tasks** 
1. Writing the documents: System Requirements,

3. Programming: Back End, Database, Front End, Tests 

- **Resources** 

1. Apache 2.4.0

2. MySQL 8.0 

3. IntelliJ IDEA

#### Team

**Team members:**

- Bozsó Károly

- Demény Zoltán

#### Task workflow
We use Trello for create new tasks, where anyone can add a new task with labels to easily find it between the other tasks, we can comment them, give short description and add lists if its needed. We can modify our tasks anytime if we want, for example add new comment, add new list item or marked it as finished.

For make it more simple and easier we can create cards with the names of:

- Backlog[not commited] 
- Backlog[commited] 
- In Progress 
- Done 
- Testing 
- Done with tests 
- Ready to deploy


## Functional requirements

#### UX requirements

**Browsing:** The customer should be able to look around between the products at the food shop.

**Detailed information:** The customer should be able to get detailed informations about the product of his/her choice.

**Basket:** The customer should be able to add products to his/her basket.

**Purchase:** The customer should be able to buy products. They could buy the products in their basket. They can finalize their order by giving their shipping information.

**Register:** The users should be able to sign up. This is also required for shopping and to use the basket. 


#### Management requirements

**Add product:** Should be able to add new product which are displayed at the application. They should be able to give the product's name, price, ingredients.

**Delete product:** Should be able to delete product. After that the product is no longer available at the application.

**Modify product:** Should be able to modify a product's properties. After the modification, the product displays with the new properties at the application.

They can review all the orders at the database .
## Database model

## Standards and Laws
#### General Standards
Application must meet the following general standards:

1. Must be easily understandable and easy to use for the customers.

3. Must function in a logical manner for the users.

5. Must use the industry best practices.


#### Development Technology, Programming Language
 application requires the use of the following (or higher) technologies:

- JAVA 8

- Apache 2.4.0

- MySQL 8.0


#### Application regulations
##### Definitions:

Customer- An individual who is at least 14 years old, in case he/she is not 18 yet the consent of his/her legal representative is required. / A legal person or organization unit.

definitions go here!!!!!!!!!!

##### The scope of the terms and conditions of use the application:

1. To use the service provided by the application, the customer need to cognize these rules and accept them.

3. The provided informations in the registration form and order form should be truthful and current. If the customer provides incorrect or outdated information, in particular as regards to the personal data of the customer, the seller is not obliged to carry out orders. It is prohibited to transfer or make available by the customer illegal content or infringe the rights of third parties.

5. Seller shall take the necessary technical and organizational measures to prevent acquisition and modification data provided by the customer during registration and when ordering by unauthorized users.

##### Placing an order:

1. Orders for food available in the application are made through the main form, available after login.

3. An order shall be made by logging in to the store, addition of the food the basket and confirmation of the order. In the absence of the customer registration in the application placing an order is not possible.

5. Sending the order by the customer constitutes an offer submitted by the customer to the seller to enter into a contract of sale, in accordance with the regulations.

For Privacy and Cookie Policy see appendix.

## Appendics
#### Terms and Acronyms
| TERM / ACRONYM  |DEFINITION  |
| ------------ | ------------ |
|  DB | Database  |
|  FE |  Front end, during development mostly used to refer to the Form design |
|	BE   |  Back end, during development mostly used to refer to Java code|
|DEV|Developer |
| SYS| System plan|

#### Privacy Policy
**Consent**

By using our website, you hereby consent to our Privacy Policy and agree to its terms.

**Information we collect**

The personal information that you are asked to provide, and the reasons why you are asked to provide it, will be made clear to you at the point we ask you to provide your personal information.

If you contact us directly, we may receive additional information about you such as your name, email address, phone number, the contents of the message and/or attachments you may send us, and any other information you may choose to provide.

When you register for an Account, we may ask for your contact information, including items such as name, company name, address, email address, and telephone number.

**How we use your information**

We use the information we collect in various ways, including to:

- Provide, operate, and maintain our website

- Improve, personalize, and expand our website

- Understand and analyze how you use our website

- Develop new services, features, and functionality

- Communicate with you, either directly or through one of our partners, including for customer service, to provide you with updates and other information relating to the webste, and for marketing and promotional purposes

- Send you emails

- Find and prevent fraud
