package model;

public class Objeto {

	private int codigo;
	private String nombre;
	private String shortName;
	
	public Objeto(int codigo, String nombre, String shortName) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.shortName = shortName;
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
	
	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
	
}
