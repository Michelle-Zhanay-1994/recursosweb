/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.ClienteNoCumplio;

/**
 *
 * @author LENOVO
 */
@Stateless
public class ClienteNoCumplioFacade extends AbstractFacade<ClienteNoCumplio> {

    @PersistenceContext(unitName = "ventaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteNoCumplioFacade() {
        super(ClienteNoCumplio.class);
    }
    
}
