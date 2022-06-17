package com.mirdu.inventory_management.service;

import java.util.List;

import com.mirdu.inventory_management.dao.InventoryDAO;
import com.mirdu.inventory_management.entity.Inventory;

public class InventoryService {
	private InventoryDAO idao = new InventoryDAO();

	public String addNewInventory(Inventory i) {
		try {
			i.purchase(i.getRequiredCount());
			System.out.println("Purchased...");
			idao.addInventoryObject(i);
			return "Item added";
		} catch (Exception e) {
			return "Something Wrong";
		}
	}

	public String updateInventory(int id, String name, int reqCount) {
		try {
			idao.updateInventory(id, name, reqCount);
			return "Item Updated...";
		} catch (Exception e) {
			return "Something Wrong";
		}
	}

	public String deleteInventory(int id) {
		try {
		idao.deleteInventory(id);
		return "Item Deleted";
		} catch (Exception e) {
			return "Something Wrong";
		}
	}

	public Inventory getSingleItem(int id) {
		try {
			return idao.getSingleInventory(id);
		}
		catch (Exception e) {
			return null;
		}
		
	}

	public List<Inventory> getAllItem() {
		try
		{
		return idao.getAllInventory();
		}
		catch (Exception e) {
			return null;
		}
	}

	public String repairOrDispose(int id, int canRepaired, int disposable) {
		try {
		idao.repairOrDisposeInventory(id, canRepaired, disposable);
		return "Repair/Dispose Done";
		}
		catch (Exception e) {
			return "Something Wrong";
		}
	}
}
