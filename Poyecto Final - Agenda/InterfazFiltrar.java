package com.example.agenda;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
public class InterfazFiltrar {

    JFrame frame = new JFrame("Filtrar");
    JPanel panel = new JPanel();
    JComboBox<String> filtrar_por_combo;
    JButton filtrar_boton;
    JLabel filtrar_por_label,nombre_label, apellido_label, codigo_pais_label, codigo_area_label;
    JTextField dato_field;
    String selccion="";

    public InterfazFiltrar(){
        frame.setSize(235, 185);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(79, 51, 145));

        filtrar_por_label = new JLabel("Filtrar por:");
        filtrar_por_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        filtrar_por_label.setForeground(new Color(51, 140, 145));
        filtrar_por_label.setBounds(10,10, 90,30);
        panel.add(filtrar_por_label);

        nombre_label = new JLabel("Nombre:");
        nombre_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        nombre_label.setForeground(new Color(51, 140, 145));
        nombre_label.setBounds(10,60, 110,30);
        nombre_label.setVisible(false);
        panel.add(nombre_label);

        apellido_label= new JLabel("Apellido:");
        apellido_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        apellido_label.setForeground(new Color(51, 140, 145));
        apellido_label.setBounds(10,60, 110,30);
        apellido_label.setVisible(false);
        panel.add(apellido_label);

        codigo_area_label= new JLabel("Codigo area:");
        codigo_area_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        codigo_area_label.setForeground(new Color(51, 140, 145));
        codigo_area_label.setBounds(10,60, 110,30);
        codigo_area_label.setVisible(false);
        panel.add(codigo_area_label);

        codigo_pais_label= new JLabel("Codigo pais:");
        codigo_pais_label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        codigo_pais_label.setForeground(new Color(51, 140, 145));
        codigo_pais_label.setBounds(10,60, 110,30);
        codigo_pais_label.setVisible(false);
        panel.add(codigo_pais_label);

        dato_field = new JTextField();
        dato_field.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        dato_field.setForeground(Color.BLACK);
        dato_field.setBorder(new LineBorder(new Color(51, 140, 145)));
        dato_field.setBounds(110, 60, 100,30);
        dato_field.setVisible(false);
        panel.add(dato_field);

        filtrar_por_combo = new JComboBox<>(new String[] {" ","Nombre","Apellido","Codigo pais","Codigo area"});
        filtrar_por_combo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        filtrar_por_combo.setForeground(Color.BLACK);
        filtrar_por_combo.setBorder(new LineBorder(new Color(51, 140, 145)));
        filtrar_por_combo.setBounds(110, 10, 100, 30);
        filtrar_por_combo.addActionListener(new oyente1());
        panel.add(filtrar_por_combo);

        filtrar_boton = new JButton("Filtrar");
        filtrar_boton.setBounds(10, 110, 200, 30);
        filtrar_boton.setBackground(new Color(51, 140, 145));
        filtrar_boton.setForeground(new Color(79, 51, 145));
        filtrar_boton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        filtrar_boton.setBorder(new LineBorder(new Color(246, 246, 246)));
        panel.add(filtrar_boton);
        filtrar_boton.addActionListener(new oyente2());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    class oyente1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(((String) filtrar_por_combo.getSelectedItem()).equals("Nombre")){
                selccion = "Nombre";
                nombre_label.setVisible(true);
                apellido_label.setVisible(false);
                codigo_area_label.setVisible(false);
                codigo_pais_label.setVisible(false);
                dato_field.setVisible(true);
            } else if (((String) filtrar_por_combo.getSelectedItem()).equals("Apellido")) {
                selccion = "Apellido";
                nombre_label.setVisible(false);
                apellido_label.setVisible(true);
                codigo_area_label.setVisible(false);
                codigo_pais_label.setVisible(false);
                dato_field.setVisible(true);
            }else if (((String) filtrar_por_combo.getSelectedItem()).equals("Codigo area")){
                selccion = "Codigo area";
                nombre_label.setVisible(false);
                apellido_label.setVisible(false);
                codigo_area_label.setVisible(true);
                codigo_pais_label.setVisible(false);
                dato_field.setVisible(true);
            } else if (((String) filtrar_por_combo.getSelectedItem()).equals("Codigo pais")) {
                selccion = "Codigo pais";
                nombre_label.setVisible(false);
                apellido_label.setVisible(false);
                codigo_area_label.setVisible(false);
                codigo_pais_label.setVisible(true);
                dato_field.setVisible(true);
            }else{
                selccion = "";
                nombre_label.setVisible(false);
                apellido_label.setVisible(false);
                codigo_area_label.setVisible(false);
                codigo_pais_label.setVisible(false);
                dato_field.setVisible(false);
            }
        }
    }

    class oyente2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (selccion.isEmpty()){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una opcion de filtrado");
            }else{
                if (dato_field.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "El campo no debe estar vacio");
                }else{
                    if(selccion.equals("Nombre")){
                        InterfazFiltrarNombre interfazFiltrarNombre = new InterfazFiltrarNombre(dato_field.getText().trim());
                        frame.dispose();
                    } else if (selccion.equals("Apellido")) {
                        InterfazFiltrarApellido interfazFiltrarApellido = new InterfazFiltrarApellido(dato_field.getText().trim());
                        frame.dispose();
                    } else if (selccion.equals("Codigo area")) {
                        InterfazFiltrarCodigoArea interfazFiltrarCodigoArea = new InterfazFiltrarCodigoArea(Integer.parseInt(dato_field.getText().trim()));
                        frame.dispose();
                    }else{
                        InterfazFiltrarCodigoPais interfazFiltrarCodigoPais = new InterfazFiltrarCodigoPais(dato_field.getText().trim());
                        frame.dispose();
                    }
                }
            }
        }
    }
}
