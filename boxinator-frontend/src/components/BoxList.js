import React, { useEffect, useState } from 'react';
import BoxService from '../service/BoxService';


const BoxList = () =>{


    const [message, setMessage] = useState({value: '', type: ''});
    
    const [reload, setReload] = useState(false);
    const [boxes,setBoxes]=useState([]);


       
    useEffect(()=>{
        const boxService = new BoxService();
        boxService.findAll().then((res)=>{
            console.log(res);
            if(res.status === 200){
                setBoxes(res.data);
                setMessage({value: 'Operation is Done!', type: 'success'});
            } else {
                 setMessage({value: 'Operation is Failed!', type: 'danger'});
            }
        });

    },[reload]);


    const Table = () => {

        const TableHeader = ()=> {
            return (
                <thead>
                    <tr>
                        <th>Receiver</th>
                        <th>Weight</th>
                        <th>Box colour</th>
                        <th>Shipping cost</th>
                    </tr>
                </thead>
                )
        };

        const TableRow = ()=> {
            return (
                <tbody>
                   {
                    boxes.map( (box)=> (
                        <tr key={box.id}>
                            <td>{box.name}</td>
                            <td>{box.weight +" "+ "Kilograms"}</td>
                            <td>{box.boxColour} </td>
                            <td>{box.shippingCost} </td>
    
                        </tr>
                    ))   
                   }                     
                </tbody>
            )
        };
        return(
            <div className="container">
                <table className="table table-striped">
                    <TableHeader/>
                    <TableRow />
                </table>
            </div>
            );

    };



    return (
        <div className="container">
            <Table />
        </div>
    );


};
export default BoxList;
