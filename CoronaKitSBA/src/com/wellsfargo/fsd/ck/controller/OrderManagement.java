package com.wellsfargo.fsd.ck.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wellsfargo.fsd.ck.Exception.ProductException;
import com.wellsfargo.fsd.ck.model.Product;
import com.wellsfargo.fsd.ck.service.ProductService;
import com.wellsfargo.fsd.ck.service.ProductServiceImpl;


/**
 * Servlet implementation class OrderManagement
 */
@WebServlet({"/AdminLogin","/listProducts","/deleteProduct","/editProduct","/newProduct","/addProduct","/saveProduct","/Newuser","/showProductstoadd","/addproductstocart","/showkit","/placeorder","/ordersummary","/Logout"})
public class OrderManagement extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderManagement() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		productService=new ProductServiceImpl();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String url = request.getServletPath();  
	        String view = "";  
	        switch (url) {  
	        case "/AdminLogin":  
	            view = doLoginAuthenticated(request, response);  
	            break; 
	        case "/listProducts":  
	            view = doListProducts(request, response);  
	            break;  
	        case "/editProduct":  
	            view = doEditProducts(request, response);  
	            break; 
	        case "/deleteProduct":  
	            view = doDeleteProducts(request, response);  
	            break;     
	        case "/newProduct":  
	            view = doAddProducts(request, response);  
	            break;  
	        case "/addProduct":  
	            view = doSaveProducts(request, response);  
	            break;     
	        case "/saveProduct":  
	            view = doSaveProducts(request, response);  
	            break;    
	        case "/Newuser":  
	            view = doNewUserEntry(request, response);  
	            break;    
	        case "/showProductstoadd":  
	            view = doShowProducts(request, response);  
	            break;     
	            
	        case "/addproductstocart":  
	            view = doaddproductstocart(request, response);  
	            break;    
	        case "/showkit":  
	            view = doShowkit(request, response);  
	            break;
	        case "/placeorder":  
	            view = doPlaceOrder(request, response);  
	            break;  
	        case "/ordersummary":  
	            view = doordersummary(request, response);  
	            break; 
	        case "/Logout":  
	            view = doLogout(request, response);  
	            break;     
	        default:
	        	view="PageNotFound.jsp";
	        	break;
	        }  
	        request.getRequestDispatcher(view).forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected String doListProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		try {
			List<Product> products=productService.getAllProducts();
			request.setAttribute("productlist", products);
			view="ProductListPage.jsp"; 
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			request.setAttribute("errMsg", e.getMessage());  
            view="errPage.jsp"; 
            }			
		return view;		
	}
	protected String doEditProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		int productid = Integer.parseInt(request.getParameter("id")); 
		
        try {  
            Product product = productService.getProduct(productid);  
            request.setAttribute("product", product);  
            request.setAttribute("isNew", false);  
            view = "ProductFormPage.jsp";  
        } catch (ProductException e) {  
            request.setAttribute("errMsg", e.getMessage());  
            view = "errPage.jsp";  
        }  
        return view; 			
			
	}
	
	protected String doAddProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		Product p=new Product();		
		 request.setAttribute("product", p);  
         request.setAttribute("isNew", true);  
         view = "ProductFormPage.jsp";  		
        return view; 			
			
	}
	
	protected String doSaveProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		Product p=new Product();		
		 p.setId(Integer.parseInt(request.getParameter("productid"))); 		
		 p.setProductName(request.getParameter("productName"));
		 p.setCost(Double.parseDouble(request.getParameter("cost")));
		 p.setProductDescription(request.getParameter("productDescription"));
		 
		 try {  
             
	            if(request.getServletPath().equals("/addProduct")) {  
	            	productService.validateAndAddProduct(p);
	            }else {  
	            	productService.validateAndSaveProduct(p);
	            }  
	              
	            request.setAttribute("msg", "Product is saved");  
	            view="Adminuser_Login.jsp";  
	        } catch (ProductException e) {  
	            request.setAttribute("errMsg", e.getMessage());  
	            view = "errPage.jsp";  
	        }
		 
        return view; 			
			
	}
	
	protected String doDeleteProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view="";
		int productid = Integer.parseInt(request.getParameter("id")); 
		try {
			productService.deleteProductbyid(productid);
			List<Product> products=productService.getAllProducts();
			request.setAttribute("productlist", products);
			request.setAttribute("deleteconfirmationmsg", "Product is deleted");
			view="ProductListPage.jsp"; 
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			request.setAttribute("errMsg", e.getMessage());  
            view="errPage.jsp"; 
            }			
		return view;		
	}
	protected String doLoginAuthenticated(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		session.setAttribute("LoginSuccess", true);
		session.setAttribute("username", request.getParameter("userid"));
		return "Adminuser_Login.jsp";
		// TODO Auto-generated method stub
		
	}
	
protected String doNewUserEntry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session2=request.getSession();
		session2.setAttribute("Newuser", true);
		session2.setAttribute("Newusername", request.getParameter("username"));
		session2.setAttribute("Newuseremail", request.getParameter("email"));
		session2.setAttribute("Newusercontact", request.getParameter("contact"));
		return "Newuser.jsp";
		// TODO Auto-generated method stub
		
	}

protected String doShowProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String view="";
	HttpSession session=request.getSession();
	session.setAttribute("cartproduct", null);
	session.setAttribute("cartaddedproduct", null);
	try {
		List<Product> products=productService.getAllProducts();
		request.setAttribute("productlist", products);
		
		view="showproductstoadd.jsp"; 
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		request.setAttribute("errMsg", e.getMessage());  
        view="errPage.jsp"; 
        }			
	return view;		
}

protected String doaddproductstocart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String view="";
	List<Product> carts=null;
	Product p=null;
	try {
		p = productService.getProduct(Integer.parseInt(request.getParameter("id")));
	} catch (NumberFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ProductException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	HttpSession session=request.getSession();
//	if (session.getAttribute("cartproduct")==null)
//	{
//		 carts=new ArrayList<Product>();
//		carts.add(p);
//		session.setAttribute("cartproduct", carts);
//	}
//	else
//	{
//		 carts = (List<Product>) session.getAttribute("cartproduct");
//		//List<String> taskList=(List<String>)session.getAttribute("tasks");
//		carts.add(p);
//		session.setAttribute("cartproduct", p);
//	}	
	List<Product> AddedProducts=(List<Product>)session.getAttribute("cartproduct");
	if (AddedProducts==null)
	{
		AddedProducts =  new ArrayList<>();
		
	}
	if (p!=null)
	{
		AddedProducts.add(p);
	}
	
	session.setAttribute("cartproduct", AddedProducts); 
	//System.out.println(AddedProducts);
	try {
		List<Product> products=productService.getAllProducts();
		request.setAttribute("productlist", products);
		
		view="showproductstoadd.jsp"; 
	} catch (ProductException e) {
		// TODO Auto-generated catch block
		request.setAttribute("errMsg", e.getMessage());  
        view="errPage.jsp"; 
        }			
	return view;		
}

protected String doShowkit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String view="";
	HttpSession session=request.getSession();
	List<Product> carts = (List<Product>) session.getAttribute("cartproduct");
	if (carts!=null)
	{
		
	
	List<Product> cartaddedproducts=new ArrayList<>();
	session.setAttribute("Qtymap", null);
	//int count=0;
	//--------
	HashMap<Integer,Integer> hm =new HashMap<Integer,Integer>();
	for(Product pc:carts)
	{
		if (hm.containsKey(pc.getId()))
		{
			
			hm.put(pc.getId(), hm.get(pc.getId())+1);	
			
		}
		else
		{
			
			hm.put(pc.getId(), 1);
			cartaddedproducts.add(pc);
		}
	}
	
	session.setAttribute("Qtymap", hm);
	//==========
	session.setAttribute("cartaddedproduct", cartaddedproducts);
	}
	
	//System.out.println(carts);
	view="showkit.jsp";
	return view;		
}

protected String doPlaceOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String view="";
	HttpSession session2=request.getSession();
	session2.setAttribute("Addresssubmitted", true);
	if (session2.getAttribute("Addresssubmitted")!=null)
	{
		session2.setAttribute("Address1", request.getParameter("Address1"));
		session2.setAttribute("Address2", request.getParameter("Address2"));
		session2.setAttribute("City", request.getParameter("City"));
		session2.setAttribute("State", request.getParameter("State"));	
	}	
	return "placeorder.jsp";		
}

protected String doordersummary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String view="";
	HttpSession session=request.getSession();
	Double TotalAmount=0.0;
	List<Product> carts = (List<Product>) session.getAttribute("cartaddedproduct");
	HashMap<Integer,Integer> hm=(HashMap<Integer,Integer>) session.getAttribute("Qtymap");
	for (Product p:carts)
	{
		TotalAmount=TotalAmount+(p.getCost()*hm.get(p.getId()));
	}
	session.setAttribute("TotalAmount", TotalAmount);	
	return "ordersummary.jsp";		
}

protected String doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session=request.getSession();
	session.setAttribute("LoginSuccess", false);	
	return "Adminuser_Login.jsp";
	// TODO Auto-generated method stub
	
}
}
