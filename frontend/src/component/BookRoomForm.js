import React from "react";
import * as actions from '../action/HotelActions';
import ErrorMessageWell from "./ErrorMessageWell";

class BookRoomForm extends React.Component {


    constructor(props, context) {
        super(props, context);
        this.state={
           guest:0,
            arrival:0,
            leave:0
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
                <ErrorMessageWell/>
                <label htmlFor={"guest"} >Number of guests</label>
                <input type={"number"} id={"guest"} name={"guest"} value={this.state.guest} onChange={this.formOnChange}/>
                <br/>
                <label>Arrive date</label>
                <input type={"date"} id={"arrival"} name={"arrival"}  value={this.state.arrival} onChange={this.formOnChange}/>
                <br/>
                <label>Leave date</label>
                <input type={"date"} id={"leave"} name={"leave"}  value={this.state.leave} onChange={this.formOnChange}/>
                <button onClick={()=> actions.bookRoom(this.state)}>Submit</button>
            </div>
        );
    }
}
export default BookRoomForm
