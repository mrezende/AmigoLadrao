package com.amigoladrao.app;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.amigoladrao.app.Sorteio;
import com.amigoladrao.app.models.Participante;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class SorteioTestes {
	
	@Test
	public void sortear_umElemento_RetornaTrue(@Injectable Participante participante) {
		
		Participante[] participantes = {participante};
		
		Sorteio sorteio = new Sorteio();
		
		sorteio.sorteiaOrdem(participantes);
		
		Assert.assertEquals(participantes[0], participante);

	}
	
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
	public void trocaPosicao_doisElementos_retornaTrue(@Injectable final Participante participante1, @Injectable final Participante participante2) {
		Participante[] participantes = {participante1, participante2};
		
		Sorteio sorteio = new Sorteio();
		sorteio.trocaPosicao(participantes, 0, 1);
		
		Assert.assertEquals(participantes[0], participante2);
		Assert.assertEquals(participantes[1], participante1);
		
	}
	
	
	

}
