package Mastermind;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

//Menü für das Spiel (Spieler wählen ihre  Rolle)

public class Menue extends JFrame {
	private JButton codierer;
	private JButton ratende;
	private JButton round;
	private Codierer code;
	private Ratende raten;
	private MouseListener openNewWindow;
	private MouseListener closeRound;
	
	
	//Getter und Setter 
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
	
	//Konstruktor für Menue
	public Menue() {
		super("Menü");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(512, 512);
		this.initialisiereKomponenten();
		this.registrierelistener();
		this.ordneKomponentenAn();
		this.setVisible(true);
	}
	//Initialisiert die Komponenten von Menue
	
	private void initialisiereKomponenten() {
		this.codierer = new JButton("Codierer");
		this.ratende = new JButton("Ratende");
		this.round = new JButton("Round");
		
		this.openNewWindow = new OpenWindowListener();
		this.closeRound = new CloseRoundListener();
	}
	//Innere Klasse für das Öffnen eines neues Fensters 
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
	
	//Listener zum Beenden der Runde
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
	
	//Controlliert das Ergebnis der Runde (Die beiden Farbarrays)
	private void round(){
		for(int i = 0; i<code.getCcolor().length;i++){
			if(code.getCcolor()[i] == raten.getRcolor()[i]){
				System.out.println("right position " + code.getCcolor()[i]);
			}
				
			for(int j = 0;j<raten.getRcolor().length;j++){
			if(code.getCcolor()[i] == raten.getRcolor()[j]){
				System.out.println("same color"+code.getCcolor()[i]);
			}
			}
		}
		}
	//Methode legt ein neues Objekt Codierer an und blendet danach den Button aus
	private void openCodeWindow() {
		this.code = new Codierer();
		codierer.setVisible(false);

	}
	//Methode legt ein neues Objekt Ratende an und blendet danach den Button aus
	private void openRatenWindow() {
		this.raten = new Ratende();
		ratende.setVisible(false);
	}
	//Übergibt den Button ihre Listener
	private void registrierelistener() {
		this.codierer.addMouseListener(this.openNewWindow);
		this.ratende.addMouseListener(this.openNewWindow);
		
		this.round.addMouseListener(this.closeRound);

	}
	//Methode zum Ordnen der Komponenten
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
public static void main(String[] args){
	Menue m = new Menue();
}
	
}
