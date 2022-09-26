import React from 'react'
import './style.css'
function PurchaseTable(props) {
    console.log("Printing in Purchase table",props.data)
    return (
        <div>
           <table className="record-table" style={{"borderWidth":"1px", 'borderColor':"#aaaaaa", 'borderStyle':'solid'}}>
               <tr>
                   <th>Material Category</th>
                   <th>Material Type</th>
                   <th>Brand</th>
                   <th>Quantity</th>
                   <th>Unit</th>
                   <th>Price</th>
                   <th>Balance</th>
                   <th>Purchase Date</th>
               </tr>
               {
                   props.data.map((record, index)=>(
                       <tr key={index}>
                           <td>{record.materialCategoryName}</td>
                           <td>{record.materialTypeName}</td>
                           <td>{record.brandname}</td>
                           <td>{record.quantity}</td>
                           <td>{record.unitName}</td>
                           <td>{record.purchaseAmount}</td>
                           <td>{record.purchaseAmount}</td>
                           <td>{record.purchaseDate}</td>
                       </tr>
                   ))
               }
            </table> 
        </div>
    )
}

export default PurchaseTable
