create table if not exists "message"(
            id BIGSERIAL not null,
            id_user BIGSERIAL not null,
            id_dialogues BIGSERIAL NOT NULL,
            text VARCHAR null,
            date date not null default clock_timestamp(),
            primary key (id)
);
create table if not exists "habrs"(
            writers VARCHAR default NULL,
            themes VARCHAR default NULL,
            texts VARCHAR default NULL,
            dates VARCHAR default NULL,
            PRIMARY KEY (themes)
);
create table if not exists "users"(
            id_user BIGSERIAL NOT NULL,
            login VARCHAR not NULL,
            first_name VARCHAR default NULL,
            second_name VARCHAR default NULL,
            password VARCHAR default NULL,
            age INT default NULL,
--             imageUrl varchar default Null,
            PRIMARY KEY (id_user)
);
create table if not exists "friendList"(
            id_transaction BIGSERIAL not null,
            id_friend_to_search BIGSERIAL not null,
            id_his_friends BIGSERIAL not null,
            primary key (id_transaction)
);
create table if not exists "dialogues"(
            id_dialogues BIGSERIAL not null,
            name_dialogue VARCHAR not null,
            quantity_people INT null,
            quantity_message INT NULL,
            primary key (id_dialogues)
);
-- create table if not exists  "user_dialogues"
--             id_user BIGSERIAL not null,
--             id_dialogues BIGSERIAL not null,
--             primary key (id_user)
--             спросить почему мы решили это оставить
-- )
create table if not exists "notification"(
            id_user BIGSERIAL not null,
            id_dialogues BIGSERIAL not null,
            date date not null default clock_timestamp(),
            primary key (id_user)
);
create table if not exists "oldpassword"(
            id_user BIGSERIAL ,
            hashcode varchar ,
            primary key (hashcode),
            UNIQUE(hashcode)
);
create table if not exists "role"(
            id_role BIGINT,
            login varchar ,
            primary key (id_role)
);
create table if not exists "privilege"(
            id_privilege BIGINT,
            name varchar,
            primary key (id_privilege)
);
create table if not exists "user_roles"(
            id_roles BIGINT,
            id_user BIGINT,
            primary key (id_user)
)