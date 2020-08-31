import React, { Component } from "react";
import BarChart from "./barChart";
import PieChart from "./pieChart";

class ChartPanel extends Component {
  render(props) {
    return (
      <div key={this.props.weatherDataItems[0].year} className="chart col">
        <div className="row">
          <div className="card">
            <h5 className="card-header">Rainy Days Per Month</h5>
            <div className="card-body">
              <p className="card-text">
                <BarChart weatherDataItems={this.props.weatherDataItems} />
              </p>
            </div>
          </div>
        </div>
        <div className="row mt-2">
          <div className="card">
            <h5 className="card-header">Precipitation Per Season</h5>
            <div className="card-body">
              <p className="card-text">
                <PieChart weatherDataItems={this.props.weatherDataItems} />
              </p>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ChartPanel;
