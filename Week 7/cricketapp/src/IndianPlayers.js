import React from 'react';

export const IndianTeam = [
  'Sachin1',
  'Dhoni2',
  'Virat3',
  'Rohit4',
  'Yuvaraj5',
  'Raina6'
];

export function OddPlayers({ players }) {
  const [first, , third, , fifth] = players;
  return (
    <ul>
      <li>First : {first}</li>
      <li>Third : {third}</li>
      <li>Fifth : {fifth}</li>
    </ul>
  );
}

export function EvenPlayers({ players }) {
  const [, second, , fourth, , sixth] = players;
  return (
    <ul>
      <li>Second : {second}</li>
      <li>Fourth : {fourth}</li>
      <li>Sixth : {sixth}</li>
    </ul>
  );
}

const T20Players = ['First Player', 'Second Player', 'Third Player'];
const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];

export const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];
