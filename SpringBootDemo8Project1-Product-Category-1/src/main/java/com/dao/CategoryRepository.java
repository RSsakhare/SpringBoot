package com.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.*;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
