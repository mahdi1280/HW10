package question3.bythread;

import java.io.FileInputStream;
import java.io.IOException;

public class ThreadFileSize extends Thread{

    private long size=0;
    private boolean isFinish=false;
    private FileInputStream fileInputStream=null;

    @Override
    public void run(){
        while (true) {
            synchronized (this) {
                if(isFinish)
                    return;
                if (fileInputStream != null) {
                    try {
                        while (fileInputStream.read() != -1)
                            size += 1;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileInputStream = null;
                }
            }
        }
    }

    public synchronized void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public long getSize() {
        return size;
    }

    public synchronized void setFinish(boolean finish) {
        isFinish = finish;
    }
}
