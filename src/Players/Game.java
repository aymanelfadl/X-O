package Players;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel role;
    private JButton[][] buttons;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Game frame = new Game();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Game() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 47, 414, 203);
        contentPane.add(panel);
        panel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                panel.add(buttons[i][j]);
            }
        }

        JLabel lblNewLabel = new JLabel("Player :");
        lblNewLabel.setBounds(10, 11, 47, 25);
        contentPane.add(lblNewLabel);

        role = new JLabel("X");
        role.setBounds(67, 11, 47, 25);
        contentPane.add(role);
    }

    private void changePlayer() {
        String currentRoleText = role.getText();
        if ("X".equals(currentRoleText)) {
            role.setText("O");
        } else {
            role.setText("X");
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = buttons[row][col];
            if (clickedButton.getText().isEmpty()) {
                clickedButton.setText(role.getText());
                changePlayer();
            }
        }
    }
}
