create table instructions
(
    duration         integer,
    mixing_level     integer,
    temperature      integer,
    id               bigint      not null
        primary key,
    step_id          bigint
        unique
        constraint fko8gl1omuufcqd7ed6icpdkcvv
            references steps,
    instruction_type varchar(31) not null,
    description      varchar(255)
);

alter table instructions
    owner to postgres;

