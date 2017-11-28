package com.nice.naor.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Haimov on 25/11/2017.
 */

@Entity
@Table(name = "USER")
public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private String address;
    private Date join_date;


    public User(int _id, String _name, String _email, String _address) {
        this.id = _id;
        this.name = _name;
        this.email = _email;
        this.address = _address;
    }

    protected User(){}

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    @Size(min=1, max=100)
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    @Size(min=5, max=100)
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    @Size(min=2, max=100)
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "join_date")
    @NotNull
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    public Date getJoin_date() {return join_date;}

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }
}
