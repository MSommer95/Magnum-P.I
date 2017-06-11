package Mastermind;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Menue extends JFrame {
	private JButton codierer;
	private JButton ratende;
	private Codierer code;
	private Ratende raten;
	private MouseListener openNewWindow;
	private Menue menue;
	
	public Menue getMenue() {
		return menue;
	}
	public void setMenue(Menue menue) {
		this.menue = menue;
	}
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
		
	public Menue(){
		super("Menü");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(512,512);
		this.initialisiereKomponenten();
		this.registrierelistener();
		this.ordneKomponentenAn();
		this.setVisible(true);
	}
	private void initialisiereKomponenten(){
		this.codierer = new JButton("Codierer");
		this.ratende = new JButton("Ratende");
		this.code = new Codierer();
		this.raten = new Ratende();
		this.openNewWindow = new OpenWindowListener();
		
		
	}
	private class OpenWindowListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e){
			if(e.getSource() == codierer){
				openCodeWindow();
				
			}
			else 
			if(e.getSource() == ratende){
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
		
	private void openCodeWindow(){
		this.code.setVisible(true);
		this.setVisible(false);
	}
	private void openRatenWindow(){
		this.raten.setVisible(true);
		this.setVisible(false);
	}

	
	private void registrierelistener(){
		this.codierer.addMouseListener(this.openNewWindow);
		this.ratende.addMouseListener(this.openNewWindow);
		
	}
	private void ordneKomponentenAn(){
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5,5,5,5);
		
		c.ipady = 40;
		c.ipadx = 40;
		this.getContentPane().add(codierer, c);
		
		c.gridy = 2;
		
		this.getContentPane().add(ratende, c);
	}
	public static void main(String[] args){
		Menue m = new Menue();
	}
}
