create index IX_665A3C8C on sbam_Highscore (userId);


create index IX_13FE9AB on sbam_Question (categoryId_fk);
create index IX_E50389BF on sbam_Question (difficulty);
create index IX_80CF1425 on sbam_Question (questionId);

create index IX_1477E12D on sbam_UserQuestion (category[$COLUMN_LENGTH:75$]);
create index IX_169DB56A on sbam_UserQuestion (difficulty);
