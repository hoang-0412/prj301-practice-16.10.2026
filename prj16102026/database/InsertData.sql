INSERT INTO Subjects (SubjectID, SubjectName) VALUES 
(1, N'Java core'),
(2, N'Java web'),
(3, N'Database');
GO

INSERT INTO Students (StudentID, StudentName, BirthDate, Gender, SubjectID) VALUES 
('SE170001', N'Tran Hung Cuong', '1996-04-30', N'Male', 1),
('SE170002', N'Le Khanh Van',    '1997-05-03', N'Female', 2),
('SE170003', N'Nguyen Thanh Dat', '1995-04-05', N'Male', 3);
GO