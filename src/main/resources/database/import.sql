INSERT INTO predmetnik.comment (ID, timestamp, body, likes, dislikes, author_name) VALUES
                                                                           (1, CURRENT_TIMESTAMP, 'This is a comment.', 0, 0, 'Author1'),
                                                                           (2, CURRENT_TIMESTAMP, 'This is another comment.', 0, 0, 'Author2'),
                                                                           (3, CURRENT_TIMESTAMP, 'This is yet another comment.', 0, 0, 'Author3'),
                                                                           (4, CURRENT_TIMESTAMP, 'This is still another comment.', 0, 0, 'Author4'),
                                                                           (5, CURRENT_TIMESTAMP, 'This is just another comment.', 0, 0, 'Author5');
INSERT INTO predmetnik.course (ID, name, year) VALUES
                                        (1, 'Course1', 2022),
                                        (2, 'Course2', 2022),
                                        (3, 'Course3', 2022),
                                        (4, 'Course4', 2022),
                                        (5, 'Course5', 2022);

INSERT INTO predmetnik.preference (ID, name) VALUES
                                      (1, 'Preference1'),
                                      (2, 'Preference2'),
                                      (3, 'Preference3'),
                                      (4, 'Preference4'),
                                      (5, 'Preference5');

INSERT INTO predmetnik.professor (ID, name, surname, link) VALUES
                                                    (1, 'Professor1', 'Surname1', 'Link1'),
                                                    (2, 'Professor2', 'Surname2', 'Link2'),
                                                    (3, 'Professor3', 'Surname3', 'Link3'),
                                                    (4, 'Professor4', 'Surname4', 'Link4'),
                                                    (5, 'Professor5', 'Surname5', 'Link5');

INSERT INTO predmetnik.program (ID, name) VALUES
                                   (1, 'Program1'),
                                   (2, 'Program2'),
                                   (3, 'Program3'),
                                   (4, 'Program4'),
                                   (5, 'Program5');


INSERT INTO predmetnik.student (index, name, surname, password, preference_ID, program_ID, role) VALUES
                                                                                          (1, 'Student1', 'Surname1', 'Password1', 1, 1, 'ROLE_USER'),
                                                                                          (2, 'Student2', 'Surname2', 'Password2', 1, 1, 'ROLE_USER'),
                                                                                          (3, 'Student3', 'Surname3', 'Password3', 1, 1, 'ROLE_USER'),
                                                                                          (4, 'Student4', 'Surname4', 'Password4', 1, 1, 'ROLE_USER'),
                                                                                          (5, 'Student5', 'Surname5', 'Password5', 1, 1, 'ROLE_USER');

INSERT INTO predmetnik.personal (ID, owner_index) VALUES
                                                      (1, 1),
                                                      (2, 1),
                                                      (3, 1),
                                                      (4, 1),
                                                      (5, 1);

INSERT INTO predmetnik.course_comments (course_id, comments_id) VALUES
                                                                    (1, 1),
                                                                    (2, 2),
                                                                    (3, 3),
                                                                    (4, 4),
                                                                    (5, 5);

INSERT INTO predmetnik.personal_personal_courses (personal_id, personal_courses_id) VALUES
                                                                                        (1, 1),
                                                                                        (2, 2),
                                                                                        (3, 3),
                                                                                        (4, 4),
                                                                                        (5, 5);

INSERT INTO predmetnik.preference_suggested_courses (preference_id, suggested_courses_id) VALUES
                                                                                              (1, 1),
                                                                                              (2, 2),
                                                                                              (3, 3),
                                                                                              (4, 4),
                                                                                              (5, 5);

INSERT INTO predmetnik.professor_teaching_courses (professor_id, teaching_courses_id) VALUES
                                                                                          (1, 1),
                                                                                          (2, 2),
                                                                                          (3, 3),
                                                                                          (4, 4),
                                                                                          (5, 5);

INSERT INTO predmetnik.program_courses_in_program (program_id, courses_in_program_id) VALUES
                                                                                          (1, 1),
                                                                                          (2, 2),
                                                                                          (3, 3),
                                                                                          (4, 4),
                                                                                          (5, 5);

INSERT INTO predmetnik.program_courses_in_program (program_id, courses_in_program_id) VALUES
                                                                                          (1, 1),
                                                                                          (2, 2),
                                                                                          (3, 3),
                                                                                          (4, 4),
                                                                                          (5, 5);