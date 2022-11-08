package com.abhay.dsa_lab.bst_sum_pair_problem;

import java.util.HashSet;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static HashSet<Integer> data = new HashSet<>();

    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(20);
        root.right = new Node(60);
        root.left.left = new Node(10);
        root.left.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(70);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Target: ");
        int target = sc.nextInt();

        boolean pairExists = isPairFound(root, target);

        if(!pairExists)
            System.out.println("Pair doesn't exist");

    }

    public static boolean isPairFound(Node root, int target) {

        if(root == null)
            return false;


        int comp = target - root.data;

        if(data.contains(comp)) {
            System.out.println("Pair exists : " + comp + " & " + root.data);
            return true;
        }
        else
            data.add(root.data);

        return isPairFound(root.left, target) || isPairFound(root.right, target);
    }

}
