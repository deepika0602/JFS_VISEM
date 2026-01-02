package com.skillnext1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;   // AUTO INCREMENT

    @Column(name = "name")
    private String name;

    @Column(name = "sem")
    private int sem;

    @Column(name = "dept")
    private String dept;

    // Default constructor (required by Hibernate)
    public Student() {}

    // Parameterized constructor
    public Student(String name, int sem, String dept) {
        this.name = name;
        this.sem = sem;
        this.dept = dept;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSem() {
        return sem;
    }

    public String getDept() {
        return dept;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
