package com.bins.bean;

public class Role {
    private int id;
    private String rolename;
    private String roledesc;

    public Role() {
    }

    public Role(int id, String rolename, String roledesc) {
        this.id = id;
        this.rolename = rolename;
        this.roledesc = roledesc;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    public int getId() {
        return id;
    }

    public String getRolename() {
        return rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }
}
