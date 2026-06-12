package es.caib.digitalib.back.controller.admin.grafiquesestadistica;

import java.util.Map;

public class FilterModelItem {
    public String label;
    public String name;
    public String value;
    public Map<String, String> options;

    public FilterModelItem() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }
    
    
}