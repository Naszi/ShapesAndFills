package hu.naszi.example.textures;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Surface extends JPanel {
	
	private BufferedImage slate;
	private BufferedImage java;
	private BufferedImage pane;
	private TexturePaint slateTP;
	private TexturePaint javaTP;
	private TexturePaint paneTP;
	
	public Surface() {
		
		loadImage();
	}
	
	private void loadImage() {
		
		try {
			
			slate = ImageIO.read(new File("slate.png"));
			java = ImageIO.read(new File("java.png"));
			pane = ImageIO.read(new File("pane.png"));
		} catch (IOException e) {
			
			Logger.getLogger(Surface.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		slateTP = new TexturePaint(slate, new Rectangle(0, 0, 90, 60));
		javaTP = new TexturePaint(java, new Rectangle(0, 0, 90, 60));
		paneTP = new TexturePaint(pane, new Rectangle(0, 0, 90, 60));
		
		g2d.setPaint(slateTP);
		g2d.fillRect(10, 15, 90, 60);
		
		g2d.setPaint(javaTP);
		g2d.fillRect(130, 15, 90, 60);
		
		g2d.setPaint(paneTP);
		g2d.fillRect(250, 15, 90, 60);
		
		g2d.dispose();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		doDrawing(g);
	}
	
	
}

public class TexturesEx extends JFrame {
	
	public TexturesEx() {
		
		initUI();
	}

	private void initUI() {
		
		add(new Surface());
		
		setTitle("Textures");
		setSize(360, 120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				TexturesEx ex = new TexturesEx();
				ex.setVisible(true);
			}
		});
	}

}
