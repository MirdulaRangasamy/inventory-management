package com.mirdu.inventory_management.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;

import com.mirdu.inventory_management.entity.Inventory;

public class InventoryServiceTest {
	InventoryService isvc = new InventoryService();
	@Test
	public void testAddNewInventory() {
		assertEquals("Item added",isvc.addNewInventory(new Inventory(105,"AC",3)));
	}

	@Test
	public void testUpdateInventory() {
		assertEquals("Item Updated...",isvc.updateInventory(101, "Landline", 6));
	}

	@Test
	public void testDeleteInventory() {
		assertEquals("Item Deleted",isvc.deleteInventory(102));
	}

	@Test
	public void testGetSingleItem() {
		assertNotNull(isvc.getSingleItem(101));
	}

	@Test
	public void testGetAllItem() {
		assertNotNull(isvc.getAllItem());
	}

	@Test
	public void testRepairOrDispose() {
		assertEquals("Repair/Dispose Done",isvc.repairOrDispose(104, 2, 2));
	}

}
