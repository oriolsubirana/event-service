CREATE TABLE organizer (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    zip VARCHAR(10),
    city VARCHAR(100),
    country VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(20),
    created_date TIMESTAMP NOT NULL,
    last_saved TIMESTAMP NOT NULL
);

CREATE TABLE event (
    id UUID PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    date TIMESTAMP NOT NULL,
    country VARCHAR(255) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    type VARCHAR(50) NOT NULL,
    organizer_id UUID NOT NULL,
    event_link VARCHAR(255) NOT NULL,
    image_url VARCHAR(255) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    last_saved TIMESTAMP NOT NULL,

    CONSTRAINT fk_organizer FOREIGN KEY (organizer_id) REFERENCES organizer(id)
);