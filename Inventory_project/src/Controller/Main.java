package Controller;
import java.sql.SQLException;

import java.util.Scanner;
import DAO.LoginDAO;
import DAO.ProductDAO;
import Model.Login;
import Model.product;

public class Main 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc=new Scanner(System.in);
		int choice,option;
		Login login=new Login();
		product Product=new product();
		LoginDAO logindao=new LoginDAO();
		ProductDAO productdao = new ProductDAO();
		do
		{
			System.out.println("1. Admin");
			System.out.println("2. Agent");
			System.out.println("3. Exit");
			System.out.println("************************************************************");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:System.out.println("Admin Login");
			sc.nextLine();
			System.out.println("Enter your username");
			String username = sc.nextLine();
			System.out.println("Enter your password ");
			String password = sc.nextLine();
			login.setUsername(username);
			login.setPassword(password);
			if(logindao.validate(login))
					{
				System.out.println("Login Success!!!");
						do
						{
							System.out.println("************************************************************");
							System.out.println("1. Add product");
							System.out.println("2.Display product");
							System.out.println("3.Logout");
							System.out.println("************************************************************");
							System.out.println("Enter your option");
							option=sc.nextInt();
							switch(option)
							{
							case 1:System.out.println("Add product");
							System.out.println("Enter the productId");
							int productId=sc.nextInt();
							sc.nextLine();
							System.out.println("Enter the productName");
							String productName=sc.nextLine();
							System.out.println("Enter the minimum sell quantity");
							int minsellQuantity=sc.nextInt();
							System.out.println("Enter the price");
							int price=sc.nextInt();
							System.out.println("Enter the quantity"); 
							int quantity=sc.nextInt();
							Product.setProductId(productId);
							Product.setProductName(productName);
							Product.setMinsellQuantity(minsellQuantity);
							Product.setPrice(price);
							Product.setQuantity(quantity);
							productdao.addProduct(Product);
							
							break;
							case 2:System.out.println("Display product");
							productdao.display();
							break;
							case 3:System.out.println("Logout");
							break;
						}
					}
						while(option!=3);
				}
				else
				{
				System.out.println("Login Failure");
				}
			break;
			case 2:System.out.println("Agent Login");
			sc.nextLine();
			System.out.println("Enter your username");
			String username1 = sc.nextLine();
			System.out.println("Enter your password");
			String password1 = sc.nextLine();
			login.setUsername(username1);
			login.setPassword(password1);
			if(logindao.validate(login))
					{
				System.out.println("Login Success!!!");
						do
						{
							System.out.println("************************************************************");
							System.out.println("1.Display product");
							System.out.println("2.Logout");
							System.out.println("************************************************************");
							System.out.println("Enter your option");
							option=sc.nextInt();
							switch(option)
							{
							case 1:System.out.println("Display product");
							productdao.display();
							break;
							case 2:System.out.println("Logout");
							break;
						}
					}
						while(option!=2);
				}
				else
				{
				System.out.println("Login Failure");
				}
			break;
			case 3:System.out.println("Exit");
			break;
			}
		}
		while(choice!=3);
		sc.close();
	}

}
