package src;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JTextField;

public class EventHandler implements MouseListener, KeyListener {
    private Hashtable<String, JTextField> _uiObj = new Hashtable<String, JTextField>();

    public EventHandler() {
    }

    public void setButtonObj(Hashtable<String, JTextField> uiObj) {
        _uiObj = uiObj;
    }

    // ===== Mouse Event Method Start =====
    public void mouseClicked(MouseEvent evt) {
        // object which trigger event
        Object obj = evt.getSource();
        // check the object is JButton
        if (obj instanceof JButton) {
            JButton btn = (JButton) obj;
            String btnName = btn.getName();
            System.out.println(btnName + " btn被按了");
            actionEvent(btnName);
        }
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    public void mousePressed(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }
    // ===== Mouse Event Method End =====


    // ===== Keyboard Event Method Start =====
    public void keyPressed(KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        String btnName = null;
        Integer key = null;
        // Parse which key was pressed
        if (48 <= keyCode && keyCode <= 57) {
            key = Integer.valueOf(keyCode - 48);
            btnName = key.toString();
        } else if (96 <= keyCode && keyCode <= 105) {
            key = Integer.valueOf(keyCode - 96);
            btnName = key.toString();
        } else if (keyCode == 106)
            btnName = "*";
        else if (keyCode == 107)
            btnName = "+";
        else if (keyCode == 109)
            btnName = "-";
        else if (keyCode == 110)
            btnName = ".";
        else if (keyCode == 111)
            btnName = "/";
        else if (keyCode == 10)
            btnName = "=";
        else if (keyCode == 8)
            btnName = "<-";
        else if (keyCode == 65)
            btnName = "AC";
        else if (keyCode == 67)
            btnName = "CE";
        System.out.println(btnName + " key被按了");
        actionEvent(btnName);
    }

    public void keyTyped(KeyEvent evt) {
    }

    public void keyReleased(KeyEvent evt) {
    }
    // ===== Keyboard Event Method End =====

    // pass different object base on btnName
    public void actionEvent(String btnName) {
        if (btnName == null)
            return;
        if (btnName == "=" || btnName == "AC")
            ActionEvent.checkAction(btnName, _uiObj.get("Entry"), _uiObj.get("Result"));
        else
            ActionEvent.checkAction(btnName, _uiObj.get("Entry"));
    }
}
