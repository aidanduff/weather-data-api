import React, { Component } from "react";
import { Pie } from "react-chartjs-2";
import { getSeasonalPrecipitation } from "../utils/seasonalPrecipitation";
import { colorData } from "./../utils/colorData";

class PieChart extends Component {
  render(props) {
    const { weatherDataItems } = this.props;
    const chartData = {};
    chartData.labels = ["Winter", "Spring", "Summer", "Autumn"];
    chartData.datasets = [
      {
        label: `Rainy days per month in ${weatherDataItems[0].year}`,
        data: getSeasonalPrecipitation(weatherDataItems),
        backgroundColor: colorData,
      },
    ];

    return (
      <Pie
        data={chartData}
        width={500}
        height={223}
        options={{ maintainAspectRatio: true }}
      />
    );
  }
}

export default PieChart;
