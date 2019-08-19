import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App.jsx';
ReactDOM.render(<App reference={document.getElementById("reference").value} />, document.getElementById('app'));