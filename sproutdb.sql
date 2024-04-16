/*creating database*/
create database sprout;
use sprout;

create table learner(learner_id int primary key,username varchar(50) unique not null,password varchar(50) not null,email varchar(50) unique not null,registeration_date date);

create table instructor(instructor_id int primary key,name char(50) not null,date_of_birth date not null,email varchar(50) unique not null,description varchar(200));

create table course(course_id int primary key,
course_title varchar(50) not null ,
instructor_id int ,
foreign key(instructor_id) references instructor(instructor_id));

create table enrollments(
enrollment_id int primary key,
learner_id int,
course_id int,
enrollment_date date not null,
completion_status int default 0,
foreign key(learner_id) references learner(learner_id),
foreign key(course_id) references course(course_id));

create table Feedback(
feedback_id int primary key,learner_id int,
course_id int,rating int ,description TEXT,
foreign key(learner_id) references learner(learner_id),
foreign key(course_id) references course(course_id));

create table Quiz(
quiz_id int primary key,learner_id int,
course_id int,score int ,date_taken date,
foreign key(learner_id) references learner(learner_id),
foreign key(course_id) references course(course_id));


create table Achievements(
achievement_id int primary key,
achievement_type char(255),
Date_of_achive date, learner_id int,
foreign key(learner_id) references learner(learner_id));

create table LeaderBoard(
learner_id int not null, total_points int,
foreign key(learner_id) references learner(learner_id));

create table module(
module_id int primary key,
module_title char(255) not null,
course_id int , foreign key(course_id) references course(course_id));

create table lesson(
lesson_id int primary key,
lesson_title char(255) not null,
module_id int , foreign key(module_id) references module(module_id));

create table Progress(
user_id int , lesson_id int ,progress_percent int default 0);

/*inserting values in databse*/

INSERT INTO learner (learner_id, username, password, email, registeration_date) 
VALUES 
    (1, 'learner1', 'password123', 'learner1@example.com', '2024-04-15'),
    (2, 'learner2', 'password456', 'learner2@example.com', '2024-04-16'),
    (3, 'learner3', 'password789', 'learner3@example.com', '2024-04-17'),
    (4, 'learner4', 'passwordabc', 'learner4@example.com', '2024-04-18'),
    (5, 'learner5', 'passworddef', 'learner5@example.com', '2024-04-19'),
    (6, 'learner6', 'passwordghi', 'learner6@example.com', '2024-04-20'),
    (7, 'learner7', 'passwordjkl', 'learner7@example.com', '2024-04-21'),
    (8, 'learner8', 'passwordmno', 'learner8@example.com', '2024-04-22'),
    (9, 'learner9', 'passwordpqr', 'learner9@example.com', '2024-04-23'),
    (10, 'learner10', 'passwordstu', 'learner10@example.com', '2024-04-24'),
    (11, 'learner11', 'passwordvwx', 'learner11@example.com', '2024-04-25'),
    (12, 'learner12', 'passwordyz1', 'learner12@example.com', '2024-04-26'),
    (13, 'learner13', 'password234', 'learner13@example.com', '2024-04-27'),
    (14, 'learner14', 'password567', 'learner14@example.com', '2024-04-28'),
    (15, 'learner15', 'password890', 'learner15@example.com', '2024-04-29'),
    (16, 'learner16', 'passwordabc1', 'learner16@example.com', '2024-04-30'),
    (17, 'learner17', 'passworddef1', 'learner17@example.com', '2024-05-01'),
    (18, 'learner18', 'passwordghi1', 'learner18@example.com', '2024-05-02'),
    (19, 'learner19', 'passwordjkl1', 'learner19@example.com', '2024-05-03'),
    (20, 'learner20', 'passwordmno1', 'learner20@example.com', '2024-05-04'),
    (21, 'learner21', 'passwordpqr1', 'learner21@example.com', '2024-05-05'),
    (22, 'learner22', 'passwordstu1', 'learner22@example.com', '2024-05-06'),
    (23, 'learner23', 'passwordvwx1', 'learner23@example.com', '2024-05-07'),
    (24, 'learner24', 'passwordyz2', 'learner24@example.com', '2024-05-08'),
    (25, 'learner25', 'password345', 'learner25@example.com', '2024-05-09'),
    (26, 'learner26', 'password678', 'learner26@example.com', '2024-05-10'),
    (27, 'learner27', 'password901', 'learner27@example.com', '2024-05-11'),
    (28, 'learner28', 'password2341', 'learner28@example.com', '2024-05-12'),
    (29, 'learner29', 'password5671', 'learner29@example.com', '2024-05-13'),
    (30, 'learner30', 'password8901', 'learner30@example.com', '2024-05-14'),
    (31, 'learner31', 'passwordabc2', 'learner31@example.com', '2024-05-15'),
    (32, 'learner32', 'passworddef2', 'learner32@example.com', '2024-05-16'),
    (33, 'learner33', 'passwordghi2', 'learner33@example.com', '2024-05-17'),
    (34, 'learner34', 'passwordjkl2', 'learner34@example.com', '2024-05-18'),
    (35, 'learner35', 'passwordmno2', 'learner35@example.com', '2024-05-19'),
    (36, 'learner36', 'passwordpqr2', 'learner36@example.com', '2024-05-20'),
    (37, 'learner37', 'passwordstu2', 'learner37@example.com', '2024-05-21'),
    (38, 'learner38', 'passwordvwx2', 'learner38@example.com', '2024-05-22'),
    (39, 'learner39', 'passwordyz3', 'learner39@example.com', '2024-05-23'),
    (40, 'learner40', 'password3456', 'learner40@example.com', '2024-05-24'),
    (41, 'learner41', 'password6789', 'learner41@example.com', '2024-05-25'),
    (42, 'learner42', 'password012', 'learner42@example.com', '2024-05-26'),
    (43, 'learner43', 'password3451', 'learner43@example.com', '2024-05-27'),
    (44, 'learner44', 'password6781', 'learner44@example.com', '2024-05-28'),
    (45, 'learner45', 'password9012', 'learner45@example.com', '2024-05-29'),
    (46, 'learner46', 'password2342', 'learner46@example.com', '2024-05-30'),
    (47, 'learner47', 'password5672', 'learner47@example.com', '2024-05-31'),
    (48, 'learner48', 'password8902', 'learner48@example.com', '2024-06-01'),
    (49, 'learner49', 'passwordabc3', 'learner49@example.com', '2024-06-02'),
    (50, 'learner50', 'passworddef3', 'learner50@example.com', '2024-06-03');


INSERT INTO instructor (instructor_id, name, date_of_birth, email, description) 
VALUES 
    (1, 'Instructor Name 1', '1980-01-01', 'instructor1@example.com', 'Experienced instructor with expertise in various subjects.'),
    (2, 'Instructor Name 2', '1975-02-02', 'instructor2@example.com', 'Passionate educator specializing in technology and innovation.'),
    (3, 'Instructor Name 3', '1983-03-03', 'instructor3@example.com', 'Dedicated teacher committed to student success.'),
    (4, 'Instructor Name 4', '1982-04-04', 'instructor4@example.com', 'Dynamic instructor with a focus on interactive learning.'),
    (5, 'Instructor Name 5', '1978-05-05', 'instructor5@example.com', 'Innovative educator exploring new teaching methodologies.'),
    (6, 'Instructor Name 6', '1985-06-06', 'instructor6@example.com', 'Enthusiastic teacher inspiring students to achieve their goals.'),
    (7, 'Instructor Name 7', '1979-07-07', 'instructor7@example.com', 'Experienced academician with a passion for teaching.'),
    (8, 'Instructor Name 8', '1981-08-08', 'instructor8@example.com', 'Knowledgeable instructor with a talent for simplifying complex concepts.'),
    (9, 'Instructor Name 9', '1976-09-09', 'instructor9@example.com', 'Motivated educator fostering critical thinking skills.'),
    (10, 'Instructor Name 10', '1987-10-10', 'instructor10@example.com', 'Engaging instructor with a focus on student-centered learning.');

INSERT INTO course (course_id, course_title, instructor_id) 
VALUES 
    (1, 'Course Title 1', 1),
    (2, 'Course Title 2', 2),
    (3, 'Course Title 3', 3),
    (4, 'Course Title 4', 4),
    (5, 'Course Title 5', 5),
    (6, 'Course Title 6', 6),
    (7, 'Course Title 7', 7),
    (8, 'Course Title 8', 8),
    (9, 'Course Title 9', 9),
    (10, 'Course Title 10', 10);

INSERT INTO enrollments (enrollment_id, learner_id, course_id, enrollment_date, completion_status) 
VALUES 
    (1, 1, 1, '2024-04-15', 1),
    (2, 1, 2, '2024-04-16', 0),
    (3, 2, 3, '2024-04-17', 1),
    (4, 2, 4, '2024-04-18', 0),
    (5, 3, 5, '2024-04-19', 1),
    (6, 3, 6, '2024-04-20', 0),
    (7, 4, 7, '2024-04-21', 1),
    (8, 4, 8, '2024-04-22', 0),
    (9, 5, 9, '2024-04-23', 1),
    (10, 5, 10, '2024-04-24', 0),
    (11, 6, 1, '2024-04-25', 1),
    (12, 6, 2, '2024-04-26', 0),
    (13, 7, 3, '2024-04-27', 1),
    (14, 7, 4, '2024-04-28', 0),
    (15, 8, 5, '2024-04-29', 1),
    (16, 8, 6, '2024-04-30', 0),
    (17, 9, 7, '2024-05-01', 1),
    (18, 9, 8, '2024-05-02', 0),
    (19, 10, 9, '2024-05-03', 1),
    (20, 10, 10, '2024-05-04', 0),
    (21, 11, 1, '2024-05-05', 1),
    (22, 11, 2, '2024-05-06', 0),
    (23, 12, 3, '2024-05-07', 1),
    (24, 12, 4, '2024-05-08', 0),
    (25, 13, 5, '2024-05-09', 1),
    (26, 13, 6, '2024-05-10', 0),
    (27, 14, 7, '2024-05-11', 1),
    (28, 14, 8, '2024-05-12', 0),
    (29, 15, 9, '2024-05-13', 1),
    (30, 15, 10, '2024-05-14', 0),
    (31, 16, 1, '2024-05-15', 1),
    (32, 16, 2, '2024-05-16', 0),
    (33, 17, 3, '2024-05-17', 1),
    (34, 17, 4, '2024-05-18', 0),
    (35, 18, 5, '2024-05-19', 1),
    (36, 18, 6, '2024-05-20', 0),
    (37, 19, 7, '2024-05-21', 1),
    (38, 19, 8, '2024-05-22', 0),
    (39, 20, 9, '2024-05-23', 1),
    (40, 20, 10, '2024-05-24', 0),
    (41, 21, 1, '2024-05-25', 1),
    (42, 21, 2, '2024-05-26', 0),
    (43, 22, 3, '2024-05-27', 1),
    (44, 22, 4, '2024-05-28', 0),
    (45, 23, 5, '2024-05-29', 1),
    (46, 23, 6, '2024-05-30', 0),
    (47, 24, 7, '2024-05-31', 1),
    (48, 24, 8, '2024-06-01', 0),
    (49, 25, 9, '2024-06-02', 1),
    (50, 25, 10, '2024-06-03', 0);


INSERT INTO Feedback (feedback_id, learner_id, course_id, rating, description) 
VALUES 
    (1, 1, 1, 5, 'Great course! Learned a lot.'),
    (2, 2, 2, 4, 'Informative content, but could use more examples.'),
    (3, 3, 3, 5, 'Excellent instructor! Clear explanations and engaging lectures.'),
    (4, 4, 4, 3, 'Good course overall, but some topics were too advanced for beginners.'),
    (5, 5, 5, 4, 'Enjoyed the interactive exercises and quizzes.'),
    (6, 6, 6, 5, 'Best course I have taken so far! Highly recommended.'),
    (7, 7, 7, 4, 'Interesting content, but pacing was a bit slow at times.'),
    (8, 8, 8, 3, 'Average course. Could be improved with more practical examples.'),
    (9, 9, 9, 4, 'Well-organized course with clear learning objectives.'),
    (10, 10, 10, 5, 'Fantastic instructor! Very engaging and knowledgeable.');

INSERT INTO Quiz (quiz_id, learner_id, course_id, score, date_taken) 
VALUES 
    (1, 1, 1, 90, '2024-04-16'),
    (2, 2, 2, 85, '2024-04-17'),
    (3, 3, 3, 95, '2024-04-18'),
    (4, 4, 4, 75, '2024-04-19'),
    (5, 5, 5, 80, '2024-04-20'),
    (6, 6, 6, 100, '2024-04-21'),
    (7, 7, 7, 70, '2024-04-22'),
    (8, 8, 8, 85, '2024-04-23'),
    (9, 9, 9, 90, '2024-04-24'),
    (10, 10, 10, 95, '2024-04-25');


INSERT INTO Achievements (achievement_id, achievement_type, Date_of_achive, learner_id) 
VALUES 
    (1, 'Completion Badge', '2024-04-16', 1),
    (2, 'Quiz Master', '2024-04-17', 2),
    (3, 'Top Performer', '2024-04-18', 3),
    (4, 'Completion Badge', '2024-04-19', 4),
    (5, 'Quiz Master', '2024-04-20', 5),
    (6, 'Top Performer', '2024-04-21', 6),
    (7, 'Completion Badge', '2024-04-22', 7),
    (8, 'Quiz Master', '2024-04-23', 8),
    (9, 'Top Performer', '2024-04-24', 9),
    (10, 'Completion Badge', '2024-04-25', 10);

INSERT INTO LeaderBoard (learner_id, total_points) 
VALUES 
    (1, 1000),
    (2, 950),
    (3, 980),
    (4, 850),
    (5, 900),
    (6, 1100),
    (7, 820),
    (8, 925),
    (9, 970),
    (10, 990);

INSERT INTO module (module_id, module_title, course_id) 
VALUES 
    (1, 'Module 1', 1),
    (2, 'Module 2', 1),
    (3, 'Module 3', 2),
    (4, 'Module 4', 2),
    (5, 'Module 5', 3),
    (6, 'Module 6', 3),
    (7, 'Module 7', 4),
    (8, 'Module 8', 4),
    (9, 'Module 9', 5),
    (10, 'Module 10', 5);

INSERT INTO lesson (lesson_id, lesson_title, module_id) 
VALUES 
    (1, 'Lesson 1', 1),
    (2, 'Lesson 2', 1),
    (3, 'Lesson 3', 2),
    (4, 'Lesson 4', 2),
    (5, 'Lesson 5', 3),
    (6, 'Lesson 6', 3),
    (7, 'Lesson 7', 4),
    (8, 'Lesson 8', 4),
    (9, 'Lesson 9', 5),
    (10, 'Lesson 10', 5);


INSERT INTO Progress (user_id, lesson_id, progress_percent) 
VALUES 
    (1, 1, 100),
    (1, 2, 80),
    (2, 3, 90),
    (2, 4, 70),
    (3, 5, 95),
    (3, 6, 85),
    (4, 7, 75),
    (4, 8, 65),
    (5, 9, 85),
    (5, 10, 75),
    (6, 1, 100),
    (6, 2, 90),
    (7, 3, 80),
    (7, 4, 70),
    (8, 5, 95),
    (8, 6, 85),
    (9, 7, 75),
    (9, 8, 65),
    (10, 9, 85),
    (10, 10, 75);

