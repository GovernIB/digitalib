package es.caib.digitalib.api.interna.all.dadesobertes.transaccions;

import java.util.List;

import org.fundaciobit.pluginsib.utils.rest.OpenDataPagination;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class Transaccions extends OpenDataPagination<TransaccioInfo> {

    public Transaccions() {
        super();
    }

    public Transaccions(List<TransaccioInfo> data, int page, int pagesize, int totalpages, int totalcount,
            String nextUrl, String dateDownload) {
        super(data, page, pagesize, totalpages, totalcount, nextUrl, dateDownload);
    }

}