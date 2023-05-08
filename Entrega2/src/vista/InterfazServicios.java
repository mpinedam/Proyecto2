package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import consola.Aplicacion;
import logica.GuiaTuristico;
import logica.Restaurante;
import logica.Spa;


public class InterfazServicios extends JFrame implements ActionListener{
	
	private JPanel panelWest;
	private JTextField texto_nombre;
	private JTextField texto_huesped;
	private JTextField texto_empleado;
	private JComboBox<String> opciones;
	private JButton elegirServicio;
	private JComboBox numeros;
	
	
	public String lista;
	
	
	
	private static final String  texto= "Texto_Nombre";
	private static final String  texto_empleado1= "Texto_Empleado";
	private static final String texto_huesped1="Texto_Huesped";
	private static final String opciones1= "op";
	private static final String REALIZAR_CONSULTA="REALIZAR_CONSULTA";
	private static final String REALIZAR_CONSULTA_SERVICIOS="REALIZAR_CONSULTA_SERVICIOS";
	private static final String NUMEROS="NUMEROS";
	private static final String ELEGIRSERVICIO = "ELEGIRSERVICIO";
	
	public InterfazServicios()
	{
		
		getContentPane().setBackground(new Color (134, 197, 210));
		setLayout(new BorderLayout());
		
		
		setTitle("Sistema de Servicios");
		setSize(700, 700);
		setVisible(true);
		
		
		JPanel panelNorth=new JPanel();
		add(panelNorth, BorderLayout.NORTH);
		panelNorth.setBackground(new Color(217,217,217));
		panelNorth.setPreferredSize(new Dimension(200,25));
		setVisible(true);
		
		JPanel panelSouth=new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(new Color(217,217,217));
		panelSouth.setPreferredSize(new Dimension(200,25));
		setVisible(true);
		
		panelWest=new JPanel();
		panelWest.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));
		add(panelWest, BorderLayout.WEST);
		panelWest.setBackground(new Color(96,137,175));
		panelWest.setPreferredSize(new Dimension(320,340));
		panelWest.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel panelEast=new JPanel();
		panelEast.setLayout(new FlowLayout(FlowLayout.CENTER, 10,20));
		//BoxLayout layoutbox=new BoxLayout(panelEast, BoxLayout.Y_AXIS);
		//panelEast.setLayout(layoutbox);
		add(panelEast, BorderLayout.EAST);
		panelEast.setBackground(new Color(134, 197, 210));
		panelEast.setPreferredSize(new Dimension(350,340));
		panelEast.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		//PanelEast
		JPanel bloque=new JPanel();
		
		//panelEast.add(Box.createRigidArea(new Dimension(0,30)));
		
		JLabel factura=new JLabel("Consultar una factura");
		factura.setForeground(new Color(255,255,255));
		factura.setBackground(new Color(96,137,175));
		factura.setOpaque(true);
		panelEast.add(Box.createRigidArea(new Dimension(15,0)));
		factura.setAlignmentX(Component.CENTER_ALIGNMENT);
		factura.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(factura);
		
		bloque.setPreferredSize(new Dimension(20,0));
		panelEast.add(bloque);
		
		panelEast.add(new JLabel(""));
		JLabel a=new JLabel("Nombre asociado a reserva: ");
		a.setAlignmentX(Component.CENTER_ALIGNMENT);
		a.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(a, BorderLayout.AFTER_LINE_ENDS);
		setVisible(true);
	 
		texto_nombre=new JTextField();
		texto_nombre.setPreferredSize(new Dimension (120,30));
		texto_nombre.addActionListener(this);
		texto_nombre.setActionCommand(texto);
		texto_nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		texto_nombre.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(texto_nombre);
		setVisible(true);
		
		
		
		JButton boton_nombre=new JButton("Consulta ");
		boton_nombre.setForeground(new Color(88,135,179));
		boton_nombre.addActionListener(this);
		boton_nombre.setActionCommand(REALIZAR_CONSULTA);
		boton_nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton_nombre.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelEast.add(boton_nombre);
		setVisible(true);
		
		//PanelWest
		JLabel servicio=new JLabel("Adquirir Servicio");
		servicio.setForeground(new Color(255,255,255));
		servicio.setBackground(new Color(97,110,160));
		servicio.setOpaque(true);
		
		servicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		servicio.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(servicio);
		JPanel bloque1=new JPanel();
		bloque1.setPreferredSize(new Dimension(300,0));
		panelWest.add(bloque1);
		
		
	
		JLabel b=new JLabel("Nombre Huesped: ");
		b.setAlignmentX(Component.CENTER_ALIGNMENT);
		b.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(b, BorderLayout.AFTER_LAST_LINE);
		setVisible(true);
		
		texto_huesped=new JTextField();
		texto_huesped.setPreferredSize(new Dimension (120,30));
		texto_huesped.addActionListener(this);
		texto_huesped.setActionCommand(texto_huesped1);
		texto_huesped.setAlignmentX(Component.CENTER_ALIGNMENT);
		texto_huesped.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(texto_huesped);
		setVisible(true);
		
		JLabel c=new JLabel("Nombre Empleado: ");
		c.setAlignmentX(Component.CENTER_ALIGNMENT);
		c.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(c, BorderLayout.AFTER_LAST_LINE);
		setVisible(true);
		
		texto_empleado=new JTextField();
		texto_empleado.setPreferredSize(new Dimension (120,30));
		texto_empleado.addActionListener(this);
		texto_empleado.setActionCommand(texto_empleado1);
		texto_empleado.setAlignmentX(Component.CENTER_ALIGNMENT);
		texto_empleado.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(texto_empleado);
		setVisible(true);
		
		String[] opcionesServicios = {"Restaurante Habitacion", "Restaurante", "Spa", "Guia Turistico"};
		opciones = new JComboBox<String>(opcionesServicios); 
		opciones.addActionListener(this);
		opciones.setActionCommand(opciones1);
		panelWest.add(opciones);
		setVisible(true);
		
		JButton boton_servicio=new JButton("Consulta ");
		boton_servicio.setForeground(new Color(88,135,179));
		boton_servicio.addActionListener(this);
		boton_servicio.setActionCommand(REALIZAR_CONSULTA_SERVICIOS);
		boton_servicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		boton_servicio.setAlignmentY(Component.CENTER_ALIGNMENT);
		panelWest.add(boton_servicio);
		setVisible(true);
		
		
		
		
		
		
		
		
		
		
		
	


	    
	}
	

	
	public String getConsultaFactura() {
		String nombreReserva=texto_nombre.getText();
		return nombreReserva;
	}
	
	public ArrayList<String> getServicios() {
		ArrayList<String> infoServicio = new ArrayList<String>();
		String nombreHuesped=texto_huesped.getText();
		String nombreEmpleado=texto_empleado.getText();
		infoServicio.add(nombreHuesped);
		infoServicio.add(nombreEmpleado);
		return infoServicio;
	}
	public String Servicio() {
		
		
		String servicio_solicitado=opciones.getSelectedItem().toString();
		
		String eleccion = null;
		String lista_restaurante="";
		if (servicio_solicitado=="Restaurante")
		{
			Object keys = Restaurante.mostrarPlato_restaurante().get(0);
			String keysString=keys.toString();
		
			String[] arraykeys=keysString.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
			numeros=new JComboBox();
			
	
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 385));
			panelWest.add(texto_servicios);
			panelWest.add(numeros);
			
			setVisible(true);
			
			elegirServicio = new JButton("OK");
			elegirServicio.addActionListener(this);
			elegirServicio.setActionCommand(ELEGIRSERVICIO);
			panelWest.add(elegirServicio);
			
		}
		if (servicio_solicitado=="Restaurante Habitacion")
		{
			Object keys = Restaurante.mostrarPlato_habitacion().get(0);
			String keysString=keys.toString();
			
			String[] arraykeys=keysString.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
			numeros=new JComboBox();
			
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 120));
			panelWest.add(texto_servicios);
			panelWest.add(numeros);	
				
		}
		if (servicio_solicitado=="Spa")
		{
			Object keys = Spa.mostrarMasaje().get(0);
			String keysString=keys.toString();
			
			String[] arraykeys=keysString.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
			numeros=new JComboBox();
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 200));
			panelWest.add(texto_servicios);
			panelWest.add(numeros);
			setVisible(true);
		
			
		}
		if (servicio_solicitado=="Guia Turistico")
		{
			Object keys = GuiaTuristico.mostrarPlan().get(0);
			String keysString=keys.toString();
			
			String[] arraykeys=keysString.split(",");
			List<String> listkeys=new ArrayList<>(Arrays.asList(arraykeys));
			numeros=new JComboBox();
			for (int i=0; i<listkeys.size(); i++)
			{
				lista_restaurante+=(i+1)+"."+ listkeys.get(i);
				lista_restaurante+="\n";
				numeros.addItem(i+1);
				
			}
			JTextArea texto_servicios=new JTextArea();
			texto_servicios.setText(lista_restaurante);
			texto_servicios.setPreferredSize(new Dimension(200, 200));
			panelWest.add(texto_servicios);
			panelWest.add(numeros);
			setVisible(true);
		
			
		}
	
	return eleccion;
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		if (comando.equals(REALIZAR_CONSULTA))
			System.out.println(getConsultaFactura());
		if(comando.equals(REALIZAR_CONSULTA_SERVICIOS))
			System.out.println(getServicios());
			Servicio();
		if(comando.equals(NUMEROS))
			System.out.println(Servicio());
			 
		if(comando.equals(ELEGIRSERVICIO))
			System.out.println(Restaurante.asociarNumeroRM(informacionComboBox()));
			
			 	

		
	}
	
	private int informacionComboBox() {
		int seleccionado = (int) numeros.getSelectedItem();
		
		return seleccionado;
		
	}
	
}