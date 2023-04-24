package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paginaPrincipal extends JFrame{
    private JButton iniciarSesionButton;
    private JButton registrarseButton;
    private JPanel panel;

    public paginaPrincipal(){
        setVisible(true);
        setTitle("Hola! Bienvenido a nuestra aplicacion");
        setSize(450,300);
        setResizable(false);
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        actionListeners();
    }
    public void actionListeners(){
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new loginView();
                dispose();
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new registerView();
                dispose();
            }
        });
    }
}
