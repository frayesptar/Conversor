package model;

import java.util.HashMap;
import java.util.Map;

public class Conversor extends Objeto {
	
	private Map<Integer, TipoConversor> tipoConversorMap = new HashMap<>();
	
	public Conversor(int codigo, String nombre, String shortName) {
		super(codigo, nombre, shortName);
	}	
	
	public Map<Integer, TipoConversor> getTipoConversorMap() {
		return tipoConversorMap;
	}

	public void setTipoConversorMap(Map<Integer, TipoConversor> tipoConversorMap) {
		this.tipoConversorMap = tipoConversorMap;
	}

	public void addTipoConversor(TipoConversor tipoConversorMap) {
		this.tipoConversorMap.put(tipoConversorMap.getCodigo(), tipoConversorMap);
	}
	
}
