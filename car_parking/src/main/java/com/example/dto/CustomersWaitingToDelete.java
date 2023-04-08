package com.example.dto;

public class CustomersWaitingToDelete {
    private long id;
    private String name;
    private String email;
    private boolean status;

    public CustomersWaitingToDelete() {
    }

    public CustomersWaitingToDelete(long id, String name, String email, boolean status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
