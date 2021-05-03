/*
 Navicat Premium Data Transfer

 Source Server         : tv-sales-dev
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : vps-5785f290.vps.ovh.ca:3306
 Source Schema         : product

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 29/04/2021 21:14:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DATABASECHANGELOG
-- ----------------------------
DROP TABLE IF EXISTS `DATABASECHANGELOG`;
CREATE TABLE `DATABASECHANGELOG` (
                                     `ID` varchar(255) NOT NULL,
                                     `AUTHOR` varchar(255) NOT NULL,
                                     `FILENAME` varchar(255) NOT NULL,
                                     `DATEEXECUTED` datetime NOT NULL,
                                     `ORDEREXECUTED` int NOT NULL,
                                     `EXECTYPE` varchar(10) NOT NULL,
                                     `MD5SUM` varchar(35) DEFAULT NULL,
                                     `DESCRIPTION` varchar(255) DEFAULT NULL,
                                     `COMMENTS` varchar(255) DEFAULT NULL,
                                     `TAG` varchar(255) DEFAULT NULL,
                                     `LIQUIBASE` varchar(20) DEFAULT NULL,
                                     `CONTEXTS` varchar(255) DEFAULT NULL,
                                     `LABELS` varchar(255) DEFAULT NULL,
                                     `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for DATABASECHANGELOGLOCK
-- ----------------------------
DROP TABLE IF EXISTS `DATABASECHANGELOGLOCK`;
CREATE TABLE `DATABASECHANGELOGLOCK` (
                                         `ID` int NOT NULL,
                                         `LOCKED` bit(1) NOT NULL,
                                         `LOCKGRANTED` datetime DEFAULT NULL,
                                         `LOCKEDBY` varchar(255) DEFAULT NULL,
                                         PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for campaign
-- ----------------------------
DROP TABLE IF EXISTS `campaign`;
CREATE TABLE `campaign` (
                            `id` bigint NOT NULL,
                            `title` varchar(255) DEFAULT NULL,
                            `base_product_quantity` int DEFAULT NULL,
                            `discount` double DEFAULT NULL,
                            `discount_type_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_campaign_discount_type_id` (`discount_type_id`),
                            CONSTRAINT `fk_campaign_discount_type_id` FOREIGN KEY (`discount_type_id`) REFERENCES `discount_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
                        `id` bigint NOT NULL,
                        `cart_state_id` bigint DEFAULT NULL,
                        `user_id` varchar(100) DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `fk_cart_cart_state_id` (`cart_state_id`),
                        KEY `fk_cart_user_id` (`user_id`),
                        CONSTRAINT `fk_cart_cart_state_id` FOREIGN KEY (`cart_state_id`) REFERENCES `cart_state` (`id`),
                        CONSTRAINT `fk_cart_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for cart_product
-- ----------------------------
DROP TABLE IF EXISTS `cart_product`;
CREATE TABLE `cart_product` (
                                `id` bigint NOT NULL,
                                `quantity` int NOT NULL,
                                `cart_id` bigint DEFAULT NULL,
                                `product_id` bigint DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                KEY `fk_cart_product_cart_id` (`cart_id`),
                                KEY `fk_cart_product_product_id` (`product_id`),
                                CONSTRAINT `fk_cart_product_cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
                                CONSTRAINT `fk_cart_product_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for cart_state
-- ----------------------------
DROP TABLE IF EXISTS `cart_state`;
CREATE TABLE `cart_state` (
                              `id` bigint NOT NULL,
                              `title` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                            `id` bigint NOT NULL,
                            `title` varchar(255) DEFAULT NULL,
                            `parent_category_id` bigint DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_category_parent_category_id` (`parent_category_id`),
                            CONSTRAINT `fk_category_parent_category_id` FOREIGN KEY (`parent_category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
                          `id` bigint NOT NULL,
                          `title` varchar(255) DEFAULT NULL,
                          `code` varchar(255) DEFAULT NULL,
                          `minimum_amount` double DEFAULT NULL,
                          `discount_type_id` bigint DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_coupon_discount_type_id` (`discount_type_id`),
                          CONSTRAINT `fk_coupon_discount_type_id` FOREIGN KEY (`discount_type_id`) REFERENCES `discount_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for discount_type
-- ----------------------------
DROP TABLE IF EXISTS `discount_type`;
CREATE TABLE `discount_type` (
                                 `id` bigint NOT NULL,
                                 `title` varchar(255) DEFAULT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for jhi_authority
-- ----------------------------
DROP TABLE IF EXISTS `jhi_authority`;
CREATE TABLE `jhi_authority` (
                                 `name` varchar(50) NOT NULL,
                                 PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for jhi_persistent_audit_event
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
CREATE TABLE `jhi_persistent_audit_event` (
                                              `event_id` bigint NOT NULL,
                                              `principal` varchar(50) NOT NULL,
                                              `event_date` timestamp NULL DEFAULT NULL,
                                              `event_type` varchar(255) DEFAULT NULL,
                                              PRIMARY KEY (`event_id`),
                                              KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for jhi_persistent_audit_evt_data
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
CREATE TABLE `jhi_persistent_audit_evt_data` (
                                                 `event_id` bigint NOT NULL,
                                                 `name` varchar(150) NOT NULL,
                                                 `value` varchar(255) DEFAULT NULL,
                                                 PRIMARY KEY (`event_id`,`name`),
                                                 KEY `idx_persistent_audit_evt_data` (`event_id`),
                                                 CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for jhi_user
-- ----------------------------
DROP TABLE IF EXISTS `jhi_user`;
CREATE TABLE `jhi_user` (
                            `id` varchar(100) NOT NULL,
                            `login` varchar(50) NOT NULL,
                            `first_name` varchar(50) DEFAULT NULL,
                            `last_name` varchar(50) DEFAULT NULL,
                            `email` varchar(191) DEFAULT NULL,
                            `image_url` varchar(256) DEFAULT NULL,
                            `activated` bit(1) NOT NULL,
                            `lang_key` varchar(10) DEFAULT NULL,
                            `created_by` varchar(50) NOT NULL,
                            `created_date` timestamp NULL DEFAULT NULL,
                            `last_modified_by` varchar(50) DEFAULT NULL,
                            `last_modified_date` timestamp NULL DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_user_login` (`login`),
                            UNIQUE KEY `ux_user_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for jhi_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `jhi_user_authority`;
CREATE TABLE `jhi_user_authority` (
                                      `user_id` varchar(100) NOT NULL,
                                      `authority_name` varchar(50) NOT NULL,
                                      PRIMARY KEY (`user_id`,`authority_name`),
                                      KEY `fk_authority_name` (`authority_name`),
                                      CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
                                      CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
                           `id` bigint NOT NULL,
                           `title` varchar(255) DEFAULT NULL,
                           `price` double DEFAULT NULL,
                           `category_id` bigint DEFAULT NULL,
                           `cart_id` bigint DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `fk_product_category_id` (`category_id`),
                           KEY `fk_product_cart_id` (`cart_id`),
                           CONSTRAINT `fk_product_cart_id` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
                           CONSTRAINT `fk_product_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SET FOREIGN_KEY_CHECKS = 1;
