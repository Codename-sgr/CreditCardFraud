import React from 'react'
import './vendorDetail.css'

function Vendordetail(props) {
    return (
        
        <div class="reportTable-details">
            <div>
                Contact Number:  &nbsp;{props.contactNumber}
            </div>
            <div>
                Contact Person:  &nbsp;{props.contactPerson}
            </div>
            <div>
                Contact Address:  &nbsp;{props.vendorAddress}
            </div>
                
                                
               
          
        </div>
    )
}

export default Vendordetail

