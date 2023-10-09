package es.caib.digitalib.logic.apimassivescanwebsimple.v1.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author anadal(u80067)
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MassiveScanWebSimpleSignatureParameters {

    protected String functionaryFullName = null;

    protected String functionaryAdministrationID = null;

    protected String functionayDIR3Unit = null;

    public MassiveScanWebSimpleSignatureParameters() {
        super();
    }

    public MassiveScanWebSimpleSignatureParameters(String functionaryFullName,
            String functionaryAdministrationID, String functionayDIR3Unit) {
        super();
        this.functionaryFullName = functionaryFullName;
        this.functionaryAdministrationID = functionaryAdministrationID;
        this.functionayDIR3Unit = functionayDIR3Unit;
    }

    public String getFunctionaryFullName() {
        return functionaryFullName;
    }

    public void setFunctionaryFullName(String functionaryFullName) {
        this.functionaryFullName = functionaryFullName;
    }

    public String getFunctionaryAdministrationID() {
        return functionaryAdministrationID;
    }

    public void setFunctionaryAdministrationID(String functionaryAdministrationID) {
        this.functionaryAdministrationID = functionaryAdministrationID;
    }

    public String getFunctionayDIR3Unit() {
        return functionayDIR3Unit;
    }

    public void setFunctionayDIR3Unit(String functionayDIR3Unit) {
        this.functionayDIR3Unit = functionayDIR3Unit;
    }

}
