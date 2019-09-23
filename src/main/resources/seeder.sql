use codercollective_db;

insert into users(id, email, firstname, lastname, password, title, username) values
(1, 'alexchris@gmail.com', 'alex', 'casa', 'pass', 'senior software developer', 'alex'),
(2, 'victorpena@gmail.com', 'victor', 'pena', 'pass', 'junior software developer', 'victor'),
(3, 'joseph@gmail.com', 'joesph', 'ortega', 'pass', 'senior software developer', 'joseph');

insert into forums(id, name) values
(1, 'springboot'),
(2, 'javascript'),
(3, 'python');

insert into posts(id, body, title, user_id, create_date,forum_id) values
(1, 'I need help with springboot', 'HELP', 1, '2010-10-10',1),
(2, 'Javascript tutorial', 'helloworld', 2, '2009-10-10',2);

insert into comments(id, body, post_id, user_id) values
(1, 'you saved my life', 2, 2),
(2, 'thanks for the sprinboot tip', 1, 1);

insert into favorite_post(user_id, post_id) values
(1,2),
(2,1),
(2,2);

insert into rating(id, vote, comment_id, owner_id) values
(1, 1, 1, 2),
(2, 0, 2, 1);










