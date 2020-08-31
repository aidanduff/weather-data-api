import React, { Component } from "react";
import Message from "./message";
import weatherDataService from "../services/weatherDataService";

class FileUpload extends Component {
  state = {
    file: null,
    buttonStatus: false,
    showMessage: false,
    filePresent: false,
    errorMessage: "",
  };

  onFormSubmit = (e) => {
    e.preventDefault(); // Stop form submit
    if (this.state.file != null) {
      weatherDataService.addRecord(this.state.file).then((response) => {
        this.props.history.push({
          pathname: "/home",
          state: {
            showMessage: true,
            message: response.data.message,
          },
        });
      });
    }
  };

  componentDidMount() {
    weatherDataService.retrieveAllData().then((response) => {
      this.setState({ filePresent: response.status === 200 });
    });
  }

  getButtonStatus = () => {
    return this.state.buttonStatus
      ? "btn btn-primary btn-block mt-4"
      : "btn btn-primary btn-block mt-4 disabled";
  };

  onChange = (e) => {
    const str = e.target.files[0].name;
    if (str.endsWith(".csv")) {
      this.setState({
        file: e.target.files[0],
        buttonStatus: true,
      });
    } else {
      this.setState(
        {
          showMessage: true,
          errorMessage: "File must be in .csv format!",
        },
        () =>
          setTimeout(() => {
            this.setState({ showMessage: false });
          }, 3000)
      );
    }
  };

  render() {
    const { showMessage, errorMessage, filePresent } = this.state;
    return (
      <div className="contentContainer">
        {showMessage && (
          <Message
            showMessage={showMessage}
            messageClass={"alert alert-danger"}
            duration={3000}
            message={errorMessage}
          />
        )}
        {!filePresent ? (
          <form onSubmit={this.onFormSubmit}>
            <h1 className="mt-2">File Upload</h1>
            <div className="custom-file mt-4">
              <div className="input-group">
                <input
                  type="file"
                  accept="text/csv, .csv"
                  className="custom-file-input"
                  id="customFile"
                  onChange={this.onChange}
                />
                <label className="custom-file-label" htmlFor="customFile">
                  {this.state.file === null
                    ? "Choose File"
                    : this.state.file.name}
                </label>
              </div>
              <button className={this.getButtonStatus()} type="submit">
                Upload
              </button>
            </div>
          </form>
        ) : (
          <h3 className="mt-2">
            A dataset is already present in the system. You must delete this
            before uploading another. This is to ensure that data is presented
            in a way that makes sense. To delete the existing record set, go to
            the settings tab and click the Delete button.
          </h3>
        )}
      </div>
    );
  }
}

export default FileUpload;
