-- ��¥ ó�� �Լ�
-- SYSDATE : ���� ��ǻ���� ��¥�� ��ȯ �ϴ� �Լ�
SELECT SYSDATE FROM DUAL;

-- MONTHS_BETWEEN(��¥1, ��¥2) : �� ��¥ ������ ���� ��
SELECT  HIRE_DATE �Ի���, 
			MONTHS_BETWEEN(SYSDATE, HIRE_DATE) "�Ի� �� ���� ��"
FROM EMPLOYEE;

-- ADD MONTHS(��¥, ���� ��)
SELECT ADD_MONTHS(SYSDATE, 6) FROM DUAL;

-- EXTRACT(YEAR | MONTH | DAY  FROM ��¥������)
-- ������ ���κ��� ��¥ ���� ���� �ϴ� �Լ�
SELECT EXTRACT(YEAR FROM HIRE_DATE),
			EXTRACT(MONTH FROM HIRE_DATE),
			EXTRACT(DAY FROM HIRE_DATE)
FROM EMPLOYEE;


-- ����ȯ �Լ�
-- DATE <--> CHAR <--> NUMBER 
-- TO_DATE(), TO_CHAR(), TO_NUMBER()
-- ��¥�����ͷ� / ���ڷ� / ���ڷ� ��ȯ���ִ� �Լ�

-- TO_CHAR() --
-- ��¥ DATA�� ���ڷ� ����
SELECT HIRE_DATE,
		TO_CHAR(HIRE_DATE, 'YYYY-MM-DD'),
		TO_CHAR(HIRE_DATE, 'YY-MON-DD')
FROM EMPLOYEE;

-- ���� ���� ����
-- 9 : ���� �� ĭ�� ǥ������ �ʴ´�.
-- 0 : ���� ��ĭ�� 0���� ǥ��
-- L : ��ȭ��ȣ(��, ��, ����, �޷�) - �ڵ�����
SELECT SALARY,
			TO_CHAR(SALARY, 'L999,999,999'), 
			TO_CHAR(SALARY, '000,000,000'),
			TO_CHAR(SALARY, 'L999,999')   -- ������ �ִ� ũ�� ��ŭ ������ �ʴٸ� ###### �̷������� ǥ�� ��.
FROM EMPLOYEE;

-- TO_DATE() -- 
SELECT 20200515,
		TO_DATE(20200515, 'yyyymmdd'),         --���� �ٰ� ������ ��� ���� ��� ��.
		TO_DATE(20200515, 'YYYY/MM/DD')
FROM DUAL;

-- DECODE(����, ���ϴ� ����, �� �϶��� �� , �ٸ� ����, �ٸ������� �� �϶��� ��) -- 
-- DECODE(����, ���ϴ� ����, �� �϶��� ��, ���� �϶��� ��)
-- JAVA���� 3�׿����� ����( ���� ? �� : ����)

-- ���� �ٹ��ϴ� �������� ������ ��, ���� ���� ����
SELECT EMP_NAME, EMP_NO,
		DECODE(SUBSTR(EMP_NO, 8, 1), '1' ,  '��', '2' , '��') ����
	--DECODE(SUBSTR(EMP_NO,8,1), '1', '��' , ' ��') ����     -- ���� �ٰ� ���� �ǹ�
FROM EMPLOYEE
ORDER BY ����;

-- �ǽ� 1
-- EMPLOYEE ���̺��� ��� ������ ���, �����, �μ��ڵ�, �����ڵ�, �ٹ�����, �����ڿ��� ��ȸ�ϵ�,
-- ���� �ٹ� ���ΰ� 'Y'�� �����, 'N'�̸� �ٹ���,  �����ڻ��(MANAGER_ID) ������ '���', ������ '������'�� �ۼ��Ͽ� ��ȸ
SELECT EMP_ID "���", EMP_NAME "�����", DEPT_CODE "�μ��ڵ�", JOB_CODE  "�����ڵ�",
			DECODE(ENT_YN , 'Y','�����','�ٹ���') "�ٹ� ����", 
						 DECODE(MANAGER_ID , '', '������', '���') "������ ����",
--					 DECODE(MANAGER_ID , NULL, '������', '���') "������ ����",    3�� �� ����
-- ����� ����. DECODE( NVL(MANAGER_ID,0), 0, '������', '���') "������ ����"
FROM EMPLOYEE;
	
-- CASE ��
-- JAVA�� IF, SWITCHó�� ����� �� �ִ� �Լ�
-- CASE
--   WHEN(���ǽ�1) THEN �����1
--   WHEN(���ǽ�2) THEN �����2
--   ELSE �����3
--   END
SELECT EMP_ID "���",
				EMP_NAME "�����",
				DEPT_CODE "�μ��ڵ�",
				JOB_CODE "�����ڵ�",
				CASE 
							WHEN ENT_YN = 'Y' THEN '�����'
							ELSE '�ٹ���'
				END "�ٹ� ����",
				CASE 
							WHEN  MANAGER_ID IS NULL THEN '������'
							ELSE '���'
				END "������ ����"
FROM EMPLOYEE;

-- NVL2(�÷��� | ������, NULL�� �ƴ� ��� ��, NULL�� ��� ��)
SELECT EMP_ID ���,
				EMP_NAME �����,
			BONUS ���ʽ�,
			NVL(TO_CHAR(BONUS), 'X' ) "NVL �Լ�",
			NVL2(BONUS, TO_CHAR(BONUS, '0.99') , 'X') "NVL2 �Լ�"			
FROM EMPLOYEE;

-- ���� ������ �Լ� -- 
-- ABS( ) : ���� ǥ��
SELECT ABS(10), ABS(-10)
FROM DUAL;

-- MOD() : �־��� �÷��̳� ���� ���� �������� ��ȯ�ϴ� �Լ�
SELECT MOD(10,3), MOD(10,2), MOD(10,7)
FROM DUAL;

-- ROUND() : ������ ���ڸ� �ݿø� �ϴ� �Լ�
SELECT ROUND(123.456,0),     -- �ڿ� ���ڴ� �Ҽ����ڸ���(0�̸� ������ ����ϰڴ�)
				ROUND(123.456,1),
				ROUND(123.456,2),
				ROUND(123.456,-2) 		-- -2�� 2��°�ڸ����� �ݿø�.(�����ڸ����� �ݿø�)	
FROM DUAL;

-- CEIL() : �Ҽ��� ù° �ڸ����� �ø�
-- FLOOR() : �Ҽ��� ���� �ڸ��� ����
-- TRUNC() : ������ ��ġ���� ���ڸ� ����
SELECT CEIL(123.456),
				FLOOR(123.456),
				TRUNC(123.456, 0),
				TRUNC(123.456, 1),
				TRUNC(123.456, -2)
FROM DUAL;

-- �ǽ� 2
-- EMPLOYEE ���̺��� �Ի��� ���� ���ڰ� Ȧ �� ���� ������ ���, �����, �Ի��� ������ ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE MOD(EXTRACT(MONTH FROM HIRE_DATE),2) = 1;

-- ��¥ ������
-- SYSDATE, MONTHS_BETWEEN, ADD_MONTHS,
-- EXTRACT, LAST_DAY, NEXT_DAY

--SYSDATE, SYSTIMESTAMP
SELECT SYSDATE,
			SYSTIMESTAMP
FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH:MI:SS' ),
				TO_CHAR(SYSTIMESTAMP, 'YYYY-MM-DD HH:MI:SSFF' )
FROM DUAL;

--NEXT_DAY(��¥, ���ϸ�)     : ��¥�κ��� �ٰ��� ���� ����� ����
SELECT NEXT_DAY(SYSDATE, '�����'),
				 NEXT_DAY(SYSDATE, '��'),
--				 NEXT_DAY(SYSDATE, 'SATURDAY'),			 :  ������(����Ŭ �� �ν��ϰ� �ִ� ���� �ѱ�!!- ����� �ν��� �� �� ����)
				 NEXT_DAY(SYSDATE, 7)     -- 1 : �Ͽ���, 7: �����
FROM DUAL;

-- ������ ����(������ ��ųʸ�)
-- ���� ������ ������ ������ DB�� ���̺� ���·� �����ϴ� ���̺�
-- �⺻������ �ý����� �����ڸ� ���� ����
-- ��, ����� ������ ������ ������ ���� ����, ���� �� ������ �ϸ� �ʱ�ȭ
SELECT * FROM V$NLS_PARAMETERS;     -- ��� ������ �ѱ���� �Ǿ�����

ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

-- ������ ���� ��ȸ
SELECT NEXT_DAY(SYSDATE, 'SATURDAY')    --����� �����ϰ� �ϸ� ���� �ȶ�
FROM DUAL;

ALTER SESSION SET NLS_LANGUAGE = KOREAN;

-- LAST_DAY() : �־��� ��¥�� ������ ���ڸ� ��ȸ(EX. 5���� ���������� 31��)
SELECT LAST_DAY(SYSDATE)
FROM DUAL;

-- ��¥�������� ���� �ֱ� ��¥�ϼ��� ���� �� ū������ �Ǵ�
-- +,- ���� ����
SELECT (SYSDATE -10) "��¥ 1",     -- ���ڿ��� 10���� ����
					TRUNC(SYSDATE - TO_DATE('20/03/01', 'RR/MM/DD')) "��¥ 2",    -- ���ڳ����� ���� ��� �� ����.
					TRUNC(TO_DATE('20/03/01', 'RR/MM/DD')- SYSDATE ) "��¥ 2"    -- ���ڳ����� ���� ��� �� ����.
FROM DUAL;

-- �ǽ�3
-- EMPLOYEE���̺��� �ٹ������ 20�� �̻��� ������� ���, �����, �μ��ڵ�, �Ի����� ��ȸ�Ͻÿ�
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)) >= 20;
-- ����Թ���. WHERE ADD_MONTHS(HIRE_DATE, 240) <= SYSDATE;

-- ����ȯ--------------------------------
/*
	YYYY �⵵ ǥ��(4�ڸ�) YY �⵵ ǥ��(2�ڸ�)
    MM  ���� ���ڷ�
	DAY ���� ǥ��
 */
SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS'),
				TO_CHAR(SYSDATE, 'MON DY, YYYY'),
				TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY'),
				TO_CHAR(SYSDATE, 'YEAR, Q')
FROM DUAL;


-- Y/R
SELECT TO_CHAR(TO_DATE('200315', 'YYMMDD'), 'YYYY') "���1",
				 TO_CHAR(TO_DATE('200315', 'RRMMDD'), 'RRRR') "���2",
				 TO_CHAR(TO_DATE('800315', 'YYMMDD'), 'YYYY') "���3",
				 TO_CHAR(TO_DATE('800315', 'RRMMDD'), 'RRRR') "���4"
FROM DUAL;

--4�ڸ� �ѹ��� �Է� ���� ��쿡�� YYYY�� RRRR �Ѵ� ��������
--2�ڸ��� �Է� ���� ��� YY�� �� ���� ����, RR�� �� ���� ����

-- YY
-- 80 --> 2080
-- RR
-- 50 ~ 99 --> 1900���
-- 0 ~  49--> 2000���

SELECT '123'+'456'
FROM DUAL;  -- ��Ģ���� �ߵ�
SELECT '123'+'456ABC'
FROM DUAL;  -- ��Ģ���� �Ұ��� ���� �߻�

-- SELECT���� ���� ����
/*
 	SELECT �÷��� AS ��Ī, ���, �Լ���
 	FROM ���̺��
 	WHERE ����
 	GROUP BY �׷��� ���� �÷Ÿ�
 	HAVING �׷쿡 ���� ���ǽ�, �Լ���
 	ORDER BY �÷�|��Ī|����
  */

-- ORDER BY --
SELECT EMP_ID, EMP_NAME �̸�, SALARY, DEPT_CODE
FROM EMPLOYEE
--ORDER BY EMP_ID;
--ORDER BY EMP_ID DESC; -- ��������
ORDER BY DEPT_CODE, EMP_ID ;    -- DEPT_CODE�� ���� �� EMP_ID�� �ٽ� ����

--  GROUP BY : Ư�� �÷�, ������ �ϳ��� �׷����� ���� �� ���̺� ������ �ұ׷� ���� ��ȸ �ϰ��� �� �� �����ϴ� ����

-- �μ��� ���
SELECT TRUNC( AVG(SALARY),-3)
FROM EMPLOYEE;
-- D1 ��� �޿� 
SELECT TRUNC( AVG(SALARY),-3)
FROM EMPLOYEE
WHERE DEPT_CODE  = 'D1';

SELECT DEPT_CODE, 
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY 1;

-- �ǽ� 4
-- EMPLOYEE ���̺��� �μ� �� �� �ο�, �޿� �հ�, �޿� ���, �ִ� �޿�, �ּ� �޿��� ��ȸ�Ͽ�
-- �μ��ڵ� �������� �������� �����Ͻÿ�.
-- ��, �޿� ��� �����ʹ� 100�� �ڸ������� ó��
SELECT DEPT_CODE "�μ��ڵ�", 
				COUNT(EMP_NAME) "�� �ο�",    --COUNT(*)�� ��
				SUM(SALARY) "�޿� �հ�",
				TRUNC(AVG(SALARY), -2) "�޿� ���",
				MAX(SALARY) "�ִ� �޿�", 
				MIN(SALARY) "�ּ� �޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY 1;

-- ���� �ڵ� �� ���ʽ��� �޴� ����� ���� ��ȸ
SELECT JOB_CODE �����ڵ�, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY 1 DESC;

-- �ǽ� 5
-- EMPLOYEE ���̺��� ���������� ���������� ���� ��ȸ�Ͻÿ�
-- GROUP BY���� �־��� Į������ �ƴ� �Լ��ĵ� ��� ����
SELECT DECODE(SUBSTR(EMP_NO,8,1),1,'����','����') ����,
			COUNT(*) || '��' ������
FROM EMPLOYEE
GROUP BY DECODE(SUBSTR(EMP_NO,8,1),1,'����','����');   -- ������ �������� ������ ���� �׷����� �ϰڴ�

-- HAVING ����
-- GROUP BY �� �� �ұ׷쿡 ���� ������ ���� �� �� �׷��Լ��� �Բ� ����ϴ� ����
SELECT DEPT_CODE,
				AVG(SALARY) ���
FROM EMPLOYEE
WHERE SALARY > 3000000
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, AVG(SALARY) ���
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY ) > 3000000
ORDER BY 1;

-- �ǽ� 6.
-- �μ��� �׷��� �޿� �հ� �� 900������ �ʰ� �ϴ� �μ��� �ڵ�� �޿� �հ踦 ��ȸ
SELECT DEPT_CODE "�μ� �ڵ�", SUM(SALARY) "�޿� �հ�"
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) > 9000000
ORDER BY 1;

-- �ǽ� 7.
-- �޿� �հ谡 ���� ���� �μ��� ã��, �ش� �μ��� �μ� �ڵ�� �޿� �հ踦 ��ȸ
-- 1) �μ��� �� ���� ���� �޿� �հ�
-- 2) ���� ���� �޿� �հ踦 ���� �μ�

SELECT MAX(SUM(SALARY)) "�ִ� �޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE 
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = 17700000;

-- SUB QUERY -- 
 -- ���� IF�� ���� ����-
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) 
													FROM EMPLOYEE
													GROUP BY DEPT_CODE);

												
												
--1. ������� �ֹι�ȣ�� ��ȸ��.  ��, �ֹι�ȣ 9��° �ڸ����� �������� '*'���ڷ� ä��
-- ��: ȫ�浿 771120-1******
SELECT EMP_NAME "������",
				RPAD(SUBSTR(EMP_NO,1,8),14,'*') "�ֹι�ȣ"
FROM EMPLOYEE;
																							
--2. ������, �����ڵ�, ����(��) ��ȸ. ��, ������ 57,000,000���� ǥ�õǰ� ��
--  ������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���.
SELECT EMP_NAME "������", 
				JOB_CODE "�����ڵ�", 
				ROUND((SALARY + (SALARY*(NVL(BONUS,0))))*12 , -6)"����"
FROM EMPLOYEE;

--3. �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի���
-- ��� ����� �μ��ڵ� �Ի���
SELECT EMP_ID "���", EMP_NAME "�����", HIRE_DATE "�Ի���"
FROM EMPLOYEE
WHERE (DEPT_CODE  = 'D5' OR DEPT_CODE = 'D9') AND  EXTRACT(YEAR FROM HIRE_DATE) = '2004' ;

--4. ������, �Ի���, �Ի��� ���� �ٹ��ϼ� ��ȸ
-- ��, �ָ��� ������
SELECT EMP_NAME "������", 
				HIRE_DATE "�Ի���",
				LAST_DAY(HIRE_DATE) - HIRE_DATE "�Ի��� ���� �ٹ� �ϼ�",
FROM EMPLOYEE;

--5. ������, �μ��ڵ�, �������, ����(��) ��ȸ. ��, ��������� �ֹι�ȣ���� �����ؼ�, 00�� 00�� 00�Ϸ� ��µǰ� ��.
-- ���̴� �ֹι�ȣ���� �����ؼ� ��¥ �����ͷ� ��ȯ�� ����, �����
SELECT EMP_NAME "������" ,
				DEPT_CODE "�μ��ڵ�",
			   SUBSTR(EMP_NO,1,2) ||'�� '||SUBSTR(EMP_NO,3,2) || '�� '||SUBSTR(EMP_NO,5,2)||'��'  "�������",
			   CEIL (MONTHS_BETWEEN(SYSDATE,TRUNC(TO_DATE(SUBSTR(EMP_NO,1,2), 'RRRR' ), 'YEAR') )/12) "�츮���� ����",
			   TRUNC(MONTHS_BETWEEN(SYSDATE,TO_DATE(SUBSTR(EMP_NO,1,6), 'RRMMDD' ))/12,0) "�� ����"
FROM EMPLOYEE;

--6. �������� �Ի��Ϸ� ���� �⵵�� ������, �� �⵵�� �Ի��ο����� ���Ͻÿ�.
-- �Ʒ��� �⵵�� �Ի��� �ο����� ��ȸ�Ͻÿ�.
-- =>TO_CHAR, DECODE, SUM ���

SELECT 	SUM(DECODE(SUBSTR(HIRE_DATE ,1,2),NULL,'',COUNT(EMP_NAME))) "��ü������",
					SUM(DECODE(SUBSTR(HIRE_DATE ,1,2),'01',COUNT(EMP_NAME))) "2001��",
					SUM(DECODE(SUBSTR(HIRE_DATE ,1,2),'02',COUNT(EMP_NAME))) "2002��",
					SUM(DECODE(SUBSTR(HIRE_DATE ,1,2),'03',COUNT(EMP_NAME))) "2003��",
					SUM(DECODE(SUBSTR(HIRE_DATE ,1,2),'04',COUNT(EMP_NAME))) "2004��"
FROM EMPLOYEE
GROUP BY SUBSTR(HIRE_DATE ,1,2);
-------------------------------------------------------------
--	��ü������   2001��   2002��   2003��   2004��
---------------------------------------------------------------

--7.  �μ��ڵ尡 D5�̸� �ѹ���, D6�̸� ��ȹ��, D9�̸� �����η� ó���Ͻÿ�. ��, �μ��ڵ尡 D5, D6, D9 �� ������ ������ ��ȸ��
--  => case ���
--   �μ��ڵ� ���� �������� ������.
SELECT 
			CASE 
				WHEN DEPT_CODE = 'D5' THEN '�ѹ���'
				WHEN DEPT_CODE = 'D6' THEN '��ȹ��'
				WHEN DEPT_CODE = 'D9' THEN '������'
				END "�μ��ڵ�",
				EMP_ID "���",
				EMP_NAME "�̸�",
				EMP_NO "�ֹι�ȣ"
FROM EMPLOYEE
WHERE DEPT_CODE  = 'D5' OR DEPT_CODE  = 'D6' OR DEPT_CODE  = 'D9'
ORDER BY DEPT_CODE;

--  => case ���
--   �μ��ڵ� ���� �������� ������.
SELECT 
			CASE 
				WHEN DEPT_CODE = 'D5' THEN '�ѹ���'
				WHEN DEPT_CODE = 'D6' THEN '��ȹ��'
				WHEN DEPT_CODE = 'D9' THEN '������'
				END "�μ��ڵ�",
				EMP_ID "���",
				EMP_NAME "�̸�",
				EMP_NO "�ֹι�ȣ"
FROM EMPLOYEE
WHERE DEPT_CODE  = 'D5' OR DEPT_CODE  = 'D6' OR DEPT_CODE  = 'D9'
ORDER BY DEPT_CODE DESC;






