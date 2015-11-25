/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

/**
 *
 * @author Sean Vogel
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NeuralNet net = new NeuralNet(2, 2, 1);
        
        double[][] data = {{0,0},{0,1},{1,0},{1,1}};
        double[][] t = {{0},{1},{1},{0}};
        
        for(int i = 0; i < 10000; ++i)
            net.train(data, t);      
    }
}
