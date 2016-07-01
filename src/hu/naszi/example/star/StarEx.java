package hu.naszi.example.star;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

	private final double POINTS[][] = { { 0, 85 }, { 75, 75 }, { 100, 10 },
			{ 125, 75 }, { 200, 85 }, { 150, 125 }, { 160, 190 }, { 100, 150 },
			{ 40, 190 }, { 50, 125 }, { 0, 85 } };

	private void doDraw(Graphics g) {

		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setPaint(Color.gray);
		g2d.translate(25, 5);

		GeneralPath star = new GeneralPath();
		star.moveTo(POINTS[0][0], POINTS[0][1]);
		for (int i = 1; i < POINTS.length; i++) {
			star.lineTo(POINTS[i][0], POINTS[i][1]);
		}
		star.closePath();
		g2d.fill(star);

		g2d.dispose();

	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		doDraw(g);
	}
}

public class StarEx extends JFrame {
	
	public StarEx() {
		
		initUI();
	}

	private void initUI() {
		
		add(new Surface());
		
		setTitle("Star");
		setSize(350, 250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		StarEx ex = new StarEx();
		ex.setVisible(true);
	}
}
