package br.com.view;

import javax.swing.*;

/**
 * Created by guilh on 04/07/2017.
 */
public class Buscas extends JFrame{
    private JPanel rootPanel;
    private JTabbedPane tabbedPane1;
    private JTextField cpfField;
    private JButton buscarAlunoButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JTextField textField3;
    private JButton buscarButton1;
    private JTextField textField4;
    private JTextArea textArea2;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton buscarButton;
    private JTextField textField8;
    private JTextField textField9;
    private JList list1;
    private JList list2;
    private JRadioButton tituloRadioButton;
    private JRadioButton radioButton2;
    private JRadioButton alunoRadioButton;
    private JRadioButton professorRadioButton;
    private JTextField textField10;
    private JButton buscarButton2;
    private JList list3;
    private JRadioButton alunoRadioButton1;
    private JRadioButton professorRadioButton1;
    private JTextField textField11;
    private JButton buscarButton3;
    private JList list4;

    public Buscas(){
        pack();
        setSize(600,400);
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
