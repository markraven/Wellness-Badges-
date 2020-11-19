import React from "react";
import * as actions from '../action/HotelActions';
import ErrorMessageWell from "./ErrorMessageWell";


class CheckInForm extends React.Component{
    constructor(props, context) {
        super(props, context);
        this.state={
            guestsName: [],
            guestsBirth: [],
            arrival:0,
            leave:0,
            roomNumber:0
        }

        this.formOnChange = this.formOnChange.bind(this);
    }
    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }

    addGuest(e){
        e.preventDefault();
        const newItem = this.newItem.value;
        const newBirth = this.newBirth.value;

        this.setState({
            guestsName: [...this.state.guestsName, newItem]
        })
        this.setState({
            guestsBirth: [...this.state.guestsBirth, newBirth]
        })

        this.addForm.reset();
    }

    render() {
        const {guestsName} = this.state;
        const {guestsBirth} = this.state;
        return(
            <div>
                <form ref={(input) => {this.addForm = input}} onSubmit={(e) => {this.addGuest(e)}}>
                    <div className={"form-group form-control-md"}>
                        <h2>Guest</h2>
                        <label htmlFor={"guestBirth"}>Date of birth</label>
                        <input ref={(inputBirth) => {this.newItem = inputBirth}} className={"form-control"} type={"number"} id={"guestBirth"} name={"guestBirth"} required min={1900} max={new Date().getFullYear()}/>

                        <label htmlFor={"guestName"}>Name</label>
                        <input ref={(inputName) => {this.newBirth = inputName}} className={"form-control"} type={"text"} id={"guestName"} name={"guestName"}  required/>
                    </div>
                    <button type="submit" className={["btn btn-secondary"]} >Add new guest</button>
                </form>
                <div>
                    <table className="table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Date of birth</th>
                                <th>Name</th>
                            </tr>
                        </thead>
                        <tbody>
                        <tr>
                                <th scope="row"></th>
                            {
                                guestsName.map(item => {
                                    return(
                                            <td key={item}>{item}</td>
                                    )
                                })
                            }
                            {
                            guestsBirth.map(item =>{
                                return(
                                    <td key={item}>{item}</td>
                                )
                                })
                            }
                            </tr>
                            </tbody>
                        </table>
                    </div>
                <form>
                    <ErrorMessageWell/>
                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"arrival"} >Arrival date</label>
                        <input className={"form-control"} type={"date"} id={"arrival"} name={"arrival"} value={this.state.arrivalDate} onChange={this.formOnChange} />
                    </div>

                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"leave"} >Leaving date</label>
                        <input className={"form-control"} type={"date"} id={"leave"} name={"leave"} value={this.state.arrivalDate} onChange={this.formOnChange} />
                    </div>

                    <label htmlFor={"RoomNumber"}>Name</label>
                    <input className={"form-control"} type={"nubmer"} id={"RoomNumber"} name={"RoomNumber"} />
                    
                    <button className={["btn btn-primary"]} onClick={()=> actions.checkIn(this.state.arrival, this.state.leave, this.state.roomNumber)}>Submit</button>
                </form>
            </div>
        );
    }

}

export default CheckInForm