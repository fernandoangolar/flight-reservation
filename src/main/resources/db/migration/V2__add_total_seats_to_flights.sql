
ALTER TABLE flights
ADD COLUMN total_seats INT CHECK (total_seats >= 0) NOT NULL;