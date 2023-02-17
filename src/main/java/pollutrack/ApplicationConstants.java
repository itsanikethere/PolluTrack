package pollutrack;

import pollutrack.gui.util.ImageLoader;

import java.awt.*;
import javax.swing.*;

public class ApplicationConstants {
    public final static Image APP_ICON = ImageLoader
            .loadImageIcon("/icons/app.png")
            .getImage();

    public final static ImageIcon APP_ICON_SMALL = ImageLoader
            .loadImageIcon("/icons/app-small.png");

    public final static String APP_NAME = "PolluTrack";
}
