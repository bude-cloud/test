import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Mock {
    public static void main(String[] args) throws IOException {

        String file = "D:\\Project\\Xmind\\NUMS\\merge.txt";
        String [] names = {"av","ere","drfe","dfd","pok","wdf","sf","df","gth","oiu","vbxz","fgf"};
        FileWriter writer = new FileWriter(file);

        BufferedWriter bw = new BufferedWriter(writer);
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        for (int i = 0; i < 6000; i++) {
            sb.append(rd.nextInt(10000)).append(",").append(names[rd.nextInt(names.length)]).append(",").append(System.currentTimeMillis()).append(",").append("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq").append("\n");
            bw.write(sb.toString());
        }
        bw.close();


    }



}
