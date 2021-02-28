package com.team.app.backend.persistance.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class User implements UserDetails, Serializable {

    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String image;
    private Date registr_date;
    private String activate_link;
    private Role role;

    private boolean enabled = true;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String username, String password, String email, String image, Date registr_date, String activate_link, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.image = image;
        this.registr_date = registr_date;
        this.activate_link = activate_link;
        this.role = role;

        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<Role>(){{ add(role); }} ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getRegistr_date() {
        return registr_date;
    }

    public void setRegistr_date(Date registr_date) {
        this.registr_date = registr_date;
    }

    public String getActivate_link() {
        return activate_link;
    }

    public void setActivate_link(String activate_link) {
        this.activate_link = activate_link;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


}
