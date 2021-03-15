import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class MainFrame extends JFrame {
    JTextArea textArea;
    public MainFrame() {
        initializeUI();
        pack();
    }

    private void initializeUI() {
        String text = "Start";
        textArea = new JTextArea(text);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.setPreferredSize(new Dimension(500, 200));
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                keyActionPerfomed(e);
            }
        });
    }

    public static void showFrame() {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    private void keyActionPerfomed(KeyEvent e){
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            FindReplacePanel findReplacePanel = new FindReplacePanel();
            textArea.add(findReplacePanel);
            findReplacePanel.setVisible(true);

        }
        pack();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame.showFrame();
            }
        });
    }
}
