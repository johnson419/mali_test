import React, { useState } from 'react';

function Register() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleRegister = () => {
    // Logic to handle registration
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <h1 className="text-2xl font-bold mb-4">Register</h1>
      <form>
        <input
          type="email"
          placeholder="Email"
          className="border border-gray-300 rounded p-2 mb-2"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          className="border border-gray-300 rounded p-2 mb-2"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button
          type="button"
          className="bg-green-500 hover:bg-green-700 text-white py-2 px-4 rounded"
          onClick={handleRegister}
        >
          Register
        </button>
        
      </form>
    </div>
  );
}

export default Register;
