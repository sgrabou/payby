import React from 'react';
import logo from '../img/logo.png';
import {
    Card, Button, CardFooter, CardBody,
    CardTitle, CardText, Container, Row, Col, Alert
} from 'reactstrap';
import SideCard from "./SideCard";
import Post from "./Post";
import sopay_logo from "../img/sopay_logo.png";

const Footer = () => (
/*<footer className="footer" style={{backgroundColor: '#CCCCCC'}}>

</footer>
 */
    <CardFooter className="text-muted">
        <div className="container">
            <img src={logo} alt="logo" height="24"/>
            <p  className="float-right">Powred by <a target="_blank" href="https://payby.ma">PayBy</a></p>
        </div>
    </CardFooter>

);

export default Footer;