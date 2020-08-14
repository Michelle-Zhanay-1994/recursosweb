/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Otrosclientes;

/**
 *
 * @author LENOVO
 */
@Stateless
public class OtrosclientesFacade extends AbstractFacade<Otrosclientes> {

    @PersistenceContext(unitName = "ventaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OtrosclientesFacade() {
        super(Otrosclientes.class);
    }
    
}
