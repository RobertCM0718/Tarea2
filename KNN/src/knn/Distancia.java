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
public class Distancia {//abrimos clase Distancia

    int indice;//declaramos atributo indice
    float distancia;//declaramos atributo distancia
    String clase;//declaramos atributo clase

    public Distancia(int indice, float distancia, String clase) {//abrimos metodo constructor Distancia
        this.indice = indice;//inicializamos atributo indice
        this.distancia = distancia;//inicializamos atributo distancia
        this.clase = clase;//inicializamos atributo clase
    }//cerramos metodo constructor Distancia

}//cerramos clase Distancia
