/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knighttraversal;

/**
 *
 * @author ASUS
 */
public class linkedlist {
    node head;
    node tail;
    linkedlist nextlist;
    public void add(node n){
        if(head==null){
            head=n;
            tail=head;
        }else{
            tail.next=n;
            tail=tail.next;
        }
    }
    
}

