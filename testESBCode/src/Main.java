import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.print("Unicode Строка: ");
        //String uniStr = scanner.nextLine();
        String uniStr = "{\"errors\": [\"\\u041d\\u0435\\u043a\\u043e\\u0440\\u0440\\u0435\\u043a\\u0442\\u043d\\u043e \\u0443\\u043a\\u0430\\u0437\\u0430\\u043d\\u044b \\u0441\\u0442\\u0440\\u0430\\u0445\\u043e\\u0432\\u0430\\u044f \\u043f\\u0440\\u0435\\u043c\\u0438\\u044f \\u0438/\\u0438\\u043b\\u0438 \\u0441\\u0442\\u0440\\u0430\\u0445\\u043e\\u0432\\u0430\\u044f \\u0441\\u0443\\u043c\\u043c\\u0430 \\u0438/\\u0438\\u043b\\u0438 \\u043e\\u0431\\u0449\\u0430\\u044f \\u0441\\u0442\\u0440\\u0430\\u0445\\u043e\\u0432\\u0430\\u044f \\u043f\\u0440\\u0435\\u043c\\u0438\\u044f \\u0438/\\u0438\\u043b\\u0438 \\u0434\\u0430\\u0442\\u044b \\u0434\\u0435\\u0439\\u0441\\u0442\\u0432\\u0438\\u044f \\u0441\\u0442\\u0440\\u0430\\u0445\\u043e\\u0432\\u043e\\u0433\\u043e \\u0440\\u0438\\u0441\\u043a\\u0430\"], \"error_code\": \"10001\"}";

        int i=0, len=uniStr.length();
        char c;
        StringBuffer sb = new StringBuffer(len);
        while (i < len) {
            c = uniStr.charAt(i++);
            if (c == '\\') {
                if (i < len) {
                    c = uniStr.charAt(i++);
                    if (c == 'u') {
                        c = (char) Integer.parseInt(uniStr.substring(i, i+4), 16);
                        i += 4;
                    }
                }
            }
            sb.append(c);
        }

        String utf8Str = sb.toString();

        System.out.println("UTF-8 строка:" + utf8Str);
    }
}
