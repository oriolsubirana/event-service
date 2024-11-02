CREATE TABLE event (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    date TIMESTAMP NOT NULL,
    country VARCHAR(255) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    type VARCHAR(50) NOT NULL,
    organizer VARCHAR(255) NOT NULL,
    eventLink VARCHAR(255) NOT NULL,
    imageUrl VARCHAR(255) NOT NULL,
    row_version    integer      DEFAULT 0     NOT NULL,
    row_created_by varchar(255)               NOT NULL,
    row_created_on timestamp    DEFAULT now() NOT NULL,
    row_updated_by varchar(255) DEFAULT NULL,
    row_updated_on timestamp    DEFAULT now()
);