drop database if exists xuetao;

/*==============================================================*/
/* Database: womiga                                             */
/*==============================================================*/
create database xuetao;

use xuetao;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2014/3/16 21:38:52                           */
/*==============================================================*/



drop table if exists Good_Comment;

drop table if exists Member;

drop table if exists Party;

drop table if exists good;

drop table if exists good_pic;

drop table if exists school;

drop table if exists category;

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   id                   int not null auto_increment,
   name                 varchar(100) not null comment '名称',
   parentId             int not null default 0 comment '父类id',
   remark               varchar(200) comment '备注',
   orderid				int(11) NOT NULL DEFAULT '0',
   statu                int not null default 0 comment '状态 0 有效 1删除 ',
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Good_Comment                                          */
/*==============================================================*/

create table Good_Comment
(
   id                   int not null auto_increment,
   member_id            int not null,
   good_id              int not null,
   content              text not null,
   statu                int not null default 0,
   create_time          timestamp not null,
   reply_member_id		int ,
   is_reply             int not null default 0,
   reply_content        text,
   reply_time          timestamp not null,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Member                                                */
/*==============================================================*/
create table Member
(
   id                   int not null auto_increment,
   name                 varchar(50) not null,
   password             varchar(200) not null,
   update_time          timestamp,
   sex                  varchar(2),
   school_id            int not null,
   party_join_sum       int not null default 0 comment '参加的次数',
   photo                varchar(200),
   description          text,
   phone                varchar(20),
   points               int not null default 0,
   reputation           int not null default 0 comment '信誉',
   success_sum          int not null default 0 comment '交换成功次数',
   fail_sum             int not null default 0 comment '交换失败测试',
   party_create_sum     int not null default 0 comment '组织的次数',
   major                varchar(50) comment '专业',
   email                varchar(50) not null,
   create_time          timestamp not null,
   roleid               int not null default 0,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: Party                                                 */
/*==============================================================*/
create table Party
(
   id                   int not null auto_increment,
   member_id            int not null,
   title                varchar(500) not null comment '标题',
   description          text not null comment '内容',
   start_time           timestamp not null comment '开始时间',
   end_time             timestamp not null comment '结束时间',
   state                int not null default 0 comment '状态',
   create_time          timestamp not null comment '创建时间',
   update_time          timestamp comment '更新时间',
   icon                 varchar(200) comment 'Logo',
   school_ids           text comment '允许学校id 集合  为空 就是全部',
   join_sum             int comment '参加人数',
   max_sum              int comment '限制人数',
   ponit                int default 5 comment '奖励积分',
   join_member_ids      text comment '参加用户ids ',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: good                                                  */
/*==============================================================*/
create table good
(
   id                   int not null auto_increment,
   category_id          int not null,
   name                 varchar(50) not null,
   title                varchar(100),
   description          text,
   level                int not null,
   price                int comment '0',
   create_time          timestamp not null,
   update_time          timestamp not null,
   member_id            int not null,
   statu                int not null default 0,
   logo                 varchar(100) comment '缩图logo',
   click_sum            int not null default 0 comment '点击次数',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: good_pic                                              */
/*==============================================================*/
create table good_pic
(
   id                   int not null auto_increment,
   good_id              int not null,
   path                 varchar(100) not null,
   statu                int not null default 0,
   description          text,
   title                varchar(50),
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: school                                                */
/*==============================================================*/
create table school
(
   id                   int not null auto_increment,
   name                 varchar(50) not null comment '学校名称',
   email                varchar(50) not null comment '有效',
   statu                int not null comment '状态',
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*==============================================================*/
/* Table: auth                                                  */
/*==============================================================*/
create table auth
(
   authid               int(11) not null auto_increment,
   authcode             varchar(50) not null,
   primary key (authid)
)
ENGINE=InnoDB  DEFAULT CHARSET=utf8;



/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   roleid               int(11) not null auto_increment,
   name                 varchar(50) not null,
   statu                int(11) not null,
   primary key (roleid)
)
ENGINE=InnoDB  DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: roleauth                                              */
/*==============================================================*/
create table roleauth
(
   id                   int(11) not null auto_increment,
   roleid               int(11) not null,
   authid               int(11) not null,
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table good_comment_sub
(
   id                   int not null auto_increment,
   member_id            int not null,
   comment_id           int not null,
   content              text not null,
   statu                int not null default 0,
   create_time          timestamp not null,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;