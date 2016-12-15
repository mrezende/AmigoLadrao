package com.amigoladrao.app.models;

import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by marceloderezendemartins on 12/15/16.
 */
@RunWith(JMockit.class)
public class ParticipanteTestes {

    @Test
    public void criaParticipantes_vetorUmElemento_retornaUmParticipante() {
        String[] nomes = { "Tio" };
        Participante[] participantes = Participante.criaParticipantes(nomes);

        Assert.assertEquals(participantes[0].getNome(), nomes[0]);
    }

    @Test
    public void criaParticipantes_vetorDoisElementos_retornaDoisParticipantes() {
        String[] nomes = { "Tio", "Tia" };
        Participante[] participantes = Participante.criaParticipantes(nomes);

        Assert.assertEquals(participantes[0].getNome(), nomes[0]);
        Assert.assertEquals(participantes[1].getNome(), nomes[1]);
    }

    @Test
    public void criaParticipantes_vetorVazio_retornaArrayVazio() {
        String[] nomes = {  };
        Participante[] participantes = Participante.criaParticipantes(nomes);

        Assert.assertEquals(0, participantes.length);

    }

}
