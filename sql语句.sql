/*
数据库循环插入数据：
*/
declare i number;
begin
 for i in 0 .. 50000 loop
		insert into tb_agent_zj_monitor_zx(gradetime,dealoper,begintime,monitorid,callid,starttime,RECORDTIME,CONTACTNO)
		VALUES ('26-6月 -19 04.55.38.946268 上午','qd1999',SEQ_BSRH_NOTICE_ID.NEXTVAL,'1666','006c02bcde30fe11',  SEQ_BSRH_NOTICE_ID.NEXTVAL  ,'09-7月 -18 10.01.32.069306 上午 +08:00','10064');

		end loop;
		DBMS_OUTPUT.PUT_LINE('成功录入数据');
		commit;
end;

/*
更新某个字段，替换字符，注意“？”的中英文
*/
update sm_dict_grade set name = replace(name,'？','') where name like '%？%';