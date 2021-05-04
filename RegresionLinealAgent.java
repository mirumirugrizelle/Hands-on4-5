import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import javax.swing.JOptionPane;
import java.util.*;

public class RegresionLinealAgent extends Agent {
	private Modelo regresion;
	private double y;
	private RegresionLinealGUI myGui;

	protected void setup() {
        double matriz[][] = {{23,651},{26,762},{30,856},{34,1063},{43,1190},{48,1298},{52,1421},{57,1440},{58,1518}};
		regresion = new Modelo(matriz);

		myGui = new RegresionLinealGUI(this);
		myGui.showGui();
	}

	protected void takeDown() {

		myGui.dispose();
		System.out.println("Regresion-lineal--agent terminating.");
	}

	/**
     This is invoked by the GUI when the user adds a new book for sale
	 */
	public void obtenerEcuacion(final double x) {
		addBehaviour(new OneShotBehaviour() {
			public void action() {
				regresion.setX(x);
				regresion.calcularY();
				y = regresion.getY();
				String r = regresion.toString()+"\n";
				r += ""+y;
				JOptionPane.showMessageDialog(null, r, "Regresion Lineal", JOptionPane.PLAIN_MESSAGE);
				System.out.println("y ="+y);
			}
		} );
	}
}