
-- Creating Users Table
CREATE TABLE `users` (
             `user_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
             `first_name` VARCHAR(50) NOT NULL,
             `last_name` VARCHAR(50) NOT NULL,
             `email` VARCHAR(100) NOT NULL,
             `phone` CHAR(255) NOT NULL,
             `password` VARCHAR(255) NOT NULL,
             `role` VARCHAR(20) CHECK (role IN ('CUSTOMER', 'ADMIN')) NOT NULL,
             `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Creating Flights Table
CREATE TABLE `flights` (
             `flight_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
             `airline` VARCHAR(100) NOT NULL,
             `flight_number` VARCHAR(10) NOT NULL,
             `origin` VARCHAR(50) NOT NULL,
             `destination` VARCHAR(50) NOT NULL,
             `departure_time` TIMESTAMP NOT NULL,
             `arrival_time` TIMESTAMP NOT NULL,
             `available_seats` INT CHECK (available_seats >= 0) NOT NULL,
             `price` DECIMAL(10,2) CHECK (price >= 0) NOT NULL,
             `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Creating Bookings Table
CREATE TABLE `bookings` (
             `booking_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
             `user_id` INT NOT NULL,
             `flight_id` INT NOT NULL,
             `booking_code` VARCHAR(50) NOT NULL,
             `seat_number` VARCHAR(500) NOt NULL,
             `booking_status` VARCHAR(20) CHECK (booking_status IN ('CONFIRMED', 'CANCELLED', 'PENDING')) NOT NULL,
             `booking_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Creating Payments Table
CREATE TABLE `payments` (
             `payment_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
             `booking_id` INT NOT NULL,
             `amount` DECIMAL(10,2) CHECK (amount > 0) NOT NULL,
             `payment_method` VARCHAR(50) CHECK (payment_method IN ('CREDIT_CARD', 'PAYPAL', 'BANK_TRANSFER)')) NOT NULL,
             `payment_status` VARCHAR(20) CHECK (payment_status IN ('PENDING', 'COMPLETED', 'FAILED')) NOT NULL,
             `payment_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Creating Notifications Table
CREATE TABLE `notifications` (
             `notification_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
             `user_id` INT NOT NULL,
             `message` TEXT NOT NULL,
             `sent_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `notification_type` VARCHAR(20) CHECK (notification_type IN ('EMAIL', 'SMS')) NOT NULL,
             `is_read` TINYINT(1) DEFAULT 0,
             `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
             `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

ALTER TABLE
    `users` ADD UNIQUE `users_email_unique`(`email`);

ALTER TABLE
    `users` ADD UNIQUE `users_phone_unique`(`phone`);

ALTER TABLE
    `flights` ADD UNIQUE `flight_number_unique`(`flight_number`);

ALTER TABLE
    `bookings` ADD UNIQUE `booking_code_unique`(`booking_code`);

ALTER TABLE `flights`
MODIFY COLUMN `flight_id` BIGINT NOT NULL AUTO_INCREMENT;

ALTER TABLE `bookings`
MODIFY COLUMN `flight_id` BIGINT NOT NULL;



ALTER TABLE
    `bookings` ADD CONSTRAINT `fk_user_id_bookings` FOREIGN KEY(`user_id`) REFERENCES `users`(`user_id`);

ALTER TABLE
    `bookings` ADD CONSTRAINT `fk_flight_id_bookings` FOREIGN KEY(`flight_id`) REFERENCES `flights`(`flight_id`);

ALTER TABLE
    `payments` ADD CONSTRAINT `fk_booking_id` FOREIGN KEY(`booking_id`) REFERENCES `bookings`(`booking_id`);

ALTER TABLE
    `notifications` ADD CONSTRAINT `fk_user_id_notifications` FOREIGN KEY(`user_id`) REFERENCES `users`(`user_id`);

-- Inserting Sample Users
INSERT INTO users (first_name, last_name, email, phone, password, role) VALUES
('John', 'Doe', 'john.doe@example.com', '+244928347582', 'hashed_password_123', 'CUSTOMER'),
('Jane', 'Smith', 'jane.smith@example.com','+244948340089', 'hashed_password_456', 'ADMIN');

-- Inserting Sample Flights
INSERT INTO flights (airline, flight_number, origin, destination, departure_time, arrival_time, available_seats, price) VALUES
('Air Angola', 'AA100', 'Luanda', 'Lisbon', '2025-06-01 08:00:00', '2025-06-01 14:00:00', 150, 500.00),
('TAAG', 'DT200', 'Luanda', 'Johannesburg', '2025-06-02 09:00:00', '2025-06-02 12:00:00', 120, 350.00);

-- Inserting Sample Bookings
INSERT INTO bookings (user_id, flight_id, booking_code, seat_number, booking_status) VALUES
((SELECT user_id FROM users WHERE email='john.doe@example.com'), (SELECT flight_id FROM flights WHERE flight_number='AA100'), 'XH78KL', '12A', 'CONFIRMED');

-- Inserting Sample Payments
INSERT INTO payments (booking_id, amount, payment_method, payment_status) VALUES
((SELECT booking_id FROM bookings WHERE booking_status='CONFIRMED'), 500.00, 'CREDIT_CARD', 'COMPLETED');

-- Inserting Sample Notifications
INSERT INTO notifications (user_id, message, notification_type) VALUES
((SELECT user_id FROM users WHERE email='john.doe@example.com'), 'Your booking for flight AA100 is confirmed.', 'EMAIL');

-- Indexes for performance optimization
CREATE INDEX idx_flights_origin_destination ON flights(origin, destination);
CREATE INDEX idx_bookings_user_id ON bookings(user_id);
CREATE INDEX idx_payments_booking_id ON payments(booking_id);