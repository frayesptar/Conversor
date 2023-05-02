package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class ConversorModel implements ConversorInterface {

	public Map<Integer, Conversor> llenarDatos() {
		
		Conversor c1 = new Conversor(1, "Convertir Moneda", "Moneda");
		
		c1.addTipoConversor(new TipoConversor(1, "De Soles a Dólar", 3.78142, "$"));
		c1.addTipoConversor(new TipoConversor(2, "De Soles a Euros", 4.06202, "€"));	
		c1.addTipoConversor(new TipoConversor(3, "De Soles a Libras Esterlinas", 4.60640, "£"));	
		c1.addTipoConversor(new TipoConversor(4, "De Soles a Yen Japonés", 0.0286849, "¥"));	
		c1.addTipoConversor(new TipoConversor(5, "De Soles a Won Surcoreano", 0.00288906, "₩"));
		c1.addTipoConversor(new TipoConversor(6, "De Dólar a Soles", 0.264451, "S/."));
		c1.addTipoConversor(new TipoConversor(7, "De Euros a Soles", 0.246183, "S/."));	
		c1.addTipoConversor(new TipoConversor(8, "De Libras Esterlinas a Soles", 0.217089, "S/."));	
		c1.addTipoConversor(new TipoConversor(9, "De Yen Japonés a Soles", 34.8615, "S/."));	
		c1.addTipoConversor(new TipoConversor(10, "De Won sul-coreano a Soles", 346.133, "S/."));
		
		Conversor c2 = new Conversor(2, "Convertir Temperatura", "Temperatura");
		
		c2.addTipoConversor(new TipoConversor(1, "De Celsius a Fahrenheit", 0, "°F"));
		c2.addTipoConversor(new TipoConversor(2, "De Celsius a Kelvin", 0, "K"));
		c2.addTipoConversor(new TipoConversor(3, "De Celsius a Rankine", 0, "°R"));	
		c2.addTipoConversor(new TipoConversor(4, "De Fahrenheit a Celsius", 0, "°C"));
		c2.addTipoConversor(new TipoConversor(5, "De Kelvin a Celsius", 0, "°C"));
		c2.addTipoConversor(new TipoConversor(6, "De Rankine a Celsius", 0, "°C"));		
		
		Conversor c3 = new Conversor(3, "Convertir Peso", "Peso");
		
		c3.addTipoConversor(new TipoConversor(1, "De Toneladas a Kilos", 0.001, "Kg"));
		c3.addTipoConversor(new TipoConversor(2, "De Kilos a Gramos", 0.001, "g"));
		c3.addTipoConversor(new TipoConversor(3, "De Gramos a Miligramos", 0.001, "mg"));
		c3.addTipoConversor(new TipoConversor(4, "De Miligramos a Libras", 453592.37, "lb"));
		c3.addTipoConversor(new TipoConversor(5, "De Libras a Onzas", 0.0625, "oz"));		
		c3.addTipoConversor(new TipoConversor(6, "De Kilos a Toneladas", 1000, "mt"));
		c3.addTipoConversor(new TipoConversor(7, "De Gramos a Kilos", 1000, "Kg"));
		c3.addTipoConversor(new TipoConversor(8, "De Miligramos a Gramos", 1000, "g"));
		c3.addTipoConversor(new TipoConversor(9, "De Libras a Miligramos", 0.0000022046, "mg"));
		c3.addTipoConversor(new TipoConversor(10, "De Onzas a Libras", 16, "lb"));		
		
		Conversor c4 = new Conversor(4, "Convertir Volumen", "Volumen");
		
		c4.addTipoConversor(new TipoConversor(1, "De Litros a Mililitros", 0.001, "ml"));
		c4.addTipoConversor(new TipoConversor(2, "De Mililitros a Metros Cubicos", 1000000, "m3"));
		c4.addTipoConversor(new TipoConversor(3, "De Metros Cubicos a Centimetros Cubicos", 0.000001, "cm3"));
		c4.addTipoConversor(new TipoConversor(4, "De Centimetros Cubicos a Milimetros Cubicos", 0.001, "mm3"));		
		c4.addTipoConversor(new TipoConversor(5, "De Mililitros a Litros", 1000, "l"));
		c4.addTipoConversor(new TipoConversor(6, "De Metros Cubicos a Mililitros", 0.000001, "ml"));
		c4.addTipoConversor(new TipoConversor(7, "De Centimetros Cubicos a Metros Cubicos", 1000000, "m3"));
		c4.addTipoConversor(new TipoConversor(8, "De Milimetros Cubicos a Centimetros Cubicos", 1000, "cm3"));	
		
		Conversor c5 = new Conversor(5, "Convertir Longitud", "Longitud");
		
		c5.addTipoConversor(new TipoConversor(1, "De Millas a Kilometros", 0.621371, "Km"));
		c5.addTipoConversor(new TipoConversor(2, "De Kilometros a Metros", 0.001, "m"));
		c5.addTipoConversor(new TipoConversor(3, "De Metros a Centimetros", 0.01, "cm"));
		c5.addTipoConversor(new TipoConversor(4, "De Centimetros a Milimetros", 0.1, "mm"));		
		c5.addTipoConversor(new TipoConversor(5, "De Kilometros a Millas", 1.60934, "mi"));
		c5.addTipoConversor(new TipoConversor(6, "De Metros a Kilometros", 1000, "Km"));
		c5.addTipoConversor(new TipoConversor(7, "De Centimetros a Metros", 100, "m"));
		c5.addTipoConversor(new TipoConversor(8, "De Milimetros a Centimetros", 10, "cm"));		

		Map<Integer, Conversor> mapa = new HashMap<>();
		
		mapa.put(c1.getCodigo(), c1);
		mapa.put(c2.getCodigo(), c2);
		mapa.put(c3.getCodigo(), c3);
		mapa.put(c4.getCodigo(), c4);
		mapa.put(c5.getCodigo(), c5);
		
		return mapa;
		
	}

	@Override
	public String convertirTipoConversor(int conversor, int tipoConversor, double dato, double valor) {
		
		String respuesta = null;
		double resultado = 0;
		
		switch (conversor) {
		case 1: {//Moneda
			respuesta = redondear("0.000", dato / valor);
			break;
		}
		case 2: {//Temperatura
			switch (tipoConversor) {
			case 1: {//°C - °F
				resultado = ((dato * 9) / 5) + 32;
				respuesta = redondear("0.00", resultado);
				break;
			}
			case 2: {//°C - K
				resultado = dato + 273.15;
				respuesta = redondear("0.00", resultado);
				break;
			}
			case 3: {//°C - °R
				resultado = ((dato * 9) / 5) + 491.67;
				respuesta = redondear("0.00", resultado);
				break;
			}
			case 4: {//°F - °C
				resultado = ((dato - 32) * 5) / 9;
				respuesta = redondear("0.00", resultado);
				break;
			}
			case 5: {//K - °C
				resultado = dato - 273.15;
				respuesta = redondear("0.00", resultado);
				break;
			}
			case 6: {//°R - °C
				resultado = ((dato - 491.67) * 5) / 9;
				respuesta = redondear("0.00", resultado);
				break;
			}
			default:
				throw new IllegalArgumentException("[Valor inesperado para el tipo de conversor: " + tipoConversor + "]");
			}
			break;
		}
		case 3: {//Peso
			respuesta = redondear("0.000000", dato / valor);
			break;
		}
		case 4: {//Volumen
			respuesta = redondear("0.000000", dato / valor);
			break;
		}
		case 5: {//Longitud
			respuesta = redondear("0.000", dato / valor);
			break;
		}
		default:
			throw new IllegalArgumentException("[Valor inesperado para el conversor: " + conversor + "]");
		}
		
		return respuesta;
		
	}

	@Override
	public String redondear(String formato, double resultado) {

		String respuesta = null;
		
		if (resultado % 1 == 0) {
			respuesta = String.valueOf(resultado);
			respuesta = formatoNumero(1, respuesta);
		} else {
			DecimalFormat df = new DecimalFormat(formato);
			df.setRoundingMode(RoundingMode.HALF_UP);
			respuesta = df.format(resultado);
			respuesta = formatoNumero(2, respuesta);
		}
		
		return respuesta;

	}

	@Override
	public String formatoNumero(int opcion, String resultado) {

		String respuesta = null;
		int contador = 0;
		int tamanio = resultado.length();
		int inicio = 0;
		int fin;
		
		switch (opcion) {
		case 1: {
			fin = resultado.indexOf(".");
			respuesta = String.valueOf(resultado.subSequence(inicio, fin));
			break;
		}
		case 2: {
			for (int i = 0; i < tamanio; i++) {
				
				if (resultado.charAt(tamanio-i-1) != '0') {
					break;
				}	
				
				contador++;
				
			}			
			fin = tamanio - contador;			
			respuesta = String.valueOf(resultado.subSequence(inicio, fin));			
			break;
		}		
		default:
			throw new IllegalArgumentException("[Valor inesperado: " + opcion + "]");
		}
		
		return respuesta;
		
	}

}
