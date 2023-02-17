package pollutrack.gui.util;

import java.util.Objects;

import javax.swing.*;

public class ImageLoader {
    public static ImageIcon loadImageIcon(String path) {
        return new ImageIcon(Objects.requireNonNull(ImageLoader.class.getResource(path)));
    }
}
