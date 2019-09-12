insert into user (ID, USER_NAME, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, ROLE, SSN) values (1001, 'msatti', 'Mad', 'Satti', 'msatti@smsr.com', 'admin', 'ssn1001');
insert into user (ID, USER_NAME, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, ROLE, SSN) values (1002, 'madhu',  'Madhu', 'Satti', 'madhu@smsr.com', 'admin', 'ssn1002');
insert into user (ID, USER_NAME, FIRST_NAME, LAST_NAME, EMAIL_ADDRESS, ROLE, SSN) values (1003, 'reddy',  'Reddy', 'Reddy', 'reddy@smsr.com', 'admin', 'ssn1003');

insert into orders (ORDERID, ORDERDESCRIPTION, USER_ID) values (2001, 'order11', 1001);
insert into orders (ORDERID, ORDERDESCRIPTION, USER_ID) values (2002, 'order12', 1001);
insert into orders (ORDERID, ORDERDESCRIPTION, USER_ID) values (2003, 'order13', 1001);
insert into orders (ORDERID, ORDERDESCRIPTION, USER_ID) values (2004, 'order14', 1002);
insert into orders (ORDERID, ORDERDESCRIPTION, USER_ID) values (2005, 'order15', 1002);
insert into orders (ORDERID, ORDERDESCRIPTION, USER_ID) values (2006, 'order16', 1003);