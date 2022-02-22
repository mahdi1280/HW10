package question3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long start= System.currentTimeMillis();
        File ff=new File("test");//todo D:\دیج کالا\مهپاش میست اسپری
        long size=0;
        for(File f:ff.listFiles()) {
            try(FileInputStream fileInputStream = new FileInputStream(f);) {
                while (fileInputStream.read()!=-1)
                    size++;
            }catch (FileNotFoundException fileNotFoundException){
                System.out.println(fileNotFoundException.getMessage());
            }
        }
        long end= System.currentTimeMillis();
        System.out.println("time: "+(end-start));
        System.out.println(size);
    }
}
