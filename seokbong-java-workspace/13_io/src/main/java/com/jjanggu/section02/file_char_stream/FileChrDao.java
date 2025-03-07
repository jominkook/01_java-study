package com.jjanggu.section02.file_char_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChrDao {

    /*
        ## FileWriter / FileReader ##
        - File : 파일과 연결되는 기반스트림
        - Writer/Reader : 데이터를 2byte 단위로 입출력하는 문자스트림
     */

    public void fileSave() {
        // FileWriter

        FileWriter fw =null;
        try {
            //
            fw = new FileWriter("b_char.txt");

            // 2. 데이터 출력 (2byte 단위로 데이터 전송)
            fw.write(54616); // '하'
            fw.write("와! IO 재밌다..ㅎ");
            fw.write('A');
            fw.write("\n");

            char[] arr = new char[]{'a', 'p', 'p','l', 'e' };
            fw.write(arr);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void fileRead(){
        // FileReader

        // 실습. 파일 읽어들이기
        FileReader fr = null;
        try {
            fr = new FileReader("b_char.txt");


            int value= 0;
            while ((value = fr.read()) != -1){
                System.out.print((char)value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
