import React, { Component } from "react";
import axios from "axios";

import { Table } from "react-bootstrap";

class ShoppingCart extends Component {
    constructor(props) {
      super(props);
      this.state = {
        orders: [],
      };
    }
  
    componentDidMount() {
      this.findAllOrders();
    }
  
    findAllOrders() {
      axios
        .get("http://localhost:8080/api/orders")
        .then((response) => response.data)
        .then((data) => {
          console.log(data);
          this.setState({ orders: data });
        });
    }

    deleteOrder(e, data) {
      console.log(data);
      axios.delete("http://localhost:8080/api/orders", {data: data})
      .then(res => {console.log(res);
        window.location.reload();
      }
      ) 
      .catch(err => console.log(err));
    }      

    render() {

      let total = 0;
      const tableData = this.state.orders.map((order, index) => {
        console.log(order);
        total = total + order.price;

        return (
        <tr key={index}>
          <td>{order.name}</td>
          <td>{order.price}</td>
          <td><button className="btn btn-warning" onClick={((e) => this.deleteOrder(e, order))}>Delete</button></td>
        </tr>
        )
      });

     return (
       <div>
        <Table striped bordered hover>
  <thead>
    <tr>
      <th>Name</th>
      <th>Price</th>  
    </tr>
  </thead>
  <tbody>
  {
    tableData
  }
  </tbody>
</Table>

<div>
  total: {total}
</div>

</div>


      ) 
      
    }

    }
    export default ShoppingCart;