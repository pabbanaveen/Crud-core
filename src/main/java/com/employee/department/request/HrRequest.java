package com.employee.department.request;

import java.util.List;

import com.employee.department.modal.HrModal;

public class HrRequest {

    private List<HrModal> hrReq;

    public HrRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HrRequest(List<HrModal> hrReq) {
        super();
        this.hrReq = hrReq;
    }

    
    public List<HrModal> getHrReq() {
        return hrReq;
    }

    public void setHrReq(List<HrModal> hrReq) {
        this.hrReq = hrReq;
    }

    @Override
    public String toString() {
        return "HrRequest [hrReq=" + hrReq + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((hrReq == null) ? 0 : hrReq.hashCode());
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
        HrRequest other = (HrRequest) obj;
        if (hrReq == null) {
            if (other.hrReq != null)
                return false;
        } else if (!hrReq.equals(other.hrReq))
            return false;
        return true;
    }
    
    

  
}
