import React, { Component, Fragment } from 'react';
import axios from 'axios';
import logo_marchand from '../img/logo_paracasa.jpg';

import {Alert, Badge, NavbarBrand, Table} from 'reactstrap';
import logo from "../img/logo.png";
import sopay_logo from "../img/sopay_logo.png";

const reference = document.getElementById("reference").value;

class Post extends Component {

    constructor() {
        super();
        this.state = { reference: null,merchandOrderID: null,amount: null, orderDetails: null,merchandUrlWebsite: null,customerFirstName: null,
            customerLastName: null,customerAddress: null,customerMobileNumber: null,customerEmail: null }
    }
   componentDidMount() {
    axios.get('http://localhost:8060/merchand/api/v1/order/reference/'+reference)
        .then(response => this.setState({ reference: response.data.reference,
          merchandOrderID: response.data.merchandOrderID, amount: response.data.amount, orderDetails: response.data.orderDetails,
          merchandUrlWebsite: response.data.merchandUrlWebsite,customerFirstName: response.data.customer.firstName,
          customerLastName: response.data.customer.lastName,customerAddress: response.data.customerAddress,
          customerMobileNumber: response.data.customerMobileNumber,customerEmail: response.data.customerEmail
        }));
  }

  render() {
    return (
      <Fragment>
        { this.state.amount && <div className="position-relative">
          <Alert color="secondary">
            <div className="container">
              <strong>www.para-casa.com</strong>
              <img src={logo_marchand} alt="logo" className="float-right" height="24"/>

            </div>
          </Alert>
          <article className="pt-2 text-secondary text-justify" style={{ fontSize: '0.9rem', whiteSpace: 'pre-line' }}>
            <Table>
              <tbody>
              <tr>
                <th>N° de Commande</th>
                <td>{this.state.merchandOrderID}</td>
              </tr>
              <tr>
                <th>Détails</th>
                <td>{this.state.orderDetails}</td>
              </tr>
              <tr>
                <th>Montant</th>
                <td>{this.state.amount}</td>
              </tr>
              </tbody>
            </Table>
            <div className="title">
            <srong>INFORMATIONS DU CLIENT</srong>
            </div>
            <Table>
              <tbody>
              <tr>
                <th>Nom et prénom</th>
                <td>{this.state.customerLastName+" "+this.state.customerFirstName}</td>
              </tr>
              <tr>
                <th>Adresse</th>
                <td>222,Boulesdsd sdsdsd Casablanca</td>
              </tr>
              <tr>
                <th>Téléphone</th>
                <td>0653343434</td>
              </tr>
              <tr>
                <th>E-mail</th>
                <td>Larry@ssd.com</td>
              </tr>
              </tbody>
            </Table>
          </article>
        </div> }
      </Fragment>
    );
  }

}

export default Post;
