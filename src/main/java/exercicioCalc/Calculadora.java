package exercicioCalc;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    private static final String CAMPO1 = "Campo 1";
    private static final String CAMPO2 = "Campo 2";
    private JTextField campoValor1;
    private JTextField campoValor2;
    private JButton botaoSomar;
    private Boolean falha = Boolean.FALSE;

    public Calculadora() {
        setTitle("Calculadora que só Soma");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        // Label campo 1;
        JLabel labelCampo1 = new JLabel(CAMPO1);
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelCampo1, constraints);

        // Label campo 2;
        JLabel labelCampo2 = new JLabel(CAMPO2);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(labelCampo2, constraints);

        //Campo valor 1
        campoValor1 = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(campoValor1, constraints);

        // Campo valor 2;
        campoValor2 = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painel.add(campoValor2, constraints);

        botaoSomar = new JButton("Somar");
        botaoSomar.addActionListener(e -> somar());
        constraints.gridx = 2;
        constraints.gridy = 1;
        painel.add(botaoSomar, constraints);

        add(painel);
        setLocationRelativeTo(null);
    }

    //    Método de converter a String para Integer;
    private Integer converter(String valorStr, String campo) {

        try {
            if (valorStr.isEmpty()) throw new CalculadoraException("O valor do " + campo + " não deve ser nulo");
            if (valorStr.isBlank()) throw new CalculadoraException("O valor do %s não pode ser espaços".formatted(campo));
            return Integer.parseInt(valorStr);
        } catch (NumberFormatException n) {
            this.falha = Boolean.TRUE;
            JOptionPane.showMessageDialog(
                    this, "O valor do $s não é válido. Informar apenas números interios".formatted(campo));
            return 0;
        } catch (CalculadoraException e) {
            this.falha = e.isFalha();
            JOptionPane.showMessageDialog(this, e.getMessage());
            return 0;
        }
    }

    // Método somar;
    private void somar() {
            var valor1 = converter(campoValor1.getText(), CAMPO1);
            var valor2 = converter(campoValor2.getText(), CAMPO2);

            if (this.falha) {
                this.falha = Boolean.FALSE;
                return;
            }

            var total = valor1 + valor2;
            JOptionPane.showMessageDialog(this, "Resultado: " + total);
        }
    }

