CREATE DATABASE SchoolDB;
GO

USE SchoolDB;
GO

CREATE TABLE Subjects (
    SubjectID INT NOT NULL PRIMARY KEY,
    SubjectName NVARCHAR(100) NOT NULL
);
GO

CREATE TABLE Instructors (
    InstructorID INT NOT NULL PRIMARY KEY,
    InstructorName NVARCHAR(100) NOT NULL,
    BirthDate DATE NULL,
    Gender NVARCHAR(10) NULL,
    SubjectID INT NULL,
    CONSTRAINT FK_Instructors_Subjects FOREIGN KEY (SubjectID) 
        REFERENCES Subjects(SubjectID)
);
GO

CREATE TABLE Students (
    StudentID INT NOT NULL PRIMARY KEY,
    StudentName NVARCHAR(100) NOT NULL,
    BirthDate DATE NULL,
    Gender NVARCHAR(10) NULL,
    SubjectID INT NULL,
    CONSTRAINT FK_Students_Subjects FOREIGN KEY (SubjectID) 
        REFERENCES Subjects(SubjectID)
);
GO