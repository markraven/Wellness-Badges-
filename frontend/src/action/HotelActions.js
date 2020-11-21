import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/ComplexNumberActionConstants'

///buy folytatása
///miután lekértük az összes guestet és az összes terméket, akkor lehet a listázott termnékekből vásárolni
export const buy=({count,guestId,productId})=>{
    axios.post('/hotel/buy',{
        count:count,
        guestId:guestId,
        productId:productId
        }
        );
}

export const addProduct=({minAge,price,productName,restDesc})=>{
axios.put('/hotel/add-product-service',
    {
        minAge:minAge,
        price:price,
        productName:productName,
        restDesc:restDesc
    }).catch((err)=>{
        dispatcher.dispatch({
        action : actionConstants.showError,
        payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
    });
})
}

export const bookRoom=({arrival,guest,leave})=>{
    axios.put('/hotel/book-room',
        {
            arrival: arrival,
            guests: guest,
            leave: leave
        }
        ).catch((err) => {
        dispatcher.dispatch({
            action : actionConstants.showError,
            payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
        });
    });
}

export const checkIn = ({arrival, leave, roomNumber}) =>{
    axios.post('/hotel/check-in',
    {
        arrival: arrival,
        leave: leave,
        roomNumber: roomNumber
    }
    ).catch((err) => {
        dispatcher.dispatch(
            {
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
    });
}
