import React, { Component } from "react";

import { Card, Button } from "react-bootstrap";
import axios from "axios";

import { Link } from "react-router-dom";

class ProductList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
    };
  }

  componentDidMount() {
    this.findAllProducts();
  }

  findAllProducts() {
    axios
      .get("http://localhost:8080/api/product")
      .then((response) => response.data)
      .then((data) => {
        console.log(data);
        this.setState({ products: data });
      });
  }

  createOrder(e, data) {
    
    axios.post("http://localhost:8080/api/orders", data)
    .then(res => console.log(res))
    .catch(err => console.log(err));
  }

  

  render() {
    return this.state.products.map((product, index) => (
      <Card
        key={index}
        product={product}
        className="tc bg-light-white dib ma3"
      >
        <Card.Img
          variant="top"
          src={`${product.pictureUrl}`}
          width="50"
          height="300"
        />
        <Card.Body>
          <Card.Subtitle>{product.name}</Card.Subtitle>
          <Card.Text>Price: {product.price}</Card.Text>
        </Card.Body>
        <Card.Body>
          
         
        <div className="d-grid gap-2">
  <Button variant="primary" size="lg" onClick={((e) => this.createOrder(e, product))}>Add to cart</Button>
        </div>
         
        </Card.Body>
      </Card>
    ));
  }
}

export default ProductList;
