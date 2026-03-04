package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Demonstration of JPA Lifecycle:
 * 1. Read persistence.xml
 * 2. Load provider (Hibernate)
 * 3. Connect to database
 * 4. Register entities
 * 5. Prepare metadata
 * 6. Create EntityManagerFactory (Persistence Context Factory)
 * 7. Create EntityManager
 * 8. Perform CRUD operations
 */
public class Main {
    public static void main(String[] args) {
        // ============================================
        // STEP 1-6: Create EntityManagerFactory
        // ============================================
        // This reads persistence.xml, loads the provider (Hibernate),
        // connects to the database, registers entities (Task, User),
        // prepares metadata, and creates the persistence context factory

        System.out.println("=== Creating EntityManagerFactory ===");
        System.out.println("This process:");
        System.out.println("1. Reads persistence.xml from META-INF folder");
        System.out.println("2. Loads the JPA provider (Hibernate)");
        System.out.println("3. Connects to MySQL database at localhost:3306/tasks");
        System.out.println("4. Registers entities: Task and User");
        System.out.println("5. Prepares entity metadata and mappings");
        System.out.println("6. Creates the EntityManagerFactory (Persistence Context Factory)");
        System.out.println();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("taskPU");

        System.out.println("✓ EntityManagerFactory created successfully!\n");

        // ============================================
        // STEP 7: Create EntityManager
        // ============================================
        // EntityManager is the interface to interact with the persistence context
        // and perform database operations

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // ============================================
            // CREATE Operations
            // ============================================
            System.out.println("=== CREATE Operations ===");
            transaction = em.getTransaction();
            transaction.begin();

            // Create a new User
            User user1 = new User("john_doe", "john@example.com", "John Doe");
            User user2 = new User("jane_smith", "jane@example.com", "Jane Smith");

            // Create new Tasks
            Task task1 = new Task("Complete JPA Tutorial", "Learn about EntityManager and persistence.xml");
            Task task2 = new Task("Build REST API", "Create a REST API using Spring Boot", LocalDateTime.now().plusDays(7));
            Task task3 = new Task("Database Design", "Design database schema for the project");

            // Associate tasks with users
            user1.addTask(task1);
            user1.addTask(task2);
            user2.addTask(task3);

            // Persist entities to database
            em.persist(user1);
            em.persist(user2);

            transaction.commit();
            System.out.println("✓ Created 2 users and 3 tasks\n");

            // ============================================
            // READ Operations
            // ============================================
            System.out.println("=== READ Operations ===");

            // Find by ID
            User foundUser = em.find(User.class, user1.getId());
            System.out.println("Found user: " + foundUser);
            System.out.println("User's tasks:");
            for (Task task : foundUser.getTasks()) {
                System.out.println("  - " + task);
            }
            System.out.println();

            // Query all users
            List<User> allUsers = em.createQuery("SELECT u FROM User u", User.class).getResultList();
            System.out.println("All users in database:");
            for (User user : allUsers) {
                System.out.println("  " + user);
            }
            System.out.println();

            // Query incomplete tasks
            List<Task> incompleteTasks = em.createQuery(
                "SELECT t FROM Task t WHERE t.completed = false", Task.class
            ).getResultList();
            System.out.println("Incomplete tasks:");
            for (Task task : incompleteTasks) {
                System.out.println("  " + task);
            }
            System.out.println();

            // ============================================
            // UPDATE Operations
            // ============================================
            System.out.println("=== UPDATE Operations ===");
            transaction = em.getTransaction();
            transaction.begin();

            // Update a task
            Task taskToUpdate = em.find(Task.class, task1.getId());
            taskToUpdate.setCompleted(true);
            System.out.println("✓ Marked task as completed: " + taskToUpdate.getTitle());

            // Update user
            User userToUpdate = em.find(User.class, user1.getId());
            userToUpdate.setFullName("John Michael Doe");
            System.out.println("✓ Updated user's full name to: " + userToUpdate.getFullName());

            transaction.commit();
            System.out.println();

            // ============================================
            // DELETE Operations
            // ============================================
            System.out.println("=== DELETE Operations ===");
            transaction = em.getTransaction();
            transaction.begin();

            // Remove a task
            Task taskToDelete = em.find(Task.class, task3.getId());
            User taskOwner = taskToDelete.getUser();
            if (taskOwner != null) {
                taskOwner.removeTask(taskToDelete);
            }
            em.remove(taskToDelete);
            System.out.println("✓ Deleted task: " + taskToDelete.getTitle());

            transaction.commit();
            System.out.println();

            // ============================================
            // Verify Changes
            // ============================================
            System.out.println("=== Final State ===");
            List<Task> remainingTasks = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
            System.out.println("Remaining tasks in database: " + remainingTasks.size());
            for (Task task : remainingTasks) {
                System.out.println("  " + task);
            }

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
                System.err.println("✗ Transaction rolled back due to error");
            }
            e.printStackTrace();
        } finally {
            // ============================================
            // CLEANUP: Close resources
            // ============================================
            System.out.println("\n=== Closing Resources ===");
            em.close();
            System.out.println("✓ EntityManager closed");
            emf.close();
            System.out.println("✓ EntityManagerFactory closed");
            System.out.println("\nJPA lifecycle demonstration completed!");
        }
    }
}

