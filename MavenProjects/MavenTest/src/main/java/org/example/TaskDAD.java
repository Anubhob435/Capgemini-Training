package org.example;

import java.util.List;

/**
 * TaskDAD - Task Data Access Definition
 * Interface defining the contract for Task data access operations
 */
public interface TaskDAD {

    /**
     * Create a new task in the database
     * @param task The task entity to create
     * @return TaskDTO representing the created task
     */
    TaskDTO create(Task task);

    /**
     * Find a task by its ID
     * @param id The ID of the task to find
     * @return TaskDTO if found, null otherwise
     */
    TaskDTO findById(Long id);

    /**
     * Retrieve all tasks from the database
     * @return List of all tasks as TaskDTOs
     */
    List<TaskDTO> findAll();

    /**
     * Update an existing task
     * @param task The task entity with updated information
     * @return TaskDTO representing the updated task
     */
    TaskDTO update(Task task);

    /**
     * Delete a task by its ID
     * @param id The ID of the task to delete
     */
    void delete(Long id);

    /**
     * Close and cleanup resources (EntityManager, EntityManagerFactory)
     */
    void close();
}
