create table hibernatetests.author (authorId integer not null, lastName varchar(200) not null, name varchar(200) not null, primary key (authorId))
create table hibernatetests.book (id integer not null, author varchar(200) not null, price double precision not null, title varchar(200) not null, primary key (id))
create table hibernatetests.users (id integer not null, name varchar(200) not null, username varchar(200) not null, primary key (id))
