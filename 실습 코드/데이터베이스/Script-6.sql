-- ���� ���� �����
-- �ý��� ������ ���� test���� ����
CREATE USER TEST IDENTIFIED BY TEST;

-- ���� �ο�
GRANT CONNECT, RESOURCE TO TEST;
--CMDâ���� SQLPLUS���� ������ Ȯ���� ����.

--�������� ���� �� �������� �����ͺ��̽� ����
--������ ��, FIND CLASS -> ORACLE.JDBC.DRIVE.DRACLEDRIVER ����

--DDL
/*
	CREATE : ������ ���̽��� ��ü�� �����ϴ� DDL
	[�������]
	CREATE : ��ü ���� ��ü�� (���� ����)
	
	-- ���̺� ���� ��
	CREATE TABLE ���̺��(
			�÷��� �ڷ���(����) ��������
	);	 
	�������� : ���̺� �����͸� �����ϰ��� �� �� ���Ѿ� �ϴ� ��Ģ
			NOT NULL - NULL�� ������� �ʰڴ�.(�ʼ� �Է� ����) 
			UNIQUE - �ߺ� ���� ������� �ʴ´�.
			CHECK - ������ �Է� ���� �ܿ��� ���� ���ϰ� ���� ����
			PRIMARY KEY - (NOT NULL + UNIQUE)  - ����ũ ���������� ������.
				���̺� ������ �ش� ���� �ν��� �� �ִ� ������ ��
				���̺� ������ �� 1���� ���� ����
  			FOREIGN KEY - �ٸ� ���̺��� ������ ���� �������� ������ �������� �����Ϳ� �����ϴ� ��������
 */

-- ���̺� ����
-- �����͸� �����ϱ� ���� ��ü
-- 2������ ǥ ���·� �����͸� ���� �� �ִ�. ��� �÷����� ����
CREATE TABLE MEMBER (
		MEMBER_NO NUMBER,						--ȸ����ȣ
		MEMBER_ID VARCHAR2(20)	,			--ȸ�����̵�
		MEMBER_PWD VARCHAR2(20),		--ȸ����й�ȣ
		MEMBER_NAME VARCHAR2(15)		--ȸ���̸�
);
SELECT * FROM MEMBER;

-- ���̺��� �� �÷��� �ּ� �ޱ�
-- COMMENT ON COLUMN ���̺��.�÷��� IS '�ּ�����';
COMMENT ON COLUMN MEMBER.MEMBER_NO IS 'ȸ�� ��ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_ID IS 'ȸ�� ���̵�';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS 'ȸ�� ��й�ȣ';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS 'ȸ�� �̸�';

--���̺� ���� Ȯ��(CMDâ �Ѽ� �α��� �� �� ��ɾ� �ۼ�)
DESC MEMBER;

SELECT *
FROM USER_TAB_COLUMNS;

SELECT *
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'MEMBER';
--���̺� �ּ� ��ȸ
SELECT *
FROM USER_TAB_COMMENTS;
--�÷� �ּ� ��ȸ
SELECT *
FROM USER_COL_COMMENTS;

SELECT * FROM USER_TABLES;

-- ��������(CONSTRAINTS) -- 
-- ���̺��� ������ �� �� �÷��� ���� ����ϴ� �Ϳ� ���� ��������� �����ϴ� ���ǵ�
-- ������ ���Ἲ ���� : ������ ���̶�� Ȥ�� ���� �ƹ��� ������ ���� �ʴ´ٴ� �ǹ�
--(�������� ��Ȯ���� �����ϱ� ���� ��Ȯ���� ���� �����Ͱ� DB���� ����Ǵ� ���� ����)


-- ���� ����� ������ ���õ� ���� ���� Ȯ��
SELECT * FROM USER_CONS_COLUMNS;

-- NOT NULL
-- 'NULL ���� ������� �ʴ´�.'
-- �÷��� �ݵ�� ���� ����ؾ� �ϴ� ���
-- ������ ����/����/���� �ÿ� NULL ���� ������� �ʵ��� 
-- �÷� �ۼ� �� �Բ� �������� �ۼ�(�÷����� �������� ���)

DROP TABLE USER_NOCONS;
CREATE TABLE USER_NOCONS(
		USER_NO NUMBER,
		USER_ID VARCHAR2(20),
		USER_PWD VARCHAR2(30),
		USER_NAME VARCHAR2(15),
		GENDER VARCHAR2(3),
		PHONE VARCHAR2(14),
		EMAIL VARCHAR2(30)
);
SELECT * FROM USER_NOCONS;
-- ���̺� �� �߰�
-- DML : INSERT
INSERT INTO USER_NOCONS
VALUES(1, 'USER01','PASS01','��â��','��','010-1234-5678','LEE315@KH.OR.KR');

INSERT INTO USER_NOCONS
VALUES(2,NULL,NULL,NULL,'��',NULL,NULL);

SELECT * FROM USER_NOCONS;

CREATE TABLE USER_NOT_NULL(
			USER_NO NUMBER NOT NULL,				--�÷�������������
			USER_ID VARCHAR2(20) NOT NULL,
			USER_PWD VARCHAR2(30) NOT NULL,
			USER_NAME VARCHAR2(15) NOT NULL,
			GENDER VARCHAR2(3),
			PHONE VARCHAR2(14),
			EMAIL VARCHAR2(30)
);

SELECT * FROM USER_NOT_NULL;

INSERT INTO USER_NOT_NULL
VALUES(1,'USER01','PASS01','��â��','��','010-1234-5678','LEE315@KH.OR.KR');

INSERT INTO USER_NOT_NULL
VALUES(2,NULL,NULL,NULL,'��',NULL,NULL);

-- UNIQUE �������� --
-- �ߺ��� ������� �ʴ� ��������
-- �÷��� ���� �Է�/������ �� �ߺ��� Ȯ���Ͽ�
-- �ߺ� ���� ������� �� �߰�/������ ���ϰ� ���� ��������

INSERT INTO USER_NOCONS
VALUES(1,'USER01','1234','ȫ�浿','��','010-4333-2111','HONG@EXAMPLE.COM');

SELECT * FROM USER_NOCONS;

CREATE TABLE USER_UNIQUE(
			USER_NO NUMBER,
			USER_ID VARCHAR2(20) UNIQUE,
			USER_PWD VARCHAR2(30),
			USER_NAME VARCHAR2(15),
			GENDER CHAR(3),
			PHONE VARCHAR2(14),
			EMAIL VARCHAR2(30)
);
SELECT * FROM USER_UNIQUE;

INSERT INTO USER_UNIQUE
VALUES(1,'USER01','PASS01','��â��','��','010-1234-5678','LEE315@KH.OR.KR');
INSERT INTO USER_UNIQUE
VALUES(1,'USER01','1234','ȫ�浿','��','010-4321-4321','HONG@EXAMPLE.COM');

SELECT * FROM USER_UNIQUE;

SELECT *
FROM USER_CONSTRAINTS C1, USER_CONS_COLUMNS C2
WHERE C1.CONSTRAINT_NAME = C2.CONSTRAINT_NAME
		AND C1.TABLE_NAME = 'USER_UNIQUE';  
--CONSTRAINT-TYPE
--U : UNIQUE
--P : PRIMARY KEY
--C : CHECK
--R : FORIEGN KEY(REFERENCE)


CREATE TABLE USER_UNIQUE2(
			USER_NO NUMBER,
--			USER_ID VARCHAR2(20) UNIQUE,
			USER_ID VARCHAR2(20),
			USER_PWD VARCHAR2(30),
			USER_NAME VARCHAR2(15),
			GENDER CHAR(3),
			PHONE VARCHAR2(14),
			EMAIL VARCHAR2(30),
			UNIQUE(USER_ID)							--�÷��� ��� �ۼ��� �Ŀ� ������ �ۼ��ϴ� ����������
																	--���̺� ���� ���������̶�� ��.
);


INSERT INTO USER_UNIQUE2
VALUES(1,'USER01','PASS01','��â��','��','010-1234-5678','LEE315@KH.OR.KR');
INSERT INTO USER_UNIQUE2
VALUES(1,'USER01','1234','ȫ�浿','��','010-4321-4321','HONG@EXAMPLE.COM');

-- UNIQUE ���������� ���� �� �÷��� ����
-- �ݵ�� ���̺� �������� ���������� ����
CREATE TABLE USER_UNIQUE3(
			USER_NO NUMBER,
			USER_ID VARCHAR2(20),
			USER_PWD VARCHAR2(30),
			USER_NAME VARCHAR2(15),
			UNIQUE(USER_NO, USER_ID)				--�� �� �̻��� �÷����� �ߺ����� �ʰ� ����
);

SELECT * FROM USER_UNIQUE3;

INSERT INTO USER_UNIQUE3
VALUES(1,'USER01','PASS01','��â��');
INSERT INTO USER_UNIQUE3
VALUES(1,'USER02','PASS02','��â��');
INSERT INTO USER_UNIQUE3
VALUES(2,'USER01','PASSO3','��â��');
INSERT INTO USER_UNIQUE3
VALUES(2,'USER02','PASSO4','��â��');

-- UNIQUE�ȿ� �� �� �����ϸ� �� �� ��� ��ĥ ���� ���������� �ɸ�.
INSERT INTO USER_UNIQUE3
VALUES(2,'USER02','PASSO5','��â��');

-- �������� �̸� ����
CREATE TABLE CONS_NAME(
			TEST_DATA1 NUMBER(10) CONSTRAINT NN_DATA1 NOT NULL,
			TEST_DATA2 VARCHAR2(20) CONSTRAINT UN_DATA2 UNIQUE,
			TEST_DATA3 VARCHAR2(30),
			CONSTRAINT UK_DATA3 UNIQUE(TEST_DATA3)
);

--
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'CONS_NAME';

-- CHECK ��������
-- �÷��� ���� ����� �� ������ �� �̿ܿ��� ���� ��ϵ��� �ʵ��� ������ �����ϴ� ����
-- CHECK(�÷��� �񱳿����� ��)

CREATE TABLE USER_CHECK(
		USER_NO NUMBER,
		USER_ID VARCHAR2(20),
		USER_PWD VARCHAR2(30),
		USER_NAME VARCHAR2(15),
		GENDER CHAR(3) CHECK(GENDER IN('��','��'))
);

INSERT INTO USER_CHECK
VALUES(1,'USER01','PASS01','��â��','��');
--�������� ���� ���������� ũ�Ⱑ �ɸ�
INSERT INTO USER_CHECK
VALUES(2,'USER02','PASS02','���Ͽ�','����');
--ũ�Ⱑ �����ϱ� ���������� �ߵ�
INSERT INTO USER_CHECK
VALUES(2,'USER02','PASS02','���Ͽ�','M');

--CHECK �������ǿ� �ε�ȣ ���
CREATE TABLE TEST_CHECK2(
			TEST_DATA NUMBER(10),
			CONSTRAINT CK_TEST_DATA CHECK(TEST_DATA > 0)
);

INSERT INTO TEST_CHECK2
VALUES(10);
INSERT INTO TEST_CHECK2
VALUES(-10);

CREATE TABLE TEST_CHECK3(
		C_NAME VARCHAR2(15),
		C_PRICE NUMBER,
		C_DATE DATE,
		C_QUAL CHAR(1),
		CONSTRAINT CK_TESTCHK3_PRICE CHECK(C_PRICE BETWEEN 1 AND 9999),
		CONSTRAINT CK_TESTCHK3_DATE CHECK(C_DATE > TO_DATE('2010/01/01','YYYY/MM/DD')),
		CONSTRAINT CK_TESTCHK3_QUAL CHECK(C_QUAL >= 'A' AND C_QUAL <= 'D')		
);

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'TEST_CHECK3';

-- ���� ���� ������ �����ϱ�
CREATE TABLE TEST_DUAL_CONS(
			TEST_NO NUMBER(10) NOT NULL UNIQUE,
			TEST_NO2 NUMBER NOT NULL
);

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'TEST_DUAL_CONS';

-- PRIMARY KEY �������� --
-- '�⺻Ű ��������'
-- ���̺� ���� ������ �߿��� ���� �ĺ��ϱ� ���� �������� ������ �÷���
-- NOT NULL�� UNIQUE ���������� �Բ� �ɾ��ִ� ��������
-- (��, ���̺� ��ü�� ���� �� �������� �ĺ��� ������ �����Ű�� ��������)
-- �⺻Ű�� ����� �÷��� ���� �ݵ�� ����, �ߺ��� �Ͼ�� �ȵ�.
-- �⺻Ű ���������� �� ���̺� ���� �ݵ�� �Ѱ� �����ؾ��Ѵ�.
-- �⺻Ű ���������� �� �÷��� ���� �� ���� �ְ�, �����÷��� ���� ������ ���� �ִ�.

CREATE TABLE USER_PK_TABLE(
		USER_NO NUMBER(10) CONSTRAINT PK_USER_NO PRIMARY KEY,
		USER_ID VARCHAR2(20) UNIQUE,
		USER_PWD VARCHAR2(30) NOT NULL,
		USER_NAME VARCHAR2(15) NOT NULL,
		GENDER VARCHAR2(3) CHECK(GENDER IN('M','F'))
);

SELECT * FROM USER_PK_TABLE;

INSERT INTO USER_PK_TABLE
VALUES(1,'USER01','PASS01','LEE','M');

INSERT INTO USER_PK_TABLE
VALUES(2,'USER02','PASS02','KIM','F');

--unique constraint (TEST.PK_USER_NO) violated
INSERT INTO USER_PK_TABLE
VALUES(1,'USER03','PASS03','CHOI','F');
-- �⺻Ű �����ϸ� �ڵ����� ����ũ �������� ������

--cannot insert NULL into ("TEST"."USER_PK_TABLE"."USER_NO")
INSERT INTO USER_PK_TABLE
VALUES(NULL,'USER03','PASS03','CHOI','F');
-- NOT NULL������ ������

-- �⺻Ű ���� ������ �����ϸ� NOT NULL�� UNIQUE�� �Բ� ���� �ȴ�.

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'USER_PK_TABLE';

-- �⺻Ű ���� ������ ���� �÷��� �����ϱ�

CREATE TABLE USER_PK_TABLE2(
		USER_NO NUMBER(10),				
		USER_ID VARCHAR2(20) UNIQUE,
		USER_PWD VARCHAR2(30) NOT NULL,
		USER_NAME VARCHAR2(15) NOT NULL,
		GENDER VARCHAR2(3) CHECK(GENDER IN('M','F')),
		CONSTRAINT PK_USER_NO2 PRIMARY KEY(USER_NO, USER_ID)  --�ΰ��� Ű�� ��� ����Ű��� ��
);

-- 1,		'USER01'		-- ����
-- 2,		'USER02'	-- ����
-- 2,		'USER03'	-- ����
-- 2,		'USER01'		-- ����

INSERT INTO USER_PK_TABLE2
VALUES(1,'USER01','PASS01','LEE','M');
-- ����Ű�ʹ� ������ �̸����� UNIQUE�� �༭ ���� �߻�
INSERT INTO USER_PK_TABLE2
VALUES(2,'USER01','PASS01','LEE','M');
INSERT INTO USER_PK_TABLE2
VALUES(1,'USER02','PASS01','LEE','M');

-- DROP : ��ü�� �����ϴ� ��ɾ�
DROP TABLE MEMBER;

SELECT * FROM MEMBER;

COMMIT;

-- MEMBER ���̺��� �����Ͽ� ����� ������ ���� �� �ִ� ���̺� ��ü�� �����,
-- ȸ�� ��ȣ�� NUMBER���·� �⺻Ű �����ϰ�,
-- ȸ�� ���̵�� �ߺ� �Ұ��� �ʼ� �Է� ��������,
-- ȸ�� ��й�ȣ�� �ʼ� �Է� ����,
-- ȸ�� �̸�, ����('M','F'),
-- ȸ�� ����ó, ȸ�� ������� ������ ���� �� �ִ� �÷��� ���� ���̺��� �����Ͻÿ�.
-- ��, �� �÷��� ���̴� ���� �Ǵ��ϰ�, ���� ������ ���̺� ��������
-- ȸ�� ������ �ּ� 5�� �̻� �����Ͽ� Ȯ���Ͻÿ�.

--�� ����
CREATE TABLE MEMBER(
		USER_NO NUMBER(10) PRIMARY KEY,		
		USER_ID VARCHAR2(20) NOT NULL UNIQUE,
		USER_PWD VARCHAR2(30) NOT NULL,
		USER_NAME VARCHAR2(15),
		GENDER VARCHAR2(3) CHECK(GENDER IN('M','F')),
		USER_EMAIL VARCHAR(30),
		USER_BIRTH VARCHAR(30)
);
SELECT * FROM MEMBER;

INSERT INTO MEMBER
VALUES(1,'USER01','PASS01','������','M','@@@','9444');

INSERT INTO MEMBER
VALUES(2,'USER02','PASS02','������','M','@@@','9444');

INSERT INTO MEMBER
VALUES(3,'USER03','PASS03','������','M','@@@','9444');

INSERT INTO MEMBER
VALUES(4,'USER04','PASS04','������','M','@@@','9444');

INSERT INTO MEMBER
VALUES(5,'USER05','PASS05','������','M','@@@','9444');

-- �Ͽ��� ����
CREATE TABLE MEMBER(
   USER_NO NUMBER(10),
   USER_ID VARCHAR2(20) NOT NULL UNIQUE,
   USER_PWD VARCHAR2(30) CONSTRAINT NN_USER_PWD NOT NULL,
   USER_NAME VARCHAR2(15),
   GENDER CHAR(3) CONSTRAINT CHK_GENDER CHECK(GENDER IN('M','F')),
   PHONE VARCHAR(14),
   BIRTHDAY DATE,
   CONSTRAINT PK1_USER PRIMARY KEY(USER_NO),
   CONSTRAINT BIRTHDAY CHECK( BIRTHDAY > TO_DATE('1900/01/01', 'YYYY/MM/DD') )
);

--����� ����
CREATE TABLE MEMBER(
		M_NO NUMBER CONSTRAINT PK_MEMBER PRIMARY KEY,
		M_ID VARCHAR2(15) NOT NULL UNIQUE,
		M_PWD VARCHAR2(30) NOT NULL,
		M_NAME VARCHAR2(15),
		M_GENDER CHAR(1) CHECK(M_GENDER IN('M','F')),
		M_MAIL VARCHAR2(30),
		P_PHONE VARCHAR2(14),
		M_BIRTH DATE
);

COMMENT ON COLUMN MEMBER.M_NO	IS 'ȸ����ȣ';
COMMENT ON COLUMN MEMBER.M_ID	IS 'ȸ�����̵�';














