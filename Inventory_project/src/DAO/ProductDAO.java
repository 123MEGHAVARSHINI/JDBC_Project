package DAO;
import java.sql.*;


import Model.product;
import ConnectionManager.ConnrctionManager;


public class ProductDAO 
{
	public void addProduct(product product) throws ClassNotFoundException, SQLException
	{
		ConnrctionManager conm = new ConnrctionManager();
		Connection con = conm.establishConnection();
		
		String sql_query = "insert into product(productId,productName,minSellQuantity,price,quantity) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setInt(3,product.getMinsellQuantity());
		ps.setInt(4,product.getPrice());
		ps.setInt(5,product.getQuantity());
		
		ps.executeUpdate();
	
		conm.closeConnection();
		
		
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnrctionManager conm = new ConnrctionManager();
		Connection con=conm.establishConnection();
	
		//1.Statement class declare
				Statement st=con.createStatement();
				
				//2.write query
				ResultSet rt= st.executeQuery("select * from product");
				while(rt.next())
				{
					
				System.out.println(rt.getInt("productId")+" | "+rt.getString("productName")+" | "+rt.getInt("minsellQuantity")+" | "+rt.getInt("price")+" | "+rt.getInt("quantity")+" | ");
				}
				conm.closeConnection();
	}
}
