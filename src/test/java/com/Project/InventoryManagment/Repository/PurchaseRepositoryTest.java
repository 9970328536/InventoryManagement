package com.Project.InventoryManagment.Repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Project.InventoryManagment.entity.Purchase;
import com.Project.InventoryManagment.repository.PurchaseRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class PurchaseRepositoryTest {
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Test
	public void savePurchaseTest() {
		
		Purchase purchase = purchaseRepository.save(new Purchase(25,52,null, "tv","jnnn",5225,412, null));
		
	          Assertions.assertThat(purchase.getId()).isGreaterThan(0);
	}
	
	@Test
    public void getPurchaseListTest() {
    	List<Purchase> purchase = purchaseRepository.findAll();
    	
    	Assertions.assertThat(purchase.size()).isGreaterThan(0);
    }

	@Test
    public void getPurchaseByIdTest() {
    	Purchase purchase = purchaseRepository.findById(552l).get();
    	
        Assertions.assertThat(purchase.getId()).isEqualTo(552l);
    }
	
	 @Test
	    public void deletePurchase() {
	    	Purchase purch = purchaseRepository.findById(552L).get();
	    	purchaseRepository.delete(purch);
	    	
	    	Purchase purchase = null;
	    	Optional<Purchase> purch1 = purchaseRepository.findById(552l);
	    	
	    	if(purch1.isPresent()) {
	    		purchase = purch1.get();
	    	}
	    	Assertions.assertThat(purchase).isNull();
	    }
	 
	 @Test
	    public void updatePurchaseTest() {
	    	Purchase purchase = purchaseRepository.findById(552L).get();
	    	
	    	purchase.setTotalCost(2552);
	    	Purchase updated = purchaseRepository.save(purchase);
	    	
	        Assertions.assertThat(updated.getTotalCost()).isEqualTo(2552);

	    }
	    
	}


