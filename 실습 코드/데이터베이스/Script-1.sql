SELECT * FROM EMPLOYEE;

--EMPLOYEE 테이블 형태
DESC EMPLOYEE;

--CRUD : 데이터 처리 로직
-- CREATE : 데이터 추가 / INSERT
-- READ   : 데이터 조회 / SELECT
-- UPDATE : 데이터 수정 / UPDATE
-- DELETE : 데이터 삭제 / DELETE

-- 기본 형태 연습1
-- EMPLOYEE 테이블에서 모든 사원의 사원명, 이메일, 연락처, 입사일 조회하기
-- EMP_NAME, EMAIL, PHONE, HIRE_DATE
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE FROM EMPLOYEE;

-- 기본 형태 연습2
-- 부서코드가 D6인 부서의 모든 직원 정보 조회하기
-- DEPT_CODE
SELECT * FROM EMPLOYEE WHERE DEPT_CODE = 'D6';

-- 조건을 2개 이상 붙일 경우( AND, OR)
-- 부서코드가 D6이면서 이름이 '유재식'인 사원의 모든 정보 조회하기
SELECT * FROM EMPLOYEE WHERE DEPT_CODE ='D6' AND EMP_NAME ='유재식';

-- 컬럼 명에 별칭 달기
-- 1. AS(alias) 표현
SELECT EMP_ID AS "사원 번호", EMP_NAME AS "사원명" FROM EMPLOYEE;

-- 2. AS 생략
-- 별칭에 ()나 띄어쓰기 같은 문자가 들어갈 경우 반드시 " "로 구분 지어야 한다.
-- (붙여있는 단어는 " " 없이 쓸수 있지만 "사번 임" 이런식으로 쓰려면 " "이 꼭 필요)
SELECT EMP_ID 사번, EMP_NAME 사원명 FROM EMPLOYEE;

-- 실습문제 1
-- EMPLOYEE 테이블에서 사원 번호가 205번인 사원의 사원명, 이메일, 급여, 입사일지를 조회하시오
-- (단, 조회하는 컬럼명에 별칭 부여)
-- EMP_NAME, EMAIL, SALARY, HIRE_DATE
SELECT EMP_NAME 사원명, EMAIL 이메일, SALARY 급여, HIRE_DATE 입사일지 FROM EMPLOYEE WHERE EMP_ID = 205;

-- 컬럼 값을 사용하여 계산식 적용
-- 컬럼 값이 만약 null이라면 어떤 연산을 처리하여도 결과는 NULL
SELECT  EMP_NAME "사원명", (SALARY *12 ) "연봉", BONUS "보너스", (SALARY + (SALARY*BONUS))*12 "연봉총합" FROM EMPLOYEE;

-- NVL() : 만약 현재 조회한 값이 NULL인 경우 별도로 설정한 값으로 변경
-- NVL(컬럼명, 기본값)
SELECT EMP_NAME 사원명, (SALARY *12) 연봉, BONUS 보너스, (SALARY+ (SALARY*NVL(BONUS,0)))  연봉총합 FROM EMPLOYEE;

--  컬럼에 일반값 사용
SELECT EMP_NAME, SALARY*12, '원' 단위 FROM EMPLOYEE;

-- DISTINCT : 중복 제거
-- 해당하는 값이 컬럼에 여러개 존재 할 경우 중복을 제거하고 한 개만 조회(NULL도 포함)
SELECT DEPT_CODE FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE FROM EMPLOYEE;

-- 실습 2
-- DEPARTMENT 테이블을 참조하여, 부서가 '해외영업2부' 부서의 부서코드를 찾고
-- EMPLOYEE 테이블에서 해당 부서의 사원들 중 급여를 200만원보다 많이 받는 직원의
-- 사번, 사원명, 급여를 조회
-- 1) '해외영업2부' 부서의 코드찾기
SELECT * FROM DEPARTMENT WHERE DEPT_TITLE = '해외영업2부';
-- 2) 조회한 부서코드를 사용하여 사원들 중 급여를 200만원보다 많이 받는 직원조회

SELECT EMP_ID 사번, EMP_NAME 사원명, SALARY 급여 FROM EMPLOYEE WHERE DEPT_CODE  = 'D6' AND SALARY  > 2000000;

-- 연산자 -- 

-- 연결 연산자 
--  '||' : 여러 컬럼의 결과나 값을 하나의 컬럼으로 묶을 때 사용
-- EX) '사번'을 가진 사원의 이름은 'O O O' 입니다.
SELECT EMP_ID || '을 가진 사원의 이름은' || EMP_NAME || '입니다.' FROM EMPLOYEE;

-- 비교 연산자
-- <, >, <=, >= : 크기를 나타내는 부등호
-- = : 같다
-- !=, ^=, <> : 같지 않다

-- EMPLOYEE에서 부서코드가 D9이 아닌 직원들의 모든 정보 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE != 'D9';

-- EMPLOYEE에서 급여가 350만원 이상 550만원 이하인 직원 사번, 사원명, 부서코드, 직급코드, 급여정보를 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY FROM EMPLOYEE WHERE SALARY >= 3500000 AND SALARY  <= 5500000;

-- ORDER BY SALARY ASC; -- 오름차순
-- ORDER BY SALARY DESC; -- 내림차순

-- BETWEEN A AND B
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY FROM EMPLOYEE WHERE SALARY BETWEEN 3500000 AND 5500000;

-- 위와 똑같은 직원 정보를 조회하는데 350만원 미만, 550만원 초과인 직원 정보를 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY FROM EMPLOYEE WHERE SALARY NOT BETWEEN 3500000 AND 5500000;

-- LIKE : 입력한 숫자, 문자가 포함된 정보를 조회
-- '_' =  임의의 한 문자
-- '%' = 몇자리 문자든 관계없음(앞 혹은 뒤에 몇글자가 있든 상관없이 조회)

-- EMPLOYEE에서 사원의 이름 가운데 '중'이 들어가는 사원 정보 조회
SELECT * FROM EMPLOYEE WHERE EMP_NAME  LIKE '_중_';

-- EMPLOYEE 테이블에서 주민등록번호 기준 남성인 사원의 정보만 조회
SELECT * FROM EMPLOYEE WHERE EMP_NO LIKE '%-1%'; --    ==   ______-1% == ______-1______

--사원 중 이메일 아이디가 5글자를 초과하는 사원의 사원명, 사번, 이메일 정보를 조회
SELECT EMP_NAME, EMP_ID, EMAIL FROM EMPLOYEE  WHERE EMAIL NOT LIKE   '_____@%'; -- 이렇게하면 5자리가 아닌 4,3,2,1 자리도 다 출력
SELECT EMP_NAME, EMP_ID, EMAIL FROM EMPLOYEE  WHERE EMAIL LIKE  '______%@%'; -- 이렇게쓰는게 맞습니다요

-- EMPLOYEE 테이블에서 '이'씨 성을 가진 직원 모두 조회하기
SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE '이%';

-- 사원 중 이메일 4번째 자리가 '_'인 사원의 정보 조회 -- '_'를 문자 그대로 쓰고 싶을 때
SELECT  EMP_ID , EMP_NAME , EMAIL FROM EMPLOYEE WHERE EMAIL LIKE '___#_%@%' ESCAPE '#';

-- IN 연산자 
-- IN(값1, 값2, 값3, ...)
-- 안에 있는 값들 중 하나라도 일치 하는 경우 해당하는 값을 조회

-- 부서코드가 D1, D6인 부서의 직원 정보를 조회
-- DEPT_CODE = 'D1' OR DEPT_CODE = 'D6' (기존의 방식으로 작성)
SELECT * FROM EMPLOYEE WHERE DEPT_CODE IN('D1','D6'); -- D1이거나 D6이거나 할 때 조회

-- 부서코드가 D1도 D6도 아닌 부서의 직원을 조회
SELECT * FROM EMPLOYEE WHERE DEPT_CODE NOT IN('D1','D6');

-- 연산자의 우선 순위
-- 0. ( ) 괄호
-- 1. 산술 연산자(+,-,*,/);
-- 2. 연결 연산자
-- 3. 비교 연산자
-- 4. IS NULL // IS NOT NULL / LIKE, IN / NOT IN
-- 5. BETWEEN A AND B
-- 6. NOT
-- 7. AND
-- 8. OR


-- 종합 실습 문제1
-- 직급이 'J2' 이면서 200만원 이상 받는 직원 이거나, 직급이 'J7'인 사원의 사번, 사원명, 직급코드, 급여 정보 조회
-- 직급코드 : JOB_CODE, 사번 : EMP_ID, 급여 : SALARY
SELECT  EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE  (JOB_CODE  = 'J2' AND SALARY  >= 2000000) OR JOB_CODE  = 'J7';

-- 종합 실습 문제2
-- 직급이 'J7' 이거나 'J2'이면서 급여를 200만원 이상 받는 직원의 사번, 사원명, 직급코드, 급여를 조회
-- 직급이 J7이거나 J2 의 조건을 포함하고 급여가 200만원 이상 받는 직원 의 사번, 사원명, 직급코드, 급여를 조회
SELECT  EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE (JOB_CODE  = 'J7' OR JOB_CODE = 'J2') AND SALARY  >= 2000000;


-- 함수(FUNCTION) --

-- 문자 관련 함수
-- LENGTH : 문자열의 길이를 계산하는 함수
-- DUAL(임시테이블(가상의 테이블)) : SELECT문에서 리터럴을 활용한 계산식을 테스트 하고자 할 때 사용하는 임시 테이블
-- LENGTHB : BYTE를 재는 단위(영어는 1BYTE, 한글은 3BYTE)
SELECT LENGTH('Hello'), LENGTHB('Hello') FROM DUAL;
SELECT LENGTH('이창진'), LENGTHB('이창진') FROM DUAL;

-- INSTR : 주어진 값에서 원하는 문자가 몇번째인지 찾아 반환하는 함수 -> INSTR('문자열', '찾을 문자')
SELECT INSTR ('ABCDE', 'A') FROM DUAL;
SELECT INSTR ('ABCDE', 'C') FROM DUAL;
SELECT INSTR ('ABCDE', 'Z') FROM DUAL;  -- 없는 문자를 찾으려할 땐 0을 반환

-- SUBSTR(컬럼명 | 값, 시작순번[, 가져올 갯수])
-- 주어진 문자열에서 특정 부분만 꺼내오는 함수

SELECT 'Hello World', SUBSTR('Hello World', 7) FROM DUAL; 
SELECT 'Hello World', SUBSTR('Hello World', 1,5) FROM DUAL; 

-- 실습 3
-- EMPLOYEE 테이블에서 사원의 이름, 이메일 조회
-- 이메일은 아이디부분만 조회하기
-- 조회결과 --
-- 홍길동 hong_gd

-- 1. 이름과 이메일 조회
SELECT  EMP_NAME, EMAIL FROM EMPLOYEE;

-- 2. @위치 찾기
SELECT INSTR(EMAIL, '@') FROM EMPLOYEE;

-- 3. SUBSTR 활용
SELECT  EMP_NAME, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1 ) FROM EMPLOYEE;

-- LPAD / RPAD  : 빈칸을 지정한 문자로 채워줌 (LPAD는 왼쪽부터 빈칸으로 여기고 채움. RPAD는 오른쪽부터 채움)
-- LPAD (대상, 크기, '바꿀문자') -- RPAD (대상, 크기, '바꿀문자')
SELECT LPAD(EMAIL, 20, '#') FROM EMPLOYEE;
SELECT RPAD(EMAIL, 20, '-') FROM EMPLOYEE;

-- LTRIM / RTRIM
-- 현재 부여된 컬럼 값이나, 특정 값으로 부터 특정 문자를 찾아 지워주는 함수
-- 찾을 문자를 지정하지 않으면 빈칸을 지운다.
-- LTRIM은 왼쪽에 있는 것만 지움, RTRIM은 오른쪽에 있는 것만 지움
SELECT LTRIM('             Hello') FROM DUAL;
SELECT RTRIM('Hello             ') FROM DUAL;
SELECT RTRIM('             HI') FROM DUAL;

SELECT  LTRIM('012345','0') FROM DUAL;
SELECT  LTRIM('012345','1') FROM DUAL;
SELECT  LTRIM('111234', '1') FROM DUAL;   -- 처음 닿는 숫자가 삭제할 숫자랑 맞으면 지우는 듯?

-- TRIM : 주어진 문자열에서 양끝을 기준으로 특정문자를 지워주는 함수
-- 기본형태 (지우고자 하는 문자가 없을 때 공백제거)
SELECT TRIM('      내일 비옴      ') FROM DUAL;

-- 양끝의 특정값을 지우고자 할 때
-- TRIM('지울 문자' FROM '문자열')
SELECT TRIM('0' FROM '00012300') FROM DUAL;


-- 밑 3개는 잘 안씀(왜냐하면 LTRIM, RTRIM, TRIM을 쓰면되니까)
-- 마치 LTRIM과 같다
SELECT TRIM (LEADING '0' FROM '00012300') FROM DUAL;

-- 마치 RTRIM과 같다
SELECT TRIM (TRAILING '0' FROM '00012300') FROM DUAL;

-- 마치 TRIM과 같다
SELECT TRIM(BOTH '0' FROM '00012300') FROM DUAL;


-- LOWER / UPPER / INITCAP : 주어진 문자열을 각각 소문자 / 대문자 / 첫글자만 대문자로 변경해주는 함수
SELECT LOWER('NICE TO MEET YOU'),
				 UPPER('nice to meet you'),
				   INITCAP('nice to meet you')
FROM DUAL;

-- CONCAT : 여러 문자열을 하나의 문자열로 합치는 함수
-- CONCAT('문자열', '문자열')
SELECT CONCAT('오라클', ' 너무 재밌어요^^;;;') 
FROM DUAL;
SELECT '오라클' || ' 재미져요 :) ' 
FROM DUAL;

-- REPLACE : 주어진 값에서 특정 문자를 변경할 때 사용하는 함수
-- REPLACE('문자열', '바꿀 문자열', '바뀔 문자열')
SELECT REPLACE('HELLO WORLD', 'HELLO' , 'BYE' ) 
FROM DUAL;

-- 실습 4
-- EMPLOYEE 테이블에서 사원의 주민번호를 확인하여 생년 월일을 각각 조회하시오.
-- 이름 | 생년 | 생월 | 생일

SELECT EMP_NAME "이름", 
			   CONCAT(SUBSTR(EMP_NO ,1,2),'년 ') "생년",
			   CONCAT(SUBSTR(EMP_NO ,3,2),'월 ') "생월", 
			   CONCAT(SUBSTR(EMP_NO ,5,2),'일')  "생일" 
FROM EMPLOYEE;

--SUBSTR을 활용하면 날짜 데이터도 나눌 수 있다.
--- '19/03/15' --> 19     /       03           /            15 
-- 날짜는 년도 4자리 중 뒤에 2자리를 기준으로 가져옴
SELECT EMP_NAME 이름,
			CONCAT(SUBSTR(HIRE_DATE, 1, 2), '년') "입사년도"
FROM EMPLOYEE;

-- 단일 행 함수(Single Row Function) : 결과를 찾아서 출력할 때마다 각행에 함수가 적용

-- 다중 행 함수(Multiple Row Function) : 조건절에 만족하는 모든 행을 다 찾고 나서 한번에 연산

-- 그룹 함수(Group Function)
-- SUM( ), AVG( ), MAX( ), MIN( ), COUNT( )

-- SUM() : 해당 컬럼들의 합계
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- AVG() : 해당 컬럼들의 평균을 계산
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- MAX() / MIN() : 해당 컬럼들의 값 중 최댓값 / 최솟값
SELECT  MAX(SALARY),
				MIN(SALARY)
FROM EMPLOYEE;


-- 실습 5 --
-- EMPLOYEE 테이블에서 '해외영업1부'에 근무하는 모든 사원의 평균 급여, 가장 높은 급여, 가장 낮은 급여, 급여합계 조회

SELECT * 
FROM DEPARTMENT
WHERE DEPT_TITLE = '해외영업1부';

SELECT AVG(SALARY ),
				SUM(SALARY),
				MAX(SALARY),
				MIN(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE  = 'D5';

-- COUNT() : 해당하는 행의 갯수
SELECT COUNT(*)
FROM EMPLOYEE;

-- NULL값이 존재할 경우 이를 계산하지 않는다.
SELECT COUNT(*),
			COUNT(DEPT_CODE), 
			COUNT(DISTINCT DEPT_CODE )   -- 실제로는 7이 나오지만 COUNT가 NULL을 계산하지 않음
FROM EMPLOYEE;

SELECT DEPT_CODE
FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

--- 실습 6.
-- EMPLOYEE 테이블에서 모든 사원의 사번, 사원명, 이메일, 주민번호를 조회하여 사원 목록표를 만들고자 한다.
-- 이때, 이메일은 '@' 전까지, 주민번호는 7번째자리 이후 '*'로 처리하여 조회하시오.
-- EMP_ID, EMP_NAME, EMAIL, EMP_NO

SELECT EMP_ID  사번, 
				EMP_NAME 사원명,  
				SUBSTR(EMAIL,1,INSTR(EMAIL, '@') -1)이메일,
				RPAD(SUBSTR(EMP_NO, 1, 8),14 , '*') 주민번호
FROM EMPLOYEE
ORDER BY 2;  -- 사원명 기준으로 정렬(즉, 2번째 테이블을 기준으로 정렬) . 1번으로 정렬하면 사번 .... 등등)

-- 실습 7.
-- EMPLOYEE 테이블에서 현재 근무하는 여성 사원의 사번, 사원명, 직급코드를 조회 하시오.
-- ** ENT_YN : 현재 근무 여부 파악하는 컬럼(퇴사 여부)

SELECT EMP_ID 사번,
				EMP_NAME 사원명,
				JOB_CODE 직급코드
FROM EMPLOYEE
WHERE ENT_YN  = 'N' AND (EMP_NO LIKE '%-2%');
-- 강사님 버전. WHERE SUBSTR(EMP_NO ,8 ,1 ) = '2'    ( 주민 뒷자리 첫번째 숫자가 2인 경우)










