package com.team.app.backend.persistance.model;




import java.util.Date;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String imageUrl;
    private Date registr_date;
    private String activate_link;
    private Role role;

    public User() {
    }

    public User(long id, String firstName, String lastName, String username, String password, String email, String imageUrl, Date registr_date, String activate_link, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.imageUrl = imageUrl;
        this.registr_date = registr_date;
        this.activate_link = activate_link;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
}
