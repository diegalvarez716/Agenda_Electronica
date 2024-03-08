package com.example.agenda;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Main {
    JPanel panel = new JPanel();
    JButton contactos, añadir, eliminar, consultar_por;
    JLabel Bienvenido = new JLabel();
    static String ruta = System.getProperty("user.home") + "/Desktop";
    static String rutaArchivo = ruta.replace("\\", "/")+"\\AgendaDB.txt";
    static String rutaArchivo2 = ruta.replace("\\", "/")+"\\Codigo_Internacional.txt";
    static String rutaArchivo3 = ruta.replace("\\", "/")+"\\Codigo_De_Area.txt";
    static ListaContactos lista = new ListaContactos();
    static Prefijo prefijo = new Prefijo();
    public Main(){

        JFrame frame = new JFrame("Agenda");
        frame.setSize(500, 300);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(79, 51, 145));

        Bienvenido.setText("Bienvenido");
        Bienvenido.setFont(new Font("Comic Sans MS", Font.BOLD, 55));
        Bienvenido.setForeground(new Color(51, 140, 145));
        Bienvenido.setBounds(100,10, 300,50);
        panel.add(Bienvenido);

        contactos = new JButton("Contactos");
        contactos.setBounds(75, 100, 125, 30);
        contactos.setBackground(new Color(51, 140, 145));
        contactos.setForeground(new Color(79, 51, 145));
        contactos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        contactos.setBorder(new LineBorder(new Color(246, 246, 246)));
        panel.add(contactos);

        añadir = new JButton("Añadir");
        añadir.setBounds(275, 100, 125, 30);
        añadir.setBackground(new Color(51, 140, 145));
        añadir.setForeground(new Color(79, 51, 145));
        añadir.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        añadir.setBorder(new LineBorder(new Color(246, 246, 246)));
        panel.add(añadir);

        eliminar = new JButton("Eliminar");
        eliminar.setBounds(75, 160, 125, 30);
        eliminar.setBackground(new Color(51, 140, 145));
        eliminar.setForeground(new Color(79, 51, 145));
        eliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        eliminar.setBorder(new LineBorder(new Color(246, 246, 246)));
        panel.add(eliminar);

        consultar_por = new JButton("Filtrar Por");
        consultar_por.setBounds(275, 160, 125, 30);
        consultar_por.setBackground(new Color(51, 140, 145));
        consultar_por.setForeground(new Color(79, 51, 145));
        consultar_por.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        consultar_por.setBorder(new LineBorder(new Color(246, 246, 246)));
        panel.add(consultar_por);


        contactos.addActionListener(new oyente1());
        añadir.addActionListener(new oyente2());
        eliminar.addActionListener(new oyente3());
        consultar_por.addActionListener(new oyente4());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class oyente1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfazContactos interfazContactos = new InterfazContactos();
        }
    }
    class oyente2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfazAñadir añadir = new InterfazAñadir();
        }
    }

    class oyente3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfazEliminar eliminar = new InterfazEliminar();
        }
    }
    class oyente4 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfazFiltrar interfazFiltrar = new InterfazFiltrar();
        }
    }

    public static void main(String[] args) {
        //Escribe los codigos internacionales en un fichero
        try {
            FileWriter fw = new FileWriter(Main.rutaArchivo2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(prefijo.Codigo_Internacional);
            bw.close();
        } catch (Exception exception) {
        }
        //Escribe los codigos de area en un fichero
        try {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Main.rutaArchivo3),
                    "UTF-8")))
            {
                bw.write(prefijo.Codigo_Area);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception exception){
        }
        //Lee el fichero de donde estan previamente guardado los contactos y los carga en memoria
        try {
            String buffer;
            FileWriter fw = new FileWriter(Main.rutaArchivo, true);
            BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo));
            while ((buffer = bf.readLine())!=null){
                if(!buffer.isEmpty()){
                    if (espacios(buffer) == 5){
                        String nombre="", apellido="", nacionalidad="", cedula="", codigo_pais="", numero="";
                        int i =0;
                        while (buffer.charAt(i) !=' '){
                            nombre = nombre + buffer.charAt(i);
                            i++;
                        }
                        i++;
                        while (buffer.charAt(i) !=' '){
                            apellido = apellido + buffer.charAt(i);
                            i++;
                        }
                        i++;
                        while (buffer.charAt(i) !=' '){
                            nacionalidad = nacionalidad + buffer.charAt(i);
                            i++;
                        }
                        i++;
                        while (buffer.charAt(i) !=' '){
                            cedula = cedula + buffer.charAt(i);
                            i++;
                        }
                        i++;
                        while (buffer.charAt(i) !=' '){
                            codigo_pais = codigo_pais + buffer.charAt(i);
                            i++;
                        }
                        for (int j=i+1; j<buffer.length();j++){
                            numero = numero + buffer.charAt(j);
                            i++;
                        }
                        Contacto nuevo = new Contacto(nombre,apellido,codigo_pais,nacionalidad,Long.parseLong(cedula),numero,0);
                        lista.añadir(nuevo);

                    } else if (espacios(buffer) == 4) {
                        String nombre="", apellido="", nacionalidad="", cedula="", codigo_de_area="", numero="";
                        int i =0;
                        while (buffer.charAt(i) !=' '){
                            nombre = nombre + buffer.charAt(i);
                            i++;
                        }
                        i++;
                        while (buffer.charAt(i) !=' '){
                            apellido = apellido + buffer.charAt(i);
                            i++;
                        }
                        i++;
                        while (buffer.charAt(i) !=' '){
                            nacionalidad = nacionalidad + buffer.charAt(i);
                            i++;
                        }
                        i++;
                        while (buffer.charAt(i) !=' '){
                            cedula = cedula + buffer.charAt(i);
                            i++;
                        }
                        for (int j=i+1; j<buffer.length();j++){
                            numero = numero + buffer.charAt(j);
                            i++;
                        }
                        codigo_de_area =  numero.charAt(0)+""+numero.charAt(1)+""+numero.charAt(2)+""+numero.charAt(3);
                        Contacto nuevo = new Contacto(nombre,apellido,"",nacionalidad,Long.parseLong(cedula),numero,Integer.parseInt(codigo_de_area));
                        lista.añadir(nuevo);
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Error al leer el archivo"+e);
        }

        //Se ejecuta la interfaz principal
        Main main = new Main();
    }

    public static int espacios(String cadena){
        int espacios=0;
        for (int i =0; i<cadena.length(); i++){
            if (cadena.charAt(i) == ' ') espacios++;
        }
        return espacios;
    }


}
