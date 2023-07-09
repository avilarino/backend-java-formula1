package Formula1;

import java.util.ArrayList;

public class Piloto {
	
	String nombre;
	String dni;
	int cantVueltas;
	ArrayList <Vuelta> vueltas = new ArrayList<>();
	
	public Piloto(String nombre, String dni, int cantVueltas) {
		
		this.nombre = nombre;
		this.dni = dni;
		this.cantVueltas = cantVueltas;
		this.vueltas = vueltas;
	}
	
	
	public void agregarVuelta(double tiempo) {
	    Vuelta nuevaVuelta = new Vuelta(tiempo);
	    vueltas.add(nuevaVuelta);
	}
	
	public String getNombre() {
		return nombre;
	}
	

	public String getDni() {
		return dni;
	}


	public int getCantVueltas() {
		return cantVueltas;
	}


	public double calcularVueltaPromedio() {
		
		double suma = 0;
		double promedio = 0;
		
		for(Vuelta vuelta : vueltas) {
			
			suma = suma + vuelta.getTiempo();
			promedio = suma / vueltas.size();
			
		}
		
		return promedio;
		
	}
	
	
	
	
	
	
	
	

}
