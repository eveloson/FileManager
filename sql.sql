drop table t_doc ;

create table t_doc(
	doc_id 		int primary key auto_increment , 
	doc_name_o 	varchar(255) ,
	doc_name_n 	varchar(255) ,
	doc_dtime 	varchar(255) ,
	doc_ctime 	varchar(50) ,
	doc_size 	varchar(20) ,
	user_id		int
);
select * from t_doc ;

drop table t_user ;

create table t_user(
	user_id 		int primary key auto_increment , 
	user_name 	varchar(255) ,
	user_pwd 	varchar(255) ,
	user_ctime 	varchar(255) 
);
select * from t_doc ;