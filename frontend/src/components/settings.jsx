import React from "react";
import WeatherDataService from "../services/weatherDataService";
import Message from "./message";
import { Component } from "react";

class Settings extends Component {
  state = {
    showMessage: false,
  };
  handleClick = () => {
    WeatherDataService.deleteAllData();
    this.setState(
      {
        showMessage: true,
      },
      () =>
        setTimeout(() => {
          this.setState({ showMessage: false });
        }, 3000)
    );
  };

  render() {
    const { showMessage } = this.state;
    return (
      <div className="contentContainer">
        {showMessage && (
          <Message
            showMessage={showMessage}
            messageClass={"alert alert-success"}
            duration={3000}
            message={"All files deleted"}
          />
        )}
        <h1 className="mt-2">Delete</h1>
        <button
          className="btn btn-primary btn-block mt-4 shadow-none"
          onClick={this.handleClick}
          type="submit"
        >
          Delete
        </button>
      </div>
    );
  }
}

export default Settings;
