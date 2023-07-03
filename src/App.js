import React from 'react';
import { BrowserRouter as Route, Router } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import CRUDForm from './components/CRUDForm';

function App() {
  return (
    <div className="min-h-screen bg-gray-100">
      {/* <Login/> */}
   <Router>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/crud" element={<CRUDForm />} />
      </Router>
    </div>
  );
}

export default App;



