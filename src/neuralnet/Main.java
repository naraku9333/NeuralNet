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
                
        //double[][] data = {{0,0},{0,1},{1,0},{1,1}};
        //double[][] t = {{0},{1},{1},{0}};
        
        double[][] allData = new double[50][];
        allData[0] = new double[] { 5.1, 3.5, 1.4, 0.2 }; // sepal length, width, petal length, width
        allData[1] = new double[] { 4.9, 3.0, 1.4, 0.2 }; // Iris setosa = 0 0 1
        allData[2] = new double[] { 4.7, 3.2, 1.3, 0.2 }; // Iris versicolor = 0 1 0
        allData[3] = new double[] { 4.6, 3.1, 1.5, 0.2 }; // Iris virginica = 1 0 0
        allData[4] = new double[] { 5.0, 3.6, 1.4, 0.2 };
        allData[5] = new double[] { 5.4, 3.9, 1.7, 0.4 };
        allData[6] = new double[] { 4.6, 3.4, 1.4, 0.3 };
        allData[7] = new double[] { 5.0, 3.4, 1.5, 0.2 };
        allData[8] = new double[] { 4.4, 2.9, 1.4, 0.2 };
        allData[9] = new double[] { 4.9, 3.1, 1.5, 0.1 };

        allData[10] = new double[] { 7.0, 3.2, 4.7, 1.4 };
        allData[11] = new double[] { 6.4, 3.2, 4.5, 1.5 };
        allData[12] = new double[] { 6.9, 3.1, 4.9, 1.5 };
        allData[13] = new double[] { 5.5, 2.3, 4.0, 1.3 };
        allData[14] = new double[] { 6.5, 2.8, 4.6, 1.5 };
        allData[15] = new double[] { 5.7, 2.8, 4.5, 1.3 };
        allData[16] = new double[] { 6.3, 3.3, 4.7, 1.6 };
        allData[17] = new double[] { 4.9, 2.4, 3.3, 1.0 };
        allData[18] = new double[] { 6.6, 2.9, 4.6, 1.3 };
        allData[19] = new double[] { 5.2, 2.7, 3.9, 1.4 };
        
        allData[20] = new double[] { 6.3, 3.3, 6.0, 2.5 };
        allData[21] = new double[] { 5.8, 2.7, 5.1, 1.9 };
        allData[22] = new double[] { 7.1, 3.0, 5.9, 2.1 };
        allData[23] = new double[] { 6.3, 2.9, 5.6, 1.8 };
        allData[24] = new double[] { 6.5, 3.0, 5.8, 2.2 };
        allData[25] = new double[] { 7.6, 3.0, 6.6, 2.1 };
        allData[26] = new double[] { 4.9, 2.5, 4.5, 1.7 };
        allData[27] = new double[] { 7.3, 2.9, 6.3, 1.8 };
        allData[28] = new double[] { 6.7, 2.5, 5.8, 1.8 };
        allData[29] = new double[] { 7.2, 3.6, 6.1, 2.5 };
        
        allData[30] = new double[] { 5.4, 3.4, 1.7, 0.2 };
        allData[31] = new double[] { 5.1, 3.7, 1.5, 0.4 };
        allData[32] = new double[] { 4.6, 3.6, 1.0, 0.2 };
        allData[33] = new double[] { 5.1, 3.3, 1.7, 0.5 };
        allData[34] = new double[] { 4.8, 3.4, 1.9, 0.2 };
        allData[35] = new double[] { 5.0, 3.0, 1.6, 0.2 };
        allData[36] = new double[] { 5.0, 3.4, 1.6, 0.4 };
        allData[37] = new double[] { 5.2, 3.5, 1.5, 0.2 };
        allData[38] = new double[] { 5.2, 3.4, 1.4, 0.2 };
        allData[39] = new double[] { 4.7, 3.2, 1.6, 0.2 };       

        allData[40] = new double[] { 6.7, 3.1, 5.6, 2.4 };
        allData[41] = new double[] { 6.9, 3.1, 5.1, 2.3 };
        allData[42] = new double[] { 5.8, 2.7, 5.1, 1.9 };
        allData[43] = new double[] { 6.8, 3.2, 5.9, 2.3 };
        allData[44] = new double[] { 6.7, 3.3, 5.7, 2.5 };
        allData[45] = new double[] { 6.7, 3.0, 5.2, 2.3 };
        allData[46] = new double[] { 6.3, 2.5, 5.0, 1.9 };
        allData[47] = new double[] { 6.5, 3.0, 5.2, 2.0 };
        allData[48] = new double[] { 6.2, 3.4, 5.4, 2.3 };
        allData[49] = new double[] { 5.9, 3.0, 5.1, 1.8 };       
        
        double[][] targets = new double[50][];
        targets[0] = new double[] { 0, 0, 1 }; 
        targets[1] = new double[] { 0, 0, 1 };
        targets[2] = new double[] { 0, 0, 1 }; 
        targets[3] = new double[] { 0, 0, 1 }; 
        targets[4] = new double[] { 0, 0, 1 };
        targets[5] = new double[] { 0, 0, 1 };
        targets[6] = new double[] { 0, 0, 1 };
        targets[7] = new double[] { 0, 0, 1 };
        targets[8] = new double[] { 0, 0, 1 };
        targets[9] = new double[] { 0, 0, 1 };
        
        targets[10] = new double[] { 0, 1, 0 };
        targets[11] = new double[] { 0, 1, 0 };
        targets[12] = new double[] { 0, 1, 0 };
        targets[13] = new double[] { 0, 1, 0 };
        targets[14] = new double[] { 0, 1, 0 };
        targets[15] = new double[] { 0, 1, 0 };
        targets[16] = new double[] { 0, 1, 0 };
        targets[17] = new double[] { 0, 1, 0 };
        targets[18] = new double[] { 0, 1, 0 };
        targets[19] = new double[] { 0, 1, 0 };

        targets[20] = new double[] { 1, 0, 0 };
        targets[21] = new double[] { 1, 0, 0 };
        targets[22] = new double[] { 1, 0, 0 };
        targets[23] = new double[] { 1, 0, 0 };
        targets[24] = new double[] { 1, 0, 0 };
        targets[25] = new double[] { 1, 0, 0 };
        targets[26] = new double[] { 1, 0, 0 };
        targets[27] = new double[] { 1, 0, 0 };
        targets[28] = new double[] { 1, 0, 0 };
        targets[29] = new double[] { 1, 0, 0 };

        targets[30] = new double[] { 0, 0, 1 };
        targets[31] = new double[] { 0, 0, 1 };
        targets[32] = new double[] { 0, 0, 1 };
        targets[33] = new double[] { 0, 0, 1 };
        targets[34] = new double[] { 0, 0, 1 };
        targets[35] = new double[] { 0, 0, 1 };
        targets[36] = new double[] { 0, 0, 1 };
        targets[37] = new double[] { 0, 0, 1 };
        targets[38] = new double[] { 0, 0, 1 };
        targets[39] = new double[] { 0, 0, 1 };

        
        targets[40] = new double[] { 1, 0, 0 };
        targets[41] = new double[] { 1, 0, 0 };
        targets[42] = new double[] { 1, 0, 0 };
        targets[43] = new double[] { 1, 0, 0 };
        targets[44] = new double[] { 1, 0, 0 };
        targets[45] = new double[] { 1, 0, 0 };
        targets[46] = new double[] { 1, 0, 0 };
        targets[47] = new double[] { 1, 0, 0 };
        targets[48] = new double[] { 1, 0, 0 };
        targets[49] = new double[] { 1, 0, 0 };
        
        NeuralNet net = new NeuralNet(4, 7, 3);
        NetworkTrainer trainer = new NetworkTrainer(net);
        for(int i = 0; i < 2000; ++i) {
            System.out.println("Iteration: " + i);
            //net.train(data, t);      
            trainer.train(allData, targets);
            System.out.println();
        }
    }
}
