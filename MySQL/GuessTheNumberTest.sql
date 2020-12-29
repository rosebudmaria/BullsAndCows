DROP DATABASE IF EXISTS GuessTheNumberTest	;
CREATE DATABASE GuessTheNumberTest;

USE GuessTheNumberTest;

CREATE TABLE Game( 
GameId INT PRIMARY KEY AUTO_INCREMENT, 
FourDigitNumber Varchar(4) NOT NULL, 
StatusOfGame Boolean NOT NULL 
);

CREATE TABLE `Round` (
RoundId INT PRIMARY KEY AUTO_INCREMENT,
GameId  INT,
Guess Varchar (4) NOT NULL, 
TimeStampOfRound datetime NOT NULL, 
Result VARCHAR(10) NOT NULL, 
FOREIGN KEY(gameId) REFERENCES Games(gameId)
); 