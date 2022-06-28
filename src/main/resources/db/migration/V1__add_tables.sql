CREATE TABLE author
(
    author_id SERIAL PRIMARY KEY,
    full_name CHARACTER VARYING(90),
    book_id   INTEGER
);

CREATE TABLE book (
                      book_id SERIAL PRIMARY KEY ,
                      book_name CHARACTER VARYING (80),
                      price INTEGER ,
                      author_id INTEGER);

CREATE TABLE book_and_author (
                                 book_id INTEGER ,
                                 author_id INTEGER,
                                 constraint fk_author foreign key(author_id) references author(author_id),
                                 constraint fk_book foreign key(book_id) references book(book_id),
                                 primary key(book_id, author_id) );

insert into book (book_name, price) values ('Harry Potter', 5000);
insert into book (book_name, price) values ('Harry Potter2', 500);
insert into author (full_name) values ('J.K.Rowling');
insert into author (full_name) values ('J.K.Kook');
insert into book_and_author(book_id, author_id) values (1,1);
insert into book_and_author(book_id, author_id) values (2,2);