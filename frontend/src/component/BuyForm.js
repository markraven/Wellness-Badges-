import React from "react";
import * as actions from '../action/HotelActions';
import ErrorMessageWell from "./ErrorMessageWell";
import GuestList from "./GuestList";
import ProductList from "./ProductList";

class BuyForm extends React.Component{

    constructor(props, context) {
        super(props, context);
        this.state={
            amount:0,
            guestId:0,
            productId:0
        }

        this.formOnChange = this.formOnChange.bind(this);
    }
    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }
    render() {
        return(
            <section className={"container_custom"} >
                <div className={"custom_col"}>
                    <div className={"custom_column"}>
                        <h1 className={"custom_h1"}>Select a guest</h1>
                        <GuestList />
                    </div>

                </div>
                <div className={"custom_col"}>
                    <h1 className={"custom_h1"}>Select a products which yo want to buy </h1>
                    <ProductList/>
                </div>
                <div className={"custom_col"}>
                    <form>
                        <ErrorMessageWell/>
                        <button onClick={()=> actions.buy(this.state)}>Submit</button>
                    </form>

                </div>


            </section>
        );
    }
}
export default BuyForm