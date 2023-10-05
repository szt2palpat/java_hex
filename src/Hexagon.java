import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Hexagon extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int size = 50; // size of hexagons
        int spacing = (int) (size * 1.5); // spacing between hexagons

        int centerX = getWidth() / 2; // x-coordinate of center hexagon
        int centerY = getHeight() / 2; // y-coordinate of center hexagon

        drawHexagon(g, centerX, centerY, size); // draw center hexagon

        for (int i = 1; i <= 6; i++) {
            int x = (int) (centerX + size * Math.cos(i * Math.PI/3));
            int y = (int) (centerY + size * Math.sin(i * Math.PI/3));
            drawRingOfHexagons(g, x, y, size, spacing); // draw ring of hexagons around center hexagon
        }
    }

    private void drawRingOfHexagons(Graphics g, int centerX, int centerY, int size, int spacing) {
        for (int i = 0; i < 6; i++) {
            int x = (int) (centerX + (size + spacing) * Math.cos(i * Math.PI/3));
            int y = (int) (centerY + (size + spacing) * Math.sin(i * Math.PI/3));
            drawHexagon(g, x, y, size);
        }
    }

    private void drawHexagon(Graphics g, int centerX, int centerY, int size) {
        int[] xs = new int[6];
        int[] ys = new int[6];
        for (int i = 0; i < 6; i++) {
            xs[i] = (int) (centerX + size * Math.cos(i * Math.PI/3));
            ys[i] = (int) (centerY + size * Math.sin(i * Math.PI/3));
        }
        g.drawPolygon(xs, ys, 6);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Regular Hexagon of Hexagons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.add(new Hexagon());
        frame.setVisible(true);
    }
}