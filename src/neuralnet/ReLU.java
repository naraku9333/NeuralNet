/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

/**
 * Rectified Linear Unit activation function
 * 
 * @author Sean Vogel
 */
public class ReLU implements Activator {

    @Override
    public double f(double x) {
        return Math.max(0, x);
    }  

    @Override
    public double fprime(double x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
