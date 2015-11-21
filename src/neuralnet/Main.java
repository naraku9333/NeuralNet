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
        NeuralNet net = new NeuralNet(2, 3, 1);
        //net.input(new double[]{1, 2, 3});
        net.feedForward();
    }
}
