package com.android.customer.chartdemo;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BarChart chart;
    private PieChart pieChart;
    private PieView pieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBarData();
        initPieData();
        initPieView();
    }

    private void initPieView() {
        List<PieEntry> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(new PieEntry(i * 20, String.format("第%s区", i)));
        }
        pieView.setBlockTextSize(14);
        pieView.setData(list)
                .setShowAnimator(true)
                .refresh();
    }

    private void initPieData() {
        List<String> values = new ArrayList<>();
        List<Entry> y = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            y.add(new Entry(i + 3, i));
            values.add("测试" + i);
        }
        IPieDataSet dataSet = new PieDataSet(y, "group1");
        dataSet.setValueTextSize(16);
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.BLACK);
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        dataSet.setValueTextColors(colors);
        PieData data = new PieData(values, dataSet);
        pieChart.setDescription("测试111");
        pieChart.setHoleColor(Color.RED);
        pieChart.setData(data);
    }

    private void initBarData() {
        XAxis xAxis = chart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getAxisRight().setEnabled(false);
        chart.setDrawBorders(false);
        chart.setHighlightFullBarEnabled(false);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        //x轴方向上的坐标值
        List<String> xValues = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            xValues.add(String.valueOf(i + 1));
        }
        //所有柱状图的数据集合
        List<IBarDataSet> dataSets = new ArrayList<>();
        //每一个柱状图的数据
        List<BarEntry> y1 = new ArrayList<>();
        List<BarEntry> y2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            BarEntry entry = new BarEntry(i * 3, i);//单个的柱状图
            y1.add(entry);

            BarEntry entry2 = new BarEntry(i * 2 + 3, i);//单个的柱状图
            y2.add(entry2);
        }
        BarDataSet dataSet = new BarDataSet(y1, "Android");//一组柱状图
        BarDataSet dataSet2 = new BarDataSet(y2, "Java");
        //修改一组柱状图的颜色
        dataSet.setColor(Color.RED);
        dataSet2.setColor(Color.GRAY);
        //修改一组柱状图的文字大小
        dataSet.setValueTextSize(16);
        dataSet2.setValueTextSize(16);


        dataSets.add(dataSet);
        dataSets.add(dataSet2);

        BarData data = new BarData(xValues, dataSets);
        chart.setData(data);

        //修改图表的描述信息
        chart.setDescription("Android Java 薪资分析");
        //设置动画
        chart.animateXY(1000, 1000);

        chart.setDrawBarShadow(false);
    }

    private void initView() {
        chart = findViewById(R.id.chart);
        pieChart = findViewById(R.id.pieChart);
        pieView = findViewById(R.id.pieView);
    }
}