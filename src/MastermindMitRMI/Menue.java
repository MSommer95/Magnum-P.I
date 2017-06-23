package MastermindMitRMI;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.event.*;
//Erklärung (Zwischenstand):
//Der Codierer und der Ratende müssen beide auf Bestätigen geklickt haben, bevor die Runde beendet werden kann (Sonst NullPointerExeption)

//Menü für das Spiel (Spieler wählen ihre  Rolle)

public class Menue extends JFrame implements SpielInterface{
	private int[] farbenRaten;
	private int rightp;
	private int rightc;
	private int runde;

	private JButton codierer;
	private JButton round;

	private Codierer code;

	private MouseListener openNewWindow;
	private MouseListener closeRound;

	// Getter und Setter
	public JButton getCodierer() {
		return codierer;
	}

	public void setCodierer(JButton codierer) {
		this.codierer = codierer;
	}
	
	

	public int getRunde() {
		return runde;
	}

	public void setRunde(int runde) {
		this.runde = runde;
	}

	public int getRightp() {
		return rightp;
	}

	public void setRightp(int rightp) {
		this.rightp = rightp;
	}

	public int getRightc() {
		return rightc;
	}

	public void setRightc(int rightc) {
		this.rightc = rightc;
	}

	public Codierer getCode() {
		return code;
	}

	public void setCode(Codierer code) {
		this.code = code;
	}

	public MouseListener getOpenNewWindow() {
		return openNewWindow;
	}

	public void setOpenNewWindow(MouseListener openNewWindow) {
		this.openNewWindow = openNewWindow;
	}

	// Konstruktor für Menue
	public Menue() {
		super("Menü");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(612, 612);
		this.initialisiereKomponenten();
		this.registrierelistener();
		this.ordneKomponentenAn();
		this.setVisible(true);
	}
	// Initialisiert die Komponenten von Menue

	private void initialisiereKomponenten() {
		this.farbenRaten = new int[4];
		
		this.rightp = 0;
		this.rightc = 0;
		this.runde = 0;

		this.codierer = new JButton("Codierer");
		this.round = new JButton("Runde Beenden");

		this.openNewWindow = new OpenWindowListener();
		this.closeRound = new CloseRoundListener();
	}

	// Innere Klasse für das Öffnen eines neues Fensters
	private class OpenWindowListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == codierer) {
				openCodeWindow();

			} 

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	// Listener zum Beenden der Runde
	private class CloseRoundListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			round();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	// Controlliert das Ergebnis der Runde (Die beiden Farbarrays)
	private void round() {
		vergleich();
	}

	// Methode legt ein neues Objekt Codierer an und blendet danach den Button
	// aus
	private void openCodeWindow() {

		this.code = new Codierer();
		codierer.setVisible(false);

	}

	// Methode legt ein neues Objekt Ratende an und blendet danach den Button
	// aus

	// Übergibt den Button ihre Listener
	private void registrierelistener() {

		this.codierer.addMouseListener(this.openNewWindow);
		
		this.round.addMouseListener(this.closeRound);

	}

	// Methode zum Ordnen der Komponenten
	private void ordneKomponentenAn() {

		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);

		c.ipady = 40;
		c.ipadx = 40;
		this.getContentPane().add(codierer, c);

		c.gridy = 2;
		this.getContentPane().add(round, c);

	}

	
	
	@Override
	public boolean starteSpiel(int starter) throws RemoteException {
		 return true;
	}

	@Override
	public boolean spielzug(int f1, int f2, int f3, int f4) throws RemoteException {
		
			this.farbenRaten[0] = f1;
			this.farbenRaten[1] = f2;
			this.farbenRaten[2] = f3;
			this.farbenRaten[3] = f4;

			
		return true;
	}
	
	public void vergleich(){
		this.rightc = 0;
		this.rightp = 0;
		for (int i = 0; i < code.getCcolor().length; i++) {
			if (code.getCcolor()[i].getRGB() == this.farbenRaten[i]) {
				this.rightp++;
				this.rightc--;
			}

			for (int j = 0; j < this.farbenRaten.length; j++) {

				if (code.getCcolor()[i].getRGB() == this.farbenRaten[j]) {

					this.rightc++;
				}
			}
		}
		
		System.out.println("Richtige Farbe " + this.rightc);
		System.out.println("Richtige Position und Farbe " + this.rightp);


		this.runde++;

		if (this.rightp == 4) {

			System.out.println("Du hast gewonnen!");

		} else if (this.runde == 8) {

			System.out.println("Du hast verloren!");
		}
		
	}

}
