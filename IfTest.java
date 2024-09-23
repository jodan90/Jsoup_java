import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class IfTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Best Price");
            System.out.println("2. Gold Trade");
            System.out.println("3. Rank Win");
            System.out.println("4. Rank Win Streak");
            System.out.println("5. 종료");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String url = "https://fconline.nexon.com/datacenter/dailytrade";

            String sel = "";
            switch (choice) {
                case 1:
                    sel = "bestPrice";
                    break;
                case 2:
                    sel = "goldTrade";
                    break;
                case 3:
                    sel = "rankWin";
                    break;
                case 4:
                    sel = "rankWinSt";
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    continue;
            }

            try {
                Document doc = Jsoup.connect(url).get();
                Element element = doc.getElementById(sel);

                if (element == null) {
                    System.out.println("해당 데이터가 없습니다.");
                } else {
                    String info = element.text();
                    System.out.println(info);
                }
            } catch (IOException e) {
                System.out.println("통신 중 오류 발생: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("알 수 없는 오류 발생: " + e.getMessage());
            }
        }

    }
} 