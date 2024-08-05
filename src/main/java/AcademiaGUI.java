import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Representa a interface gráfica do sistema de academia.
 * O Menu de chegada possui o botões de navegação para o Menu Principal e para sair do programa.
 * O Menu Principal possui as opções de gerenciar alunos, instrutores e aulas, além do botão de voltar à tela anterior.
 * Cada gerenciador permite criar um novo objeto, listar o existentes e retornar ao Menu Principal.
 */
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

    private PersisteAluno persisteAluno;
    private PersisteInstrutor persisteInstrutor;
    private PersisteAula persisteAula;

    /**
     * Cria e configura os painéis para a interface gráfica da academia, incluindo os painéis para
     * gerenciamento de alunos, instrutores e aulas, bem como para adicionar novos registros e
     * listar existentes.
     */
    public AcademiaGUI() {
        alunos = new ArrayList<>();
        instrutores = new ArrayList<>();
        aulas = new ArrayList<>();

        persisteAluno = new PersisteAluno("aluno.txt");
        persisteInstrutor = new PersisteInstrutor("instrutor.txt");
        persisteAula = new PersisteAula("aula.txt");

        alunos = persisteAluno.carregaDados(null);
        instrutores = persisteInstrutor.carregaDados(null);
        aulas = persisteAula.carregaDados(instrutores);

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

    /**
     * Cria o painel inicial da aplicação com um título e dois botões: "Menu Principal" e "Sair".
     */
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

    /**
     * Cria o painel do menu principal com botões para gerenciar alunos, instrutores e aulas,
     * além de um botão para voltar ao painel inicial.
     */
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

    /**
     * Cria o painel para gerenciar alunos com opções para adicionar um novo aluno,
     * mostrar a lista de alunos e voltar ao menu principal.
     */
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

    /**
     * Cria o painel para gerenciar instrutores com opções para adicionar um novo instrutor,
     * mostrar a lista de instrutores e voltar ao menu principal.
     */
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

    /**
     * Cria o painel para gerenciar aulas com opções para adicionar uma nova aula,
     * mostrar a lista de aulas e voltar ao menu principal.
     */
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

    /**
     * Cria e configura o painel para adicionar um novo aluno.
     *
     * Este método inicializa o painel `addAlunoPanel` com um layout de borda e adiciona um painel de formulário no centro.
     * O painel de formulário contém campos de texto para o nome, idade, CPF, telefone e plano de treino do aluno, além de um
     * botão para adicionar o aluno e outro para voltar ao painel de gerenciamento de alunos. Também inclui uma área de texto
     * para exibir informações sobre o aluno adicionado.
     *
     * O botão "Adicionar Aluno" coleta os dados dos campos de texto, cria um objeto `Aluno` com esses dados e o adiciona à
     * lista de alunos. Os dados do aluno são persistidos usando o objeto `persisteAluno`. A área de texto é atualizada para
     * exibir a representação do aluno adicionado.
     *
     * O método também configura um adaptador de teclado para permitir a navegação entre os campos de texto usando a tecla Enter
     * e acionar a ação do botão "Adicionar Aluno" ao pressionar Enter no campo de texto do plano de treino.
     */
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

            Aluno aluno = new Aluno(nome, idade, cpf, telefone, planoDeTreino);
            alunos.add(aluno);
            persisteAluno.persisteDados(aluno);
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

    /**
     * Cria e configura o painel para listar todos os alunos.
     *
     * Este método inicializa o painel `listAlunosPanel` com um layout de borda e adiciona uma área de texto no centro para
     * exibir a lista de alunos. Um botão "Atualizar Lista" é adicionado no topo para atualizar a lista de alunos exibida na
     * área de texto. Outro botão "Voltar" é adicionado na parte inferior para retornar ao painel de gerenciamento de alunos.
     *
     * O botão "Atualizar Lista" limpa a área de texto e itera sobre a lista de alunos, adicionando a representação de cada
     * aluno à área de texto.
     */
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

    /**
     * Cria e configura o painel para adicionar um novo instrutor.
     *
     * Este método inicializa o painel `addInstrutorPanel` com um layout de borda e adiciona um painel de formulário no centro.
     * O painel de formulário contém campos de texto para o nome, idade, CPF, telefone e especialidade do instrutor, além de um
     * botão para adicionar o instrutor e outro para voltar ao painel de gerenciamento de instrutores. Também inclui uma área de texto
     * para exibir informações sobre o instrutor adicionado.
     *
     * O botão "Adicionar Instrutor" coleta os dados dos campos de texto, cria um objeto `Instrutor` com esses dados e o adiciona à
     * lista de instrutores. Os dados do instrutor são persistidos usando o objeto `persisteInstrutor`. A área de texto é atualizada para
     * exibir a representação do instrutor adicionado.
     *
     * O método também configura um adaptador de teclado para permitir a navegação entre os campos de texto usando a tecla Enter
     * e acionar a ação do botão "Adicionar Instrutor" ao pressionar Enter no campo de texto da especialidade.
     */
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
            persisteInstrutor.persisteDados(instrutor);
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

    /**
     * Cria e configura o painel para listar todos os instrutores.
     *
     * Este método inicializa o painel `listInstrutoresPanel` com um layout de borda e adiciona uma área de texto no centro para
     * exibir a lista de instrutores. Um botão "Atualizar Lista" é adicionado no topo para atualizar a lista de instrutores exibida na
     * área de texto. Outro botão "Voltar" é adicionado na parte inferior para retornar ao painel de gerenciamento de instrutores.
     *
     * O botão "Atualizar Lista" limpa a área de texto e itera sobre a lista de instrutores, adicionando a representação de cada
     * instrutor à área de texto.
     */
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

    /**
     * Cria e inicializa o painel para adicionar uma nova aula no aplicativo.
     * Este painel inclui campos para inserir o tipo da aula, o horário e o instrutor.
     * Também contém um botão para adicionar a aula ao sistema e outro para navegar de volta
     * ao menu de gerenciamento de aulas.
     *
     * É feita uma validação para verificar se o instrutor responsável fornecido existe para adicionar a nova aula
     *
     * O painel é estruturado com um formulário para inserir os detalhes e uma área de saída
     * para exibir feedback. Um listener de tecla é adicionado para permitir o envio do formulário
     * pressionando a tecla Enter.
     */
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
                persisteAula.persisteDados(aula);
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


    /**
     * Cria e inicializa o painel para listar todas as aulas no aplicativo.
     * Este painel inclui uma área de texto para exibir a lista de aulas e botões para atualizar
     * a lista ou voltar ao menu de gerenciamento de aulas.
     *
     * O botão de atualizar atualiza a lista exibida de aulas e o botão de voltar retorna
     * ao menu de gerenciamento de aulas.
     */
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

    /**
     * Classe principal que inicializa a interface gráfica.
     * @param args Argumentos da função main.
     */
    public static void main(String[] args) {
        new AcademiaGUI();
    }
}
