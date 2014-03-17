
INSERT INTO role VALUES(1,"bao_super_admin",0);
INSERT INTO role VALUES(2,"bao_member",0);
INSERT INTO role VALUES(3,"bao_visitor",0);



INSERT INTO auth VALUES ( '1','web_auth_index');
INSERT INTO auth VALUES ( '2','web_auth_member_home');
INSERT INTO auth VALUES ( '3','web_auth_member_update');

INSERT INTO roleauth VALUES(1,1,1);
INSERT INTO roleauth VALUES(2,1,2);
INSERT INTO roleauth VALUES(3,1,3);
INSERT INTO roleauth VALUES(4,3,1);
INSERT INTO roleauth VALUES(5,7,1);




