import React from 'react';
import axios from "axios";



class ProductList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            products : [],
            selected:""
        };
        this.fields = { text: "name", tooltip: "Name", id: "id"  };
    }


    componentDidMount() {
        axios.get('/hotel/products').then(res=>
           this.setState({
               products:res.data
           })
        );

    }

    getSelected(e, id){
        e.preventDefault();
        this.state.selected = "";
        this.setState({
            selected: id
        })
    }

    //{product.id} {product.name} {product.price}
    render() {

        return (
            <div>
                <select>
                    <option>SELECT</option>
                    {this.state.products.map(products=> 
                    <option onClick={(e) => {this.getSelected(e,products.id)}} name={"scripts"} className={"custom_select"} id={"selected"} name={"selected"} value={products.id}> {products.name}</option>
                    )}
                </select>
            </div>
            );
    }
}

export default ProductList;
