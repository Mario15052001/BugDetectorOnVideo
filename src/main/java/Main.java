public class Main {
    public static void main(String[] args) {
        BugDetectorOnVideo bugDetectorOnVideo = new BugDetectorOnVideo();
        bugDetectorOnVideo.setPath("C:\\Users\\Mario Autore\\Desktop\\uni\\Laurea\\Progetto\\video.mp4");
        if(bugDetectorOnVideo.setVideo()) {
            System.out.println(bugDetectorOnVideo.analyze());
        }
    }
}