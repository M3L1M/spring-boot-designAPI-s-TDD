package com.melim.primerioteste;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

public class MockitoTest {
	
	@Test 
	public void primeiroTesteMockito() {
		List<String> lista=Mockito.mock(ArrayList.class);
		
		Mockito.when(lista.size()).thenReturn(2);
		
		int size = lista.size();
		
		Assertions.assertThat(size).isEqualTo(20);
		
	}
}
