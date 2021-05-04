package org1.ml;
import java.io.IOException;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;

public class DataAnalysis {
	
	public static void main(String args[])
	{
		System.out.println("data analysis");
	
	try
	{
		Table credit_card= Table.read().csv("C:\\Users\\Dell\\eclipse-workspace\\org1.ml\\src\\main\\java\\org1\\ml\\crdt.csv");
		
		System.out.println(credit_card.shape());
		System.out.println(credit_card.first(7));
		System.out.println(credit_card.last(7));
		System.out.println(credit_card.summary());
		System.out.println(credit_card.structure());
////	Histogram
		Layout layout1 = Layout.builder().title("Distribution Over draft").build();
	    HistogramTrace trace1 = HistogramTrace.builder(credit_card.nCol("C1")).build();
	    Plot.show(new Figure(layout1, trace1));
	    Layout layout2 = Layout.builder().title("Distribution of  Credit usage").build();
	    HistogramTrace trace2 = HistogramTrace.builder(credit_card.nCol("C2")).build();
	    Plot.show(new Figure(layout2, trace2));
	    Layout layout3 = Layout.builder().title("Distribution of Credit history").build();
	    HistogramTrace trace3 = HistogramTrace.builder(credit_card.nCol("C3")).build();
	    Plot.show(new Figure(layout3, trace3));
	    Layout layout4 = Layout.builder().title("Distribution of Purpose").build();
	    HistogramTrace trace4 = HistogramTrace.builder(credit_card.nCol("C4")).build();
	    Plot.show(new Figure(layout4, trace4));
	    Layout layout5 = Layout.builder().title("Distribution of Current balance").build();
	    HistogramTrace trace5 = HistogramTrace.builder(credit_card.nCol("C5")).build();
	    Plot.show(new Figure(layout5, trace5));
	    Layout layout6 = Layout.builder().title("Distribution of  Average credit balance").build();
	    HistogramTrace trace6 = HistogramTrace.builder(credit_card.nCol("C6")).build();
	    Plot.show(new Figure(layout6, trace6));
	    Layout layout13 = Layout.builder().title("Distribution of Employment").build();
	    HistogramTrace trace13 = HistogramTrace.builder(credit_card.nCol("C7")).build();
	    Plot.show(new Figure(layout13, trace13));
	    
	    
	    Layout layout7 = Layout.builder().title("Credit usage by Purpose ").build();
	    BoxTrace trace7 =BoxTrace.builder(credit_card.categoricalColumn("C4"), credit_card.nCol("C2")).build();
	    Plot.show(new Figure(layout7, trace7));
	    Layout layout8 = Layout.builder().title(" Credit usage by Average credit balance").build();
	    BoxTrace trace8 =BoxTrace.builder(credit_card.categoricalColumn("C6"), credit_card.nCol("C2")).build();
	    Plot.show(new Figure(layout8, trace8));
	    Layout layout9 = Layout.builder().title(" Credit usage by Employment").build();
	    BoxTrace trace9 =BoxTrace.builder(credit_card.categoricalColumn("C7"), credit_card.nCol("C2")).build();
	    Plot.show(new Figure(layout9, trace9));
	    Layout layout10 = Layout.builder().title(" Credit history by existing credits").build();
	    BoxTrace trace10 =BoxTrace.builder(credit_card.categoricalColumn("C16"), credit_card.nCol("C3")).build();
	    Plot.show(new Figure(layout10, trace10));
	    Layout layout11 = Layout.builder().title(" Employment by Job").build();
	    BoxTrace trace11 =BoxTrace.builder(credit_card.categoricalColumn("C17"), credit_card.nCol("C7")).build();
	    Plot.show(new Figure(layout11, trace11));
	    Layout layout12 = Layout.builder().title("Foreign worker by Residence since").build();
	    BoxTrace trace12 =BoxTrace.builder(credit_card.categoricalColumn("C11"), credit_card.nCol("C20")).build();
	    Plot.show(new Figure(layout12, trace12));
	    Layout layout14 = Layout.builder().title("Other payment plans by Average credit balance").build();
	    BoxTrace trace14 =BoxTrace.builder(credit_card.categoricalColumn("C6"), credit_card.nCol("C14")).build();
	    Plot.show(new Figure(layout14, trace14));
	    Layout layout15 = Layout.builder().title(" Property magnitude by Purpose").build();
	    BoxTrace trace15 =BoxTrace.builder(credit_card.categoricalColumn("C12"), credit_card.nCol("C4")).build();
	    Plot.show(new Figure(layout15, trace15));
	    
	}
	catch(IOException e)  
	{
		e.printStackTrace();
	}
}
} 