package es.caib.digitalib.api.interna.all.dadesobertes.transaccions;

import java.util.List;

import org.fundaciobit.pluginsib.utils.rest.ReuseDataPagination;



/**
 * 
 * @author anadal (u80067)
 *
 */
public class Transaccions extends ReuseDataPagination<TransaccioInfo> {

    public Transaccions() {
        super();
    }

    public Transaccions(List<TransaccioInfo> data, int page, int pagesize, int totalpages, int totalcount,
            String nextUrl, String dateDownload, String name) {
        super(data, page, pagesize, totalpages, totalcount, nextUrl, dateDownload, name);
    }

}
