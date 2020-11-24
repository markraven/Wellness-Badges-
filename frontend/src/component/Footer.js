import React from 'react';

const Footer = () => {
    return (
        <footer id='footer' className={"page-footer bg-info text-light mt-2"} style={{position: "relative", bottom: "0"}}>
            <div className={"footer-copyright text-center py-2"}>
                {new Date().getFullYear()} Copyright Team9
            </div>
        </footer>
    )

}

export default Footer;