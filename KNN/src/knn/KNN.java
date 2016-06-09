/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.util.Scanner; //importamos libreria Scanner usada para lectura de datos

/**
 *
 * @author trebor
 */
public class KNN { //abrimos clase principal KNN

    public void datos() {//abrimos metodo datos
        int outlook, temp, humidity, windy, k; //declaramos variables necesarias para llenar la nueva instancia.
        String clase;//declaramos variable necesaria para la nueva instancia
        Instancia n_ins[] = new Instancia[1];//creamos un  arreglo de tipo Instancia
        Scanner teclado = new Scanner(System.in);//creamos un objeto de tipo Scanner  

        System.out.println("\n\nBienvenido al calculo del metodo KNN \nIngrese la nueva instancia.\nAtributo:Outlook \n1.-Sunny 2.-Overcast 3.-Rainy");//Imprimimos mensaje de bienvenida y solicitamos prime atributo
        outlook = teclado.nextInt();//leemos el primer dato recibido
        System.out.println("Atributo:Temp\n1.-Hot 2.-Mild 3.-Cool");//Solicitamos el segundo atributo
        temp = teclado.nextInt();//leemos el segundo dato recibido
        System.out.println("Atributo:Humidity\n1.-High 2.-Normal");//Solicitamos el tercer atributo
        humidity = teclado.nextInt();//leemos el tercer dato recibido
        System.out.println("Atributo:Windy\n1.-False 2.-True");//solicitamos el cuarto atributo
        windy = teclado.nextInt();//leemos ele cuarto atributo
        System.out.println("Ahora ingresa el valor de K");//solicitamos el valor de K
        k = teclado.nextInt();//leemos el valor de K

        n_ins[0] = new Instancia(1, outlook, temp, humidity, windy, "?");//asignamos valores a nuestra nueva instancia
        calcular(n_ins, k);//usamos metodo calcular
    }//cerramos metodo datos

    public void calcular(Instancia[] n_ins, int k) {//abrimos metodo calcular que recibe 1 arreglo de tipo Instacia y un valor entero
        int cont1 = 0, cont2 = 0;//Declaramos variables

        Distancia dis[] = new Distancia[14];//creamos arreglo de tipo Distancia con tamaño 14

        Instancia instancia[] = new Instancia[14];//creamos arreglo de tipo Instancia con tamaño 14
        instancia[0] = new Instancia(1, 1, 1, 1, 1, "DontPlay");//Asignamos valores a la fila 0
        instancia[1] = new Instancia(2, 1, 1, 1, 2, "DontPlay");//Asignamos valores a la fila 1
        instancia[2] = new Instancia(3, 2, 2, 2, 2, "Play");//Asignamos valores a la fila 2
        instancia[3] = new Instancia(4, 3, 2, 1, 1, "Play");//Asignamos valores a la fila 3
        instancia[4] = new Instancia(5, 3, 3, 2, 1, "Play");//Asignamos valores a la fila 4
        instancia[5] = new Instancia(6, 3, 3, 2, 2, "DontPlay");//Asignamos valores a la fila 5
        instancia[6] = new Instancia(7, 2, 3, 2, 2, "Play");//Asignamos valores a la fila 6
        instancia[7] = new Instancia(8, 1, 2, 1, 1, "DontPlay");//Asignamos valores a la fila 7
        instancia[8] = new Instancia(9, 1, 3, 2, 1, "Play");//Asignamos valores a la fila 8
        instancia[9] = new Instancia(10, 3, 2, 2, 1, "Play");//Asignamos valores a la fila 9
        instancia[10] = new Instancia(11, 1, 2, 2, 2, "Play");//Asignamos valores a la fila 10
        instancia[11] = new Instancia(12, 1, 2, 2, 2, "Play");//Asignamos valores a la fila 11
        instancia[12] = new Instancia(13, 2, 1, 2, 1, "Play");//Asignamos valores a la fila 12
        instancia[13] = new Instancia(14, 3, 2, 1, 2, "Play");//Asignamos valores a la fila 13

        for (int i = 0; i < instancia.length; i++) {//abrimos ciclo for

            float out = (float) Math.pow((n_ins[0].outlook - instancia[i].outlook), 2);//Restamos outlook de lainstancia numero i a la nueva instancia y elevamos al 2
            float temp = (float) Math.pow((n_ins[0].temp - instancia[i].temp), 2);//Restamos temp de la instancia numero i a la nueva instancia y elevamos al 2
            float hum = (float) Math.pow((n_ins[0].humidity - instancia[i].humidity), 2);//Restamos humidity de la instancia numero i a la nueva instancia y elevamos al 2
            float win = (float) Math.pow((n_ins[0].windy - instancia[i].windy), 2);//Restamos windy de la instancia numero i a la nueva instancia y elevamos al 2
            float aux = (float) Math.sqrt(out + temp + hum + win);//Sumamos los resultados y obtenemos raiz cuadrada
            dis[i] = new Distancia((i + 1), aux, instancia[i].clase);//Guardamos nuestros resultados en  arreglo dipo Distancia
            aux = 0;//Igualamos a 0 aux para volver a realizar el proceso
        }//cerramos ciclo for
        System.out.println("\n\nDistancia Euclidiana");//Imprimimos mensaje de aviso
        for (int i = 0; i < dis.length; i++) {//acrimos ciclo for
            System.out.println("No : " + dis[i].indice + " Distancia: " + dis[i].distancia);//Imprimos el No de instancia con su resultado.
        }//cerramos ciclo for
        Distancia ordenado[] = new Distancia[14];//creamos arreglo de tipo Distancia con tamaño 14
        ordenado = ordenarMenorMayor(dis, k);//asignamos al nuevo arreglo el resultado de ordenarMenorMayor
        for (int i = 0; i < k; i++) {//abrimos for
            if (ordenado[i].clase == "DontPlay") {//abrimos if, comparamos clase de instancia i con DontPlay
                cont1 = cont1 + 1;//acumulamos el numero de veces que se cumplio la condicion
            } else {//cerramos if y abrimos else
                cont2 = cont2 + 1;//acumulamos el numero de que no se cumplio la condicion
            }//cerramos else
        }//cerramos for
        System.out.println("\n\n¡Usando funcion mayoria para la toma de decisión!");//Imprimimos aviso
        if (cont1 > cont2) {//abrimos if y aplicamos funcion mayoria
            System.out.println(cont1 + " de " + k);//Imprimos el numero de veces repetidas de la clase con respecto de K
            System.out.println("La clase es: DontPlay!");//Imprimos aviso
        } else {//cerramos if y abrimos else
            System.out.println(cont2 + " de " + k);//Imprimimos el numero de veces repetidas de la clase con respecto de k
            System.out.println("La clase es: Play");//Imprimos aviso
        }//cerramos else

    }//cerramos funcion calcular

    public Distancia[] ordenarMenorMayor(Distancia[] dis, int k) {//abrimos funcion ordenarMenorMayor y recibimos parametros arreglo tipo Distancia y valor entero
        for (int i = 0; i < (dis.length - 1); i++) {//Abrimos primer for de for anidado restando 1 al tamaño del arreglo recibido
            for (int j = i + 1; j < dis.length; j++) {//Abrimos segundo for de for anidado
                if (dis[i].distancia > dis[j].distancia) {//abrimos if y comparamos distancias
                    float aux1 = dis[i].distancia;//Guardamos distancia de dis[i] en nueva variable 
                    int aux2 = dis[i].indice;//Guardamos indice de dis[i] en nueva variable
                    String aux3 = dis[i].clase;//Guardamos clase de dis[i] en nueva variable
                    dis[i].distancia = dis[j].distancia;//Iniciamos intercambio de valores distancia una posicion antes
                    dis[i].indice = dis[j].indice;//Iniciamos intercambio de valores distancia una posicion antes
                    dis[i].clase = dis[j].clase;//Iniciamos intercambio de valores distancia una posicion antes
                    dis[j].distancia = aux1;//Terminamos intercambio de valores 
                    dis[j].indice = aux2;//Terminamos intercambio de valores
                    dis[j].clase = aux3;//Terminamos intercambio de valores

                }//cerramos if
            }//cerramos segundo for de for anidado
        }//cerramos primer for de for anidado
        System.out.println("\n\nPrimeras " + k + " distancias ordenadas de menor a mayor");//Imprimimos aviso
        for (int i = 0; i < k; i++) {//Iniciamos ciclo for
            System.out.println("Indice: " + dis[i].indice + " Dis: " + dis[i].distancia + " Clase: " + dis[i].clase);//Imprimos las primeras K distancias
        }//cerramos ciclo for
        return dis;//retornamos el arreglo ordenado
    }//cerramos metodo ordenarMenorMayor

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//Abrimos metodo main
        KNN obj = new KNN();//creamos objeto tipo KNN
        obj.datos();//usamos metodo datos de objeto KNN

    }//cerramos metodo main

}//cerramos clase principal
