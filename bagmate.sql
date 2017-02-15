-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ssdi_onlinebaggagefinder
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `msgID` int(11) NOT NULL AUTO_INCREMENT,
  `sender` varchar(100) DEFAULT NULL,
  `receiver` varchar(100) DEFAULT NULL,
  `messageDate` varchar(100) DEFAULT NULL,
  `requestWeight` int(11) DEFAULT NULL,
  `postWeight` int(11) DEFAULT NULL,
  `postId` int(11) DEFAULT NULL,
  `approved` tinyint(1) DEFAULT NULL,
  `message` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`msgID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'vandana@uncc.edu','tallam@uncc.edu','12/6/2016, 7:23:38 PM',12,21,1,0,'Hey I need 12 kgs of your baggage space'),(2,'m@gmail.com','tallam@uncc.edu','12/6/2016, 7:55:16 PM',12,21,1,1,'Hye i need this space');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notifications` (
  `notify_id` int(11) NOT NULL AUTO_INCREMENT,
  `notify_msg` varchar(2000) DEFAULT NULL,
  `notified_from` varchar(200) DEFAULT NULL,
  `notified_to` varchar(200) DEFAULT NULL,
  `contact_details` varchar(2000) DEFAULT NULL,
  `notify_date` varchar(500) DEFAULT NULL,
  `notification_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`notify_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'Tanuj Allam has accepted your baggage request,you can contact Tanuj Allam using the contact details appended below.','Tanuj Allam','m@gmail.com','Please call/message on: +1-9805856510 or Email me at: tallam@uncc.edu','Tue, 6 Dec 2016 07:55 PM',1);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `flightNo` varchar(100) DEFAULT NULL,
  `airlines` varchar(100) DEFAULT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `weight` varchar(50) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  `datePosted` varchar(100) DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'hey ! I have this baggage space..','BB1265','Blue Bird Airways','tallam@uncc.edu','9','Rajiv Gandhi International Airport-Hyderabad','Charlotte Douglas International Airport-Charlotte','12/14/2016','Tue, 6 Dec 2016 07:17 PM','Tanuj Allam'),(2,'Hey ! I have this much baggage space.','KP1243','Kingfisher Air Service','vandana@uncc.edu','12','Bandaranaike International Airport-Colombo','Logan International Airport-Boston','12/29/2016','Tue, 6 Dec 2016 07:23 PM','Vandana Nayakanti'),(3,'Hye I have this bbagge space','QR123','Qatar Airways','m@gmail.com','21','Rajiv Gandhi International Airport-Hyderabad','Chaghcharan Airport-Chaghcharan','12/14/2016','Tue, 6 Dec 2016 07:54 PM','Madhuroima Doppal');
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `countrycode` varchar(10) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `passport` varchar(100) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Tanuj','Allam','tallam@uncc.edu','+1','9805856510','L65325','204,Barton Creek Dr Apt H,Charlotte,Nc 28262','qwerty123'),(13,'Vandana','Nayakanti','vandana@uncc.edu','+1','9986598647','L234567','204 Barton Creek Dr Apartment H','asatvm34'),(14,'Vidyasagar','k','k.vidyasagar948@gmail.com','+1','8745961230','l6543','204 Barton Creek Dr Apartment H','qwerty123'),(15,'Varshini','Gouri','varshini@uncc.edu','+1','9912341234','L542361','204 Barton Creek Dr Apartment H','Asatvm34'),(16,'Deepthi','reddy','d@gmail.com','+1','3037630809','L533424','8-44 Hyderabad','Mbalamani28$'),(17,'Madhuroima','Doppal','m@gmail.com','+1','9987546123','L23415623','204 Barton Creek Dr Apartment H','qwerty123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-06 12:36:49
