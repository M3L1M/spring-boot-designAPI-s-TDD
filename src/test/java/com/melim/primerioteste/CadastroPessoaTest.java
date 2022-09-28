package com.melim.primerioteste;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroPessoaTest {
	
	@Test
	@DisplayName("Deve criar o cadastro de uma pessoa")
	public void deveCadastrarUmaPessoa() {
		//Cenario e Execução
		CadastroPessoa cadastro=new CadastroPessoa();
		
		//Verificação
		Assertions.assertThat(cadastro.getPessoa()).isEmpty();
	}
	
	@Test
	@DisplayName("Deve adicionar uma pessoa")
	public void deveAdicionarUmaPessoa() {
		//Cenario
		CadastroPessoa cadastroPessoa = new CadastroPessoa();
		Pessoa pessoa=new Pessoa();
		pessoa.setNome("Gabriel");
		//Execução
		cadastroPessoa.adicionar(pessoa);
		
		//Verificação
		Assertions
			.assertThat(cadastroPessoa.getPessoa())
			.isNotEmpty()
			.hasSize(1)
			.contains(pessoa);
	}
	
	@Test//(expected = PessoaSemNomeException.class)
	@DisplayName("Não deve adicionar uma pessoa com o nome vazio")
	public void naoDeveAdicionarPessoaComNomeVazio() {
		//Cenario
		CadastroPessoa cadastroPessoa = new CadastroPessoa();
		Pessoa pessoa=new Pessoa();
		//Execução
		org.junit.jupiter.api.Assertions
					.assertThrows(PessoaSemNomeException.class,() -> cadastroPessoa.adicionar(pessoa));
	}
	
	@Test
	@DisplayName("Deve remover uma pessoa")
	public void deveRemoverPessoa() {
		//Cenario
		CadastroPessoa cadastroPessoa = new CadastroPessoa();
		Pessoa pessoa=new Pessoa();
		pessoa.setNome("Gabriel");
		cadastroPessoa.adicionar(pessoa);
		//Execução
		cadastroPessoa.remover(pessoa);
		
		//Verificação
		Assertions.assertThat(cadastroPessoa.getPessoa()).isEmpty();
	}
	
	@Test//(expected = CadastroVazioException.class)
	@DisplayName("Deve lançar um erro ao tentar remover uma pessoa que nao existe")
	public void deveLancarErroAoTentarRemoverPessoaInexistente() {
		//Cenario
		CadastroPessoa cadastroPessoa=new CadastroPessoa();
		Pessoa pessoa=new Pessoa();
		
		//Execução
		
		org.junit.jupiter.api.Assertions
			.assertThrows(CadastroVazioException.class, () -> cadastroPessoa.remover(pessoa));
		
	}
}
