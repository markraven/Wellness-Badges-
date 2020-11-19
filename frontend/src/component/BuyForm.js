import React from "react";
import * as actions from '../action/HotelActions';
import ErrorMessageWell from "./ErrorMessageWell";
import GuestList from "./GuestList";
import ProductList from "./ProductList";


class BuyForm extends React.Component{


    constructor(props, context) {
        super(props, context);
        this.state={
            count:0,
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
            <section>

                <div>
                    <GuestList/>
                </div>

                <div>
                    <ProductList/>

                </div>


                <ErrorMessageWell/>
                <label htmlFor={"guest"} >Number of guests</label>
                <input type={"number"} id={"guest"} name={"guest"} value={this.state.guest} onChange={this.formOnChange}/>
                <br/>

                <label htmlFor={"bornAt"}>Birth date</label>
                <input type={"datetime"} id={"bornAt"} name={"bornAt"} value={this.state.bornAt} onChange={this.formOnChange}/>
                <br/>
                <label>Arrive date</label>
                <input type={"datetime-local"} id={"arrival"} name={"arrival"}  value={this.state.arrival} onChange={this.formOnChange}/>
                <br/>
                <label>Leave date</label>
                <input type={"date"} id={"leave"} name={"leave"}  value={this.state.leave} onChange={this.formOnChange}/>
                <button onClick={()=> actions.bookRoom(this.state)}>Submit</button>
            </section>
        );
    }
}
export default BuyForm