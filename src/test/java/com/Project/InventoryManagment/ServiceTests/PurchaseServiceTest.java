package com.Project.InventoryManagment.ServiceTests;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.Project.InventoryManagment.Exception.GivenIdNotFoundException;
import com.Project.InventoryManagment.Exception.NoRecordFoundException;
import com.Project.InventoryManagment.Exception.RecordAlreadyExistException;
import com.Project.InventoryManagment.entity.Purchase;
import com.Project.InventoryManagment.repository.PurchaseRepository;
import com.Project.InventoryManagment.service.PurchaseServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceTest {

	@Mock
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	@InjectMocks
	private PurchaseServiceImpl purchaseService;

	private Purchase purchase;
	
	private Purchase purchase1;
	private Purchase purchase2;
	List<Purchase> purchaseList;

	@BeforeEach
	public void serUp() {
		purchaseList = new ArrayList<>();
		
		purchase1 = new Purchase(5002,2,"TV",25000.0);
		purchase1 = new Purchase(5003,3,"Mobile",15000.0);
		
		purchaseList.add(purchase1);
		purchaseList.add(purchase2);
	}
	
	@AfterEach
	public void afterTest() {
		purchase1 = purchase2= null;
		purchaseList =null;
	}
	
	
	@DisplayName("Test For savePurchase() method")
	@Test
	public void givenPurchaseToAddShouldReturnAddPurchase() {
           when(purchaseRepository.save(purchase1)).thenReturn(purchase1);
				
		Purchase savedPurchase = purchaseService.savePurchase(purchase1);
		
		System.out.println(savedPurchase);
		assertThat(savedPurchase).isNotNull();
	}
	
	@Test
  public void givenExistingIdWhenSavePurchaseThenThrowsException(){
  	
  	Purchase purchase = new Purchase(5002,2,"TV",25000.0);

      when(purchaseRepository.findById(purchase.getId())).thenReturn(Optional.of(purchase));
      
      
     org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> { purchaseService.savePurchase(purchase);
  	   });
  }
	
	// To test getPurchaseList() method
		@Test
		public void givenGetAllPurchaseShouldReturnListOfAllPurchase()throws NoRecordFoundException {
			
			purchaseRepository.saveAll(purchaseList);
			
			when(purchaseRepository.findAll()).thenReturn(purchaseList);
			
			List<Purchase> actualPurchaseList = purchaseService.getPurchaseList();
			
			assertThat(actualPurchaseList).isEqualTo(purchaseList);
			
		}
		
		@Test
		public void givenIdThenShouldReturnPurchaseOfThatId() throws GivenIdNotFoundException{
			
			when(purchaseRepository.findById(5003L)).thenReturn(Optional.ofNullable(purchase1));
			assertThat(purchaseService.getPurchaseById(purchase1.getId())).isEqualTo(purchase1);
			
		}
		
		@Test
		public void givenIdToDeleteThenShouldDeletePurchaseOfThatId() {
			when(purchaseRepository.findById(purchase1.getId())).thenReturn(Optional.ofNullable(purchase1));
			
	        assertThat(purchaseService.deletePurchaseById(purchase1.getId())).isEqualTo("Record Deleted Sucsessfully");
		}
		
		@Test
		public void givenIdToDeleteNotExistThenThrowsException()  {
			long purchaseId = 5002L;
			 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () -> 
		    {
	        purchaseService.deletePurchaseById(purchaseId);
	         });
		}
		    @DisplayName("JUnit test for updatePurchase method")
		    @Test
		    public void givenPurchaserObject_whenUpdatePurchase_thenReturnUpdatedPurchase(){
		    	long id = 5002L;
		        when(purchaseRepository.save(purchase1)).thenReturn(purchase1);
		        when(purchaseRepository.findById(id)).thenReturn(Optional.of(purchase1));
		        purchase1.setUnitPrice(25000.0);
		        purchase1.setTotalCost(25000.0);
		        Purchase updatePurchase = purchaseService.updatePurchaseById(id, purchase1);
		
		        assertThat(updatePurchase.getUnitPrice()).isEqualTo(25000.0);
		        assertThat(updatePurchase.getTotalCost()).isEqualTo(25000.0);
		
		    }
		    
		    @Test
			public void givenIdToUpdateNotExistThenThrowsException()  {
				long purchaseId = 5002L;
		
				Purchase purchase= new Purchase();
				purchase1.setUnitPrice(25000.0);
		        purchase1.setTotalCost(25000.0);
		        
				 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () ->
				 {
		        purchaseService.updatePurchaseById(purchaseId, purchase);
				 } 
				 );
		} 
}
