CREATE TABLE IF NOT EXISTS public.flower
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1
    MAXVALUE 2147483647 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    "id_profile" integer NOT NULL,
    description text NULL,
    CONSTRAINT id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.profile
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( CYCLE INCREMENT 1 START 1 MINVALUE 1
    MAXVALUE 2147483647 CACHE 1 ),
    fio text NULL,
    login text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT profile_pkey PRIMARY KEY (id)
);

ALTER TABLE flower
    ADD CONSTRAINT FK_flower_profile FOREIGN KEY(id_profile)
        REFERENCES profile(id);