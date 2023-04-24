package views;

import controller.usuarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginView extends JFrame{
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton aunNoTengoCuentaButton;
    private JButton loginButton;
    private JPanel panel;

    public loginView(){
        setVisible(true);
        setTitle("Login");
        setSize(450,300);
        setResizable(false);
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        actionListeners();
    }
    public void actionListeners(){
        aunNoTengoCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new registerView();
                dispose();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=userTextField.getText().toString();
                String password=passwordField.getText().toString();
                if(!username.isEmpty() && !password.isEmpty()){
                    usuarioController usuarioController=new usuarioController();
                    boolean results=usuarioController.login(username,password);
                    if(results){
                        JOptionPane.showMessageDialog(null,"Hola! "+username+
                                " Bienvenido a la aplicacion de login y register ^_^ !");
                    }else{
                        JOptionPane.showMessageDialog(null,"El usuario y contraseña no coinciden");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Todos los datos son requeridos");
                }
            }
        });
    }
}
