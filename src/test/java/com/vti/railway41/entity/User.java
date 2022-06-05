package com.vti.railway41.entity;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private int ProjectId;
    private String ProSkill;
    private Integer ExpInYear;
    private  Role role;

    public User() {
    }

    public User(int id, String fullName, String email, String password,
                int projectId, String proSkill, Integer expInYear, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        ProjectId = projectId;
        ProSkill = proSkill;
        ExpInYear = expInYear;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setIdd(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    public Integer getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(Integer expInYear) {
        ExpInYear = expInYear;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ProjectId=" + ProjectId +
                ", ProSkill='" + ProSkill + '\'' +
                ", ExpInYear=" + ExpInYear +
                ", role=" + role +
                '}';
    }


}
