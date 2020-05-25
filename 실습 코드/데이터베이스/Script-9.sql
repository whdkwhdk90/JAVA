-- DELETE --
--  테이블의 행을 삭제하는 명령어
-- [사용형식]
-- DELETE FROM 테이블명 [WHERE 조건]


CREATE TABLE TEST_DELETE
AS
		SELECT * FROM EMPLOYEE;
	
-- DEPT_ID가 D1인 것은 참조되고 있어서 삭제 불가
-- ORA-02292: integrity constraint (TEST.SYS_C007132) violated - child record found
DELETE FROM DEPARTMENT 
WHERE DEPT_ID = 'D1';
	
-- 1) 제약 조건 관련 컬럼에 삭제 옵션 적용하기
-- ON DELETE CASCADE : 부모가 지워질 때 자식 컬럼도 함께 삭제 
-- ON DELETE SET NULL : 부모가 지워질 때 자식은 NULL값으로 변경

-- 2) 제약조건을 비활성화하여 삭제가 가능하게 설정 변경
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMPLOYEE';

-- 제약조건 비활성화
ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT EMPLOYEE_PK;
-- 제약조건은 함부로 건드리지 말기

-- 제약조건 활성화
ALTER TABLE EMPLOYEE 
ENABLE CONSTRAINT EMPLOYEE_PK;
	
-- TRUNCATE : DELETE와 유사하게 테이블의 정보를 삭제하는 명령어
-- ** DELETE보다 빠르지만, 삭제 후 ROLLBACK 불가능

SELECT * FROM EMP_SALARY;
COMMIT;
-- DELETE를 통해 데이터 전체 삭제
DELETE FROM EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;
SELECT * FROM EMP_SALARY;
	
-- TRUNCATE 사용
TRUNCATE TABLE EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;
SELECT * FROM EMP_SALARY;

-- TCL
-- TRANSACTION CONTROL LANGUAGE --
-- 트랜잭션 제어 언어(COMMIT, ROLLBACK, SAVEPOINT, ROLLBACK TO)
	
-- 트랜잭션 : 데이터를 처리하는 작업을 잘게 나눈 데이터 처리의 최소 단위	

-- COMMIT : 트랜잭션이 종료 될 때 정상적으로 종료되었다면 변경사항을 DB에 저장하겠다.
-- ROLLBACK : 트랜잭션이 작업 중 오류가 발생할 경우 잘못작업한 내역을 취소하겠다.
-- SAVEPOINT 임시저장소명 : 현재 트랜잭션 수행 중 특정 구역을 나누어 현재까지 진행된 부분만 별도로 중간에 저장하겠다.
-- ROLLBACK TO :임시저장소명 : 트랜잭션 작업 중 임시 저장된 SAVEPOINT를 찾아 해당 부분까지 원상복구할 때 사용
COMMIT;
CREATE TABLE USER_TBL(
			USER_NO NUMBER UNIQUE,
			USER_ID VARCHAR2(20) NOT NULL UNIQUE,
			USER_PWD VARCHAR2(30) NOT NULL
);
INSERT INTO USER_TBL VALUES(1, 'TEST01', 'PASS01');	
INSERT INTO USER_TBL VALUES(2, 'TEST02', 'PASS02');
COMMIT;
SELECT * FROM USER_TBL;

INSERT INTO USER_TBL VALUES(3,'TEST03','PASS03');
SELECT * FROM USER_TBL;

--롤백했을 때 COMMIT을 한 시점은 데이터가 2개만 들어가있을 때이므로 2개만 조회됨.
ROLLBACK;
	
SELECT * FROM USER_TBL;	
	
INSERT INTO USER_TBL VALUES(3,'TEST03','PASS03');

SAVEPOINT SP1;

INSERT INTO USER_TBL VALUES(4,'TEST04','PASS04');

SELECT * FROM USER_TBL;

--SP1 지점으로 되돌리겠다(그러면 3개의 데이터가 있는 시점으로 되돌아감)
ROLLBACK TO SP1;

SELECT * FROM USER_TBL;

--이전에 COMMIT한 시점이 데이터가 2개인 시점이기에 데이터가 2개밖에없음
--ROLLBACK 하고 ROLLBACK TO SP1하면 에러 뜸.(이미 SP1지점 전으로 돌아왔기에 다시 못 돌아감)
ROLLBACK;

SELECT * FROM USER_TBL;


-- DROP --
-- 객체의 특정요소를 제거하거나 객체자체를 제거할 때 사용하는 명령어
-- [형식1]
-- ALTER 객체 객체명
-- DROP 지우고자 하는 요소

-- [형식2]
-- DROP 객체 객체명

SELECT * FROM DEPT_COPY;

-- DROP (컬럼명)
ALTER TABLE DEPT_COPY
DROP (DEPT_TITLE);

-- 제약조건 삭제
CREATE TABLE CONST_TAB(
		EID CHAR(2),
		ENAME VARCHAR2(15) NOT NULL,
		AGE NUMBER NOT NULL,
		DEPT CHAR(5),
		-- 테이블 레벨
		CONSTRAINT PK_TAB PRIMARY KEY(EID),
		CONSTRAINT UK_TAB UNIQUE(ENAME),
		CONSTRAINT CK_TAB CHECK(AGE>0),
		CONSTRAINT FK_TAB FOREIGN KEY(DEPT) REFERENCES DEPARTMENT ON DELETE CASCADE
);

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CONST_TAB';

-- 제약조건 삭제하기
ALTER TABLE  CONST_TAB
DROP CONSTRAINT CK_TAB;

SELECT * FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'CONST_TAB';

-- 제약조건 여러 개 삭제하기
ALTER TABLE CONST_TAB 
DROP CONSTRAINT UK_TAB
DROP CONSTRAINT FK_TAB
DROP CONSTRAINT PK_TAB;

SELECT * FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'CONST_TAB';

-- 제약조건 삭제하기
ALTER TABLE CONST_TAB 
DROP CONSTRAINT SYS_C007179;

-- AGE를 NULL로 수정하겠다(입력을 하든 안하든 상관없다라는 의미)
ALTER TABLE CONST_TAB
MODIFY (AGE NULL);

SELECT * FROM CONST_TAB;

-- 객체 삭제
DROP TABLE CONST_TAB;
DROP USER KING;

-- 관리자 계정 내용 --
-- CMD 작성해서 SYSTEM 혹은 위에 TEST를 SYSTEM으로 바꾸기
-- CREATE USER KING IDENTIFIED BY QUEEN; -- 계정 생성
-- GRANT CONNECT, RESOURCE TO KING -- 권한 부여
-- CONN KING/QUEEN; -- 계정 접속
-- DROP USER KING; -- 계정 삭제
----------------

-- 오라클 객체
-- VIEW(뷰) --

-- VIEW : SELECT를 실행한 결과 화면을 담는 객체
-- SELECT문장 자체를 저장하여 호출할 때 마다 해당 쿼리를 실행하여 결과를 보여주는 객체.

-- [사용방법]
-- CREATE [OR REPLACE] VIEW 뷰이름
-- AS 서브쿼리(뷰에서 확인할 SELECT 쿼리);
-- CREATE OR REPLACE는 없으면 만들고 있으면 대체하라는 의미임.

-- 관리자계정에서 뷰 생성 권한 부여
GRANT CREATE VIEW TO TEST;
COMMIT;
-------------------------------------------
-- ORA-01031: insufficient privileges
-- TEST계정이 뷰를 생성할 수 있는 권한이 없음
CREATE VIEW V_EMP
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE
		FROM EMPLOYEE;
	
SELECT * FROM V_EMP;

-- 이미 생성된 뷰가 있더라도 REPLACE를 통해 새롭게 생성 가능하다.
CREATE OR REPLACE VIEW V_EMP(사번, 이름, 부서, 직급)
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
		FROM EMPLOYEE;
	
SELECT * FROM V_EMP;

-- 생성된 뷰 정보 확인
SELECT * FROM USER_VIEWS;

-- 실습 1.
-- 사번, 이름, 직급명, 부서명, 근무지역을 조회하고
-- 그 결과를 V_RESULTSET_EMP 라는 뷰를 만들어
-- 뷰를 통해 그 결과를 조회하여 확인
-- 1) 서브쿼리 준비
-- 2) 뷰에 대입해서 사용

CREATE VIEW V_RESULTSET_EMP(사번,이름,직급명,부서명,근무지)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
			FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L
			WHERE E.JOB_CODE  = J.JOB_CODE
						AND E.DEPT_CODE  = D.DEPT_ID
							AND D.LOCATION_ID  = L.LOCAL_CODE;

SELECT * FROM V_RESULTSET_EMP;						

-- 실습2.
-- 만들어진 VIEW를 활용하여 사번이 '205'번인 직원 정보 조회하기

SELECT * 
FROM V_RESULTSET_EMP
WHERE 사번 = '205';

-- VIEW는 SELECT 쿼리를 저장하고 있기 때문에
-- 원본 테이블의 값이 변경되었을 때 뷰도 함께 변경된 값을 조회 가능

UPDATE EMPLOYEE SET EMP_NAME = '정종아' WHERE EMP_ID = '205';

SELECT * FROM EMPLOYEE WHERE EMP_ID = '205';

SELECT * FROM V_RESULTSET_EMP WHERE 사번 = '205';

COMMIT;

-- 뷰 삭제
DROP VIEW V_RESULTSET_EMP;
SELECT * FROM USER_VIEWS;


-- 뷰에 데이터 삽입, 수정, 삭제
CREATE OR REPLACE VIEW V_JOB
AS
SELECT * FROM JOB;

SELECT * FROM V_JOB;

-- 뷰를 통한 데이터 추가(뷰를 통한 데이터 추가가 JOB에 추가하는거랑 같다)
INSERT INTO V_JOB  VALUES('J8','인턴');
SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- 뷰를 통한 데이터 수정
UPDATE V_JOB SET JOB_NAME = '알바' WHERE JOB_CODE = 'J8';
SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- 뷰를 통한 데이터 삭제
DELETE FROM V_JOB WHERE JOB_CODE = 'J8';
SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- DML 명령어가 안되는 경우
-- 뷰에 정의되지 않은 컬럼 값을 변경하려고 하는 경우
-- 산술 연산이 포함된 컬럼
-- 일반적으로는 JOIN을 한 테이블 정보를 가진 뷰
-- DISTINCT를 뷰에 사용했을 때
-- 그룹함수를 사용하거나, GROUP BY를 통한 결과값을 포함한 경우


-- 뷰에 정의 되어있지 않은 컬럼을 수정할 경우
CREATE OR REPLACE VIEW V_JOB
AS SELECT JOB_CODE FROM JOB;

SELECT * FROM V_JOB;
-- ORA-00913: too many values
-- 넣는건 JOB_CODE 하난데 2개 넣으려 해서 오류뜸
INSERT INTO V_JOB VALUES('J8','인턴');

-- ORA-00904: "JOB_NAME": invalid identifier
-- JOB_NAME이 없다
UPDATE V_JOB SET JOB_NAME = '인턴' WHERE JOB_CODE ='J7';


-- 산술 표현일 경우
CREATE OR REPLACE VIEW V_EMP_SAL
AS
SELECT EMP_ID, EMP_NAME, SALARY,
		(SALARY+SALARY*NVL(BONUS,0))*12 연봉
FROM EMPLOYEE;

SELECT * FROM V_EMP_SAL;

--ORA-01733: virtual column not allowed here
-- 마지막 컬럼은 가상의 컬럼이라서 넣을 수가 없음.
INSERT INTO V_EMP_SAL
VALUES(901,'장하영',3000000,4000000);

-- JOIN을 통해서 VIEW의 정보를 수정하는 경우
CREATE OR REPLACE VIEW V_JOIN_EMP
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID );

SELECT * FROM V_JOIN_EMP;	

-- ORA-01776: cannot modify more than one base table through a join view
-- JOIN을 해서 가져온건 함부로 수정하거나 넣을수가없다.
INSERT INTO V_JOIN_EMP
VALUES(911,'이대희','기술지원부');

-- 그룹함수, GROUP BY
-- ORA-00998: must name this expression with a column alias
-- 그룹함수를 통해 VIEW를 만들려고하면 별칭을 줘야 만들어짐.
CREATE OR REPLACE VIEW V_GROUP_DEPT
AS
SELECT DEPT_CODE, SUM(SALARY) 합계, TRUNC(AVG(SALARY),-4) 평균
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT * FROM V_GROUP_DEPT;

INSERT INTO V_GROUP_DEPT
VALUES('D10',50000,50000);

UPDATE V_GROUP_DEPT
SET DEPT_CODE = 'D10'
WHERE DEPT_CODE = 'D5';

DELETE FROM V_GROUP_DEPT
WHERE DEPT_CODE = 'D6';

-- 뷰를 왜 쓰는가?
-- 수정을 못하게끔
-- 테이블이 존재하지않더라도 강제적으로 만들수 있게
-- 동일한 뷰가 있으면 덮어쓰기


-- VIEW 생성 시 설정 옵션
-- OR REPLACE : 기존에 있던 동일한 이름의 뷰가 있을 경우
--								해당 뷰를 덮어씌우고, 없다면 새로 만들겠다.
-- FORCE / NOFORCE : 서브쿼리에 사용되는 테이블이 존재하지 않아도
--										뷰를 강제생성 할 것인지 결정
-- WITH CHECK / READ ONLY
--					CHECK : 옵션 설정한 컬럼의 값을 바꾸지 못하게 막는 설정
--					READ ONLY : 뷰에 사용된 어떠한 컬럼도 뷰를 통해서 변경하지 못하게 막는 설정 

-- FORCE : 존재하지 않는 테이블이라도 뷰를 강제로 생성
CREATE OR REPLACE FORCE VIEW V_EMP
AS
SELECT T_CODE, T_NAME, T_CONTENT
FROM TEST_TABLE;

--생성은 강제로 했지만 조회는 당연히 안됨
SELECT * FROM V_EMP;

DROP VIEW V_EMP;

-- NO FORCE : 만약 생성하려는 뷰의 테이블이 존재하지 않는다면 뷰를 생성하지 않겠다.
-- 기본 DEFAULT값이 NOFORCE로 되어있음.
CREATE OR REPLACE /*NOFORCE*/ VIEW V_EMP
AS
SELECT T_CODE, T_NAME, T_CONTENT
FROM TEST_TABLE;

-- WITH CHECK : 뷰에 존재하는 컬럼에 추가하거나 수정하지 못하게 막는 뷰의 옵션
--1)
CREATE OR REPLACE VIEW V_EMP
AS
SELECT * FROM EMPLOYEE
WITH CHECK OPTION;

SELECT * FROM V_EMP;

--ORA-32575: Explicit column default is not supported for modifying views
--추가 수정불가능하게 막아놔서 못함
INSERT INTO V_EMP VALUES(784, '이창진','101010-1234567','LEE@KH.OR.KR','01012344321',
													'D1','J7','S1',8000000,0.1,200,SYSDATE,NULL,DEFAULT);
--근데 DELETE는 됨.
DELETE FROM V_EMP WHERE EMP_ID = '900';

SELECT * FROM V_EMP;

-- WITH READ ONLY : 데이터의 입력, 수정, 삭제 모두 막는 옵션
CREATE OR REPLACE VIEW V_EMP
AS
SELECT * FROM EMPLOYEE
WITH READ ONLY;

--READ ONLY하면 추가 수정 삭제 다 안되는 것을 알 수 있음.
INSERT INTO V_EMP VALUES(784, '이창진','101010-1234567','LEE@KH.OR.KR','01012344321',
													'D1','J7','S1',8000000,0.1,200,SYSDATE,NULL,DEFAULT);
DELETE FROM V_EMP WHERE EMP_ID = '500';

----------------------------
-- ## ROLE
----------------------------

--> 사용자에게 여러 개의 권한을 한 번에 부여 할 수 있는 데이터베이스 객체
-- ORACLE DB 설치 시 기본 제공되는 ROLE
-- CONNECT : 사용자가 데이터베이스에 접속 가능하도록 하기 위한 권한이 있는 ROLE
-- RESOURCE : 사용자가 객체를 생성하기 위한 시스템 권한 제공되는 ROLE
-- DBA : 시스템 자원을 무제한적으로 사용가능하며 시스템 관리를 하기 위한 모든 권한을 제공하는 ROLE

-- ROLE에 부여된 시스템 권한 확인
SELECT * FROM ROLE_SYS_PRIVS 
-- WHERE ROLE = 'RESOURCE';
 WHERE ROLE = 'CONNECT';

-- SYSTEM 계정 시작
SELECT * FROM ROLE_SYS_PRIVS  WHERE ROLE = 'DBA';

CREATE USER TESTER IDENTIFIED BY TESTER;
GRANT CONNECT, RESOURCE TO TESTER;

--특정 사용자에게 특정 테이블(EMPLOYEE)에 대한 조회 권한 부여하기
-- ROLE 생성
CREATE ROLE EMP_ROLE;

-- ROLE에 권한 부여
GRANT SELECT ON KH.EMPLOYEE TO EMP_ROLE;

-- 흐름의 이해
-- 1) ROLE 생성
-- 2) ROLE에 권한 부여
-- 3) ROLE을 사용자에게 부여

-- TEST 사용자에게 EMP_ROLE 권한 부여
GRANT EMP_ROLE TO TESTER;

-- TEST계정에서 EMPLOYEE 테이블 권한 확인
SELECT * FROM KH.EMPLOYEE;
---------------------------------------------

-- 권한 회수(관리자 계정)
REVOKE EMP_ROLE FROM TESTER;
-- 권한 회수되었기에 KH의 EMPLOYEE는 확인 불가
SELECT * FROM KH.EMPLOYEE;

-- SEQUENCE : 시퀀스
-- 1,2,3,4,5 .... 형식으로 숫자데이터를 자동으로 카운트 하는 객체

/*
  		CREATE SEQUENCE 시퀀스명
  		[START WITH 숫자] : 시작값, 생략하면 1부터 시작	
  		[INCREMENT BY 숫자] : 다음 값에 대한 증감 수치, 생략 시 1씩 증가
  												-- INCREMENT BY 5 --> 5씩 증가					
  		[MAXVALUE	숫자 | NOMAXVALUE] : 발생시킬 값의 최댓값 설정
  		[MINVALUE		숫자 | NOMINVALUE] :  발생시킬 값의  최솟값 설정
		[CYCLE | NOCYCLE] : 값의 순환 여부 (1~10 ... 1~10 ... 1~10)
		[CACHE 바이트 크기 | NOCACHE] : 값을 미리 구해놓고 다음 값을 반영할 때 활용하는 설정  		
 */

CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

-- 310을 넘어가게 되면 최댓값을 넘어가게 되므로 에러 발생
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
-- 현재 시퀀스 확인
SELECT SEQ_EMPID.CURRVAL FROM DUAL;

-- 시퀀스는 변경 시에 초기값은 설정할 수 없다.
-- 초기값 변경 하고자 할 때는 DROP 후 재생성
ALTER SEQUENCE SEQ_EMPID
--START WITH 315
INCREMENT BY 10
MAXVALUE 400
NOCYCLE
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

-- 시퀀스 정보가 들어있는 데이터 사전
SELECT * FROM USER_SEQUENCES;

-- 시퀀스 삭제하기
DROP SEQUENCE SEQ_EMPID;


-- TEST 계정
-- 시퀀스 이용하여 데이터 추가
CREATE SEQUENCE SEQ_EID
START WITH 300
INCREMENT BY 1
MAXVALUE 10000
NOCYCLE
NOCACHE;

-- 데이터 추가하기
INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '이진호','121212-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D2','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);

SELECT * FROM EMPLOYEE;

-- D9부서에 J7직급의 사원 4명을 시퀀스를 활용하여 추가하시오.
INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '이대희','111111-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);

INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '김승진','570120-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);
			
INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '유장석','990519-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);
			
INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '이준혁','890917-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);			

SELECT * FROM EMPLOYEE;

-- CYCLE / CACHE

-- CYCLE : 시퀀스의 값이 최솟값 혹은 최댓값에 도달 했을 때 다시 반대의 값부터 시작하는 옵션
CREATE SEQUENCE SEQ_CYCLE
START WITH 200
INCREMENT BY 10
MAXVALUE 230
MINVALUE 15
CYCLE 
NOCACHE;

SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;  -- 최댓값 도달!!
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;  -- CYCLE 설정 시 최댓값 도달 후 다시 최솟값부터 시작

-- CACHE : 컴퓨터가 다음 값에 대한 연산들을 그때 그때 수행하지 않고 미리 계산해 놓은 것
-- NOCACHE는 DEFAULT값(그때 그때 처리)

CREATE SEQUENCE SEQ_CACHE
START WITH 100
INCREMENT BY 1
CACHE 20
NOCYCLE;

SELECT SEQ_CACHE.NEXTVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;






















