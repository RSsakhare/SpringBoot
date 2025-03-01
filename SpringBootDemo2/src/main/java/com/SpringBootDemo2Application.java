package com;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.beans.Product;
import com.dao.ProductDaoImpl;

@SpringBootApplication
public class SpringBootDemo2Application {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(SpringBootDemo2Application.class, args);
        ProductDaoImpl pdao = ac.getBean(ProductDaoImpl.class);
        
        Scanner scanner = new Scanner(System.in);

        // User input loop for CRUD operations
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("1. Save Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show all Products");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Save Product
                    System.out.println("Enter Product ID:");
                    int pid = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.println("Enter Product Name:");
                    String pname = scanner.nextLine();
                    System.out.println("Enter Product Quantity:");
                    int pqty = scanner.nextInt();
                    Product p1 = new Product(pid, pname, pqty);
                    pdao.saveProduct(p1);
                    System.out.println("Product saved successfully!");
                    break;

                case 2: // Update Product
                    System.out.println("Enter Product ID to update:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.println("Enter new Product Name:");
                    String updateName = scanner.nextLine();
                    System.out.println("Enter new Product Quantity:");
                    int updateQty = scanner.nextInt();
                    Product p2 = new Product(updateId, updateName, updateQty);
                    pdao.updateProduct(p2);
                    System.out.println("Product updated successfully!");
                    break;

                case 3: // Delete Product
                    System.out.println("Enter Product ID to delete:");
                    int deleteId = scanner.nextInt();
                    Product p3 = new Product(deleteId, "", 0);
                    pdao.deleteProduct(p3);
                    System.out.println("Product deleted successfully!");
                    break;

                case 4: // Show all Products
                    pdao.showallProduct();
                    break;

                case 5: // Exit
                    System.out.println("Exiting the application...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
