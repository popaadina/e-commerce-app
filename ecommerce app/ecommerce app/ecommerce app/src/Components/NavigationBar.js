import React, { Component } from "react";
import { Navbar, Nav } from "react-bootstrap";

import { Link } from "react-router-dom";

class NavigationBar extends Component {
  render() {
    return (
      <Navbar bg="dark" className="p-3" variant="dark">
        <Link to={""} className="navbar-brand p-3">
          {" "}
          Cake Shop
        </Link>
        <div className="logo"></div>
        <Nav className="me-auto p-2">
          <Link to={"list"} className="nav-link">
            Product List
          </Link>
        </Nav>
        <Nav className="me-auto p-2 shoppingCart">
          <Link to={"shoppingCart"} className="nav-link">
            Shopping Cart
          </Link>
          <div className="cartLogo"></div>
        
        </Nav>
        
      </Navbar>
    );
  }
}

export default NavigationBar;
