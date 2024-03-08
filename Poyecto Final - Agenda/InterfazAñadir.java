package com.example.agenda;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class InterfazAñadir {
    JLabel nombre_label, apellido_label, ciudadania_label, codigo_de_pais_label,
    cedula_label, numero_personal_label,numero_fijo_label, tipo_de_numero_label;
    JTextField nombre_field, apellido_field, codigo_de_pais_field, cedula_field, numero_fijo_field, numero_personal_field;

    JComboBox<String> ciudadania_combo, tipo_numero_combo;
    JButton Añadir;
    JPanel panel = new JPanel();

    String tipo_numero="",ciudadania="",nombre, apellido, cedula, numero,codigo_pais,  codigo_de_area;

    public InterfazAñadir() {
        JFrame frame = new JFrame("Agregar Contacto");
        frame.setSize(500, 430);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(79, 51, 145));

        nombre_label = new JLabel("Nombre:");
        nombre_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        nombre_label.setForeground(new Color(51, 140, 145));
        nombre_label.setBounds(10, 40, 70, 30);
        panel.add(nombre_label);

        nombre_field = new JTextField();
        nombre_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        nombre_field.setForeground(Color.BLACK);
        nombre_field.setBounds(90, 40, 100, 30);
        nombre_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        panel.add(nombre_field);

        apellido_label = new JLabel("Apellido:");
        apellido_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        apellido_label.setForeground(new Color(51, 140, 145));
        apellido_label.setBounds(290, 40, 70, 30);
        panel.add(apellido_label);

        apellido_field = new JTextField();
        apellido_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        apellido_field.setForeground(Color.BLACK);
        apellido_field.setBounds(370, 40, 100, 30);
        apellido_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        panel.add(apellido_field);

        ciudadania_label = new JLabel("Ciudadano: ");
        ciudadania_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        ciudadania_label.setForeground(new Color(51, 140, 145));
        ciudadania_label.setBounds(10, 100, 90, 30);
        panel.add(ciudadania_label);


        ciudadania_combo = new JComboBox<>(new String[] {" ","Venezolano","Extranjero"});
        ciudadania_combo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        ciudadania_combo.setForeground(Color.BLACK);
        ciudadania_combo.setBorder(new LineBorder(new Color(51, 140, 145)));
        ciudadania_combo.setBounds(100, 100, 90, 30);
        panel.add(ciudadania_combo);

        cedula_label = new JLabel("Cedula:");
        cedula_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        cedula_label.setForeground(new Color(51, 140, 145));
        cedula_label.setBounds(290, 100, 100, 30);
        panel.add(cedula_label);

        cedula_field = new JTextField();
        cedula_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        cedula_field.setForeground(Color.BLACK);
        cedula_field.setBounds(370, 100, 100, 30);
        cedula_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        panel.add(cedula_field);

        tipo_de_numero_label = new JLabel("Tipo de numero:");
        tipo_de_numero_label.setBounds(80, 160, 130, 30);
        tipo_de_numero_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        tipo_de_numero_label.setForeground(new Color(51, 140, 145));
        panel.add(tipo_de_numero_label);


        tipo_numero_combo = new JComboBox<>(new String[] {" ","Personal","Fijo"});
        tipo_numero_combo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        tipo_numero_combo.setForeground(Color.BLACK);
        tipo_numero_combo.setBorder(new LineBorder(new Color(51, 140, 145)));
        tipo_numero_combo.setBounds(210, 160, 90, 30);
        panel.add(tipo_numero_combo);

        numero_fijo_label = new JLabel("Numero Telefonico Fijo: ");
        numero_fijo_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        numero_fijo_label.setForeground(new Color(51, 140, 145));
        numero_fijo_label.setBounds(10, 220, 190, 30);
        numero_fijo_label.setVisible(false);
        panel.add(numero_fijo_label);

        numero_fijo_field = new JTextField();
        numero_fijo_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        numero_fijo_field.setForeground(Color.BLACK);
        numero_fijo_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        numero_fijo_field.setBounds(200, 220, 100, 30);
        numero_fijo_field.setVisible(false);
        panel.add(numero_fijo_field);

        codigo_de_pais_label = new JLabel("Codigo Pais: ");
        codigo_de_pais_label.setBounds(10, 280, 100, 30);
        codigo_de_pais_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        codigo_de_pais_label.setForeground(new Color(51, 140, 145));
        codigo_de_pais_label.setVisible(false);
        panel.add(codigo_de_pais_label);

        codigo_de_pais_field = new JTextField();
        codigo_de_pais_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        codigo_de_pais_field.setBounds(110, 280, 50, 30);
        codigo_de_pais_field.setForeground(Color.BLACK);
        codigo_de_pais_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        codigo_de_pais_field.setVisible(false);
        panel.add(codigo_de_pais_field);

        numero_personal_label = new JLabel("Numero Telefonico Personal:");
        numero_personal_label.setBounds(170, 280, 220, 30);
        numero_personal_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        numero_personal_label.setForeground(new Color(51, 140, 145));
        numero_personal_label.setVisible(false);
        panel.add(numero_personal_label);


        numero_personal_field = new JTextField();
        numero_personal_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        numero_personal_field.setBounds(380, 280, 100, 30);
        numero_personal_field.setForeground(Color.BLACK);
        numero_personal_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        numero_personal_field.setVisible(false);
        panel.add(numero_personal_field);

        Añadir = new JButton("Añadir");
        Añadir.setBounds(380,340, 100,30 );
        Añadir.setBackground(new Color(51, 140, 145));
        Añadir.setForeground(new Color(79, 51, 145));
        Añadir.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        Añadir.setBorder(new LineBorder(new Color(246, 246, 246)));
        panel.add(Añadir);

        ciudadania_combo.addActionListener(new oyente1());
        tipo_numero_combo.addActionListener(new oyente2());
        Añadir.addActionListener(new oyente3());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    class oyente1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(((String) ciudadania_combo.getSelectedItem()).equals("Venezolano")){
                ciudadania= "Venezolano";
            } else if (((String) ciudadania_combo.getSelectedItem()).equals("Extranjero")) {
                ciudadania= "Extranjero";
            }else{
                ciudadania="";
            }
        }
    }
    class oyente2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(((String) tipo_numero_combo.getSelectedItem()).equals("Personal")){
                numero_personal_field.setVisible(true);
                numero_personal_label.setVisible(true);
                codigo_de_pais_label.setVisible(true);
                codigo_de_pais_field.setVisible(true);

                numero_fijo_field.setVisible(false);
                numero_fijo_label.setVisible(false);

                tipo_numero = "Personal";
            } else if (((String) tipo_numero_combo.getSelectedItem()).equals("Fijo")) {
                numero_personal_field.setVisible(false);
                numero_personal_label.setVisible(false);
                codigo_de_pais_label.setVisible(false);
                codigo_de_pais_field.setVisible(false);

                numero_fijo_field.setVisible(true);
                numero_fijo_label.setVisible(true);

                tipo_numero= "Fijo";
            }else{
                tipo_numero="";
            }
        }
    }
    class oyente3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){

            if (tipo_numero.isEmpty()){
                JOptionPane.showMessageDialog(null,"Debe Elegir un tipo de numero telefonico");
            }else{
                if (tipo_numero.equals("Personal")){
                    nombre = nombre_field.getText().trim(); apellido = apellido_field.getText().trim(); cedula = cedula_field.getText().trim();
                    numero = numero_personal_field.getText().trim(); codigo_pais = codigo_de_pais_field.getText().trim();

                    if((nombre.isEmpty()) || (apellido.isEmpty()) || (cedula.isEmpty()) || (numero.isEmpty()) || (ciudadania.isEmpty()) || (codigo_pais.isEmpty())){
                        JOptionPane.showMessageDialog(null,"No deben haber campos vacios");
                    }else{
                        if((numero.length() < 9) || (numero.length() > 13)){
                            JOptionPane.showMessageDialog(null,"Numero telefonico no valido");
                        }else {
                            try {
                                if (!(Confirmar_Codigo_Internacional(codigo_pais))){
                                    JOptionPane.showMessageDialog(null,"Codigo de pais no valido");
                                }else {
                                    if (ciudadania.equals("Venezolano")){
                                        if (Long.parseLong(cedula) > 50000000){
                                            JOptionPane.showMessageDialog(null,"Cedula no valida");
                                        }else{
                                            if (!(Main.lista.confirmar(Long.parseLong(cedula)))){
                                                JOptionPane.showMessageDialog(null,"Cedula repetida");
                                            }else{
                                                Contacto contacto = new Contacto(nombre,apellido,codigo_pais,ciudadania,Long.parseLong(cedula),numero,0);
                                                Main.lista.añadir(contacto);
                                                try{
                                                    FileWriter fw = new FileWriter(Main.rutaArchivo, true);
                                                    BufferedWriter bw = new BufferedWriter(fw);
                                                    bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.codigo_de_pais+" "+contacto.numero+"\n");
                                                    bw.close();
                                                    JOptionPane.showMessageDialog(null, "Contacto registrado");
                                                }catch (Exception exception){

                                                }
                                            }
                                        }
                                    }else{
                                        if (Long.parseLong(cedula) < 1000000){
                                            JOptionPane.showMessageDialog(null,"Cedula no valida");
                                        }else{
                                            Contacto contacto = new Contacto(nombre,apellido,codigo_pais,ciudadania,Long.parseLong(cedula),numero,0);
                                            Main.lista.añadir(contacto);
                                            try{
                                                FileWriter fw = new FileWriter(Main.rutaArchivo, true);
                                                BufferedWriter bw = new BufferedWriter(fw);
                                                bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.codigo_de_pais+" "+contacto.numero+"\n");
                                                bw.close();
                                                JOptionPane.showMessageDialog(null, "Contacto registrado");
                                            }catch (Exception exception){

                                            }
                                        }
                                    }
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }else {
                    nombre = nombre_field.getText().trim(); apellido = apellido_field.getText().trim(); cedula = cedula_field.getText().trim();
                    numero = numero_fijo_field.getText().trim();
                    if((nombre.isEmpty()) || (apellido.isEmpty()) || (cedula.isEmpty()) || (numero.isEmpty()) || (ciudadania.isEmpty())){
                        JOptionPane.showMessageDialog(null,"No deben haber campos vacios");
                    }else{
                        if((numero.length() != 11)){
                            JOptionPane.showMessageDialog(null,"Numero telefonico no valido");
                        }else {
                             codigo_de_area =  numero.charAt(0)+""+numero.charAt(1)+""+numero.charAt(2)+""+numero.charAt(3);
                            try {
                                if (!(Confirmar_Codigo_Area(codigo_de_area.trim()))){
                                    JOptionPane.showMessageDialog(null,"Codigo de Area no valido");
                                }else {
                                    if (ciudadania.equals("Venezolano")){
                                        if (Long.parseLong(cedula) > 50000000){
                                            JOptionPane.showMessageDialog(null,"Cedula no valida");
                                        }else{
                                            if (!(Main.lista.confirmar(Long.parseLong(cedula)))){
                                                JOptionPane.showMessageDialog(null,"Cedula repetida");
                                            }else{
                                                Contacto contacto = new Contacto(nombre,apellido,"",ciudadania,Long.parseLong(cedula),numero,Integer.parseInt(codigo_de_area));
                                                Main.lista.añadir(contacto);
                                                try{
                                                    FileWriter fw = new FileWriter(Main.rutaArchivo, true);
                                                    BufferedWriter bw = new BufferedWriter(fw);
                                                    bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.numero+"\n");
                                                    bw.close();
                                                    JOptionPane.showMessageDialog(null, "Contacto registrado");
                                                }catch (Exception exception){

                                                }
                                            }

                                        }
                                    }else{
                                        if (Long.parseLong(cedula) < 1000000){
                                            JOptionPane.showMessageDialog(null,"Cedula no valida");
                                        }else{
                                            Contacto contacto = new Contacto(nombre,apellido,"",ciudadania,Long.parseLong(cedula),numero,Integer.parseInt(codigo_de_area));
                                            Main.lista.añadir(contacto);
                                            try{
                                                FileWriter fw = new FileWriter(Main.rutaArchivo, true);
                                                BufferedWriter bw = new BufferedWriter(fw);
                                                bw.append(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.numero+"\n");
                                                bw.close();
                                                JOptionPane.showMessageDialog(null, "Contacto registrado");
                                            }catch (Exception exception){

                                            }
                                        }

                                    }
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
            }

        }

        public boolean Confirmar_Codigo_Internacional(String codigo) throws IOException {
            String buffer;
            BufferedReader bf = new BufferedReader(new FileReader(Main.rutaArchivo2));
            while ((buffer = bf.readLine())!=null){
                if (buffer.equals(codigo))return true;
            }
            return false;
        }
        public boolean Confirmar_Codigo_Area(String codigo) throws IOException {
            String buffer;
            BufferedReader bf = new BufferedReader(new FileReader(Main.rutaArchivo3));
            while ((buffer = bf.readLine())!=null){
                if ( (Integer.parseInt(codigo))==(Integer.parseInt(buffer)))return true;
            }
            return false;
        }
    }

}
