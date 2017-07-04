package br.com.view;

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
    private JButton alunoButton;
    private JButton professorButton;
    private JButton livroButton;
    private JButton emprestimoButton;
    private JButton funcionárioButton;
    private JButton reservaButton;
    private JButton registrarButton;
    private JButton emprestimosButton;
    private JButton reservasButton;
    private JButton relatóriosButton;
    private JButton novoButton;
    private JButton ajudaButton;
    private JButton novoFuncionárioButton;

    public TelaFuncionario(){
        pack();
        setContentPane(rootPanel);
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        cadastrosButton.addActionListener(this);
        buscasButton.addActionListener(this);
        registrarButton.addActionListener(this);
        relatóriosButton.addActionListener(this);
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

    public JButton getAlunoButton() {
        return alunoButton;
    }

    public JButton getProfessorButton() {
        return professorButton;
    }

    public JButton getLivroButton() {
        return livroButton;
    }

    public JButton getEmprestimoButton() {
        return emprestimoButton;
    }

    public JButton getFuncionárioButton() {
        return funcionárioButton;
    }

    public JButton getReservaButton() {
        return reservaButton;
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
        hideBuscas();
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
        alunoButton.setVisible(true);
        professorButton.setVisible(true);
        funcionárioButton.setVisible(true);
        livroButton.setVisible(true);
        emprestimoButton.setVisible(true);
        reservaButton.setVisible(true);
    }
    public void hideBuscas(){
        alunoButton.setVisible(false);
        professorButton.setVisible(false);
        funcionárioButton.setVisible(false);
        livroButton.setVisible(false);
        emprestimoButton.setVisible(false);
        reservaButton.setVisible(false);
    }
    public void showRegistrar(){
        hideCadastros();
        hideBuscas();
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
        hideBuscas();
        hideRegistrar();
        novoButton.setVisible(true);
    }
    public void hideRelatorios(){
        novoButton.setVisible(false);
    }
}
