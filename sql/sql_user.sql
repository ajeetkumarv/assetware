--CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'Ass3t@1234';

--GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';
GRANT select, insert, update, delete PRIVILEGES ON *.* TO 'admin'@'localhost';

--REVOKE type_of_permission ON database_name.table_name FROM ‘username’@‘localhos
--DROP USER ‘username’@‘localhost’;
FLUSH PRIVILEGES;