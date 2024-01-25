import java.io.File;
import java.util.Random;

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

    public String analyze() {
        Random random = new Random();
        BugType[] bugTypes = BugType.values();
        BugType bugType = bugTypes[random.nextInt(bugTypes.length)];
        return bugType.toString();
    }
}
