import React, { Component, Fragment } from 'react';

import {Alert, Badge, NavbarBrand, Table} from 'reactstrap';
import PropTypes from 'prop-types';

class Post extends Component {
  static get propTypes() {
    return {
      reference: PropTypes.string,
      merchantUrlWebsite:PropTypes.string,
      merchantLogo:PropTypes.string,
      merchantOrderID:PropTypes.string,
      orderDetails:PropTypes.string,
      amount:PropTypes.string,
      customerLastName:PropTypes.string,
      customerFirstName:PropTypes.string,
      customerAddress:PropTypes.string,
      customerPhoneNumber:PropTypes.string,
      customerEmail:PropTypes.string
    };
  }
    constructor(props) {
      super(props);
    }

  render() {
    return (
      <Fragment>
        <div className="position-relative">
          <Alert color="secondary">
            <div className="container">
              <strong>{this.props.merchantUrlWebsite}</strong>
              <img src={this.props.merchantLogo} alt="logo" className="float-right" height="24"/>

            </div>
          </Alert>
          <article className="pt-2 text-secondary text-justify" style={{ fontSize: '0.9rem', whiteSpace: 'pre-line' }}>
            <Table>
              <tbody>
              <tr>
                <th>N° de Commande</th>
                <td>{this.props.merchantOrderID}</td>
              </tr>
              <tr>
                <th>Détails</th>
                <td>{this.props.orderDetails}</td>
              </tr>
              <tr>
                <th>Montant</th>
                <td>{this.props.amount+" DH"}</td>
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
                <td>{this.props.customerLastName+" "+this.props.customerFirstName}</td>
              </tr>
              <tr>
                <th>Adresse</th>
                <td>{this.props.customerAddress}</td>
              </tr>
              <tr>
                <th>Téléphone</th>
                <td>{this.props.customerPhoneNumber}</td>
              </tr>
              <tr>
                <th>E-mail</th>
                <td>{this.props.customerEmail}</td>
              </tr>
              </tbody>
            </Table>
          </article>
        </div>
      </Fragment>
    );
  }

}

export default Post;
