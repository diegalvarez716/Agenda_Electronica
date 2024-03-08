package com.example.agenda;

public class ListaContactos {
    Contacto inicio = null, fin = null;
    int tamaño = 0;

    public void añadir(Contacto nuevo){
            if(inicio == null){
                inicio = fin = nuevo;
                tamaño++;
            }else {
                nuevo.anterior = fin;
                fin.siguiente= nuevo;
                fin = nuevo;
                tamaño++;
            }
    }
    public boolean confirmar(long cedula){
        Contacto aux = inicio;
        while (aux != null){
            if (aux.cedula == cedula) return false;
            aux = aux.siguiente;
        }
        return true;
    }

    public boolean eliminar(Long cedula){
        Contacto aux = inicio;
        while (aux != null){
            if (aux.cedula == cedula){
                if(tamaño == 1){
                    inicio=fin= null;
                    tamaño--;
                    return true;
                }else if(tamaño >1){
                    if (aux == inicio){
                        aux.siguiente.anterior = null;
                        inicio = aux.siguiente;
                        tamaño--;
                        return true;
                    } else if (aux == fin) {
                        aux.anterior.siguiente = null;
                        fin = aux.anterior;
                        tamaño--;
                        return true;
                    }else {
                        aux.anterior.siguiente = aux.siguiente;
                        aux.siguiente.anterior = aux.anterior;
                        tamaño--;
                        return true;
                    }
                }else{
                    return false;
                }
            }
            aux = aux.siguiente;
        }
        return false;
    }
    public boolean eliminar(Long cedula,String nombre, String apellido){
        Contacto aux = inicio;
        while (aux != null){
            if ((aux.cedula == cedula)&&(aux.nombre.equalsIgnoreCase(nombre))&&(aux.apellido.equalsIgnoreCase(apellido))){
                if(tamaño == 1){
                    inicio=fin= null;
                    tamaño--;
                    return true;
                }else if(tamaño >1){
                    if (aux == inicio){
                        aux.siguiente.anterior = null;
                        inicio = aux.siguiente;
                        tamaño--;
                        return true;
                    } else if (aux == fin) {
                        aux.anterior.siguiente = null;
                        fin = aux.anterior;
                        tamaño--;
                        return true;
                    }else {
                        aux.anterior.siguiente = aux.siguiente;
                        aux.siguiente.anterior = aux.anterior;
                        tamaño--;
                        return true;
                    }
                }else{
                    return false;
                }
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public void mostrar(){
        Contacto contacto = inicio;
        while (contacto != null){
            System.out.println(contacto.nombre+" "+contacto.apellido+" "+contacto.ciudadania+" "+contacto.cedula+" "+contacto.numero+" "+contacto.codigo_de_pais+" "+ contacto.codigo_de_area+"\n");
            contacto = contacto.siguiente;
        }
    }
}
