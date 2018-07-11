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
 * @author leandro
 */
public class CartaoTeste extends Teste {

    private CartaoServico cartaoServico;

    @Before
    public void setUp() throws NamingException {
        cartaoServico = (CartaoServico) container.getContext().lookup("java:global/classes/ejb/CartaoServico!servico.CartaoServico");
    }

    @After
    public void tearDown() {
        cartaoServico = null;
    }
    
    @Test
    public void getCartaoporBandeira() {
        List<CartaoCredito> cartaoCreditos = cartaoServico.consultarCartoesBandeira("VISA");
        assertEquals(cartaoCreditos.size(), 2);
    }

    @Test
    public void getCartaoporNumero() {
        List<CartaoCredito> cartaoCreditos = cartaoServico.consultarCartoesNumero("5555666677778884");
        assertEquals(cartaoCreditos.size(), 1);
        
    }
    
    @Test
    public void PersistCartao() {
         CartaoCredito cartaoCredito = cartaoServico.criar();
         cartaoCredito.setBandeira("MASTERCARD");
        cartaoCredito.setNumero("5297472416030205");
        cartaoCredito.setDataExpiracao(getData(15, Calendar.FEBRUARY, 2022));
        
    }
    
    private Date getData(int dia, int mes, int ano) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, dia);
        calendar.set(Calendar.MONTH, mes);
        calendar.set(Calendar.YEAR, ano);
        return calendar.getTime();
    
    }
    @Test
    public void getCartaoPorId() {
        assertNotNull(cartaoServico.consultarPorId(new Long(2)));
    }
}

