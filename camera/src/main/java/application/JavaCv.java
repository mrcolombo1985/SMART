package application;

import application.CameraThread;

/**
 *
 */
public class JavaCv {


    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 2; i++) {
            CameraThread cameraThread = new CameraThread();
            cameraThread.setData("Hellow " + i);
            cameraThread.setI(i);
            Thread myThready = new Thread(cameraThread);
            myThready.start();
        }
    }
}