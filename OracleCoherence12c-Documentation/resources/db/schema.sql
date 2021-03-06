CREATE TABLE Action (oid INTEGER NOT NULL, actDate TIMESTAMP, oversion INTEGER, PRIMARY KEY (oid));
CREATE TABLE AddressChangeAction (oid INTEGER NOT NULL, borrowerOID INTEGER, city VARCHAR(255), street VARCHAR(255), PRIMARY KEY (oid));
CREATE TABLE Book (oid INTEGER NOT NULL, dueDate TIMESTAMP, title VARCHAR(255), oversion INTEGER, borrower_oid INTEGER, PRIMARY KEY (oid));
CREATE TABLE BorrowAction (oid INTEGER NOT NULL, PRIMARY KEY (oid));
CREATE TABLE Borrower (oid INTEGER NOT NULL, name VARCHAR(255), oversion INTEGER, city VARCHAR(255), street VARCHAR(255), PRIMARY KEY (oid));
CREATE TABLE LoanAction (oid INTEGER NOT NULL, bookOID INTEGER, borrowerOID INTEGER, PRIMARY KEY (oid));
CREATE TABLE NewAddressChangeAction (oid INTEGER NOT NULL, PRIMARY KEY (oid));
CREATE TABLE NotifyAction (oid INTEGER NOT NULL, bookOID INTEGER, PRIMARY KEY (oid));
CREATE TABLE OPENJPA_SEQUENCE_TABLE (ID SMALLINT NOT NULL, SEQUENCE_VALUE BIGINT, PRIMARY KEY (ID));
CREATE TABLE PartialAddressChangeAction (oid INTEGER NOT NULL, PRIMARY KEY (oid));
CREATE TABLE ReturnAction (oid INTEGER NOT NULL, PRIMARY KEY (oid));
CREATE TABLE Subject (oid INTEGER NOT NULL, name VARCHAR(255), oversion INTEGER, PRIMARY KEY (oid));
CREATE TABLE Subject_Book (subjects_oid INTEGER, books_oid INTEGER);
CREATE TABLE Volunteer (oid INTEGER NOT NULL, hours_per_week INTEGER, oversion INTEGER, borrower_oid INTEGER, PRIMARY KEY (oid));
CREATE INDEX I_BOOK_BORROWER ON Book (borrower_oid);
CREATE INDEX I_SBJC_BK_ELEMENT ON Subject_Book (books_oid);
CREATE INDEX I_SBJC_BK_SUBJECTS ON Subject_Book (subjects_oid);
CREATE INDEX I_VOLUNTR_BORROWER ON Volunteer (borrower_oid);
