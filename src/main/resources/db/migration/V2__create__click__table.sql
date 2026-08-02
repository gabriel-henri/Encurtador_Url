CREATE TABLE clicks(
    id BIGSERIAL PRIMARY KEY,
    url_id BIGINT NOT NULL,
    ip VARCHAR(20) NOT NULL,
    user_agent VARCHAR(255),
    acessed_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_click_url
    FOREIGN KEY (url_id)
    REFERENCES urls(id)
    ON DELETE CASCADE
);