-- Init user table
CREATE TABLE public."user" (
	id integer NOT NULL,
	"name" varchar(255) NULL,
	email varchar(255) NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Init person table
CREATE TABLE public.person (
	id integer NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	CONSTRAINT person_pk PRIMARY KEY (id)
);

-- Init department table 
CREATE TABLE public.department (
	id integer NOT NULL,
	dep_name varchar(255) NULL,
	dep_tel varchar(255) NULL,
	CONSTRAINT department_pk PRIMARY KEY (id)
);

-- Init system_auth table
CREATE TABLE public.system_auth (
	id integer NOT NULL,
	user_id varchar(255) NULL,
	user_name varchar(255) NULL,
	"password" varchar(255) NULL,
	CONSTRAINT system_auth_pk PRIMARY KEY (id)
);

-- Init user data
INSERT INTO public."user" (id,"name",email)
	VALUES (1,'manager','manager@test.local');
INSERT INTO public."user" (id,"name",email)
	VALUES (2,'sub_manager','sub@test.local');
INSERT INTO public."user" (id,"name",email)
	VALUES (3,'staff_01','staff_01@test.local');
INSERT INTO public."user" (id,"name",email)
	VALUES (4,'staff_02','staff_02@test.local');
INSERT INTO public."user" (id,"name",email)
	VALUES (5,'staff_03','staff_03@test.local');

-- Init system_auth data
INSERT INTO public.system_auth (id,user_id,user_name,"password")
	VALUES (1,'1','manager','5432');
INSERT INTO public.system_auth (id,user_id,user_name,"password")
	VALUES (2,'2','submanager','5432');
INSERT INTO public.system_auth (id,user_id,user_name,"password")
	VALUES (3,'3','staff_01','5432');
INSERT INTO public.system_auth (id,user_id,user_name,"password")
	VALUES (4,'4','staff_02','5432');
INSERT INTO public.system_auth (id,user_id,user_name,"password")
	VALUES (5,'5','staff_03','5432');

-- Init person data
INSERT INTO public.person (id,first_name,last_name)
	VALUES (1,'chayoud','pakdeeyong');
INSERT INTO public.person (id,first_name,last_name)
	VALUES (2,'chayoud_02','pakdeeyong');
INSERT INTO public.person (id,first_name,last_name)
	VALUES (3,'chayoud_03','pakdeeyong');
INSERT INTO public.person (id,first_name,last_name)
	VALUES (4,'chayoud_04','pakdeeyong');
INSERT INTO public.person (id,first_name,last_name)
	VALUES (5,'chayoud_05','pakdeeyong');

-- Init department data
INSERT INTO public.department (id,dep_name,dep_tel)
	VALUES (1,'Information Tecnology','099-999-9999');
INSERT INTO public.department (id,dep_name,dep_tel)
	VALUES (2,'Computer Engineer','099-999-9999');
INSERT INTO public.department (id,dep_name,dep_tel)
	VALUES (3,'Automation Engineer','099-999-9999');