-- Table: users
create table users(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
)
    ENGINE= InnoDB;

-- Table: roles
CREATE TABLE roles (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),

    UNIQUE (user_id,role_id)
) ENGINE = InnoDB;

-- Insert data about users and roles
INSERT INTO users VALUE (1,'user','1');
INSERT INTO users VALUE (2,'admin','1');

INSERT INTO roles VALUE (1,'ROLE_USER');
INSERT INTO roles VALUE (2,'ROLE_ADMIN');

INSERT INTO user_roles VALUE (1,1);
INSERT INTO user_roles VALUE (2,2);

-- Table: surveys
CREATE TABLE surveys(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NULL,
    start DATE NOT NULL,
    stop DATE NOT NULL,
    survey_body TEXT NOT NULL
) ENGINE = InnoDB;

-- Table for getting surveys that user passed: user_surveys
CREATE TABLE user_surveys(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    survey_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (survey_id) REFERENCES surveys(id),

    UNIQUE (user_id, survey_id)
) ENGINE = InnoDB;

-- Table for getting user's survey results : user_answers
CREATE TABLE user_answers(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_surveys_id INT NOT NULL,
    question_id INT NOT NULL,
    answer VARCHAR(255) NULL,

    FOREIGN KEY (user_surveys_id) REFERENCES user_surveys(id),
    UNIQUE (user_surveys_id,question_id)
) ENGINE = InnoDB;

-- Table for questions
CREATE TABLE questions(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    survey_id INT NOT NULL,
    question VARCHAR(255) not null,
    answer_type VARCHAR(255) not null,

    FOREIGN KEY (survey_id) REFERENCES surveys(id)
) ENGINE = InnoDB;

-- Table for variations of answers
CREATE TABLE var_answers(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    question_id INT NOT NULL,
    answer VARCHAR(255) not null,
    FOREIGN KEY (question_id) REFERENCES questions(id)
) ENGINE = InnoDB;