package Mastermind;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.*;

//Der Codierer entscheidet sich für eine Farbfolge

public class Codierer extends JFrame {

	private Color[] farbe;
	private Color[] ccolor;

	private int bestätigt;
	private int counter;

	private String[] rundeAnzeigeText;
	private JLabel rundeAnzeige;
	private JLabel labelSliderButton;
	private JLabel labelSliderFarbe;

	private Panel southP;
	private Panel centerP;
	private Panel northP;

	private JButton[] buttonsammler;
	private JButton eins;
	private JButton zwei;
	private JButton drei;
	private JButton vier;
	private JButton bestätigen;

	private JSlider sliderFarbe;
	private JSlider sliderButton;

	private ChangeListener farbListener;
	private MouseListener bestätigenListener;

	// Getter und Setter

	public String[] getRundeAnzeigeText() {
		return rundeAnzeigeText;
	}

	public int getBestätigt() {
		return bestätigt;
	}

	public void setBestätigt(int bestätigt) {
		this.bestätigt = bestätigt;
	}

	public void setRundeAnzeigeText(String[] rundeAnzeigeText) {
		this.rundeAnzeigeText = rundeAnzeigeText;
	}

	public JLabel getRundeAnzeige() {
		return rundeAnzeige;
	}

	public void setRundeAnzeige(JLabel rundeAnzeige) {
		this.rundeAnzeige = rundeAnzeige;
	}

	public Color[] getFarbe() {
		return farbe;
	}

	public void setFarbe(Color[] farbe) {
		this.farbe = farbe;
	}

	public Panel getSouthP() {
		return southP;
	}

	public void setSouthP(Panel southP) {
		this.southP = southP;
	}

	public Panel getCenterP() {
		return centerP;
	}

	public void setCenterP(Panel centerP) {
		this.centerP = centerP;
	}

	public Panel getNorthP() {
		return northP;
	}

	public void setNorthP(Panel northP) {
		this.northP = northP;
	}

	public JButton[] getButtonsammler() {
		return buttonsammler;
	}

	public void setButtonsammler(JButton[] buttonsammler) {
		this.buttonsammler = buttonsammler;
	}

	public Color[] getCcolor() {
		return ccolor;
	}

	public void setCcolor(Color[] ccolor) {
		this.ccolor = ccolor;
	}

	public JButton getEins() {
		return eins;
	}

	public void setEins(JButton eins) {
		this.eins = eins;
	}

	public JButton getZwei() {
		return zwei;
	}

	public void setZwei(JButton zwei) {
		this.zwei = zwei;
	}

	public JButton getDrei() {
		return drei;
	}

	public void setDrei(JButton drei) {
		this.drei = drei;
	}

	public JButton getVier() {
		return vier;
	}

	public void setVier(JButton vier) {
		this.vier = vier;
	}

	public JSlider getSliderFarbe() {
		return sliderFarbe;
	}

	public void setSliderFarbe(JSlider sliderFarbe) {
		this.sliderFarbe = sliderFarbe;
	}

	public JSlider getSliderButton() {
		return sliderButton;
	}

	public void setSliderButton(JSlider sliderButton) {
		this.sliderButton = sliderButton;
	}

	public ChangeListener getFarbListener() {
		return farbListener;
	}

	public void setFarbListener(ChangeListener farbListener) {
		this.farbListener = farbListener;
	}

	// Konstruktor für Codierer
	public Codierer() {
		super("Codierer Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(612, 612);
		this.initialisiereKomponenten();
		this.ordneKomponentenAn();
		this.registrierelistener();
		this.setVisible(true);
	}

	// Initialisiert die Komponenten von Codierer
	private void initialisiereKomponenten() {
		this.southP = new Panel();
		this.southP.setBackground(new Color(250, 240, 230));

		this.centerP = new Panel();
		this.centerP.setBackground(new Color(50, 0, 150));

		this.northP = new Panel();
		this.northP.setBackground(new Color(200, 0, 190));

		this.farbe = new Color[] { Color.BLACK, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE, Color.GREEN };

		this.eins = new JButton("Eins");
		this.zwei = new JButton("Zwei");
		this.drei = new JButton("Drei");
		this.vier = new JButton("Vier");
		this.bestätigen = new JButton("Bestätigen");

		this.farbListener = new FarbListener();
		this.bestätigenListener = new BestätigenListener();

		this.sliderFarbe = this.erstelleSchieberegler(1, 6);
		this.sliderButton = this.erstelleSchieberegler(1, 4);

		this.buttonsammler = new JButton[] { eins, zwei, drei, vier };

		this.labelSliderButton = new JLabel("Button-Slider");
		this.labelSliderFarbe = new JLabel("Farbe-Slider");

		this.rundeAnzeigeText = new String[] { "Runde 1", "Runde 2", "Runde 3", "Runde 4", "Runde 5", "Runde 6",
				"Runde 7", "Runde 8" };
		this.rundeAnzeige = new JLabel(this.rundeAnzeigeText[0]);
		this.counter = 0;
	}

	// Innere Klasse für die Slider Listener
	private class BestätigenListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			bestätigen();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	private class FarbListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			farbe();
		}

	}

	// Methode für den Slider Listener (läuft die Buttons durch und wählt eine
	// Farbe/ für den Anwender ist die Farbe zu der Zahl im Vorfeld nicht
	// bekannt)
	private void bestätigen() {

		this.ccolor = new Color[] { this.eins.getBackground(), this.zwei.getBackground(), this.drei.getBackground(),

				this.vier.getBackground() };

		for (int i = 0; i < this.ccolor.length; i++) {

			for (int j = 0; j < this.ccolor.length; j++) {

				if (this.ccolor[i] == this.ccolor[j]) {

					this.counter++;
				}
			}
		}

		if (counter > 4) {

			System.out.println("Doppelte Farben sind nicht erlaubt. Bitte wähle eine andere Farbfolge.");
		}

		this.counter = 0;
		this.bestätigt++;

		System.out.println("Codierer hat seine Farbfolge bestätigt!");
	}

	private void farbe() {

		int i = sliderFarbe.getValue() - 1;
		buttonsammler[sliderButton.getValue() - 1].setBackground(farbe[i]);
	}

	// Übergibt den Komponenten die Listener
	private void registrierelistener() {

		this.sliderFarbe.addChangeListener(this.farbListener);
		this.bestätigen.addMouseListener(this.bestätigenListener);
	}

	// Methode zum Erstellen der Slider
	private JSlider erstelleSchieberegler(int minimum, int maximum) {
		JSlider schieberegler = new JSlider(minimum, maximum);
		schieberegler.setPaintLabels(true);
		schieberegler.setPaintTicks(true);
		schieberegler.setMajorTickSpacing(1);
		return schieberegler;
	}

	// Organisationsmethode für die Komponenten (Darstellung)
	private void ordneKomponentenAn() {

		add(northP, BorderLayout.NORTH);
		northP.add(rundeAnzeige);

		add(southP, BorderLayout.SOUTH);
		southP.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(4, 4, 4, 4);

		southP.add(labelSliderFarbe, c);

		c.gridy = 1;
		southP.add(sliderFarbe, c);

		c.gridy = 0;
		c.gridx = 2;
		southP.add(bestätigen, c);

		c.gridx = 3;
		southP.add(labelSliderButton, c);
		c.gridy = 1;
		southP.add(sliderButton, c);

		for (int i = 0; i < buttonsammler.length; i++) {

			centerP.add(buttonsammler[i]);
		}

		add(centerP, BorderLayout.CENTER);

	}

}
