package com.employee.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.department.modal.DevelopmentModal;

@Repository
public interface DevelopmentRepository extends JpaRepository<DevelopmentModal, Long>{

}
