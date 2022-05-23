import java.util.Stack;

public class SpringArray {

    public static Spring equivalentSpring(String springExpr) {
        String a = "[[]]";
        //stack
        Stack<Character> stacks = new Stack<>();
        //loop
        Spring r = new Spring();
        Spring r1;
        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(c == '[' || c == '{' ) {
                stacks.push(c);
            } else if(c == '[') {
                if(stacks.pop() == ']') {
                    Spring.inSeries(r);
                }
            } else if(c == '{') {
                if(stacks.pop() == '}') {
                    Spring.inParallel(r1);
                }
            }
            return Spring;
        }




       /* for (int i = 0; i < a.length(); i++) {
            char x = a.charAt(i);
            if (x == '[' || x == '{') {
                // Push the element in the stack
                stacks.push(x);
                continue;
                char check;
                switch (x) {
                    case '{':
                        check = stacks.pop();
                        if (check == '}') {
                            Spring.inParallel(r);
                            stacks.pop()
                        }
                        break;
                    case '[':
                        check = stacks.pop();
                        if (check == ']') {
                            Spring.inParallel(r1);
                        }
                        break;
                }

        */

            }
        }
        

/*

 */

