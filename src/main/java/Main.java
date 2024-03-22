import introducaoGUI.JanelaEntradaGUI;

public class Main {
    public static void main(String[] args) {

            javax.swing.SwingUtilities.invokeLater(() -> {
                JanelaEntradaGUI janela = new JanelaEntradaGUI();
                janela.setVisible(true);
            });
        }
    }