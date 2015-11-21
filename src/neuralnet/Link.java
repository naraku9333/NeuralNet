/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

/**
 * Weighted connection between neurons
 * 
 * @author Sean Vogel
 */
public class Link {
    public double weight;
    public Neuron prev, next;
}
