# 河工大博士考试初试成绩查询系统使用说明

## 1、修改数据库密码为本机的数据库密码

- 在`application.properties`中修改（目录如下图）（解压缩war包可见到类似目录）
- ![1553868833900](C:\Users\卢华源\AppData\Roaming\Typora\typora-user-images\1553868833900.png)

- 内容如右图：修改password![1553868915139](C:\Users\卢华源\AppData\Roaming\Typora\typora-user-images\1553868915139.png)

- 在`myabtis-config.xml`中的数据连接池也修改数据库密码

  ![1553869393394](C:\Users\卢华源\AppData\Roaming\Typora\typora-user-images\1553869393394.png)

## 2、将数据库脚本（下列出）执行以生成数据库

## 数据库脚本

```sql
/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.7.18 : Database - springboot_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`springboot_demo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `springboot_demo`;

/*Table structure for table `infotest` */

DROP TABLE IF EXISTS `infotest`;

CREATE TABLE `infotest` (
  `test_id` varchar(64) COLLATE utf8_bin NOT NULL,
  `person_id` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `majorOfApply` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `institueOfApply` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `foreignLanguage` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `firstCourse` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `secondCourse` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `total` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `infotest` */

insert  into `infotest`(`test_id`,`person_id`,`name`,`majorOfApply`,`institueOfApply`,`foreignLanguage`,`firstCourse`,`secondCourse`,`total`) values 
('2','2','2','2','2','2','2','2','2'),
('5','5','5','5','5','5','5','5','5'),
('6','6','6','6','6','6','6','6','6'),
('8','8','8','8','8','8','8','8','8');

```

## 3、使用说明

> 前提是已将war包部署到tomcat（或其他）服务器下

- 输入`服务器地址+/war包名/uploadAndDownload/index`可以上传**根据模板填写**的数据
- 输入`服务器地址+/war包名/search`可以作为查询页面

## 4、 所需文件下载地址

- `https://stuhauteducn-my.sharepoint.com/:f:/g/personal/lhypersonmail_stu_haut_edu_cn/EqdDRAH92uxNo6MAcnMOx1sBhktdtnQ-aldesqrtxHtCNA?e=aCepUg`

- 或者

  `链接：https://pan.baidu.com/s/1qkJ8LasK9qUEwFopXkuuNA 
  提取码：pf8j 
  复制这段内容后打开百度网盘手机App，操作更方便哦`
