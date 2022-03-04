package src;

import java.util.EmptyStackException;
import javax.swing.JTextField;

public class ActionEvent {

    // only to change one JTextField, i.e. "Entry"
    public static void checkAction(String btnName, Object obj) {
        // check the object is JTextField
        if (obj != null && obj instanceof JTextField) {
            JTextField tfEntry = (JTextField) obj;
            if (btnName == "<-") {
                // backspace
                tfEntry.setText(backspace(tfEntry.getText()));
            } else if (btnName == "CE")
                // clear entry
                tfEntry.setText(clearEntry(tfEntry.getText()));
            else {
                // other case, i.e. 1-9, ., +, -, *, /
                tfEntry.setText(tfEntry.getText() + btnName);
            }
        }
    }

    // must to change all JTextField, i.e. "Entry" and "Result"
    public static void checkAction(String btnName, Object obj1, Object obj2) {
        // check the object is JTextField
        if (obj1 != null && obj1 instanceof JTextField && obj2 != null && obj2 instanceof JTextField) {
            JTextField tfEntry = (JTextField) obj1;
            JTextField tfResult = (JTextField) obj2;
            if (btnName == "AC") {
                // clear all
                tfEntry.setText(null);
                tfResult.setText(null);
            } else {
                // =
                try {
                    // evaluate expression
                    double ans = InfixEvaluation.evaluate(tfEntry.getText());
                    tfResult.setText(String.format("%.1f", ans));
                } catch (UnsupportedOperationException e) {
                    // divide by zero
                    tfResult.setText("Error");
                } catch (EmptyStackException e) {
                    // other exception, ex:9++
                    tfResult.setText("Error");
                }
            }
        }
    }

    // backspace method
    public static String backspace(String str) {
        // remove the last character
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    // clear entry method
    public static String clearEntry(String str) {
        // find the last operator, and remove the number after that
        if (str != null && str.length() > 0) {
            for (int i = str.length() - 1; i >= 0; i--) {
                char c = str.charAt(i);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    str = str.substring(0, i + 1);
                    break;
                }
            }
        }
        return str;
    }
}
