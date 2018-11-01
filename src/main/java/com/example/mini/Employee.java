package com.example.mini;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Employee {
 
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;
    private int years;
    
    public long getid() {
		return id;
	}

	public void setid(long id) {
		this.id = id;
    }
    public String getname() {
		return name;
	}

	public void setname(String id) {
		this.name = name;
    }
    
    public Integer getage() {
		return age;
	}

	public void setage(Integer age) {
		this.age = age;
	}

    public Integer getyears() {
		return years;
	}

	public void setyear(Integer years) {
		this.years = years;
	}

    private Employee() {}
 
    public Employee(String name, int age, int years) {
        this.name = name;
        this.age = age;
        this.years = years;
    }
}