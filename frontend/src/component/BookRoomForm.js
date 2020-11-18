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
                <form>
                    <ErrorMessageWell/>
                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"guest"} >Number of guests</label>
                        <input class={"form-control"} type={"number"} id={"guest"} name={"guest"} min={"1"} max={"4"} value={this.state.guest} onChange={this.formOnChange} />
                    </div>
                    
                    <div className={"form-group form-control-md"}>
                        <label>Date of arriving</label>
                        <input class={"form-control"} type={"date"} id={"arrival"} name={"arrival"}  value={this.state.arrival} onChange={this.formOnChange}/>
                    </div>
                    
                    <div className={"form-group form-control-md"}>
                        <label>Date of leaving</label>
                        <input class={"form-control"} type={"date"} id={"leave"} name={"leave"}  value={this.state.leave} onChange={this.formOnChange}/>
                    </div>

                    <button className={["btn btn-primary"]} onClick={()=> actions.bookRoom(this.state)}>Submit</button>
                </form>
            </div>
        );
    }
}
export default BookRoomForm
