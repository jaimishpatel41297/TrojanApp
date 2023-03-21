/*
package com.com.trojans.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")

    private int id;


    @Column(name = "EMAIL")
    @Email(message = "Invalid Email")
    @NotEmpty(message = "*Require email")

    private String email;


    @Column(name = "PASSWORD")
    @Length(min = 6, message = "Password must contain at least 6 characters")
    @NotEmpty(message = "*Require password")

    private String password;


    @Column(name = "NAME")
    @NotEmpty(message = "*Require your name")

    private String name;


    @Column(name = "LAST_NAME")
    @NotEmpty(message = "*Require your last name")

    private String lastName;


    @Column(name = "ACTIVE")

    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))

    private Set<LoginRole> roles;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    public Set<LoginRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<LoginRole> roles) {
        this.roles = roles;
    }
}
*/
