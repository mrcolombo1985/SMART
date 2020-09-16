package application;

import application.Camera;
import com.googlecode.javacv.FrameGrabber;

public class CameraThread implements Runnable {
    private String data;
    private Integer i;

    public void run() {
        Camera camera = new Camera();
        try {
            camera.connectToCamera(data, i);
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
