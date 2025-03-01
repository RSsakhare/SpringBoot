package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.*;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> 
{

	List<Product> findAllByCategory_Cid(int cid);

}
