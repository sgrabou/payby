import React, { Component, Fragment } from 'react';

import {
    Button, Alert, Card, CardImg, CardBody,
    CardTitle, CardText, Popover, PopoverHeader, PopoverBody
} from 'reactstrap';
import sopay_logo from "../img/sopay_logo.png";
import qr_code from "../img/qr_code.png";

const CRCODE = 'https://i.imgur.com/CaKdFMq.jpg';

class SideCard extends Component {

    constructor(props) {
        super(props);
        this.toggle = this.toggle.bind(this);
        this.state = {
            popoverOpen: false,
            reference: this.props.reference,
            walletName: this.props.walletName,
            walletLogo: this.props.walletLogo
        }
    }
    toggle() {
        navigator.clipboard.writeText(this.state.reference);
        this.setState({
            popoverOpen: !this.state.popoverOpen
        });
    }

    render() {
        return (
            <Fragment>
                <Alert color="secondary">
                    <div className="container">
                        <strong>Payer avec votre compte {this.state.walletName}</strong>
                        <img src={this.state.walletLogo} alt="logo" className="float-right" height="24"/>
                    </div>
                </Alert>
                <Card>
                    <CardTitle className="align-items-center d-flex justify-content-center h6 pt-2 pl-2">Scanner le
                        QRCode avec votre Application SoPay</CardTitle>
                    <CardImg className="mx-auto" src={qr_code} alt="qr code" style={{width: '60%'}}/>
                    <CardBody className="text-center">
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
                            {this.state.reference}
                        </CardText>
                    </CardBody>
                </Card>
            </Fragment>
        );
    }
}
export default SideCard;
