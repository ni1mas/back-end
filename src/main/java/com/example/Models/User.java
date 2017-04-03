package com.example.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * Created by Robert on 04/04/2017.
 */
@Entity
@Table(name = "User")
public class User {

    public User(String dni, String name, String fname, int phone, int phone2, String email, String address, String password){
        this.DNI=dni;
        this.name=name;
        this.fname=fname;
        this.phone=phone;
        this.phone2=phone2;
        this.email=email;
        this.address=address;
        this.password=password;
    }

    public User(){

    }
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Id
    private String DNI;
    @NotNull
    private String name;
    @NotNull
    private String fname;
    @NotNull
    private int phone;
    private int phone2;
    @Column(unique=true)
    private String email;
    @NotNull
    private String address;
    @NotNull
    private String password;

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public String getFname() {
        return fname;
    }

    public int getPhone() {
        return phone;
    }

    public int getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
