import React, { Component, Fragment } from 'react';

import {Alert, Badge, NavbarBrand, Table} from 'reactstrap';
import logo from "../img/logo.png";
import sopay_logo from "../img/sopay_logo.png";

class Post extends Component {

    constructor(props) {
        super(props);
        this.state = { reference: this.props.reference, merchandOrderID: this.props.merchandOrderID,amount: this.props.amount, orderDetails: this.props.orderDetails,
            merchandUrlWebsite: this.props.merchandUrlWebsite,customerFirstName: this.props.customerFirstName, customerLastName: this.props.customerLastName,
            customerAddress: this.props.customerAddress, customerMobileNumber: this.props.customerMobileNumber,customerEmail: this.props.customerEmail,
            merchandLogo: this.props.merchandLogo }

    }

  render() {
    return (
      <Fragment>
        { this.state.amount && <div className="position-relative">
          <Alert color="secondary">
            <div className="container">
              <strong>{this.state.merchandUrlWebsite}</strong>
              <img src={this.state.merchandLogo} alt="logo" className="float-right" height="24"/>

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
                <td>{this.state.amount+" DH"}</td>
              </tr>
              </tbody>
            </Table>
            <div className="title">
            <h5>INFORMATIONS DU CLIENT</h5>
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
