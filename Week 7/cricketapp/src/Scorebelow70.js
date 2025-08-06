import React from 'react';

export function Scorebelow70({ players }) {
  const filtered = players.filter((p) => p.score <= 70);
  return (
    <ul>
      {filtered.map((item) => (
        <li key={item.name}>
          Mr. {item.name} {item.score}
        </li>
      ))}
    </ul>
  );
}
