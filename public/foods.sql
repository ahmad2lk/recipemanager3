create table foods
(
    id          bigint not null
        primary key,
    consistency varchar(255),
    unit        varchar(255)
);

alter table foods
    owner to postgres;

