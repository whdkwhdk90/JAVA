DROP SEQUENCE BOARDNOSQ;
DROP SEQUENCE GROUPNOSQ;
DROP TABLE ANSWERBOARD;

--글 번호 시퀀스(PRIMARY KEY)
CREATE SEQUENCE BOARDNOSQ NOCACHE;
--그룹번호 시퀀스(새로운 글 등록할때만)
CREATE SEQUENCE GROUPNOSQ NOCACHE;

--글번호, 그룹번호, 그룹순서, 제목탭, 제목, 내용, 작성자, 작성일
-- 그룹 순서로 정렬하고 글 번호로 정렬해서 하는 거인듯.
-- titletab은 들여쓰기 횟수.
CREATE TABLE ANSWERBOARD(
	BOARDNO NUMBER PRIMARY KEY,
	GROUPNO NUMBER NOT NULL,
	GROUPSQ NUMBER NOT NULL,
	TITLETAB NUMBER NOT NULL,
	TITLE VARCHAR2(2000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WRITER VARCHAR2(1000) NOT NULL,
	REGDATE DATE NOT NULL
);

SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSQ;

--첫번째 글 작성
-- GROUPNOSQ는 새로운 글을 등록할때만 사용(답글 시에는 NEXTVAL로 사용하지않음)
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,GROUPNOSQ.NEXTVAL,1,0,'첫번째 글','1번 글입니다.','유저1',SYSDATE
);

--두번째 글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,GROUPNOSQ.NEXTVAL,1,0,'두번째 글','2번 글입니다.','유저2',SYSDATE
);

--1번글 답글 작성
--부모와 같은 GROUPNO, 부모의 GROUPSQ+1, 부모의 TITLETAB+1
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=1),
		(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=1)+1,
		(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=1)+1,
		'RE:첫번째 글','1번 글의 답글입니다.','유저2',SYSDATE
);

--세번째 글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,GROUPNOSQ.NEXTVAL,1,0,'세번째 글','3번 글입니다.','유저3',SYSDATE
);

--2번글 답글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2),
		(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2)+1,
		(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=2)+1,
		'RE:두번째 글','2번 글의 답글입니다.(1)','유저1',SYSDATE
);

--답글 작성(RE:두번째 글 - NO.5)
--부모와 같은 GROUPNO, 부모의 GROUPSQ+1, 부모의 TITLETAP+1
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=5),
		(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=5)+1,
		(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=5)+1,
		'RE:RE:두번째 답글','2번 글의 답글입니다.(2)','유저2',SYSDATE
);

--답글 작성(두번째 글 - NO.2)
UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1
WHERE GROUPNO=(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2) 
	AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2);

	
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2),
		(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2)+1,
		(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=2)+1,
		'RE:두번째 글','2번 글의 답글입니다!!!!.(2)','유저2',SYSDATE
);

DELETE FROM ANSWERBOARD WHERE BOARDNO = 7;

--답변 작성(RE:두번째글 -NO.8)
UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1
WHERE GROUPNO=(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=8) 
	AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=8);

	
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=8),
		(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=8)+1,
		(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=8)+1,
		'RE:두번째 글','2번 글의 답글입니다!!!!.(2)','유저2',SYSDATE
);








