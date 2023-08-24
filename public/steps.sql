create table steps
(
    id        bigint not null
        primary key,
    recipe_id bigint
        constraint fk729dw6qpupm85tlbq57rqbpru
            references recipes
);

alter table steps
    owner to postgres;

