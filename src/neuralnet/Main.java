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
                
        // sepal length, width, petal length, width        
        float[][] allData = new float[][] {
            { 5.1f, 3.5f, 1.4f, 0.2f }, { 4.9f, 3.0f, 1.4f, 0.2f }, { 4.7f, 3.2f, 1.3f, 0.2f }, { 4.6f, 3.1f, 1.5f, 0.2f }, 
            { 5.0f, 3.6f, 1.4f, 0.2f }, { 5.4f, 3.9f, 1.7f, 0.4f }, { 4.6f, 3.4f, 1.4f, 0.3f }, { 5.0f, 3.4f, 1.5f, 0.2f }, 
            { 4.4f, 2.9f, 1.4f, 0.2f }, { 4.9f, 3.1f, 1.5f, 0.1f }, { 7.0f, 3.2f, 4.7f, 1.4f }, { 6.4f, 3.2f, 4.5f, 1.5f }, 
            { 6.9f, 3.1f, 4.9f, 1.5f }, { 5.5f, 2.3f, 4.0f, 1.3f }, { 6.5f, 2.8f, 4.6f, 1.5f }, { 5.7f, 2.8f, 4.5f, 1.3f }, 
            { 6.3f, 3.3f, 4.7f, 1.6f }, { 4.9f, 2.4f, 3.3f, 1.0f }, { 6.6f, 2.9f, 4.6f, 1.3f }, { 5.2f, 2.7f, 3.9f, 1.4f },
            { 6.3f, 3.3f, 6.0f, 2.5f }, { 5.8f, 2.7f, 5.1f, 1.9f }, { 7.1f, 3.0f, 5.9f, 2.1f }, { 6.3f, 2.9f, 5.6f, 1.8f }, 
            { 6.5f, 3.0f, 5.8f, 2.2f }, { 7.6f, 3.0f, 6.6f, 2.1f }, { 4.9f, 2.5f, 4.5f, 1.7f }, { 7.3f, 2.9f, 6.3f, 1.8f }, 
            { 6.7f, 2.5f, 5.8f, 1.8f }, { 7.2f, 3.6f, 6.1f, 2.5f }, { 5.4f, 3.4f, 1.7f, 0.2f }, { 5.1f, 3.7f, 1.5f, 0.4f }, 
            { 4.6f, 3.6f, 1.0f, 0.2f }, { 5.1f, 3.3f, 1.7f, 0.5f }, { 4.8f, 3.4f, 1.9f, 0.2f }, { 5.0f, 3.0f, 1.6f, 0.2f }, 
            { 5.0f, 3.4f, 1.6f, 0.4f }, { 5.2f, 3.5f, 1.5f, 0.2f }, { 5.2f, 3.4f, 1.4f, 0.2f }, { 4.7f, 3.2f, 1.6f, 0.2f },       
            { 6.7f, 3.1f, 5.6f, 2.4f }, { 6.9f, 3.1f, 5.1f, 2.3f }, { 5.8f, 2.7f, 5.1f, 1.9f }, { 6.8f, 3.2f, 5.9f, 2.3f }, 
            { 6.7f, 3.3f, 5.7f, 2.5f }, { 6.7f, 3.0f, 5.2f, 2.3f }, { 6.3f, 2.5f, 5.0f, 1.9f }, { 6.5f, 3.0f, 5.2f, 2.0f }, 
            { 6.2f, 3.4f, 5.4f, 2.3f }, { 5.9f, 3.0f, 5.1f, 1.8f }       
        };
               
        // Iris setosa = 0 0 1
        // Iris versicolor = 0 1 0
        // Iris virginica = 1 0 0
        int[][] targets = new int[][] {
            { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 },
            { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 },
            { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 },
            { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 },
            { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 },
            { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 },
            { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 },
            { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 }, { 0, 0, 1 },
            { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 },
            { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }
        };
        
        NeuralNet net = new NeuralNet(4, 20, 3);
        NetworkTrainer trainer = new NetworkTrainer(net);
        for(int i = 0; i < 1000; ++i) {
            //System.out.println("Iteration: " + i);
            //net.train(data, t);      
            trainer.train(allData, targets);
            //System.out.println();
        }
        
        float[][] test = new float[][] {
            { 5.1f, 3.8f, 1.9f, 0.4f }, { 5.6f, 2.7f, 4.2f, 1.3f }, { 6.5f, 3.0f, 5.8f, 2.2f },
            { 5.7f, 2.9f, 4.2f, 1.3f }, { 5.1f, 2.5f, 3.0f, 1.1f }, { 7.7f, 2.6f, 6.9f, 2.3f }
        };
        
        int[][] res = {{ 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 0, 0 }};
        
        NetworkTester tester = new NetworkTester(net);
        
        int[] results = new int[res.length];
        tester.test(test, results);
        
        for(int i = 0; i < results.length; ++i) {
            System.out.print("Expected = {");
            for(int j = 0; j < res[i].length; ++j) {
                System.out.print(res[i][j]+",");
            }
            System.out.print("\b}\tActual = ");
            System.out.println(results[i]);
        }
    }
}
