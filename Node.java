/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prims;

/**
 *
 * @author 18101509
 */
public class Node {
    int x;
    int y;
    int w;
    Node next;
    public Node(int x,int w){
        this.x=x;
        this.w=w;
        next=null;
    }
    
}