import React from 'react';
import './App.scss';
import AddNewProductForm from "./component/AddNewProductForm";
import BookRoomForm from "./component/BookRoomForm";
function App() {
  return (
    <div className={["App","container"]}>
        <div className={"row"}>
            <div className={"col-md-3"}></div>
            <div className={"col-md-6"}>
                <AddNewProductForm/>
            </div>

        </div>
        <div className={"col"}>
            <BookRoomForm/>
        </div>
    </div>
  );
}

export default App;
