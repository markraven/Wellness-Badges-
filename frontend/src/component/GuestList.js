import React from 'react';
import {default as store} from '../store/GuestStore'
import GuestListItem from "./GuestListItem";
import * as actions from '../action/HotelActions';
class GuestList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {guests : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({guests : store._complexNumbers});
    }

    render() {
        return(
            <select onClick={()=> actions.getAllGuest()} >
                {this.state.guests.map(({id,bornAt,name}, index)=>{
                    return(
                        <GuestListItem key={index} id={id} bornAt={bornAt} name={name} />
                    );
                })}
            </select>
        );
    }
}

export default GuestList;
