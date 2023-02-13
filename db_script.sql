
CREATE SCHEMA IF NOT EXISTS "mapa-bravo"
AUTHORIZATION postgres;

COMMENT ON SCHEMA "mapa-bravo"
    IS 'schema used for the project "mapa-z2j"';
	
	CREATE TABLE IF NOT EXISTS "mapa-bravo"."user"
(
    id bigint NOT NULL,
    nickname character(100) NOT NULL,
    city character(100) NOT NULL,
    country character(100) NOT NULL,
    "zipCode" character(100) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "mapa-bravo"."user"
    OWNER to postgres;

COMMENT ON TABLE "mapa-bravo"."user"
    IS 'user table';