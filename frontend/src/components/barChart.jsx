import React, { Component } from "react";
import { Bar } from "react-chartjs-2";
import { colorData } from "./../utils/colorData";

class BarChart extends Component {
  getChartData(weatherDataItems) {
    const chartData = {
      labels: weatherDataItems.map((wdi) => wdi.month),
      datasets: [
        {
          label: `Rainy days per month in ${weatherDataItems[0].year}`,
          data: weatherDataItems.map((wdi) => wdi.rd),
          backgroundColor: colorData,
        },
      ],
    };
    return chartData;
  }

  render(props) {
    const chartData = this.getChartData(this.props.weatherDataItems);
    return (
      <Bar
        data={chartData}
        width={500}
        height={223}
        options={{ maintainAspectRatio: false }}
      />
    );
  }
}

export default BarChart;
