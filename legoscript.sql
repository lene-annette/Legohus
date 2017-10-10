create table users (
	u_id integer not null auto_increment,
    email varchar(45) not null,
    u_name varchar(45) not null,
    u_type enum('user','employee') not null,
    primary key (u_id)
    
);

create table orders (
	o_id integer not null auto_increment,
    length integer not null,
    width integer not null,
    height integer not null,
    orderdate date,
    dispatchdate date,
    u_id integer not null,
    primary key (o_id),
    constraint id foreign key(u_id) references users(u_id)
    
);