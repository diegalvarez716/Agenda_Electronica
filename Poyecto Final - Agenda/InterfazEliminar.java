package com.example.agenda;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class InterfazEliminar {
    JPanel panel = new JPanel();
    JButton  eliminar;
    JComboBox<String> ciudadania_combo;
    String ciudadania="";

    JLabel cedula_label,ciudadania_label, nombre_label, apellido_label;
    JTextField cedula_field, nombre_field, apellido_field;
    public InterfazEliminar(){
        JFrame frame = new JFrame("Eliminar contacto");
        frame.setSize(450, 230);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(79, 51, 145));


        ciudadania_label = new JLabel("Ciudadania:");
        ciudadania_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        ciudadania_label.setForeground(new Color(51, 140, 145));
        ciudadania_label.setBounds(10,10, 90,30);
        panel.add(ciudadania_label);

        ciudadania_combo = new JComboBox<>(new String[] {" ","Venezolano","Extranjero"});
        ciudadania_combo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        ciudadania_combo.setForeground(Color.BLACK);
        ciudadania_combo.setBorder(new LineBorder(new Color(51, 140, 145)));
        ciudadania_combo.setBounds(110, 10, 100, 30);
        ciudadania_combo.addActionListener(new oyente1());
        panel.add(ciudadania_combo);

        cedula_label = new JLabel("Cedula:");
        cedula_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        cedula_label.setForeground(new Color(51, 140, 145));
        cedula_label.setBounds(10,60, 90,30);
        cedula_label.setVisible(false);
        panel.add(cedula_label);

        cedula_field = new JTextField();
        cedula_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        cedula_field.setForeground(Color.BLACK);
        cedula_field.setBounds(110, 60, 100, 30);
        cedula_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        cedula_field.setVisible(false);
        panel.add(cedula_field);

        nombre_label = new JLabel("Nombre:");
        nombre_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        nombre_label.setForeground(new Color(51, 140, 145));
        nombre_label.setBounds(10,110, 90,30);
        nombre_label.setVisible(false);
        panel.add(nombre_label);

        nombre_field = new JTextField();
        nombre_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        nombre_field.setForeground(Color.BLACK);
        nombre_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        nombre_field.setBounds(110, 110, 100,30);
        nombre_field.setVisible(false);
        panel.add(nombre_field);

        apellido_label = new JLabel("Apellido:");
        apellido_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        apellido_label.setForeground(new Color(51, 140, 145));
        apellido_label.setBounds(240,110, 90,30);
        apellido_label.setVisible(false);
        panel.add(apellido_label);

        apellido_field = new JTextField();
        apellido_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        apellido_field.setForeground(Color.BLACK);
        apellido_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        apellido_field.setBounds(320, 110, 100,30);
        apellido_field.setVisible(false);
        panel.add(apellido_field);

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(320, 150, 100, 30);
        eliminar.setBackground(new Color(51, 140, 145));
        eliminar.setForeground(new Color(79, 51, 145));
        eliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        eliminar.setBorder(new LineBorder(new Color(246, 246, 246)));
        eliminar.addActionListener(new oyente2());
        panel.add(eliminar);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class oyente1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(((String) ciudadania_combo.getSelectedItem()).equals("Venezolano")){
                ciudadania= "Venezolano";
                cedula_label.setVisible(true);
                cedula_field.setVisible(true);
                nombre_label.setVisible(false);
                nombre_field.setVisible(false);
                apellido_label.setVisible(false);
                apellido_field.setVisible(false);
            } else if (((String) ciudadania_combo.getSelectedItem()).equals("Extranjero")) {
                ciudadania= "Extranjero";
                cedula_label.setVisible(true);
                cedula_field.setVisible(true);
                nombre_label.setVisible(true);
                nombre_field.setVisible(true);
                apellido_label.setVisible(true);
                apellido_field.setVisible(true);
            }else{
                ciudadania="";
            }
        }
    }

    class oyente2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ciudadania.isEmpty()){
                JOptionPane.showMessageDialog(null,"Debe seleccionar una nacionalidad");
            }else{
                if (ciudadania.equals("Venezolano")){
                    if (cedula_field.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Debe ingresar una cedula");
                    }else{
                        if (!(Main.lista.eliminar(Long.parseLong(cedula_field.getText())))){
                            JOptionPane.showMessageDialog(null, "Contacto no existente");
                        }else {
                            try{
                                File archivo = new File(Main.rutaArchivo);
                                Contacto contacto = Main.lista.inicio;
                                if(Main.lista.tamaño == 0){
                                    try (FileWriter escritor = new FileWriter(archivo)) {
                                        JOptionPane.showMessageDialog(null, "Contacto eliminado");
                                    }

                                }else {
                                    try {
                                        FileWriter fw = new FileWriter(archivo);
                                        BufferedWriter bw = new BufferedWriter(fw);
                                        while (contacto !=null){
                                            if (contacto.codigo_de_area == 0){
                                                bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.codigo_de_pais+" "+contacto.numero+"\n");
                                            }else{
                                                bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.numero+"\n");
                                            }
                                        }
                                        bw.close();
                                        JOptionPane.showMessageDialog(null, "Contacto eliminado");
                                    }catch (IOException exception){

                                    }
                                }
                            }catch (Exception exception){

                            }
                        }
                    }
                }else{
                    if ((cedula_field.getText().isEmpty())||(nombre_field.getText().isEmpty())||(apellido_field.getText().isEmpty())){
                        JOptionPane.showMessageDialog(null, "Debe ingresar una cedula");
                    }else{
                        if (!(Main.lista.eliminar((Long.parseLong(cedula_field.getText())), nombre_field.getText(), apellido_field.getText()))){
                            JOptionPane.showMessageDialog(null, "Contacto no existente");
                        }else {
                            try{
                                File archivo = new File(Main.rutaArchivo);
                                Contacto contacto = Main.lista.inicio;
                                if(Main.lista.tamaño == 0){
                                    try (FileWriter escritor = new FileWriter(archivo)) {
                                        JOptionPane.showMessageDialog(null, "Contacto eliminado");
                                    }

                                }else {
                                    try {
                                        FileWriter fw = new FileWriter(archivo);
                                        BufferedWriter bw = new BufferedWriter(fw);
                                        while (contacto !=null){
                                            if (contacto.codigo_de_area == 0){
                                                bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.codigo_de_pais+" "+contacto.numero+"\n");
                                            }else{
                                                bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.numero+"\n");
                                            }
                                        }
                                        bw.close();
                                        JOptionPane.showMessageDialog(null, "Contacto eliminado");
                                    }catch (IOException exception){

                                    }
                                }
                            }catch (Exception exception){

                            }
                        }
                    }
                }
            }
        }
    }

}
