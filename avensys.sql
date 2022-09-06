CREATE database login;
USE login;

CREATE TABLE user
(
  id INT NOT NULL AUTO_INCREMENT,
  fName VARCHAR(60) NOT NULL,
  lName VARCHAR(60) NOT NULL,
  role CHAR(10) NOT NULL,
  username VARCHAR(60) NOT NULL,
  pw CHAR(30) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (username)
);

INSERT INTO user VALUES
	(NULL, 'Lara', 'Tom', 'Manager', 'manager', 'manager1'),
    (NULL, 'Clara', 'Ferrari', 'User', 'clara', 'clara2'),
	(NULL, 'Jamie', 'Sawkins', 'User', 'jamie', 'jamie3'),
    (NULL, 'Basil', 'Tebb', 'User', 'basil', 'basil4');
  
SELECT * FROM user;