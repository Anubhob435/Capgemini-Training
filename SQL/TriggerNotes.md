# SQL Triggers - Detailed Notes

## Definition
A trigger is a stored procedure in a database that automatically executes in response to certain events on a particular table or view. In Oracle, triggers are associated with tables or views and fire when specific DML (Data Manipulation Language) statements (INSERT, UPDATE, DELETE) occur.

## Purpose
- Enforce business rules automatically
- Maintain audit trails
- Validate input data
- Synchronize data across tables
- Implement complex security mechanisms

## Types of Triggers in Oracle 10g

### 1. DML Triggers
- Execute when DML operations occur (INSERT, UPDATE, DELETE)
- Can be row-level or statement-level triggers

### 2. System Event Triggers
- Execute in response to system events (STARTUP, SHUTDOWN, LOGON, LOGOFF)

### 3. User Event Triggers
- Execute in response to user events (CREATE, ALTER, DROP)

## Trigger Components

### Trigger Timing
- **BEFORE**: Executes before the triggering event occurs
- **AFTER**: Executes after the triggering event occurs

### Trigger Level
- **FOR EACH ROW**: Row-level trigger - fires once for each affected row
- **FOR EACH STATEMENT**: Statement-level trigger - fires once for the entire statement (default)

### Triggering Events
- INSERT
- UPDATE [OF column_name]
- DELETE

## Syntax
```sql
CREATE [OR REPLACE] TRIGGER trigger_name
  {BEFORE | AFTER}
  {INSERT [OF column_name] | UPDATE [OF column_name] | DELETE}
  ON table_name
  [FOR EACH ROW]
  [WHEN condition]
DECLARE
  -- Declaration section
BEGIN
  -- Trigger body
EXCEPTION
  -- Exception handling
END;
```

## Example Triggers for Oracle 10g

### 1. Simple Row-Level Trigger
```sql
CREATE OR REPLACE TRIGGER emp_audit_trigger
  BEFORE INSERT OR UPDATE OR DELETE ON employees
  FOR EACH ROW
BEGIN
  IF INSERTING THEN
    DBMS_OUTPUT.PUT_LINE('New employee added');
  ELSIF UPDATING THEN
    DBMS_OUTPUT.PUT_LINE('Employee data updated');
  ELSIF DELETING THEN
    DBMS_OUTPUT.PUT_LINE('Employee deleted');
  END IF;
END;
```

### 2. Audit Trail Trigger
```sql
CREATE TABLE emp_audit (
  id NUMBER,
  emp_id NUMBER,
  action VARCHAR2(10),
  action_date DATE,
  old_salary NUMBER,
  new_salary NUMBER
);

CREATE OR REPLACE TRIGGER emp_change_audit
  AFTER INSERT OR UPDATE OR DELETE ON employees
  FOR EACH ROW
BEGIN
  IF INSERTING THEN
    INSERT INTO emp_audit VALUES (
      emp_audit_seq.NEXTVAL,
      :NEW.employee_id,
      'INSERT',
      SYSDATE,
      NULL,
      :NEW.salary
    );
  ELSIF UPDATING THEN
    INSERT INTO emp_audit VALUES (
      emp_audit_seq.NEXTVAL,
      :NEW.employee_id,
      'UPDATE',
      SYSDATE,
      :OLD.salary,
      :NEW.salary
    );
  ELSIF DELETING THEN
    INSERT INTO emp_audit VALUES (
      emp_audit_seq.NEXTVAL,
      :OLD.employee_id,
      'DELETE',
      SYSDATE,
      :OLD.salary,
      NULL
    );
  END IF;
END;
```

### 3. Validation Trigger
```sql
CREATE OR REPLACE TRIGGER salary_validation
  BEFORE INSERT OR UPDATE ON employees
  FOR EACH ROW
WHEN (NEW.salary < 0)
BEGIN
  RAISE_APPLICATION_ERROR(-20001, 'Salary cannot be negative');
END;
```

## Pseudo-Variables in Triggers

### :NEW and :OLD
- **:NEW**: Contains the new values for INSERT and UPDATE operations
- **:OLD**: Contains the old values for UPDATE and DELETE operations
- These are not available in statement-level triggers

### :INSERTING, :UPDATING, :DELETING
- Boolean variables to check which operation triggered the trigger
- Useful in triggers that handle multiple operations

## Restrictions in Triggers

### Limitations in Row-Level Triggers
- Cannot execute transaction control statements (COMMIT, ROLLBACK, SAVEPOINT)
- Cannot execute DDL statements (CREATE, DROP, ALTER)
- Cannot execute SELECT FOR UPDATE

### Mutating Table Problem
- Occurs when a row-level trigger attempts to query or modify the table it is firing from
- Oracle raises ORA-04091 error
- Solution: Use statement-level triggers or compound triggers

## Managing Triggers

### Enable/Disable Triggers
```sql
ALTER TRIGGER trigger_name ENABLE;
ALTER TRIGGER trigger_name DISABLE;
ALTER TABLE table_name DISABLE ALL TRIGGERS;
ALTER TABLE table_name ENABLE ALL TRIGGERS;
```

### Drop Trigger
```sql
DROP TRIGGER trigger_name;
```

### View Trigger Information
```sql
SELECT trigger_name, trigger_type, triggering_event, table_name
FROM USER_TRIGGERS
WHERE table_name = 'EMPLOYEES';
```

## Best Practices for Oracle 10g

1. Keep triggers simple and efficient
2. Avoid recursive triggering
3. Use triggers for data integrity, not business logic
4. Document triggers well
5. Test thoroughly, especially for cascading effects
6. Be cautious with triggers that modify the same table
7. Monitor performance impact of triggers

## Common Issues and Solutions

### 1. Performance Impact
- Triggers can slow down DML operations
- Solution: Optimize trigger code and minimize operations

### 2. Debugging Challenges
- Triggers execute implicitly
- Solution: Use logging and exception handling

### 3. Maintenance Complexity
- Triggers can make database behavior harder to predict
- Solution: Proper documentation and clear naming conventions

## Oracle 10g Specific Considerations

- Limited support for compound triggers (introduced in Oracle 10g)
- Basic trigger functionality is robust but lacks advanced features of later versions
- Pay attention to shared pool memory usage with many triggers
- Use DBMS_OUTPUT for debugging in development environments