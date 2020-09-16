package facerecognition.gui;


import facerecognition.javafaces.FaceRec;

import java.awt.*;

public class FaceRecMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FaceRecView view = new FaceRecView("FACE RECOGNITION");
                FaceRec model = new FaceRec();
                new SimpleController(view, model);
            }
        });
    }

    public static void debug(String msg) {
        System.out.println(msg);
    }
}


