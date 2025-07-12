INSERT INTO roles(role_id, name) VALUES (1, 'USER');
INSERT INTO roles(role_id, name) VALUES (2, 'ADMIN');

INSERT INTO users(username, password, enabled) VALUES ('user', '$2a$10$aJfFv14R1tFuVJbxBLy7kOiXZ1wTkMp41uRAlBQcUtJAcUGmtG7LS', true); -- 'pwd'
INSERT INTO users(username, password, enabled) VALUES ('admin', '$2a$10$aJfFv14R1tFuVJbxBLy7kOiXZ1wTkMp41uRAlBQcUtJAcUGmtG7LS', true); -- 'pwd'

INSERT INTO user_roles(username, role_id) VALUES ('user', 1);
INSERT INTO user_roles(username, role_id) VALUES ('admin', 2);
