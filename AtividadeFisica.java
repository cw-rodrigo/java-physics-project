import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Scanner;

public class AtividadeFisica implements ActionListener {
    //VARIÁVEIS:
    double valor1, valor2, valor3, valor4, resultado;
    String desejo, variacao;

    JFrame janela = new JFrame();
    JButton botaoGerar = new JButton("Gerar Gráfico");
    Scanner ler = new Scanner(System.in);

    public AtividadeFisica() {
        botaoGerar.setSize(10, 10);
        botaoGerar.addActionListener(this);

        janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);
        janela.setTitle("Atividade de Física - Gráfico de Pizza");
        janela.setSize(640, 720);
        janela.setLocationRelativeTo(null);
        janela.setResizable(false);
        janela.setLayout(new FlowLayout());

        // DESENHANDO BOTÃO "GERAR GRÁFICO"
        janela.add(BorderLayout.SOUTH, botaoGerar);

        System.out.println("Deseja gerar um grafico? (sim / nao)");
        desejo = ler.nextLine();


        if (Objects.equals(desejo, "sim")) {
            System.out.println("Informe o coeficiente de dilatacao (NÃO utilize notação cientifica). ");
            valor1 = ler.nextDouble();

            System.out.println("Informe o comprimento inicial. ");
            valor2 = ler.nextDouble();

            System.out.println("Informe o comprimento final. ");
            valor4 = ler.nextDouble();

            System.out.println("Informe a variacao da temperatura. ");
            valor3 = ler.nextDouble();

            System.out.println("Informe o tipo de dilatação (linear / superficial / volumetrica)");
            variacao = ler.nextLine();


            resultado = valor1 * valor2 * valor3;
            if (Objects.equals(variacao, "superficial")) {
                resultado = resultado * 2;
            } else if (Objects.equals(variacao, "volumetrica")) {
                resultado = resultado * 3;
            }
            janela.setVisible(true);
        } else {
            System.out.println("Saindo do Programa...");
            janela.setVisible(false);
        }
    }

    public ChartPanel criarGraficoBarras() {
        // DEFININDO TIPO DO GRÁFICO (GRÁFICO DE BARRAS NESSE CASO).
        DefaultCategoryDataset graficoBarra = new DefaultCategoryDataset();

        // DEFININDO VALORES NO GRÁFICO.
        graficoBarra.setValue((valor4 + resultado) , "Situação 1", "10m");
        graficoBarra.setValue(((valor4 + resultado) * 2), "Situação 2 ", "20m");
        graficoBarra.setValue(((valor4 + resultado) * 3), "Situação 3", "30m'");

        JFreeChart grafico = ChartFactory.createBarChart3D("Alunos: Rodrigo e Vinícius", "Física", "Percentual", graficoBarra, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barraDoGrafico = grafico.getCategoryPlot();

        // DEFININDO CORES DO GRÁFICO.
        //barraDoGrafico.getRenderer().setSeriesPaint(0, Color.GRAY);
        //barraDoGrafico.getRenderer().setSeriesPaint(1, Color.DARK_GRAY);
        //barraDoGrafico.getRenderer().setSeriesPaint(2, Color.LIGHT_GRAY);

        return new ChartPanel(grafico);
    }

    public ChartPanel criarGraficoPizza() {
        // DEFININDO TIPO DO GRÁFICO (GRÁFICO DE PIZZA NESSE CASO).
        DefaultPieDataset graficoPizza = new DefaultPieDataset();

        // DEFININDO VALORES NO GRÁFICO.
        graficoPizza.setValue("Situação 1", (valor4 + resultado));
        graficoPizza.setValue("Situação 2", ((valor4 + resultado) * 2));
        graficoPizza.setValue("Situação 3", ((valor4 + resultado) * 3));

        JFreeChart grafico = ChartFactory.createPieChart("Gráfico de Pizza", graficoPizza, false, true, false);
        PiePlot fatiaDoGrafico = (PiePlot) grafico.getPlot();

        // DEFININDO CORES DO GRÁFICO.
        //fatiaDoGrafico.setSectionPaint("Marco", Color.LIGHT_GRAY);
        //fatiaDoGrafico.setSectionPaint("Rodrigo", Color.DARK_GRAY);
        //fatiaDoGrafico.setSectionPaint("Vinícius", Color.GRAY);

        return new ChartPanel(grafico);
    }

    public static void main(String[] args) {
        System.out.print("-- Inicio do Programa --");

        new AtividadeFisica();
    }

    public void actionPerformed(ActionEvent event) {
        // LIMPA A TELA ANTERIOR (A TELA DE INSERÇÃO DOS DADOS QUE SERÃO USADOS NO GRÁFICO)
        janela.getContentPane().removeAll();

        // DESENHA OS GRÁFICOS NA TELA.
        janela.add(criarGraficoBarras());
        janela.add(criarGraficoPizza());

        janela.setLayout(new GridLayout(2, 2));

        // ATUALIZA A TELA, APLICANDO TUDO ACIMA
        janela.repaint();
        janela.setVisible(true);
    }
}
