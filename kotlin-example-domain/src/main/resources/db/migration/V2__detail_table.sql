create table my_first_record_details (
  id bigint not null auto_increment,
  recordId bigint not null,
  description varchar(255) not null,
  createdAt datetime not null default now(),
  modifiedAt datetime not null default now(),
  primary key(id),
  index(recordId)
)