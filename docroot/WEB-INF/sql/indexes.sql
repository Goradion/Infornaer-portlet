create index IX_665A3C8C on sbam_Highscore (userId);

create index IX_AF875B31 on sbam_Question (category[$COLUMN_LENGTH:75$], difficulty);
create index IX_13FE9AB on sbam_Question (categoryId_fk);
create index IX_E50389BF on sbam_Question (difficulty);
create index IX_80CF1425 on sbam_Question (questionId);

create index IX_1477E12D on sbam_UserQuestion (category[$COLUMN_LENGTH:75$]);
create index IX_169DB56A on sbam_UserQuestion (difficulty);

create index IX_A4D2D45A on wwi_Highscore (userId);

create index IX_46746223 on wwi_Question (category[$COLUMN_LENGTH:75$], difficulty);
create index IX_B88D3731 on wwi_Question (difficulty);
create index IX_5458C197 on wwi_Question (questionId);