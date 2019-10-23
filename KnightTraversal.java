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
import java.util.*;
public class KnightTraversal {

 static int countstep = 0;//to count the necessary steps 
    static int l = 8;//maximum value of x and y axis 
    static int p;//value of destiny of x axis
    static int q;//value of destiny of y axis
    static boolean v[][] = new boolean[l][l];//all 64 rooms which are not visited
    static int m[][] = new int[8][8];//taking the graph for all 64 rooms
    static int flag = 0;//to identify when the destination has been reached

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt() - 1;//taking the starting point of x axis
        int a2 = sc.nextInt() - 1;//taking the starting point of y axis
        m[a1][a2] = 1;//to mark that this is the starting point  
        v[a1][a2]=true;//to mark that this has bee visited and we will not come back to this point
        p = sc.nextInt() - 1;//taking the x axis of our destination
        q = sc.nextInt() - 1;//taikng the y axis of our destination
        m[p][q] = 1;//marking the room so that we can identify when we have reached it
        node start = new node(a1, a2, null);//making the node of the starting point
        linkedlist f = new linkedlist();//making a linked list of it so that we can use the recursive method
        f.add(start);//adding the starting point to the linkedlist
        steps(f);// satrting the method to find the steps
        System.out.println("Moves Needed : "+countstep);//printing the needed steps
    }

    public static void steps(linkedlist l) {
        countstep++;//counting steps
        node h = l.head;//taking the head from the linked list. this head will give us his next possible
                        //movements and the linked list will give us all possible moves from that each nodes in the linkedlist
        linkedlist lk = new linkedlist();
        //we are taking a linkedlist because we want to add all the possible next steps of a level
        while (h != null && flag==0 ) {
            lk=checkmoves(h, lk);//we will add all the possible steps of next level here
            h = h.next;
        }
        if (flag == 0) {//the recurtion will stop as soon as we reach our destination
            steps(lk);
        }
    }

    public static linkedlist checkmoves(node n, linkedlist lk) {
        //this method is to find all 8 possible steps from our current position
        int x = n.x;//taking the x axis of our current position
        int y = n.y;//taking the y axis of our current position
        if ((x + 2 < l) && (y + 1 < l) && v[x + 2][y + 1] == false) {//we are checking if this step can be taken or not and if the room is already visited or not
            v[x + 2][y + 1] = true;//if the step is possible then we will visit it and mark it as visited
            if (m[x + 2][y + 1] == 1) {
                flag = 1;//if it is our destined path than we will raise the flag
            } else {
                node z1 = new node(x + 2, y + 1, null);//if we find that it is not our destined room but is a possible path to go to our destiny
                lk.add(z1);//than we will add it to our linkedlist to find if it is possible to rach our destiny from this point
            }
        }
        if (x + 2 < l && (y - 1 >= 0) && v[x + 2][y - 1] == false) {
            v[x + 2][y - 1] = true;
            if (m[x + 2][y - 1] == 1) {
                flag = 1;
            } else {
                node z2 = new node(x + 2, y - 1, null);
                lk.add(z2);
            }
        }
        if (( x - 2 >= 0) && y + 1 < l && v[x - 2][y + 1] == false) {
            v[x - 2][y + 1] = true;
            if (m[x - 2][y + 1] == 1) {
                flag = 1;
            } else {
                node z3 = new node(x - 2, y + 1, null);
                lk.add(z3);
            }
        }
        if ((x - 2 >= 0) && ( y - 1 >= 0) && v[x - 2][y - 1] == false) {
            v[x - 2][y - 1] = true;
            if (m[x - 2][y - 1] == 1) {
                flag = 1;
            } else {
                node z4 = new node(x - 2, y - 1, null);
                lk.add(z4);
            }
        }
        if (x + 1 < l && y + 2 < l && v[x + 1][y + 2] == false) {
            v[x + 1][y + 2] = true;
            if (m[x + 1][y + 2] == 1) {
                flag = 1;
            } else {
                node z5 = new node(x + 1, y + 2, null);
                lk.add(z5);
            }
        }
        if ((x - 1 >= 0) && y + 2 < l && v[x - 1][y + 2] == false) {
            v[x - 1][y + 2] = true;
            if (m[x - 1][y + 2] == 1) {
                flag = 1;
            } else {
                node z6 = new node(x - 1, y + 2, null);
                lk.add(z6);
            }
        }
        if (x + 1 < l && (y - 2 >= 0) && v[x + 1][y - 2]== false) {
        v[x + 1][y - 2]=true;
            if (m[x + 1][y - 2] == 1) {
                flag = 1;
            } else {
                node z7 = new node(x + 1, y - 2, null);
                lk.add(z7);
            }
        }
        if (x - 1 >= 0 && (y - 2 >= 0) && v[x - 1][y - 2] == false) {
            v[x - 1][y - 2] = true;
            if (m[x - 1][y - 2] == 1) {
                flag = 1;
            } else {
                node z8 = new node(x - 1, y - 2, null);
                lk.add(z8);
            }
        }
        return lk;//we will gather and all the possible steps in the linkedlist andsend the linkedlist back
    }

}

