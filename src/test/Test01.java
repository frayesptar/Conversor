package test;

import java.util.HashMap;
import java.util.Map;

import model.Conversor;
import model.TipoConversor;

public class Test01 {

	public static void main(String[] args) {

		Conversor c1 = new Conversor(1, "Convertir Moneda", "moneda");
		
		c1.addTipoConversor(new TipoConversor(1, "Soles a Dolares", 3.50, ""));
		c1.addTipoConversor(new TipoConversor(2, "Soles a Euros", 4.50, ""));	
		
		Conversor c2 = new Conversor(2, "Convertir Temperatura", "temperatura");
		
		c2.addTipoConversor(new TipoConversor(1, "Celsius a Fahrenheit", 10, ""));
		c2.addTipoConversor(new TipoConversor(2, "Celsius a Kelvin", 20, ""));

		Map<Integer, Conversor> mapa = new HashMap<>();
		
		mapa.put(c1.getCodigo(), c1);
		mapa.put(c2.getCodigo(), c2);
		
		mapa.forEach((k, v) -> System.out.println(v));
		
		System.out.println(mapa.values());
		System.out.println(mapa.get(1).getShortName());
		System.out.println(mapa.get(1).getCodigo());
		
		Conversor conversorMap = mapa.get(1);
		
		System.out.println(conversorMap.getTipoConversorMap().get(1).getValor()*20);
		
	}

}
