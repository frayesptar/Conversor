package test;

import model.ConversorModel;

public class Test02 {

	public static void main(String[] args) {
		
		ConversorModel cm = new ConversorModel();
		
		System.out.println(cm.convertirTipoConversor(3, 9, 1000, 0.0000022046));
		//String resultado = Math.round((1000/0.0000022046) * 10d) / 10d+"";
		String resultado = "453597024.4001564";
		int valor;
		valor = resultado.indexOf("0", 10);
		System.out.println("Valor: " + valor);
		System.out.println("Indice: " + resultado.indexOf("."));
		System.out.println("Resultado: "+resultado.charAt(10));
		System.out.println(resultado);
		System.out.println("Valor: "+0.001000%1);
		System.out.println("Valor Entero: "+Math.floor(1.6));
		System.out.println("Entre: "+resultado.subSequence(0, 17));
	}
	
}
