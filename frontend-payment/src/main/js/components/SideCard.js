import React, { Fragment } from 'react';

import {
    Button, Alert, Card, CardImg, CardBody,
    CardTitle, CardSubtitle, CardText, NavbarBrand
} from 'reactstrap';
import sopay_logo from "../img/sopay_logo.png";
import qr_code from "../img/qr_code.png";

const CRCODE = 'https://i.imgur.com/CaKdFMq.jpg';
const reference = document.getElementById("reference").value;

const SideCard = () => (
  <Fragment>
      <Alert color="secondary">
          <div className="container">
          <strong>Payer avec votre compte SOPAY</strong>
          <img src={sopay_logo} alt="logo" className="float-right" height="24"/>
          </div>
      </Alert>
    <Card>
        <CardTitle className="align-items-center d-flex justify-content-center h6 pt-2 pl-2">Scanner le QRCode avec votre Application SoPay</CardTitle>
        <CardImg className="mx-auto" src={qr_code} alt="qr code" style={{width: '60%'}} />
      <CardBody className="text-center">
          <CardTitle className="align-items-center d-flex justify-content-center h6 font-weight-bold text-secondary">Cliquer pour copier la référence</CardTitle>
          <Button color="primary" className="font-weight-bold">copier</Button>
          <CardText className="align-items-center d-flex justify-content-center text-secondary mb-4" style={{ fontSize: '0.75rem' }}>
              {reference}
          </CardText>
      </CardBody>
    </Card>
  </Fragment>
);

export default SideCard;
