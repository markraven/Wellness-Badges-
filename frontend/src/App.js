import React from 'react';
import './App.scss';
import AddNewProductForm from "./component/AddNewProductForm";
import BookRoomForm from "./component/BookRoomForm";
import CheckInForm from './component/CheckInForm';
import BuyForm from "./component/BuyForm";
import ProductList from "./component/ProductList";
import Footer from "./component/Footer";

function App() {
  return (
    <div className={["App container"]}>
      <div className={"row"}>
        <div className={"col-md-6"}>
          <div className={"card text-center bg-warning h-100"}>
            <div className={"card-header"}>
              <h3>Add new product or service to the Hotel services</h3>
            </div>
            <div className={"card-body"}>
              <AddNewProductForm/>
            </div>
            <div className={["card-footer text-muted"]}></div>
          </div>
        </div>

        <div className={"col-md-6"}>
          <div className={"card text-center bg-warning h-100 "}>
              <div className={"card-header"}>
                <h3>Booking a room before Check-in</h3>
              </div>
              <div className={"card-body"}>
              <BookRoomForm/>
              </div>
              <div className={["card-footer text-muted"]}></div>
          </div>
        </div>
      </div>

      <div className={"row"}>
        <div className={"col-md-6"}>
        <div className={"card text-center bg-success h-100 "}>
              <div className={"card-header"}>
                <h3>Checking in</h3>
              </div>
              <div className={"card-body"}>
              <CheckInForm/>
              </div>
              <div className={["card-footer text-muted"]}></div>
          </div>
        </div>
      </div>

        <div className={"row"}>
            <div className={"custom_col"}>
                <h1 className={"custom_h1"}>Select a products which yo want to buy </h1>
                <ProductList/>
            </div>
        </div>
        <Footer/>
    </div>
  );
}

export default App;
