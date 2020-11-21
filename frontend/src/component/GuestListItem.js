import React from 'react';

function GuestListItem({guestId,bornAt,guestName}){
    return (
        <option>({guestId}, {bornAt}, {guestName})</option>
    );
}

export default GuestListItem;
