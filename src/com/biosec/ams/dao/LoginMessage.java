// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.dao;

public class LoginMessage
{
    private String message;
    private Users users;
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(final Users users) {
        this.users = users;
    }
}
