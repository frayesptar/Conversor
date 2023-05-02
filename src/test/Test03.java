package test;

public class Test03 {

	public static void main(String[] args) {
		
		String number = "0.001000";
		int cont = 0;
		char indice;
		
		System.out.println("Cantidad: " + number.length());
		
		for (int i = 0; i < number.length(); i++) {
			System.out.println("i: " + i + " || Tamaño: " + (number.length()-i-1));
			//indice = number.indexOf("0", number.length()-i-1);
			indice = number.charAt(number.length()-i-1);
			System.out.println("Indice: " + indice);
			if (indice != '0') {
				break;
			}
			cont++;
		}
		
		System.out.println("Contador: "+cont);
		
	}
	
}
