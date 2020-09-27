import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionalSettings extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 200;
    private GameWindow gameWindow;
    private JTextField winHeigth;
    private JTextField winWidth;
    AdditionalSettings(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Additional game settings");
        setLayout(new GridLayout(6, 1));
        addControls();
        JButton btnApply = new JButton("Apply");
        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectDataFromControlsAndApply();
            }
        });
        add(btnApply);
    }

    private void addControls() {
        add(new JLabel("Size of game window"));
        add(new JLabel("Width"));
        winWidth = new JTextField(Integer.toString(gameWindow.getWidth()),5);
        add(winWidth);
        add(new JLabel("Heigth"));
        winHeigth = new JTextField(Integer.toString(gameWindow.getHeight()),5);
        add(winHeigth);
    }

   private void collectDataFromControlsAndApply() {
        int width = new Integer(winWidth.getText());
        int heigth = new Integer(winHeigth.getText());
        gameWindow.acceptWinSettings(width, heigth);
        setVisible(false);
    }

}
