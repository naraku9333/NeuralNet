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
    public double activate(double x) {
        return Math.log(1 + Math.exp(x));
    } 
}
