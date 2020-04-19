package view.personal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.CardSwitcher;
import view.ModuloMenu;
import view.ModuloPanel;
import view.clientes.AltaCliente;
import view.clientes.BajaCliente;

public class PersonalPanel extends JPanel {
	public PersonalPanel() {
		initGUI();
	}
	private ModuloMenu personalMenu;
	private ModuloPanel personalFuncion;
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		CardLayout cardLayout = new CardLayout();
		personalFuncion = new ModuloPanel(cardLayout);
		CardSwitcher switcher = new CardSwitcher(personalFuncion, cardLayout);
		personalMenu = new ModuloMenu(switcher, 45);
		
		addFuncion(new AltaEmpleado(), new JButton("   Alta empleado"), "Personal/altaempleado", "AltaCliente");
		addFuncion(new BajaEmpleado(), new JButton("   Baja empleado"), "Personal/bajaempleado", "BajaCliente");
		addFuncion(new ModEmpleado(), new JButton("Modificar empleado"), "Personal/modempleado", "ModificarEmpleado");
		addFuncion(new BajaCliente(), new JButton("  Mostrar empleado"), "Personal/mostrarempleado", "MostrarEmpleado");
		addFuncion(new BajaCliente(), new JButton("   Listar empleado"), "Personal/listarempleado", "ListarClientes");
		addFuncion(new BajaCliente(), new JButton("Historial empleado"), "Personal/historialempleado", "HistorialCliente");
		
		add(personalFuncion, BorderLayout.CENTER);
		add(personalMenu, BorderLayout.NORTH);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent evt) {personalMenu.reset();}
        });
	}
	
	private void addFuncion(JPanel panel, JButton button, String dirIcon, String card) {
		personalFuncion.addPanel(panel, card);
		personalMenu.addButton(button, dirIcon, card);
	}
}