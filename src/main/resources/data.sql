INSERT INTO country(capital, code, continent, description, nationality)
VALUES ('Budapest',360,'HUN','leírás','Magyar');
INSERT INTO country(capital, code, continent, description, nationality)
VALUES ('Bukarest',465,'RO','leírás','Románia');
INSERT INTO country(capital, code, continent, description, nationality)
VALUES ('Berlin',4378,'GER','-','Németország');
INSERT INTO country(capital, code, continent, description, nationality)
VALUES ('Párizs',933,'FR','Híres','Franciaország');
INSERT INTO country(capital, code, continent, description, nationality)
VALUES ('Tokio',1973,'JP','Szigetország','Japán');

INSERT INTO state (capital, code, countryid, details, name)
VALUES ('Szekszárd','7200',1,'Tolna megye','Dombóvár');
INSERT INTO state (capital, code, countryid, details, name)
VALUES ('Budapest','1000',1,'Pest megye','Budapest');
INSERT INTO state (capital, code, countryid, details, name)
VALUES ('Kaposvár','7600',1,'Somogy megye','Csoma');

INSERT INTO client(address, city, countryid, details, email, mobile, stateid, website, firstname, gender, lastname, marital_status, othername, title)
VALUES ('Kiskőrösi utca 65','Nagykőrös',1,'Tiszta rendezett anyagi háttér','peti.nagy@asdmail.com','06 1/555-555',1,'nincs','Nagy','Férfi','Péter',
'Egyedülálló','Mester','Grandmaster');
INSERT INTO client(address, city, countryid, details, email, mobile, stateid, website, firstname, gender, lastname, marital_status, othername)
VALUES ('Harkály utca 1.','Kiskőrös',1,'Asztmás','lacko.kis@asdmail.com','06 1/777-777',2,'nincs','Kis','Férfi','László',
'Kapcsolatban','Inas');

INSERT INTO location(address, city, countryid, description, details, stateid)
VALUES ('Kiscsikó tér. 266','Dombóvár',1,'Telephely','4500m2',1);
INSERT INTO location(address, city, countryid, description, details, stateid)
VALUES ('Palcsó utca 66.','Kaposvár',1,'Telephely','2000m2',3);
INSERT INTO location(address, city, countryid, description, details, stateid)
VALUES ('Óz utca 55','Érd',1,'Kiállítótér','Központ',2);
INSERT INTO location(address, city, countryid, description, details, stateid)
VALUES ('Harmat Jenő utca 2.','Bárdudvarnod',1,'Telephely','500m2',3);

INSERT INTO roles(role) VALUES ('ROLE_USER');
INSERT INTO roles(role) VALUES ('ROLE_ADMIN');

INSERT INTO USER(password, username, email, active, firstname, lastname)
VALUES ('$2a$10$/zoxVpY6M7K7XxCiHMl30elFxl4HtczwELCly3JkH47IPuVPf8/.O','user','examplemail@asdmail.com',1,'test','user');
INSERT INTO USER(password, username, email, active, firstname, lastname)
VALUES ('$2a$10$UwjimyxBAdbm7qoPLC72s.J7n0czvj9O27xquKk5xkGUWJJddcska','admin','exampladmail@asdmail.com',1,'test','admin');

INSERT INTO users_roles(user_id, role_id) VALUES (1,1);
INSERT INTO users_roles(user_id, role_id) VALUES (2,1);
INSERT INTO users_roles(user_id, role_id) VALUES (2,2);

INSERT INTO vehicle(acquisition_date, description, fuel_capacity, locationid, name, net_weight, power, remarks, vehicle_number)
VALUES ('2020-01-01','blue','2000L',1,'alfa romeo','1000kg','200le','powerfull',20);
INSERT INTO vehicle(acquisition_date, description, fuel_capacity, locationid, name, net_weight, power, remarks, vehicle_number)
VALUES ('2020-02-01','red','2000L',2,'dodge viper','1400kg','230le','powerfull',30);
INSERT INTO vehicle(acquisition_date, description, fuel_capacity, locationid, name, net_weight, power, remarks, vehicle_number)
VALUES ('2020-03-01','yellow','2000L',4,'suzuki','500kg','80le','weak',30);

INSERT INTO employee(address, city, countryid, date_of_birth, email, firstname, gender, lastname, marital_status, mobile, stateid, title)
VALUES ('V.66','Dombóvár',1,'1988-05-10 00:00:00','metalhero2010@gmail.com','Somogyi','Férfi','György','Házas','06202105555',1,'Developer');