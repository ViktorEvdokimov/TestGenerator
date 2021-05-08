-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: groups_and_persons
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groups` (
  `id_groups` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_groups`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,'Разработчики'),(2,'Тестировщики'),(3,'DevOps'),(4,'Архитекторы'),(5,'TeamLeads'),(6,'Дизайнеры'),(7,'Маркетологи'),(8,'Менеджеры'),(9,'Бухгалтерия'),(10,'Отдел кадров'),(11,'Охрана труда'),(12,'Инженеры'),(13,'Схемотехники'),(14,'Продукт менеджеры'),(15,'Проджект менеджеры'),(16,'Обслуживающий персонал'),(17,'Системные одминистраторы'),(18,'Аудиторы'),(19,'Инженеры по качеству'),(20,'Охрана'),(21,'Лаборанты'),(22,'Технологи'),(23,'Операторы'),(24,'Технички'),(25,'Юристы'),(26,'Механики'),(27,'Социологи'),(28,'Оценщики'),(29,'Психологи'),(30,'Техники'),(31,'Наставники'),(32,'Товароведы'),(33,'Художники'),(34,'Экономисты по планированию');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `man_first_name`
--

DROP TABLE IF EXISTS `man_first_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `man_first_name` (
  `id_first_Name` int NOT NULL AUTO_INCREMENT,
  `man_first_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_first_Name`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `man_first_name`
--

LOCK TABLES `man_first_name` WRITE;
/*!40000 ALTER TABLE `man_first_name` DISABLE KEYS */;
INSERT INTO `man_first_name` VALUES (1,'Абрам'),(2,'Аваз'),(3,'Аввакум'),(4,'Август'),(5,'Авдей'),(6,'Авраам'),(7,'Автандил'),(8,'Агап'),(9,'Агафон'),(10,'Аггей'),(11,'Адис'),(12,'Адольф'),(13,'Азарий'),(14,'Азат'),(15,'Айнур'),(16,'Акакий'),(17,'Александр'),(18,'Алексей'),(19,'Алмаз'),(20,'Анатолий'),(21,'Ануфрий'),(22,'Антон'),(23,'Геннадий'),(24,'Георгий'),(25,'Геральд'),(26,'Глеб'),(27,'Даниил'),(28,'Демьян'),(29,'Дмитрий'),(30,'Динар'),(31,'Донатос'),(32,'Евграф'),(33,'Евгений'),(34,'Захар'),(35,'Иван'),(36,'Игорь');
/*!40000 ALTER TABLE `man_first_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `man_last_name`
--

DROP TABLE IF EXISTS `man_last_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `man_last_name` (
  `id_man_last_name` int NOT NULL AUTO_INCREMENT,
  `man_last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_man_last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `man_last_name`
--

LOCK TABLES `man_last_name` WRITE;
/*!40000 ALTER TABLE `man_last_name` DISABLE KEYS */;
INSERT INTO `man_last_name` VALUES (1,'Смирнов'),(2,'Иванов'),(3,'Кузнецов'),(4,'Соколов'),(5,'Попов'),(6,'Лебедев'),(7,'Козлов'),(8,'Новиков'),(9,'Морозов'),(10,'Петров'),(11,'Волков'),(12,'Соловьёв'),(13,'Васильев'),(14,'Зайцев'),(15,'Павлов'),(16,'Семёнов'),(17,'Голубев'),(18,'Виноградов'),(19,'Богданов'),(20,'Воробьёв'),(21,'Фёдоров'),(22,'Тарасов'),(23,'Белов'),(24,'Комаров'),(25,'Орлов'),(26,'Киселёв'),(27,'Макаров'),(28,'Андреев'),(29,'Ковалёв'),(30,'Лазарев'),(31,'Медведев'),(32,'Ершов'),(33,'Никитин'),(34,'Соболев'),(35,'Рябов'),(36,'Поляков'),(37,'Цветков'),(38,'Данилов'),(39,'Жуков'),(40,'Фролов'),(41,'Журавлёв'),(42,'Николаев'),(43,'Максимов');
/*!40000 ALTER TABLE `man_last_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `man_patronymic`
--

DROP TABLE IF EXISTS `man_patronymic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `man_patronymic` (
  `id_man_patronymic` int NOT NULL AUTO_INCREMENT,
  `man_patronymic` varchar(45) NOT NULL,
  PRIMARY KEY (`id_man_patronymic`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `man_patronymic`
--

LOCK TABLES `man_patronymic` WRITE;
/*!40000 ALTER TABLE `man_patronymic` DISABLE KEYS */;
INSERT INTO `man_patronymic` VALUES (1,'Александрович'),(2,'Львович'),(3,'Ларионович'),(4,'Ларионович'),(5,'Лукич'),(6,'Любомирович'),(7,'Мануилович'),(8,'Маринович'),(9,'Маркелович'),(10,'Милиевич'),(11,'Несторович'),(12,'Никонович'),(13,'Никифорович'),(14,'Натанович'),(15,'Гавриилович'),(16,'Гедеонович'),(17,'Герасимович'),(18,'Гиацинтович'),(19,'Давидович'),(20,'Денисович'),(21,'Димитриевич'),(22,'Диомидович'),(23,'Евграфович'),(24,'Евстратович'),(25,'Егорович'),(26,'Егориевич'),(27,'Ермиевич'),(28,'Ермолаевич'),(29,'Ефимиевич'),(30,'Святополкович'),(31,'Северинович'),(32,'Сергеевич'),(33,'Силантиевич'),(34,'Созонтиевич');
/*!40000 ALTER TABLE `man_patronymic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `street` (
  `id_street` int NOT NULL AUTO_INCREMENT,
  `street` varchar(45) NOT NULL,
  PRIMARY KEY (`id_street`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'10-й Лобинский переулок'),(2,'улица 10-я'),(3,'улица 20-я'),(4,'6 аллея'),(5,'улица 50 лет ВЛКСМ'),(6,'улица 40-летия Октября'),(7,'улица 40-летия Победы'),(8,'9-й Бульварный переулок'),(9,'улица 60-летия Октября'),(10,'Абрикосовая улица'),(11,'улица Багратиона'),(12,'Валдайская улица'),(13,'Евпаторийская улица'),(14,'проспект Давыдова'),(15,'улица Габдуллы Тукая'),(16,'улица Жаворонкова'),(17,'улица Завалишина'),(18,'улица Игнатия Вандышева'),(19,'Магистральный переулок'),(20,'Лавандовая улица'),(21,'Кавказская улица'),(22,'Елочная улица'),(23,'Набережная улица'),(24,'улица Павлова'),(25,'Кадиевская улица'),(26,'Магнитогорская улица');
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `woman_first_name`
--

DROP TABLE IF EXISTS `woman_first_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `woman_first_name` (
  `id_woman_first_name` int NOT NULL AUTO_INCREMENT,
  `woman_first_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_woman_first_name`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `woman_first_name`
--

LOCK TABLES `woman_first_name` WRITE;
/*!40000 ALTER TABLE `woman_first_name` DISABLE KEYS */;
INSERT INTO `woman_first_name` VALUES (1,'Августа'),(2,'Агата'),(3,'Аглая'),(4,'Аделина'),(5,'Адель'),(6,'Азалия'),(7,'Аксинья'),(8,'Алена'),(9,'Алина'),(10,'Алла'),(11,'Анна'),(12,'Валентина'),(13,'Василина'),(14,'Вероника'),(15,'Изольда'),(16,'Инара'),(17,'Инна'),(18,'Ирина'),(19,'Искра'),(20,'Камилла'),(21,'Кира'),(22,'Катарина'),(23,'Корнелия'),(24,'Кристина'),(25,'Рита'),(26,'Роза'),(27,'Полина'),(28,'Павла'),(29,'Регина'),(30,'Эля'),(31,'Эрика');
/*!40000 ALTER TABLE `woman_first_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `woman_last_name`
--

DROP TABLE IF EXISTS `woman_last_name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `woman_last_name` (
  `id_woman_last_name` int NOT NULL AUTO_INCREMENT,
  `woman_last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_woman_last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `woman_last_name`
--

LOCK TABLES `woman_last_name` WRITE;
/*!40000 ALTER TABLE `woman_last_name` DISABLE KEYS */;
INSERT INTO `woman_last_name` VALUES (1,'Иванова'),(2,'Смирнова'),(3,'Кузнецова'),(4,'Попова'),(5,'Васильева'),(6,'Петрова'),(7,'Соколова'),(8,'Михайлова'),(9,'Новикова'),(10,'Фёдорова'),(11,'Морозова'),(12,'Алексеева'),(13,'Волкова'),(14,'Лебедева'),(15,'Семёнова'),(16,'Егорова'),(17,'Павлова'),(18,'Козлова'),(19,'Степанова'),(20,'Николаева');
/*!40000 ALTER TABLE `woman_last_name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `woman_patronymic`
--

DROP TABLE IF EXISTS `woman_patronymic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `woman_patronymic` (
  `id_woman_patronymic` int NOT NULL AUTO_INCREMENT,
  `woman_patronymic` varchar(45) NOT NULL,
  PRIMARY KEY (`id_woman_patronymic`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `woman_patronymic`
--

LOCK TABLES `woman_patronymic` WRITE;
/*!40000 ALTER TABLE `woman_patronymic` DISABLE KEYS */;
INSERT INTO `woman_patronymic` VALUES (1,'Анатольевна '),(2,'Андреевна '),(3,'Антоновна '),(4,'Аркадьевна '),(5,'Валентиновна '),(6,'Валерьевна '),(7,'Викторовна '),(8,'Владиславовна '),(9,'Геннадиевна '),(10,'Георгиевна '),(11,'Григорьевна '),(12,'Денисовна '),(13,'Дмитриевна '),(14,'Евгеньевна '),(15,'Егоровна '),(16,'Ефимовна '),(17,'Ивановна '),(18,'Игоревна '),(19,'Ильинична '),(20,'Кирилловна '),(21,'Константиновна '),(22,'Леонидовна '),(23,'Львовна '),(24,'Максимовна '),(25,'Матвеевна '),(26,'Михайловна '),(27,'Олеговна '),(28,'Павловна '),(29,'Платоновна '),(30,'Робертовна '),(31,'Семеновна '),(32,'Станиславовна '),(33,'Тимофеевна ');
/*!40000 ALTER TABLE `woman_patronymic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-08 15:58:20
