CREATE TABLE urls(
    id BIGSERIAL PRIMARY KEY ,
    short_url VARCHAR(20) NOT NULL UNIQUE,
    original_url VARCHAR(2048) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_expiracao TIMESTAMP NOT NULL
);