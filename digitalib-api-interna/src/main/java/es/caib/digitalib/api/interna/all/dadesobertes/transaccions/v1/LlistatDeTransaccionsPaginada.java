package es.caib.digitalib.api.interna.all.dadesobertes.transaccions.v1;

import java.util.List;

import org.fundaciobit.pluginsib.utils.rest.ReuseDataPagination;



/**
 * 
 * @author anadal (u80067)
 *
 */
public class LlistatDeTransaccionsPaginada extends ReuseDataPagination<TransaccioInfo> {

    public LlistatDeTransaccionsPaginada() {
        super();
    }

    public LlistatDeTransaccionsPaginada(List<TransaccioInfo> data, int page, int pagesize, int totalpages, int totalcount,
            String nextUrl, String dateDownload, String name) {
        super(data, page, pagesize, totalpages, totalcount, nextUrl, dateDownload, name);
    }

}
