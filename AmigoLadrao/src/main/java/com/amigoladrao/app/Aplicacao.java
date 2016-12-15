package com.amigoladrao.app;

import com.amigoladrao.app.config.SorteioConfig;
import com.amigoladrao.app.config.module.SorteioConfigModule;
import com.amigoladrao.app.models.Participante;
import com.google.inject.Guice;
import com.google.inject.Injector;



/**
 * Created by marceloderezendemartins on 12/15/16.
 */
public class Aplicacao {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new SorteioConfigModule());
        SorteioConfig config = injector.getInstance(SorteioConfig.class);
        String[] nomesDosParticipantes = config.recuperaNomes();
        System.out.println("----- PARTICIPANTES ------");
        System.out.println("Ordem inicial: ");
        Participante[] participantes = Participante.criaParticipantes(nomesDosParticipantes);

        for(int i = 0; i < participantes.length; i++) {
            System.out.println(( i + 1) + " - " + participantes[i].getNome());
        }

        System.out.println("----- SORTEIO ------");
        System.out.println("Ordem final: ");
        Sorteio sorteio = injector.getInstance(Sorteio.class);
        Participante[] participantesEmbaralhados = sorteio.sorteiaOrdem(participantes);

        for(int i = 0; i < participantesEmbaralhados.length; i++) {
            System.out.println((i + 1) + " - " + participantesEmbaralhados[i].getNome());
        }


    }

}
