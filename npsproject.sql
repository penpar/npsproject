
-- j_nps 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `j_nps` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `j_nps`;

-- 테이블 j_nps.customer 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `grade` varchar(10) NOT NULL,
  `age` int NOT NULL,
  `region` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1041 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 j_nps.customer:~8 rows (대략적) 내보내기
INSERT INTO `customer` (`id`, `name`, `gender`, `grade`, `age`, `region`, `email`) VALUES
	(39, 'John1', '남', '4', 30, '서울', 'john.doe@example.com'),
	(40, 'John2', '여', '4', 21, '인천', 'john.doe@example.com')
    
-- 테이블 j_nps.journey_nps 구조 내보내기
CREATE TABLE IF NOT EXISTS `journey_nps` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int NOT NULL,
  `journey_state` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nps_score` int NOT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `journey_nps_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 테이블 데이터 j_nps.journey_nps:~1,000 rows (대략적) 내보내기
INSERT INTO `journey_nps` (`id`, `customer_id`, `journey_state`, `nps_score`, `create_date`) VALUES
	(4, 39, '일시정지', 1, '2023-04-22 21:53:16'),
	(5, 40, '활동', 9, '2023-04-22 21:53:16');

-- 테이블 j_nps.survey_type 구조 내보내기
CREATE TABLE IF NOT EXISTS `survey_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

