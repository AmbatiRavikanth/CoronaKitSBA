package com.wellsfargo.fsd.ck.service;

import java.util.List;

import com.wellsfargo.fsd.ck.Exception.ProductException;
import com.wellsfargo.fsd.ck.model.Product;

public interface ProductService {
	
	Product validateAndAddProduct(Product product) throws ProductException;
	Product validateAndSaveProduct(Product product) throws ProductException;
	Product getProduct(int id)throws ProductException;
	List<Product> getAllProducts() throws ProductException;
	boolean deleteProductbyid(int id)throws ProductException;

}
