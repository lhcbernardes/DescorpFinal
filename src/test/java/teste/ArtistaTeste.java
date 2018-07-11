/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.mycompany.descorpv2.ejb.entidades.Artista;
import javax.naming.NamingException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import servico.ArtistaServico;

/**
 *
 * @author leandro
 */
public class ArtistaTeste extends Teste {

    private ArtistaServico artistaServico;

    @Before
    public void setUp() throws NamingException {
        artistaServico = (ArtistaServico) container.getContext().lookup("java:global/classes/ejb/ArtistaServico!servico.ArtistaServico");
    }

    @After
    public void tearDown() {
        artistaServico = null;
    }

    @Test
    public void consultarArtistaPorNome() {
        assertEquals(1, artistaServico.consultarArtistas("Metallica").size());
    }

    @Test
    public void consultarArtistaPorPais() {
        assertEquals(2, artistaServico.consultarPorPais("BRA").size());
    }
    
    @Test
    public void consultarArtistaPorIdViaNamedQuery() {
        assertEquals(1, artistaServico.consultarEntidades(new Object[] {Long.parseLong("2")}, Artista.ARTISTA_POR_ID).size());
    }
    
    @Test
    public void consultarArtistaPorTituloViaNamedQuery(){
        assertEquals(1, artistaServico.consultarEntidades(new Object[]{"Metallica"}, Artista.ARTISTA_POR_NOME).size());
    }
    
    @Test
    public void persistirArtista() {
        Artista artista = artistaServico.criar();
        artista.setNome("Korn");
        artista.setPais("EUA");
        artistaServico.persistir(artista);
        assertEquals(1, artistaServico.consultarArtistas("Korn").size());
    }

    @Test
    public void atualizarArtista() {
        Artista artista = artistaServico.consultarPorId((long) 2);
        artista.setNome("Black");
        artistaServico.atualizar(artista);
        assertEquals("Black", artistaServico.consultarPorId((long) 2).getNome());
    }

     @Test
    public void DeleteArtista() {
        Artista artista = artistaServico.consultarPorId((long) 4);
        artistaServico.delete(artista);
        assertNull(artistaServico.consultarPorId((long) 4));
    }
}
