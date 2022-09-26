//create a form with vendor name, from date and to date
//load vendor details when page loads in the appropriate field of the form created.
//on submit, display the purchases made from the vendor selected and dates mentioned if any

import React, { Component } from 'react'
import PropTypes from 'prop-types'
import axios from 'axios'
import Vendordetail  from './Vendordetail'

import PurchaseTable from './PurchaseTable'

export class PostForm extends Component {
    
    constructor(props) {
        super(props)
        this.state = {
             vendors:{},
             vendorName:"" ,
             contactPerson:"" ,
             contactNumber:"" ,
             vendorAddress :"" ,
             index: -1,
             reports:[],
             errorMessage  :"Some Error Occured"
        }
    }
    componentDidMount() { 
        axios.get("http://localhost:8087/vendor/controller/getVendors")//async based / non blocking request
        .then(
            response=> {
                console.log("Go result"+response.data);
                this.setState({vendors:response.data})
                console.log(this.state.vendors)

            }
        ).catch(error=>{
                console.log(">"+error.message)
        });
    }
    handleDropDownChange=(event)=>{
        this.setState({
            index: event.target.value 
        },(event)=>this.updateVendorDetails())
       
    }
    updateVendorDetails = (event)=>{
        this.setState({
            vendorName : this.state.vendors[this.state.index].vendorName ,
            contactPerson :this.state.vendors[this.state.index].contactPerson , 
            contactNumber : this.state.vendors[this.state.index].contactNumber ,
            vendorAddress : this.state.vendors[this.state.index].vendorAddress ,
        },()=>console.log('Changed Value is :'+this.state.vendorName));
    }
    handleformsubmit=(event) =>{  
        console.log(event.target.elements.username.value) 
        event.preventDefault() ;
        console.log(event.target.elements.date1.value)
        console.log("Adding data")
        if(this.state.vendorName=="")
        {    alert("Please enter Vendor Name!")

        }
        if(event.target.elements.date1.value>event.target.elements.date2.value)
        {    alert("Please enter Valid Date!")

        }        
        const data = {
            vendor : this.state.vendorName,
            fromDate :event.target.elements.date1.value ,
            toDate : event.target.elements.date2.value 
        }
        axios.post("http://localhost:8080/InventoryManagementSystemTeamI//rest/getPurchaseReports" ,data)
            .then(
                res=> {
                    console.log("data collection here")
                    console.log(res);
                    this.setState({
                        ...this.state,
                        reports: res.data
                    });
                }
            )
            .catch(error =>{ 
                console.log("Error Occured:",error.message)
            }
            
            )
   
    }
        
    render() {
        var vendorNames =[] ;
        for (var i=0; i < this.state.vendors.length; i++) {
            // console.log(this.state.vendors[i])
            vendorNames.push(this.state.vendors[i].vendorName)
        } 
       
        return (
            <div>
                <a href="http://localhost:8080/InventoryManagementSystemTeamI/">Home Page</a>
                <div className="homeHead">

                    Vendor Purchase Report
                    
                </div>
                
                <div>
                    <form  onSubmit={this.handleformsubmit}>
                        <div class="postForm-container">
                            <div class="postForm-field">
                                <span class="postForm-field-head">Vendor Name</span>
                                <span class="postForm-field-input">
                                    <select onChange= {this.handleDropDownChange} name ="username" >
                                        <option value="-1">Select Vendor</option>
                                    { vendorNames.map((name,index) =>{ 
                                        return (                                 
                                            <option value={index} >{name}</option>
                                        )
                                    })}
                                    </select>
                                </span>
                            </div>
                            <div class="postForm-field">
                                <span class="postForm-field-head">From Date</span>
                                <span class="postForm-field-input">
                                <input type="date" name="date1"/>
                                </span>
                            </div>
                            <div class="postForm-field">
                                <span class="postForm-field-head">To Date</span>
                                <span class="postForm-field-input">
                                <input type ="date" name="date2" />
                                </span>
                            </div>
                            <div class="postForm-field">
                                
                                    <button class="postForm-field-button" type="submit" style={{height:"35px"}}>Search</button>
                               
                            </div>
                        </div>
                    </form>
                </div>
                { this.state.vendorName.length >0 ?
                    <Vendordetail 
                        name ={this.state.vendorName}
                        contactNumber= {this.state.contactNumber}
                        contactPerson= {this.state.contactPerson}
                        vendorAddress ={this.state.vendorAddress}
                    />
                :
                false
                }
                { this.state.reports.length > 0 ?
                    <PurchaseTable data={this.state.reports}/>
                    :
                    false
                }        
              
            </div>
        )
    }
}
