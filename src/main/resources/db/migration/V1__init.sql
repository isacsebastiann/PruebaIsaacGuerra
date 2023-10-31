CREATE TABLE IF NOT EXISTS conference (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    city VARCHAR(255),
    total_assistant INT
    );

CREATE TABLE IF NOT EXISTS assistant (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    age INT,
    conference_id INT,
    FOREIGN KEY (conference_id) REFERENCES conference(id)
);
