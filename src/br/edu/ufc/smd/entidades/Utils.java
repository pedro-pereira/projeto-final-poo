package br.edu.ufc.smd.entidades;

public final class Utils {
	
    public static String formatarRegistroCRM(String registro) {
        return registro + '/' + registro;
    }
    
    public static String formatarRegistroCoren(String registro) {
        return registro + '.' + registro;
     }
}
