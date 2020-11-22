import React from 'react';
import {default as store} from '../store/ProductStore'
import axios from "axios";
import { ListViewComponent } from '@syncfusion/ej2-react-lists';
import dispatcher from "../dispatcher/Dispatcher";
import * as actionConstants from "../dispatcher/ComplexNumberActionConstants";

class ProductList extends React.Component{



    constructor(props) {
        super(props);
        this.listobj=null;
        this.state = {products : [], selectedItemsValue: []};
        this.fields = { text: "name", tooltip: "Name", id: "id"  };

    }


    getSelectedItems() {
        if (this.listobj) {
            this.setState({
                selectedItemsValue: this.listobj.getSelectedItems().data
            });
        }
    }

    componentDidMount() {
        axios.get('/hotel/products').then(res=>
           this.setState({
               products:res.data
           })
        );

    }

    //{product.id} {product.name} {product.price}
    render() {
        return (

            <div>

                {this.state.products.map((product,i,arr) =>

                    {if(arr.length-1===i){
                        return( <ListViewComponent fields={this.fields} key={this.state.products[i].id} dataSource={this.state.products} id={"list"} showCheckBox={true} ref={scope=>{this.listobj=scope;}}>
                        </ListViewComponent>)
                        }

                    }
                    )
                }

            <button id="btn" onClick={this.getSelectedItems.bind(this)}>
                Get Selected Items
            </button>
            <div>
                <table>
                    <tbody>
                    <tr>
                        <th>Id</th>
                        <th>Text</th>
                    </tr>

                    {this.state.selectedItemsValue.map((item, index) => {
                        return (<tr key={index}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                        </tr>);
                    })}
                    </tbody>
                </table>
            </div>
        </div>);

    }
}

export default ProductList;
