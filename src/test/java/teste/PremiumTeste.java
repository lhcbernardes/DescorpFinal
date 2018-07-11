/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import com.mycompany.descorpv2.ejb.entidades.CartaoCredito;
import com.mycompany.descorpv2.ejb.entidades.Premium;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import servico.CartaoServico;
import servico.PremiumServico;

/**
 *
 * @author marcos
 */
public class PremiumTeste extends Teste {

    private PremiumServico premiumServico;
    private CartaoServico cartaoServico;

    @Before
    public void setUp() throws NamingException {
        cartaoServico = (CartaoServico) container.getContext().lookup("java:global/classes/ejb/CartaoServico!servico.CartaoServico");
        premiumServico = (PremiumServico) container.getContext().lookup("java:global/classes/ejb/PremiumServico!servico.PremiumServico");
    }

    @After
    public void tearDown() {
        premiumServico = null;
    }

    @Test
    public void getPremiumsPorCartao() {
        List<Premium> premiums = premiumServico.consultarPremiumscartao("VISA");
        assertEquals(premiums.size(), 2);
    }

    @Test
    public void getPremiumPorId() {
        assertNotNull(premiumServico.consultarPorId(new Long(2)));
    }

    private Date getData(int dia, int mes, int ano) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes);
        calendar.set(Calendar.YEAR, ano);
        return calendar.getTime();
    }

    @Test
    public void existePremium() {
        Premium premium = premiumServico.criar();
        premium.setNome("Leo");
        assertTrue(premiumServico.existe(premium));
    }

@Test
    public void atualizar() {
        Premium premium = premiumServico.consultarPorId(new Long(1));
        premium.setSenha("LucasS");
        premiumServico.atualizar(premium);
        premium = premiumServico.consultarPorId(new Long(1));
        assertEquals("LucasS", premium.getSenha());
    }

}
