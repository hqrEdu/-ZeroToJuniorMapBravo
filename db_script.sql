
CREATE SCHEMA IF NOT EXISTS "map"
AUTHORIZATION postgres;

COMMENT ON SCHEMA "map"
    IS 'schema used for the project "mapa-z2j"';
	
	CREATE TABLE IF NOT EXISTS "map"."user"
(
    id serial NOT NULL,
    nickname character(100) NOT NULL,
    city character(100) NOT NULL,
    country character(100) NOT NULL,
    zipCode character(100) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS "map"."user"
    OWNER to postgres;

COMMENT ON TABLE "map"."user"
    IS 'user table';