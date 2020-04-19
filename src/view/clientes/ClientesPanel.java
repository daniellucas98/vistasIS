package view.clientes;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.CardSwitcher;
import view.ModuloMenu;
import view.ModuloPanel;

public class ClientesPanel extends JPanel {
	public ClientesPanel() {
		initGUI();
	}
	private ModuloMenu clientesMenu;
	private ModuloPanel clientesFuncion;
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		CardLayout cardLayout = new CardLayout();
		clientesFuncion = new ModuloPanel(cardLayout);
		CardSwitcher switcher = new CardSwitcher(clientesFuncion, cardLayout);
		clientesMenu = new ModuloMenu(switcher, 35);
		
		addFuncion(new AltaCliente(), new JButton("     Alta cliente"), "Clientes/altacliente", "AltaCliente");
		addFuncion(new BajaCliente(), new JButton("     Baja cliente"), "Clientes/bajacliente", "BajaCliente");
		addFuncion(new AltaCliente(), new JButton("Modificar cliente"), "Clientes/modcliente", "ModificarCliente");
		addFuncion(new AltaCliente(), new JButton("     Mostrar cliente"), "Clientes/mostrarcliente", "MostrarCliente");
		addFuncion(new AltaCliente(), new JButton("     Listar clientes"), "Clientes/listarcliente", "ListarClientes");
		addFuncion(new AltaCliente(), new JButton("Historial cliente"), "Clientes/historialcliente", "HistorialCliente");
		
		add(clientesFuncion, BorderLayout.CENTER);
		add(clientesMenu, BorderLayout.NORTH);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentHidden(ComponentEvent evt) {clientesMenu.reset();
            }
        });
	}
	
	private void addFuncion(JPanel panel, JButton button, String dirIcon, String card) {
		clientesFuncion.addPanel(panel, card);
		clientesMenu.addButton(button, dirIcon, card);
	}
}
