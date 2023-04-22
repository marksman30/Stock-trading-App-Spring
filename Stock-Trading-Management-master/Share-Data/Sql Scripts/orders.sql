use stockuser;
-- orderPrice decimal(10,2) not null
create table orders (
id integer not null,
user_id Integer not null,
share_id Integer not null,
quantity integer not null,
foreign key(user_id) references register(userid),
foreign key(share_id) references share(id)
);

alter table orders change orderPrice orderprice varchar(50);

select * from orders;

alter table orders add primary key(id);

drop table orders;

create table orders (
orderid integer primary key auto_increment not null,
orderName varchar(50) not null,
orderPrice decimal(10,2) not null,
quantity integer not null,
category varchar(20) not null
);
