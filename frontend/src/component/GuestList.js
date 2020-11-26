import React from 'react';
import {default as store} from '../store/GuestStore'
import axios from "axios";
class GuestList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            guests : [],
            selected:""
        };
        this._updateState = this._updateState.bind(this);
    }

    componentDidMount() {
            axios.get('/hotel/guests').then(res=>
            this.setState({
                guests:res.data
            }))
    }

    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({guests : store._gueststore});
    }

    getSelected(e, id){
        e.preventDefault();
        this.state.selected = "";
        this.setState({
            selected: id
        })
    }

    render() {
        return(
            <select>
                <option>SELECT</option>
                {this.state.guests.map(guest=> 
                <option onClick={(e) => {this.getSelected(e,guest.guestId)}} id={"selected"} name={"selected"} value={guest.id}>{guest.bornAt}, {guest.guestName}</option>
                )}
            </select>
        );
    }
}

export default GuestList;
