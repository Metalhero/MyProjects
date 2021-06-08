INSERT INTO roles(role) VALUES ('ROLE_USER');
INSERT INTO roles(role) VALUES ('ROLE_ADMIN');

INSERT INTO USER(password, username, email, active) VALUES ('$2a$10$/zoxVpY6M7K7XxCiHMl30elFxl4HtczwELCly3JkH47IPuVPf8/.O','user','examplemail@asdmail.com',1);
INSERT INTO USER(password, username, email, active) VALUES ('$2a$10$UwjimyxBAdbm7qoPLC72s.J7n0czvj9O27xquKk5xkGUWJJddcska','admin','exampladmail@asdmail.com',1);

INSERT INTO users_roles(user_id, role_id) VALUES (1,1);
INSERT INTO users_roles(user_id, role_id) VALUES (2,1);
INSERT INTO users_roles(user_id, role_id) VALUES (2,2);
