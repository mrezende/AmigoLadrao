package com.amigoladrao.app;

import com.amigoladrao.app.models.Participante;

import java.util.Arrays;

public class Sorteio {



	public Participante[] sorteiaOrdem(Participante[] participantes) {

		Participante[] participanteEmbaralhado = Arrays.copyOf(participantes, participantes.length);
		
		for(int i = 0; i < participanteEmbaralhado.length - 1; i++) {
			int numeroSorteado = sorteiaNumero(i, participanteEmbaralhado.length - 1);
			trocaPosicao(participanteEmbaralhado,i, numeroSorteado);
		}


		return participanteEmbaralhado;
	}

	public int sorteiaNumero(int i, int j) {
		
		// [0, 4 [ -> [1, 5 [
		int numeroSorteado = (int) (geraNumeroAleatorio() * (j - i + 1) + i);
		
		return numeroSorteado;
	}

	public double geraNumeroAleatorio() {
		return Math.random();
	}

	public void trocaPosicao(Participante[] participantes, int i, int j) {
		
		Participante aux = participantes[i];
		participantes[i] = participantes[j];
		participantes[j] = aux;
		
	}

}
