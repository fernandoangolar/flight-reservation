
ALTER TABLE flights
ADD COLUMN status ENUM('SCHEDULED', 'DELAYED', 'CANCELED', 'COMPLETED') NOT NULL
CHECK (status IN ('SCHEDULED', 'DELAYED', 'CANCELED', 'COMPLETED'));


INSERT INTO flights (flight_number, airline, origin, destination, departure_time, arrival_time, available_seats, total_seats, price, status, created_at, updated_at)
VALUES
('AA101', 'Air Angola', 'Luanda', 'Lisbon', '2025-06-01 08:00:00', '2025-06-01 14:00:00', 150, 200, 500.00, 'SCHEDULED', NOW(), NOW()),
('AA102', 'Air Angola', 'Luanda', 'Dubai', '2025-06-02 09:00:00', '2025-06-02 17:00:00', 120, 180, 700.00, 'DELAYED', NOW(), NOW()),
('AA103', 'Air Angola', 'Luanda', 'Johannesburg', '2025-06-03 07:30:00', '2025-06-03 10:30:00', 100, 150, 300.00, 'COMPLETED', NOW(), NOW()),
('TA200', 'TAAG', 'Luanda', 'Porto', '2025-06-04 06:45:00', '2025-06-04 12:30:00', 80, 120, 450.00, 'CANCELED', NOW(), NOW()),
('TA201', 'TAAG', 'Lisbon', 'Luanda', '2025-06-05 14:00:00', '2025-06-05 20:00:00', 200, 220, 600.00, 'SCHEDULED', NOW(), NOW()),
('EK300', 'Emirates', 'Dubai', 'Luanda', '2025-06-06 03:00:00', '2025-06-06 09:00:00', 90, 150, 900.00, 'DELAYED', NOW(), NOW()),
('EK301', 'Emirates', 'Dubai', 'Johannesburg', '2025-06-07 15:30:00', '2025-06-07 21:00:00', 170, 200, 750.00, 'COMPLETED', NOW(), NOW()),
('TP400', 'TAP Portugal', 'Lisbon', 'Luanda', '2025-06-08 10:00:00', '2025-06-08 16:00:00', 60, 100, 500.00, 'CANCELED', NOW(), NOW()),
('TP401', 'TAP Portugal', 'Lisbon', 'Porto', '2025-06-09 07:00:00', '2025-06-09 08:00:00', 40, 80, 150.00, 'SCHEDULED', NOW(), NOW()),
('TP402', 'TAP Portugal', 'Porto', 'Lisbon', '2025-06-10 20:00:00', '2025-06-10 21:00:00', 30, 60, 100.00, 'DELAYED', NOW(), NOW()),
('TA202', 'TAAG', 'Luanda', 'Cape Town', '2025-06-11 13:00:00', '2025-06-11 17:30:00', 85, 110, 400.00, 'COMPLETED', NOW(), NOW()),
('AA104', 'Air Angola', 'Luanda', 'Maputo', '2025-06-12 08:00:00', '2025-06-12 12:00:00', 95, 130, 320.00, 'SCHEDULED', NOW(), NOW()),
('EK302', 'Emirates', 'Dubai', 'New York', '2025-06-13 01:00:00', '2025-06-13 13:00:00', 250, 300, 1200.00, 'DELAYED', NOW(), NOW()),
('QR500', 'Qatar Airways', 'Doha', 'Luanda', '2025-06-14 11:30:00', '2025-06-14 18:00:00', 180, 200, 800.00, 'COMPLETED', NOW(), NOW()),
('QR501', 'Qatar Airways', 'Doha', 'Lisbon', '2025-06-15 22:00:00', '2025-06-16 04:00:00', 160, 180, 750.00, 'CANCELED', NOW(), NOW()),
('LH600', 'Lufthansa', 'Frankfurt', 'Luanda', '2025-06-16 06:00:00', '2025-06-16 13:00:00', 140, 160, 680.00, 'SCHEDULED', NOW(), NOW()),
('LH601', 'Lufthansa', 'Frankfurt', 'New York', '2025-06-17 09:00:00', '2025-06-17 18:00:00', 190, 210, 1000.00, 'DELAYED', NOW(), NOW()),
('BA700', 'British Airways', 'London', 'Luanda', '2025-06-18 15:00:00', '2025-06-18 22:00:00', 175, 200, 700.00, 'COMPLETED', NOW(), NOW()),
('BA701', 'British Airways', 'London', 'Johannesburg', '2025-06-19 10:30:00', '2025-06-19 19:00:00', 220, 250, 850.00, 'CANCELED', NOW(), NOW()),
('AA105', 'Air Angola', 'Luanda', 'Rio de Janeiro', '2025-06-20 07:00:00', '2025-06-20 16:00:00', 110, 150, 650.00, 'SCHEDULED', NOW(), NOW()),
('AA106', 'Air Angola', 'Luanda', 'São Paulo', '2025-06-21 08:30:00', '2025-06-21 18:30:00', 130, 180, 700.00, 'DELAYED', NOW(), NOW()),
('AA107', 'Air Angola', 'Luanda', 'Madrid', '2025-06-22 09:00:00', '2025-06-22 16:00:00', 100, 130, 600.00, 'COMPLETED', NOW(), NOW()),
('TA203', 'TAAG', 'Luanda', 'Cape Verde', '2025-06-23 14:00:00', '2025-06-23 19:30:00', 150, 170, 550.00, 'SCHEDULED', NOW(), NOW()),
('EK303', 'Emirates', 'Dubai', 'Los Angeles', '2025-06-24 23:00:00', '2025-06-25 15:00:00', 270, 300, 1300.00, 'DELAYED', NOW(), NOW()),
('LH602', 'Lufthansa', 'Frankfurt', 'São Paulo', '2025-06-25 08:00:00', '2025-06-25 16:00:00', 200, 220, 900.00, 'COMPLETED', NOW(), NOW()),
('QR502', 'Qatar Airways', 'Doha', 'Cape Town', '2025-06-26 04:00:00', '2025-06-26 11:30:00', 150, 180, 750.00, 'CANCELED', NOW(), NOW()),
('TP403', 'TAP Portugal', 'Lisbon', 'Rio de Janeiro', '2025-06-27 12:00:00', '2025-06-27 19:00:00', 170, 200, 780.00, 'SCHEDULED', NOW(), NOW()),
('BA702', 'British Airways', 'London', 'Lisbon', '2025-06-28 18:00:00', '2025-06-28 21:00:00', 60, 90, 350.00, 'DELAYED', NOW(), NOW());

INSERT INTO flights (flight_number, airline, origin, destination, departure_time, arrival_time, available_seats, total_seats, price, status, created_at, updated_at)
VALUES
('AA108', 'Air Angola', 'Luanda', 'Berlin', '2025-07-01 10:00:00', '2025-07-01 18:00:00', 100, 150, 750.00, 'SCHEDULED', NOW(), NOW()),
('AA109', 'Air Angola', 'Luanda', 'Paris', '2025-07-02 07:00:00', '2025-07-02 15:00:00', 110, 170, 820.00, 'DELAYED', NOW(), NOW()),
('AA110', 'Air Angola', 'Luanda', 'Rome', '2025-07-03 09:30:00', '2025-07-03 17:30:00', 90, 140, 780.00, 'CANCELED', NOW(), NOW()),
('TA204', 'TAAG', 'Lisbon', 'Rio de Janeiro', '2025-07-04 12:30:00', '2025-07-04 22:00:00', 80, 120, 600.00, 'COMPLETED', NOW(), NOW()),
('TA205', 'TAAG', 'Luanda', 'Cape Town', '2025-07-05 14:30:00', '2025-07-05 19:00:00', 95, 130, 400.00, 'SCHEDULED', NOW(), NOW()),
('EK304', 'Emirates', 'Dubai', 'Johannesburg', '2025-07-06 05:00:00', '2025-07-06 12:00:00', 130, 180, 900.00, 'DELAYED', NOW(), NOW()),
('EK305', 'Emirates', 'Dubai', 'Paris', '2025-07-07 08:00:00', '2025-07-07 16:00:00', 140, 190, 1000.00, 'COMPLETED', NOW(), NOW()),
('TP404', 'TAP Portugal', 'Lisbon', 'São Paulo', '2025-07-08 10:00:00', '2025-07-08 20:00:00', 60, 100, 750.00, 'CANCELED', NOW(), NOW()),
('TP405', 'TAP Portugal', 'Lisbon', 'Madrid', '2025-07-09 06:00:00', '2025-07-09 07:30:00', 50, 80, 200.00, 'SCHEDULED', NOW(), NOW()),
('TP406', 'TAP Portugal', 'Lisbon', 'Porto', '2025-07-10 20:00:00', '2025-07-10 21:00:00', 30, 60, 150.00, 'DELAYED', NOW(), NOW()),
('QR503', 'Qatar Airways', 'Doha', 'Johannesburg', '2025-07-11 01:00:00', '2025-07-11 08:00:00', 100, 150, 800.00, 'COMPLETED', NOW(), NOW()),
('QR504', 'Qatar Airways', 'Doha', 'Madrid', '2025-07-12 09:00:00', '2025-07-12 14:00:00', 120, 170, 700.00, 'SCHEDULED', NOW(), NOW()),
('LH603', 'Lufthansa', 'Frankfurt', 'Lisbon', '2025-07-13 11:30:00', '2025-07-13 16:00:00', 85, 120, 600.00, 'CANCELED', NOW(), NOW()),
('LH604', 'Lufthansa', 'Frankfurt', 'Berlin', '2025-07-14 12:00:00', '2025-07-14 13:30:00', 50, 100, 300.00, 'DELAYED', NOW(), NOW()),
('BA703', 'British Airways', 'London', 'Lisbon', '2025-07-15 14:00:00', '2025-07-15 18:00:00', 70, 110, 500.00, 'COMPLETED', NOW(), NOW()),
('BA704', 'British Airways', 'London', 'Berlin', '2025-07-16 09:30:00', '2025-07-16 13:30:00', 110, 150, 650.00, 'SCHEDULED', NOW(), NOW()),
('AA111', 'Air Angola', 'Luanda', 'Cape Verde', '2025-07-17 07:00:00', '2025-07-17 12:00:00', 75, 120, 550.00, 'DELAYED', NOW(), NOW()),
('AA112', 'Air Angola', 'Luanda', 'São Paulo', '2025-07-18 16:00:00', '2025-07-18 23:00:00', 120, 180, 750.00, 'COMPLETED', NOW(), NOW()),
('TA206', 'TAAG', 'Luanda', 'Madrid', '2025-07-19 12:30:00', '2025-07-19 17:30:00', 95, 140, 500.00, 'SCHEDULED', NOW(), NOW()),
('EK306', 'Emirates', 'Dubai', 'London', '2025-07-20 22:00:00', '2025-07-21 06:00:00', 180, 220, 1100.00, 'DELAYED', NOW(), NOW()),
('EK307', 'Emirates', 'Dubai', 'Los Angeles', '2025-07-21 03:00:00', '2025-07-21 17:00:00', 250, 300, 1500.00, 'COMPLETED', NOW(), NOW()),
('TP407', 'TAP Portugal', 'Lisbon', 'Berlin', '2025-07-22 09:00:00', '2025-07-22 13:00:00', 65, 90, 500.00, 'CANCELED', NOW(), NOW()),
('QR505', 'Qatar Airways', 'Doha', 'Berlin', '2025-07-23 08:30:00', '2025-07-23 14:00:00', 135, 160, 900.00, 'SCHEDULED', NOW(), NOW()),
('LH605', 'Lufthansa', 'Frankfurt', 'New York', '2025-07-24 06:00:00', '2025-07-24 14:00:00', 200, 250, 1200.00, 'DELAYED', NOW(), NOW());

INSERT INTO flights (flight_number, airline, origin, destination, departure_time, arrival_time, available_seats, total_seats, price, status, created_at, updated_at)
VALUES
('LH606', 'Lufthansa', 'Frankfurt', 'Luanda', '2025-07-25 14:00:00', '2025-07-25 22:00:00', 180, 200, 1000.00, 'SCHEDULED', NOW(), NOW()),
('LH607', 'Lufthansa', 'Frankfurt', 'Rome', '2025-07-26 09:00:00', '2025-07-26 12:00:00', 150, 180, 850.00, 'COMPLETED', NOW(), NOW()),
('EK308', 'Emirates', 'Dubai', 'Cape Town', '2025-07-27 03:00:00', '2025-07-27 09:00:00', 200, 220, 950.00, 'DELAYED', NOW(), NOW()),
('EK309', 'Emirates', 'Dubai', 'Sydney', '2025-07-28 06:00:00', '2025-07-28 18:00:00', 300, 320, 1400.00, 'CANCELED', NOW(), NOW()),
('BA705', 'British Airways', 'London', 'Johannesburg', '2025-07-29 07:00:00', '2025-07-29 15:00:00', 160, 200, 900.00, 'SCHEDULED', NOW(), NOW()),
('BA706', 'British Airways', 'London', 'New York', '2025-07-30 10:00:00', '2025-07-30 18:00:00', 220, 250, 1100.00, 'COMPLETED', NOW(), NOW()),
('AA113', 'Air Angola', 'Luanda', 'Dubai', '2025-07-31 08:00:00', '2025-07-31 16:00:00', 140, 170, 820.00, 'DELAYED', NOW(), NOW()),
('AA114', 'Air Angola', 'Luanda', 'Lisbon', '2025-08-01 05:30:00', '2025-08-01 11:30:00', 180, 200, 700.00, 'CANCELED', NOW(), NOW()),
('TA207', 'TAAG', 'Luanda', 'Johannesburg', '2025-08-02 14:00:00', '2025-08-02 19:00:00', 90, 130, 450.00, 'SCHEDULED', NOW(), NOW()),
('TP408', 'TAP Portugal', 'Lisbon', 'Frankfurt', '2025-08-03 12:00:00', '2025-08-03 15:00:00', 100, 150, 500.00, 'COMPLETED', NOW(), NOW()),
('QR506', 'Qatar Airways', 'Doha', 'Sydney', '2025-08-04 03:30:00', '2025-08-04 19:30:00', 250, 300, 1300.00, 'DELAYED', NOW(), NOW()),
('QR507', 'Qatar Airways', 'Doha', 'New York', '2025-08-05 02:00:00', '2025-08-05 14:00:00', 270, 290, 1600.00, 'CANCELED', NOW(), NOW()),
('LH608', 'Lufthansa', 'Frankfurt', 'Madrid', '2025-08-06 11:00:00', '2025-08-06 13:00:00', 90, 100, 400.00, 'SCHEDULED', NOW(), NOW()),
('LH609', 'Lufthansa', 'Frankfurt', 'Paris', '2025-08-07 10:00:00', '2025-08-07 12:00:00', 120, 140, 600.00, 'COMPLETED', NOW(), NOW()),
('EK310', 'Emirates', 'Dubai', 'Mumbai', '2025-08-08 04:00:00', '2025-08-08 10:00:00', 200, 220, 800.00, 'DELAYED', NOW(), NOW()),
('EK311', 'Emirates', 'Dubai', 'London', '2025-08-09 07:30:00', '2025-08-09 15:30:00', 180, 200, 1000.00, 'CANCELED', NOW(), NOW()),
('BA707', 'British Airways', 'London', 'Rome', '2025-08-10 09:00:00', '2025-08-10 12:00:00', 150, 180, 750.00, 'SCHEDULED', NOW(), NOW()),
('BA708', 'British Airways', 'London', 'Dubai', '2025-08-11 13:00:00', '2025-08-11 21:00:00', 220, 250, 1100.00, 'COMPLETED', NOW(), NOW()),
('AA115', 'Air Angola', 'Luanda', 'Nairobi', '2025-08-12 06:00:00', '2025-08-12 10:00:00', 160, 180, 650.00, 'DELAYED', NOW(), NOW()),
('AA116', 'Air Angola', 'Luanda', 'Accra', '2025-08-13 08:00:00', '2025-08-13 12:00:00', 90, 130, 500.00, 'CANCELED', NOW(), NOW()),
('TA208', 'TAAG', 'Luanda', 'Porto', '2025-08-14 14:00:00', '2025-08-14 20:00:00', 75, 120, 400.00, 'SCHEDULED', NOW(), NOW()),
('TP409', 'TAP Portugal', 'Lisbon', 'Dubai', '2025-08-15 02:00:00', '2025-08-15 10:00:00', 110, 140, 800.00, 'COMPLETED', NOW(), NOW()),
('QR508', 'Qatar Airways', 'Doha', 'Paris', '2025-08-16 05:30:00', '2025-08-16 12:30:00', 180, 200, 950.00, 'DELAYED', NOW(), NOW()),
('QR509', 'Qatar Airways', 'Doha', 'Cape Town', '2025-08-17 04:00:00', '2025-08-17 12:00:00', 170, 190, 890.00, 'CANCELED', NOW(), NOW()),
('LH610', 'Lufthansa', 'Frankfurt', 'London', '2025-08-18 12:30:00', '2025-08-18 14:30:00', 110, 150, 550.00, 'SCHEDULED', NOW(), NOW()),
('LH611', 'Lufthansa', 'Frankfurt', 'New York', '2025-08-19 10:00:00', '2025-08-19 18:00:00', 210, 250, 1200.00, 'COMPLETED', NOW(), NOW());
