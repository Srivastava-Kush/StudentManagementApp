package com.example.demo.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.student;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository sturepo;

    public Iterable<student> showAll() {
        return sturepo.findAll();
    }

    public student saveStudent(student std) {
        return sturepo.save(std);
    }

    public student getStudentById(int id) {
        return sturepo.findById(id).orElse(null);
    }

    public void deleteStudent(int id) {
        sturepo.deleteById(id);
    }

    public student updateStudent(student std) {
        return sturepo.save(std);
    }
    
    public List<student> search(String gn){
    	return sturepo.findByName(gn);
    }
    
    public String registerStudent(int roll, String name,String course,int fees,MultipartFile photo) {
        
        try {
       	    String UPLOADED_FOLDER = "src/main/resources/static/uploads/";
            String filename=photo.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER+File.separator+filename);
            Files.copy(photo.getInputStream(), path);
            student stu=new student();
            stu.setRoll(roll);
            stu.setName(name);
            stu.setCourse(course);
            stu.setPhoto(filename);
            sturepo.save(stu);
            return "Successfully Registered";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed Registration";
        }  
           
      }



}
