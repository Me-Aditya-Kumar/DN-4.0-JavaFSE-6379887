// EmployeeCard.js
import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard() {
  const theme = useContext(ThemeContext);

  return (
    <button className={theme}>Employee Action</button>
  );
}

export default EmployeeCard;
