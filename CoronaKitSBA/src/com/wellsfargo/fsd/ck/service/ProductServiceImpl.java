package com.wellsfargo.fsd.ck.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.ck.Exception.ProductException;
import com.wellsfargo.fsd.ck.dao.Productdao;
import com.wellsfargo.fsd.ck.dao.ProductdaoImpl;
import com.wellsfargo.fsd.ck.model.Product;
 
public class ProductServiceImpl implements ProductService{
	
	Productdao productdao=null;
		
	public ProductServiceImpl()
	{
		productdao = new ProductdaoImpl();
	}
	
	private boolean isValidProductid(Integer pid)
	{
		return pid!=null && pid>0;
	}
	
	private boolean isValidCost(Double c)
	{
		return c!=null && c>0.0;
	}
	
	private boolean isValidName(String n)
	{
		return n!=null;		
	}
	
	private boolean isValidProduct(Product product) throws ProductException
	{
		boolean isValid=true;
		List<String> errMsgs=new ArrayList<String>();
		if (product!=null)
		{
			if (!isValidProductid(product.getId()))
			{
				isValid=false;
				errMsgs.add("Invalid Product Id");
			}
			if (!isValidCost(product.getCost()))
			{
				isValid=false;
				errMsgs.add("Invalid Product Cost");
			}
			if (!isValidName(product.getProductName()))
			{
				isValid=false;
				errMsgs.add("Invalid Product Cost");
			}
			if(!errMsgs.isEmpty())
			{
				throw new ProductException(errMsgs.toString());
			}
		}
		else {  
            isValid=false;  
        } 
		return isValid;
	}

	@Override
	public Product validateAndAddProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		if (isValidProduct(product))
		{
			productdao.addProduct(product);
		}
		return product;
	}

	@Override
	public Product validateAndSaveProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		if (isValidProduct(product))
		{
			productdao.saveProduct(product);
		}
		return product;
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> products=productdao.listProducts();
		return products;
	}

	@Override
	public boolean deleteProductbyid(int id) throws ProductException {
		// TODO Auto-generated method stub
		return productdao.deleteProduct(id);
	}

	@Override
	public Product getProduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		return productdao.getProduct(id);
	}
	
}
