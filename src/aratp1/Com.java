/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aratp1;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;
/**
 *
 * @author p1507338
 */
public class Com {
    public static final int SERVER_PORT = 6969;
    
    DatagramSocket ds;
    DatagramPacket dp;
    
    public Com(){
        try{
            ds = new DatagramSocket();
        }catch (SocketException se){
            System.out.println("Client runtime interrupted (SocketException):");
            System.out.println(se.getMessage());
        }
    }
    
    public Com(int port){
        try{
            ds = new DatagramSocket(port);
        }catch (SocketException se){
            System.out.println("Server runtime interrupted (SocketException):");
            System.out.println(se.getMessage());
        }
    }
    
    protected void send(String data, InetAddress ip, int port){
        DatagramPacket dp = new DatagramPacket(data.getBytes(), 
                                                data.getBytes().length, 
                                                ip, port);
        try{
            ds.send(dp);
        }catch(IOException ioe){
            System.out.println("Runtime interrupted (SocketException) :");
            System.out.println(ioe.getMessage());
        }
        
    }
    
    //returns an ArrayList of all unused (UDP) ports and displays the busy ones
    public static ArrayList<Integer> scan(int dep, int fin){
        ArrayList<Integer> portList = new ArrayList<>();
        DatagramSocket ds;
        System.out.println("Ports occupés :");
        
        for (int i=dep; i<=fin; ++i){
            try{
                ds = new DatagramSocket(i);
                portList.add(i);
                
            }catch (SocketException se){
                System.out.println(i);
            }
        }
        
        
        return portList;
    }
    
    
}
