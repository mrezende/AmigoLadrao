

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.amigoladrao.app.Sorteio;
import com.amigoladrao.app.models.Participante;


import mockit.Injectable;
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
	public void sorteiaNumero_entreZeroEZero_retornaZeroSempre() {
		
		Sorteio sorteio = new Sorteio();
		int numeroSorteado = sorteio.sorteiaNumero(0, 0);
		
		Assert.assertEquals(0, numeroSorteado);
		
	}
	
	@Test
	public void sorteiaNumero_entreUmEQuatro_retornaEntreUmEQuatro() {
		Sorteio sorteio = new Sorteio();
		int numeroSorteado = sorteio.sorteiaNumero(1, 4);
		
		boolean entreUmEQuatro = numeroSorteado >= 1 && numeroSorteado <= 4;
		
		Assert.assertTrue(entreUmEQuatro);
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
