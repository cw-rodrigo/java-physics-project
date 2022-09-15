import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// --- ESSE "ACTIONLISTENER" É QUEM CONTROLA O QUE IRÁ ACONTECER AO PRESSIONAR UM BOTÃO.
public class EstudoSobreInterface implements ActionListener {

    //  --- DECLARANDO VARIÁVEIS (SIM, JFRAME, JBUTTON E JTEXTFIELD SÃO OS TIPOS DESSAS VARIÁVEIS) ---
    JFrame janela = new JFrame();
    JButton botao = new JButton("Imprimir Texto Escrito");
    JTextField textoEntrada = new JTextField(30);

    // --- ESSE MÉTODO ABAIXO É O MÉTODO CONSTRUTOR (CHAMADO DE "EstudoSobreInterface"), O MÉTODO CONSTRUTOR
    // --- SEMPRE TEM O MESMO NOME QUE A CLASSE ---
    public EstudoSobreInterface () {

        // --- ADICIONANDO AÇÃO AO BOTAO (FAZER ALGO QUANDO ELE FOR PRESSIONADO) ---
        botao.addActionListener(this);

        // --- CONFIGURAÇÃO DA JANELA ---

        janela.setSize(640, 480);
        janela.setTitle("Olá, Mundo!");
        janela.setLayout(new FlowLayout());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- ADICIONANDO ELEMENTOS NA JANELA ---
        // --- (NESSE CASO, ESTOU ADICIONANDO APENAS UMA CAIXA DE ENTRADA DE TEXTO E UM BOTÃO) ---
        janela.add(textoEntrada);
        janela.add(botao);

        janela.setVisible(true);
    }

    public static void main(String[] args) {
        // --- A LINHA ABAIXO SIMPLESMENTE ESTÁ EXECUTANDO O MÉTODO CONSTRUTOR... ---
        new EstudoSobreInterface();
    }

    // --- MÉTODO RESERVADO PARA ESPECIFICAR QUAL A AÇÃO AO PRESSIONAR UM BOTÃO (FAZ PARTE DO ACTIONLISTENER)
    // --- (NESSE CASO, SERÁ IMPRIMIDO O QUE O USUÁRIO DIGITAR AO PRESSIONAR O BOTÃO) ---
    public void actionPerformed(ActionEvent event) {
        System.out.println(textoEntrada.getText());
    }
}
