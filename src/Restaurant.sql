DROP TABLE ORDER_CONTAINS ;
DROP TABLE Customer_Service;
DROP TABLE Edits;
DROP TABLE Orders;
DROP TABLE Admin;
DROP TABLE Customer;
DROP TABLE Package;
DROP TABLE Meal;

CREATE TABLE Admin (
   AdminID INT NOT NULL,
   Password varchar (20) NOT NULL,
   fName varchar (20) NOT NULL,
   lName varchar (20) NOT NULL,
   Birthdate DATE NOT NULL,
   Salary DECIMAL NOT NULL,
   PRIMARY KEY (AdminID)
);

CREATE TABLE Customer (
   CustomerID INT NOT NULL,
   Password varchar (20) NOT NULL,
   fName varchar (20) NOT NULL,
   lName varchar (20) NOT NULL,
   Birthdate DATE NOT NULL,
   Address varchar (100) NOT NULL,
   PRIMARY KEY (CustomerID)
);

CREATE TABLE Meal(
   ProductID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 8000 INCREMENT BY 1),
   Name varchar (45) NOT NULL,
   Type varchar (20) NOT NULL,
   Calories INT NOT NULL,
   Vegan BOOLEAN NOT NULL,
   Keto BOOLEAN NOT NULL,
   Price DECIMAL NOT NULL,
   PRIMARY KEY (ProductID)
);

CREATE TABLE Package (
   Name varchar (30) NOT NULL,
   ProductID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 8100 INCREMENT BY 1),
   PkgPrice INT NOT NULL,
   PkgCalories INT NOT NULL,
   DietType varchar (20) NOT NULL,
   Vegan BOOLEAN ,
   Keto BOOLEAN ,
   Breakfast_Dish varchar (45) ,
   Breakfast_Drink varchar (45)  ,
   Breakfast_Dessert varchar (45)  ,

   Lunch_Dish varchar (45)  ,
   Lunch_Drink varchar (45)  ,
   Lunch_Dessert varchar (45) ,

   Dinner_Dish varchar (45) ,
   Dinner_Drink varchar (45) ,
   Dinner_Dessert varchar (45) ,
   PRIMARY KEY (productID)
);


CREATE TABLE Edits (
   AdminID INT NOT NULL,
   ProductID INT NOT NULL,
   DateTime Timestamp,
    
   FOREIGN KEY (AdminID) REFERENCES Admin (AdminID)
);

CREATE TABLE Orders (
   OrderID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 400 INCREMENT BY 1),
   CustomerID INT NOT NULL,
   Total DECIMAL NOT NULL,
   PaymentMethod varchar (200),
   DateTime TIMESTAMP ,
   PRIMARY KEY (OrderID),
   FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID) 
);

CREATE TABLE Order_Contains (
   OrderID INT NOT NULL,
   ProductID INT NOT NULL,
   Price DECIMAL NOT NULL,
   Quantity INT NOT NULL,

PRIMARY KEY (OrderID,ProductID),
FOREIGN KEY (OrderID) REFERENCES Orders (OrderID)
 );

CREATE TABLE Customer_Service (
   CustomerID INT NOT NULL,
   OrderID INT NOT NULL,
   AdminID INT ,
   Checked BOOLEAN ,
   Date_and_Time TIMESTAMP NOT NULL,
   Complaint varchar (200) NOT NULL ,
   Reply varchar(200),
   FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID),
   FOREIGN KEY (AdminID) REFERENCES Admin (AdminID),
   FOREIGN KEY (OrderID) REFERENCES Orders (OrderID)
);

INSERT INTO Admin (AdminID,Password,fName, lName,Birthdate , Salary )
VALUES 
   (101,'easyPass','Hind','Alzahrani','2001-03-04',6000), 
   (102,'funnCode20','Aseel','AlGhamddi','1999-05-01',3000),
   (103,'IAU2022', 'Nouf', 'Alghamdi','2000-12-19',8500),
   (104,'1234BH', 'Bayan', 'AlHumaidan','2001-04-26',5000),
   (105,'1234BH', 'Shahad', 'AlShammari','1998-08-17',7400),
   (106,'1234BH', 'Zahra', 'AlHarz','2001-04-26',5000);

INSERT INTO Customer (CustomerID,Password,fName, lName,Birthdate, Address)
VALUES
   (201,'Random1','Aseel','Michael','2002-07-05','Khobar'),
   (202,'cornPop21','Zahra','Morgano','2000-08-29','Dammam'),
   (203,'Deitel0','Bayan','Alhumidan', '2001-10-11','Khobar'),
   (204,'paSs123','Hind','AlZahrani', '2001-04-26','Dhahran'),
   (205,'Abc999','Sara','Omar', '1996-06-15','Jubail'),
   (206,'f5151P','Fatima','Yousif', '1997-07-7','Dammam');



INSERT INTO Meal (Name, Type, Calories , Vegan , Keto, Price)
VALUES
/* 
Breakfast
 */
   ('Banana Pancakes', 'dish', 250, TRUE ,FALSE, 35 ),
   ('Coconut Mango Muffins', 'dish', 252, FALSE ,FALSE, 35 ),
   ( 'Keto Chaffee Breakfast Snadwich', 'dish', 342,FALSE,TRUE,25),
   ('Baked Avocado Egg Boats', 'dish', 217, FALSE ,TRUE, 45 ),
   ('Avocado Cucmber Roll', 'dish', 231, FALSE ,FALSE, 30 ),
/* 
Lunch
 */
   ('Tacos', 'dish', 443, TRUE ,FALSE, 40 ),
   ('Cacciatore', 'dish', 534, True ,FALSE, 45 ),
   ('Shrimp and Grits', 'dish', 442, FALSE ,TRUE, 50 ),
   ('Taco Soup', 'dish', 376, FALSE ,TRUE, 45 ),
   ('Sushi Roll', 'dish', 188, FALSE ,FALSE, 50 ),
/* 
Dinner
 */
   ('Roasted', 'dish', 422, TRUE ,False, 50 ),
   ('Frankies', 'dish', 341, TRUE ,False, 35 ),
   ('Taco Shells', 'dish', 22, False ,True, 40 ),
   ('Stuffed Peppers', 'dish', 345, False ,True, 40 ),
   ('Salmon with Lemon Garlic Butter Sauce', 'dish', 210, False ,False, 50 ),
/* 
Drink
 */
   ('Orange Juice', 'drink', 113, TRUE ,False, 18 ),
   ('Lemon Juice', 'drink', 97, TRUE ,False, 18 ),
   ('Blueberry Pineapple Lemonade', 'drink', 148, FALSE ,False, 20 ),
   ('Avocado Green Smoothie', 'drink', 82, TRUE ,FALSE, 25 ),
   ('Peanut Butter Smoothie', 'drink', 113, TRUE ,TRUE, 21 ),
/* 
Dessert
 */
   ('Brownies', 'dessert', 252, TRUE ,False, 25 ),
   ('Sugar-Free Cheesecake', 'dessert', 121, TRUE ,TRUE, 21 ),
   ('Chocolate Cake', 'dessert', 212, TRUE ,TRUE, 20 ),
   ('Pumpkin Pie', 'dessert', 189, TRUE ,False, 21 ),
   ('Apple Pie Oatmeal Cookies', 'dessert', 156, false ,false, 25 );

INSERT INTO Package (Name, PkgPrice, pkgcalories, DietType,Vegan , Keto, Breakfast_Dish ,Breakfast_Drink ,Breakfast_Dessert ,  Lunch_Dish, Lunch_Drink ,Lunch_Dessert,Dinner_Dish,Dinner_Drink, Dinner_Dessert)
VALUES
   ('Vegan delight Package' ,499.50, 2141, 'vegan', true,false, 'Banana Pancakes','Orange Juice','Brownies','Cacciatore','Lemon Juice','Brownies',  'Frankies','Peanut Butter Smoothie','Pumpkin Pie'  ),
   ('Keto delight Package' ,650, 1797, 'keto', false,true,'Baked Avocado Egg Boats','Peanut Butter Smoothie','Sugar-Free Cheesecake','Shrimp and Grits','Peanut Butter Smoothie','Chocolate Cake','Stuffed Peppers','Peanut Butter Smoothie','Sugar-Free Cheesecake' ),
   ('Original Package' ,550, 1919, 'loss-wight diet', false,false,'Tacos','Blueberry Pineapple Lemonade','Chocolate Cake','Frankies','Lemon Juice','Brownies','Sushi Roll','Avocado Green Smoothie','Apple Pie Oatmeal Cookies' );

INSERT INTO Edits (AdminID,ProductID,DateTime)
VALUES
   (101,8001,{ts '2022-5-09 07:00:00'}),
   (102,8002,{ts '2022-4-28 6:00:00'}),
   (103,8004,{ts '2022-4-29 10:00:00'});

INSERT INTO Orders (CustomerID,Total, PaymentMethod,DateTime)
VALUES
   (202,75,'Cash', {ts '2022-02-09 07:00:00'}),
   (201,126,'Apple Pay',{ts '2022-03-09 05:30:00'}),
   (202,112,'Mada',{ts '2022-01-10 10:55:00'}),
   (204,190,'Apple Pay',{ts '2022-03-24 7:45:00'});


INSERT INTO Order_Contains (OrderID,ProductID,Price, Quantity)
VALUES
   (400,8007,50,1),
   (400,8020,25,1),

   (401,8000,105,3),
   (401,8023,21,1),

   (402,8021,42,2),
   (402,8010,50,1),
   (402,8017,20,1),

   (403,8005,40,1),
   (403,8009,100,2),
   (403,8018,50,2);


 INSERT INTO Customer_Service (CustomerID,OrderID,AdminID,Checked, Date_and_time,Complaint, Reply)
 VALUES
    (201,401,101,TRUE,{ts '2021-02-12 22:30:12'}, 'Long wait time','You will get a 30% discount coupon as an apologize.'),
    (202,400,102,TRUE,{ts '2021-03-18 10:30:23'}, 'subpar food and drink quality','We are  sorry to hear that, you will get a free meal today afternoon.' ),
    (202,402,103,FALSE,{ts '2021-03-22 17:00:00'}, 'Delivery related issues',NULL);
