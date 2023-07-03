import { Link } from 'react-router-dom';

function CRUDForm() {
    return (
      <div className="container mx-auto px-4 py-8">
        <h1 className="text-2xl font-bold mb-4">CRUD Form</h1>
        {/* Form implementation */}
        <Link to="/crud" className="mr-2">
          Back to CRUD Form
        </Link>
      </div>
    );
  }

  export default CRUDForm