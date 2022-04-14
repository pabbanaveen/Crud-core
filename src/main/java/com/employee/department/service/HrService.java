package com.employee.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.department.modal.HrModal;
import com.employee.department.repository.HrRepository;
import com.employee.department.request.HrRequest;
import com.employee.department.response.HrResponse;

@Service
public class HrService {
    @Autowired
    private HrRepository hrRepository;

    public void saveHrData(HrRequest hrRequest) throws Exception {

        if (hrRequest == null) {
            throw new Exception("please entrer the hr data");
        }

        int size = hrRequest.getHrReq().size();

        if (size > 0) {
            for (HrModal hr : hrRequest.getHrReq()) {
                hrRepository.save(hr);
            }
        }
    }

    public HrResponse getAllHrs() {
        HrResponse hrResponse = new HrResponse();
        hrResponse.setMessage("no data found of hr");
        List<HrModal> findAll = hrRepository.findAll();
        if (findAll.size() > 0) {
            hrResponse.setHrsResp(findAll);
            hrResponse.setMessage("found hr's data recrods count: " + findAll.size());
        }
        return hrResponse;
    }

    public Optional<HrModal> getHrById(long id) throws Exception {
        Optional<HrModal> find = null;
        if (id <= 0) {
            throw new Exception("please enter valid id");
        }
        if (id > 0) {
            find = hrRepository.findById(id);
        }
        return find;
    }

    public HrModal updateHr(HrModal request) throws Exception {
        // TODO Auto-generated method stub
        HrModal save = null;
        if (request == null || request.getId() <= 0) {
            throw new Exception("please send the data with request and id");
        }

        Optional<HrModal> one = hrRepository.findById(request.getId());
        if (one.isPresent()) {
            one.get().setFirstName(request.getFirstName());
            one.get().setLastName(request.getLastName());
            one.get().setEmail(request.getEmail());
            one.get().setPhone(request.getPhone());
            one.get().setRecruited(request.getRecruited());
            save = hrRepository.save(one.get());
        }

        return save;
    }
    
    public void deleteHr(long id) throws Exception {
        if(id<= 0) {
            throw new Exception("please enter valid id to delete the Hr ");
        }
        
        hrRepository.deleteById(id);
    }
}
