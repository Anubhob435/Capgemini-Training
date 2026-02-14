-- Triggers

CREATE OR REPLACE TRIGGER UEM1
BEFORE UPDATE ON EMP
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('EMP TABLE IS UPDATED');
END UEM1;
/


update emp 
set comm = 100 
where comm >=0;


CREATE OR REPLACE TRIGGER UEM2
BEFORE
CREATE ON SCOTT.SCHEMA
BEGIN
DBMS_OUTPUT.PUT_LINE('A NEW TABLE IS CREATED IN SCOTT SCHEMA');
END ;
/

CREATE TABLE E2 (
    EMP_ID NUMBER PRIMARY KEY,
    EMP_NAME VARCHAR2(50),
    DEPARTMENT VARCHAR2(30),
    SALARY NUMBER(10,2),
    HIRE_DATE DATE
);

INSERT INTO EMPLOYEES VALUES (1, 'John Smith', 'Sales', 50000, TO_DATE('2020-01-15', 'YYYY-MM-DD'));
INSERT INTO EMPLOYEES VALUES (2, 'Sarah Johnson', 'IT', 65000, TO_DATE('2019-06-20', 'YYYY-MM-DD'));
INSERT INTO EMPLOYEES VALUES (3, 'Mike Davis', 'HR', 55000, TO_DATE('2021-03-10', 'YYYY-MM-DD'));
INSERT INTO EMPLOYEES VALUES (4, 'Emma Wilson', 'Finance', 72000, TO_DATE('2018-11-05', 'YYYY-MM-DD'));
INSERT INTO EMPLOYEES VALUES (5, 'David Brown', 'Operations', 48000, TO_DATE('2022-02-28', 'YYYY-MM-DD'));

COMMIT;

-- NOTE: To see DBMS_OUTPUT in SQL*Plus/SQL Developer run:
-- SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER uem2
BEFORE CREATE ON SCHEMA
BEGIN
  DBMS_OUTPUT.PUT_LINE('A NEW OBJECT IS CREATED IN THIS SCHEMA');
END uem2;
/


SELECT table_name FROM user_tables;

select * from EMPLOYEES;

DROP TABLE E2;

-- Trigger to check phone number digits

-- Ensure EMPLOYEES has PHONE column (add only if missing)
DECLARE
  v_cnt NUMBER;
BEGIN
  SELECT COUNT(*)
  INTO v_cnt
  FROM user_tab_cols
  WHERE table_name = 'EMPLOYEES'
    AND column_name = 'PHONE';

  IF v_cnt = 0 THEN
    EXECUTE IMMEDIATE 'ALTER TABLE EMPLOYEES ADD (PHONE VARCHAR2(20))';
  END IF;
END;
/

CREATE OR REPLACE TRIGGER check_phone_digits
BEFORE INSERT OR UPDATE ON employees
FOR EACH ROW
BEGIN
  IF LENGTH(REGEXP_REPLACE(:NEW.phone, '[^0-9]', '')) < 10 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Phone number must contain at least 10 digits');
  END IF;

  DBMS_OUTPUT.PUT_LINE(
    'Phone number contains ' ||
    LENGTH(REGEXP_REPLACE(:NEW.phone, '[^0-9]', '')) ||
    ' digits'
  );
END;
/

SHOW ERRORS TRIGGER check_phone_digits;

INSERT INTO EMPLOYEES (EMP_ID, EMP_NAME, DEPARTMENT, SALARY, HIRE_DATE, phone)
VALUES (6, 'Lisa Anderson', 'Marketing', 60000, DATE '2023-01-10', '555-123-4567');

-- see all triggers in the current schema
SELECT trigger_name, trigger_type, triggering_event, table_name, status
FROM user_triggers
ORDER BY trigger_name;



