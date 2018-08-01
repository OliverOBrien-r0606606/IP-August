INSERT INTO USERS(username,name,sir,email,pass,enabled) VALUES
('DDN','Oliver','OBrien','oliver.obrien@ucll.be','$2a$04$rUlX/CAImg8rZlr1mO5CCOMhQr3JTjOgpZhPDNuzanIElz0pL4HBO',true),
('Legend101','Sebastian','OBrien','seb.obrien@ucll.be','$2a$04$a34CAkmrAPX1md6lai09QOftVD91tdm1yId6KOLLznwPS10z.BE.O',true);

INSERT INTO USER_ROLES(userid,role) VALUES
(1,'ROLE_ADMIN');
INSERT INTO USER_ROLES(userid,role) VALUES
(1,'ROLE_USER');
INSERT INTO USER_ROLES(userid,role) VALUES
(2,'ROLE_USER');