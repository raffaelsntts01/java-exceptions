package introducaoGUI;

import javax.swing.*;
import java.awt.*;

public class JanelaEntradaGUI extends JFrame{
    private JTextField campoNome;
    private JTextField campoSobreNome;
    private JButton botaoEnviar;

    public JanelaEntradaGUI() {
        setTitle("Janela de Entrada");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridBagLayout organiza os componentes em uma grade
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelNome = new JLabel("Digite seu nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(campoNome, constraints);

        JLabel labelSobreNome = new JLabel("Digite seu sobrenome:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(labelSobreNome, constraints);

        campoSobreNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painel.add(campoSobreNome, constraints);

        botaoEnviar = new JButton("Enviar");
        botaoEnviar.addActionListener(e -> executarAcaoDoBotao());
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        painel.add(botaoEnviar, constraints);

        // Adicionar o painel à janela
        add(painel);

        // Centralizar a janela na tela
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JanelaEntradaGUI janela = new JanelaEntradaGUI();
            janela.setVisible(true);
        });
    }

    private void validarNumero()throws NumberFormatException {
        if(campoNome.getText().isEmpty()) throw  new RuntimeException("Não pode ser vazio");

        var numero = Integer.parseInt(campoNome.getText());
        System.out.println(numero);
    }
    private void executarAcaoDoBotao() {
        try {
            validarNumero();
            var valorDigitado = campoNome.getText() + " " + campoSobreNome.getText();
            JOptionPane.showMessageDialog(this, "Parabéns " + valorDigitado);
        } catch (NumberFormatException e){
            System.out.println("Precisa ser apenas números !");
        } catch (RuntimeException re){
            System.out.println(re.getMessage());
        }


        var valorDigitado = campoNome.getText() + " " + campoSobreNome.getText();
        JOptionPane.showMessageDialog(this, "Parabéns " + valorDigitado);
    }
}

