package com.employee.department.response;

import java.util.List;

import com.employee.department.modal.DevelopmentModal;

public class DevelopmentResponse {

    private List<DevelopmentModal> developmentResponse; 
    private String message;
    public List<DevelopmentModal> getDevelopmentResponse() {
        return developmentResponse;
    }
    public void setDevelopmentResponse(List<DevelopmentModal> developmentResponse) {
        this.developmentResponse = developmentResponse;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public DevelopmentResponse() {
        super();
        // TODO Auto-generated constructor stub
    }
    public DevelopmentResponse(List<DevelopmentModal> developmentResponse, String message) {
        super();
        this.developmentResponse = developmentResponse;
        this.message = message;
    }
    
     
}
