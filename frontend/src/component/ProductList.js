import React from 'react';
import {default as store} from '../store/ProductStore'
import ProductListItem from "./ProductListItem";
import * as actions from "../action/HotelActions";

class ProductList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {product : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({product : store._complexNumbers});
    }

    render() {
        return(
            <section>

                {this.state.product.map(({id,name,price}, index)=>{
                    return(
                        <ProductListItem key={index} id={id} name={name} price={price} />
                    );
                })}
                <button onClick={()=> actions.listAllProducts()}>Get All Products</button>
            </section>
        );
    }
}

export default ProductList;
