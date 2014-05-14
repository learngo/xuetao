
create table notification
(
   id                   int not null auto_increment,
   member_id            int not null,
   count          		int not null default 0,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table evaluate
(
   id                   int not null auto_increment,
   member_id            int not null,
   evaluate_product_type int not null,
   evaluate_product_id   int not null,
   evaluate_worth        int not null,
   content              text not null,
   statu                int not null default 0,
   create_time          timestamp not null,
   reply_count          int not null default 0,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table evaluate_comment
(
   id                   int not null auto_increment,
   member_id            int not null,
   evaluate_id          int not null,
   content              text not null,
   statu                int not null default 0,
   create_time          timestamp not null,
   primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
