/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sean Vogel
 */
public class NetworkTester {
    /**
     * 
     */
    private final NeuralNet network;
    
    /**
     * 
     * @param n
     */
    public NetworkTester(NeuralNet n) {
        network = n;
    }
    
    /**
     * 
     * @param data 
     * @param results 
     */
    public void test(float[][] data, int[] results) {
        for(int i = 0; i < data.length; ++i) {//for each sample
            network.input(data[i]);
            network.feedForward();
            ArrayList<Double> out = network.getOutputs();            
            results[i] = out.indexOf(Collections.max(out)) + 1;                        
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
