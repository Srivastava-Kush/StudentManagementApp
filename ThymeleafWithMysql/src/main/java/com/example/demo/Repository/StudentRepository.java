package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.Entity.student;
@Repository
public interface StudentRepository extends CrudRepository<student, Integer>{
	 
	
     public List<student> findByName(String gn);
     
    
}
