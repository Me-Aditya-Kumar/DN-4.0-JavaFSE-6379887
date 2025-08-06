import React from 'react';

export function ListofIndianPlayers({ IndianPlayers }) {
  return (
    <ul>
      {IndianPlayers.map((player, index) => (
        <li key={index}>Mr. {player}</li>
      ))}
    </ul>
  );
}
