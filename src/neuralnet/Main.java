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
        
        double[][] data = {{1,0},{0,0},{0,1},{1,1}};
        double[][] t = {{1},{0},{1},{0}};
        //net.input(new double[]{1, 2, 3});
        //net.feedForward();
        net.train(data, t);
        //net.backPropagate(new double[]{0, 3, 1});
        
//        for(double d : net.getOutputs()) {
//            System.out.print(d + " ");
//        }
    }
}
