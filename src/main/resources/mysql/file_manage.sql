/*
Navicat MySQL Data Transfer

Source Server         : Ubuntu
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : file_manage

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-18 18:26:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file_block
-- ----------------------------
DROP TABLE IF EXISTS `file_block`;
CREATE TABLE `file_block` (
  `file_id` varchar(38) NOT NULL COMMENT '分块儿对应文件id',
  `file_md5` varchar(38) DEFAULT NULL COMMENT '文件MD5',
  `chunk` int(18) DEFAULT NULL COMMENT '文件分块下标',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for file_in_server
-- ----------------------------
DROP TABLE IF EXISTS `file_in_server`;
CREATE TABLE `file_in_server` (
  `object_id` varchar(38) NOT NULL,
  `md5` varchar(38) DEFAULT NULL COMMENT '文件MD5',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `file_size` varchar(38) DEFAULT NULL COMMENT '文件大小，单位KB',
  `file_type` varchar(18) DEFAULT NULL COMMENT '文件格式',
  `file_path` varchar(512) DEFAULT NULL COMMENT '文件存储路径',
  `last_modified_date` datetime(3) DEFAULT NULL COMMENT '文件最后修改时间',
  `create_user` varchar(50) DEFAULT NULL COMMENT '文件存储人',
  `create_time` datetime DEFAULT NULL COMMENT '文件存储时间',
  `modify_user` varchar(50) DEFAULT NULL COMMENT '文件修改人',
  `modify_time` datetime DEFAULT NULL COMMENT '文件修改时间',
  `active` int(1) DEFAULT '1' COMMENT '删除标识：1存在，0删除',
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
