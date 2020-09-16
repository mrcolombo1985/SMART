package facerecognition.gui;

import facerecognition.utils.Utils;

import javax.swing.*;
import javax.swing.filechooser.FileView;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ThumbNailView extends FileView {
    @Override
    public Icon getIcon(File f) {
        Icon icon = null;
        try {
            if (Utils.isImageFile(f.getPath())) {
                icon = createImageIcon(f.getPath(), null);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return icon;
    }

    private ImageIcon createImageIcon(String path, String description) {
        if (path != null) {
            ImageIcon icon = new ImageIcon(path);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(16, -1, java.awt.Image.SCALE_DEFAULT);
            return new ImageIcon(newimg);
        } else {
            //System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
