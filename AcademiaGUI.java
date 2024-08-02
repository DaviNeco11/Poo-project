import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AcademiaGUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel initialPanel;
    private JPanel menuPanel;
    private JPanel manageAlunosPanel;
    private JPanel manageInstrutoresPanel;
    private JPanel manageAulasPanel;
    private JPanel addAlunoPanel;
    private JPanel listAlunosPanel;
    private JPanel addInstrutorPanel;
    private JPanel listInstrutoresPanel;
    private JPanel addAulaPanel;
    private JPanel listAulasPanel;

    private ArrayList<Aluno> alunos;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<Aula> aulas;

    public AcademiaGUI() {
        alunos = new ArrayList<>();
        instrutores = new ArrayList<>();
        aulas = new ArrayList<>();

        setTitle("Sistema de Academia");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        createInitialPanel();
        createMenuPanel();
        createManageAlunosPanel();
        createManageInstrutoresPanel();
        createManageAulasPanel();
        createAddAlunoPanel();
        createListAlunosPanel();
        createAddInstrutorPanel();
        createListInstrutoresPanel();
        createAddAulaPanel();
        createListAulasPanel();

        mainPanel.add(initialPanel, "Inicial");
        mainPanel.add(menuPanel, "Menu");
        mainPanel.add(manageAlunosPanel, "Gerenciar Alunos");
        mainPanel.add(manageInstrutoresPanel, "Gerenciar Instrutores");
        mainPanel.add(manageAulasPanel, "Gerenciar Aulas");
        mainPanel.add(addAlunoPanel, "Adicionar Aluno");
        mainPanel.add(listAlunosPanel, "Listar Alunos");
        mainPanel.add(addInstrutorPanel, "Adicionar Instrutor");
        mainPanel.add(listInstrutoresPanel, "Listar Instrutores");
        mainPanel.add(addAulaPanel, "Adicionar Aula");
        mainPanel.add(listAulasPanel, "Listar Aulas");

        add(mainPanel);
        cardLayout.show(mainPanel, "Inicial");

        setVisible(true);
    }

    private void createInitialPanel() {
        initialPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Academia", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        initialPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        JButton menuButton = new JButton("Menu Principal");
        menuButton.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        JButton exitButton = new JButton("Sair");
        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(menuButton);
        buttonPanel.add(exitButton);

        initialPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void createMenuPanel() {
        menuPanel = new JPanel(new GridLayout(4, 1));

        JButton manageAlunosButton = new JButton("Gerenciar Alunos");
        manageAlunosButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Alunos"));
        menuPanel.add(manageAlunosButton);

        JButton manageInstrutoresButton = new JButton("Gerenciar Instrutores");
        manageInstrutoresButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Instrutores"));
        menuPanel.add(manageInstrutoresButton);

        JButton manageAulasButton = new JButton("Gerenciar Aulas");
        manageAulasButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Aulas"));
        menuPanel.add(manageAulasButton);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Inicial"));
        menuPanel.add(backButton);
    }

    private void createManageAlunosPanel() {
        manageAlunosPanel = new JPanel(new GridLayout(3, 1));

        JButton addAlunoButton = new JButton("Criar Aluno");
        addAlunoButton.addActionListener(e -> cardLayout.show(mainPanel, "Adicionar Aluno"));
        manageAlunosPanel.add(addAlunoButton);

        JButton listAlunosButton = new JButton("Mostrar Lista de Alunos");
        listAlunosButton.addActionListener(e -> cardLayout.show(mainPanel, "Listar Alunos"));
        manageAlunosPanel.add(listAlunosButton);

        JButton backButton = new JButton("Voltar ao Menu Principal");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        manageAlunosPanel.add(backButton);
    }

    private void createManageInstrutoresPanel() {
        manageInstrutoresPanel = new JPanel(new GridLayout(3, 1));

        JButton addInstrutorButton = new JButton("Criar Instrutor");
        addInstrutorButton.addActionListener(e -> cardLayout.show(mainPanel, "Adicionar Instrutor"));
        manageInstrutoresPanel.add(addInstrutorButton);

        JButton listInstrutoresButton = new JButton("Mostrar Lista de Instrutores");
        listInstrutoresButton.addActionListener(e -> cardLayout.show(mainPanel, "Listar Instrutores"));
        manageInstrutoresPanel.add(listInstrutoresButton);

        JButton backButton = new JButton("Voltar ao Menu Principal");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        manageInstrutoresPanel.add(backButton);
    }

    private void createManageAulasPanel() {
        manageAulasPanel = new JPanel(new GridLayout(3, 1));

        JButton addAulaButton = new JButton("Criar Aula");
        addAulaButton.addActionListener(e -> cardLayout.show(mainPanel, "Adicionar Aula"));
        manageAulasPanel.add(addAulaButton);

        JButton listAulasButton = new JButton("Mostrar Lista de Aulas");
        listAulasButton.addActionListener(e -> cardLayout.show(mainPanel, "Listar Aulas"));
        manageAulasPanel.add(listAulasButton);

        JButton backButton = new JButton("Voltar ao Menu Principal");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Menu"));
        manageAulasPanel.add(backButton);
    }

    private void createAddAlunoPanel() {
        addAlunoPanel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        JTextField nomeField = new JTextField();
        JTextField idadeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField planoTreinoField = new JTextField();
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Idade:"));
        formPanel.add(idadeField);

        formPanel.add(new JLabel("CPF:"));
        formPanel.add(cpfField);

        formPanel.add(new JLabel("Telefone:"));
        formPanel.add(telefoneField);

        formPanel.add(new JLabel("Plano de Treino:"));
        formPanel.add(planoTreinoField);

        JButton addButton = new JButton("Adicionar Aluno");
        addButton.addActionListener(e -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String cpf = cpfField.getText();
            String telefone = telefoneField.getText();
            PlanoDeTreino planoDeTreino = new PlanoDeTreino(planoTreinoField.getText());

            Aluno aluno = new Aluno(nome, idade, cpf, telefone, Aluno.contador, planoDeTreino);
            alunos.add(aluno);
            outputArea.append(aluno.toString() + "\n");
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Alunos"));

        formPanel.add(addButton);
        formPanel.add(backButton);

        addAlunoPanel.add(formPanel, BorderLayout.CENTER);
        addAlunoPanel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTextField source = (JTextField) e.getSource();
                    if (source.equals(nomeField)) {
                        idadeField.requestFocus();
                    } else if (source.equals(idadeField)) {
                        cpfField.requestFocus();
                    } else if (source.equals(cpfField)) {
                        telefoneField.requestFocus();
                    } else if (source.equals(telefoneField)) {
                        planoTreinoField.requestFocus();
                    } else if (source.equals(planoTreinoField)) {
                        addButton.doClick();
                        nomeField.requestFocus();
                    }
                }
            }
        };

        nomeField.addKeyListener(keyAdapter);
        idadeField.addKeyListener(keyAdapter);
        cpfField.addKeyListener(keyAdapter);
        telefoneField.addKeyListener(keyAdapter);
        planoTreinoField.addKeyListener(keyAdapter);
    }

    private void createListAlunosPanel() {
        listAlunosPanel = new JPanel(new BorderLayout());
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        JButton refreshButton = new JButton("Atualizar Lista");
        refreshButton.addActionListener(e -> {
            outputArea.setText("");
            for (Aluno aluno : alunos) {
                outputArea.append(aluno.toString() + "\n");
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Alunos"));

        listAlunosPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        listAlunosPanel.add(refreshButton, BorderLayout.NORTH);
        listAlunosPanel.add(backButton, BorderLayout.SOUTH);
    }

    private void createAddInstrutorPanel() {
        addInstrutorPanel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(6, 2));
        JTextField nomeField = new JTextField();
        JTextField idadeField = new JTextField();
        JTextField cpfField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField especialidadeField = new JTextField();
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        formPanel.add(new JLabel("Nome:"));
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Idade:"));
        formPanel.add(idadeField);

        formPanel.add(new JLabel("CPF:"));
        formPanel.add(cpfField);

        formPanel.add(new JLabel("Telefone:"));
        formPanel.add(telefoneField);

        formPanel.add(new JLabel("Especialidade:"));
        formPanel.add(especialidadeField);

        JButton addButton = new JButton("Adicionar Instrutor");
        addButton.addActionListener(e -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            String cpf = cpfField.getText();
            String telefone = telefoneField.getText();
            String especialidade = especialidadeField.getText();

            Instrutor instrutor = new Instrutor(nome, idade, cpf, telefone, especialidade);
            instrutores.add(instrutor);
            outputArea.append(instrutor.toString() + "\n");
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Instrutores"));

        formPanel.add(addButton);
        formPanel.add(backButton);

        addInstrutorPanel.add(formPanel, BorderLayout.CENTER);
        addInstrutorPanel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTextField source = (JTextField) e.getSource();
                    if (source.equals(nomeField)) {
                        idadeField.requestFocus();
                    } else if (source.equals(idadeField)) {
                        cpfField.requestFocus();
                    } else if (source.equals(cpfField)) {
                        telefoneField.requestFocus();
                    } else if (source.equals(telefoneField)) {
                        especialidadeField.requestFocus();
                    } else if (source.equals(especialidadeField)) {
                        addButton.doClick();
                        nomeField.requestFocus();
                    }
                }
            }
        };

        nomeField.addKeyListener(keyAdapter);
        idadeField.addKeyListener(keyAdapter);
        cpfField.addKeyListener(keyAdapter);
        telefoneField.addKeyListener(keyAdapter);
        especialidadeField.addKeyListener(keyAdapter);
    }

    private void createListInstrutoresPanel() {
        listInstrutoresPanel = new JPanel(new BorderLayout());
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        JButton refreshButton = new JButton("Atualizar Lista");
        refreshButton.addActionListener(e -> {
            outputArea.setText("");
            for (Instrutor instrutor : instrutores) {
                outputArea.append(instrutor.toString() + "\n");
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Instrutores"));

        listInstrutoresPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        listInstrutoresPanel.add(refreshButton, BorderLayout.NORTH);
        listInstrutoresPanel.add(backButton, BorderLayout.SOUTH);
    }

    private void createAddAulaPanel() {
        addAulaPanel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        JTextField tipoField = new JTextField();
        JTextField horarioField = new JTextField();
        JTextField instrutorField = new JTextField();
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        formPanel.add(new JLabel("Tipo:"));
        formPanel.add(tipoField);

        formPanel.add(new JLabel("Horário:"));
        formPanel.add(horarioField);

        formPanel.add(new JLabel("Instrutor:"));
        formPanel.add(instrutorField);

        JButton addButton = new JButton("Adicionar Aula");
        addButton.addActionListener(e -> {
            String tipo = tipoField.getText();
            String horario = horarioField.getText();
            Instrutor instrutor = null;
            for (Instrutor i : instrutores) {
                if (i.getNome().equals(instrutorField.getText())) {
                    instrutor = i;
                    break;
                }
            }
            if (instrutor != null) {
                Aula aula = new Aula(tipo, horario, instrutor);
                aulas.add(aula);
                outputArea.append(aula.toString() + "\n");
            } else {
                outputArea.append("Instrutor não encontrado.\n");
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Aulas"));

        formPanel.add(addButton);
        formPanel.add(backButton);

        addAulaPanel.add(formPanel, BorderLayout.CENTER);
        addAulaPanel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    JTextField source = (JTextField) e.getSource();
                    if (source.equals(tipoField)) {
                        horarioField.requestFocus();
                    } else if (source.equals(horarioField)) {
                        instrutorField.requestFocus();
                    } else if (source.equals(instrutorField)) {
                        addButton.doClick();
                        tipoField.requestFocus();
                    }
                }
            }
        };

        tipoField.addKeyListener(keyAdapter);
        horarioField.addKeyListener(keyAdapter);
        instrutorField.addKeyListener(keyAdapter);
    }

    private void createListAulasPanel() {
        listAulasPanel = new JPanel(new BorderLayout());
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        JButton refreshButton = new JButton("Atualizar Lista");
        refreshButton.addActionListener(e -> {
            outputArea.setText("");
            for (Aula aula : aulas) {
                outputArea.append(aula.toString() + "\n");
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Gerenciar Aulas"));

        listAulasPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        listAulasPanel.add(refreshButton, BorderLayout.NORTH);
        listAulasPanel.add(backButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new AcademiaGUI();
    }
}
