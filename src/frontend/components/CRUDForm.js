import React, { useState, useEffect } from 'react';

function CRUDForm() {
  const [data, setData] = useState([]);
  const [inputValue, setInputValue] = useState('');

  useEffect(() => {
    // Fetch data from an API or database
    // Example code:
    // fetch('https://api.example.com/data')
    //   .then(response => response.json())
    //   .then(data => setData(data));
    // Replace the above code with your API or database integration logic
    // This is just a placeholder to demonstrate the basic structure
    const initialData = ['Item 1', 'Item 2', 'Item 3'];
    setData(initialData);
  }, []);

  const handleInputChange = event => {
    setInputValue(event.target.value);
  };

  const handleAddItem = () => {
    if (inputValue.trim() !== '') {
      setData([...data, inputValue]);
      setInputValue('');
    }
  };

  const handleDeleteItem = index => {
    const newData = data.filter((item, i) => i !== index);
    setData(newData);
  };

  return (
    <div>
      <h1>CRUD Form</h1>

      <div>
        <input type="text" value={inputValue} onChange={handleInputChange} />
        <button onClick={handleAddItem}>Add</button>
      </div>

      <ul>
        {data.map((item, index) => (
          <li key={index}>
            {item}
            <button onClick={() => handleDeleteItem(index)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CRUDForm;
