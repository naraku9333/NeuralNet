/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

/**
 * Hyperbolic Tangent activation function
 * 
 * @author Sean Vogel
 */
public class Tanh implements Activator {

    @Override
    public double f(double x) {
        return Math.tanh(x);
    }   

    @Override
    public double fprime(double x) {
        return 1 - x*x;
    }
}
