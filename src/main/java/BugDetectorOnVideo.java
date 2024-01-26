import java.io.File;
import java.util.Random;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;

public class BugDetectorOnVideo {
    private String path;

    enum BugType {
        NULL_POINTER_EXCEPTION,
        ARRAY_INDEX_OUT_OF_BOUNDS,
        DIVISION_BY_ZERO,
        INFINITE_LOOP,
        MEMORY_LEAK
    }
    public void setPath(String path) {
        this.path = path;
    }
    public boolean setVideo() {
        File video = new File(this.path);
        if (!video.exists()) {
            System.out.println("File does not exist");
            return false;
        } else {
            System.out.println("File exists");
            return true;
        }
    }
    public String analyze(){
        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(this.path)) {
            CanvasFrame canvasFrame = new CanvasFrame("Bug Detector");
            grabber.start();
            System.out.println("Grabber avviato con successo");
            canvasFrame.setCanvasSize(grabber.getImageWidth(), grabber.getImageHeight());
            Frame frame;
            while ((frame = grabber.grab()) != null) {
                canvasFrame.showImage(frame);
            }
            canvasFrame.dispose();
            grabber.stop();
            System.out.println("Video analizzato");
        } catch (Exception e) {
            System.err.println("Errore durante l'acquisizione del frame: " + e.getMessage());
            e.printStackTrace();
        }
        Random random = new Random();
        BugType[] bugTypes = BugType.values();
        BugType bugType = bugTypes[random.nextInt(bugTypes.length)];
        return bugType.toString();
    }
}
