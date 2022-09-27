package com.melim.primerioteste;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoaTest {
	
	@Test
	public void deveCadastrarUmaPessoa() {
		//Cenario e Execução
		CadastroPessoa cadastro=new CadastroPessoa();
		
		//Verificação
		Assertions.assertThat(cadastro.getPessoa()).isEmpty();
	}
	
	@Test
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
	
	@Test(expected = PessoaSemNomeException.class)
	public void naoDeveAdicionarPessoaComNomeVazio() {
		//Cenario
		CadastroPessoa cadastroPessoa = new CadastroPessoa();
		Pessoa pessoa=new Pessoa();
		//Execução
		cadastroPessoa.adicionar(pessoa);
	}
	
	@Test
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
	
	@Test(expected = CadastroVazioException.class)
	public void deveLancarErroAoTentarRemoverPessoaInexistente() {
		//Cenario
		CadastroPessoa cadastroPessoa=new CadastroPessoa();
		Pessoa pessoa=new Pessoa();
		
		//Execução
		cadastroPessoa.remover(pessoa);
		
	}
}
