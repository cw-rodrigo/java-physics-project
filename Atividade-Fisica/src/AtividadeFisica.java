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

public class AtividadeFisica implements ActionListener {
    JFrame janela = new JFrame();
    JButton botaoGerar = new JButton("Gerar Gráfico");

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

        janela.setVisible(true);
    }

    public ChartPanel criarGraficoBarras() {
        // DEFININDO TIPO DO GRÁFICO (GRÁFICO DE BARRAS NESSE CASO).
        DefaultCategoryDataset graficoBarra = new DefaultCategoryDataset();

        // DEFININDO VALORES NO GRÁFICO.
        graficoBarra.setValue(20, "Rodrigo", "Geralt");
        graficoBarra.setValue(20, "Vinícius", "O Bilíngue");
        graficoBarra.setValue(7, "Marco", "O 'Biólogo'");

        JFreeChart grafico = ChartFactory.createBarChart3D("Percentual de Realizações de Tarefas", "Durante Todo o Bimestre", "Percentual", graficoBarra, PlotOrientation.VERTICAL, false, true, false);
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
        graficoPizza.setValue("Marco", 5);
        graficoPizza.setValue("Rodrigo", 40);
        graficoPizza.setValue("Vinícius", 40);

        JFreeChart grafico = ChartFactory.createPieChart("Percentual de Realizações de Tarefas", graficoPizza, false, true, false);
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
