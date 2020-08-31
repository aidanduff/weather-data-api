import React, { Component } from "react";

class WeatherDataTable extends Component {
  render(props) {
    const { weatherDataItems } = this.props;
    return (
      <React.Fragment>
        <table className="table table-bordered">
          <thead className="thead-dark">
            <tr>
              <th>Year</th>
              <th>Month</th>
              <th>Precipitation (mm)</th>
              <th>Greatest Daily Rainfall (mm)</th>
              <th>Rainy Days</th>
            </tr>
          </thead>
          <tbody>
            {weatherDataItems.map((weatherDataItem) => (
              <tr key={weatherDataItem.id}>
                <td>{weatherDataItem.year}</td>
                <td>{weatherDataItem.month}</td>
                <td>{weatherDataItem.rain}</td>
                <td>{weatherDataItem.gdf}</td>
                <td>{weatherDataItem.rd}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </React.Fragment>
    );
  }
}

export default WeatherDataTable;
