/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.mycompany.descorpv2.ejb.entidades.Playlist;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import servico.PlaylistServico;

/**
 *
 * @author marcos
 */
public class PlayListTeste extends Teste {

    private PlaylistServico playlistServico;

    @Before
    public void setUp() throws NamingException {
        playlistServico = (PlaylistServico) container.getContext().lookup("java:global/classes/ejb/PlaylistServico!servico.PlaylistServico");
    }

    @After
    public void tearDown() {
        playlistServico = null;
    }

    @Test
    public void consultarPlaylistPorTitulo() {
        assertNotNull(playlistServico.consultarPlaylists("MPB"));
    }
    
    @Test
    public void pegarTodasAsPlayLists(){
        assertEquals(5, playlistServico.pegarPlayLists().size());
    }
    
     @Test
    public void DeletePlaylist() {
        Playlist playlist = playlistServico.consultarPorId(new Long(2));
        playlistServico.delete(playlist);
        assertNull(playlistServico.consultarPorId(new Long(2)));
    }

    @Test
    public void criarPlaylist() {
        Playlist play = playlistServico.criar();
        play.setTitulo("Teste");
        playlistServico.persistir(play);
        assertNotNull(playlistServico.consultarPlaylists("Teste"));
    }
}
