/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.io.Serializable;

/**
 * Sigmoidal (logistic) activation function
 * 
 * @author Sean Vogel
 */
public class Sigmoid implements Activator, Serializable {

    @Override
    public double f(double x) { 
        return 1 / (1 + Math.exp(-x)); }    

    @Override
    public double fprime(double x) {
        return x * (1 - x);//f(x) * (1 - f(x));
    }
}
