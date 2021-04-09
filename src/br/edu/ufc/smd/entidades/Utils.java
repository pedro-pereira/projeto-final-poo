package br.edu.ufc.smd.entidades;

public final class Utils {
	
    public static String formatarRegistroCRM(String registro) {
        return "CRM " + '/' + registro;
    }
    
    public static String formatarRegistroCoren(String registro) {
        return "COREN " + '.' + registro;
     }
}
