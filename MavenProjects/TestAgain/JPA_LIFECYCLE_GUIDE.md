# JPA Lifecycle and EntityManager Guide

## Overview
This guide explains how JPA (Jakarta Persistence API) works with Hibernate and demonstrates the complete lifecycle from reading `persistence.xml` to performing database operations.

---

## The JPA Lifecycle Steps

### 1. Read persistence.xml
**Location:** `src/main/resources/META-INF/persistence.xml`

When you call `Persistence.createEntityManagerFactory("taskPU")`, JPA:
- Searches for `persistence.xml` in the `META-INF` folder
- Reads the persistence unit named "taskPU"
- Extracts all configuration properties

**Key Configuration:**
```xml
<persistence-unit name="taskPU">
    <!-- Defines which persistence unit to use -->
</persistence-unit>
```

---

### 2. Load Provider
**Provider:** `org.hibernate.jpa.HibernatePersistenceProvider`

The provider is the JPA implementation. In this project, we use **Hibernate**.

```xml
<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
```

JPA loads Hibernate classes and prepares the ORM (Object-Relational Mapping) engine.

---

### 3. Connect to Database
**Database:** MySQL on `localhost:3306/tasks`

JPA reads the JDBC properties and establishes a connection:

```xml
<property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/tasks"/>
<property name="jakarta.persistence.jdbc.user" value="root"/>
<property name="jakarta.persistence.jdbc.password" value="admin"/>
```

**Before running:**
- Ensure MySQL is running
- Create the database: `CREATE DATABASE tasks;`

---

### 4. Register Entities
**Entities:** `Task` and `User`

JPA reads the entity classes specified in persistence.xml:

```xml
<class>org.example.Task</class>
<class>org.example.User</class>
```

It scans these classes for JPA annotations:
- `@Entity` - Marks class as a JPA entity
- `@Table` - Specifies database table name
- `@Id` - Marks the primary key field
- `@GeneratedValue` - Auto-generates ID values
- `@Column` - Maps fields to table columns
- `@ManyToOne`, `@OneToMany` - Defines relationships

---

### 5. Prepare Metadata
JPA analyzes the entity classes and builds an internal metadata model:
- Table names and column mappings
- Primary keys and foreign keys
- Relationship mappings (one-to-many, many-to-one)
- Field types and constraints
- Cascade operations

This metadata is used to:
- Generate SQL statements
- Validate entity state
- Manage relationships
- Handle transactions

---

### 6. Create EntityManagerFactory (Persistence Context Factory)
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
```

The `EntityManagerFactory` is the factory for creating `EntityManager` instances.

**Important:**
- ✅ **Thread-safe** - Can be shared across threads
- ✅ **Heavyweight** - Create once and reuse
- ✅ **Application-scoped** - One per application

**Hibernate Configuration:**
```xml
<property name="hibernate.hbm2ddl.auto" value="update"/>
```

Options:
- **update** - Updates schema, keeps existing data
- **create** - Drops and creates schema on startup
- **create-drop** - Creates on startup, drops on shutdown
- **validate** - Only validates schema, no changes
- **none** - No schema management

---

### 7. Create EntityManager
```java
EntityManager em = emf.createEntityManager();
```

The `EntityManager` is the primary interface for interacting with the persistence context.

**Important:**
- ❌ **NOT thread-safe** - Create one per thread/request
- ❌ **Lightweight** - Can create many instances
- ❌ **Request-scoped** - Create, use, and close per transaction

---

## CRUD Operations with EntityManager

### CREATE - Persist New Entities
```java
EntityTransaction transaction = em.getTransaction();
transaction.begin();

User user = new User("john_doe", "john@example.com", "John Doe");
Task task = new Task("Complete Tutorial", "Learn JPA");
user.addTask(task);

em.persist(user);  // INSERT into database

transaction.commit();
```

**Key Methods:**
- `persist(entity)` - Makes entity managed and schedules INSERT

---

### READ - Query Entities
```java
// Find by Primary Key
User user = em.find(User.class, 1L);

// JPQL Query
List<User> users = em.createQuery("SELECT u FROM User u", User.class)
                      .getResultList();

// Query with WHERE clause
List<Task> tasks = em.createQuery(
    "SELECT t FROM Task t WHERE t.completed = false", 
    Task.class
).getResultList();
```

**Key Methods:**
- `find(Class, id)` - Finds entity by primary key
- `createQuery(jpql, Class)` - Creates JPQL query
- `getResultList()` - Executes query and returns list

---

### UPDATE - Modify Entities
```java
transaction.begin();

Task task = em.find(Task.class, 1L);
task.setCompleted(true);  // JPA automatically detects change

transaction.commit();  // UPDATE executed automatically
```

**Important:** 
- No explicit `update()` call needed
- JPA tracks changes to managed entities
- Changes are flushed to database on commit

---

### DELETE - Remove Entities
```java
transaction.begin();

Task task = em.find(Task.class, 1L);
em.remove(task);  // DELETE from database

transaction.commit();
```

**Key Methods:**
- `remove(entity)` - Schedules DELETE operation

---

## Entity States

Entities can be in one of four states:

### 1. Transient (New)
```java
User user = new User("john", "john@example.com", "John");
// Not associated with EntityManager - not in database
```

### 2. Managed (Persistent)
```java
em.persist(user);  // Now managed
// Changes are tracked and synchronized with database
```

### 3. Detached
```java
em.close();  // user is now detached
// Entity exists in database but not tracked by EntityManager
```

### 4. Removed
```java
em.remove(user);  // Marked for deletion
transaction.commit();  // Actually deleted from database
```

---

## Transaction Management

### Manual Transaction Control
```java
EntityTransaction transaction = em.getTransaction();
try {
    transaction.begin();
    
    // Perform operations
    em.persist(entity);
    
    transaction.commit();
} catch (Exception e) {
    if (transaction != null && transaction.isActive()) {
        transaction.rollback();
    }
    throw e;
}
```

**Key Points:**
- Always start transaction before modifying data
- Commit to save changes
- Rollback on errors to undo changes
- READ operations don't require transactions

---

## Best Practices

### 1. Resource Management
```java
EntityManagerFactory emf = null;
EntityManager em = null;
try {
    emf = Persistence.createEntityManagerFactory("taskPU");
    em = emf.createEntityManager();
    // Use em...
} finally {
    if (em != null) em.close();
    if (emf != null) emf.close();
}
```

### 2. One EntityManagerFactory per Application
```java
// BAD - Creates multiple factories
for (int i = 0; i < 10; i++) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
}

// GOOD - Reuse one factory
EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
for (int i = 0; i < 10; i++) {
    EntityManager em = emf.createEntityManager();
    // use em...
    em.close();
}
```

### 3. Always Close Resources
Use try-with-resources (Java 7+):
```java
try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");
     EntityManager em = emf.createEntityManager()) {
    // Use em...
}  // Automatically closed
```

### 4. Handle Transactions Properly
```java
EntityTransaction tx = null;
try {
    tx = em.getTransaction();
    tx.begin();
    // Operations...
    tx.commit();
} catch (Exception e) {
    if (tx != null && tx.isActive()) {
        tx.rollback();
    }
    throw e;
}
```

---

## Relationship Mappings

### One-to-Many (User → Tasks)
```java
@Entity
public class User {
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
}
```

### Many-to-One (Task → User)
```java
@Entity
public class Task {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
```

**Key Concepts:**
- `mappedBy` - Indicates the inverse side (non-owning)
- `cascade` - Operations propagate to related entities
- `fetch` - LAZY (load on demand) or EAGER (load immediately)
- `@JoinColumn` - Specifies foreign key column

---

## Running the Application

### Prerequisites
1. **MySQL Running:** Ensure MySQL server is running on localhost:3306
2. **Database Created:** 
   ```sql
   CREATE DATABASE tasks;
   ```
3. **Dependencies:** Maven will download required libraries

### Steps
1. **Compile the project:**
   ```bash
   mvn clean compile
   ```

2. **Run the application:**
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```
   Or run `Main.java` directly from IntelliJ IDEA.

### Expected Output
The application will:
1. Create EntityManagerFactory (read persistence.xml, connect to DB)
2. Create 2 users and 3 tasks (CREATE)
3. Query and display users and tasks (READ)
4. Update a task and user (UPDATE)
5. Delete a task (DELETE)
6. Show final state
7. Close resources properly

---

## Troubleshooting

### Error: "No Persistence provider for EntityManager named taskPU"
- Check that `persistence.xml` is in `src/main/resources/META-INF/`
- Verify the persistence unit name matches: `"taskPU"`

### Error: "Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment]"
- MySQL is not running
- Database credentials are incorrect
- Database doesn't exist (create it first)

### Error: "Table doesn't exist"
- Check `hibernate.hbm2ddl.auto` is set to `update` or `create`
- Verify database permissions

### Entities not persisting
- Check you're calling `transaction.commit()`
- Verify entity has `@Entity` annotation
- Ensure entity is listed in `persistence.xml`

---

## Summary

The complete JPA lifecycle:

```
1. Persistence.createEntityManagerFactory("taskPU")
   ↓
2. Reads META-INF/persistence.xml
   ↓
3. Loads Hibernate provider
   ↓
4. Connects to MySQL database
   ↓
5. Registers Task and User entities
   ↓
6. Prepares entity metadata
   ↓
7. Creates EntityManagerFactory
   ↓
8. emf.createEntityManager()
   ↓
9. Perform CRUD operations
   ↓
10. em.close() and emf.close()
```

**Remember:** 
- EntityManagerFactory = Heavy, create once
- EntityManager = Light, create per transaction
- Always manage transactions for write operations
- Close resources in finally block

