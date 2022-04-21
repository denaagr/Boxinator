import React, { Fragment } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import AddBox from './AddBox';
import BoxList from './BoxList';

const Navbar  = () => {
    return (
        <Fragment>
            <Router>
                <Header />
                <div className="container">
                    <Switch>
                        <Route exact path="/" component={Home} />
                        <Route path="/addbox" component={AddBox} />
                        <Route path="/listboxes" component={BoxList} />
                      
                        <Route component={NotFound} />

                    </Switch>
                </div>
                
            </Router>

        </Fragment>
    );

};

const Home = () => <b>Home Page</b>;
const NotFound = () => <b>Page Not Found</b>;


const Header = () => {
    return (
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
            <div className="container-fluid">
                <ul className="navbar-nav me-auto">
                    
                    <li className="nav-item">
                        <Link className="navbar-brand" to="/">Home</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="navbar-brand" to="/addbox">AddBox</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="navbar-brand" to="/listboxes">BoxList</Link>
                    </li>
                   
                </ul>
                
            </div>
    
        </nav>
    )
    };
    
   
    
       
    
    
export default Navbar;