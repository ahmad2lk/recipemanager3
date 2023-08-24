create table ingredient_steps
(
    crowd         integer      not null,
    food_id       bigint
        constraint fkkg4jsvwsa5dkwiei2bdyk1hbs
            references foods,
    id            bigint       not null
        primary key,
    ingredient_id bigint
        constraint fktd6bmkuvwpgm2gukpvvhjukt1
            references ingredients,
    step_id       bigint       not null
        constraint fkjucb7j4ren5al0ohs4tp08hk
            references steps,
    presentation  varchar(255),
    unit          varchar(255) not null
);

alter table ingredient_steps
    owner to postgres;

