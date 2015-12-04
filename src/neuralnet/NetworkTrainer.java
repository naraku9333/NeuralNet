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
public class NetworkTrainer {
    private double learningRate;

    /**
     * 
     */
    private final NeuralNet network;
    
    /**
     * 
     * @param n 
     */
    public NetworkTrainer(NeuralNet n) {
        this(n, 0.3);
    }
    
    /**
     * 
     * @param n
     * @param lr
     */
    public NetworkTrainer(NeuralNet n, double lr) {
        network = n;
        learningRate = lr;
    }
    
    /**
     * 
     * @param desiredOutput
     */
    private void backPropagate(int[] desiredOutput) {
        ArrayList<ArrayList<Neuron>> neuronList = network.getNetwork();        
                
        //start at output layer
        for(int i = neuronList.size()-1; i >= 0; --i) {
            for(int j = 0; j < neuronList.get(i).size(); ++j) {
                Neuron n = neuronList.get(i).get(j);
                
                //calculate errors
                if(i == neuronList.size()-1) {//output neuron
                    n.setError(network.getActivator().fprime(n.getValue()) * (desiredOutput[j] - n.getValue()));
                    //outputError += n.getError();
                }
                else {
                    double w = 0;
                    for(Link l : n.forward) { w += l.weight * l.next.getError(); }
                    n.setError(network.getActivator().fprime(n.getValue()) * w );
                    //for(Link l : n.backward) { l.weight += learningRate * n.getError() * l.prev.getValue(); }
                }
                
                //adjust weights
                for(Link l : n.backward) { l.weight += learningRate * n.getError() * l.prev.getValue(); }
            }
        }
    }    
    
    /**
     * 
     * @param desiredOutput
     */
    private void backPropagate(int desiredOutput) {
        ArrayList<ArrayList<Neuron>> neuronList = network.getNetwork();       
                
        int[] desout = new int[neuronList.get(neuronList.size()-1).size()];
        for(int i = 0; i < desout.length; ++i) desout[i] = 0;
        desout[desiredOutput-1] = 1;
        //start at output layer
        for(int i = neuronList.size()-1; i >= 0; --i) {
            for(int j = 0; j < neuronList.get(i).size(); ++j) {
                Neuron n = neuronList.get(i).get(j);
                
                //calculate errors
                if(i == neuronList.size()-1) {//output neuron
                    n.setError(network.getActivator().fprime(n.getValue()) * (desout[j] - n.getValue()));
                    //outputError += n.getError();
                }
                else {
                    double w = 0;
                    for(Link l : n.forward) { w += l.weight * l.next.getError(); }
                    n.setError(network.getActivator().fprime(n.getValue()) * w );
                    //for(Link l : n.backward) { l.weight += learningRate * n.getError() * l.prev.getValue(); }
                }
                
                //adjust weights
                for(Link l : n.backward) { l.weight += learningRate * n.getError() * l.prev.getValue(); }
            }
        }
    }        
    
    /**
     * 
     * @param data
     * @param targets 
     */
    public void train(float[][] data, int[][] targets) {
        for(int i = 0; i < data.length; ++i) {//for each sample
            network.input(data[i]);
            network.feedForward();
            backPropagate(targets[i]);
        }   
    }    
    
    /**
     * 
     * @param data
     * @param targets 
     */
    public void train(float[][] data, int[] targets) {
        for(int i = 0; i < data.length; ++i) {//for each sample
            network.input(data[i]);
            network.feedForward();
            backPropagate(targets[i]);
        }   
    }    
    
    /**
     * 
     * @param x
     * @return 
     */
    private double clamp(double x) {
        return (x < 0.05) ? 0 : (x > 0.95) ? 1 : -1;
    }
}
