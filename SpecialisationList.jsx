import React from "react";

const SpecialisationList = ({ specialisations, onSelect, refreshSpecialisations }) => {
  return (
    <div>
      <h2>Specialisations</h2>
      <ul>
        {specialisations.map((specialisation) => (
          <li key={specialisation.id}>
            <span>{specialisation.name}</span>
            <button onClick={() => onSelect(specialisation.id)}>View Courses</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default SpecialisationList;
