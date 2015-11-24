/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

/**
 * Sigmoidal (logistic) activation function
 * 
 * @author Sean Vogel
 */
public class Sigmoid implements Activator {

    @Override
    public double activate(double x) { 
        return 1 / (1 + Math.exp(-x)); }    
}
