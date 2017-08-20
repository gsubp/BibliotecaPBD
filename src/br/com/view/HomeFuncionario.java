package br.com.view;

import br.com.control.TelaFuncionarioControl;
import br.com.model.pojo.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class HomeFuncionario extends JFrame{
    private JButton novoAlunoButton;
    private JButton novoProfessorButton;
    private JButton novoFuncionárioButton;
    private JButton novoLivroButton;
    private JButton novoDepartamentoButton;
    private JButton novoCursoButton;
    private JTable emprestimosTable;
    private JRadioButton alunoEmpRadioButton;
    private JRadioButton professorEmpRadioButton;
    private JFormattedTextField cpfEmprestimoField;
    private JButton buscarEmpButton;
    private JButton novoButton;
    private JButton relatóriosButton;
    private JLabel funcionarioLabel;
    private JButton sairButton;
    private JButton meusDadosButton;
    private JPanel rootPanel;
    private JRadioButton palavraChaveRadioButton;
    private JRadioButton anoRadioButton;
    private JRadioButton editoraRadioButton;
    private JTextField buscaField;
    private JRadioButton tituloRadioButton;
    private JRadioButton autorRadioButton;
    private JTable livroTable;
    private JButton buscarLivroButtton;
    private JRadioButton alunoResRadioButton;
    private JRadioButton professorResRadioButton;
    private JFormattedTextField cpfResField;
    private JButton buscaResButton;
    private JTable reservaTable;
    private JFormattedTextField cpfDevField;
    private JButton buscaDevButton;
    private JRadioButton alunoDevRadioButton;
    private JRadioButton professorDevRadioButton;
    private JTable devolucaoTable;
    private JButton blockUserButton;
    private JButton unblockUserButton;
    private JTable alunosTable;
    private JTable professoresTable;
    private JButton findUserButton;
    private JButton findAllUserButton;
    private JFormattedTextField formattedTextField1;
    private JRadioButton alunoRadioButton;
    private JRadioButton professorRadioButton;
    private JButton buscarButton;
    private JPanel buscaPanel;
    private JFormattedTextField buscaCpfField;
    private JButton lateButton;

    public HomeFuncionario(Funcionario funcionario) {
        setTitle("Biblioteca PBD");
        setContentPane(rootPanel);
        pack();
        setSize(650, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            DefaultFormatterFactory factory = new DefaultFormatterFactory(new MaskFormatter("###.###.###-##"));
            cpfEmprestimoField.setFormatterFactory(factory);
            cpfDevField.setFormatterFactory(factory);
            cpfResField.setFormatterFactory(factory);
            buscaCpfField.setFormatterFactory(factory);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // definindo controle
        TelaFuncionarioControl control = new TelaFuncionarioControl(this, funcionario);

        // button groups
        ButtonGroup acervoGroup = new ButtonGroup();
        acervoGroup.add(palavraChaveRadioButton);
        acervoGroup.add(autorRadioButton);
        acervoGroup.add(editoraRadioButton);
        acervoGroup.add(anoRadioButton);
        acervoGroup.add(tituloRadioButton);
        palavraChaveRadioButton.setSelected(true);

        ButtonGroup buscaGroup = new ButtonGroup();
        buscaGroup.add(alunoRadioButton);
        buscaGroup.add(professorRadioButton);
        alunoRadioButton.setSelected(true);

        ButtonGroup empGroup = new ButtonGroup();
        empGroup.add(alunoEmpRadioButton);
        empGroup.add(professorEmpRadioButton);
        alunoEmpRadioButton.setSelected(true);

        ButtonGroup devGroup = new ButtonGroup();
        devGroup.add(alunoDevRadioButton);
        devGroup.add(professorDevRadioButton);
        alunoDevRadioButton.setSelected(true);

        ButtonGroup resGroup = new ButtonGroup();
        resGroup.add(alunoResRadioButton);
        resGroup.add(professorResRadioButton);
        alunoResRadioButton.setSelected(true);

        // definindo modelos das tables
        DefaultTableModel emprestimoTableModel = new DefaultTableModel();
        emprestimoTableModel.addColumn("ID");
        emprestimoTableModel.addColumn("Livro");
        emprestimoTableModel.addColumn("Data do Emprestimo");
        emprestimoTableModel.addColumn("Data de Entrega");
        emprestimoTableModel.addColumn("Situação");
        emprestimosTable.setModel(emprestimoTableModel);

        DefaultTableModel devolucaoTableModel = new DefaultTableModel();
        devolucaoTableModel.addColumn("ID");
        devolucaoTableModel.addColumn("Livro");
        devolucaoTableModel.addColumn("Data do Emprestimos");
        devolucaoTableModel.addColumn("Data de Entrega");
        devolucaoTable.setModel(devolucaoTableModel);

        DefaultTableModel reservaTableModel = new DefaultTableModel();
        reservaTableModel.addColumn("ID");
        reservaTableModel.addColumn("Livro");
        reservaTableModel.addColumn("Data de Realização");
        reservaTableModel.addColumn("Data de Validação");
        reservaTableModel.addColumn("Data Limite");
        reservaTable.setModel(reservaTableModel);

        DefaultTableModel livroTableModel = new DefaultTableModel();
        livroTableModel.addColumn("id");
        livroTableModel.addColumn("Título");
        livroTableModel.addColumn("Autores");
        livroTableModel.addColumn("Editora");
        livroTableModel.addColumn("Edição");
        livroTableModel.addColumn("Ano de publicação");
        livroTableModel.addColumn("Nº de Exemplares");
        livroTable.setModel(livroTableModel);

        DefaultTableModel alunoTableModel = new DefaultTableModel();
        alunoTableModel.addColumn("id");
        alunoTableModel.addColumn("CPF");
        alunoTableModel.addColumn("Nome");
        alunoTableModel.addColumn("Situação");
        alunosTable.setModel(alunoTableModel);
        DefaultTableModel profTableModel = new DefaultTableModel();
        profTableModel.addColumn("id");
        profTableModel.addColumn("CPF");
        profTableModel.addColumn("Nome");
        profTableModel.addColumn("Situação");
        professoresTable.setModel(profTableModel);


        // eventos dos buttons
        novoAlunoButton.addActionListener(control);
        novoProfessorButton.addActionListener(control);
        novoFuncionárioButton.addActionListener(control);
        novoDepartamentoButton.addActionListener(control);
        novoCursoButton.addActionListener(control);
        novoLivroButton.addActionListener(control);
        buscarLivroButtton.addActionListener(control);
        buscarEmpButton.addActionListener(control);
        buscaDevButton.addActionListener(control);
        buscaResButton.addActionListener(control);
        sairButton.addActionListener(control);
        findAllUserButton.addActionListener(control);
        blockUserButton.addActionListener(control);
        unblockUserButton.addActionListener(control);
        findUserButton.addActionListener(control);
        buscarButton.addActionListener(control);
        lateButton.addActionListener(control);
    }

    public JButton getNovoAlunoButton() {
        return novoAlunoButton;
    }

    public JButton getNovoProfessorButton() {
        return novoProfessorButton;
    }

    public JButton getNovoFuncionárioButton() {
        return novoFuncionárioButton;
    }

    public JButton getNovoLivroButton() {
        return novoLivroButton;
    }

    public JButton getNovoDepartamentoButton() {
        return novoDepartamentoButton;
    }

    public JButton getNovoCursoButton() {
        return novoCursoButton;
    }

    public JTable getEmprestimosTable() {
        return emprestimosTable;
    }

    public JRadioButton getAlunoEmpRadioButton() {
        return alunoEmpRadioButton;
    }

    public JRadioButton getProfessorEmpRadioButton() {
        return professorEmpRadioButton;
    }

    public JFormattedTextField getCpfEmprestimoField() {
        return cpfEmprestimoField;
    }

    public JButton getBuscarEmpButton() {
        return buscarEmpButton;
    }

    public JButton getNovoButton() {
        return novoButton;
    }

    public JButton getRelatóriosButton() {
        return relatóriosButton;
    }

    public JLabel getFuncionarioLabel() {
        return funcionarioLabel;
    }

    public JButton getSairButton() {
        return sairButton;
    }

    public JButton getMeusDadosButton() {
        return meusDadosButton;
    }

    public JRadioButton getPalavraChaveRadioButton() {
        return palavraChaveRadioButton;
    }

    public JRadioButton getAnoRadioButton() {
        return anoRadioButton;
    }

    public JRadioButton getEditoraRadioButton() {
        return editoraRadioButton;
    }

    public JTextField getBuscaField() {
        return buscaField;
    }

    public JRadioButton getTituloRadioButton() {
        return tituloRadioButton;
    }

    public JRadioButton getAutorRadioButton() {
        return autorRadioButton;
    }

    public JTable getLivroTable() {
        return livroTable;
    }

    public JButton getBuscarLivroButtton() {
        return buscarLivroButtton;
    }

    public JRadioButton getAlunoResRadioButton() {
        return alunoResRadioButton;
    }

    public JRadioButton getProfessorResRadioButton() {
        return professorResRadioButton;
    }

    public JFormattedTextField getCpfResField() {
        return cpfResField;
    }

    public JButton getBuscaResButton() {
        return buscaResButton;
    }

    public JTable getReservaTable() {
        return reservaTable;
    }

    public JFormattedTextField getCpfDevField() {
        return cpfDevField;
    }

    public JButton getBuscaDevButton() {
        return buscaDevButton;
    }

    public JRadioButton getAlunoDevRadioButton() {
        return alunoDevRadioButton;
    }

    public JRadioButton getProfessorDevRadioButton() {
        return professorDevRadioButton;
    }

    public JTable getDevolucaoTable() {
        return devolucaoTable;
    }

    public JButton getBlockUserButton() {
        return blockUserButton;
    }

    public JButton getUnblockUserButton() {
        return unblockUserButton;
    }

    public JTable getAlunosTable() {
        return alunosTable;
    }

    public JTable getProfessoresTable() {
        return professoresTable;
    }

    public JButton getFindUserButton() {
        return findUserButton;
    }

    public JButton getFindAllUserButton() {
        return findAllUserButton;
    }

    public JFormattedTextField getFormattedTextField1() {
        return formattedTextField1;
    }

    public JRadioButton getAlunoRadioButton() {
        return alunoRadioButton;
    }

    public JRadioButton getProfessorRadioButton() {
        return professorRadioButton;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public JPanel getBuscaPanel() {
        return buscaPanel;
    }

    public JFormattedTextField getBuscaCpfField() {
        return buscaCpfField;
    }

    public JButton getLateButton() {
        return lateButton;
    }
}