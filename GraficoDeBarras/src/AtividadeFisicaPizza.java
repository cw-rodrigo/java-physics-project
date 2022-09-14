import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JFrame;
import java.awt.*;

public class AtividadeFisicaPizza extends JFrame {
    public AtividadeFisicaPizza() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Atividade de Física - Gráfico de Pizza");
        setSize(640, 480);
        setLocationRelativeTo(null);

        criarGrafico();

        setVisible(true);
    }

    public void criarGrafico() {
        // DEFININDO TIPO DO GRÁFICO (GRÁFICO DE PIZZA NESSE CASO).
        DefaultPieDataset graficoPizza = new DefaultPieDataset();

        // DEFININDO VALORES NO GRÁFICO.
        graficoPizza.setValue("Marco", 5);
        graficoPizza.setValue("Rodrigo", 40);
        graficoPizza.setValue("Vinícius", 40);

        JFreeChart grafico = ChartFactory.createPieChart("Percentual de Realizações de Tarefas", graficoPizza, true, true, false);
        PiePlot fatiaDoGrafico = (PiePlot) grafico.getPlot();

        // DEFININDO CORES DO GRÁFICO.
        fatiaDoGrafico.setSectionPaint("Marco", Color.LIGHT_GRAY);
        fatiaDoGrafico.setSectionPaint("Rodrigo", Color.DARK_GRAY);
        fatiaDoGrafico.setSectionPaint("Vinícius", Color.GRAY);

        // DESENHANDO O GRÁFICO NA TELA.
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }

    public static void main(String[] args) {
        System.out.print("-- Inicio do Programa --");

        new AtividadeFisicaPizza();
    }
}
