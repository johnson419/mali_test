import React from 'react';
import { BrowserRouter as Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import CRUDForm from './components/CRUDForm';

function App() {
  return (
    <div className="min-h-screen bg-gray-100">
   <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/crud" element={<CRUDForm />} />
      </Routes>
    </div>
  );
}

export default App;



