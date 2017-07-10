package br.com.view;

import br.com.control.TelaFuncionarioControl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by guilh on 04/07/2017.
 */
public class TelaFuncionario extends JFrame implements ActionListener{
    private JPanel rootPanel;
    private JButton cadastrosButton;
    private JButton novoAlunoButton;
    private JButton novoProfessorButton;
    private JButton novoLivroButton;
    private JButton buscasButton;
    private JButton registrarButton;
    private JButton emprestimosButton;
    private JButton reservasButton;
    private JButton relatóriosButton;
    private JButton novoButton;
    private JButton ajudaButton;
    private JButton novoFuncionárioButton;
    private JButton sairButton;
    private JLabel funcionarioLabel;

    public TelaFuncionario(String nomeFuncionario){
        pack();
        setContentPane(rootPanel);
        funcionarioLabel.setText(nomeFuncionario);
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        cadastrosButton.addActionListener(this);
        buscasButton.addActionListener(this);
        registrarButton.addActionListener(this);
        relatóriosButton.addActionListener(this);

        novoAlunoButton.addActionListener(new TelaFuncionarioControl(this));
        novoProfessorButton.addActionListener(new TelaFuncionarioControl(this));
        buscasButton.addActionListener(new TelaFuncionarioControl(this));
    }

    public JButton getCadastrosButton() {
        return cadastrosButton;
    }

    public JButton getNovoAlunoButton() {
        return novoAlunoButton;
    }

    public JButton getNovoProfessorButton() {
        return novoProfessorButton;
    }

    public JButton getNovoLivroButton() {
        return novoLivroButton;
    }

    public JButton getBuscasButton() {
        return buscasButton;
    }

    public JButton getRegistrarButton() {
        return registrarButton;
    }

    public JButton getEmprestimosButton() {
        return emprestimosButton;
    }

    public JButton getReservasButton() {
        return reservasButton;
    }

    public JButton getRelatóriosButton() {
        return relatóriosButton;
    }

    public JButton getNovoButton() {
        return novoButton;
    }

    public JButton getAjudaButton() {
        return ajudaButton;
    }

    public JButton getNovoFuncionárioButton() {
        return novoFuncionárioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrosButton)
            showCadastros();
        if(e.getSource() == buscasButton)
            showBuscas();
        if(e.getSource() == registrarButton)
            showRegistrar();
        if(e.getSource() == relatóriosButton)
            showRelatorios();

    }

    public void showCadastros(){
        hideRelatorios();
        hideRegistrar();
        novoAlunoButton.setVisible(true);
        novoProfessorButton.setVisible(true);
        novoFuncionárioButton.setVisible(true);
        novoLivroButton.setVisible(true);
    }
    public void hideCadastros(){
        novoAlunoButton.setVisible(false);
        novoProfessorButton.setVisible(false);
        novoFuncionárioButton.setVisible(false);
        novoLivroButton.setVisible(false);
    }
    public void showBuscas(){
        hideCadastros();
        hideRegistrar();
        hideRelatorios();
    }

    public void showRegistrar(){
        hideCadastros();
        hideRelatorios();
        emprestimosButton.setVisible(true);
        reservasButton.setVisible(true);
    }
    public void hideRegistrar(){
        emprestimosButton.setVisible(false);
        reservasButton.setVisible(false);
    }
    public void showRelatorios(){
        hideCadastros();
        hideRegistrar();
        novoButton.setVisible(true);
    }
    public void hideRelatorios(){
        novoButton.setVisible(false);
    }
}
