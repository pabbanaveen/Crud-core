package com.employee.department.request;

import java.util.List;

import com.employee.department.modal.DevelopmentModal;

public class DevelopmentRequest {

    private List<DevelopmentModal> developmentReq;

    public DevelopmentRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DevelopmentRequest(List<DevelopmentModal> developmentReq) {
        super();
        this.developmentReq = developmentReq;
    }

    public List<DevelopmentModal> getDevelopmentReq() {
        return developmentReq;
    }

    public void setDevelopmentReq(List<DevelopmentModal> developmentReq) {
        this.developmentReq = developmentReq;
    }

    @Override
    public String toString() {
        return "DevelopmentRequest [developmentReq=" + developmentReq + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((developmentReq == null) ? 0 : developmentReq.hashCode());
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
        DevelopmentRequest other = (DevelopmentRequest) obj;
        if (developmentReq == null) {
            if (other.developmentReq != null)
                return false;
        } else if (!developmentReq.equals(other.developmentReq))
            return false;
        return true;
    }

}
