import React, { Component, Fragment } from 'react';

import {
    Button, Alert, Card, CardImg, CardBody,
    CardTitle, CardText, Popover, PopoverHeader, PopoverBody
} from 'reactstrap';
import qr_code from "../img/qr_code.png";
import { QRCode } from "react-qr-svg";
import PropTypes from "prop-types";
const CRCODE = 'https://i.imgur.com/CaKdFMq.jpg';

class PendingPayment extends Component {
    static get propTypes() {
        return {
            reference: PropTypes.string,
            walletName:PropTypes.string,
            walletLogo:PropTypes.string,
            orderStatus:PropTypes.string
        };
    }
    constructor(props) {
        super(props);
        this.toggle = this.toggle.bind(this);
        this.state = {
            popoverOpen: false
        }
    }
    toggle() {
        navigator.clipboard.writeText(this.props.reference);
        this.setState({
            popoverOpen: !this.state.popoverOpen
        });
    }

    render() {
      console.log(this.props.orderStatus);
        if (this.props.orderStatus === 'ENATTENTE') {
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
                  </CardBody>
                  </Card>
              </Fragment>
            );
        } else{
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
                   <CardBody className="text-center">
                      <CardTitle
                        className="align-items-center d-flex justify-content-center h6 font-weight-bold text-secondary">Cliquer
                          pour copier la référence</CardTitle>
                    <CardText className="align-items-center d-flex justify-content-center text-secondary mb-4"
                                style={{fontSize: '0.75rem'}}>
                          {this.props.reference}
                      </CardText>
                  </CardBody>
                  </Card>
              </Fragment>
            );
        }

    }
}
export default PendingPayment;
