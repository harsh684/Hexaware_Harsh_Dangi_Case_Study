create database CARS;
use CARS;

CREATE TABLE Victims ( victimid INT PRIMARY KEY, 
firstname VARCHAR(55), 
lastname VARCHAR(55), 
dob DATE, 
gender VARCHAR(10), 
address VARCHAR(255), 
phno VARCHAR(11));

CREATE TABLE Suspects (
    suspectid INT PRIMARY KEY,
    firstname VARCHAR(55),
    lastname VARCHAR(55),
    sdob DATE,
    gender VARCHAR(10),
    scontactinfo VARCHAR(255)
);

CREATE TABLE LawEnforcementAgencies (
    agencyid INT PRIMARY KEY,
    agencyname VARCHAR(255),
    jurisdiction VARCHAR(255),
    contactinfo VARCHAR(255)
);

CREATE TABLE Officers (
    officerid INT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    badgeno VARCHAR(20),
    officerRank VARCHAR(50),
    contactinfo VARCHAR(255),
    agencyid INT,
    FOREIGN KEY (agencyid) REFERENCES LawEnforcementAgencies(agencyid) ON DELETE CASCADE
);

CREATE TABLE Incidents (
    incidentid INT PRIMARY KEY,
    incidenttype VARCHAR(255),
    incidentdate DATE,
    location VARCHAR(255),
    incidentdesc VARCHAR(1000),
    status VARCHAR(50),
    victimid INT,
    suspectid INT,
    agencyid INT,
    FOREIGN KEY (victimid) REFERENCES Victims(victimid),
    FOREIGN KEY (suspectid) REFERENCES Suspects(suspectid) ON DELETE CASCADE,
    FOREIGN KEY (agencyid) REFERENCES LawEnforcementAgencies(agencyid) ON DELETE CASCADE
);


CREATE TABLE Reports (
    reportid INT PRIMARY KEY,
    incidentid INT,
    reportingofficer INT,
    reportdate DATE,
    reportdetails VARCHAR(1000),
    reportstatus VARCHAR(50),
    FOREIGN KEY (incidentid) REFERENCES Incidents(incidentid),
    FOREIGN KEY (reportingofficer) REFERENCES Officers(officerid) ON DELETE CASCADE
);

CREATE TABLE Evidence(evidenceid int primary key,
descr varchar(220),
locationfound varchar(100),
incidentid int,
FOREIGN KEY (incidentid) references Incidents(incidentid)
);

create table Cases(caseId int primary key,
incidentId int,
caseDescription varchar(225),
foreign key (incidentId) references Incidents(incidentId));


-- Insert into Victims table
INSERT INTO Victims (victimid, firstname, lastname, dob, gender, address, phno)
VALUES (1, 'John', 'Doe', '1990-01-15', 'Male', '123 Main St, Cityville', '555-1234');

INSERT INTO Victims (victimid, firstname, lastname, dob, gender, address, phno)
VALUES (2, 'Ali', 'Baba', '1999-01-15', 'Male', 'Pakistan', '566-123410');

-- Insert into Suspects table
INSERT INTO Suspects (suspectid, firstname, lastname, sdob, gender, scontactinfo)
VALUES (1, 'Jane', 'Smith', '1985-05-20', 'Female', '456 Oak St, Townsville');

INSERT INTO Suspects (suspectid, firstname, lastname, sdob, gender, scontactinfo)
VALUES (2, 'Jada', 'Smith', '2000-05-20', 'Female', 'United Kingdom');

INSERT INTO LawEnforcementAgencies (agencyid, agencyname, jurisdiction, contactinfo)
VALUES (1, 'City Police Department', 'Citywide', '789 Pine St, Metropolis');

insert into incidents values(1,'Murder','2023-10-01','Rudrapur','Mysterious man killed a person.','Under Investigation',1,1,1);


select * from LawEnforcementAgencies;
select * from incidents;
select * from Cases;
select * from reports;
select * from Suspects;
-- delete from reports where reportId=2;
-- delete from LawEnforcementAgencies where agencyId=2;
-- delete from cases where caseId=1;
-- delete from incidents where incidentId=3;
-- delete from suspects where suspectId=3;
-- delete from cases where caseId=10;

-- Insert into LawEnforcementAgencies table