-- Table: wiki.author

-- DROP TABLE IF EXISTS wiki.author;

CREATE TABLE IF NOT EXISTS wiki.author
(
    "id" integer NOT NULL,
    "name" text COLLATE pg_catalog."default",
    "email" text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    CONSTRAINT author_pkey PRIMARY KEY ("id")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS wiki.author
    OWNER to postgres;

-- Table: wiki.book

-- DROP TABLE IF EXISTS wiki.book;

CREATE TABLE IF NOT EXISTS wiki.book
(
    "id" integer NOT NULL,
    "name" text COLLATE pg_catalog."default",
    "price" integer,
    publisher text COLLATE pg_catalog."default",
    isbn integer,
    "quantity" integer,
    "author_id" integer,
    "location_id" integer,
    CONSTRAINT book_pkey PRIMARY KEY ("id")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS wiki.book
    OWNER to postgres;


-- Table: wiki.location

-- DROP TABLE IF EXISTS wiki.location;

CREATE TABLE IF NOT EXISTS wiki.location
(
    "id" integer NOT NULL,
    "block" text COLLATE pg_catalog."default",
    "bay_side" text COLLATE pg_catalog."default",
    "floor" text COLLATE pg_catalog."default",
    "shelf" text COLLATE pg_catalog."default",
    CONSTRAINT candidate_pkey PRIMARY KEY ("id")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS wiki.location
    OWNER to postgres;

-- SEQUENCE: wiki.author_seq

-- DROP SEQUENCE IF EXISTS wiki.author_seq;

CREATE SEQUENCE IF NOT EXISTS wiki.author_seq
    INCREMENT 1
    START 5001
    MINVALUE 1
    MAXVALUE 100000000
    CACHE 1;

ALTER SEQUENCE wiki.author_seq
    OWNER TO postgres;


-- SEQUENCE: wiki.book_seq

-- DROP SEQUENCE IF EXISTS wiki.book_seq;

CREATE SEQUENCE IF NOT EXISTS wiki.book_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 100000000
    CACHE 1;

ALTER SEQUENCE wiki.book_seq
    OWNER TO postgres;
	

-- SEQUENCE: wiki.location_seq

-- DROP SEQUENCE IF EXISTS wiki.location_seq;

CREATE SEQUENCE IF NOT EXISTS wiki.location_seq
    INCREMENT 1
    START 9001
    MINVALUE 1
    MAXVALUE 100000000
    CACHE 1;

ALTER SEQUENCE wiki.location_seq
    OWNER TO postgres;
	
	
	INSERT INTO wiki.book("id", "name", "price", "publisher", "isbn", "quantity", "author_id", "location_id")
VALUES
(1, 'Javascript Deep Dive', 100, 'Blackbook Publications', 11002233, 50, 5001, 9001);

INSERT INTO wiki.book("id", "name", "price", "publisher", "isbn", "quantity", "author_id", "location_id")
VALUES
(2, 'Java InDepth', 100, 'Blackbook Publications', 11002233, 50, 5002, 9002);

INSERT INTO wiki.book("id", "name", "price", "publisher", "isbn", "quantity", "author_id", "location_id")
VALUES
(3, 'Angular Extensive', 100, 'Blackbook Publications', 11002233, 50, 5003, 9003);


INSERT INTO wiki.author("id", "name", "email", "description")
VALUES
(5001, 'Abhishek', 'toabhishek@gmail.com', 'Working as a Software Engineer');

INSERT INTO wiki.author("id", "name", "email", "description")
VALUES
(5002, 'Abhimanyu', 'toabhimanyu@gmail.com', 'Working as a Engineering Engineer');

INSERT INTO wiki.author("id", "name", "email", "description")
VALUES
(5003, 'Abhinav', 'toabhinav@gmail.com', 'Working as a Product Manager');


INSERT INTO wiki.location("id", "block", "bay_side", "floor", "shelf")
VALUES
(9001, 'A1', 'Right', '2F', '5A');

INSERT INTO wiki.location("id", "block", "bay_side", "floor", "shelf")
VALUES
(9002, 'A2', 'Left', '3F', '6B');

INSERT INTO wiki.location("id", "block", "bay_side", "floor", "shelf")
VALUES
(9003, 'A3', 'Right', '4F', '7C');

select * from wiki.author;

select * from wiki.book;

select * from wiki.location;
