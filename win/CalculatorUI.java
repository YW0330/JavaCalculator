package win;

import src.EventHandler;
import java.util.Hashtable;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CalculatorUI extends JFrame {
    private int width = 500;
    private int length = 500;    
    private EventHandler eh = new EventHandler();
    private Hashtable<String, JTextField> uiObj = new Hashtable<String, JTextField>();
    public CalculatorUI(String frameName) {
        super(frameName);
        init();
    }

    public void init() {
        // Calculator Structure:
		//
		// JFrame
		// |_JPanel
		// | |_JTextField
        // | |_JTextField
		// |_JPanel
        // | |_JButton Matrix

        // set JFrame size
        this.setSize(width, length);
        // distinguish JFrame to two part
        this.setLayout(new GridLayout(2, 1));

        // ===== First Part Start =====
        JPanel txtPanel = new JPanel();
        GridLayout layout = new GridLayout(2, 1);
        layout.setVgap(3);
        txtPanel.setLayout(layout);
        JTextField tfEntry = new JTextField();
        tfEntry.setBackground(Color.black);
        tfEntry.setForeground(Color.white);
        tfEntry.setFont(new Font("SansSerif", Font.PLAIN, 20));
        tfEntry.setHorizontalAlignment(JTextField.RIGHT);
        tfEntry.setEditable(false);
        // add keyboard event listener to first JTextField
        tfEntry.addKeyListener(eh);
        JTextField tfResult = new JTextField();
        tfResult.setBackground(Color.black);
        tfResult.setForeground(Color.white);
        tfResult.setHorizontalAlignment(JTextField.RIGHT);
        tfResult.setFont(new Font("SansSerif", Font.BOLD, 30));
        tfResult.setEditable(false);
        // add JTextField to Hashtable
        uiObj.put("Entry", tfEntry);
        uiObj.put("Result", tfResult);
        txtPanel.add(tfEntry);
        txtPanel.add(tfResult);
        // ===== First Part End =====

        // ===== Second Part Start =====
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.BLACK);
        btnPanel.setSize(500,300);
        layout = new GridLayout(0, 4);
        layout.setHgap(10);
        layout.setVgap(10);
        btnPanel.setLayout(layout);
        String[] buttonName = { "AC", "CE", "<-", "/", 
                                "1", "2", "3", "*", 
                                "4", "5", "6", "-",
                                "7", "8", "9", "+",
                                "", "0", ".", "="};
        for(int i=0;i<buttonName.length;i++){
            JButton btn = new JButton(buttonName[i]);
            btn.setFont(new Font("Serif", Font.BOLD, 15));
            if(!buttonName[i].equals("")){
                btn.setName(buttonName[i]);
                // add Mouse event listener to each JButton
                btn.addMouseListener(eh);
            }else{
                btn.setEnabled(false);
                btn.setBackground(Color.black);
                btn.setBorderPainted(false);
            }
            btnPanel.add(btn);
        }
        // ===== Second Part End =====

        // pass object to EventHandler
        eh.setButtonObj(uiObj);
        this.add(txtPanel);
        this.add(btnPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
