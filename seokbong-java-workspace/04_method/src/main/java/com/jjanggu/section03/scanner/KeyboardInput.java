package com.jjanggu.section03.scanner;

import java.util.Scanner;
import java.util.SortedMap;

public class KeyboardInput {

    /*
        ## Scanner == java.util.Scanner ##
        1. 사용자로부터 입력되는 정수, 실수, 문자열을 처리하는 클래스
        2. 입력값이 담겨있는 버퍼로부터 메모리상으로 값을 읽어들일 수 있음
        3. java.util 에서 제공됨
        4. 주요 제공 메소드
           1) next()       : 입력된 값을 String형으로 반환함 (공백 이전까지의 한 토큰)
           2) nextLine()   : 입련된 값을 String형으로 반환함 (개행 이전까지의 전체 토큰)
           3) nextInt()    : 입력된 값을 int형으로 반환함
           4) nextDouble() : 입련된 값을 double형으로 반환함
        5. 사용방법
           1) Scanner 객체 생성 (import 사용)
           2) 메소드 호출
     */
    public void testBasicScanner() {

        java.util.Scanner sc = new java.util.Scanner(System.in); // System.in : 입력받은 값을 바이트단위로 읽어 들이겠다는걸 의미

        System.out.print("인사말 입력 : ");
        //String greetingMsg = sc.next();
        String greetingMsg = sc.nextLine(); // 여러 단어가 입력될 여지가 있을 경우 사용

        System.out.print("나이 입력 : ");
        int age = sc.nextInt();

        System.out.println("키 입력 : ");
        double height = sc.nextDouble();

        System.out.println("입력하신 인사말은 '" + greetingMsg + "'입니다");
        System.out.println("입력하신 나이는 '" + age + "'입니다.");
        System.out.println("입력하신 키는 '" + height + "'입니다.");

    }

    public void testScannerExample1() {
        Scanner sc = new Scanner(System.in);

        /*
            실습.
            사용자에게 이름, 학교, 학년, 반 순서로 정보를 입력받아 출력
         */
        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("학교 : ");
        String school = sc.nextLine();

        System.out.print("학년 : ");
        int grade = sc.nextInt();

        System.out.print("반 : ");
        int classNum = sc.nextInt();

        System.out.printf("%s에 다니는 %d학년 %d반 학생 %s님", school,grade, classNum, name);

    }

    public void testWarningCase1() {

        /*
            ## Scanner 사용시 유의사항 1 ##
            nextLine()을 제외한 메소드 (next(0, nextInt(), nextDouble(), .. emfdms)
            공백(space) 기준으로 토큰들을 분리해서 하나의 토큰을 가져옴
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("주소 입력 : "); // "서울시 강서구" 입력
        String address = sc.next();       // "서울시: 토큰만 읽어들여지고 "강서구'  토큰은 버퍼에 남아있는 상태

        System.out.print("나이 입력 : "); // 입력도 하기 전에
        int age = sc.nextInt();           // 버퍼에 남아있는 "강서구" 토큰이 곧바로 읽어들여짐
        // int 자료형에 부적합한 문자열이므로 타입출일치 예외(InputMismatchExceptio

        System.out.println(address);
        System.out.println(age);

        /*
            ## 해결방법 ##
            여러단어가 입력될 여지가 있을 경우 nextLine()으로 문자열을 입력받자
         */
    }

    public void testWarningCase2() {
        /*
            ## Scanner 사용시 유의사항 2 ##
            nextLine()은 개행(enter, \n)을 토큰 구분자로 인식함
            그리고 버퍼 내에 개행을 감지하여 개행이 존재할 경우 입력되었다 간주해서 값을 읽어들임
            nextLine()을 제외한 메소드들은 토큰을 읽어들인 후 개행문자를 제거해주지 않음
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("이름 : "); // "김땡땡" 입력
        String name = sc.nextLine(); // "김땡땡" 읽어들여진 후 개행 제거

        System.out.print("나이 : "); // 12 입력
        int age = sc.nextInt();      // 12 읽어들인 후 개행 제거 안함(버퍼에 개행이 남아있는 상태)

        sc.nextLine(); // 해결방법 : 버퍼지우기

        System.out.print("주소  : "); // 입력도 하기 전에
        String address = sc.nextLine(); // 버퍼에 개행이 남아있어 입력되었다고 간주되어 곧바로 읽어들여짐

        System.out.println(age + "살" + name + "님은" + address + "에 삽니다.");

        /*
            ## 해결방법 ##
            nextLine()을 제외한 메소드들이 실행된 후 nextLine()이 오게될 경우 발생
            버퍼에 남아 있는 개행을 제거하고 nextLine() 수행될 수 있도록
            개행을 지우기 위한 sc.nextLine() 한 번 써주기
         */


    }

    public void testSpecialCase() {
        /*
            ## 문자형으로 값 입력받기 ##
            Scanner 에서는 char형(문자형)으로 값을 반환하는 메소드를 제공 X
            문자와 밀접하게 연관있는 문자열로 값을 읽어들인 후
            원하는 순번(자바에서는 인덱스)째의 문자를 반환받아 기록하면됨

            ex)      "apple"        => 문자열 (String)
                 0   1   2   3   4  => 인덱스 (위치)
                'a' 'p' 'p' 'l' 'e' => 문자(char)

                문자열.charAt(인덱스) => 해당 문자열의 해당 인덱스자리의 문자 반환
         */
        /*
        String fruit = "apple";

        char ch = fruit.charAt(4);

        System.out.println(ch);
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("성별(M/F) 입력 : ");
        char gender = sc.nextLine().charAt(0);

        System.out.println(gender);
    }

    public void testScannerExample2() {
        /*
            실습.
            사용자에게 등록할 상품에 대한 정보 입력받기
            상품명(String), 브랜드명(String), 가격(int), 제조국가(String),
            할인률(double), 등급(char)(A~D) 순으로 입력 후 출력
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("등록할 상품 정보를 입력하시오.");

        System.out.print("\n상품명 입력 : ");
        String product = sc.nextLine();

        System.out.print("브랜드명 입력 : ");
        String brand = sc.nextLine();

        System.out.print("가격 입력 : ");
        int price = sc.nextInt();

        sc.nextLine();

        System.out.print("제조국가 입력 : ");
        String country = sc.nextLine();

        System.out.print("할인율 입력 : ");
        double discountRate = sc.nextDouble();

        sc.nextLine();

        System.out.print("등급 입력(A~D) : ");
        char grade = sc.nextLine().charAt(0);

        System.out.printf("%s의 상품정보 \n브랜드 : %s \n가격 : %d원 \n제조국가 : %s" +
                          "\n할인율 : %.0f%% \n등급 : %s>", product, brand, price, country, discountRate, grade);
    }
}
