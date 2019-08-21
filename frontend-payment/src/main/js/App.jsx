import React, { Component, Fragment } from 'react';
import { Container, Row, Col } from 'reactstrap';
import PropTypes from 'prop-types';
import axios from "axios";
import Post from './components/Post';
import Header from './components/Header';
import PendingPayment from './components/PendingPayment';
import Footer from "./components/Footer";

class App extends Component {
	static get propTypes() {
		return {
			reference: PropTypes.string,
		};
	}
	constructor(props) {
		super(props);
		this.state = {reference: props.reference, merchantOrderID: null,amount: null, orderDetails: null,
			merchantUrlWebsite: null,customerFirstName: null,customerLastName: null,customerAddress: null,
			customerPhoneNumber: null,customerEmail: null,logo: null,walletName:null, walletLogo:null, orderStatus:null,retourUrl:null };
	}
	componentDidMount() {
		axios.get('http://localhost:8060/merchant/api/v1/order/reference/'+this.state.reference)
			.then(response => this.setState({
				merchantOrderID: response.data.merchantOrderID, amount: response.data.displayedAmount, orderDetails: response.data.orderDetails,
				merchantUrlWebsite: response.data.merchant.urlWebsite,merchantLogo: response.data.merchant.logo,customerFirstName: response.data.customer.firstName,
				customerLastName: response.data.customer.lastName,customerAddress: response.data.customer.address,
				customerPhoneNumber: response.data.customer.phoneNumber,customerEmail: response.data.customer.email,
				walletName: response.data.merchant.wallet.walletName, walletLogo:response.data.merchant.wallet.logo,
				orderStatus: response.data.orderStatus,retourUrl:response.data.merchant.merchantResponseURL
			}));
	}

	render() {
		return this.state.amount
			? <Fragment>
				<Header/>
				<main className="my-5 py-5">
					<Container className="px-0">
						<Row noGutters className="pt-2 pt-md-5 w-100 px-4 px-xl-0 position-relative">
							<Col xs={{ order: 2 }} md={{ size: 5, order: 1 }} tag="aside" className="pb-5 mb-5 pb-md-0 mb-md-0 mx-auto mx-md-0">
                <PendingPayment reference={this.state.reference}
																walletName={this.state.walletName}
																walletLogo={this.state.walletLogo}
																orderStatus={this.state.orderStatus}
																retourUrl={this.state.retourUrl+"&REFERENCE_ID="+this.state.reference+"&ORDER_ID="+this.state.merchantOrderID}
								/>
							</Col>
							<Col xs={{ order: 1 }} md={{ size: 6, offset: 1 }} tag="section" className="py-5 mb-5 py-md-0 mb-md-0">
								<Post reference={this.state.reference}
											merchantOrderID={this.state.merchantOrderID}
											amount={this.state.amount}
											orderDetails={this.state.orderDetails}
											merchantUrlWebsite={this.state.merchantUrlWebsite}
											merchantLogo={this.state.merchantLogo}
											customerFirstName={this.state.customerFirstName}
											customerLastName={this.state.customerLastName}
											customerAddress={this.state.customerAddress}
											customerPhoneNumber={this.state.customerPhoneNumber}
											customerEmail={this.state.customerEmail}

								/>
							</Col>
						</Row>
					</Container>
				</main>
				<Footer/>
			</Fragment>
			: null;
	}
}
export default App;
