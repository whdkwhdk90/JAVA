SELECT * FROM EMPLOYEE;

--EMPLOYEE ���̺� ����
DESC EMPLOYEE;

--CRUD : ������ ó�� ����
-- CREATE : ������ �߰� / INSERT
-- READ   : ������ ��ȸ / SELECT
-- UPDATE : ������ ���� / UPDATE
-- DELETE : ������ ���� / DELETE

-- �⺻ ���� ����1
-- EMPLOYEE ���̺��� ��� ����� �����, �̸���, ����ó, �Ի��� ��ȸ�ϱ�
-- EMP_NAME, EMAIL, PHONE, HIRE_DATE
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE FROM EMPLOYEE;

-- �⺻ ���� ����2
-- �μ��ڵ尡 D6�� �μ��� ��� ���� ���� ��ȸ�ϱ�
-- DEPT_CODE
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D6';

-- ������ 2�� �̻� ���� ���( AND, OR)
-- �μ��ڵ尡 D6�̸鼭 �̸��� '�����'�� ����� ��� ���� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE WHERE DEPT_CODE ='D6' AND EMP_NAME ='�����';

-- �÷� �� ��Ī �ޱ�
-- 1. AS(alias) ǥ��
SELECT EMP_ID AS "��� ��ȣ", EMP_NAME AS "�����" FROM EMPLOYEE;

-- 2. AS ����
-- ��Ī�� ()�� ���� ���� ���ڰ� �� ��� �ݵ�� " "�� ���� ����� �Ѵ�.
-- (�ٿ��ִ� �ܾ�� " " ���� ���� ������ "��� ��" �̷������� ������ " "�� �� �ʿ�)
SELECT EMP_ID ���, EMP_NAME ����� FROM EMPLOYEE;

-- �ǽ����� 1
-- EMPLOYEE ���̺��� ��� ��ȣ�� 205���� ����� �����, �̸���, �޿�, �Ի������� ��ȸ�Ͻÿ�
-- (��, ��ȸ�ϴ� �÷��� ��Ī �ο�)
-- EMP_NAME, EMAIL, SALARY, HIRE_DATE
SELECT EMP_NAME �����, EMAIL �̸���, SALARY �޿�, HIRE_DATE �Ի����� FROM EMPLOYEE WHERE EMP_ID = 205;

-- �÷� ���� ����Ͽ� ���� ����
-- �÷� ���� ���� null�̶�� � ������ ó���Ͽ��� ����� NULL
SELECT  EMP_NAME "�����", (SALARY *12 ) "����", BONUS "���ʽ�", (SALARY + (SALARY*BONUS))*12 "��������" FROM EMPLOYEE;

-- NVL() : ���� ���� ��ȸ�� ���� NULL�� ��� ������ ������ ������ ����
-- NVL(�÷���, �⺻��)
SELECT EMP_NAME �����, (SALARY *12) ����, BONUS ���ʽ�, (SALARY+ (SALARY*NVL(BONUS,0)))  �������� FROM EMPLOYEE;

--  �÷��� �Ϲݰ� ���
SELECT EMP_NAME, SALARY*12, '��' ���� FROM EMPLOYEE;

-- DISTINCT : �ߺ� ����
-- �ش��ϴ� ���� �÷��� ������ ���� �� ��� �ߺ��� �����ϰ� �� ���� ��ȸ(NULL�� ����)
SELECT DEPT_CODE FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;

-- �ǽ� 2
-- DEPARTMENT ���̺��� �����Ͽ�, �μ��� '�ؿܿ���2��' �μ��� �μ��ڵ带 ã��
-- EMPLOYEE ���̺��� �ش� �μ��� ����� �� �޿��� 200�������� ���� �޴� ������
-- ���, �����, �޿��� ��ȸ
-- 1) '�ؿܿ���2��' �μ��� �ڵ�ã��
SELECT * FROM DEPARTMENT WHERE DEPT_TITLE = '�ؿܿ���2��';
-- 2) ��ȸ�� �μ��ڵ带 ����Ͽ� ����� �� �޿��� 200�������� ���� �޴� ������ȸ

SELECT EMP_ID ���, EMP_NAME �����, SALARY �޿� FROM EMPLOYEE WHERE DEPT_CODE  = 'D6' AND SALARY  > 2000000;

-- ������ -- 

-- ���� ������ 
--  '||' : ���� �÷��� ����� ���� �ϳ��� �÷����� ���� �� ���
-- EX) '���'�� ���� ����� �̸��� 'O O O' �Դϴ�.
SELECT EMP_ID || '�� ���� ����� �̸���' || EMP_NAME || '�Դϴ�.' FROM EMPLOYEE;

-- �� ������
-- <, >, <=, >= : ũ�⸦ ��Ÿ���� �ε�ȣ
-- = : ����
-- !=, ^=, <> : ���� �ʴ�

-- EMPLOYEE���� �μ��ڵ尡 D9�� �ƴ� �������� ��� ���� ��ȸ
SELECT * FROM EMPLOYEE WHERE DEPT_CODE != 'D9';

-- EMPLOYEE���� �޿��� 350���� �̻� 550���� ������ ���� ���, �����, �μ��ڵ�, �����ڵ�, �޿������� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY FROM EMPLOYEE WHERE SALARY >= 3500000 AND SALARY  <= 5500000;

-- ORDER BY SALARY ASC; -- ��������
-- ORDER BY SALARY DESC; -- ��������

-- BETWEEN A AND B
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY FROM EMPLOYEE WHERE SALARY BETWEEN 3500000 AND 5500000;

-- ���� �Ȱ��� ���� ������ ��ȸ�ϴµ� 350���� �̸�, 550���� �ʰ��� ���� ������ ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY FROM EMPLOYEE WHERE SALARY NOT BETWEEN 3500000 AND 5500000;

-- LIKE : �Է��� ����, ���ڰ� ���Ե� ������ ��ȸ
-- '_' =  ������ �� ����
-- '%' = ���ڸ� ���ڵ� �������(�� Ȥ�� �ڿ� ����ڰ� �ֵ� ������� ��ȸ)

-- EMPLOYEE���� ����� �̸� ��� '��'�� ���� ��� ���� ��ȸ
SELECT * FROM EMPLOYEE WHERE EMP_NAME  LIKE '_��_';

-- EMPLOYEE ���̺��� �ֹε�Ϲ�ȣ ���� ������ ����� ������ ��ȸ
SELECT * FROM EMPLOYEE WHERE EMP_NO LIKE '%-1%'; --    ==   ______-1% == ______-1______

--��� �� �̸��� ���̵� 5���ڸ� �ʰ��ϴ� ����� �����, ���, �̸��� ������ ��ȸ
SELECT EMP_NAME, EMP_ID, EMAIL FROM EMPLOYEE  WHERE EMAIL NOT LIKE   '_____@%'; -- �̷����ϸ� 5�ڸ��� �ƴ� 4,3,2,1 �ڸ��� �� ���
SELECT EMP_NAME, EMP_ID, EMAIL FROM EMPLOYEE  WHERE EMAIL LIKE  '______%@%'; -- �̷��Ծ��°� �½��ϴٿ�

-- EMPLOYEE ���̺��� '��'�� ���� ���� ���� ��� ��ȸ�ϱ�
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '��%';

-- ��� �� �̸��� 4��° �ڸ��� '_'�� ����� ���� ��ȸ -- '_'�� ���� �״�� ���� ���� ��
SELECT  EMP_ID , EMP_NAME , EMAIL FROM EMPLOYEE WHERE EMAIL LIKE '___#_%@%' ESCAPE '#';

-- IN ������ 
-- IN(��1, ��2, ��3, ...)
-- �ȿ� �ִ� ���� �� �ϳ��� ��ġ �ϴ� ��� �ش��ϴ� ���� ��ȸ

-- �μ��ڵ尡 D1, D6�� �μ��� ���� ������ ��ȸ
-- DEPT_CODE = 'D1' OR DEPT_CODE = 'D6' (������ ������� �ۼ�)
SELECT * FROM EMPLOYEE WHERE DEPT_CODE IN('D1','D6'); -- D1�̰ų� D6�̰ų� �� �� ��ȸ

-- �μ��ڵ尡 D1�� D6�� �ƴ� �μ��� ������ ��ȸ
SELECT * FROM EMPLOYEE WHERE DEPT_CODE NOT IN('D1','D6');

-- �������� �켱 ����
-- 0. ( ) ��ȣ
-- 1. ��� ������(+,-,*,/);
-- 2. ���� ������
-- 3. �� ������
-- 4. IS NULL // IS NOT NULL / LIKE, IN / NOT IN
-- 5. BETWEEN A AND B
-- 6. NOT
-- 7. AND
-- 8. OR


-- ���� �ǽ� ����1
-- ������ 'J2' �̸鼭 200���� �̻� �޴� ���� �̰ų�, ������ 'J7'�� ����� ���, �����, �����ڵ�, �޿� ���� ��ȸ
-- �����ڵ� : JOB_CODE, ��� : EMP_ID, �޿� : SALARY
SELECT  EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE  (JOB_CODE  = 'J2' AND SALARY  >= 2000000) OR JOB_CODE  = 'J7';

-- ���� �ǽ� ����2
-- ������ 'J7' �̰ų� 'J2'�̸鼭 �޿��� 200���� �̻� �޴� ������ ���, �����, �����ڵ�, �޿��� ��ȸ
-- ������ J7�̰ų� J2 �� ������ �����ϰ� �޿��� 200���� �̻� �޴� ���� �� ���, �����, �����ڵ�, �޿��� ��ȸ
SELECT  EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE (JOB_CODE  = 'J7' OR JOB_CODE = 'J2') AND SALARY  >= 2000000;


-- �Լ�(FUNCTION) --

-- ���� ���� �Լ�
-- LENGTH : ���ڿ��� ���̸� ����ϴ� �Լ�
-- DUAL(�ӽ����̺�(������ ���̺�)) : SELECT������ ���ͷ��� Ȱ���� ������ �׽�Ʈ �ϰ��� �� �� ����ϴ� �ӽ� ���̺�
-- LENGTHB : BYTE�� ��� ����(����� 1BYTE, �ѱ��� 3BYTE)
SELECT LENGTH('Hello'), LENGTHB('Hello') FROM DUAL;
SELECT LENGTH('��â��'), LENGTHB('��â��') FROM DUAL;

-- INSTR : �־��� ������ ���ϴ� ���ڰ� ���°���� ã�� ��ȯ�ϴ� �Լ� -> INSTR('���ڿ�', 'ã�� ����')
SELECT INSTR ('ABCDE', 'A') FROM DUAL;
SELECT INSTR ('ABCDE', 'C') FROM DUAL;
SELECT INSTR ('ABCDE', 'Z') FROM DUAL;  -- ���� ���ڸ� ã������ �� 0�� ��ȯ

-- SUBSTR(�÷��� | ��, ���ۼ���[, ������ ����])
-- �־��� ���ڿ����� Ư�� �κи� �������� �Լ�

SELECT 'Hello World', SUBSTR('Hello World', 7) FROM DUAL; 
SELECT 'Hello World', SUBSTR('Hello World', 1,5) FROM DUAL; 

-- �ǽ� 3
-- EMPLOYEE ���̺��� ����� �̸�, �̸��� ��ȸ
-- �̸����� ���̵�κи� ��ȸ�ϱ�
-- ��ȸ��� --
-- ȫ�浿 hong_gd

-- 1. �̸��� �̸��� ��ȸ
SELECT  EMP_NAME, EMAIL FROM EMPLOYEE;

-- 2. @��ġ ã��
SELECT INSTR(EMAIL, '@') FROM EMPLOYEE;

-- 3. SUBSTR Ȱ��
SELECT  EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1 ) FROM EMPLOYEE;

-- LPAD / RPAD  : ��ĭ�� ������ ���ڷ� ä���� (LPAD�� ���ʺ��� ��ĭ���� ����� ä��. RPAD�� �����ʺ��� ä��)
-- LPAD (���, ũ��, '�ٲܹ���') -- RPAD (���, ũ��, '�ٲܹ���')
SELECT LPAD(EMAIL, 20, '#') FROM EMPLOYEE;
SELECT RPAD(EMAIL, 20, '-') FROM EMPLOYEE;

-- LTRIM / RTRIM
-- ���� �ο��� �÷� ���̳�, Ư�� ������ ���� Ư�� ���ڸ� ã�� �����ִ� �Լ�
-- ã�� ���ڸ� �������� ������ ��ĭ�� �����.
-- LTRIM�� ���ʿ� �ִ� �͸� ����, RTRIM�� �����ʿ� �ִ� �͸� ����
SELECT LTRIM('             Hello') FROM DUAL;
SELECT RTRIM('Hello             ') FROM DUAL;
SELECT RTRIM('             HI') FROM DUAL;

SELECT  LTRIM('012345','0') FROM DUAL;
SELECT  LTRIM('012345','1') FROM DUAL;
SELECT  LTRIM('111234', '1') FROM DUAL;   -- ó�� ��� ���ڰ� ������ ���ڶ� ������ ����� ��?

-- TRIM : �־��� ���ڿ����� �糡�� �������� Ư�����ڸ� �����ִ� �Լ�
-- �⺻���� (������� �ϴ� ���ڰ� ���� �� ��������)
SELECT TRIM('      ���� ���      ') FROM DUAL;

-- �糡�� Ư������ ������� �� ��
-- TRIM('���� ����' FROM '���ڿ�')
SELECT TRIM('0' FROM '00012300') FROM DUAL;


-- �� 3���� �� �Ⱦ�(�ֳ��ϸ� LTRIM, RTRIM, TRIM�� ����Ǵϱ�)
-- ��ġ LTRIM�� ����
SELECT TRIM (LEADING '0' FROM '00012300') FROM DUAL;

-- ��ġ RTRIM�� ����
SELECT TRIM (TRAILING '0' FROM '00012300') FROM DUAL;

-- ��ġ TRIM�� ����
SELECT TRIM(BOTH '0' FROM '00012300') FROM DUAL;


-- LOWER / UPPER / INITCAP : �־��� ���ڿ��� ���� �ҹ��� / �빮�� / ù���ڸ� �빮�ڷ� �������ִ� �Լ�
SELECT LOWER('NICE TO MEET YOU'),
				 UPPER('nice to meet you'),
				   INITCAP('nice to meet you')
FROM DUAL;

-- CONCAT : ���� ���ڿ��� �ϳ��� ���ڿ��� ��ġ�� �Լ�
-- CONCAT('���ڿ�', '���ڿ�')
SELECT CONCAT('����Ŭ', ' �ʹ� ��վ��^^;;;') 
FROM DUAL;
SELECT '����Ŭ' || ' ������� :) ' 
FROM DUAL;

-- REPLACE : �־��� ������ Ư�� ���ڸ� ������ �� ����ϴ� �Լ�
-- REPLACE('���ڿ�', '�ٲ� ���ڿ�', '�ٲ� ���ڿ�')
SELECT REPLACE('HELLO WORLD', 'HELLO' , 'BYE' ) 
FROM DUAL;

-- �ǽ� 4
-- EMPLOYEE ���̺��� ����� �ֹι�ȣ�� Ȯ���Ͽ� ���� ������ ���� ��ȸ�Ͻÿ�.
-- �̸� | ���� | ���� | ����

SELECT EMP_NAME "�̸�", 
			   CONCAT(SUBSTR(EMP_NO ,1,2),'�� ') "����",
			   CONCAT(SUBSTR(EMP_NO ,3,2),'�� ') "����", 
			   CONCAT(SUBSTR(EMP_NO ,5,2),'��')  "����" 
FROM EMPLOYEE;

--SUBSTR�� Ȱ���ϸ� ��¥ �����͵� ���� �� �ִ�.
--- '19/03/15' --> 19     /       03           /            15 
-- ��¥�� �⵵ 4�ڸ� �� �ڿ� 2�ڸ��� �������� ������
SELECT EMP_NAME �̸�,
			CONCAT(SUBSTR(HIRE_DATE, 1, 2), '��') "�Ի�⵵"
FROM EMPLOYEE;

-- ���� �� �Լ�(Single Row Function) : ����� ã�Ƽ� ����� ������ ���࿡ �Լ��� ����

-- ���� �� �Լ�(Multiple Row Function) : �������� �����ϴ� ��� ���� �� ã�� ���� �ѹ��� ����

-- �׷� �Լ�(Group Function)
-- SUM( ), AVG( ), MAX( ), MIN( ), COUNT( )

-- SUM() : �ش� �÷����� �հ�
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- AVG() : �ش� �÷����� ����� ���
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- MAX() / MIN() : �ش� �÷����� �� �� �ִ� / �ּڰ�
SELECT  MAX(SALARY),
				MIN(SALARY)
FROM EMPLOYEE;


-- �ǽ� 5 --
-- EMPLOYEE ���̺��� '�ؿܿ���1��'�� �ٹ��ϴ� ��� ����� ��� �޿�, ���� ���� �޿�, ���� ���� �޿�, �޿��հ� ��ȸ

SELECT * 
FROM DEPARTMENT
WHERE DEPT_TITLE = '�ؿܿ���1��';

SELECT AVG(SALARY ),
				SUM(SALARY),
				MAX(SALARY),
				MIN(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE  = 'D5';

-- COUNT() : �ش��ϴ� ���� ����
SELECT COUNT(*)
FROM EMPLOYEE;

-- NULL���� ������ ��� �̸� ������� �ʴ´�.
SELECT COUNT(*),
			COUNT(DEPT_CODE), 
			COUNT(DISTINCT DEPT_CODE )   -- �����δ� 7�� �������� COUNT�� NULL�� ������� ����
FROM EMPLOYEE;

SELECT DEPT_CODE
FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

--- �ǽ� 6.
-- EMPLOYEE ���̺��� ��� ����� ���, �����, �̸���, �ֹι�ȣ�� ��ȸ�Ͽ� ��� ���ǥ�� ������� �Ѵ�.
-- �̶�, �̸����� '@' ������, �ֹι�ȣ�� 7��°�ڸ� ���� '*'�� ó���Ͽ� ��ȸ�Ͻÿ�.
-- EMP_ID, EMP_NAME, EMAIL, EMP_NO

SELECT EMP_ID  ���, 
				EMP_NAME �����,  
				SUBSTR(EMAIL,1,INSTR(EMAIL, '@') -1)�̸���,
				RPAD(SUBSTR(EMP_NO, 1, 8),14 , '*') �ֹι�ȣ
FROM EMPLOYEE
ORDER BY 2;  -- ����� �������� ����(��, 2��° ���̺��� �������� ����) . 1������ �����ϸ� ��� .... ���)

-- �ǽ� 7.
-- EMPLOYEE ���̺��� ���� �ٹ��ϴ� ���� ����� ���, �����, �����ڵ带 ��ȸ �Ͻÿ�.
-- ** ENT_YN : ���� �ٹ� ���� �ľ��ϴ� �÷�(��� ����)

SELECT EMP_ID ���,
				EMP_NAME �����,
				JOB_CODE �����ڵ�
FROM EMPLOYEE
WHERE ENT_YN  = 'N' AND (EMP_NO LIKE '%-2%');
-- ����� ����. WHERE SUBSTR(EMP_NO ,8 ,1 ) = '2'    ( �ֹ� ���ڸ� ù��° ���ڰ� 2�� ���)










