package com.employee.department.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.department.modal.HrModal;

@Repository
public interface HrRepository extends JpaRepository<HrModal, Long>{

    Optional<HrModal> findById(long id);
}
