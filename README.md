1. Create a database and a user using the following commands:
CREATE DATABASE contactsdb;
CREATE USER 'john'@'localhost' identified by 'john113';
GRANT ALL ON contactsdb.* to 'john'@'localhost';

2.Import this project into Eclipse or Visual Studio Code

3.Configure application.properties with the appropriate values
4.Run the MiniApplication from your IDE
5.Access your application at: http://localhost:8080/


