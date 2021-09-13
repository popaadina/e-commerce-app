import React, { Component } from "react";
import { Jumbotron } from "react-bootstrap";


class Welcome extends Component {
  render() {
    return (
      <Jumbotron className="bg-dark text-white text-center">
        <h1 className="p-2">Welcome to Cake Shop</h1>
        <blockquote className="blockquote pb-2">
          <p>We know how to make your life awesome!</p>
        </blockquote>
      </Jumbotron>
    );
  }
}
export default Welcome;
