create table user
(
   user_id              bigint not null comment 'id',
   username             varchar(60) comment '用户名',
   nickname             varchar(16) comment '昵称',
   mobile               varchar(11) comment '手机',
   mail                 varchar(60) comment '邮箱',
   created_on           datetime default CURRENT_TIMESTAMP comment 'DB',
   updated_on           datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'DB',
   primary key (user_id)
);

create table user_password
(
   user_password_id     bigint not null comment 'ID',
   user_id              bigint comment '用户id',
   password             varchar(64) comment '密码',
   created_on           datetime default CURRENT_TIMESTAMP comment 'DB',
   updated_on           datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'DB',
   primary key (user_password_id)
);

create table dict
(
   dict_id              bigint not null auto_increment comment '字典ID',
   name                 varchar(32) comment '名称',
   dict_code            varchar(32) comment '字典编码',
   default_value        varchar(128) comment '默认值',
   created_on           datetime default CURRENT_TIMESTAMP comment 'DB创建时间',
   updated_on           datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'DB更新时间',
   primary key (dict_id)
);

create table dict_item
(
   dict_item_id         bigint not null auto_increment comment '字典子项ID',
   dict_id              bigint comment '字典ID',
   dict_text            varchar(32) comment '字典文本',
   dict_value           int comment '字典值',
   sorted               int comment '顺序',
   created_on           datetime default CURRENT_TIMESTAMP comment 'DB创建时间',
   updated_on           datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment 'DB更新时间',
   primary key (dict_item_id)
);