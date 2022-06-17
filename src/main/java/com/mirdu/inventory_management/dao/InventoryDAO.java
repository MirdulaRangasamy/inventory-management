package com.mirdu.inventory_management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mirdu.inventory_management.entity.Inventory;

public class InventoryDAO {
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public boolean addInventoryObject(Inventory i) {
		emf = Persistence.createEntityManagerFactory("data_pu");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		System.out.println(i);
		em.persist(i);
		System.out.println("Data Added");
		em.getTransaction().commit();
		em.close();
		emf.close();
		return true;
	}
	
	public boolean updateInventory(int id, String name, int reqCount)
	{
		emf = Persistence.createEntityManagerFactory("data_pu");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Inventory i1 = em.find(Inventory.class, id);
		i1.setName(name);
		i1.setRequiredCount(reqCount);
		if(i1.getCountAvailable()<i1.getRequiredCount())
			i1.purchase(i1.getRequiredCount()-i1.getCountAvailable());
		em.getTransaction().commit();
		em.close();
		emf.close();
		return true;
	}
	
	public boolean deleteInventory(int id)
	{
		emf = Persistence.createEntityManagerFactory("data_pu");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Inventory i1 = em.find(Inventory.class, id);
		em.remove(i1);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return true;
	}
	
	public Inventory getSingleInventory(int id)
	{
		Inventory i;
		emf = Persistence.createEntityManagerFactory("data_pu");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		i = em.find(Inventory.class, id);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return i;
	}
	
	public List<Inventory> getAllInventory()
	{
		List<Inventory> ilist;
		emf = Persistence.createEntityManagerFactory("data_pu");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Inventory> query = em.createNamedQuery("viewall", Inventory.class);
		ilist = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return ilist;
	}
	
	public boolean repairOrDisposeInventory(int id, int canRepaired, int disposable)
	{
		Inventory i;
		emf = Persistence.createEntityManagerFactory("data_pu");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		i = em.find(Inventory.class, id);
		i.disposeOrRepair(canRepaired, disposable);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return true;
	}
}
