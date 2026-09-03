CREATE TABLE tbl_Todo (

         id BIGSERIAL PRIMARY KEY,
         title VARCHAR(255) NOT NULL,
         description VARCHAR(100) NOT NULL,
         date TIMESTAMP,
         done BOOLEAN NOT NULL DEFAULT FALSE
);