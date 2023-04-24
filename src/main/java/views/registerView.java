package views;

import controller.usuarioController;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerView extends JFrame {
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton cancelarButton;
    private JButton registrarseButton;
    private JPanel panel;

    public registerView(){
        setVisible(true);
        setTitle("Registro de usuario");
        setSize(450,300);
        setResizable(false);
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        actionListeners();
    }
    public void actionListeners(){
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=usernameTextField.getText().toString();
                String password=passwordField.getText().toString(); //No considero seguridad
                if(!username.isEmpty() && !password.isEmpty()){
                    usuarioController usuarioController=new usuarioController();
                    boolean results=usuarioController.register(new Usuario(username,password));
                    if(results){
                        JOptionPane.showMessageDialog(null,"El usuario fue registrado correctamente");
                    }else{
                        JOptionPane.showMessageDialog(null,"El nombre de Usuario ya esta registrado");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Todos los campos son requeridos");
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new paginaPrincipal();
                dispose();
            }
        });
    }
}
