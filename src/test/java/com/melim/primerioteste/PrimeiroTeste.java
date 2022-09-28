package com.melim.primerioteste;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class PrimeiroTeste {
	@Test
	public void deveSomarDoisNumeros() {
		int n1=5,n2=1;
		Calculadora calc=new Calculadora();
		
		int resultado=calc.somar(n1, n2); 
		
		Assertions.assertThat(resultado).isEqualTo(6);
	}
	
	@Test//(expected = RuntimeException.class)
	public void naoSomarNegativo() {
		int n1=5,n2=-1;
		Calculadora calc=new Calculadora();
		
		org.junit.jupiter.api.Assertions
			.assertThrows(RuntimeException.class, () -> calc.somar(n1, n2));
		
	}
	
	@Test
	public void deveSubtrairDoisNumeros() {
		int n1=5,n2=1;
		Calculadora calc=new Calculadora();
		
		int resultado=calc.subtrair(n1, n2);
		
		Assertions.assertThat(resultado).isEqualTo(4);
	}
	
	@Test//(expected = RuntimeException.class)
	public void naoSubtrairNegativo() {
		int n1=5,n2=-1;
		Calculadora calc=new Calculadora();
		
		org.junit.jupiter.api.Assertions
			.assertThrows(RuntimeException.class, () -> calc.subtrair(n1, n2));
	}
	
	@Test
	public void deveMultiplicarDoisNumeros() {
		int n1=5,n2=1;
		Calculadora calc=new Calculadora();
		
		int resultado=calc.multiplicar(n1, n2);
		
		Assertions.assertThat(resultado).isEqualTo(5);
	}
	
	@Test//(expected = RuntimeException.class)
	public void naoMultiplicarNegativo() {
		int n1=5,n2=-1;
		Calculadora calc=new Calculadora();
		
		org.junit.jupiter.api.Assertions
			.assertThrows(RuntimeException.class, () -> calc.multiplicar(n1, n2));
					
		
	}
	
	@Test
	public void deveDividirDoisNumeros() {
		int n1=5,n2=1;
		Calculadora calc=new Calculadora();
		
		long resultado=calc.dividir(n1, n2);
		
		Assertions.assertThat(resultado).isEqualTo(5);
	}
	@Test//(expected = ArithmeticException.class)
	public void divisorDiferenteDeZero() {
		int n1=5,n2=0;
		Calculadora calc=new Calculadora();
		
		org.junit.jupiter.api.Assertions
			.assertThrows(ArithmeticException.class, () -> calc.dividir(n1, n2));
		
	}
	
	@Test//(expected = RuntimeException.class)
	public void naoDividirNegativo() {
		int n1=5,n2=-1;
		Calculadora calc=new Calculadora();
		
		org.junit.jupiter.api.Assertions
			.assertThrows(RuntimeException.class, () -> calc.dividir(n1, n2));
	}
	
	
}

class Calculadora{
	
	public int somar(int n1,int n2) {
		if(n1 < 0 || n2 < 0) {
			throw new RuntimeException("Não é permitido somar com numeros negativos");
		}
		return n1+n2;
	}
	
	public int subtrair(int n1,int n2) {
		if(n1 < 0 || n2 < 0) {
			throw new RuntimeException("Não é permitido subtrair com numeros negativos");
		}
		return n1-n2;
	}
	
	public int multiplicar(int n1,int n2) {
		if(n1 < 0 || n2 < 0) {
			throw new RuntimeException("Não é permitido multiplicar com numeros negativos");
		}
		return n1*n2;
	}
	
	public long dividir(int n1,int n2) {
		if(n1 < 0 || n2 < 0) {
			throw new RuntimeException("Não é permitido dividir com numeros negativos");
		}
		if(n2 == 0) {
			throw new ArithmeticException("Divisor não pode ser ZERO");
		}
		
		return n1/n2;
	}
}
