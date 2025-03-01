package com.dao;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bean.*;
@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer> 
{
	ArrayList<Employee> findByEname(String ename);
	ArrayList<Employee> findByEsalBetween(int minSal,int maxSal);
}
