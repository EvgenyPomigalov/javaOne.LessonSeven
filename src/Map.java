import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int MODE_HVH = 0;
    public static final int MODE_HVA = 1;
    public static int fieldSize = 1;
    public Map() {
        setBackground(Color.black);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode:%d, size:%d, win:%d\n", gameMode, fieldSizeX, winLength);
        repaint();
    }
    @Override
   public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        int cellWidth = getWidth() / this.fieldSize;
        int cellHeight = getHeight() / this.fieldSize;
        for (int i = 1; i < this.fieldSize; i++) {
            g.drawLine(i * cellWidth, 0, i * cellWidth, getHeight());
            g.drawLine(0, i * cellHeight, getWidth(), i * cellHeight);
        }
    }
}