import React from 'react';
import {default as store} from '../store/GuestStore'
import axios from "axios";
class GuestList extends React.Component{


    constructor(props) {
        super(props);
        this.state = {guests : []};
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

    render() {
        return(
            <select className={"custom_select"} >
                {this.state.guests.map(guest=> <option>{guest.guestId}, {guest.bornAt}, {guest.guestName}</option>)}
                )}
            </select>
        );
    }
}

export default GuestList;
