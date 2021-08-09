delete from User;
delete from Employee;

insert into User (id, username, password, role)
values(1, 'admin01', '$2a$10$yce69V8bfd3COZJJi6hBBepeGTzRYOEP52QTvFL9GZztz4fmW1Q66', 'ROLE_ADMIN');



--delete from Role;
--insert into Role (id, name) values(1, 'Systems Analyst');
--insert into Role (id, name) values(2, 'Quality Assurance Tester');
--insert into Role (id, name) values(3, 'Database Manager');

--
--
--delete from Band;
--insert into Band (id, description) values(1, 'B1');
--insert into Band (id, description) values(2, 'B2');
--insert into Band (id, description) values(3, 'B3');
--


--delete from Skill;
--insert into Skill (id, role_id, band_id, name) values('DV101', 1, 1, 'Core Java L2');
--insert into Skill (id, role_id, band_id, name) values('DV102', 1, 1, 'Spring L2');
--insert into Skill (id, role_id, band_id, name) values('DV103', 1, 1, 'Object Oriented Background');
--insert into Skill (id, role_id, band_id, name) values('QA101', 2, 1, 'Core Java L1');
--insert into Skill (id, role_id, band_id, name) values('QA102', 2, 1, 'Unit Test');
--insert into Skill (id, role_id, band_id, name) values('DB101', 3, 1, 'Basic SQL');
--insert into Skill (id, role_id, band_id, name) values('DV201', 1, 2, 'Core Java L3');
--insert into Skill (id, role_id, band_id, name) values('DV202', 1, 2, 'Spring L3');
--insert into Skill (id, role_id, band_id, name) values('DV203', 1, 2, 'REST');
--insert into Skill (id, role_id, band_id, name) values('QA202', 2, 2, 'REST Assured');
--insert into Skill (id, role_id, band_id, name) values('DB201', 3, 2, 'SQL Programming');
--insert into Skill (id, role_id, band_id, name) values('DV301', 1, 3, 'Core Java L4');
--insert into Skill (id, role_id, band_id, name) values('DV302', 1, 3, 'Spring L4');
--insert into Skill (id, role_id, band_id, name) values('DV303', 1, 3, 'Microservices');
--insert into Skill (id, role_id, band_id, name) values('QA301', 2, 3, 'Test Automation with Selenium');
--insert into Skill (id, role_id, band_id, name) values('DB301', 3, 3, 'Database Management Procedures');