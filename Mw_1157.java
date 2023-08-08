import java.util.Arrays;
import java.util.Scanner;

public class Mw_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 단어를 입력 받는다.
        String word = sc.next();

        // 입력 받은 단어를 하나의 알파벳으로 쪼갠 뒤 배열에 저장한다.
        char[] alphabet = word.toCharArray();

        // 알파벳을 셀 배열을 만든다.
        int[] cnt = new int[26];

        for(int idx = 0; idx < alphabet.length; idx++) {
            //char형을 비교할 때에는 equals 메서드가 아닌 등호를 사용한다.
            if(alphabet[idx] == 'A' || alphabet[idx] == 'a') {
                cnt[0]++;
            } else if (alphabet[idx] == 'B' || alphabet[idx] == 'b') {
                cnt[1]++;
            } else if (alphabet[idx] == 'C' || alphabet[idx] == 'c') {
                cnt[2]++;
            } else if (alphabet[idx] == 'D' || alphabet[idx] == 'd') {
                cnt[3]++;
            } else if (alphabet[idx] == 'E' || alphabet[idx] == 'e') {
                cnt[4]++;
            } else if (alphabet[idx] == 'F' || alphabet[idx] == 'f') {
                cnt[5]++;
            } else if (alphabet[idx] == 'G' || alphabet[idx] == 'g') {
                cnt[6]++;
            } else if (alphabet[idx] == 'H' || alphabet[idx] == 'h') {
                cnt[7]++;
            } else if (alphabet[idx] == 'I' || alphabet[idx] == 'i') {
                cnt[8]++;
            } else if (alphabet[idx] == 'J' || alphabet[idx] == 'j') {
                cnt[9]++;
            } else if (alphabet[idx] == 'K' || alphabet[idx] == 'k') {
                cnt[10]++;
            } else if (alphabet[idx] == 'L' || alphabet[idx] == 'l') {
                cnt[11]++;
            } else if (alphabet[idx] == 'M' || alphabet[idx] == 'm') {
                cnt[12]++;
            } else if (alphabet[idx] == 'N' || alphabet[idx] == 'n') {
                cnt[13]++;
            } else if (alphabet[idx] == 'O' || alphabet[idx] == 'o') {
                cnt[14]++;
            } else if (alphabet[idx] == 'P' || alphabet[idx] == 'p') {
                cnt[15]++;
            } else if (alphabet[idx] == 'Q' || alphabet[idx] == 'q') {
                cnt[16]++;
            } else if (alphabet[idx] == 'R' || alphabet[idx] == 'r') {
                cnt[17]++;
            } else if (alphabet[idx] == 'S' || alphabet[idx] == 's') {
                cnt[18]++;
            } else if (alphabet[idx] == 'T' || alphabet[idx] == 't') {
                cnt[19]++;
            } else if (alphabet[idx] == 'U' || alphabet[idx] == 'u') {
                cnt[20]++;
            } else if (alphabet[idx] == 'V' || alphabet[idx] == 'v') {
                cnt[21]++;
            } else if (alphabet[idx] == 'W' || alphabet[idx] == 'w') {
                cnt[22]++;
            } else if (alphabet[idx] == 'X' || alphabet[idx] == 'x') {
                cnt[23]++;
            } else if (alphabet[idx] == 'Y' || alphabet[idx] == 'y') {
                cnt[24]++;
            } else if (alphabet[idx] == 'Z' || alphabet[idx] == 'z') {
                cnt[25]++;
            }
        }

        // 최대로 사용한 알파벳의 수 max와 그 알파벳의 인덱스를 저장할 변수 index를 선언한다.
        int max = 0;
        int index = -1;

        for(int idx = 0; idx < cnt.length; idx++) {
            if(max < cnt[idx]) {
                max = cnt[idx];
                index = idx;
            }
        }

        // 아스키 코드를 활용한다. (A = 65)
        char code = (char)(index+65);

        Arrays.sort(cnt);
        if(cnt[cnt.length-1] == cnt[cnt.length-2]) {
            System.out.println("?");
        } else {
            System.out.println(code);
        }
    }
}
