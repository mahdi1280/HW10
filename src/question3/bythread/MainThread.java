package question3.bythread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) throws IOException, InterruptedException {
        long start= System.currentTimeMillis();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the address: ");
        String address = scanner.nextLine();
        System.out.println("enter the count thread: ");
        int count=scanner.nextInt();
        List<ThreadFileSize> threadFileSizes=new ArrayList<>();
        for(int i=0;i<count;i++) {
            threadFileSizes.add(new ThreadFileSize());
            threadFileSizes.get(i).start();
        }
        File ff=new File(address);// TODO: 2/16/2022 "D:\\دیج کالا"
        int i=0;
        for(File f:ff.listFiles()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(f);
                threadFileSizes.get(i).setFileInputStream(fileInputStream);
            }catch (FileNotFoundException fileNotFoundException){
                System.out.println(fileNotFoundException.getMessage());
            }
            i++;
            if(i==threadFileSizes.size())
                i=0;
        }
        int counter=0;
        for(int j=0;j<count;j++) {
            threadFileSizes.get(j).setFinish(true);
            threadFileSizes.get(j).join();
            counter+=threadFileSizes.get(j).getSize();
        }
        long end= System.currentTimeMillis();
        System.out.println("time: "+(end-start));
        System.out.println("size: "+ counter);
    }
}
