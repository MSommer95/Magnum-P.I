package Mastermind;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
//Erklärung (Zwischenstand):
//Der Codierer und der Ratende müssen beide auf Bestätigen geklickt haben, bevor die Runde beendet werden kann (Sonst NullPointerExeption)

//Menü für das Spiel (Spieler wählen ihre  Rolle)

public class Menue extends JFrame {

	private int rightp;
	private int rightc;
	private int runde;

	private JButton codierer;
	private JButton ratende;
	private JButton round;

	private Codierer code;
	private Ratende raten;

	private MouseListener openNewWindow;
	private MouseListener closeRound;

	// Getter und Setter
	public JButton getCodierer() {
		return codierer;
	}

	public void setCodierer(JButton codierer) {
		this.codierer = codierer;
	}

	public JButton getRatende() {
		return ratende;
	}

	public void setRatende(JButton ratende) {
		this.ratende = ratende;
	}

	public Codierer getCode() {
		return code;
	}

	public void setCode(Codierer code) {
		this.code = code;
	}

	public Ratende getRaten() {
		return raten;
	}

	public void setRaten(Ratende raten) {
		this.raten = raten;
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

		this.rightp = 0;
		this.rightc = 0;
		this.runde = 0;

		this.codierer = new JButton("Codierer");
		this.ratende = new JButton("Ratende");
		this.round = new JButton("Runde Beenden");

		this.openNewWindow = new OpenWindowListener();
		this.closeRound = new CloseRoundListener();
	}

	// Innere Klasse für das Öffnen eines neues Fensters
	private class OpenWindowListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == codierer) {
				openCodeWindow();

			} else if (e.getSource() == ratende) {
				openRatenWindow();
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
		controllFarbe();
		if (code.getBestätigt() > 0 && raten.getBestätigt() > 0) {

			for (int i = 0; i < code.getCcolor().length; i++) {

				if (code.getCcolor()[i] == raten.getRcolor()[i]) {
					this.rightp++;
					this.rightc--;
				}

				for (int j = 0; j < raten.getRcolor().length; j++) {

					if (code.getCcolor()[i] == raten.getRcolor()[j]) {

						this.rightc++;
					}
				}
			}

			System.out.println("Richtige Farbe " + this.rightc);
			System.out.println("Richtige Position und Farbe " + this.rightp);

			this.runde++;

			if (this.rightp == 4) {
				sichtbar();
				System.out.println("Du hast gewonnen!");

			} else if (this.runde == 8) {
				sichtbar();
				System.out.println("Du hast verloren!");
				
				
			}
			
			raten.getRundeAnzeige().setText(raten.getRundeAnzeigeText()[this.runde]);
			raten.getTips1().setText("Richtige Farbe: " + this.rightc);
			raten.getTips2().setText("Richtige Farbe & Position: " + this.rightp);
			code.getRundeAnzeige().setText(code.getRundeAnzeigeText()[this.runde]);
			this.rightc = 0;
			this.rightp = 0;
			
		} else
			System.out.println("Beide Spieler müssen ihre Farbfolge bestätigt haben!");
	}

	public void sichtbar(){
		for(int i = 0; i<=code.getCcolor().length-1;i++){
			raten.getButtonsammler()[i+32].setVisible(true);
		}
	}
	public void controllFarbe(){
		for(int i = 0; i<=code.getCcolor().length-1;i++){
		raten.getButtonsammler()[i+32].setBackground(code.getCcolor()[i]);
		
		
		}
	}
	
	// Methode legt ein neues Objekt Codierer an und blendet danach den Button
	// aus
	private void openCodeWindow() {

		this.code = new Codierer();
		codierer.setVisible(false);

	}

	// Methode legt ein neues Objekt Ratende an und blendet danach den Button
	// aus
	private void openRatenWindow() {

		this.raten = new Ratende();
		ratende.setVisible(false);
	}

	// Übergibt den Button ihre Listener
	private void registrierelistener() {

		this.codierer.addMouseListener(this.openNewWindow);
		this.ratende.addMouseListener(this.openNewWindow);
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
		this.getContentPane().add(ratende, c);

		c.gridy = 3;
		this.getContentPane().add(round, c);

	}

}
