package model;

import java.util.Map;

public interface ConversorInterface {

	public String convertirTipoConversor(int conversor, int tipoConversor, double dato, double valor);
	
	public String redondear(String formato, double resultado);
	
	public String formatoNumero(int opcion, String resultado);
	
}
