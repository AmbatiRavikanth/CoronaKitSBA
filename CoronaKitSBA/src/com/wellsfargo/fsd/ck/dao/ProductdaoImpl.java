package com.wellsfargo.fsd.ck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.ck.Exception.ProductException;
import com.wellsfargo.fsd.ck.model.Product;

public class ProductdaoImpl implements Productdao {
	
	public static final String INS_LN_QRY="Insert into products(pid,pname,pcost,pdesc) values (?,?,?,?)";
	public static final String UPD_LN_QRY="update products set pname=?,pcost=?,pdesc=? where pid=?";
	public static final String DEL_LN_QRY="Delete from products where pid=?";	
	public static final String GET_BY_ID_LN_QRY="select pid,pname,pcost,pdesc from products where pid=?";
	public static final String GET_ALL_LNS_QRY="select pid,pname,pcost,pdesc from products";

	@Override
	public Product addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		if (product!=null)
		{
			try(Connection con=ConnectionFactory.getConnection();)
			{
				PreparedStatement pst =con.prepareStatement(INS_LN_QRY);
				pst.setInt(1, product.getId());
				pst.setString(2, product.getProductName());
				pst.setDouble(3, product.getCost());
				pst.setString(4, product.getProductDescription());
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ProductException("Error, could not add product");
			}
			
		}
		return product;
	}

	@Override
	public Product saveProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		if (product!=null)
		{
			try(Connection con=ConnectionFactory.getConnection();)
			{
				PreparedStatement pst =con.prepareStatement(UPD_LN_QRY);
				
				pst.setString(1, product.getProductName());
				pst.setDouble(2, product.getCost());
				pst.setString(3, product.getProductDescription());
				pst.setInt(4, product.getId());
				pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new ProductException("Error, could not update product");
			}
			
		}
		return product;
	}

	@Override
	public List<Product> listProducts() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		try(Connection con=ConnectionFactory.getConnection();)
		{
			PreparedStatement pst =con.prepareStatement(GET_ALL_LNS_QRY);		
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setCost(rs.getDouble(3));
				p.setProductDescription(rs.getString(4));
				products.add(p);
			}
			if (products.isEmpty())
			{
				products=null;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Error, could not retrieve products ");
		}
		return products;
	}

	@Override
	public boolean deleteProduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		boolean deleteProduct=false;
		try(Connection con=ConnectionFactory.getConnection();)
		{
			PreparedStatement pst =con.prepareStatement(DEL_LN_QRY);		
			
			pst.setInt(1, id);
			int rowsCount=pst.executeUpdate();
			deleteProduct=rowsCount>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Error, could not delete product with id "+id);
		}
		
		return deleteProduct;
	}

	@Override
	public Product getProduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		Product p = null;
		try(Connection con=ConnectionFactory.getConnection();)
		{
			PreparedStatement pst =con.prepareStatement(GET_BY_ID_LN_QRY);	
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
				if (rs.next())
				{
				 p=new Product();
				p.setId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setCost(rs.getDouble(3));
				p.setProductDescription(rs.getString(4));		
				}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ProductException("Error, could not retriev product details");
		}
		
		return p;
	}

}
