create table recipes
(
    id          bigint not null
        primary key,
    designation varchar(255)
);

alter table recipes
    owner to postgres;

