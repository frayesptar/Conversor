package controller;

import java.util.Map;

import model.Conversor;
import model.ConversorModel;

public class ConversorController {

	public Map<Integer, Conversor> llenarDatos() {
		
		ConversorModel cm = new ConversorModel();
		Map<Integer, Conversor> mapaController=  cm.llenarDatos();
		
		return mapaController;
		
	}
	
	public String convertirTipoConversor(int conversor, int tipoConversor, double dato, double valor) {
		
		ConversorModel cm = new ConversorModel();
		
		return cm.convertirTipoConversor(conversor, tipoConversor, dato, valor);
		
	}
	
	
}
