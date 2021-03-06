create table `users` (
	`u_id` integer not null auto_increment,
    `email` varchar(45) not null,
    `u_name` varchar(45) not null,
    `password` varchar(45) not null,
    `u_type` enum('customer','employee') not null,
    primary key (`u_id`),
    unique key `email unique` (`email`)
    
);

create table  `orders`(
	`o_id` integer not null auto_increment,
    `length` integer not null,
    `width` integer not null,
    `height` integer not null,
    `orderdate` date,
    `dispatchdate` date,
    `u_id` integer not null,
    primary key (`o_id`),
    constraint `id` foreign key(`u_id`) references `users`(`u_id`)
    
);

-- drop table orders;
-- drop table users;

insert into `users` (`email`,`u_name`,`password`,`u_type`) values ('lene@mail.dk','Lene S','1234','employee');
insert into `users` (`email`,`u_name`,`password`,`u_type`) values ('john@gmail.com','John D','password','customer');
insert into `orders` (`length`,`width`,`height`,`orderdate`,`u_id`) values (13,9,4,'2017-10-12',3);

select * from `users`;
select * from `orders`;

select u_id, u_name, u_type from users where email='lene@mail.dk' and password='1234';

update orders set dispatchdate='2017-10-13' where o_id=1;
