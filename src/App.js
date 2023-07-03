import React from 'react';
import { BrowserRouter as Router, Route, Routes, Switch } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import CRUDForm from './components/CRUDForm';


function App() {
  return (
    <div className="min-h-screen bg-gray-100">
      <Router>
        <Switch>
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/register">
            <Register/>
          </Route>
          <Route path="/crud">
            <CRUDForm />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;

