import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" W");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);
        pw.println(num1+num2);
        pw.flush();
        pw.close();

    }
}