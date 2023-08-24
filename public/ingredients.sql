create table ingredients
(
    crowd     integer      not null,
    food_id   bigint
        constraint fkqeojdjxqktfqpf2mhclc0we3
            references foods,
    id        bigint       not null
        primary key,
    recipe_id bigint       not null
        constraint fk7p08vcn6wf7fd6qp79yy2jrwg
            references recipes,
    unit      varchar(255) not null
);

alter table ingredients
    owner to postgres;

