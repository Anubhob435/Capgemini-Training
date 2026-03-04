package org.example;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDAO implements TaskDAD {

    private EntityManagerFactory emf;
    private EntityManager em;

    public TaskDAO() {
        this.emf = Persistence.createEntityManagerFactory("taskPU");
        this.em = emf.createEntityManager();
    }

    // CREATE
    @Override
    public TaskDTO create(Task task) {
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
            System.out.println("Task successfully created with id: " + task.getId());
            return convertToDTO(task);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    // READ BY ID
    @Override
    public TaskDTO findById(Long id) {
        Task task = em.find(Task.class, id);
        if (task != null) {
            return convertToDTO(task);
        }
        return null;
    }

    // READ ALL
    @Override
    public List<TaskDTO> findAll() {
        List<Task> tasks = em.createQuery("SELECT t FROM Task t", Task.class)
                .getResultList();

        return tasks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // UPDATE
    @Override
    public TaskDTO update(Task task) {
        try {
            em.getTransaction().begin();
            Task updatedTask = em.merge(task);
            em.getTransaction().commit();
            return convertToDTO(updatedTask);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        }
    }

    // DELETE
    @Override
    public void delete(Long id) {
        try {
            em.getTransaction().begin();
            Task task = em.find(Task.class, id);
            if (task != null) {
                em.remove(task);
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    // CLOSE CONNECTIONS
    @Override
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    // CONVERT ENTITY → DTO
    private TaskDTO convertToDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTask(),
                task.getDescription()
        );
    }
}