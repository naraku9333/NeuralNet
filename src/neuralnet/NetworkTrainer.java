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
    private void backPropagate(double[] desiredOutput) {
        ArrayList<ArrayList<Neuron>> neuronList = network.getNetwork();
        if(desiredOutput.length != neuronList.get(neuronList.size()-1).size())
            throw new IllegalArgumentException("Invalid number of outputs");
        
        //double outputError = 0;
        
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
     * @param data
     * @param targets 
     */
    public void train(double[][] data, double[][] targets) {
        for(int i = 0; i < data.length; ++i) {//for each sample
            network.input(data[i]);
            network.feedForward();
            backPropagate(targets[i]);
            network.getOutputs().stream().forEach((d) -> {
                System.out.print(clamp(d) + " ");
            });        
            System.out.println();
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
