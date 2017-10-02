create table my_first_table (
  id bigint not null auto_increment,
  name varchar(255) not null,
  createdAt datetime not null default now(),
  primary key(id)
)