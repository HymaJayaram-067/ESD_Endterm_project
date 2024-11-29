-- Create Course table
CREATE TABLE IF NOT EXISTS course (
    course_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(255),
    description TEXT,
    year INT,
    term VARCHAR(50),
    faculty VARCHAR(255),
    credits INT,
    capacity INT
);

-- Create Specialisation table
CREATE TABLE IF NOT EXISTS specialisation (
    specialisation_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(255),
    description TEXT,
    year INT,
    credits_required INT
);

-- Create SpecialisationCourse table
CREATE TABLE IF NOT EXISTS specialisation_course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    specialisation_id BIGINT,
    course_id BIGINT,
    FOREIGN KEY (specialisation_id) REFERENCES specialisation(specialisation_id),
    FOREIGN KEY (course_id) REFERENCES course(course_id)
);

-- Create Users table (for login functionality)
CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,  -- Store hashed password
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert a sample user into the Users table only if the username doesn't already exist
INSERT IGNORE INTO users (username, password) 
VALUES ('hyma', '$2a$10$7vB9YtAkOcs2kFrb0zJ2e.VqfEomqzme0j72Z54vYPgLO9tss5neK');  -- username: hyma, password: password123
