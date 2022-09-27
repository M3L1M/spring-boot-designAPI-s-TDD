package com.melim.primerioteste;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {
	private List<Pessoa> pessoa;

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	public CadastroPessoa() {
		this.pessoa = new ArrayList<>();
	}

	public void adicionar(Pessoa pessoa) {
		if(pessoa.getNome()==null) {
			throw new PessoaSemNomeException();
		}
		this.pessoa.add(pessoa);
		
	}

	public void remover(Pessoa pessoa) {
		
		if(this.pessoa.isEmpty()) {
			throw new CadastroVazioException();
		}
		
		this.pessoa.remove(pessoa);
		
	}
	
	
}
