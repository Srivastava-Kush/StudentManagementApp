package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class student {

    @Id
    int roll;
    String name;
    String course;
    int fees;
    String photo; // Add photo field to store the file path

    public student() {}

    public student(int roll, String name, String course, int fees, String photo) {
        super();
        this.roll = roll;
        this.name = name;
        this.course = course;
        this.fees = fees;
        this.photo = photo;
    }

    // Getters and Setters
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
