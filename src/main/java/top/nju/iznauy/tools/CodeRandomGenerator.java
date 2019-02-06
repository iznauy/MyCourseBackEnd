package top.nju.iznauy.tools;

import java.util.Random;

/**
 * Created on 06/02/2019.
 * Description:
 *
 * @author iznauy
 */
public class CodeRandomGenerator {

    private CodeRandomGenerator() {
    }

    public static String randomGenerateCode() {
        StringBuilder resultBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            resultBuilder.append(random.nextInt(10));
        }
        return resultBuilder.toString();
    }

}
