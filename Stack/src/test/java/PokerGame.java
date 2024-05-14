import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerGame {
    // 定义扑克牌序列

    List<Character> cards = new ArrayList<>();
    public void input() {
        Scanner scanner = new Scanner(System.in);

        String numStr = scanner.nextLine();
        int num = Integer.parseInt(numStr);
        String cardsStr = scanner.nextLine();
        // 将输入的牌号序列分割成字符串数组
        String[] cardsStrs = cardsStr.split(" ");
        // 将字符串转换为整数并添加到列表中
        for (String card : cardsStrs) {
            cards.add(card.charAt(0));
        }
        scanner.close(); // 关闭 Scanner 对象
    }

    public void solve() {
        boolean isExit = false;
        while (!isExit) {
            for (int i = 0; i < cards.size()-2; i++) {
                if(cards.get(i) == cards.get(i+1) && cards.get(i+1) == cards.get(i+2)) {
                    cards.remove(i);
                    cards.remove(i);
                    cards.remove(i);
                    break;
                }
            }
        }
    }

    public void track() {
        for (int i = 0; i < cards.size()-2; i++) {
            if(cards.get(i) == cards.get(i+1) && cards.get(i+1) == cards.get(i+2)) {
                cards.remove(i+2);
                cards.remove(i+1);
                cards.remove(i);
                track();
                return;
            }
        }
    }

    public String getAns() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cards.size(); i++) {
            sb.append(cards.get(i));
            if( i != cards.size()-1) {
                sb.append(" ");
            }
        }
        return  cards.size() > 0 ? sb.toString() : "0";
    }
}

class TestPokerGame {
    public static void main(String[] args) {
        PokerGame pokerGame = new PokerGame();
        pokerGame.input();
        pokerGame.track();
        String ans = pokerGame.getAns();
        System.out.println(ans);
    }
}