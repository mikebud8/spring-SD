DROP TABLE IF EXISTS PLAYERS;
DROP TABLE IF EXISTS TEAMS;
  
CREATE TABLE PLAYERS AS
    SELECT * FROM CSVRead('C:\Users\mikeb\Documents\workspace-spring-tool-suite-4-4.14.0.RELEASE\socking-dingers\src\main\resources\data.csv');

CREATE TABLE TEAMS AS
    SELECT * FROM CSVRead('C:\Users\mikeb\Documents\workspace-spring-tool-suite-4-4.14.0.RELEASE\socking-dingers\src\main\resources\teams.csv');
