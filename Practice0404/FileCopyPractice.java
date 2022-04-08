package Practice0404;

import java.io.*;

public class FileCopyPractice {
    public static void main(String[] args) {

        BufferedReader br = null;
        PrintWriter pw = null;

        if (args.length != 2) {
            System.out.println("두개의 파일 명을 올바르게 지정하십십시오");
            return;
        }

        try {
            br = new BufferedReader(new FileReader(args[0]));
            pw = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));

            String str;

            while ((str = br.readLine()) != null) {
                pw.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일명이 잘못되었습니다.");
        } catch (IOException e) {
            System.out.println("입출력 오류입니다.");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (pw != null) {
                pw.close();
            }
        }
    }
}


