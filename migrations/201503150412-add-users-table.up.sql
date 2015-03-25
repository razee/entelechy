CREATE TABLE users
(id VARCHAR(20) PRIMARY KEY,
 first_name VARCHAR(30),
 last_name VARCHAR(30),
 email VARCHAR(30),
 admin BOOLEAN,
 last_login TIME,
 is_active BOOLEAN,
 pass VARCHAR(100));


CREATE TABLE posts
(id INTEGER PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(30),
 timestamp TIMESTAMP,
 category VARCHAR(30),
 content VARCHAR(10000))



