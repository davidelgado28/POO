import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class CadastroAlunos extends JFrame {

    private JTextField txtNome;
    private JTextField txtNota;
    private JButton    btnCadastrar;
    private JButton    btnLimpar;
    private JTextArea  areaLista;
    private ArrayList<String> alunos = new ArrayList<>();

    public CadastroAlunos() {
        setTitle("Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializar();
        registrar();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void inicializar() {
        txtNome      = new JTextField(18);
        txtNota      = new JTextField(6);
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar    = new JButton("Limpar Lista");
        areaLista    = new JTextArea(10, 32);
        areaLista.setEditable(false);
        areaLista.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaLista.setText("[ ALUNOS CADASTRADOS ]\n");

        JPanel pForm = new JPanel(new GridLayout(2, 2, 8, 6));
        pForm.add(new JLabel("Nome:"));         pForm.add(txtNome);
        pForm.add(new JLabel("Nota (0-10):"));  pForm.add(txtNota);

        JPanel pBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pBotoes.add(btnLimpar);
        pBotoes.add(btnCadastrar);

        JPanel pPrincipal = new JPanel(new BorderLayout(10, 10));
        pPrincipal.setBorder(
            BorderFactory.createEmptyBorder(12, 12, 12, 12));
        pPrincipal.add(pForm,    BorderLayout.NORTH);
        pPrincipal.add(pBotoes,  BorderLayout.CENTER);
        pPrincipal.add(new JScrollPane(areaLista),
                         BorderLayout.SOUTH);
        add(pPrincipal);
    }
    private void registrar() {

        btnCadastrar.addActionListener(e -> {
            try {
                String nome = txtNome.getText().trim();
                if (nome.isEmpty())
                    throw new IllegalArgumentException(
                        "O campo Nome não pode estar vazio.");

                double nota = Double.parseDouble(txtNota.getText());
                if (nota < 0 || nota > 10)
                    throw new IllegalArgumentException(
                        "A nota deve estar entre 0 e 10.");

                String situacao = nota >= 6.0
                    ? "✅ Aprovado" : "❌ Reprovado";

                alunos.add(nome + " — Nota: " + nota
                    + " | " + situacao);
                atualizarLista();

                txtNome.setText("");
                txtNota.setText("");
                txtNome.requestFocus();

            } catch (NumberFormatException ex) {
                mostrarErro("Nota inválida. Use ponto ou vírgula: ex 7.5");
            } catch (IllegalArgumentException ex) {
                mostrarErro(ex.getMessage());
            }
        });
        btnLimpar.addActionListener(e -> {
            int resp = JOptionPane.showConfirmDialog(
                this, "Limpar toda a lista?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                alunos.clear();
                atualizarLista();
            }
        });
        txtNota.addActionListener(
            btnCadastrar.getActionListeners()[0]);
    }
    private void atualizarLista() {
        StringBuilder sb = new StringBuilder("[ ALUNOS CADASTRADOS ]\n");
        for (int i = 0; i < alunos.size(); i++)
            sb.append((i+1) + ". " + alunos.get(i) + "\n");
        areaLista.setText(sb.toString());
    }
    private void mostrarErro(String msg) {
        JOptionPane.showMessageDialog(
            this, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CadastroAlunos::new);
    }
}