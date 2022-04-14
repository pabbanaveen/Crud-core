package com.employee.department.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.department.modal.DevelopmentModal;
import com.employee.department.request.DevelopmentRequest;
import com.employee.department.response.DevelopmentResponse;
import com.employee.department.service.DevelopmentService;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/develop")
public class DevelopmentDepartmentController {

    @Autowired
    private DevelopmentService devService;

    @PostMapping("/addDeveloper")
    public ResponseEntity<String> saveDeveloper(@RequestBody DevelopmentRequest request) {
        ResponseEntity<String> response = null;
        try {
            devService.saveDeveloper(request);
            response = new ResponseEntity<String>("successfully add the developer", HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            response = new ResponseEntity<String>("Unable to add developer " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("/getAllDevelopers")
    public ResponseEntity<DevelopmentResponse> getAllDevelopers() {
        return new ResponseEntity<DevelopmentResponse>(devService.getAllDevelopers(), HttpStatus.OK);
    }

    @GetMapping("/getDeveloperById/{id}")
    public ResponseEntity<Optional<DevelopmentModal>> getDeveloperById(@PathVariable long id) {
        ResponseEntity<Optional<DevelopmentModal>> resp = null;

        try {
            resp = new ResponseEntity<Optional<DevelopmentModal>>(devService.getDeveloperById(id), HttpStatus.OK);
        } catch (Exception e) {
            resp = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }

    @PutMapping("/updateDeveloper")
    public ResponseEntity<DevelopmentModal> updateDeveloper(@RequestBody DevelopmentModal request) {
        ResponseEntity<DevelopmentModal> resp = null;

        try {
            resp = new ResponseEntity<DevelopmentModal>(devService.updateDeveloper(request), HttpStatus.OK);
        } catch (Exception e) {
            resp = new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return resp;
    }

    @DeleteMapping("/deleteDeveloper/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable long id) {
        ResponseEntity<String> resp = null;

        try {
            devService.deleteDeveloper(id);
            resp = new ResponseEntity<String>("Successfully delete", HttpStatus.OK);
        } catch (Exception e) {
            resp = new ResponseEntity("Not able to delete the record with error: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

        return resp;
    }

}
