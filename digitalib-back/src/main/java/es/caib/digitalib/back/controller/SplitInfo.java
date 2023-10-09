package es.caib.digitalib.back.controller;

import java.io.File;

/**
 * 
 * @author anadal (u80067)
 *
 */
public class SplitInfo {

    public final File file;
    
    public final boolean firstPageEmpty;

    public SplitInfo(File file, boolean firstPageEmpty) {
        super();
        this.file = file;
        this.firstPageEmpty = firstPageEmpty;
    }
    
    
    
    
}
