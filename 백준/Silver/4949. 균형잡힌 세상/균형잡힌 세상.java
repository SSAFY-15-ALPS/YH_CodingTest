import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();

            if (line.equals(".")) 
                break;
            
            Stack<Character> st = new Stack<>();
            boolean result = true;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(' || c == '[') {
                    st.push(c);
                }else if (c == ')') {
                    if (st.isEmpty() || st.peek() != '(') {
                        result = false;
                        break;
                    }
                    st.pop();
                }else if (c == ']') {
                    if (st.isEmpty() || st.peek() != '[') {
                        result = false;
                        break;
                    }
                    st.pop();
                }
            }

            if (!st.isEmpty()) 
                result = false;

            System.out.println(result ? "yes" : "no");
        }
    }
}