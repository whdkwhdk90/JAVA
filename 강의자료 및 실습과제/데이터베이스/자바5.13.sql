--���� �ּ�
/* ������ �ּ� */
-- ';' : ������ ��

--SELECT�� : ��ȸ��SQL
--SELECT �÷��� : ��ȸ�ϰ��� �ϴ� ����
--FROM ���̺�� : ��ȸ�ϰ��� �ϴ� ���̺��
--[WHERE ����] : Ư�� ����
--[ORDER BY �÷�] : ����
--;

--��� ��� ��� �÷� ��ȸ
SELECT  * FROM  EMPLOYEE;

--����� ID�� �����, ����ó ��ȸ
SELECT  EMP_ID, EMP_NAME, PHONE FROM EMPLOYEE;

--����� ���̵�, �����, �̸���, ����ó, �μ���ȣ, �����ڵ带 ��ȸ

SELECT EMP_ID, EMP_NAME, EMAIL, PHONE, DEPT_CODE, JOB_CODE FROM EMPLOYEE;

--WHERE��
--���̺��� ������ �����ϴ� ���� ������ ���� ���� �����Ͽ� ��ȸ�ϴ� ������
--���� ���� ������ �����ϰ��� �� ���, AND, OR ��ɾ �Բ� ���

--�μ� �ڵ尡 D6�� ��� ������ ��� ��ȸ�ϱ�
SELECT  * FROM EMPLOYEE WHERE DEPT_CODE = 'D6';
--EMPLOYEE ���̺��� DEPT_CODE�� D6�� ����� ��� �÷��� ��ȸ�ϰڴ�.

--����1.
--������ 'J1'�� ����� ���, �����, �����ڵ�, �μ��ڵ带 ��ȸ�Ͻÿ�
SELECT  EMP_NO, EMP_NAME, JOB_CODE, DEPT_CODE FROM EMPLOYEE WHERE JOB_CODE = 'J1';

--����2.
--�޿��� 300���� �̻��� ����� ID, �����, �����ڵ�, �޿��� ��ȸ�Ͻÿ�
SELECT  EMP_ID, EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE SALARY >= 3000000;

