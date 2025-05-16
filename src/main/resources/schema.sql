CREATE TABLE Customer (
                          id INT NOT NULL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          phone VARCHAR(15),
                          date_of_registration DATE
);


CREATE TABLE Product (
                         product_id INT NOT NULL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         price DECIMAL(10, 2) CHECK (price >= 3.00 AND price <= 100.00),
                         stock_quantity INT
);


ALTER TABLE product MODIFY COLUMN product_id INT NOT NULL AUTO_INCREMENT;

CREATE TABLE OrderGeneral (
                              order_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                              order_date DATE NOT NULL,
                              customer_id INT NOT NULL,
                              order_status VARCHAR(50) NOT NULL,
                              delivery_date DATE,
                              FOREIGN KEY (customer_id) REFERENCES customer(id)
) AUTO_INCREMENT = 100001;


CREATE TABLE OrderItem (
                           order_item_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           order_id INT NOT NULL,
                           product_id INT NOT NULL,
                           quantity INT NOT NULL,
                           FOREIGN KEY (order_id) REFERENCES OrderGeneral(order_id),
                           FOREIGN KEY (product_id) REFERENCES product(product_id)
);