DROP TABLE IF EXISTS PLAYERS;  
CREATE TABLE PLAYERS AS
    SELECT * FROM CSVRead('C:\Users\mikeb\Documents\workspace-spring-tool-suite-4-4.14.0.RELEASE\socking-dingers\src\main\resources\data.csv');
