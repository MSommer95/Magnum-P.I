package MastermindMitRMI;

import java.awt.*;
import java.awt.event.*;
import java.rmi.RemoteException;

import javax.swing.*;
import javax.swing.event.*;

//Der Codierer und der Ratende müssen beide auf Bestätigen geklickt haben, bevor die Runde beendet werden kann (Sonst NullPointerExeption)

//Menü für das Spiel (Spieler wählen ihre  Rolle)
public class Menue extends JFrame implements SpielInterface {
	private int[] farbenRaten;
	private int rightp;
	private int rightc;
	private int runde;
	private int winner;

	private JButton round;

	private Codierer code;

	private MouseListener closeRound;

	// Getter und Setter
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
		this.code = new Codierer();

		this.farbenRaten = new int[4];

		this.rightp = 0;
		this.rightc = 0;
		this.runde = 0;

		this.round = new JButton("Vergleichen");

		this.closeRound = new CloseRoundListener();
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
		if (code.getBestätigt() >= 1) {
			vergleich();
		} else
			System.out.println("Der Codierer muss seine Farbfolge bestätigen!");
	}

	// Übergibt den Button ihre Listener
	private void registrierelistener() {

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

		c.gridy = 2;
		this.getContentPane().add(round, c);

	}

	@Override
	// Startet im Zusammenhang mit dem Server das Spiel
	public boolean starteSpiel(int starter) throws RemoteException {
		return true;
	}

	// Verarbeitet die Daten, die der Server bekommt
	@Override
	public boolean spielzug(int f1, int f2, int f3, int f4) throws RemoteException {

		this.farbenRaten[0] = f1;
		this.farbenRaten[1] = f2;
		this.farbenRaten[2] = f3;
		this.farbenRaten[3] = f4;
		code.getLabelAktivität().setText(code.getAktivität()[1]);
		return true;
	}

	// Methode zum Vergleichen der Farbfolgen
	public void vergleich() {
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
		System.out.println("Daten bereit zum Senden!");

		this.runde++;

		if (this.rightp == 4) {
			this.winner = 1;

		} else if (this.runde == 8) {
			this.winner = -1;
		}
		code.getLabelAktivität().setText(code.getAktivität()[0]);

	}

	public void winner() {
		if (this.winner == 1) {
			this.getCode().getLabelAktivität().setText("Ratender hat gewonnen!");
		} else if (this.winner == -1) {
			this.getCode().getLabelAktivität().setText("Du hast gewonnen!");
		}
	}

}