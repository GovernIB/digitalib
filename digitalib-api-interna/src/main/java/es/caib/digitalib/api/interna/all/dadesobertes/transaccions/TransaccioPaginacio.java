package es.caib.digitalib.api.interna.all.dadesobertes.transaccions;

import java.util.List;

import org.fundaciobit.pluginsib.utils.rest.RestPagination;

import es.caib.digitalib.model.entity.Transaccio;

/**
 * 
 * @author anadal
 *
 */
public class TransaccioPaginacio extends RestPagination<Transaccio> {

    /**
     * 
     */
    public TransaccioPaginacio() {
        super();
    }

    /**
     * 
     * @param pagesize
     * @param page
     * @param totalpages
     * @param totalcount
     * @param data
     */
    public TransaccioPaginacio(int pagesize, int page, int totalpages, int totalcount, List<Transaccio> data) {
        super(pagesize, page, totalpages, totalcount, data);
    }

}