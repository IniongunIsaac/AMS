/*
 * To change this license header, choose License Headers in Project PropeReturnMessageies.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosec.ams.core;

public class ReturnMessage
{
    private String message;
    private boolean result;
    
    public ReturnMessage() {
        this.result = false;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public boolean isResult() {
        return this.result;
    }
    
    public void setResult(final boolean result) {
        this.result = result;
    }
}
