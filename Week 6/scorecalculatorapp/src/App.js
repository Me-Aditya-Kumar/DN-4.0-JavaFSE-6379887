import React from 'react';
import './App.css';
import { CalculateScore } from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore Name="Aditya" School="SOA University" total={480} goal={6} />
    </div>
  );
}

export default App;
