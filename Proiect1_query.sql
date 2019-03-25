SET SQL_SAFE_UPDATES = 0;
/*
insert into student
values(1,'andrei','123','strada1','qwe','qwe');

insert into student
values(2,'ana','124','strada2','asd','asd');

insert into student
values(3,'ion','125','strada3','zxc','zxc');

insert into student
values(4,'vasile','126','strada4','qaz','qaz');

###############################################

insert into StudentProfile
values(1,3,1);

insert into StudentProfile
values(2,4,2);

insert into StudentProfile
values(3,2,3);

insert into StudentProfile
values(4,1,4);

###############################################

insert into Curs
values(1,'Eco',10,12,2,2);

insert into Curs
values(2,'Math',11,13,1,1);

insert into Curs
values(3,'Med',12,14,1,2);

insert into Curs
values(4,'Physics',8,10,2,1);

#################################################

insert into StudentProfile_has_Curs
values(1,1,8,8,6);

insert into StudentProfile_has_Curs
values(1,3,9,8,7);

insert into StudentProfile_has_Curs
values(1,4,6,7,8);

insert into StudentProfile_has_Curs
values(2,2,10,5,6);

insert into StudentProfile_has_Curs
values(3,2,10,10,10);

insert into StudentProfile_has_Curs
values(3,4,9,7,2);

insert into StudentProfile_has_Curs
values(4,1,9,10,5);

insert into StudentProfile_has_Curs
values(4,3,6,5,7);

*/
###################################################

#select * from student
#inner join student ON StudentProfile.student_idstudent = 3;

#select * from student
#inner join StudentProfile ON student.idstudent = StudentProfile.student_idstudent;

#select * from StudentProfile
#where student_idstudent = 3;

/*
update student
set nume = 'ionB'
where nume = 'ion';
*/
#select * from StudentProfile where student_idstudent = 2;

#delete from StudentProfile_has_Curs where idStudentProfile = 5;
#delete from StudentProfile where idStudentProfile = 5;
#delete from student where idStudent = 5;

#idStudent, Curs.nume, notaPartial, notaColocviu, notaExamen
select * from student
inner join StudentProfile ON student.idstudent = StudentProfile.student_idstudent
inner join StudentProfile_has_Curs ON StudentProfile.idStudentProfile = StudentProfile_has_Curs.idStudentProfile
inner join Curs ON StudentProfile_has_Curs.idCurs = Curs.idCurs; #where idstudent = 2;

#select * from student,Curs
#where idstudent = 2;



#select * from StudentProfile
#where student_idstudent = 3;


#select * from student
#where student.userName = 'asds' AND student.password = 'asds';

select * from student;
select * from StudentProfile;
select * from Curs where nume = 'Eco';
select * from StudentProfile_has_Curs;

#delete from student;
#delete from StudentProfile;