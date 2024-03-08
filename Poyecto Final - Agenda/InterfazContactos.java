package com.example.agenda;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InterfazContactos {
    JPanel panel = new JPanel();
    JTable tabla = new JTable();
    DefaultTableModel modelo = new DefaultTableModel();
    JScrollPane scrollPane;

    public InterfazContactos(){
        JFrame frame = new JFrame("Contactos");
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(79, 51, 145));

        String [] columnas = {"Nombre","Apellido","Ciudadania","Cedula","Codigo Pais","Numero"};
        modelo.setColumnIdentifiers(columnas);
        tabla.setModel(modelo);

        tabla.setBounds(10,10,765,340);
        tabla.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        tabla.setForeground(Color.BLACK);
        tabla.setBorder(new LineBorder(new Color(51, 140, 145)));

        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(10,10,765,340);
        panel.add(scrollPane);

        Contacto aux = Main.lista.inicio;
        while (aux!= null){
            if(aux.codigo_de_area == 0){
                Object [] fila = {aux.nombre, aux.apellido,aux.ciudadania, aux.cedula, aux.codigo_de_pais, aux.numero};
                modelo.addRow(fila);
            }else{
                Object [] fila = {aux.nombre, aux.apellido,aux.ciudadania, aux.cedula, "N/A", aux.numero};
                modelo.addRow(fila);
            }
            aux = aux.siguiente;
        }

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
