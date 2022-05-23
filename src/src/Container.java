import javax.swing.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Container{

    public static int price = 0;
    public static List<Integer> prices = new ArrayList<Integer>();
    public static int total_price = 0;
    public static List<String> foodies = new ArrayList<String>();


    public static String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

}
