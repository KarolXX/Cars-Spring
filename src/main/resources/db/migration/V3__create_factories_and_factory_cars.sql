create table factories(
    id int primary key auto_increment,
    name varchar(50) not null,
    establishment_year datetime
);
create table factory_cars(
    id int primary key auto_increment,
    name varchar(50) not null,
    passed_years int,
    factory_id int null,
    foreign key (factory_id) references factories(id)
)