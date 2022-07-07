package com.Project.InventoryManagment.ServiceTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
import com.Project.InventoryManagment.entity.Venditor;
import com.Project.InventoryManagment.repository.VenditorRepository;
import com.Project.InventoryManagment.service.VenditorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VenditoeServiceTest {

	@Mock
	private VenditorRepository venditorRepository;
	
	@Autowired
	@InjectMocks
	private VenditorServiceImpl venditorService;

	private Venditor venditor;
	
	private Venditor venditor1;
	private Venditor venditor2;
	List<Venditor> venditorList;

	@BeforeEach
	public void serUp() {
		venditorList = new ArrayList<>();
		
		venditor1 = new Venditor(2,"v2","Samsung","Puna");
		venditor2 = new Venditor(3,"v3","Apple","UK");
		
		venditorList.add(venditor1);
		venditorList.add(venditor2);
	}
	
	@AfterEach
	public void afterTest() {
		venditor1 = venditor2= null;
		venditorList =null;
	}
	
	
	@DisplayName("Test For saveVenditor() method")
	@Test
	public void givenVenditorToAddShouldReturnAddVenditor() {
           when(venditorRepository.save(venditor1)).thenReturn(venditor1);
				
		Venditor savedVenditor = venditorService.saveVenditor(venditor1);
		
		System.out.println(savedVenditor);
		assertThat(savedVenditor).isNotNull();
	}
	
	@Test
  public void givenExistingIdWhenSaveVenditorThenThrowsException(){
  	
  	Venditor venditor = new Venditor(2,"v2","Samsung","Puna");

      when(venditorRepository.findById(venditor.getId())).thenReturn(Optional.of(venditor));
      
      
     org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> { venditorService.saveVenditor(venditor);
  	   });
  }
	
	// To test getVenditorList() method
		@Test
		public void givenGetAllVenditorShouldReturnListOfAllVenditors()throws NoRecordFoundException {
			
			venditorRepository.saveAll(venditorList);
			
			when(venditorRepository.findAll()).thenReturn(venditorList);
			
			List<Venditor> actualVenditorList = venditorService.getVenditorList();
			
			assertThat(actualVenditorList).isEqualTo(venditorList);
			
		}
		
		@Test
		public void givenIdThenShouldReturnVenditorOfThatId() throws GivenIdNotFoundException{
			
			when(venditorRepository.findById(2L)).thenReturn(Optional.ofNullable(venditor1));
			assertThat(venditorService.getVenditorById(venditor1.getId())).isEqualTo(venditor1);
			
		}
		
		@Test
		public void givenIdToDeleteThenShouldDeleteVenditorOfThatId() {
			when(venditorRepository.findById(venditor1.getId())).thenReturn(Optional.ofNullable(venditor1));
			
	        assertThat(venditorService.deleteVenditorById(venditor1.getId())).isEqualTo("Record Deleted Succsessfully");
		}
		
		@Test
		public void givenIdToDeleteNotExistThenThrowsException()  {
			long venditorId = 2L;
			 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () -> 
		    {
	        venditorService.deleteVenditorById(venditorId);
	         });
		}
		    @DisplayName("JUnit test for updateVenditor method")
		    @Test
		    public void givenVenditorObject_whenUpdateVenditor_thenReturnUpdatedVenditor(){
		    	long id = 2L;
		        when(venditorRepository.save(venditor1)).thenReturn(venditor1);
		        when(venditorRepository.findById(id)).thenReturn(Optional.of(venditor1));
		        venditor1.setEmail("samsung@gmail.com");
		        venditor1.setSupAddress("Nashik");
		        Venditor updateVenditor = venditorService.updateVenditor(id, venditor1);
		
		        assertThat(updateVenditor.getEmail()).isEqualTo("samsung@gmail.com");
		        assertThat(updateVenditor.getSupAddress()).isEqualTo("Nashik");
		
		    }
		    
		    @Test
			public void givenIdToUpdateNotExistThenThrowsException()  {
				long venditorId = 2L;
		
				Venditor venditor= new Venditor();
		        venditor1.setEmail("samsung@gmail.com");
		        venditor1.setSupAddress("Nashik");
		        
				 org.junit.jupiter.api.Assertions.assertThrows(GivenIdNotFoundException.class, () ->
				 {
		        venditorService.updateVenditor(venditorId, venditor);
				 } 
				 );
		} 
}
