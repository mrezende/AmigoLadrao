package com.amigoladrao.app.models;

import java.util.ArrayList;
import java.util.List;

public class Participante {
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public static Participante[] criaParticipantes(String[] nomes) {
		List<Participante> participantes = new ArrayList<Participante>();
		for (String nome: nomes) {
			Participante p = new Participante();
			p.setNome(nome);
			participantes.add(p);
		}
		return participantes.toArray(new Participante[nomes.length]);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Participante that = (Participante) o;

		return nome.equals(that.nome);

	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}
}
