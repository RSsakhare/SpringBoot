package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.beans.Product;
@Component
public class ProductDaoImpl implements ProductDaoInterface
{

	@Autowired
	JdbcTemplate jdbctemplate;
	
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public int updateProduct(Product p) {
		
		String query="update products11 set pname='"+p.getPname()+"',pid='"+p.getPid()+"',pqty='"+p.getPqty()+"' where pid='"+p.getPid()+"'";
		return jdbctemplate.update(query);
	}

	@Override
	public int saveProduct(Product p) {
String query="insert into Products11 values('"+p.getPid()+"','"+p.getPname()+"','"+p.getPqty()+"')";
		
		return jdbctemplate.update(query);
	}

	@Override
	public int deleteProduct(Product p) {
		String query="delete from products11 where pid="+p.getPid();
		return jdbctemplate.update(query);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void showallProduct()

	{

	List<Product> list=new ArrayList<Product>();

	jdbctemplate.query("select * from products11", new RowMapper() {

	public Object mapRow (ResultSet rs, int count) throws SQLException
	{

	Product p=new Product();

	p.setPid(rs.getInt(1));

	p.setPname(rs.getString(2));

	p.setPqty(rs.getInt(3));

	list.add(p);

	return p;

	}
	});

	

	for (Product p:list)

	{

	 System.out.println(p);

	}
	
	}
	}

