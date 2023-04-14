
CREATE SCHEMA IF NOT EXISTS "map"
AUTHORIZATION postgres;

COMMENT ON SCHEMA "map"
    IS 'schema used for the project "mapa-z2j"';
	
	CREATE TABLE IF NOT EXISTS "map"."user"
(
    id serial NOT NULL,
    nickname character varying NOT NULL,
    city character varying NOT NULL,
    country character varying NOT NULL,
    zipCode character varying NOT NULL,
    latitude float NOT NULL,
    longitude float NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS "map"."user"
    OWNER to postgres;

COMMENT ON TABLE "map"."user"
    IS 'user table';