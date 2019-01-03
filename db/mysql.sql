-- 用户表
drop table `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` varchar(100) NOT NULL,
  `username` varchar(50) COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `create_time` datetime COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- 用户Token表
drop table `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` varchar(100) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime COMMENT '过期时间',
  `update_time` datetime COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- 账号：13612345678  密码：admin
INSERT INTO `tb_user` (`user_id`,`username`, `mobile`, `password`, `create_time`) VALUES ('dfas21324231', 'mark', '13612345678', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2017-03-23 22:37:41');

-- 设备信息
drop table `tb_device`;
CREATE TABLE `tb_device` (
  `device_id` varchar(100) NOT NULL,
  `device_token` varchar(100) NOT NULL COMMENT '设备唯一码',
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备信息表';

-- 设备信息
drop table `tb_user_device`;
CREATE TABLE `tb_user_device` (
  `user_device_id` varchar(100) NOT NULL ,
  `user_id` varchar(100) COMMENT '用户ID',
  `device_id` varchar(100) COMMENT '设备唯一码',
  PRIMARY KEY (`user_device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户设备关系表';
