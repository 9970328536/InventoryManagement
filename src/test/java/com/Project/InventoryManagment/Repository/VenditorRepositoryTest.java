package com.Project.InventoryManagment.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Project.InventoryManagment.entity.Venditor;
import com.Project.InventoryManagment.repository.VenditorRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VenditorRepositoryTest {
	
	@Autowired
	private VenditorRepository venditorRepository;
	
	@Test 
	public void saveVenditor() {
		Venditor venditor = venditorRepository.save(new Venditor(52,"v8","nhnh","yyhy",55562336652L,"ggyy@gmail.com",true, null));
		
		Assertions.assertThat(venditor.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getVenditorListTest() {
		List<Venditor> venditor = venditorRepository.findAll();
		
		Assertions.assertThat(venditor.size()).isGreaterThan(0);
	}
		
	@Test
	public void getVenditorById() {
		Venditor venditor = venditorRepository.findById(106l).get();
		
		Assertions.assertThat(venditor.getId()).isEqualTo(106l);
	}
	
	@Test
	public void updateVenditorTest() {
		Venditor venditor =venditorRepository.findById(101L).get();
		
		venditor.setEmail("pooja@gmail.com");
		Venditor updated = venditorRepository.save(venditor);
		
		Assertions.assertThat(updated.getEmail()).isEqualTo("pooja@gmail.com");
	}
	
	@Test
	public void deleteVenditor() {
		Venditor ven = venditorRepository.findById(101l).get();
    	venditorRepository.delete(ven);
    	
    	Venditor venditor = null;
    	Optional<Venditor> ven1 = venditorRepository.findById(101l);
    	
    	if(ven1.isPresent()) {
    		venditor = ven1.get();
    	}
    	Assertions.assertThat(venditor).isNull();
    }
	
}
