import org.junit.jupiter.api.Test;

import java.lang.invoke.VarHandle;
import java.util.Scanner;

/**
 * ClassName: IpConvert
 * Package: PACKAGE_NAME
 *
 * @Author jjt
 * @Create 2024/4/18 18:43
 * @Version 1.0
 * Description:
 */
public class IpConvert {

    Scanner in = new Scanner(System.in);

    // 192.168.0.1
    public long solve(String ipStr) {
        String[] split = ipStr.split("\\.");
        int[] ipNum = new int[4];
        long ans = 0;
        for (int i = 3; i >= 0 ; i--) {
            int num = Integer.parseInt(split[i]);
            ans += Math.pow(256, (3-i)) * num;
        }
        return ans;
    }


    @Test
    public void test() {
        String ipStr = "192.168.0.1";
        long ans = solve(ipStr);
        System.out.println("ans = " + ans);
    }
}
