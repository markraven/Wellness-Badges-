import React from "react";
import * as actions from '../action/HotelActions';
import ErrorMessageWell from "./ErrorMessageWell";
import axios from "axios";
import dispatcher from "../dispatcher/Dispatcher";
import * as actionConstants from "../dispatcher/ComplexNumberActionConstants";


class CheckInForm extends React.Component{
    constructor(props, context) {
        super(props, context);
        this.state={
            guests:{
                bornAt:[],
                name:[]
            },
            arrival:0,
            leave:0,
            roomNumber:"",
        }

        this.formOnChange = this.formOnChange.bind(this);
    }
    formOnChange(event){
        const {name,value} = event.target;
        this.setState({[name] : value});
    }




    addGuest(e){
        e.preventDefault();

        this.setState({
            guests: {
                bornAt:[...this.state.guests.bornAt, this.newBirth.value],
                name:[...this.state.guests.name, this.newItem.value]
            }
        })

        this.addForm.reset();
    }


    render() {
        return(
            console.log(this.state),
            <div>
                <form ref={(input) => {this.addForm = input}} onSubmit={(e) => {this.addGuest(e)}}>
                    <div className={"form-group form-control-md"}>
                        <h2>Guest</h2>
                        <label htmlFor={"guestBirth"}>Date of birth</label>
                        <input ref={(inputBirth) => {this.newBirth = inputBirth}} className={"form-control"} type={"date"} id={"bornAt"} name={"bornAt"} required min={1900} max={new Date().getFullYear()}/>

                        <label htmlFor={"guestName"}>Name</label>
                        <input ref={(inputName) => {this.newItem = inputName}} className={"form-control"} type={"text"} id={"name"} name={"name"}  required/>
                    </div>
                    <button type="submit" className={["btn btn-secondary"]} >Add new guest</button>
                </form>
                <div>
                    <table className="table">
                        <thead>
                        <tr>
                            <th>Date of birth</th>
                            <th>Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.guests.bornAt.map((item,maini) =>{return(
                            <tr>
                                <td key={item}>{item}</td>
                                {this.state.guests.name.map((item2, i,a) => {
                                if (maini === i) {
                                    return (<td key={a[i]}> {item2}</td>)
                                }})}
                            </tr>
                        )})}
                        </tbody>
                    </table>
                    </div>
                <form>
                    <ErrorMessageWell/>
                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"arrival"} >Arrival date</label>
                        <input className={"form-control"} type={"date"} id={"arrival"} name={"arrival"} value={this.state.arrival} onChange={this.formOnChange} />
                    </div>

                    <div className={"form-group form-control-md"}>
                        <label htmlFor={"leave"} >Leaving date</label>
                        <input className={"form-control"} type={"date"} id={"leave"} name={"leave"} value={this.state.leave} onChange={this.formOnChange} />
                    </div>

                    <label htmlFor={"RoomNumber"}>Room number</label>
                    <input className={"form-control"} type={"text"} id={"roomNumber"} name={"roomNumber"} value={this.state.roomNumber} onChange={this.formOnChange}/>
                    
                    <button className={["btn btn-primary"]}
                            onClick={()=> actions.checkIn(this.state
                                                        )}>Submit</button>
                </form>
            </div>
        );
    }

}

export default CheckInForm
