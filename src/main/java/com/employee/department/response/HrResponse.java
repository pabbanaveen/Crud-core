package com.employee.department.response;

import java.util.List;

import com.employee.department.modal.HrModal;

public class HrResponse {

    private List<HrModal> hrsResp;
    private String message;
    
    
    public HrResponse(List<HrModal> hrsResp, String message) {
        super();
        this.hrsResp = hrsResp;
        this.message = message;
    }
    public HrResponse() {
        super();
        // TODO Auto-generated constructor stub
    }
    public List<HrModal> getHrsResp() {
        return hrsResp;
    }
    public void setHrsResp(List<HrModal> hrsResp) {
        this.hrsResp = hrsResp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "HrResponse [hrsResp=" + hrsResp + ", message=" + message + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hrsResp == null) ? 0 : hrsResp.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        HrResponse other = (HrResponse) obj;
        if (hrsResp == null) {
            if (other.hrsResp != null)
                return false;
        } else if (!hrsResp.equals(other.hrsResp))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
            return false;
        return true;
    }
    
    
  
}
