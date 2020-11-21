import React from 'react';
import {default as store} from '../store/ProductStore'
import axios from "axios";
import dispatcher from "../dispatcher/Dispatcher";
import * as actionConstants from "../dispatcher/ComplexNumberActionConstants";

class ProductList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {products : []};
        this._updateState = this._updateState.bind(this);
    }

    componentDidMount() {
        axios.get('/hotel/products').then((resp)=>{
            dispatcher.dispatch({
                action : actionConstants.refresh,
                payload: resp.data
            });
        })
    }

    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({product : store._productstore});
    }

    render() {
        return(
            <ul>
                {this.state.products.map(product => <li>{product.id} {product.name} {product.price}</li>)}
            </ul>
        );
    }
}

export default ProductList;
