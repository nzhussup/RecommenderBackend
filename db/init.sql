CREATE TABLE IF NOT EXISTS users (
    userID SERIAL PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    password VARCHAR(150) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS items (
    itemID SERIAL PRIMARY KEY,
    userID INT,
    title TEXT NOT NULL,
    description TEXT,
    score FLOAT(5),
    FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS auth (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(10)
);

INSERT INTO users (firstName, lastName, email, password, username) VALUES
('John', 'Doe', 'john.doe@example.com', 'password123', 'johndoe'),
('Jane', 'Smith', 'jane.smith@example.com', 'password456', 'janesmith'),
('Michael', 'Johnson', 'michael.j@example.com', 'password789', 'mikejohnson'),
('Emily', 'Davis', 'emily.davis@example.com', 'password101', 'emilyd'),
('Daniel', 'Garcia', 'daniel.g@example.com', 'password111', 'dgarcia'),
('Olivia', 'Martinez', 'olivia.m@example.com', 'password222', 'oliviam'),
('James', 'Brown', 'james.b@example.com', 'password333', 'jamesbrown'),
('Sophia', 'Lopez', 'sophia.l@example.com', 'password444', 'sophial'),
('Ethan', 'Gonzalez', 'ethan.g@example.com', 'password555', 'ethang'),
('Isabella', 'Wilson', 'isabella.w@example.com', 'password666', 'isabellaw');

INSERT INTO items (userID, title, description, score) VALUES
(1, 'Item 1', 'Description for item 1', 4.5),
(1, 'Item 2', 'Description for item 2', 3.8),
(1, 'Item 3', 'Description for item 3', 4.9),
(1, 'Item 4', 'Description for item 4', 4.2),
(1, 'Item 5', 'Description for item 5', 3.6),
(1, 'Item 6', 'Description for item 6', 5.0),
(1, 'Item 7', 'Description for item 7', 3.5),
(1, 'Item 8', 'Description for item 8', 4.1),
(1, 'Item 9', 'Description for item 9', 3.9),
(1, 'Item 10', 'Description for item 10', 4.7);

INSERT INTO auth (email, password, role) VALUES
('test@test.com', '$2a$10$4wNSo/r23HUtFGQ6q7ABYeu/DPozGzfwSt.d1EgYjwlsCLWiBpYN2', 'ROLE_ADMIN');



