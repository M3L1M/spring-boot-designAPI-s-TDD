package com.melim.primerioteste;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
	
	@Mock
	List<String> lista;
	
	
	@Test 
	public void primeiroTesteMockito() {
		/*Mockito.when(lista.size()).thenReturn(2);
		int size = 0;
		if(1==1) {
			size = lista.size();
			size = lista.size();
		} */
		
		lista.size();
		lista.size();
		
		InOrder inOrder = Mockito.inOrder(lista);
		inOrder.verify(lista).size();
		inOrder.verify(lista).add("");
		
		//Assertions.assertThat(size).isEqualTo(2);
		
		//Mockito.verify(lista,Mockito.times(1)).size();
	}
}
