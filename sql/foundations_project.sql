create schema foundation_sql;

set search_path to foundation_sql;
--create a table to specify users roles to our foundations test database
create table user_roles (
    id int generated always as identity primary key,
    name varchar unique not null
);
-- create a table for basic registration 
create table app_users (
    id int generated always as identity,
    first_name varchar not null,
    last_name varchar not null,
    email varchar unique not null,
    username varchar unique not null check (length (username) >= 6),
    password varchar unique not null, check (length (password) >= 6),
    role_id int,
--set the id as a primary key
    constraint app_users_pk
    primary key (id),
-- connect the role_id to the user_roles so we understand the user role on the app
    constraint role_id_fk
    foreign key (role_id)
    references user_roles (id)
);
-- create a table where each user provides their steps to projects and allow them to get rankings. 
create table foundation_steps (
    id int generated always as identity primary key,
    steps varchar not null,
    difficulty int check (difficulty > 0 and difficulty <= 5)
);