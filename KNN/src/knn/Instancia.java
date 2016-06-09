/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

/**
 *
 * @author trebor
 */
public class Instancia {//abrimos clase Instancia

    int indice;//declaramos atributo indice
    int outlook;//declaramos atributo outlook
    int temp;//declaramos atributo temp
    int humidity;//declaramos atributo humidity
    int windy;//declaramos atributo windy
    String clase;//declaramos atributo clase

    public Instancia(int indice, int outlook, int temp, int humidity, int windy, String clase) {//abrimos metodo constructor
        this.indice = indice;//inicializamos atributo indice
        this.outlook = outlook;//inicializamos atributo outlook
        this.temp = temp;//inicializamos atributo temp
        this.humidity = humidity;//inicializamos atributo humidity
        this.windy = windy;//inicializamos atributo windy
        this.clase = clase;//inicializamos atribuo clase
    }//cerramos metodo constructos

}//cerramos clase Instancia
