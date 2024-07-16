insert into users (name, username, password)
values ('Sharipov Islom', 'tawkenskiy000@gmail.com', '$2a$10$BjJ17poFnXP5xiGg5Aia8OVTOwX7xnuoMuoCNOr0h6p2B8yDEe4JW'),
       ('Shirinov Ilgar', 'baltun@gmail.com', '$2a$10$m5hJC8kPpNS3Y2Pq0uFYZ.f9tzqfydt2mXjaDRsfeiUaJIE7hxPvy');


insert into tasks (title, description, status, expiration_date)
values ('Gosh olish', null, 'TODO', '2024-02-01 00:00:00'),
       ('Do home work', 'Math, History', 'IN_PROGRESS', '2024-02-01 12:00:00'),
       ('Clean rooms', null, 'DONE', null),
       ('Call Ilgar', 'Baltundan Habar olish', 'TODO', '2024-02-01 10:00:00');

insert into users_tasks (task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 2),
       (4, 1);

insert into users_roles (user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');