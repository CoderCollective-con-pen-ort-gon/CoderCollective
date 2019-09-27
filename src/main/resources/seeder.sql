use codercollective_db;


insert into users(id, email, firstname, lastname, password, title, username) values
(1, 'gena@gmail.com', 'Gena', 'Vasquez', 'password', 'UI', 'gena'),
(2, 'victorpena@gmail.com', 'victor', 'pena', 'password', 'Front-End Software Developer', 'victor'),
(3, 'joseph@gmail.com', 'joesph', 'ortega', 'password', 'Full-Stack Software Developer', 'joseph'),
(4, 'joey@gmail.com', 'Joey', 'Gonzalez', 'password', 'Full-Stack Software Developer', 'joey');

insert into forums(id, name) values
(1, 'Ruby'),
(2, 'JavaScript'),
(3, 'Python'),
(4,'Java'),
(5,'C++'),
(6,'Kotlin'),
(7,'Elixir'),
(8,'Go'),
(9,'PHP'),
(10,'Scala'),
(11,'Clojure'),
(12,'Frameworks'),
(13,'CSS Frameworks'),
(14,'Libraries'),
(15,'IDE'),
(16,'Learn Programming'),
(17,'Tech Events');

insert into posts(id, body, title, user_id, create_date,forum_id) values
(1, 'I need help with springboot', 'HELP', 1, '2010-10-10',12),
(2, 'Javascript tutorial', 'helloworld', 2, '2009-10-10',2);

insert into comments(id, body, post_id, user_id) values
(1, 'you saved my life', 2, 1),
(2, 'thanks for the sprinboot tip', 1, 1);

insert into favorite_post(user_id, post_id) values
(1,2),
(2,1),
(2,2);

insert into rating(id, vote, comment_id, owner_id) values
(1, 1, 1, 2),
(2, 0, 2, 1);



