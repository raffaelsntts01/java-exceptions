package exercicioCalc;

import javax.swing.*;
import java.awt.*;


public class Calculadora extends JFrame {
    private JTextField campoValor1;
    private JTextField campoValor2;

    private JButton botaoSomar;

    public Calculadora() {
        setTitle("Calculadora que só Soma");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel labelCampo1 = new JLabel("Campo 1: ");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painel.add(labelCampo1, constraints);

        campoValor1 = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painel.add(campoValor1, constraints);

        JLabel labelCampo2 = new JLabel("Campo 2");
        constraints.gridx = 2;
        constraints.gridy = 0;
        painel.add(labelCampo2, constraints);

        campoValor2 = new JTextField(5);
        constraints.gridx = 3;
        constraints.gridy = 0;
        painel.add(campoValor2, constraints);

        botaoSomar = new JButton("Somar");
        botaoSomar.addActionListener(e -> somar());
        constraints.gridx = 0;
        constraints.gridy = 1;
        painel.add(botaoSomar, constraints);

        add(painel);
        setLocationRelativeTo(null);
    }

    private void validarNumbers() throws NumberFormatException {
        if (campoValor1.getText().isEmpty() & campoValor2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo não pode ser nulo");
        }

        var number1 = Integer.parseInt(campoValor1.getText());
        var number2 = Integer.parseInt(campoValor2.getText());
        System.out.println("Valor campo1: " + number1);
        System.out.println("Valor campo2: " + number2);
    }
    private void somar() {
        try {
            validarNumbers();
            var valor1 = Integer.parseInt(campoValor1.getText());
            var valor2 = Integer.parseInt(campoValor2.getText());
            var total = valor1 + valor2;

            JOptionPane.showMessageDialog(this, "Resultado: " + total);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"Precisar ser só números");

        }
        catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}
