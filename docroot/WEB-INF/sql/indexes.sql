create index IX_E514BFC5 on sbam_Category (categoryName[$COLUMN_LENGTH:75$]);
create index IX_6C16EC7F on sbam_Category (unlocked);

create unique index IX_C4C8C13D on sbam_Difficulty (score);

create index IX_665A3C8C on sbam_Highscore (userId);

create index IX_508FAED3 on sbam_Question (categoryId_fk, difficultyId_fk);
create index IX_BAE07CCE on sbam_Question (difficultyId_fk);
create index IX_80CF1425 on sbam_Question (questionId);

create index IX_1477E12D on sbam_UserQuestion (category[$COLUMN_LENGTH:75$]);
create index IX_169DB56A on sbam_UserQuestion (difficulty);