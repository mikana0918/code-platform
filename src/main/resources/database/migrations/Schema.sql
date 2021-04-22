CREATE TABLE i_user (
                        id int(11) NOT NULL AUTO_INCREMENT,
                        email varchar(255) NOT NULL,
                        password varchar(255) NOT NULL,
                        role_type varchar(32) NOT NULL,
                        PRIMARY KEY (id)
);


INSERT INTO i_user (id, email, password, role_type)
VALUES
    (1, 'admin', 'admin', 'ADMIN'),
    (2, 'techbot', 'techbot', 'USER');
