package question3.bythread;

public class FileSize {

    private long size=0;

    public synchronized long getSize() {
        return size;
    }

    public synchronized void setSize(long size) {
        this.size = size;
    }
}
