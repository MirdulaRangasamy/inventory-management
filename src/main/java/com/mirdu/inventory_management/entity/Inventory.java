package com.mirdu.inventory_management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@NamedQuery(name="viewall", query=" select i from Inventory i")
@Entity
public class Inventory {
	@Id
	private int id;
	private String name;
	private int requiredCount;
	private int countAvailable;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int id, String name, int requiredCount) {
		super();
		this.id = id;
		this.name = name;
		this.requiredCount = requiredCount;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRequiredCount() {
		return requiredCount;
	}
	public void setRequiredCount(int requiredCount) {
		this.requiredCount = requiredCount;
	}	
	public int getCountAvailable() {
		return countAvailable;
	}
	public void setCountAvailable(int countAvailable) {
		this.countAvailable = countAvailable;
	}
	public void purchase(int count)
	{
		this.countAvailable += count;
		System.out.println(count + "extra items got purchased");
	}
	public void disposeOrRepair(int canRepaired, int disposable)
	{
		System.out.println(canRepaired + " items Sent for Repair");
		
		countAvailable  = countAvailable-disposable;
	
		if(countAvailable < requiredCount)
		{
			purchase(requiredCount - countAvailable);	
		}
		else
		{
			System.out.println(disposable+" no of items got disposed..");
		}
	}
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", requiredCount=" + requiredCount + ", countAvailable="
				+ countAvailable + "]";
	}
	
	
}
