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
    private double learningRate = 0.9;
    
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
     * 
     * @param desiredOutput
     */
    public void backPropagate(double[] desiredOutput) {
        if(desiredOutput.length != network.get(network.size()-1).size())
            throw new IllegalArgumentException("Invalid number of outputs");
        
        double outputError = 0;
        
        //start at output layer
        for(int i = network.size()-1; i > 0; --i) {
            for(int j = 0; j < network.get(i).size(); ++j) {
                Neuron n = network.get(i).get(j);
                
                //calculate errors
                if(i == network.size()-1) {//output neuron
                    n.setError(activator.fprime(n.getValue()) * (desiredOutput[j] - n.getValue()));
                    outputError += n.getError();
                }
                else {
                    double w = 0;
                    for(Link l : n.forward) { w += l.weight * outputError; }
                    n.setError(activator.fprime(n.getValue()) * w );
                }
                
                //adjust weights
                for(Link l : n.backward) { l.weight += learningRate * n.getError() * l.prev.getValue(); }
            }
        }
    }
    
    /**
     * Set values for input neurons
     * @param in 
     */
    public void input(double[] in) {
        if(in.length != network.get(0).size()) 
            throw new IllegalArgumentException("Invalid number of inputs");
        
        ArrayList<Neuron> inputLayer = network.get(0);
        for(int i = 0; i < inputLayer.size(); ++i) {
            inputLayer.get(i).setValue(in[i]);
        }
    }
    
    /**
     * 
     * @param a 
     */
    public void setActivator(Activator a) {
        activator = a;
    }
    
    public ArrayList<Double> getOutputs() {
        ArrayList<Double> a = new ArrayList<>();
        network.get(network.size()-1).stream().forEach((n) -> {
            a.add(n.getValue());
        });
        
        return a;
    }
    
    public void train(double[][] data, double[][] targets) {
        for(int i = 0; i < data.length; ++i) {//for each sample
            input(data[i]);
            feedForward();
            backPropagate(targets[i]);
            getOutputs().stream().forEach((d) -> {
                System.out.print(d + " ");
            });             
        }
        System.out.println();
    }        
}
