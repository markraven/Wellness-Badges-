import React from "react";
import * as actions from '../action/HotelActions';
import ErrorMessageWell from "./ErrorMessageWell";
class AddNewProductForm extends React.Component {
    constructor(props, context) {
        super(props, context);
        this.state={
            minAge:0,
            productName:"",
            restDesc:"",
            price:0
        }
        this.formOnChange = this.formOnChange.bind(this);
    }
    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }
    render() {
        return(
            <div>
                <form>
                    <ErrorMessageWell/>
                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"minAge"} >Minimum age</label>
                        <input class={"form-control"} type={"number"} id={"minAge"} name={"minAge"} value={this.state.minAge} onChange={this.formOnChange}/>
                    </div>
                    
                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"productName"}>The name of the product</label>
                        <input class={"form-control"} type={"text"} id={"productName"} name={"productName"} value={this.state.productName} onChange={this.formOnChange}/>
                    </div>
                    
                    <div className={"form-group form-control-md"}>
                        <label>Description</label>
                        <input class={"form-control"} type={"text"} id={"restDesc"} name={"restDesc"}  value={this.state.restDesc} onChange={this.formOnChange}/>
                    </div>
                    
                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"price"} >Product Price</label>
                        <input class={"form-control"} type={"number"} id={"price"} name={"price"} value={this.state.price} onChange={this.formOnChange}/>
                    </div>
                    
                    <button className={["btn btn-primary"]} onClick={()=> actions.addProduct(this.state)}>Submit</button>
                </form>
            </div>
        );
    }
}
export  default AddNewProductForm