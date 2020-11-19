import axios from 'axios';
import dispatcher from '../dispatcher/Dispatcher';
import * as actionConstants from '../dispatcher/ComplexNumberActionConstants'


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


    axios.put('/hotel/book-out',


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



///visszaaadja az összes terméket
export const listAllProducts=()=>{
    axios.get('/hotel/allproduct').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}

//visszaadja az összes guestet
export const getAllGuest=()=>{
    axios.get('/hotel/getallguest').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}


///miután lekértük az összes guestet és az összes terméket, akkor lehet a listázott termnékekből vásárolni
export const buy=({count,guestId,productId})=>{
    axios.post('/hotel/buy',{
        count:count,
        guestId:guestId,
        productId:productId
        }

        )


}


export const recordComplexNumber = ({real,imag}) =>{
    axios.post('/hotel/buy',
        {
            real : real,
            imag : imag
        })
        .then(() => {
            fetchComplexNumbers();
            dispatcher.dispatch({action : actionConstants.clearError});
        })
        .catch((err) => {
            dispatcher.dispatch({
                action : actionConstants.showError,
                payload: `${err.response.status}-${err.response.statusText}: ${err.response.data.message}`
            });
            fetchComplexNumbers();
        });
}

export const fetchComplexNumbers = () =>{

    axios.get('/complex-number/').then((resp)=>{
        dispatcher.dispatch({
            action : actionConstants.refresh,
            payload: resp.data
        });
    })
}
