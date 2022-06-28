package com.Project.InventoryManagment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Project.InventoryManagment.entity.Venditor;

@Repository
@Component
public interface VenditorRepository extends JpaRepository<Venditor, Long> {

	List<Venditor> findBySupId(String supId);

	List<Venditor> findBySupAddress(String supAddress);

	List<Venditor> findBySupName(String supName);


}
