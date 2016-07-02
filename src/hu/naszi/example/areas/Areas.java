package hu.naszi.example.areas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {

	public void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(renderingHints);

		g2d.setPaint(Color.gray);

		Area area1 = new Area(new Rectangle2D.Double(20, 20, 100, 100));
		Area area2 = new Area(new Ellipse2D.Double(50, 50, 100, 100));
		area1.subtract(area2);
		g2d.fill(area1);

		Area area3 = new Area(new Rectangle2D.Double(150, 20, 100, 100));
		Area area4 = new Area(new Ellipse2D.Double(150, 20, 100, 100));
		area3.subtract(area4);
		g2d.fill(area3);

		Area area5 = new Area(new Rectangle2D.Double(280, 20, 100, 100));
		Area area6 = new Area(new Ellipse2D.Double(320, 40, 100, 100));
		area5.add(area6);
		g2d.fill(area5);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}

}

public class Areas extends JFrame {
	
	public Areas() {
		
		initUI();
	}
	
	private void initUI() {
		
		add(new Surface());
		
		setTitle("Areas");
		setSize(450, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				Areas areas = new Areas();
				areas.setVisible(true);
			}
		});
	}

}
