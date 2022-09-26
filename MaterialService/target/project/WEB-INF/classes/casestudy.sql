-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.47-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for casestudy
CREATE DATABASE IF NOT EXISTS `casestudy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `casestudy`;


-- Dumping structure for table casestudy.material_category
CREATE TABLE IF NOT EXISTS `material_category` (
  `category_id` varchar(255) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table casestudy.material_category: ~3 rows (approximately)
/*!40000 ALTER TABLE `material_category` DISABLE KEYS */;
INSERT INTO `material_category` (`category_id`, `category_name`) VALUES
	('C001', 'Thread'),
	('C002', 'Cloth'),
	('C003', 'Button');
/*!40000 ALTER TABLE `material_category` ENABLE KEYS */;


-- Dumping structure for table casestudy.material_type
CREATE TABLE IF NOT EXISTS `material_type` (
  `type_id` varchar(50) NOT NULL,
  `type_name` varchar(50) DEFAULT NULL,
  `category_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  KEY `FK_material_type_material_category` (`category_id`),
  CONSTRAINT `FK_material_type_material_category` FOREIGN KEY (`category_id`) REFERENCES `material_category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table casestudy.material_type: ~6 rows (approximately)
/*!40000 ALTER TABLE `material_type` DISABLE KEYS */;
INSERT INTO `material_type` (`type_id`, `type_name`, `category_id`) VALUES
	('T001', 'Silk', 'C001'),
	('T002', 'Silk', 'C002'),
	('T004', 'Linen', 'C002'),
	('T005', 'Silk Cotton', 'C003'),
	('T006', 'Suit', 'C003'),
	('T007', 'Silk Cotton', 'C002');
/*!40000 ALTER TABLE `material_type` ENABLE KEYS */;


-- Dumping structure for table casestudy.unit
CREATE TABLE IF NOT EXISTS `unit` (
  `unit_Id` varchar(50) NOT NULL,
  `unit_name` varchar(50) DEFAULT NULL,
  `category_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`unit_Id`),
  KEY `FK_unit_material_category` (`category_id`),
  CONSTRAINT `FK_unit_material_category` FOREIGN KEY (`category_id`) REFERENCES `material_category` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table casestudy.unit: ~5 rows (approximately)
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` (`unit_Id`, `unit_name`, `category_id`) VALUES
	('U001', 'Metres', 'C001'),
	('U002', 'Metres', 'C002'),
	('U003', 'Yards', 'C001'),
	('U004', 'Yards', 'C002'),
	('U005', 'Kilograms', 'C003');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
