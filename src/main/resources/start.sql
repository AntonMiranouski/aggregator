INSERT INTO "USERS" (ID, USERNAME, PASSWORD, EMAIL) VALUES (1, 'bob', '123456', 'bobster@bob.com');
INSERT INTO "USERS" (ID, USERNAME, PASsWORD, EMAIL) VALUES (2, 'jan', '654321' ,'jan@jan.com');

INSERT INTO "WEBSITES" (ID, URL) VALUES (1, 'svaboda.org');
INSERT INTO "WEBSITES" (ID, URL) VALUES (2, 'nn.by');

INSERT INTO "CATEGORIES" (ID, NAME) VALUES (1, 'News');
INSERT INTO "CATEGORIES" (ID, NAME) VALUES (2, 'Culture');
INSERT INTO "CATEGORIES" (ID, NAME) VALUES (3, 'History');

INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (1, 1);
INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (1, 3);
INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (2, 1);
INSERT INTO "WEBSITES_CATEGORIES" (WEBSITE_ID, CATEGORY_ID) VALUES (2, 2);

