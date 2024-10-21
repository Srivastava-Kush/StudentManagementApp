package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Entity.ContactMessage;
import com.example.demo.Entity.student;
import com.example.demo.Service.StudentService;

@Controller
public class AppController {
	

    @Autowired
    StudentService stuservice;
    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";  // This should correspond to your contact.html Thymeleaf template
    }
    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("records", stuservice.showAll());
        return "showdata";
    }
    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new student());
        return "add-student";
    }
    @PostMapping("/save")
    public String saveStudent(@RequestParam int roll,@RequestParam String name,@RequestParam String course,@RequestParam int fees, @RequestParam MultipartFile photo,Model model) {
          String message=stuservice.registerStudent(roll,name,course,fees,photo);
          model.addAttribute(message);
        return "redirect:/show";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam int roll,@RequestParam String name,@RequestParam String course,@RequestParam int fees, @RequestParam MultipartFile photo) {
      stuservice.registerStudent(roll,name,course,fees,photo);
      return "redirect:/show";
        }
   

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", stuservice.getStudentById(id));
        return "edit-student";
    }

   
    @GetMapping("/search")
    public String search(@RequestParam("gname") String gname, Model model) {
        List<student> records = stuservice.search(gname);
        model.addAttribute("records", records);
        return "search_results"; // This should correspond to your search.html
    }
    
    
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    
    
    @PostMapping("/submitContact")
    public String submitContact(@ModelAttribute("contactMessage") ContactMessage contactMessage, Model model) {
        // Here you could process the contact message (save it, send an email, etc.)
        // For simplicity, we'll just display a success message
        System.out.println("Contact Form Submission - Name: " + contactMessage.getName());
        System.out.println("Email: " + contactMessage.getEmail());
        System.out.println("Message: " + contactMessage.getMessage());

        model.addAttribute("successMessage", "Your message has been successfully submitted!");
        return "contact"; // Redirect back to the contact form page with the success message
    }
}
