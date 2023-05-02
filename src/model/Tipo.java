package model;

public class Tipo {

	private int codigo;
	private String nombre;
	private double valor;
	private String simbolo;
	
	public Tipo(int codigo, String nombre, double valor, String simbolo) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
		this.simbolo = simbolo;
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}	
	
	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	@Override
	public String toString() {

		return this.nombre;
		
	}
	
}
