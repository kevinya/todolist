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
	public Task create(Task task) {
		em.persist(task);
		return find(task.getId());
	}

	@Transactional
	public Task update(Task task) {
		em.merge(task);
		return find(task.getId());
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
		return em.createQuery("from Task", Task.class).getResultList();
	}

	@Transactional
	public List<Task> findNotDeleted() {
		return em
				.createQuery("from Task where status < ?1", Task.class)
				.setParameter(1, 2)
				.getResultList();
	}

}
