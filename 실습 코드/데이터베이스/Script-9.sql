-- DELETE --
--  ���̺��� ���� �����ϴ� ��ɾ�
-- [�������]
-- DELETE FROM ���̺�� [WHERE ����]


CREATE TABLE TEST_DELETE
AS
		SELECT * FROM EMPLOYEE;
	
-- DEPT_ID�� D1�� ���� �����ǰ� �־ ���� �Ұ�
-- ORA-02292: integrity constraint (TEST.SYS_C007132) violated - child record found
DELETE FROM DEPARTMENT 
WHERE DEPT_ID = 'D1';
	
-- 1) ���� ���� ���� �÷��� ���� �ɼ� �����ϱ�
-- ON DELETE CASCADE : �θ� ������ �� �ڽ� �÷��� �Բ� ���� 
-- ON DELETE SET NULL : �θ� ������ �� �ڽ��� NULL������ ����

-- 2) ���������� ��Ȱ��ȭ�Ͽ� ������ �����ϰ� ���� ����
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'EMPLOYEE';

-- �������� ��Ȱ��ȭ
ALTER TABLE EMPLOYEE
DISABLE CONSTRAINT EMPLOYEE_PK;
-- ���������� �Ժη� �ǵ帮�� ����

-- �������� Ȱ��ȭ
ALTER TABLE EMPLOYEE 
ENABLE CONSTRAINT EMPLOYEE_PK;
	
-- TRUNCATE : DELETE�� �����ϰ� ���̺��� ������ �����ϴ� ��ɾ�
-- ** DELETE���� ��������, ���� �� ROLLBACK �Ұ���

SELECT * FROM EMP_SALARY;
COMMIT;
-- DELETE�� ���� ������ ��ü ����
DELETE FROM EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;
SELECT * FROM EMP_SALARY;
	
-- TRUNCATE ���
TRUNCATE TABLE EMP_SALARY;
SELECT * FROM EMP_SALARY;
ROLLBACK;
SELECT * FROM EMP_SALARY;

-- TCL
-- TRANSACTION CONTROL LANGUAGE --
-- Ʈ����� ���� ���(COMMIT, ROLLBACK, SAVEPOINT, ROLLBACK TO)
	
-- Ʈ����� : �����͸� ó���ϴ� �۾��� �߰� ���� ������ ó���� �ּ� ����	

-- COMMIT : Ʈ������� ���� �� �� ���������� ����Ǿ��ٸ� ��������� DB�� �����ϰڴ�.
-- ROLLBACK : Ʈ������� �۾� �� ������ �߻��� ��� �߸��۾��� ������ ����ϰڴ�.
-- SAVEPOINT �ӽ�����Ҹ� : ���� Ʈ����� ���� �� Ư�� ������ ������ ������� ����� �κи� ������ �߰��� �����ϰڴ�.
-- ROLLBACK TO :�ӽ�����Ҹ� : Ʈ����� �۾� �� �ӽ� ����� SAVEPOINT�� ã�� �ش� �κб��� ���󺹱��� �� ���
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

--�ѹ����� �� COMMIT�� �� ������ �����Ͱ� 2���� ������ ���̹Ƿ� 2���� ��ȸ��.
ROLLBACK;
	
SELECT * FROM USER_TBL;	
	
INSERT INTO USER_TBL VALUES(3,'TEST03','PASS03');

SAVEPOINT SP1;

INSERT INTO USER_TBL VALUES(4,'TEST04','PASS04');

SELECT * FROM USER_TBL;

--SP1 �������� �ǵ����ڴ�(�׷��� 3���� �����Ͱ� �ִ� �������� �ǵ��ư�)
ROLLBACK TO SP1;

SELECT * FROM USER_TBL;

--������ COMMIT�� ������ �����Ͱ� 2���� �����̱⿡ �����Ͱ� 2���ۿ�����
--ROLLBACK �ϰ� ROLLBACK TO SP1�ϸ� ���� ��.(�̹� SP1���� ������ ���ƿԱ⿡ �ٽ� �� ���ư�)
ROLLBACK;

SELECT * FROM USER_TBL;


-- DROP --
-- ��ü�� Ư����Ҹ� �����ϰų� ��ü��ü�� ������ �� ����ϴ� ��ɾ�
-- [����1]
-- ALTER ��ü ��ü��
-- DROP ������� �ϴ� ���

-- [����2]
-- DROP ��ü ��ü��

SELECT * FROM DEPT_COPY;

-- DROP (�÷���)
ALTER TABLE DEPT_COPY
DROP (DEPT_TITLE);

-- �������� ����
CREATE TABLE CONST_TAB(
		EID CHAR(2),
		ENAME VARCHAR2(15) NOT NULL,
		AGE NUMBER NOT NULL,
		DEPT CHAR(5),
		-- ���̺� ����
		CONSTRAINT PK_TAB PRIMARY KEY(EID),
		CONSTRAINT UK_TAB UNIQUE(ENAME),
		CONSTRAINT CK_TAB CHECK(AGE>0),
		CONSTRAINT FK_TAB FOREIGN KEY(DEPT) REFERENCES DEPARTMENT ON DELETE CASCADE
);

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CONST_TAB';

-- �������� �����ϱ�
ALTER TABLE  CONST_TAB
DROP CONSTRAINT CK_TAB;

SELECT * FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'CONST_TAB';

-- �������� ���� �� �����ϱ�
ALTER TABLE CONST_TAB 
DROP CONSTRAINT UK_TAB
DROP CONSTRAINT FK_TAB
DROP CONSTRAINT PK_TAB;

SELECT * FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'CONST_TAB';

-- �������� �����ϱ�
ALTER TABLE CONST_TAB 
DROP CONSTRAINT SYS_C007179;

-- AGE�� NULL�� �����ϰڴ�(�Է��� �ϵ� ���ϵ� ������ٶ�� �ǹ�)
ALTER TABLE CONST_TAB
MODIFY (AGE NULL);

SELECT * FROM CONST_TAB;

-- ��ü ����
DROP TABLE CONST_TAB;
DROP USER KING;

-- ������ ���� ���� --
-- CMD �ۼ��ؼ� SYSTEM Ȥ�� ���� TEST�� SYSTEM���� �ٲٱ�
-- CREATE USER KING IDENTIFIED BY QUEEN; -- ���� ����
-- GRANT CONNECT, RESOURCE TO KING -- ���� �ο�
-- CONN KING/QUEEN; -- ���� ����
-- DROP USER KING; -- ���� ����
----------------

-- ����Ŭ ��ü
-- VIEW(��) --

-- VIEW : SELECT�� ������ ��� ȭ���� ��� ��ü
-- SELECT���� ��ü�� �����Ͽ� ȣ���� �� ���� �ش� ������ �����Ͽ� ����� �����ִ� ��ü.

-- [�����]
-- CREATE [OR REPLACE] VIEW ���̸�
-- AS ��������(�信�� Ȯ���� SELECT ����);
-- CREATE OR REPLACE�� ������ ����� ������ ��ü�϶�� �ǹ���.

-- �����ڰ������� �� ���� ���� �ο�
GRANT CREATE VIEW TO TEST;
COMMIT;
-------------------------------------------
-- ORA-01031: insufficient privileges
-- TEST������ �並 ������ �� �ִ� ������ ����
CREATE VIEW V_EMP
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE
		FROM EMPLOYEE;
	
SELECT * FROM V_EMP;

-- �̹� ������ �䰡 �ִ��� REPLACE�� ���� ���Ӱ� ���� �����ϴ�.
CREATE OR REPLACE VIEW V_EMP(���, �̸�, �μ�, ����)
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
		FROM EMPLOYEE;
	
SELECT * FROM V_EMP;

-- ������ �� ���� Ȯ��
SELECT * FROM USER_VIEWS;

-- �ǽ� 1.
-- ���, �̸�, ���޸�, �μ���, �ٹ������� ��ȸ�ϰ�
-- �� ����� V_RESULTSET_EMP ��� �並 �����
-- �並 ���� �� ����� ��ȸ�Ͽ� Ȯ��
-- 1) �������� �غ�
-- 2) �信 �����ؼ� ���

CREATE VIEW V_RESULTSET_EMP(���,�̸�,���޸�,�μ���,�ٹ���)
AS SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME
			FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L
			WHERE E.JOB_CODE  = J.JOB_CODE
						AND E.DEPT_CODE  = D.DEPT_ID
							AND D.LOCATION_ID  = L.LOCAL_CODE;

SELECT * FROM V_RESULTSET_EMP;						

-- �ǽ�2.
-- ������� VIEW�� Ȱ���Ͽ� ����� '205'���� ���� ���� ��ȸ�ϱ�

SELECT * 
FROM V_RESULTSET_EMP
WHERE ��� = '205';

-- VIEW�� SELECT ������ �����ϰ� �ֱ� ������
-- ���� ���̺��� ���� ����Ǿ��� �� �䵵 �Բ� ����� ���� ��ȸ ����

UPDATE EMPLOYEE SET EMP_NAME = '������' WHERE EMP_ID = '205';

SELECT * FROM EMPLOYEE WHERE EMP_ID = '205';

SELECT * FROM V_RESULTSET_EMP WHERE ��� = '205';

COMMIT;

-- �� ����
DROP VIEW V_RESULTSET_EMP;
SELECT * FROM USER_VIEWS;


-- �信 ������ ����, ����, ����
CREATE OR REPLACE VIEW V_JOB
AS
SELECT * FROM JOB;

SELECT * FROM V_JOB;

-- �並 ���� ������ �߰�(�並 ���� ������ �߰��� JOB�� �߰��ϴ°Ŷ� ����)
INSERT INTO V_JOB  VALUES('J8','����');
SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- �並 ���� ������ ����
UPDATE V_JOB SET JOB_NAME = '�˹�' WHERE JOB_CODE = 'J8';
SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- �並 ���� ������ ����
DELETE FROM V_JOB WHERE JOB_CODE = 'J8';
SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- DML ��ɾ �ȵǴ� ���
-- �信 ���ǵ��� ���� �÷� ���� �����Ϸ��� �ϴ� ���
-- ��� ������ ���Ե� �÷�
-- �Ϲ������δ� JOIN�� �� ���̺� ������ ���� ��
-- DISTINCT�� �信 ������� ��
-- �׷��Լ��� ����ϰų�, GROUP BY�� ���� ������� ������ ���


-- �信 ���� �Ǿ����� ���� �÷��� ������ ���
CREATE OR REPLACE VIEW V_JOB
AS SELECT JOB_CODE FROM JOB;

SELECT * FROM V_JOB;
-- ORA-00913: too many values
-- �ִ°� JOB_CODE �ϳ��� 2�� ������ �ؼ� ������
INSERT INTO V_JOB VALUES('J8','����');

-- ORA-00904: "JOB_NAME": invalid identifier
-- JOB_NAME�� ����
UPDATE V_JOB SET JOB_NAME = '����' WHERE JOB_CODE ='J7';


-- ��� ǥ���� ���
CREATE OR REPLACE VIEW V_EMP_SAL
AS
SELECT EMP_ID, EMP_NAME, SALARY,
		(SALARY+SALARY*NVL(BONUS,0))*12 ����
FROM EMPLOYEE;

SELECT * FROM V_EMP_SAL;

--ORA-01733: virtual column not allowed here
-- ������ �÷��� ������ �÷��̶� ���� ���� ����.
INSERT INTO V_EMP_SAL
VALUES(901,'���Ͽ�',3000000,4000000);

-- JOIN�� ���ؼ� VIEW�� ������ �����ϴ� ���
CREATE OR REPLACE VIEW V_JOIN_EMP
AS
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID );

SELECT * FROM V_JOIN_EMP;	

-- ORA-01776: cannot modify more than one base table through a join view
-- JOIN�� �ؼ� �����°� �Ժη� �����ϰų� ������������.
INSERT INTO V_JOIN_EMP
VALUES(911,'�̴���','���������');

-- �׷��Լ�, GROUP BY
-- ORA-00998: must name this expression with a column alias
-- �׷��Լ��� ���� VIEW�� ��������ϸ� ��Ī�� ��� �������.
CREATE OR REPLACE VIEW V_GROUP_DEPT
AS
SELECT DEPT_CODE, SUM(SALARY) �հ�, TRUNC(AVG(SALARY),-4) ���
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

-- �並 �� ���°�?
-- ������ ���ϰԲ�
-- ���̺��� ���������ʴ��� ���������� ����� �ְ�
-- ������ �䰡 ������ �����


-- VIEW ���� �� ���� �ɼ�
-- OR REPLACE : ������ �ִ� ������ �̸��� �䰡 ���� ���
--								�ش� �並 ������, ���ٸ� ���� ����ڴ�.
-- FORCE / NOFORCE : ���������� ���Ǵ� ���̺��� �������� �ʾƵ�
--										�並 �������� �� ������ ����
-- WITH CHECK / READ ONLY
--					CHECK : �ɼ� ������ �÷��� ���� �ٲ��� ���ϰ� ���� ����
--					READ ONLY : �信 ���� ��� �÷��� �並 ���ؼ� �������� ���ϰ� ���� ���� 

-- FORCE : �������� �ʴ� ���̺��̶� �並 ������ ����
CREATE OR REPLACE FORCE VIEW V_EMP
AS
SELECT T_CODE, T_NAME, T_CONTENT
FROM TEST_TABLE;

--������ ������ ������ ��ȸ�� �翬�� �ȵ�
SELECT * FROM V_EMP;

DROP VIEW V_EMP;

-- NO FORCE : ���� �����Ϸ��� ���� ���̺��� �������� �ʴ´ٸ� �並 �������� �ʰڴ�.
-- �⺻ DEFAULT���� NOFORCE�� �Ǿ�����.
CREATE OR REPLACE /*NOFORCE*/ VIEW V_EMP
AS
SELECT T_CODE, T_NAME, T_CONTENT
FROM TEST_TABLE;

-- WITH CHECK : �信 �����ϴ� �÷��� �߰��ϰų� �������� ���ϰ� ���� ���� �ɼ�
--1)
CREATE OR REPLACE VIEW V_EMP
AS
SELECT * FROM EMPLOYEE
WITH CHECK OPTION;

SELECT * FROM V_EMP;

--ORA-32575: Explicit column default is not supported for modifying views
--�߰� �����Ұ����ϰ� ���Ƴ��� ����
INSERT INTO V_EMP VALUES(784, '��â��','101010-1234567','LEE@KH.OR.KR','01012344321',
													'D1','J7','S1',8000000,0.1,200,SYSDATE,NULL,DEFAULT);
--�ٵ� DELETE�� ��.
DELETE FROM V_EMP WHERE EMP_ID = '900';

SELECT * FROM V_EMP;

-- WITH READ ONLY : �������� �Է�, ����, ���� ��� ���� �ɼ�
CREATE OR REPLACE VIEW V_EMP
AS
SELECT * FROM EMPLOYEE
WITH READ ONLY;

--READ ONLY�ϸ� �߰� ���� ���� �� �ȵǴ� ���� �� �� ����.
INSERT INTO V_EMP VALUES(784, '��â��','101010-1234567','LEE@KH.OR.KR','01012344321',
													'D1','J7','S1',8000000,0.1,200,SYSDATE,NULL,DEFAULT);
DELETE FROM V_EMP WHERE EMP_ID = '500';

----------------------------
-- ## ROLE
----------------------------

--> ����ڿ��� ���� ���� ������ �� ���� �ο� �� �� �ִ� �����ͺ��̽� ��ü
-- ORACLE DB ��ġ �� �⺻ �����Ǵ� ROLE
-- CONNECT : ����ڰ� �����ͺ��̽��� ���� �����ϵ��� �ϱ� ���� ������ �ִ� ROLE
-- RESOURCE : ����ڰ� ��ü�� �����ϱ� ���� �ý��� ���� �����Ǵ� ROLE
-- DBA : �ý��� �ڿ��� ������������ ��밡���ϸ� �ý��� ������ �ϱ� ���� ��� ������ �����ϴ� ROLE

-- ROLE�� �ο��� �ý��� ���� Ȯ��
SELECT * FROM ROLE_SYS_PRIVS 
-- WHERE ROLE = 'RESOURCE';
 WHERE ROLE = 'CONNECT';

-- SYSTEM ���� ����
SELECT * FROM ROLE_SYS_PRIVS  WHERE ROLE = 'DBA';

CREATE USER TESTER IDENTIFIED BY TESTER;
GRANT CONNECT, RESOURCE TO TESTER;

--Ư�� ����ڿ��� Ư�� ���̺�(EMPLOYEE)�� ���� ��ȸ ���� �ο��ϱ�
-- ROLE ����
CREATE ROLE EMP_ROLE;

-- ROLE�� ���� �ο�
GRANT SELECT ON KH.EMPLOYEE TO EMP_ROLE;

-- �帧�� ����
-- 1) ROLE ����
-- 2) ROLE�� ���� �ο�
-- 3) ROLE�� ����ڿ��� �ο�

-- TEST ����ڿ��� EMP_ROLE ���� �ο�
GRANT EMP_ROLE TO TESTER;

-- TEST�������� EMPLOYEE ���̺� ���� Ȯ��
SELECT * FROM KH.EMPLOYEE;
---------------------------------------------

-- ���� ȸ��(������ ����)
REVOKE EMP_ROLE FROM TESTER;
-- ���� ȸ���Ǿ��⿡ KH�� EMPLOYEE�� Ȯ�� �Ұ�
SELECT * FROM KH.EMPLOYEE;

-- SEQUENCE : ������
-- 1,2,3,4,5 .... �������� ���ڵ����͸� �ڵ����� ī��Ʈ �ϴ� ��ü

/*
  		CREATE SEQUENCE ��������
  		[START WITH ����] : ���۰�, �����ϸ� 1���� ����	
  		[INCREMENT BY ����] : ���� ���� ���� ���� ��ġ, ���� �� 1�� ����
  												-- INCREMENT BY 5 --> 5�� ����					
  		[MAXVALUE	���� | NOMAXVALUE] : �߻���ų ���� �ִ� ����
  		[MINVALUE		���� | NOMINVALUE] :  �߻���ų ����  �ּڰ� ����
		[CYCLE | NOCYCLE] : ���� ��ȯ ���� (1~10 ... 1~10 ... 1~10)
		[CACHE ����Ʈ ũ�� | NOCACHE] : ���� �̸� ���س��� ���� ���� �ݿ��� �� Ȱ���ϴ� ����  		
 */

CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

-- 310�� �Ѿ�� �Ǹ� �ִ��� �Ѿ�� �ǹǷ� ���� �߻�
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
-- ���� ������ Ȯ��
SELECT SEQ_EMPID.CURRVAL FROM DUAL;

-- �������� ���� �ÿ� �ʱⰪ�� ������ �� ����.
-- �ʱⰪ ���� �ϰ��� �� ���� DROP �� �����
ALTER SEQUENCE SEQ_EMPID
--START WITH 315
INCREMENT BY 10
MAXVALUE 400
NOCYCLE
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

-- ������ ������ ����ִ� ������ ����
SELECT * FROM USER_SEQUENCES;

-- ������ �����ϱ�
DROP SEQUENCE SEQ_EMPID;


-- TEST ����
-- ������ �̿��Ͽ� ������ �߰�
CREATE SEQUENCE SEQ_EID
START WITH 300
INCREMENT BY 1
MAXVALUE 10000
NOCYCLE
NOCACHE;

-- ������ �߰��ϱ�
INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '����ȣ','121212-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D2','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);

SELECT * FROM EMPLOYEE;

-- D9�μ��� J7������ ��� 4���� �������� Ȱ���Ͽ� �߰��Ͻÿ�.
INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '�̴���','111111-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);

INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '�����','570120-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);
			
INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '���弮','990519-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);
			
INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '������','890917-1234567','LEE_JH@KH.OR.KR','01012334566'
				,'D9','J7','S1',5000000,0.1,200,SYSDATE,NULL,DEFAULT);			

SELECT * FROM EMPLOYEE;

-- CYCLE / CACHE

-- CYCLE : �������� ���� �ּڰ� Ȥ�� �ִ񰪿� ���� ���� �� �ٽ� �ݴ��� ������ �����ϴ� �ɼ�
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
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;  -- �ִ� ����!!
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL;  -- CYCLE ���� �� �ִ� ���� �� �ٽ� �ּڰ����� ����

-- CACHE : ��ǻ�Ͱ� ���� ���� ���� ������� �׶� �׶� �������� �ʰ� �̸� ����� ���� ��
-- NOCACHE�� DEFAULT��(�׶� �׶� ó��)

CREATE SEQUENCE SEQ_CACHE
START WITH 100
INCREMENT BY 1
CACHE 20
NOCYCLE;

SELECT SEQ_CACHE.NEXTVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;






















