import React from 'react';

function GuestListItem({id,bornAt,name}){
    return (
        <option>({id}, {bornAt}, {name})</option>
    );
}

export default GuestListItem;
