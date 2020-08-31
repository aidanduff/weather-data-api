import React from "react";

const About = () => {
  return (
    <div className="pt-4">
      <h1>About</h1>
      <br></br>
      <h5>
        RainyDays v1.0.0<br></br>
        <br></br> This application is designed to store and display monthly
        weather data in the form of tables and graphs. The weather data to be
        used here can be obtained from gov.ie which has an extensive collection
        of datasets in .csv format. Below are some links to obtain examples of
        these files, be sure to choose the monthly files.{" "}
        <p className="text-center">
          <br></br>
          <a
            href="https://data.gov.ie/dataset/dublin-ringsend-rainfall-data"
            className="text-right"
          >
            Dublin 1941 - 2020
          </a>
          <br></br>
          <a
            href="https://data.gov.ie/dataset/athlone-opw-rainfall-datai"
            className="text-right"
          >
            Athlone 1941 - 2020
          </a>
          <br></br>
          <a
            href="https://data.gov.ie/dataset/roundstone-rainfall-data"
            className="text-right"
          >
            Galway 1985 - 2020
          </a>
          <br></br>
        </p>
        The server side of this programme was created with the Spring Boot
        framework and the Java Persistance API, along with SQL. The client side
        uses React JS. Both backend and frontend respectively are available from
        the following github repositories.{" "}
        <p className="text-center">
          {" "}
          <br></br>
          <a
            href="https://github.com/aidanduff/weather-data-ui"
            className="text-right"
          >
            Front End
          </a>
          <br></br>
          <a
            href="https://github.com/aidanduff/weather-data-api"
            className="text-right"
          >
            Back End
          </a>
          <br></br>
        </p>
        For any queries or complaints regarding this application, please send a
        mail to aidanduff@gmail.com.
        <br></br>
        <br></br>
        <p className="text-center">
          <a href="https://github.com/aidanduff" className="text-right">
            <i className="fa fa-github fa-github-about  fa-2x"> </i>
          </a>
          &nbsp;
          <a
            href="https://www.linkedin.com/in/aidan-d-31294a16a/"
            className="text-right"
          >
            <i className="fa fa-linkedin fa-linkedin-about fa-2x"> </i>
          </a>
        </p>
      </h5>
    </div>
  );
};

export default About;
