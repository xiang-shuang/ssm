-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jcsd
--

CREATE DATABASE IF NOT EXISTS jcsd;
USE jcsd;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL auto_increment COMMENT '管理员的编号',
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `pass` varchar(36) NOT NULL COMMENT '密码',
  `atype` varchar(8) NOT NULL COMMENT '用户类型1代表管理员，2代码考研室，3代码单位负责人',
  `phone` varchar(12) NOT NULL COMMENT '电话',
  `email` varchar(45) NOT NULL COMMENT 'email',
  `qq` varchar(10) NOT NULL COMMENT 'qq',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用于存放管理信息';

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment COMMENT '教材类别编号',
  `name` varchar(50) default NULL COMMENT '教材类别名称',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用于存入教材类别; InnoDB free: 3072 kB';

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`,`name`,`create_time`,`update_time`) VALUES 
 (1,'A.面向21世纪课程教材','0000-00-00 00:00:00','0000-00-00 00:00:00'),
 (2,'B.教育部推荐教材','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `classse`
--

DROP TABLE IF EXISTS `classse`;
CREATE TABLE `classse` (
  `id` int(11) NOT NULL auto_increment COMMENT '班级编号',
  `name` varchar(50) default NULL COMMENT '班级名称',
  `major_id` int(11) default NULL COMMENT '班级专业',
  `major_name` varchar(20) default NULL COMMENT '专业名称',
  `student_number` int(11) default NULL COMMENT '班级学生人数',
  `create_time` datetime NOT NULL COMMENT '班级创建时间',
  `update_time` datetime NOT NULL COMMENT '班级最后更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用于存放班级信息';

--
-- Dumping data for table `classse`
--

/*!40000 ALTER TABLE `classse` DISABLE KEYS */;
INSERT INTO `classse` (`id`,`name`,`major_id`,`major_name`,`student_number`,`create_time`,`update_time`) VALUES 
 (1,'17级',1,NULL,38,'0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `classse` ENABLE KEYS */;


--
-- Definition of table `course`
--

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL auto_increment COMMENT '课程编号',
  `code` varchar(8) default NULL COMMENT '课程代码',
  `name` varchar(20) default NULL COMMENT '课程名称',
  `period` int(11) default NULL COMMENT '课时',
  `Nature` varchar(20) default NULL COMMENT '课程类型',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '最后更新时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用于保课程的信息; InnoDB free: 3072 kB';

--
-- Dumping data for table `course`
--

/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`,`code`,`name`,`period`,`Nature`,`create_time`,`update_time`) VALUES 
 (1,'0100','j2e企业开发',64,'选修','0000-00-00 00:00:00',NULL),
 (2,'0101','java程序设计',80,'必修',NULL,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


--
-- Definition of table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL auto_increment COMMENT '部门号',
  `name` varchar(50) default NULL COMMENT '部门名称',
  `d_manager` varchar(16) NOT NULL COMMENT '部门负责人',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用于存入部门信息';

--
-- Dumping data for table `department`
--

/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`id`,`name`,`d_manager`,`create_time`,`update_time`) VALUES 
 (1,'计信学院','','0000-00-00 00:00:00','0000-00-00 00:00:00'),
 (2,'体育学院','','0000-00-00 00:00:00','0000-00-00 00:00:00'),
 (3,'数统学院','','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


--
-- Definition of table `jc`
--

DROP TABLE IF EXISTS `jc`;
CREATE TABLE `jc` (
  `id` int(11) NOT NULL auto_increment COMMENT '教材编号',
  `name` varchar(50) default NULL COMMENT '教材名称',
  `isbn` varchar(20) default NULL COMMENT '教材书号',
  `author` varchar(20) default NULL COMMENT '作者',
  `publisher_id` int(11) default NULL COMMENT '出版社',
  `price` double default NULL COMMENT '价格',
  `pubdate` datetime default NULL COMMENT '开课时间',
  `category_id` int(11) default NULL COMMENT '专业编号',
  `major_text` varchar(50) default NULL COMMENT '使用专业',
  `classse_id` int(11) unsigned NOT NULL COMMENT '班级编号',
  `classse_text` varchar(50) default NULL COMMENT '使用班级',
  `levels_id` int(11) default NULL COMMENT '层次',
  `k_overview` text COMMENT 'a到J不用写原因',
  `depart_opinion` text COMMENT '部门审核意见',
  `company_option` text COMMENT '单位审核意见',
  `course_id` int(11) default NULL COMMENT '课程编号',
  `course_name` varchar(20) default NULL COMMENT '课程名称',
  `teacher_use` int(10) default NULL COMMENT '教师用量',
  `yesorno` int(11) default NULL COMMENT '是否审核通过',
  `sd_datetime` varchar(20) default NULL COMMENT '申订日期',
  `sd_teacher` int(11) unsigned NOT NULL COMMENT '申订教师编号',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='教材信息';

--
-- Dumping data for table `jc`
--

/*!40000 ALTER TABLE `jc` DISABLE KEYS */;
INSERT INTO `jc` (`id`,`name`,`isbn`,`author`,`publisher_id`,`price`,`pubdate`,`category_id`,`major_text`,`classse_id`,`classse_text`,`levels_id`,`k_overview`,`depart_opinion`,`company_option`,`course_id`,`course_name`,`teacher_use`,`yesorno`,`sd_datetime`,`sd_teacher`,`create_time`,`update_time`) VALUES 
 (1,'java 2e教程','123456789','王刚',NULL,35.8,NULL,NULL,'',0,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `jc` ENABLE KEYS */;


--
-- Definition of table `levels`
--

DROP TABLE IF EXISTS `levels`;
CREATE TABLE `levels` (
  `id` int(11) NOT NULL auto_increment COMMENT '层次编号',
  `name` varchar(20) default NULL COMMENT '层次名称',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用于存放教材的层次';

--
-- Dumping data for table `levels`
--

/*!40000 ALTER TABLE `levels` DISABLE KEYS */;
INSERT INTO `levels` (`id`,`name`,`create_time`,`update_time`) VALUES 
 (1,'专科','0000-00-00 00:00:00','0000-00-00 00:00:00'),
 (2,'研究生','0000-00-00 00:00:00','0000-00-00 00:00:00');
/*!40000 ALTER TABLE `levels` ENABLE KEYS */;


--
-- Definition of table `major`
--

DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` int(11) NOT NULL auto_increment COMMENT '专业编号',
  `name` varchar(20) default NULL COMMENT '专业名称',
  `create_time` datetime NOT NULL,
  `update_time` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='专业';

--
-- Dumping data for table `major`
--

/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` (`id`,`name`,`create_time`,`update_time`) VALUES 
 (1,'软件工程','0000-00-00 00:00:00','');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;


--
-- Definition of table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(50) default NULL COMMENT '出版社的名称',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用于存放出版社';

--
-- Dumping data for table `publisher`
--

/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` (`id`,`name`) VALUES 
 (1,'清华大学出版社');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;


--
-- Definition of table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL auto_increment COMMENT '编号',
  `name` varchar(20) default NULL COMMENT '姓名',
  `phone` varchar(11) default NULL COMMENT '电话',
  `email` varchar(100) default NULL COMMENT 'email',
  `qq` varchar(10) default NULL COMMENT 'qq',
  `depart_id` int(11) default NULL COMMENT '所在部门',
  `depart_name` varchar(45) NOT NULL COMMENT '所在部门的名称',
  `pass` varchar(36) default NULL COMMENT '密码',
  `question` varchar(45) NOT NULL COMMENT '找回密码的问题',
  `answer` varchar(45) NOT NULL COMMENT '找回密码答案',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后更新时间',
  `utype` int(11) default '0' COMMENT '0代表普通教师，1代表教研室主任，2代表单位负责人',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用于存放教师的信息';

--
-- Dumping data for table `teacher`
--

/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`,`name`,`phone`,`email`,`qq`,`depart_id`,`depart_name`,`pass`,`question`,`answer`,`create_time`,`update_time`,`utype`) VALUES 
 (1,'teacher wang','13777835678','wang@qq.com','12813688',1,'',NULL,'','','0000-00-00 00:00:00','0000-00-00 00:00:00',0);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
