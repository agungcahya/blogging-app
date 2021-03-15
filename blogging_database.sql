CREATE SEQUENCE user_id_seq;
ALTER SEQUENCE public.user_id_seq
    OWNER to postgres;

CREATE TABLE public.user
(
    id integer not null default nextval('user_id_seq'),
    email character varying,
    name character varying,
    password character varying,
    PRIMARY KEY (id)
);

ALTER TABLE public.user
    OWNER to postgres;

CREATE SEQUENCE blog_post_id_seq;
ALTER SEQUENCE public.blog_post_id_seq
    OWNER to postgres;

CREATE TABLE public.blog_post
(
	id integer not null default nextval('blog_post_id_seq'),
    user_id integer,
    title character varying(250),
    content text,
    created_at timestamp without time zone
);

ALTER TABLE public.blog_post
    OWNER to postgres;

CREATE SEQUENCE comment_id_seq;
ALTER SEQUENCE public.comment_id_seq
    OWNER to postgres;

CREATE TABLE public.comment
(
    id integer not null default nextval('comment_id_seq'),
    user_id integer,
    post_id integer,
    content text,
    created_at timestamp without time zone
);

ALTER TABLE public.comment
    OWNER to postgres;