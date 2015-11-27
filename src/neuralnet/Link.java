/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.util.Random;

/**
 * Weighted connection between neurons
 * 
 * @author Sean Vogel
 */
public class Link {
    private static final Random r = new Random();
    public Link(Neuron n1, Neuron n2) {  
        prev = n1; next = n2;
        weight = r.nextDouble();// - 0.5;
    }
    public double weight;
    public Neuron prev, next;
}
