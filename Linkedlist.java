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
public class Linkedlist {
    Node head;
    Node tail;
    public void add(Node n){
        if(head==null){
            head=n;
            tail=head;
        }else{
            tail.next=n;
            tail=tail.next;
        }
    }
    public Node pop(){
        Node p=head;
        head=head.next;
        return p;
    }
    public int peek(){
        return head.x;
    }
    public int weightreturn(){
        return head.w;
    }
}