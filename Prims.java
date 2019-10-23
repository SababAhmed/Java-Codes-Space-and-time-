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
import java.util.*;
import java.io.*;

public class Prims {

    /**
     * @param args the command line arguments
     */
    static Linkedlist lk = new Linkedlist();
    static int vertices;
    static int[][] wgraph;
    static boolean[] visited;
    static int weight;

    public static void main(String[] args) throws Exception {
        File f = new File("C:\\Users\\18101509\\Documents\\NetBeansProjects\\Dijsktra\\src\\dijsktra\\WeightedGraph");
        Scanner sc = new Scanner(f);
        vertices = sc.nextInt();
        wgraph = new int[vertices][vertices];
        int gx = 0;
        int gy = 0;
        int gw = 0;

        while (sc.hasNext()) {
            gx = sc.nextInt();
            gy = sc.nextInt();
            gw = sc.nextInt();
            wgraph[gx][gy] = gw;
            wgraph[gy][gx] = gw;
        }

        visited = new boolean[vertices];
        for (int c = 0; c < vertices; c++) {
            for (int d = 0; d < vertices; d++) {
                System.out.print(wgraph[c][d] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Traversal Path :");
        int start = 0;
        visited[0] = true;
        weight=0;
        System.out.print(start + " ");
        Linkedlist lk = new Linkedlist();

        for (int y = 1; y < vertices; y++) {
            for (int x = 0; x < vertices; x++) {
                if (visited[x] != true && wgraph[start][x] != 0) {
                    Node n = new Node(x, wgraph[start][x]);
                    lk.add(n);

                }
            }

            lk.head = sort(lk.head);
            boolean check = false;
            int wgt=0;
            while (check != true) {
                wgt=lk.weightreturn();
                start = lk.pop().x;
                
                if (visited[start] != true) {
                    check = true;
                }
            }
            weight=weight+wgt;
            System.out.print(start + " ");
            visited[start] = true;
        }
        
        System.out.println("");
        System.out.println("Minimum Weight : "+weight);

    }

    public static Node sort(Node h) {
        for (Node z = h; z.next != null; z = z.next) {
            for (Node z1 = h; z1.next != null; z1 = z1.next) {
                if (z1.w > z1.next.w) {
                    int tx = z1.x;
                    z1.x = z1.next.x;
                    z1.next.x = tx;
                    int tw = z1.w;
                    z1.w = z1.next.w;
                    z1.next.w = tw;
                }
            }
        }
        return h;
    }

}