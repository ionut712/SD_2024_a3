import React from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import UserList from './UserList';
import UserEdit from './UserEdit';
import UserAdd from './UserAdd';

const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Home/>}/>
        <Route path='/users' exact={true} element={<UserList/>}/>
	<Route path='/users/:id' element={<UserEdit/>}/>
	<Route path='/users/add' element={<UserAdd/>}/>
      </Routes>
    </Router>
  )
}


export default App;
