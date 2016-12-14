package com.amigoladrao.app;

import com.amigoladrao.app.models.Participante;

public class Sorteio {
	
	public void sorteiaOrdem(Participante[] participantes) {
		
		for(int i = 0; i < participantes.length - 1; i++) {
			int numeroSorteado = sorteiaNumero(i, participantes.length - 1);
			trocaPosicao(participantes, i, numeroSorteado);
		}
		
		
	}

	public int sorteiaNumero(int i, int j) {
		
		// [0, 4 [ -> [1, 5 [
		int numeroSorteado = (int) (Math.random() * (j - i + 1) + i);
		
		return numeroSorteado;
	}

	public void trocaPosicao(Participante[] participantes, int i, int j) {
		
		Participante aux = participantes[i];
		participantes[i] = participantes[j];
		participantes[j] = aux;
		
	}

}
