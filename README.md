## E-Commerce System

## Project Overview

This Java-based e-commerce system was developed to manage e-commerce process. It showcases a modular, object-oriented design that simulates a basic shopping experience including product management, cart operations, checkout processing, and shipping logistics.

The system focuses on applying key **OOP principles** such as:
- **Inheritance**
- **Interfaces**
- **Polymorphism**

---
## 📽️ Demo 

https://github.com/user-attachments/assets/faa2bc8f-5aa2-4b10-98ec-d8df3dc919c8



## Features

- **Product Definition**
  - Products have a name, price, and available quantity.
  - Some products are **expirable** (e.g., Cheese, Biscuits).
  - Some products are **shippable** (e.g., Cheese, TV) and require a weight attribute.
  - Some products are **expirable and shippable** (e.g cheese)

- **Customer Interaction**
  - Customers can add items to their cart with a specific quantity.
  - Quantity cannot exceed what's available in stock.

- **Checkout Process**
  - Validates:
    - Cart is not empty.
    - All items are in stock and not expired.
    - Customer has sufficient balance.
  - Computes:
    - Subtotal (sum of item prices × quantities)
    - Shipping fees (based on total weight of shippable items)
    - Total amount paid
    - Customer’s remaining balance

- **Shipping Service**
  - All shippable items are sent to a `ShippingService` which accepts a list of objects implementing:
    - `String getName()`
    - `double getWeight()`

---

## 🧪 Example Usage
```Java

product cheese = new Exp_ship("Veta",20,100,"2030,1,1",250);
product cheese1 = new Exp_ship("s",20,100,"2030,1,1",250);
product TV = new Shippable("Samsung",10000,200,2000);
product Biscuits = new Expirable("Lambada",15,100,"2028,1,1");
product MobScratchCard = new Shippable("MobSCard",40,90,20);
product laptop = new product("Lenovo",50000,50 );


//Customer
Customer customer = new Customer("Marwan Salah",40000);

//cart
Cart cart = new Cart();
cart.add(new Item(cheese,3));
cart.add(new Item(MobScratchCard,2));
cart.add(new Item(TV,3));

```
------------------------------------------------------------------------------------------
Output
```markdown

** Shipment notice **
3x Veta		750.0 g
2x MobSCard		40.0 g
3x Samsung		6000.0 g
Total package weight 6790.0 g 
================================
** Checkout receipt **
3x Veta   60.0
2x MobSCard   80.0
3x Samsung   30000.0
----------------------
Subtotal 30140.0
Shipping 30.0
Amount 30170.0

```

## 📦 Project Structure
```bash
E-Commerec/
├── src/
│   ├── Interfaces/
│   │   ├── shipping.java
│   │
│   ├── Products/
│   │   ├── Exp_ship.java           # (Expirable + Shippable) product
│   │   ├── Expirable.java          # Expirable product
│   │   ├── Shippable.java          # Shippable product
│   │   ├── product.java            # Base class
│   │
│   ├── Services/
│   │   ├── checkout_details.java   # Handles the checkout process
│   │   ├── shipping_service.java   # Handles shipping logic
│   │
│   ├── User/
│   │   ├── Cart.java               # Shopping cart
│   │   ├── Customer.java           # Customer info and balance
│   │   ├── Item.java               # Item in the cart
│
│   ├── Main.java                   # Entry point of the application
│
├── E-commerce.iml                  # IntelliJ project file
├── README.md                       # Project documentation

```

## 📌 Technologies Used

- Java (JDK 24+)
- IntelliJ IDEA Community Edition
- OOP Concepts (Inheritance, Polymorphism, Interfaces)
