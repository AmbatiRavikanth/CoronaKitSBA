package com.wellsfargo.fsd.ck.dao;

import java.util.List;

import com.wellsfargo.fsd.ck.Exception.ProductException;
import com.wellsfargo.fsd.ck.model.Product;

public interface Productdao {
	
	Product addProduct(Product product) throws ProductException;
	Product saveProduct(Product product) throws ProductException;
	List<Product> listProducts() throws ProductException;
	boolean deleteProduct(int id) throws ProductException;
	Product getProduct(int id) throws ProductException;
	
	
}
