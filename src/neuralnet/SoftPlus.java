/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

/**
 * SoftPlus activation function
 * 
 * @author Sean Vogel
 */
public class SoftPlus implements Activator {

    @Override
    public double f(double x) {
        return Math.log(1 + Math.exp(x));
    } 

    @Override
    public double fprime(double x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
