CREATE TYPE "text" AS ENUM ('TYPE1', 'TYPE2', 'TYPE3', 'TYPE4', 'TYPE5', 'TYPE6', 'TYPE7');

CREATE TABLE IF NOT EXISTS legacy_app_table(
                       id bigserial NOT NULL,
                       "type" "text" NOT NULL,
                       business_value "text" NOT NULL,
                       created_at timestamp NOT NULL,
                       updated_at timestamp DEFAULT NULL,
                       PRIMARY KEY (id)
);