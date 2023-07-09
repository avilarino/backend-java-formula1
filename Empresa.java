package Formula1;

import java.util.ArrayList;


public class Empresa {
	
	String nombre;
	ArrayList <Carrera> carreras = new ArrayList<>();

	ArrayList<Piloto> pilotosEnCarrera = new ArrayList<>();
	
	Empresa(String nombre){
		this.nombre = nombre;
		this.carreras = carreras;
	}

	
	public Carrera buscarCarrera(String fecha){
		
		Carrera carreraBuscada = null;
		int i = 0 ;
		
		while(i < this.carreras.size() && carreraBuscada == null ) {
			if(this.carreras.get(i).getFecha().equalsIgnoreCase(fecha)) {
				carreraBuscada = this.carreras.get(i);
			}
			i++;
		}
			return carreraBuscada;
	}

	public boolean agregarCarrera(String fecha, int hora, Dificultad dificultad, int cantVueltas, int cantPilotos) {
		
		Carrera carreraBuscada = this.buscarCarrera(fecha);
		boolean agregado = false;
		
		if(carreraBuscada == null) {
			Carrera carreraNueva = new Carrera(fecha,hora,dificultad,cantVueltas,cantPilotos);
			this.carreras.add(carreraNueva);
			agregado = true;
		}
		return agregado;
			
	}
	
	
	public ArrayList<Piloto> pilotosPorCarrera() {
	    

	    for (Carrera carrera : carreras) {
	        ArrayList<Piloto> pilotosCarrera = carrera.getPilotos();

	        for (Piloto piloto : pilotosCarrera) {
	            if (!pilotosEnCarrera.contains(piloto)) {
	                pilotosEnCarrera.add(piloto);
	            }
	        }
	    }

	    return pilotosEnCarrera;
	}
		
		
		
		
	}
	
	
	

