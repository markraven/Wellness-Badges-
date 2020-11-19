import React from 'react';

function ProductListItem({id,name,price}){
    return (
        <div>({id}, {name}, {price})</div>
    );
}

export default ProductListItem;
