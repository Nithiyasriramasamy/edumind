# Campus Cafeteria Sales Tracker

A full-stack web application for managing cafeteria food orders with a clean, interactive UI.

## Features

- **Menu Display**: Browse food items in a responsive 3-column grid
- **Shopping Cart**: Add items to cart and view total amount
- **Order Processing**: Place orders with mock payment
- **Digital Bill**: Generate order confirmation with details

## Tech Stack

- **Frontend**: HTML, CSS, Thymeleaf
- **Backend**: Spring Boot (Java)
- **Database**: MySQL
- **Styling**: Custom CSS with Poppins font

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

## Database Setup

1. Install MySQL and start the service
2. Create a database user (or use root)
3. Update `src/main/resources/application.properties` with your MySQL credentials:
   ```properties
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```

## Running the Application

1. Navigate to the project directory:
   ```bash
   cd demo
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

3. Open your browser and go to: http://localhost:8080

## Application Workflow

1. **Home Page (/)**: Browse the cafeteria menu with food items displayed in cards
2. **Add to Cart**: Click "Add to Cart" on any item to add it to your cart
3. **Cart Page (/cart)**: View selected items and total amount
4. **Place Order**: Click "Place Order & Pay" to process the order
5. **Bill Page (/bill)**: View order confirmation and success message

## Sample Data

The application automatically initializes with sample food items including:
- Burger ($8.99)
- Pizza ($12.99)
- Sandwich ($6.99)
- Pasta ($10.99)
- Salad ($7.99)
- Coffee ($3.99)
- Fries ($4.99)
- Soda ($2.99)
- Ice Cream ($5.99)

## API Endpoints

- `GET /` - Display menu items
- `POST /add-to-cart/{id}` - Add item to cart
- `GET /cart` - View cart contents
- `POST /place-order` - Process order and payment
- `GET /bill` - View order confirmation

## Design Features

- Warm cafeteria-themed colors (orange, beige, brown)
- Responsive design for mobile and desktop
- Hover animations and smooth transitions
- Clean, modern UI with rounded corners and shadows
- Success animations on order completion

## Project Structure

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── CafeApplication.java
│   │   ├── config/DataInitializer.java
│   │   ├── controller/CafeteriaController.java
│   │   ├── model/Item.java
│   │   ├── model/Order.java
│   │   ├── repository/ItemRepository.java
│   │   ├── repository/OrderRepository.java
│   │   └── service/CartService.java
│   └── resources/
│       ├── static/css/style.css
│       ├── templates/
│       │   ├── index.html
│       │   ├── cart.html
│       │   └── bill.html
│       └── application.properties
```

## Notes

- The cart is session-based (in-memory)
- Payment is mocked (no real payment processing)
- Database tables are auto-created via JPA
- Images are loaded from Unsplash for demonstration