import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static int WIN_WIDTH = 507;
    private static int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;

    private Map map;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);
        setTitle("TicTacToe");
        setResizable(false);
        setLocationRelativeTo(null);
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("<html><body><b>Exit</b></body></html>");
        JButton btnSettings = new JButton("Settings");
        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnStop);
        map = new Map();
        SettingsWindow settings = new SettingsWindow(this);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
      //кнопка для изменения размеров окна
        AdditionalSettings settingsAdd = new AdditionalSettings(this);
        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsAdd.setVisible(true);
            }
        });
        add(map, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        add(btnSettings,BorderLayout.NORTH);
        setVisible(true);
    }
    // Установка размеров окна
    public void acceptWinSettings(int winWidth, int winHeigth) {
        this.WIN_WIDTH = winWidth;
        this.WIN_HEIGHT = winHeigth;
        setSize(WIN_WIDTH, WIN_HEIGHT);
    }
    public void acceptSettings(int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}

