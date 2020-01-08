INSERT INTO "USERS" (ID, USERNAME, PASSWORD, EMAIL)
VALUES (1, 'admin', '$2a$04$Q92jgOvC2Oap/blS8vc82Ogkw.LX6IudpGo5CiV5MJX5a5vHDdyGG', 'admin@mail.com');
INSERT INTO "USERS" (ID, USERNAME, PASsWORD, EMAIL)
VALUES (2, 'jan', '$2a$04$YBkG3klFBdNDikZl5nrutuj2bQdAEFh1NP9kinMk61sBM2HuJj7q6' ,'jan@mail.com');

INSERT INTO "WEBSITES" (ID, URL) VALUES (1, 'svaboda.org');
INSERT INTO "WEBSITES" (ID, URL) VALUES (2, 'nn.by');
INSERT INTO "WEBSITES" (ID, URL) VALUES (3, 'euroradio.fm');
INSERT INTO "WEBSITES" (ID, URL) VALUES (4, 'tut.by');
INSERT INTO "WEBSITES" (ID, URL) VALUES (5, 'belsat.eu');

INSERT INTO "CATEGORIES" (ID, NAME) VALUES (1, 'news');
INSERT INTO "CATEGORIES" (ID, NAME) VALUES (2, 'culture');
INSERT INTO "CATEGORIES" (ID, NAME) VALUES (3, 'history');
INSERT INTO "CATEGORIES" (ID, NAME) VALUES (4, 'sport');
INSERT INTO "CATEGORIES" (ID, NAME) VALUES (5, 'finance');


INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (1, 1);
INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (1, 3);
INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (2, 1);
INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (2, 2);

INSERT INTO "PREFERRED_CATEGORIES" (USER_ID, CATEGORY_ID) VALUES (1, 1);
INSERT INTO "PREFERRED_CATEGORIES" (USER_ID, CATEGORY_ID) VALUES (2, 1);

INSERT INTO "PREFERRED_WEBSITES" (USER_ID, WEBSITE_ID) VALUES (1, 1);
INSERT INTO "PREFERRED_WEBSITES" (USER_ID, WEBSITE_ID) VALUES (2, 2);

INSERT INTO "ROLES" (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO "ROLES" (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO "USERS_ROLES" (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO "USERS_ROLES" (USER_ID, ROLE_ID) VALUES (1, 2);
INSERT INTO "USERS_ROLES" (USER_ID, ROLE_ID) VALUES (2, 1);