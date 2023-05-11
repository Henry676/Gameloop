





import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Minijuego implements Runnable, MouseListener, KeyListener {
    static final int ANCHO = 400, LARGO = 400;
    boolean condicion;
    Thread threadPrincipal;
    JPanel panel;
    int x = 40, y = 40;

    public Minijuego() {
        JFrame ventana = new JFrame("Jueguito");
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                render(g);
            }
        };

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBounds(460, 225, ANCHO, LARGO);
        ventana.add(panel);
        ventana.setVisible(true);

        threadPrincipal = new Thread(this);
        threadPrincipal.start();
        ventana.addKeyListener(this);
        ventana.addMouseListener(this);
    }

    public  void mouseClicked(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    public void keyPressed(KeyEvent e){
    	System.out.println(" "+e.getKeyCode());
    	if(e.getKeyCode() == 65){
    		x-=10;
    	}
    	if(e.getKeyCode() == 87){
    		y-=10;
    	}
    	if(e.getKeyCode() == 68){
    		x+=10;
    	}
    	if(e.getKeyCode() == 83){
    		y+=10;
    	}
    }

    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){

    }

    public void run() {
        System.out.println("Start!!");
        condicion = true;
        while (condicion) {
            update();
            panel.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException excepcion) {
                excepcion.printStackTrace();
            }
        }
    }

    public void update() {
        // Lógica de actualización del juego
    }

    public void render(Graphics g) {
        g.drawRect(0, 0, ANCHO, LARGO);//Dibuja rectangulo
        g.setColor(new Color(0,0,0));//Asigna color al rectangulo
        g.fillRect(0, 0, ANCHO, LARGO);
        g.setColor(Color.BLUE);
       // g.drawString("Hola cara de caca",125,150);
        g.fillRect(x,y,40,40);
        // Otros dibujos del juego
        Toolkit.getDefaultToolkit().sync();//-------------------Evita que el renderizado parpadee
        g.dispose();
    }

    public static void main(String args[]) {
        Minijuego juego = new Minijuego();
    }
}