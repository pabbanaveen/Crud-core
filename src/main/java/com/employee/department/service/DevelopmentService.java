package com.employee.department.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.department.modal.DevelopmentModal;
import com.employee.department.repository.DevelopmentRepository;
import com.employee.department.request.DevelopmentRequest;
import com.employee.department.response.DevelopmentResponse;

@Service
public class DevelopmentService {

    @Autowired
    private DevelopmentRepository devRepo;

    public void saveDeveloper(DevelopmentRequest request) throws Exception {
        if (request == null || request.getDevelopmentReq().size() <= 0) {
            throw new Exception("Request data invalid for developer");
        }
        if (request.getDevelopmentReq().size() > 0) {
            for (DevelopmentModal dev : request.getDevelopmentReq()) {
                devRepo.save(dev);
            }
        }
    }

    public DevelopmentResponse getAllDevelopers() {
        DevelopmentResponse developmentResponse = new DevelopmentResponse();
        developmentResponse.setMessage("no data found of hr");
        List<DevelopmentModal> findAll = devRepo.findAll();
        if (findAll.size() > 0) {
            developmentResponse.setDevelopmentResponse(findAll);
            developmentResponse.setMessage("found developers data recrods count: " + findAll.size());
        }
        return developmentResponse;
    }

    public Optional<DevelopmentModal> getDeveloperById(long id) throws Exception {
        Optional<DevelopmentModal> find = null;
        if (id <= 0) {
            throw new Exception("please enter valid id for developer");
        }
        if (id > 0) {
            find = devRepo.findById(id);
        }
        return find;
    }

    public DevelopmentModal updateDeveloper(DevelopmentModal request) throws Exception {
        // TODO Auto-generated method stub
        DevelopmentModal save = null;
        if (request == null || request.getId() <= 0) {
            throw new Exception("please send the data with request and id for developer");
        }

        Optional<DevelopmentModal> one = devRepo.findById(request.getId());
        if (one.isPresent()) {
            one.get().setFirstName(request.getFirstName());
            one.get().setLastName(request.getLastName());
            one.get().setEmail(request.getEmail());
            one.get().setPhone(request.getPhone());
            one.get().setProject(request.getProject());
            save = devRepo.save(one.get());
        }

        return save;
    }

    public void deleteDeveloper(long id) throws Exception {
        if (id <= 0) {
            throw new Exception("please enter valid id to delete the developer");
        }

        devRepo.deleteById(id);
    }
}
