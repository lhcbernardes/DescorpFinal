/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.mycompany.descorpv2.ejb.entidades.Musica;
import com.mycompany.descorpv2.ejb.entidades.Reputacao;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import servico.MusicaServico;

/**
 *
 * @author leandro
 */
public class MusicaTeste extends Teste {

    private MusicaServico musicaServico;

    @Before
    public void setUp() throws NamingException {
        musicaServico = (MusicaServico) container.getContext().lookup("java:global/classes/ejb/MusicaServico!servico.MusicaServico");
    }

    @After
    public void tearDown() {
        musicaServico = null;
    }

    @Test
    public void consultarMusicaPorTitulo() {
        assertEquals(1, musicaServico.consultarTitulos("iron man").size());
    }
    

//    @Test
//    public void persistirMusica() {
//        Musica musica = musicaServico.criar();
//        musica.setTitulo("Korn");
//        musica.setReputacao(Reputacao.BOM);
//        musica.setLink("TesteLink");
//        musica.setDuracao(Float.parseFloat("2.4"));
//        musicaServico.persistir(musica);
//        assertEquals(1, musicaServico.consultarTitulos("Korn").size());
//    }

    @Test
    public void atualizarMusica() {
        Musica musica = musicaServico.consultarPorId((long) 2);
        musica.setTitulo("Black");
        musicaServico.atualizar(musica);
        assertEquals("Black", musicaServico.consultarPorId((long) 2).getTitulo());
    }

     @Test
    public void DeleteMusica() {
        Musica musica = musicaServico.consultarPorId((long) 4);
        musicaServico.delete(musica);
        assertNull(musicaServico.consultarPorId((long) 4));
    }
}
