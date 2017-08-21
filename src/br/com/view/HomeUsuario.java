package br.com.view;

import br.com.control.TelaUsuarioControl;
import br.com.model.pojo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HomeUsuario extends JFrame{
    private final JMenuItem empItem;
    private final JMenuItem resItem;
    private final JMenuItem devItem;
    private final JMenuItem presItem;
    private final JMenuItem canItem;
    private JPanel rootPanel;
    private JLabel usuarioLabel;
    private JRadioButton palavraChaveRadioButton;
    private JRadioButton anoRadioButton;
    private JButton buscarLivroButtton;
    private JRadioButton editoraRadioButton;
    private JTextField buscaField;
    private JRadioButton tituloRadioButton;
    private JRadioButton autorRadioButton;
    private JTable livroTable;
    private JTable emprestimosTable;
    private JTable reservaTable;
    private JButton updateResButton;
    private JButton updateEmpButton;
    private JLabel situacaoLabel;

    public HomeUsuario(Usuario usuario){
        setTitle("Biblioteca PBD");
        setContentPane(rootPanel);
        pack();
        setSize(650, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //definindo controle
        TelaUsuarioControl control = new TelaUsuarioControl(this, usuario);

        // button groups
        ButtonGroup acervoGroup = new ButtonGroup();
        acervoGroup.add(palavraChaveRadioButton);
        acervoGroup.add(autorRadioButton);
        acervoGroup.add(editoraRadioButton);
        acervoGroup.add(anoRadioButton);
        acervoGroup.add(tituloRadioButton);
        palavraChaveRadioButton.setSelected(true);

        // definindo modelos das tables
        DefaultTableModel emprestimoTableModel = new DefaultTableModel();
        emprestimoTableModel.addColumn("ID");
        emprestimoTableModel.addColumn("Livro");
        emprestimoTableModel.addColumn("Data do Emprestimo");
        emprestimoTableModel.addColumn("Data de Entrega");
        emprestimoTableModel.addColumn("Situação");
        emprestimosTable.setModel(emprestimoTableModel);

        DefaultTableModel reservaTableModel = new DefaultTableModel();
        reservaTableModel.addColumn("ID");
        reservaTableModel.addColumn("Livro");
        reservaTableModel.addColumn("Data de Realização");
        reservaTableModel.addColumn("Data de Validação");
        reservaTableModel.addColumn("Data Limite");
        reservaTableModel.addColumn("Situação");
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

        //pop menus
        JPopupMenu livroMenu = new JPopupMenu();
        empItem = new JMenuItem("Pegar emprestado");
        resItem = new JMenuItem("Reservar");
        livroMenu.add(empItem);
        livroMenu.add(resItem);
        livroTable.setComponentPopupMenu(livroMenu);

        JPopupMenu empMenu = new JPopupMenu();
        devItem = new JMenuItem("Devolver");
        empMenu.add(devItem);
        emprestimosTable.setComponentPopupMenu(empMenu);

        JPopupMenu resMenu = new JPopupMenu();
        presItem = new JMenuItem("Pegar emprestado");
        resMenu.add(presItem);
        canItem = new JMenuItem("Cancelar Reserva");
        resMenu.add(canItem);

        reservaTable.setComponentPopupMenu(resMenu);

        //listeners
        buscarLivroButtton.addActionListener(control);
        empItem.addActionListener(control);
        resItem.addActionListener(control);
        updateEmpButton.addActionListener(control);
        updateResButton.addActionListener(control);
        devItem.addActionListener(control);
        presItem.addActionListener(control);
        canItem.addActionListener(control);

    }

    public JLabel getUsuarioLabel() {
        return usuarioLabel;
    }

    public JRadioButton getPalavraChaveRadioButton() {
        return palavraChaveRadioButton;
    }

    public JRadioButton getAnoRadioButton() {
        return anoRadioButton;
    }

    public JButton getBuscarLivroButtton() {
        return buscarLivroButtton;
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

    public JTable getEmprestimosTable() {
        return emprestimosTable;
    }

    public JTable getReservaTable() {
        return reservaTable;
    }

    public JMenuItem getEmpItem() {
        return empItem;
    }

    public JMenuItem getResItem() {
        return resItem;
    }

    public JButton getUpdateResButton() {
        return updateResButton;
    }

    public JButton getUpdateEmpButton() {
        return updateEmpButton;
    }

    public JMenuItem getDevItem() {
        return devItem;
    }

    public JMenuItem getPresItem() {
        return presItem;
    }

    public JMenuItem getCanItem() {
        return canItem;
    }

    public JLabel getSituacaoLabel() {
        return situacaoLabel;
    }
}
