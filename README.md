# 🛒 E-Commerce System

## 📌 Project Overview

This Java-based e-commerce system was developed to manage e-commerce process. It showcases a modular, object-oriented design that simulates a basic shopping experience including product management, cart operations, checkout processing, and shipping logistics.

The system focuses on applying key **OOP principles** such as:
- **Inheritance**
- **Interfaces**
- **Abstract Classes**
- **Polymorphism**

---

## ✅ Features

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
    - All items are in stock and not expired. (In progress)
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
## 📌 Technologies Used

- Java (JDK 24+)
- IntelliJ IDEA Community Edition
- OOP Concepts (Inheritance, Polymorphism, Interfaces)
- Swing (for GUI version, if applicable)

## 📦 Project Structure
```bash

E-Commerec/
├── src/
│   ├── Interfaces/
│   │   ├── shipping.java
│   │
│   ├── Products/
│   │   ├── Exp_ship.java           # Expirable + Shippable product
│   │   ├── Expirable.java          # Interface
│   │   ├── Shippable.java          # Interface
│   │   ├── product.java            # Abstract base class
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


## 🧪 Example Usage
```java
  Customer customer = new Customer("Marwan",40000);
  Cart cart = new Cart();
  shipping_service shipping_service = new shipping_service();
  checkout_details ChechOut = new checkout_details();

//cart
  cart.add(new Item(cheese,3));
  cart.add(new Item(MobScratchCard,2));
  cart.add(new Item(TV,3));

//shipping
  shipping_service.ship(cart.shippableItems(), cart);

//checkout
ChechOut.checkout(customer,cart);

---

'''bash
** Shipment notice **
2x SCard         40.0 g
3x Samsung       6000.0 g
Total package weight 6040.0 g 
================================

** Checkout receipt **
3x Veta   60.0
2x SCard   80.0
3x Samsung  30000.0
----------------------
Subtotal  30140.0
Shipping  30.0
Amount    30170.0




