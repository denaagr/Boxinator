import React, { Fragment, useEffect, useState } from 'react';
import BoxService from '../service/BoxService';
import { useForm } from 'react-hook-form';
import {ColorPicker} from 'primereact/colorpicker';


const AddBox  = () => {

    const [boxes,setBoxes]=useState([]);
    const [message, setMessage] = useState({value: '', type: ''});
    const [reload, setReload] = useState(false);

    const [countryState, setCountryState]=useState("Sweden");

    

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

   


    
    const Form = () => {

        const {register, handleSubmit, formState: {errors} } = useForm();

        const saveBox = (data) => {
            console.log("DATA#### ",data);
           const service = new BoxService();
            service.saveBox(data).then(res => {
                if(res.status === 201){
                    setMessage({value: 'Operation is done for box Id:' + res.data.id , type: 'success'});
                    
                     setReload(!reload);
                }else {
                    
                    setMessage({value: 'Error:'+ res.status, type: 'danger'});
                }
            });
           
        }
        
        return(
            <Fragment>
                <form className="form-control m-2 p-3 " onSubmit={handleSubmit(saveBox)}>
                    <div className="row mb-3">
                        <div className="col-6">
                         <label>Name</label>
                            <input type="text" className="form-control" {...register("name", {required: true})}  />
                            {errors.name && <span className="text-danger">Name is Required!</span>}
                        </div>
                    </div> 

                    <div className="row mb-3">
                        <div className="col-6">
                         <label>Weight</label>
                            <input type="number" min="0.01" step={0.1} precision={2} className="form-control" {...register("weight", {required: true})}  />
                            {errors.weight && <span className="text-danger">Weight is Required!</span>}
                        </div>
                    </div>

                    <div className="row mb-3">
                        <div className="col-6">
                         <label>Box Colour</label>
                            <input type="color" id="boxColour" className="form-control"   {...register("boxColour", {required: true})} placeholder="Click to show colour picker" />
                            {errors.colour && <span className="text-danger">Box colour is Required!</span>}
                        </div>
                    </div>

                    <div className="row mb-3">
                        <div className="col-6">
                         <label>Country</label>
                            <select  className="form-control" {...register("country",{required: true})} onChange={(e) =>{ const selectedCountry=e.target.value; setCountryState(selectedCountry) }}>
                                <option value="Sweden">Sweden</option>
                                <option value="China">China</option>
                                <option value="Brazil">Brazil</option>
                                <option value="Australia">Australia</option>
                            </select>
                        </div>
                    </div>  

                    <button type="submit" className="btn btn-success">Save</button>
                    
                </form>
            </Fragment>
        );
    };


    return (
        <div className="container">

            <Form />
            
        </div>
    );
    
 
};
export default AddBox;
