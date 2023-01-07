package org.example.user4;

import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.example.user4.ObjectSizeCalculator.getObjectSize;

public class Main {

    public static void main(String[] args) {



//        out.println(GraphLayout.parseInstance(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                out.println("kekeke");
//            }
//        })).totalSize() / 1024000f + " MB");
//
//        out.println(GraphLayout.parseInstance(new Thread()).totalSize() / 1024000f + " MB");
//        out.println(GraphLayout.parseInstance(new Thread()).totalSize() / 1024000f + " MB");
//
//        out.println(GraphLayout.parseInstance(new Runnable() {
//            @Override
//            public void run() {
//                out.println("kekeke");
//            }
//        }).totalSize() / 1024000f + " MB");
//
//        List<Thread> threads = new ArrayList<>();
//        threads.add(new Thread());
//
//        out.println(GraphLayout.parseInstance(threads).totalSize() / 1024000f + " MB");
//        List<Thread> threads1 = new ArrayList<>();
//        threads.add(new Thread());
//        threads.add(new Thread());
//        threads.add(new Thread());
//        threads.add(new Thread());

        out.println(GraphLayout.parseInstance(new Thread()).toFootprint());

    }

}