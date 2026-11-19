package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.entity.Employee;
import com.jdbcConnection.JDBCUtil;

public class EmployeeDao {
	
//	 Database Code
	
  Connection con =  JDBCUtil.createConnection();
  
//   saveEmployee 
  
//  public void createTable()
//  {
//	  try
//	  {
//		 Statement st = con.createStatement();
//		 
//		 st.execute("create table employees (EmpId int , EmpName varchar(45),EmpSalary double,Department varchar(45))");
//		 
//		 System.out.println("Table created...");
//		  
//	  }catch(Exception e)
//	  {
//		  e.printStackTrace();
//	  }
//  }
  
  
//  Not Recomendaded
 /* public void insertEmployee(Employee employee)
  {
	  try
	  {
		  
	   Statement st = con.createStatement();
	   
	   st.execute("insert into employees values ('"+employee.getEmpId()+"','"+employee.getEmpName()+"','"+employee.getEmpSalary()+"','"+employee.getEmpDepartment()+"')");
	   
	   System.out.println("Data Inserted SucessFully....");
	  
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  */
//  ReComendaded 
  
  
  public void insertEmployee(Employee employee)
  {
	  try
	  {
		  
//	   Statement st = con.createStatement();
		  
	 PreparedStatement pst=  con.prepareStatement("insert into employees values (?,?,?,?)");
	  
	 pst.setInt(1, employee.getEmpId());
	 
	 pst.setString(2, employee.getEmpName());
	 
	 pst.setDouble(3, employee.getEmpSalary());
	 
	 pst.setString(4, employee.getEmpDepartment());
	   
	 pst.execute();
	   
	   System.out.println("Data Inserted SucessFully....");
	  
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	 
  }
  
 
  public static void main(String[] args)
  {
	  EmployeeDao emp = new EmployeeDao();
//	  emp.createTable();
	
/*	 Employee e1 = new Employee();
	 e1.setEmpId(102);
	 e1.setEmpName("jayram");
	 e1.setEmpSalary(5000);
	 e1.setEmpDepartment("IT");
	 
	 
	 Employee e2 = new Employee();
	 
	 e2.setEmpId(103);
	 e2.setEmpName("Sachin");
     e2.setEmpSalary(50000);
     e2.setEmpDepartment("BA");
     
     Employee e3 = new Employee();
     e3.setEmpId(104);
     e3.setEmpName("Prem");
     e3.setEmpSalary(56000);
     e3.setEmpDepartment("IT");
     
     Employee e4 = new Employee();
     
     e4.setEmpId(105);
     e4.setEmpName("Abhinay");
     e4.setEmpSalary(45000);
     e4.setEmpDepartment("IT");
     
     
     Employee e5 = new Employee();
     
     e5.setEmpId(106);
     e5.setEmpName("Shrii");
     e5.setEmpSalary(35000);
     e5.setEmpDepartment("HR");
     
    
     List<Employee> list = Arrays.asList(e1,e2,e3,e4,e5);
     
     for(Employee ee : list)
     {
    	 emp.insertEmployee(ee);
//    	 System.out.println("Employee Inserted SucessFully....");
     }
     
     */
	  
	  
	  Employee e = new Employee();
	  
	  e.setEmpId(108);
	  e.setEmpName("Govind");
	  e.setEmpSalary(34500);
	  e.setEmpDepartment("Sales");
	  
	  List<Employee> list = Arrays.asList(e);
	  
	  for(Employee em : list)
	  {
		  emp.insertEmployee(em);
	  }
//     System.out.println("Employee Inserted....");
  }
  
  
  
  
  
}
