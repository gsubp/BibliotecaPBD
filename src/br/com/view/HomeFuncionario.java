package br.com.view;

import br.com.control.TelaFuncionarioControl;
import br.com.model.pojo.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HomeFuncionario extends JFrame{
    private final DefaultTableModel livroTableModel;
    private JButton novoAlunoButton;
    private JButton novoProfessorButton;
    private JButton novoFuncionárioButton;
    private JButton novoLivroButton;
    private JButton novoDepartamentoButton;
    private JButton novoCursoButton;
    private JButton emprestimosButton;
    private JButton reservasButton;
    private JTable registrosTable;
    private JRadioButton alunoRadioButton;
    private JRadioButton professorRadioButton;
    private JFormattedTextField cpfField;
    private JButton buscarButton;
    private JButton aprovarButton;
    private JButton receberButton;
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
    private JButton devolucaoButton;
    private JPanel cadastrosPanel;
    private final DefaultTableModel emprestimoTableModel;
    private final DefaultTableModel devolucaoTableModel;
    private final DefaultTableModel reservaTableModel;

    public HomeFuncionario(Funcionario funcionario) {
        setTitle("Biblioteca PBD");
        setContentPane(rootPanel);
        pack();
        setSize(650, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

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

        ButtonGroup regGroup = new ButtonGroup();
        regGroup.add(alunoRadioButton);
        regGroup.add(professorRadioButton);
        alunoRadioButton.setSelected(true);

        // definindo modelos das tables
        emprestimoTableModel = new DefaultTableModel();
        emprestimoTableModel.addColumn("ID");
        emprestimoTableModel.addColumn("Livro");
        emprestimoTableModel.addColumn("Data do Emprestimo");
        emprestimoTableModel.addColumn("Data de Entrega");
        emprestimoTableModel.addColumn("Situação");
        devolucaoTableModel = new DefaultTableModel();
        devolucaoTableModel.addColumn("ID");
        devolucaoTableModel.addColumn("Livro");
        devolucaoTableModel.addColumn("Data do Emprestimos");
        devolucaoTableModel.addColumn("Data de Entrega");
        reservaTableModel = new DefaultTableModel();
        reservaTableModel.addColumn("ID");
        reservaTableModel.addColumn("Livro");
        reservaTableModel.addColumn("Data de Realização");
        reservaTableModel.addColumn("Data de Validação");
        reservaTableModel.addColumn("Data Limite");
        livroTableModel = new DefaultTableModel();
        livroTableModel.addColumn("id");
        livroTableModel.addColumn("Título");
        livroTableModel.addColumn("Autores");
        livroTableModel.addColumn("Editora");
        livroTableModel.addColumn("Edição");
        livroTableModel.addColumn("Ano de publicação");
        livroTableModel.addColumn("Nº de Exemplares");
        livroTable.setModel(livroTableModel);

        // eventos dos buttons
        novoAlunoButton.addActionListener(control);
        novoProfessorButton.addActionListener(control);
        novoFuncionárioButton.addActionListener(control);
        novoDepartamentoButton.addActionListener(control);
        novoCursoButton.addActionListener(control);
        novoLivroButton.addActionListener(control);
        emprestimosButton.addActionListener(control);
        devolucaoButton.addActionListener(control);
        reservasButton.addActionListener(control);
        buscarLivroButtton.addActionListener(control);
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

    public JButton getEmprestimosButton() {
        return emprestimosButton;
    }

    public JButton getReservasButton() {
        return reservasButton;
    }

    public JTable getRegistrosTable() {
        return registrosTable;
    }

    public JRadioButton getAlunoRadioButton() {
        return alunoRadioButton;
    }

    public JRadioButton getProfessorRadioButton() {
        return professorRadioButton;
    }

    public JFormattedTextField getCpfField() {
        return cpfField;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public JButton getAprovarButton() {
        return aprovarButton;
    }

    public JButton getReceberButton() {
        return receberButton;
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

    public DefaultTableModel getEmprestimoTableModel() {
        return emprestimoTableModel;
    }

    public DefaultTableModel getDevolucaoTableModel() {
        return devolucaoTableModel;
    }

    public DefaultTableModel getReservaTableModel() {
        return reservaTableModel;
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

    public JButton getDevolucaoButton() {
        return devolucaoButton;
    }
}
