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
    private long _id;
    private String _name;
    private String _email;
    private String _address;
    private Date _joinDate;


    public User(String _name, String _email, String _address, int _id) {
        this._name = _name;

        this._email = _email;
        this._address = _address;
        this._id = _id;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    @NotEmpty
    @Size(min=1, max=100)
    @Column(name = "name", nullable = false)
    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    @NotEmpty
    @Size(min=5, max=100)
    @Column(name = "email")
    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    @NotEmpty
    @Size(min=2, max=100)
    @Column(name = "address")
    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    @Column(name = "joinDate")
    @NotNull
    public Date get_joinDate() {
        return _joinDate;
    }

    public void set_joinDate(Date _joinDate) {
        this._joinDate = _joinDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return _id == user._id && _name.equals(user._name) && (_email != null ? _email.equals(user._email) : user._email == null) && (_address != null ? _address.equals(user._address) : user._address == null) && _joinDate.equals(user._joinDate);
    }

    @Override
    public int hashCode() {
        int result = (int) (_id ^ (_id >>> 32));
        result = 31 * result + _name.hashCode();
        result = 31 * result + (_email != null ? _email.hashCode() : 0);
        result = 31 * result + (_address != null ? _address.hashCode() : 0);
        result = 31 * result + _joinDate.hashCode();
        return result;
    }
}
