-- Dumping structure for table project.bank
DROP TABLE IF EXISTS `bank`;
CREATE TABLE IF NOT EXISTS `bank` (
  `number` int NOT NULL AUTO_INCREMENT,
  `pin` varchar(4) DEFAULT NULL,
  `deposit` varchar(20) DEFAULT NULL,
  `withdrawal` varchar(20) DEFAULT NULL,
  `balance` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`number`) USING BTREE,
  KEY `pin` (`pin`)
)

-- Dumping structure for table project.login
DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `cardno` varchar(20) DEFAULT NULL,
  `pin` varchar(5) DEFAULT NULL
) 

-- Dumping structure for table project.signup
DROP TABLE IF EXISTS `signup`;
CREATE TABLE IF NOT EXISTS `signup` (
  `name` varchar(15) DEFAULT NULL,
  `fname` varchar(15) DEFAULT NULL,
  `date` varchar(5) DEFAULT NULL,
  `month` varchar(10) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `marital` varchar(10) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL,
  `state` varchar(15) DEFAULT NULL,
  `formno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`formno`)
) 

-- Dumping structure for table project.signup2
DROP TABLE IF EXISTS `signup2`;
CREATE TABLE IF NOT EXISTS `signup2` (
  `formno` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `religion` varchar(15) DEFAULT NULL,
  `category` varchar(15) DEFAULT NULL,
  `income` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `education` varchar(15) DEFAULT NULL,
  `occupation` varchar(15) DEFAULT NULL,
  `panno` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `aadharno` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `senior` varchar(5) DEFAULT NULL,
  `existing` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`formno`)
)

-- Dumping structure for table project.signup3
DROP TABLE IF EXISTS `signup3`;
CREATE TABLE IF NOT EXISTS `signup3` (
  `acctype` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `accno` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `formno` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pin` varchar(5) DEFAULT NULL,
  `service_required` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`formno`)
)
