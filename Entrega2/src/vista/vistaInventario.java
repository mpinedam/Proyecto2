package vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

import logica.Reserva;


public class vistaInventario extends JFrame{
	
	
	
	public vistaInventario() {
	setTitle("Inventario");
	setSize(700, 300);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(new GridLayout(4,12));
	
	

  
    for (int i = 1101; i <= 1148; i++) {
        JButton button = new JButton(String.valueOf(i));
        
        HashMap<Integer, HashMap<String, String>>totalReservas = Reserva.listaReservas;
        
        for (int m=0;m<=totalReservas.size()-1;m++) {
        	Set<Integer> numerosReservas = totalReservas.keySet();
        	for (int j=0; j<=numerosReservas.size()-1;j++) {
        		Object[] arrayReservas = numerosReservas.toArray();
        		Integer reservaActual = (Integer) arrayReservas[j];
        		HashMap<String, String> infoReserva = totalReservas.get(reservaActual);
        		String habitacion1=infoReserva.get("Habitacion1");
        		System.out.println(i);
    			System.out.println(habitacion1);
        		if (Integer.toString(i).equals(habitacion1)) {
        			
        			button.setForeground(Color.RED);
        		}
        		
        		
        	}
        		
        add(button);
	}
    
    
    	
    	
    	
    }
    
    
    
    
	
	

}
}
