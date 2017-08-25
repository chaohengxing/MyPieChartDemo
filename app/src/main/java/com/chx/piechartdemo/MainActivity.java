package com.chx.piechartdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyPieChart.OnItemClickListener {

    private MyPieChart myPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPieChart = (MyPieChart) findViewById(R.id.mypiechart);

        myPieChart.setRadius(DensityUtils.dp2px(this, 80));

        myPieChart.setOnItemClickListener(this);

        List<MyPieChart.PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new MyPieChart.PieEntry(0, R.color.chart_orange, true));
        pieEntries.add(new MyPieChart.PieEntry(1, R.color.chart_green, false));
        pieEntries.add(new MyPieChart.PieEntry(0, R.color.chart_blue, false));
        pieEntries.add(new MyPieChart.PieEntry(0, R.color.chart_purple, false));
        pieEntries.add(new MyPieChart.PieEntry(0, R.color.chart_mblue, false));
        pieEntries.add(new MyPieChart.PieEntry(0, R.color.chart_turquoise, false));

        myPieChart.setPieEntries(pieEntries);

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "点击了" + position, Toast.LENGTH_SHORT).show();
    }
}
