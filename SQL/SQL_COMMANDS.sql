-- SELECT * from emp ;

-- SELECT ename, sal FROM emp WHERE ename LIKE '%S'
-- SELECT ename, hiredate FROM emp WHERE EXTRACT(YEAR FROM hiredate) = 1982;

-- SELECT ename, job, sal FROM emp WHERE job = 'ANALYST' AND sal >= 1000 AND sal <= 9999;


/*
SELECT * FROM emp WHERE TO_CHAR(hiredate, 'YYYY') > '1982' 
AND TO_CHAR(hiredate, 'YYYY') < '1987';
*/

-- SELECT * FROM emp WHERE job = 'CLERK' AND (deptno = 10 OR deptno = 30) AND ename LIKE '%A%';

-- SELECT * FROM emp WHERE EXTRACT(MONTH FROM hiredate) = 1;

-- Details of employees who works as SALESMAN and doesnt earn any commision
-- SELECT * FROM emp WHERE job = 'SALESMAN' AND (comm IS NULL OR comm = 0);

-- Select * from emp where job = 'MANAGER' and sal > 2000 and deptno in (10, 20, 30);

-- SELECT COUNT(comm) FROM emp;

-- SELECT COUNT(*) FROM emp;

-- SELECT AVG(sal) FROM emp;

/*
SELECT MAX(sal) FROM emp WHERE (DEPTNO = 20 OR DEPTNO = 30 ) 
AND (JOB = 'MANAGER' OR JOB = 'ANALYST');

*/

/*
SELECT SUM(sal) AS Total_Salary, 
COUNT(*) AS No_of_Employees FROM emp WHERE job = 'SALESMAN' 
AND comm IS NOT NULL AND comm > 0;
*/

-- groupby

/*
SELECT deptno, COUNT(*) AS emp_count, ROUND(AVG(sal), 3) AS avg_salary
FROM emp
GROUP BY deptno;
*/


-- maximum min salary of each job if emp name has A

/*
SELECT job, MAX(sal) AS max_salary, MIN(sal) AS min_salary
FROM emp
WHERE ename LIKE '%A%'
GROUP BY job;
*/

-- group by deptno and filter groups having more than 3 employees

/*
SELECT MAX(sal), deptno, COUNT(*) AS emp_count
FROM emp
GROUP BY deptno
HAVING COUNT(*) >= 3;
*/

-- total salary given to employees in each dept where no of jobs is exactly four salesman

/*
SELECT deptno, SUM(sal) AS total_salary
FROM emp
WHERE job = 'SALESMAN'
GROUP BY deptno
HAVING COUNT(*) = 4;
*/


-- Maximum salary and minimum salary given to employees in dept where maximum sal is < 1500 and greater than 2500

/*W
SELECT deptno, MAX(sal) AS max_salary, MIN(sal) AS min_salary
FROM emp
GROUP BY deptno
HAVING MAX(sal) < 1500 OR MAX(sal) > 2500;

*/

-- ORDERBY

/*
SELECT ename, job, sal FROM emp
ORDER BY job;
*/

-- SELECT table_name FROM user_tables;

/*
SELECT e.ename, e.job, d.dname, d.deptno
FROM emp e
CROSS JOIN dept d;
*/

-- SELECT * FROM EMP, DEPT WHERE EMP.DEPTNO = DEPT.DEPTNO;

/*
SELECT e.ename, d.dname, e.JOB
FROM emp e
INNER JOIN dept d ON e.deptno = d.deptno
-- query to display ename job deptname is the employee is working as analyst
 AND e.job = 'ANALYST';

 */


 -- Query to display ename salary deptname if the employee name if the emp is working in the department of accounting
SELECT e.ename, e.sal, d.dname
FROM emp e
INNER JOIN dept d ON e.deptno = d.deptno
WHERE d.dname = 'ACCOUNTING';


-- display emname deptname if employee is working in department no 20

SELECT e.ename, d.dname
FROM emp e
INNER JOIN dept d ON e.deptno = d.deptno
WHERE e.deptno = 20;

-- 