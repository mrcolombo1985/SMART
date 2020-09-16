package application;

import com.googlecode.javacv.cpp.opencv_core.*;
import com.googlecode.javacv.cpp.opencv_objdetect.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_objdetect.*;

@SuppressWarnings("unused")
public class FaceDetection {
    private static final int SCALE = 2;
    public int j = 0, k = 0, no, total;
    public String timeStamp;
    public int w = 0, h = 0, distance = 0;
    public String viewers, dist;
    FileWriter out;

    public IplImage FaceDetections(IplImage origImg, int no) throws IOException {
        out = new FileWriter("D:/log.csv", true);
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
        if (no == 1) {
            out.append("\n From " + timeStamp + "\n");
            out.append("Serial No,Face Coordinates,Face No,TimeStamp,Distance,count\n");
        }
        String CASCADE_FILE = "C:/opencv/data/haarcascades/haarcascade_frontalface_alt2.xml";
        try {
            IplImage grayImg = IplImage.create(origImg.width(), origImg.height(), IPL_DEPTH_8U, 1);
            cvCvtColor(origImg, grayImg, CV_BGR2GRAY);
            IplImage smallImg = IplImage.create(grayImg.width() / SCALE, grayImg.height() / SCALE, IPL_DEPTH_8U, 1);
            cvResize(grayImg, smallImg, CV_INTER_LINEAR);
            IplImage equImg = IplImage.create(smallImg.width(), smallImg.height(), IPL_DEPTH_8U, 1);
            cvEqualizeHist(smallImg, equImg);
            CvMemStorage storage = CvMemStorage.create();
            CvHaarClassifierCascade cascade = new CvHaarClassifierCascade(cvLoad(CASCADE_FILE));
            CvSeq faces = cvHaarDetectObjects(equImg, cascade, storage, 1.1, 3, CV_HAAR_DO_CANNY_PRUNING);
            cvClearMemStorage(storage);
            cvReleaseHaarClassifierCascade(cascade);
            total = faces.total();
            for (int i = 1; i <= total; i++) {
                CvRect r = new CvRect(cvGetSeqElem(faces, i));
                cvRectangle(origImg, cvPoint(r.x() * SCALE, r.y() * SCALE), cvPoint((r.x() + r.width()) * SCALE, (r.y() + r.height()) * SCALE), CvScalar.BLUE, 2, CV_AA, 0);
                String strRect = String.format("%d-%d-%d-%d ", r.x(), r.y(), r.width(), r.height());
                out.append(no + "," + strRect + "," + i + " ," + timeStamp + "," + distance + "," + total + "\n");
                System.out.println(" " + strRect);
            }
            out.flush();
            out.close();
            CvSeq.deallocateReferences();
        } catch (Exception e) {
            System.out.println("Exception FD" + e);

        }
        IplImage equImg = null;
        IplImage smallImg = null;
        IplImage grayImg = null;
        return origImg;
    }
}
