import {EventEmitter} from 'events'
import dispatcher from "../dispatcher/Dispatcher";
import {refresh} from '../dispatcher/ComplexNumberActionConstants';

class ProductStore extends EventEmitter{

    _productstore = [];

    emitChange(){
        this.emit('Change');
    }

    addChangeListener(callback){
        this.addListener('Change',callback);
    }

    removeChangeListener(callback){
        this.removeListener('Change',callback);
    }
}

const store = new ProductStore();
export default store;

dispatcher.register(({action,payload})=>{
    if(action !== refresh ) return;
    store._productstore = payload;
    store.emitChange();
})
