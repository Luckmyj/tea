/*
Navicat MySQL Data Transfer

Source Server         : zy101
Source Server Version : 50719
Source Host           : 47.94.18.152:3306
Source Database       : tea_grading

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-10-02 10:45:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tea_message
-- ----------------------------
DROP TABLE IF EXISTS `tea_message`;
CREATE TABLE `tea_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `shape` double unsigned NOT NULL,
  `colour` double unsigned NOT NULL,
  `neatness` double unsigned NOT NULL,
  `fragrance` double unsigned NOT NULL,
  `liquor_color` double unsigned NOT NULL,
  `taste` double unsigned NOT NULL,
  `infused_leaf` double unsigned NOT NULL,
  `grading` varchar(10),
  `status` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `current` timestamp not null default current_timestamp,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tea_message
-- ----------------------------

create table user(
id int unsigned primary key auto_increment,
phone varchar(20) not null,
`current` timestamp not null default current_timestamp
)
