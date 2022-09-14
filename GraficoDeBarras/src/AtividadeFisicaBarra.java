import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class AtividadeFisicaBarra extends JFrame {
    public AtividadeFisicaBarra() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Atividade de Física - Gráfico de Barras");
        setSize(640, 480);
        setLocationRelativeTo(null);

        criarGrafico();

        setVisible(true);
    }

    public void criarGrafico() {
        // DEFININDO TIPO DO GRÁFICO (GRÁFICO DE BARRAS NESSE CASO).
        DefaultCategoryDataset graficoBarra = new DefaultCategoryDataset();

        // DEFININDO VALORES NO GRÁFICO.
        graficoBarra.setValue(20, "Rodrigo", "Geralt");
        graficoBarra.setValue(20, "Vinícius", "O Bilíngue");
        graficoBarra.setValue(7, "Marco", "O 'Biólogo'");

        JFreeChart grafico = ChartFactory.createBarChart3D("Percentual de Realizações de Tarefas", "Durante Todo o Bimestre", "Percentual", graficoBarra, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot barraDoGrafico = grafico.getCategoryPlot();

        // DEFININDO CORES DO GRÁFICO.
        barraDoGrafico.getRenderer().setSeriesPaint(0, Color.GRAY);
        barraDoGrafico.getRenderer().setSeriesPaint(1, Color.DARK_GRAY);
        barraDoGrafico.getRenderer().setSeriesPaint(2, Color.LIGHT_GRAY);

        // DESENHANDO O GRÁFICO NA TELA.
        ChartPanel painel = new ChartPanel(grafico);
        add(painel);
    }

    public static void main(String[] args) {
        System.out.print("-- Inicio do Programa --");

        new AtividadeFisicaBarra();
    }
}
