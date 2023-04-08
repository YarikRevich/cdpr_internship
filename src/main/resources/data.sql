INSERT INTO users (firstName, lastName, email, password) VALUES ("admin", "admin", "test@gmail.com", "12345678");
INSERT INTO admins (users_id) VALUES (1);