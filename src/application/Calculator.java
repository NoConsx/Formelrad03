package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
		
		int inputCounter = 0;
		
		if(leistung != 0.0) {
			inputCounter++;
		}
		if(spannung != 0.0) {
			inputCounter++;
		}
		if(strom != 0.0) {
			inputCounter++;
		}
		if(widerstand != 0.0) {
			inputCounter++;
		}
		
		if(inputCounter > 2) {
			System.out.println("Error: Do not add more than 2 inputs");
			System.out.println("Inputs added : " + inputCounter);
			
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Input Error");
	        alert.setHeaderText("ERROR: TO MANY INPUTS (" + inputCounter + ")");
	        alert.setContentText("Please make sure you only add two inputs");
	 
	        alert.showAndWait();
		}
		
		if(getLeistung() == 0 && getSpannung() != 0 && getStrom() != 0) {
			leistung = pAusUundI(spannung, strom);
		}
		
		if(getLeistung() == 0 && getWiderstand() != 0 && getStrom() != 0) {
			leistung = pAusRundI(widerstand, strom);
		}
		
		if(getLeistung() == 0 && getSpannung() != 0 && getWiderstand() != 0) {
			leistung = pAusUundR(spannung, widerstand);
		}
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */
	
	public double pAusUundI(double u, double i) {
		 return u*i;
		}
	
	public double pAusRundI(double r, double i) {
		 return r*(i*i);
		}
	
	public double pAusUundR(double u, double r) {
		 return (u*u)/r;
		}

}