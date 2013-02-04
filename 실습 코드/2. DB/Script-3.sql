-- GROUP BY : �־��� ����� Ư�� �ұ׷����� ���� �� ����ϴ� ����
-- HAVING : �׷� ���� ������ ������ �� ����Ѵ�.

/*
 * 	- ���� ���� ����
 *		5 : SELECT �÷���
 *		1 : FROM ���̺��
 *		2: WHERE ���ǽ�
 *		3 : GROUP BY �÷���
 *		4 : HAVING �׷쳻�� ���ǽ�
 *		6 : ORDER BY ǥ����
 */

-- �ǽ�1.
-- EMPLOYEE ���̺��� ���޺� �׷��� ���Ͽ� �����ڵ�, �޿��հ�, �޿����, �ο� ���� ��ȸ
-- ��, �ο����� 3���� �ʰ��ϴ� ���޸��� ��ȸ
SELECT JOB_CODE "�����ڵ�",
				SUM(SALARY) "�޿��հ�",
				AVG(SALARY) "�޿����",
				COUNT(*) "�ο� ��"
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING COUNT(*) >3
ORDER BY 4 DESC;

--DECODE()
--DECODE(�÷���, ���1, ��1 [, �����2, ��2 ......], �⺻��) 
SELECT EMP_NAME,
				DECODE(SUBSTR(EMP_NO,8,1),1,'����',2,'����')
FROM EMPLOYEE;


-- SET OPERATOR --     (�� �Ʒ��� ���δٰ� �����ϸ� ��. ��, �÷��� ������ ���ƾ� ���ų�, ���ϰų�, �������� ���� �� ����)
-- �ΰ� �̻��� SELECT �� ����� ��ġ�ų�, 
-- �ߺ��� ������ �����ϰų� �ϴ� ���� ������ ����� ��ȸ�ϴ� ��ɾ�

-- ������ -- 
-- UNION : �� �� �̻��� SELECT�� ����� ���ϴ� ��ɾ�
-- �ߺ��� ���� ��� �ߺ��Ǵ� ����� 1���� �����ش�.
-- UNION ALL : �� �� �̻��� SELECT�� ����� ���� �ֵ�, �ߺ��� ���� ��쿡 �״�� ��ȸ�Ͽ� �����ش�.  (��ġ SET�̳� LIST�̳� �ε�)

-- ������ --
-- INTERSECT : �� �� �̻��� ��� �� �ߺ��Ǵ� ����� �����ش�.

-- ������ --
-- MINUS : �� �� �̻��� ��� �� ù��° ������� ���� ������ �����ִ� ��ɾ�

-- SELECT ����� A�� B�� �ϳ��� ��ġ�� ���
-- A�� B�� �÷� ������ �ڷ����� �ݵ�� ���ƾ� �Ѵ�!!

-- UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- INTERSECT
SELECT EMP_ID,EMP_NAME,DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY  > 3000000;

-- MINUS
SELECT EMP_ID,EMP_NAME,DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID,EMP_NAME,DEPT_CODE,SALARY
FROM EMPLOYEE
WHERE SALARY  > 3000000;

-- JOIN --
-- �� �� �̻��� ���̺��� �ϳ��� ���ļ� ����ϴ� ��ɾ�

-- ���࿡ 'J6'��� ������ ���� ������� �ٹ� �μ����� �ñ��ϴٸ� ???
SELECT EMP_NAME, JOB_CODE, DEPT_CODE
FROM EMPLOYEE
WHERE JOB_CODE = 'J6'; -- D8, D1

SELECT * FROM DEPARTMENT;

SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_ID  IN('D1','D8');

-- ����Ŭ ���� ���� / ANSI ǥ�� ����

-- ����Ŭ ���� ����
-- FROM ���� ','��ȣ�� �ٿ� ��ġ�� �� ���̺���� ����
-- WHERE ������ ���ؼ� ��ĥ ���̺���� ���� ������ �ۼ�
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

SELECT * FROM EMPLOYEE;
SELECT * FROM JOB;

SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

SELECT*
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

SELECT *
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;    --JOIN ���� ���� ROW�� �� ������

----------------------------------------------
-- ANSI ǥ�� ����
-- �����ϰ��� �ϴ� ���̺��� FROM ���� ������
-- JOIN ���̺�� ON() | USING() ������ ����Ͽ�
-- �� �� �̻��� ���̺��� �ϳ��� ��ġ�� ���

-- �� ���� ���̺��� ���� �÷��� �̸��� �ٸ� ���
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(EMPLOYEE.DEPT_CODE = DEPARTMENT.DEPT_ID);  --EMPLOYEE�� DEPARTMENT ���� ����

-- �� ���� ���̺��� ���� �÷��� �̸��� ���� ���
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB ON(JOB.JOB_CODE = EMPLOYEE.JOB_CODE);
-- ����ó���� �� �� ������ ��ȿ����
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);   -- �������� ���ϸ� Ȯ���� ��������

-- �ǽ� 2.
-- EMPLOYEE ���̺��� ���� �޿� ������ SAL_GRADE�� �޿� ����� ���ļ�
-- ���, �����, �޿����, ��� ���� �ּұ޿�, �ִ�޿��� ��ȸ

-- �����ϰ��� �ϴ� ���̺� ���� ��ȸ
SELECT * FROM SAL_GRADE;
SELECT * FROM EMPLOYEE;

-- ����Ŭ ���� --
SELECT EMP_ID, EMP_NAME, EMPLOYEE.SAL_LEVEL,MIN_SAL, MAX_SAL
FROM EMPLOYEE, SAL_GRADE
WHERE EMPLOYEE.SAL_LEVEL  = SAL_GRADE.SAL_LEVEL;

-- ANSI ���� --
SELECT EMP_ID, EMP_NAME, SAL_LEVEL,MIN_SAL, MAX_SAL
FROM EMPLOYEE
JOIN SAL_GRADE USING(SAL_LEVEL);   -- ANSI ���� �÷�

SELECT EMP_ID, EMP_NAME,EMPLOYEE.SAL_LEVEL,MIN_SAL, MAX_SAL
FROM EMPLOYEE
JOIN SAL_GRADE ON(SAL_GRADE.SAL_LEVEL  = EMPLOYEE.SAL_LEVEL);  -- ANSI �ٸ� �÷�

-- �ǽ� 3.
-- DEPARTMENT ���̺��� ��ġ ����
-- LOCATION ���̺��� �����Ͽ� �� �μ��� �ٹ��� ��ġ�� ��ȸ
-- �μ��ڵ�, �μ���, �ٹ��� �ڵ�, �ٹ��� ��ġ
SELECT * FROM DEPARTMENT;
SELECT * FROM LOCATION;

-- ����Ŭ --
SELECT DEPT_ID, DEPT_TITLE, LOCATION.LOCAL_CODE , LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE DEPARTMENT.LOCATION_ID  = LOCATION.LOCAL_CODE;

-- ANSI --
SELECT DEPT_ID, DEPT_TITLE, LOCATION.LOCAL_CODE , LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON(LOCATION.LOCAL_CODE  = DEPARTMENT.LOCATION_ID );

-- INNER JOIN / OUTER JOIN --
-- �� �� �̻��� ���̺��� ��ĥ ��
-- INNER JOIN�� �� ��� ��ġ�ϴ� �����͸� ��ġ��,
-- OUTER JOIN�� �� �� �ϳ�, Ȥ�� �� ��ΰ� ���� ��� ���� ��ĥ �� ���

-- INNER JOIN
SELECT DISTINCT DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID )
ORDER BY 1;

-- OUTER JOIN --
-- LEFT [OUTER] JOIN : �� ���̺� �� ����(����) ���̺��� ������ ��� �����Ͽ� ��ȸ
-- RIGHT [OUTER] JOIN : �� ���̺� �� JOIN�� ����� ���̺��� ������ ��� �����Ͽ� ��ȸ
-- FULL [OUTER] JOIN : �� ���̺��� ���� ������ �� ���ΰ� ������ ���� ���̶� ��� �����Ͽ� ��ȸ

-- LEFT JOIN -- 
-- ANSI ǥ��
SELECT DEPT_CODE, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID );
-- ORACLE ����
SELECT DEPT_CODE, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE  = DEPT_ID(+);   
-- +�� �Ⱦ��� �׳� INNER JOIN������ DEPT_ID�� +���� LEFT JOIN�� ��.
-- +��ġ�� DEPT_CODE�� ������ RIGHT JOIN�� ��.
-- DEPT_ID�� ��� �߰� �ض� �ϴ½����� �����ϸ� �� ��.(DEPT_CODE�� �������� �����ϴ� ��)


-- RIGHT JOIN --
--ANSI ǥ��
SELECT DEPT_CODE, DEPT_ID, EMP_NAME
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
-- ORACLE ����
SELECT DEPT_CODE, DEPT_ID, EMP_NAME
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- FULL JOIN --
--ANSI ǥ��--
SELECT DEPT_CODE, DEPT_ID, EMP_NAME
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);
-- ORACLE
-- ORACLE ���������� FULL JOIN�� �������� �ʴ´�.
-- �ؿ� �� �ִ°ɷ� �鳯 �غ��� �ȵ�
SELECT DEPT_CODE, DEPT_ID, EMP_NAME
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID(+);


-- CROSS JOIN   (CARTESIAN PRODUCT)  -- �����ϸ� ��� ���ϴ°� ....
SELECT EMP_NAME, NATIONAL_CODE
FROM EMPLOYEE
CROSS JOIN NATIONAL;

SELECT NATIONAL_CODE
FROM NATIONAL;

-- SELF JOIN --
-- �ڱ� �ڽ��� �����ϴ� ���
-- �� ���̺��� ���� �� �� �񱳰� �ʿ��� �������� ����Ͽ� ��ȸ�ϴ� ���

-- ������ ������ ������ �����ϴ� �Ŵ����� ������ ��ȸ
SELECT * FROM EMPLOYEE;

-- ANSI --
SELECT * 
FROM EMPLOYEE E
JOIN EMPLOYEE M ON(E.MANAGER_ID  = M.EMP_ID );
-- ORACLE --
SELECT E.EMP_ID ���,
				E.EMP_NAME �����,
				E.MANAGER_ID "������ ���",
				M.EMP_NAME �����ڸ�
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;

-- ���� JOIN --
-- ���� ���� ���̺��� JOIN�ϴ� ��
-- �Ϲ� ���ΰ� �������� ������, �ռ� ������ ����� �������� ���Ŀ� ������ ���̺��� ���� ���´�.
-- ���� ���� ������ �ݵ�� ���� �ؾ��Ѵ�.

SELECT * FROM LOCATION ; -- LOCAL_CODE
SELECT * FROM DEPARTMENT; -- DEPT_ID, LOCATION_ID
SELECT * FROM EMPLOYEE;  -- DEPT_CODE
--ANSI ǥ�� --
--����κ��� ������ ��ĥ �� ������ ������ �� �ؼ� JOIN�ؾߵ�
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID )
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE );

-- ORACLE --
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE (DEPT_CODE = DEPT_ID) AND (LOCATION_ID = LOCAL_CODE);

-- �ǽ� 4.
-- ������ �븮�̸鼭, �ƽþ� �������� �ٹ��ϴ� ��� ��ȸ
-- ���, �����, ���޸�, �μ���, �ٹ�������, �޿�
SELECT * FROM EMPLOYEE;
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;
SELECT * FROM JOB;  -- JOBCODE J6

SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE, JOB,DEPARTMENT, LOCATION
WHERE (JOB.JOB_CODE =  EMPLOYEE.JOB_CODE AND EMPLOYEE.JOB_CODE = 'J6') 
				AND DEPARTMENT.LOCATION_ID  = LOCATION.LOCAL_CODE 
				AND (EMPLOYEE.DEPT_CODE  = DEPARTMENT.DEPT_ID AND  LOCAL_NAME LIKE 'ASIA%');

			
			
			-- ����� ���� --
-- ANSI --
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE  = J.JOB_CODE AND JOB_NAME = '�븮')
JOIN DEPARTMENT ON(DEPT_ID  = DEPT_CODE)
JOIN LOCATION ON(LOCATION_ID = LOCAL_CODE AND LOCAL_NAME LIKE 'ASIA%');
--ORACLE--
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_NAME, SALARY
FROM EMPLOYEE E, JOB J, DEPARTMENT D , LOCATION L
WHERE E.JOB_CODE = J.JOB_CODE 
			AND DEPT_CODE = DEPT_ID 
			AND LOCAL_CODE  = LOCATION_ID
			AND JOB_NAME = '�븮'
			AND LOCAL_NAME LIKE 'ASIA%';


-- �ǽ� 5
-- �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �ٹ� �������� ������ ��ȸ�Ͻÿ�
-- �����, �μ���, ������, ������
SELECT * FROM EMPLOYEE;
SELECT * FROM LOCATION;
SELECT * FROM DEPARTMENT;

--ANSI ǥ�� --
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(D.DEPT_ID = E.DEPT_CODE )
JOIN LOCATION L ON(L.LOCAL_CODE  = D.LOCATION_ID AND NATIONAL_CODE IN('KO','JP'));
--����� ���� ANSI ǥ�� --
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON(D.DEPT_ID = E.DEPT_CODE )
JOIN LOCATION L ON(L.LOCAL_CODE  = D.LOCATION_ID)
JOIN NATIONAL N ON 	(L.NATIONAL_CODE  = N.NATIONAL_CODE )
WHERE NATIONAL_NAME  IN('�ѱ�','�Ϻ�');


-- ORACLE -- 
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_CODE
FROM EMPLOYEE E, DEPARTMENT D , LOCATION L 
WHERE D.DEPT_ID = E.DEPT_CODE 
		AND L.LOCAL_CODE  = D.LOCATION_ID 
			AND L.NATIONAL_CODE IN('KO','JP');
-- ����� ���� ORACLE -- 
SELECT EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE E, DEPARTMENT D , LOCATION L , NATIONAL N
WHERE D.DEPT_ID = E.DEPT_CODE 
		AND L.LOCAL_CODE  = D.LOCATION_ID 
		AND L.NATIONAL_CODE  = N.NATIONAL_CODE 
			AND NATIONAL_NAME IN('�ѱ�','�Ϻ�');


-----------------------------
-- Sub Query --
-- �ְ� �Ǵ� ���� ���� �ȿ��� �����̳� �ϳ��� �˻��� ����
-- �ٸ� ������ �߰��ϴ� ���

-- ���� �� ��������
-- ������� 1�� ������ ��������
		
-- EX) �ּ� �޿��� �޴� ����� ���� ��ȸ
SELECT MIN(SALARY)
FROM EMPLOYEE; -- 1380000
SELECT * FROM EMPLOYEE
WHERE SALARY = 1380000;

SELECT *
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) 
										FROM EMPLOYEE);

-- ���� �� ��������
-- ��� ���� ���� �� ������ ��������

-- �� ���޺� �ּ� �޿�
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT * 
FROM EMPLOYEE
WHERE SALARY IN (SELECT MIN(SALARY) 
										FROM EMPLOYEE
											GROUP BY JOB_CODE);


-- ���� �� ���� �� ��������
-- ���� �÷��� ���� ���� ���� ���������� ����Ͽ� ����� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY) 
																	FROM EMPLOYEE
																	GROUP BY JOB_CODE);
										
-- ���� �� ���� �� ���������� �Ϲ� ���� �� �������� ����
-- EX) ����� �������� ���� ����, ���� �μ��� �ٹ��ϴ� �������� ������ ��ȸ
SELECT *
FROM EMPLOYEE
WHERE ENT_YN  = 'Y';

SELECT *
FROM EMPLOYEE
WHERE (JOB_CODE, DEPT_CODE ) IN ( SELECT JOB_CODE, DEPT_CODE 
																			FROM EMPLOYEE 
																			WHERE ENT_YN  = 'Y');
										
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE  = (SELECT DEPT_CODE 
											FROM EMPLOYEE
											WHERE ENT_YN = 'Y')
				AND JOB_CODE = (SELECT JOB_CODE 
											FROM EMPLOYEE
											WHERE ENT_YN  = 'Y')
				AND EMP_NAME  <> (SELECT EMP_NAME 
													FROM EMPLOYEE
													WHERE ENT_YN = 'Y');
				
-- ���� �� ���� �� ���������� ����
SELECT *
FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE ,JOB_CODE
																						FROM EMPLOYEE
																					WHERE ENT_YN = 'Y')
				AND EMP_NAME  <> (SELECT EMP_NAME
														FROM EMPLOYEE
														WHERE ENT_YN = 'Y');																	
										
-- ���� ������ ��� ��ġ
-- SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY, JOIN
-- DML : INSERT, UPDATE, DELETE
-- DDL : CREATE TABLE, CREATE VIEW
-- ��� ��ġ�� ��� �� �� �ִ�.

-- Inline View(�ζ��� ��)
													
					
