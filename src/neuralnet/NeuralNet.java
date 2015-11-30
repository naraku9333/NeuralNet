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
 * 
 * @todo Add bias
 */
public class NeuralNet {

    /**
     * First dimension are the network layers
     * Second dimension are the neurons of the layers 
     */
    private final ArrayList<ArrayList<Neuron>> network;
    private Activator activator;
    
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
        activator = new Sigmoid();
        network = new ArrayList<>();
        for(int size : layers) {
            ArrayList<Neuron> l = new ArrayList<>();//new layer
            for(int i = 0; i < size; ++i) {                         
                l.add(new Neuron());//add neurons to layer
            }
            network.add(l);//add a layer to the network
        }
        createLinks();
    }
    
    /**
     * Create the connections between each neuron in layer L
     * and all neurons in layer L+1
     * 
     *  |\ | --> |   <-- |\ |
     *  | \| <-- |__ --> | \|
     */
    private void createLinks() {
        for(int i = 0; i < network.size() - 1; ++i) {//foreach layer
            for(Neuron n1 : network.get(i)) {//foreach neuron
                for(Neuron n2 : network.get(i+1)) {
                    Link l = new Link(n1, n2);
                    n1.forward.add(l);
                    n2.backward.add(l);
                }
            }
        }
    }
    
    /**
     * Feed inputs forward through the network
     */
    public void feedForward() {
        for(ArrayList<Neuron> layer : network) {
            for(Neuron n : layer) {
                if(n.backward.isEmpty()) break;//its input layer
                double v = 0;
                for(Link l : n.backward) { v += l.prev.getValue() * l.weight; }
                n.setValue(activator.f(v));
            }
        }
    }            
    
    /**
     * Set values for input neurons
     * @param in 
     */
    public void input(float[] in) {
        if(in.length != network.get(0).size()) 
            throw new IllegalArgumentException("Invalid number of inputs");
        
        //apply inputs to input layer
        ArrayList<Neuron> inputLayer = network.get(0);
        for(int i = 0; i < inputLayer.size(); ++i) {
            inputLayer.get(i).setValue(in[i]);
        }
    }
    
    /**
     * 
     * @param a 
     */
    public void setActivator(Activator a) { activator = a; }
    
    /**
     * 
     * @return 
     */
    public Activator getActivator() { return activator; }
    
    /**
     * 
     * @return 
     */
    public final ArrayList<ArrayList<Neuron>> getNetwork() { return network; }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Double> getOutputs() {
        ArrayList<Double> a = new ArrayList<>();
        network.get(network.size()-1).stream().forEach((n) -> {
            a.add(n.getValue());
        });
        
        return a;
    }
    
    private double clamp(double x) {
        return (x < 0.05) ? 0 : (x > 0.95) ? 1 : -1;
    }
}
