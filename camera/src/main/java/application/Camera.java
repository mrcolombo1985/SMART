package application;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;

import java.io.IOException;

public class Camera {


    public void connectToCamera(String data, Integer i) throws FrameGrabber.Exception {
        OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("http://192.168.43.1:8080/video?dummy=param.mjpg");
        frameGrabber.setFormat("mjpeg");
        frameGrabber.start();
        opencv_core.IplImage iPimg = frameGrabber.grab();
        CanvasFrame canvasFrame = new CanvasFrame(data);
        canvasFrame.setCanvasSize(iPimg.width() / 2, iPimg.height() / 2);
        canvasFrame.setLocation(0, 0);
        canvasFrame.setResizable(false);
        while (canvasFrame.isVisible() && (iPimg = frameGrabber.grab()) != null) {

            FaceDetection faceDetection = new FaceDetection();
            opencv_core.IplImage iPimgX = null;
            try {
                iPimgX = faceDetection.FaceDetections(iPimg, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            canvasFrame.showImage(iPimgX);
        }
        frameGrabber.stop();
        canvasFrame.dispose();
        System.exit(0);
    }
}
