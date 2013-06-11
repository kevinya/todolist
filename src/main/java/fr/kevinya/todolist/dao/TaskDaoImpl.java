package fr.kevinya.todolist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.kevinya.todolist.model.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

    @PersistenceContext
    EntityManager em;
    
	@Transactional
	public void create(Task task) {
		em.persist(task);
	}

	@Transactional
	public void update(Task task) {
		em.merge(task);
	}

	@Transactional
	public void delete(Task task) {
		em.remove(task);
	}

	@Transactional
	public Task find(Integer id) {
		return em.find(Task.class, id);
	}

	@Transactional
	public List<Task> findAll() {
		return em.createQuery("from Task").getResultList();
	}

	@Transactional
	public List<Task> findNotDeleted() {
		return em.createQuery("from Task where status < 2").getResultList();
	}

}
