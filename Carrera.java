package Formula1;

import java.util.ArrayList;

public class Carrera {

	String fecha;
	int hora;
	Dificultad dificultad;
	int cantVueltas;
	int cantPilotos;
	
	ArrayList <Piloto> pilotosPorDebajoDe = new ArrayList<>();
	ArrayList <Piloto> pilotos = new ArrayList<>();
	
	
	public Carrera(String fecha, int hora, Dificultad dificultad, int cantVueltas, int cantPilotos) {
	
		this.fecha = fecha;
		this.hora = hora;
		this.dificultad = dificultad;
		this.cantVueltas = cantVueltas;
		this.cantPilotos = cantPilotos;
	}


	public String getFecha() {
		return fecha;
	}
	
	
	
	public ArrayList<Piloto> getPilotos() {
		return pilotos;
	}


	public Piloto buscarPiloto(String nombre){
		
		Piloto pilotoBuscado = null;
		int i = 0 ;
		
		while(i < this.pilotos.size() && pilotoBuscado == null ) {
			if(this.pilotos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				pilotoBuscado = this.pilotos.get(i);
			}
			i++;
		}
			return pilotoBuscado;
	}

	public boolean agregarPiloto(String nombre, String dni, int cantVueltas) {
		
		Piloto pilotoBuscado = this.buscarPiloto(nombre);
		boolean agregado = false;
		
		if(pilotoBuscado == null) {
			Piloto pilotoNuevo = new Piloto(nombre,dni,cantVueltas);
			this.pilotos.add(pilotoNuevo);
			agregado = true;
		}
		return agregado;
			
	}
	
	
	public ArrayList <Piloto>  buscarPilotoPorDebajoDe(String nombre, double segundos) {
		
		Piloto pilotoBuscar = this.buscarPiloto(nombre);
		
		if(pilotoBuscar != null && pilotoBuscar.getCantVueltas() <= 10 && pilotoBuscar.calcularVueltaPromedio() < segundos) {
			pilotosPorDebajoDe.add(pilotoBuscar);
		}
		
		return pilotosPorDebajoDe;
		
		
	}
	
	double MIN = 9999999;
	double total = 0;
	
	public void mostrarMenorPromedio() {
		
		Piloto pilotoMenorPromedio = null;
		
		if(!pilotos.isEmpty()) {
		
			for(Piloto piloto : pilotos) {
				
				if(piloto.calcularVueltaPromedio() < MIN) {
					total = piloto.calcularVueltaPromedio();
					pilotoMenorPromedio = piloto;
					
				}
			
			}
		}
		
		System.out.print(pilotoMenorPromedio.getNombre());
		System.out.print(pilotoMenorPromedio.getDni());
		
	}
	
	
}
