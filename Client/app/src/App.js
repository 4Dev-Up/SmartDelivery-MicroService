import React, { Component } from "react";
import logo from "./logo.svg";
import "./App.css";

class App extends Component {
  state = {
    isLoading: true,
    autos: [],
  };
  async componentDidMount() {
    const response = await fetch("aero-service/api/aero/get");
    const body = await response.json();
    console.log("json", response);
    this.setState({ autos: body, isLoading: false });
  }

  render() {
    const { autos, isLoading } = this.state;
    if (isLoading) {
      console.log(autos);
      return <p>Loading...</p>;
    }

    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div className="App-intro">
            <h2>Auto mobile :</h2>
            {autos.map((auto) => (
              <div key={auto.id}>{auto.matricule}</div>
            ))}
          </div>
        </header>
      </div>
    );
  }
}

export default App;
