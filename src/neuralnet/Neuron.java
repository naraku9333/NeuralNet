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
public class Neuron {
    private double value;
    private double error;
    
    /**
     * Links to neurons in next layer
     */
    public ArrayList<Link> forward;
    
    /**
     * Links to neurons in previous layer
     */
    public ArrayList<Link> backward;
    
    /**
     * Constructor
     */
    public Neuron() {
        forward = new ArrayList<>();
        backward = new ArrayList<>();
    }
    
    public double getValue() { return value; }
    public void setValue(double v) { value = v; }
    public double getError() { return error; }
    public void setError(double e) { error = e; }
}
