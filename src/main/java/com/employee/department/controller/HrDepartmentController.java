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
import org.springframework.web.bind.annotation.RestController;

import com.employee.department.modal.HrModal;
import com.employee.department.request.HrRequest;
import com.employee.department.response.HrResponse;
import com.employee.department.service.HrService;

@RestController
@CrossOrigin(origins = "*")
public class HrDepartmentController {

    @Autowired
    private HrService hrService;

    @PostMapping("/addHr")
    public ResponseEntity<String> addHr(@RequestBody HrRequest hrRequest) {
        ResponseEntity<String> resp = null;
        try {
            hrService.saveHrData(hrRequest);
            resp = new ResponseEntity<String>("added hr's data", HttpStatus.OK);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            resp = new ResponseEntity<String>("Error while saving hr's data" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return resp;

    }

    @GetMapping("/getAllHrData")
    public ResponseEntity<HrResponse> getAllHrData() {
        return new ResponseEntity<HrResponse>(hrService.getAllHrs(), HttpStatus.OK);
    }

    @GetMapping("/getHrById/{id}")
    public ResponseEntity<Optional<HrModal>> getHrById(@PathVariable long id) {
        ResponseEntity<Optional<HrModal>> resp = null;

        try {
            resp = new ResponseEntity<Optional<HrModal>>(hrService.getHrById(id), HttpStatus.OK);
        } catch (Exception e) {
            resp = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return resp;
    }
    
    @PutMapping("/updateHr")
    public ResponseEntity<HrModal> updateHr(@RequestBody HrModal request) {
        ResponseEntity<HrModal> resp = null;

        try {
            resp = new ResponseEntity<HrModal>(hrService.updateHr(request), HttpStatus.OK);
        } catch (Exception e) {
            resp = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

        return resp;
    }
    
    @DeleteMapping("/deleteHr/{id}")
    public ResponseEntity<String> deleteHr(@PathVariable long id) {
        ResponseEntity<String> resp = null;

        try {
            hrService.deleteHr(id);
            resp = new ResponseEntity<String>("Successfully delete", HttpStatus.OK);
        } catch (Exception e) {
            resp = new ResponseEntity("Not able to delete the record with error: " + e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }

        return resp;
    }
}
