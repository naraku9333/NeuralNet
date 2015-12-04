/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuralnet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Sean Vogel
 */
public class Main {
    public static void save(Object o, String file_name) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(file_name);
        ObjectOutputStream oos = new ObjectOutputStream(fout);   
        oos.writeObject(o);
    }
    public static Object load(String file_name) throws IOException {
        NeuralNet n = null;
        try {
            FileInputStream fin = new FileInputStream(file_name);
            ObjectInputStream ois = new ObjectInputStream(fin);
            n = (NeuralNet)ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
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
               
        // Iris setosa = 0 0 1 = 1
        // Iris versicolor = 0 1 0 = 2
        // Iris virginica = 1 0 0 = 3
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
        float[][] data = new float[150][4];
        int[] t = new int[150];
        readData(data, t);
        Random r = new Random();
        int[] is = r.ints(150, 0, 150).toArray();
        NeuralNet net = new NeuralNet(4, 20, 3);
        
        float[][] fs = new float[150][];
        int[] ts = new int[150];
        for(int k = 0; k < 150; ++k){
            fs[k] = data[is[k]];
            ts[k] = t[is[k]];
        }
        NetworkTrainer trainer = new NetworkTrainer(net);
        for(int i = 0; i < 1000; ++i) {
            //System.out.println("Iteration: " + i);
            //net.train(data, t);      
            trainer.train(fs, ts);
            //System.out.println();
        }
        
        try {
            save(net, "net.bin");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        float[][] test = new float[][] {
            { 5.1f, 3.8f, 1.9f, 0.4f }, { 5.6f, 2.7f, 4.2f, 1.3f }, { 6.5f, 3.0f, 5.8f, 2.2f },
            { 5.7f, 2.9f, 4.2f, 1.3f }, { 5.1f, 2.5f, 3.0f, 1.1f }, { 7.7f, 2.6f, 6.9f, 2.3f }
        };
        
        int[][] res = {{ 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 0, 0 }};
        
        NetworkTester tester = null;
        try {
            tester = new NetworkTester((NeuralNet)load("net.bin"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(tester != null) {
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
    
    public static void readData(float[][] data, int[] targets) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Iris-setosa", 1);
        map.put("Iris-versicolor", 2);
        map.put("Iris-virginica", 3);             
        
        int row = 0, col = 0;
        try {
            Scanner sc = new Scanner(new File("data/bezdekIris.data"));
            String s;
//            while((s = sc.nextLine()).equals("")) {
//                String[] a = s.split(",");
//                for(int i = 0; i < a.length-1; ++i){
//                    data[row][i] = Double.parseDouble(a[i]);               
//                }
//                targets[row] = map.get(a[a.length-1]);
//                ++row;
//            }
            for(int i = 0; i < 150; ++i){
                s = sc.nextLine();
                String[] a = s.split(",");
                for(int j = 0; j < a.length-1; ++j){
                    data[i][j] = Float.parseFloat(a[j]);//Double.parseDouble(a[j]);               
                }
                targets[i] = map.get(a[a.length-1]);
               // ++row;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
