import React, { Component, Fragment } from 'react';

import {
  Button, Alert, Card, CardImg, CardBody,
  CardTitle, CardText, Popover, PopoverHeader, PopoverBody, CardLink
} from 'reactstrap';
import { QRCode } from "react-qr-svg";
import PropTypes from "prop-types";
import axios from "axios";

class PendingPayment extends Component {

    static get propTypes() {
        return {
            reference: PropTypes.string,
            walletName:PropTypes.string,
            walletLogo:PropTypes.string,
            orderStatus:PropTypes.string,
            retourUrl:PropTypes.string
        };
    }
    constructor(props) {
        super(props);
        this.toggle = this.toggle.bind(this);
        this.state = {
            popoverOpen: false,
          orderStatus:this.props.orderStatus
        }
    }

  componentDidMount() {
    this.timer = setInterval(()=> this.verifyayment(), 2000);
  }
  componentWillUnmount() {
    clearInterval(this.timer);
    this.timer = null; // here...
  }

  verifyayment() {
    if (this.state.orderStatus === 'ENATTENTE'){
      axios.get('http://localhost:8060/merchant/api/v1/order/reference/'+this.props.reference)
        .then(response => this.setState({
          orderStatus: response.data.orderStatus
        }));
    }

  }
    toggle() {
        navigator.clipboard.writeText(this.props.reference);
        this.setState({
            popoverOpen: !this.state.popoverOpen
        });
    }

    render() {
      console.log(this.state.orderStatus);
        if (this.state.orderStatus === 'ENATTENTE') {
            return (
              <Fragment>
                  <Alert color="secondary">
                      <div className="container">
                          <strong>Payer avec votre compte {this.props.walletName}</strong>
                          <img src={this.props.walletLogo} alt="logo" className="float-right" height="24"/>
                      </div>
                  </Alert>
                  <Card>
                      <CardTitle className="align-items-center d-flex justify-content-center h6 pt-2 pl-2">Scanner le
                          QRCode avec votre Application SoPay</CardTitle>
                      <QRCode className="mx-auto"
                              bgColor="#FFFFFF"
                              fgColor="#000000"
                              level="Q"
                              style={{ width: 256 }}
                              value={this.props.reference}
                      />                    <CardBody className="text-center">
                      <CardTitle
                        className="align-items-center d-flex justify-content-center h6 font-weight-bold text-secondary">Cliquer
                          pour copier la référence</CardTitle>
                      <Button id="Popover1" className="font-weight-bold" type="button" onClick={this.toggle} color="primary">
                          Copier
                      </Button>
                      <Popover placement="top" isOpen={this.state.popoverOpen} target="Popover1" toggle={this.toggle}
                      >
                          <PopoverHeader style={{backgroundColor:'#000',color:'#fff'}} >Référence copiée</PopoverHeader>
                      </Popover>
                      <CardText className="align-items-center d-flex justify-content-center text-secondary mb-4"
                                style={{fontSize: '0.75rem'}}>
                          {this.props.reference}
                      </CardText>
                    <CardLink>
                      <a href={this.props.retourUrl+"&RESPONSE_CODE=1028"}>Revenir au site marchand </a>
                    </CardLink>
                  </CardBody>
                  </Card>
              </Fragment>
            );
        } else if (this.state.orderStatus === 'CAPTURED'){
            return (
              <Fragment>
                  <Alert color="success">
                      <div className="container">
                          <strong>Commande payée gràce à {this.props.walletName}</strong>
                          <img src={this.props.walletLogo} alt="logo" className="float-right" height="24"/>
                      </div>
                  </Alert>
                  <Card>
                      <CardTitle color="success" className="align-items-center d-flex justify-content-center h6 pt-2 pl-2">
                        Transaction effectué avec succès</CardTitle>
                   <CardBody className="text-center">
                     <CardLink>
                       <a href={this.props.retourUrl}>Revenir au site marchand </a>
                     </CardLink>
                  </CardBody>
                  </Card>
              </Fragment>
            );
        }

    }
}
export default PendingPayment;
