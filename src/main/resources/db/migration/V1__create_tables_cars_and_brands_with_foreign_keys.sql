create table brands(
    id int primary key auto_increment,
    name varchar(30) not null,
    production_brand_year datetime
);

create table cars(
    id int primary key auto_increment,
    name varchar(30) not null,
    production_year datetime,
    tested bit,
    brand_id int null,
    foreign key (brand_id) references brands(id)
)
