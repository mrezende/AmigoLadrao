package com.amigoladrao.app;



import mockit.Verifications;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.MatcherAssert.*;

import com.amigoladrao.app.Sorteio;
import com.amigoladrao.app.models.Participante;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

import java.util.Arrays;

@RunWith(JMockit.class)
public class SorteioTestes {

	@Test
	public void sorteiaNumero_geraNumeroAleatorioIgual099_retornaQuatro() {

		Sorteio sorteio = new Sorteio();
		new Expectations(sorteio) {{
			
			sorteio.geraNumeroAleatorio(); result = 0.99;
			
		}};
		
		int numeroSorteado = sorteio.sorteiaNumero(1, 4);
		
		Assert.assertEquals(4, numeroSorteado);
		
	}
	
	@Test
	public void sorteiaNumero_geraNumeroAleatorioIgualZero_retornaUm() {

		Sorteio sorteio = new Sorteio();
		new Expectations(sorteio) {{
			
			sorteio.geraNumeroAleatorio(); result = 0;
			
		}};
		
		int numeroSorteado = sorteio.sorteiaNumero(1, 4);
		
		Assert.assertEquals(1, numeroSorteado);
	}
	
	@Test
	public void sorteiaNumero_geraNumeroAleatorioIgual05_retornaTres() {

		Sorteio sorteio = new Sorteio();
		new Expectations(sorteio) {{
			
			sorteio.geraNumeroAleatorio(); result = 0.5;
			
		}};
		
		int numeroSorteado = sorteio.sorteiaNumero(1, 4);
		
		Assert.assertEquals(3, numeroSorteado);
	}
	
	@Test
	public void trocaPosicao_doisElementos_retornaTrue(@Injectable final Participante participante1, @Injectable final Participante participante2) {
		Participante[] participantes = {participante1, participante2};
		
		Sorteio sorteio = new Sorteio();
		sorteio.trocaPosicao(participantes, 0, 1);
		
		Assert.assertEquals(participantes[0], participante2);
		Assert.assertEquals(participantes[1], participante1);
		
	}

	@Test
	public void sorteiaOrdem_umParticipante_retornaMesmaOrdem() {
		String[] nomes = { "Tio" };
		Participante[] participantes = Participante.criaParticipantes(nomes);
		Sorteio sorteio = new Sorteio();
		Participante[] participantesEmbaralhados = sorteio.sorteiaOrdem(participantes);

		Assert.assertEquals(nomes[0], participantesEmbaralhados[0].getNome());

	}

	@Test
	public void sorteiaOrdem_doisParticipantes_retornaDoisParticipantes() {
		String[] nomes = { "Tio" , "Tia"};
		Participante[] participantes = Participante.criaParticipantes(nomes);
		Sorteio sorteio = new Sorteio();
		Participante[] participantesNovaOrdem = sorteio.sorteiaOrdem(participantes);

		assertThat(Arrays.asList(participantesNovaOrdem), IsIterableContainingInAnyOrder.containsInAnyOrder(participantes));

	}
	
	
	

}
