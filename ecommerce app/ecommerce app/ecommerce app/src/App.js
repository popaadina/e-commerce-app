import { Component } from "react";
import "./App.css";

import NavigationBar from "./Components/NavigationBar";
import Welcome from "./Components/Welcome";
import Footer from "./Components/Footer";
import ProductList from "./Components/ProductList";
import ShoppingCart from "./Components/ShoppingCart";
import { Container } from "react-bootstrap";

import { BrowserRouter as Router, Switch, Route } from "react-router-dom";


import "tachyons";

class App extends Component {
  render() {
    return (
      <div>
      <Router>
        <NavigationBar />
        <Container>
          <Switch>
            <Route path="/" exact component={Welcome} />
            <Route path="/list" exact component={ProductList} />
            <Route path="/shoppingCart" exact component={ShoppingCart} />
          </Switch>
        </Container>
        <Footer />
      </Router>
      </div>

    );
  }
}

export default App;
