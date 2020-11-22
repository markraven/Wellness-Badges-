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
    handleChange = (ev: SyntheticMouseEvent<>) => {
        this.props.onChange({event: ev, index: this.props.index})
    }

    componentDidMount() {
        axios.get('/hotel/products').then(res=>
           this.setState({
               products:res.data
           })
        );

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
                {this.state.products.map(product =>
                    <li onClick={this.handleChange}>{product.id} {product.name} {product.price}
                        <div>
                            <button type="button" className="btn btn-success">Success</button>
                            <button type="button" className="btn btn-warning">Warning</button>
                        </div>
                    </li>)}
            </ul>
        );
    }
}

export default ProductList;
