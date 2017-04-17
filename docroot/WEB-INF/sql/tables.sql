create table sbam_Category (
	categoryId LONG not null primary key,
	categoryName VARCHAR(75) null,
	unlocked BOOLEAN
);

create table sbam_Difficulty (
	guaranteed BOOLEAN,
	score LONG not null primary key
);

create table sbam_Highscore (
	userId LONG not null primary key,
	userName VARCHAR(75) null,
	score LONG
);

create table sbam_Question (
	questionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	questionContent STRING null,
	answerA VARCHAR(75) null,
	answerB VARCHAR(75) null,
	answerC VARCHAR(75) null,
	answerD VARCHAR(75) null,
	categoryId_fk LONG,
	difficultyId_fk LONG,
	rightAnswer VARCHAR(75) null
);

create table sbam_QuestionStatistics (
	questionId LONG not null primary key,
	answered_a LONG,
	answered_b LONG,
	answered_c LONG,
	answered_d LONG
);

create table sbam_UserQuestion (
	userId LONG,
	userName VARCHAR(75) null,
	questionId LONG not null primary key,
	question VARCHAR(75) null,
	answerA VARCHAR(75) null,
	answerB VARCHAR(75) null,
	answerC VARCHAR(75) null,
	answerD VARCHAR(75) null,
	category VARCHAR(75) null,
	difficulty INTEGER,
	rightAnswer VARCHAR(75) null
);

create table sbam_UserStatistics (
	userId LONG not null primary key,
	gamesWon LONG,
	gamesPlayed LONG,
	rightAnswers LONG,
	wrongAnswers LONG
);