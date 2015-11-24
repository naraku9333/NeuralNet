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
    static Random r = new Random();
    public Link() {        
        weight = r.nextInt(30) / 100;//using nextInt for bound
    }
    public double weight;
    public Neuron prev, next;
}
