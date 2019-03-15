/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia2_readdb;
/**
 *
 * @author wabzs
 */
public class test_class {
    
     static{
        System.loadLibrary("native");
    }
     
    private native String sayHello(String x);
    
    public static void main(String args[]) {
      String result = new test_class().sayHello("Hello from Java");
      System.out.println("In Java, the returned string is: " + result);
    }   
    
}
