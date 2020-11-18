import React from 'react';
import './App.scss';
import AddNewProductForm from "./component/AddNewProductForm";
import BookRoomForm from "./component/BookRoomForm";
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
    </div>
  );
}

export default App;
