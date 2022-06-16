create table user_tbl(
	user_id varchar2(30),
	pwd varchar2(30) not null,
	user_name varchar2(30) not null,
	user_nickname varchar2(60) not null,
	join_date date not null,
	is_del char(1) default '0',
	
	constraint user_pk primary key(user_id)
);

ALTER TABLE board_tbl modify content varchar(2000);


create table board_tbl (
	board_id number,
	user_id varchar2(30) not null,
	title varchar2(200) not null,
	content varchar2(1000) not null,
	write_date date not null,
	is_del char(1) default '0',
	
	constraint board_pk primary key(board_id)
);

create table comment_tbl (
	comment_id number,
	board_id number not null,
	user_id varchar2(30) not null,
	content varchar2(500) not null,
	write_date date not null,
	is_del char(1) default '0',
	
	constraint comment_pk primary key(comment_id)
);

insert into COMMENT_TBL values(content_seq.nextval, ?, ?, ?, SYSDATE, 0);
insert into board_tbl values(board_seq.nextval, 'admin', '테스트', '테스트 게시물입니다.', SYSDATE, '0');
insert into board_tbl values(board_seq.nextval, 'admin', '테스트', '테스트 게시물입니다.', SYSDATE, '0');
insert into board_tbl values(board_seq.nextval, 'admin', '테스트', '테스트 게시물입니다.', SYSDATE, '0');
insert into board_tbl values(board_seq.nextval, 'admin', '테스트', '테스트 게시물입니다.', SYSDATE, '0');
insert into board_tbl values(board_seq.nextval, 'admin', '테스트', '테스트 게시물입니다.', SYSDATE, '0');
insert into board_tbl values(board_seq.nextval, 'admin', '테스트', '테스트 게시물입니다.', SYSDATE, '0');
insert into board_tbl values(board_seq.nextval, 'admin', '테스트', '테스트 게시물입니다.', SYSDATE, '0');

select * from user_tbl where user_id = 'wooae1234' and pwd = 1232;
select * from user_tbl;

select * from board_tbl;
select * from comment_tbl where board_id = 1 and is_del = 0;

update BOARD_TBL set is_del = '1' where board_id = 1;
select * from (select rownum AS SEQ,b.* from board_tbl b join user_tbl u on (b.user_id = u.user_id) where b.is_del = '0' order by board_id) where SEQ >= 7 and SEQ <= 12;
select rownum,b.* from board_tbl b join user_tbl u on (b.user_id = u.user_id) where b.is_del = '0' order by board_id
select * from (select rownum AS SEQ, b.*, u.user_nickname from board_tbl b join user_tbl u on (b.user_id = u.user_id) where b.is_del = '0' order by b.board_id desc) where SEQ >= 1 and SEQ <= 6;
select * from (select tbl.*, rownum as seq from (select b.*, u.user_nickname from board_tbl b join user_tbl u on (b.user_id = u.user_id) where b.is_del = '0' order by b.board_id desc) tbl) where seq >= 1 and seq <= 6;

select * from (select rownum AS SEQ, b.*, u.user_nickname from board_tbl b join user_tbl u on (b.user_id = u.user_id) where b.is_del = '0' and title like '%박홍식%' order by board_id desc) where SEQ >= 1 and SEQ <= 6;
select count(*) cnt from board_tbl where is_del = '0' and title like '%박홍식%';

select * from board_tbl;

update board_tbl set is_del = 1 where board_id = 11;

drop table user_tbl;
drop table board_tbl;
drop table comment_tbl;

create sequence board_seq start with 1 increment by 1 maxvalue 9999 nocycle nocache;
create sequence content_seq start with 1 increment by 1 maxvalue 9999 nocycle nocache;
