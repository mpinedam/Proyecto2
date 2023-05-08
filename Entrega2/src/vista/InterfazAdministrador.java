
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class InterfazAdministrador extends JFrame implements ActionListener{
	
	
	private static final String FUNCIONALIDAD = "FUNCIONALIDAD";
	private JComboBox<String> funcionalidad;

	public  InterfazAdministrador()
	{
		
		getContentPane().setBackground(new Color (134, 197, 210));
		setLayout(new BorderLayout());
		
		setTitle("Administrador");
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel selusu = new JLabel("Seleccione que desea realizar: ");
		add(selusu, BorderLayout.CENTER);
		
		String[] opcionesFuncionalidad = {"Cambiar Tarifa Habitaciones", "Cambiar Tarifa Servicios", "Visualizar Inventario"};
		funcionalidad = new JComboBox<String>(opcionesFuncionalidad); 
		funcionalidad.addActionListener(this);
		funcionalidad.setActionCommand(FUNCIONALIDAD);
		
		add(funcionalidad, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(FUNCIONALIDAD));
		Object funcionalidadele = funcionalidad.getSelectedItem();
		String seleccionado = funcionalidadele.toString();
		if (seleccionado == "Cambiar Tarifa Habitaciones") {
			new InterfazCambioTarifa();
			setVisible(false);
		}
		if (seleccionado == "Cambiar Tarifa Servicios") {
			new InterfazCambiarServicios();
			setVisible(false);
		}
		if (seleccionado == "Visualizar Inventario") {
			new InterfazVisualizarInventario();
			setVisible(false);
		}
		
			
		
	}

}
