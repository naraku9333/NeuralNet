/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.util.ArrayList;

/**
 *
 * @author Sean Vogel
 */
public class NeuralNet {

    /**
     * First dimension are the network layers
     * Second dimension are the neurons of the layers 
     */
    private final ArrayList<ArrayList<Neuron>> network;
    
    /**
     * Constructor 
     * 
     * First arg is number of neurons in input layer
     * Last arg is number of neurons in output layer
     * Each other is the number of neurons in that hidden layer
     * 
     * @param layers 
     */
    public NeuralNet(int... layers) {
        network = new ArrayList<>();
        for(int size : layers) {
            ArrayList<Neuron> a = new ArrayList<>();
            for(int i = 0; i < size; ++i) {                         
                a.add(new Neuron());//add neurons to layer
            }
            network.add(a);//add a layer to the network
        }
        createLinks();
    }
    
    /**
     * 
     */
    private void createLinks() {
        for(int i = 0; i < network.size() - 1; ++i) {//foreach layer
            for(Neuron n1 : network.get(i)) {//foreach neuron
                for(Neuron n2 : network.get(i+1)) {
                    Link l = new Link();
                    l.prev = n1; l.next = n2;
                    n1.forward.add(l);
                    n2.backward.add(l);
                }
            }
        }        
    }
    
    /**
     * 
     */
    public void feedForward() {
        
    }
    
    /**
     * 
     */
    public void backPropagate() {
        
    }
    
    /**
     * 
     * @param in 
     */
    public void input(double[] in) {
        if(in.length != network.get(0).size()) throw new IllegalArgumentException();
    }
    
    /**
     * Activation function
     * @param x
     * @return 
     */
    private double activate(double x) { return 1 / (1 + Math.exp(-x)); }  
}
