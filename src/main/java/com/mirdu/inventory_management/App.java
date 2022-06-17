package com.mirdu.inventory_management;

import java.util.Scanner;

import com.mirdu.inventory_management.entity.Inventory;
import com.mirdu.inventory_management.service.InventoryService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	InventoryService isvc = new InventoryService();
        System.out.println("Welcome to Inventory Management");
        Scanner ip = new Scanner(System.in);
        char ch = 'Y';
        int id = 0,  reqCount = 0 ;
        String name = "";
        Inventory i;
        while(ch == 'Y')
        {
        	System.out.println("1. Add New Item \n 2.View an Item \n 3.View all Item \n 4.Repair/Dispose Item \n 5. Delete Item \n 6.Update Item");
        	System.out.println("Enter your choice");
        	int option = ip.nextInt();
        	switch(option)
        	{
        		case 1:
        			System.out.println("Add an Item");
        			System.out.println("Enter ID:");
        			id = ip.nextInt();
        			System.out.println("Enter Name:");
        			name = ip.next();
        			System.out.println("Enter required count:");
        			reqCount = ip.nextInt();
        			i = new Inventory(id, name, reqCount);
        			System.out.println(isvc.addNewInventory(i));
        			break;
        		case 2:
        			System.out.println("View an Item");
        			System.out.println("Enter ID:");
        			id = ip.nextInt();
        			System.out.println(isvc.getSingleItem(id));
        			break;
        		case 3:
        			System.out.println("View all Item");
        			for(Inventory i1:isvc.getAllItem())
        			{
        				System.out.println(i1);
        			}
        			break;
        		case 4:
        			System.out.println("Repair / Dispose Item");
        			System.out.println("Enter ID:");
        			id = ip.nextInt();
        			System.out.println("Enter the count of Items that can be repaired well: ");
        			int canRepaired = ip.nextInt();
        			System.out.println("Enter the count of Items that need to be disposed: ");
        			int disposable = ip.nextInt();
        			System.out.println(isvc.repairOrDispose(id, canRepaired, disposable));
        			break;
        		case 5:
        			System.out.println("Delete an Item");
        			System.out.println("Enter ID:");
        			id = ip.nextInt();
        			System.out.println(isvc.deleteInventory(id));
        			break;
        		case 6:
        			System.out.println("Update an Item");
        			System.out.println("Enter ID:");
        			id = ip.nextInt();
        			System.out.println("Enter Name:");
        			name = ip.next();
        			System.out.println("Enter required count:");
        			reqCount = ip.nextInt();
        			System.out.println(isvc.updateInventory(id, name, reqCount));
        			break;
        		default:
        			System.out.println("Sorry! Wrong Option");
        			break;
        	}
        	System.out.println("Want to Continue??? Press Y: ");
        	ch = ip.next().charAt(0);
        }
        System.out.println("Thank you for Using!!!!!");
    }
}
