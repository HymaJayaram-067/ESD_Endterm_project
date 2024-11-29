import React, { useState } from "react";
import { createOrUpdateSpecialisation } from "../services/specialisationService";

const SpecialisationForm = ({ refreshSpecialisations }) => {
  const [name, setName] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const newSpecialisation = { name };
    try {
      await createOrUpdateSpecialisation(newSpecialisation);
      refreshSpecialisations(); // Refresh the specialisations list after creation
      setName(""); // Reset the form
    } catch (error) {
      console.error("Error creating specialisation:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Specialisation Name"
      />
      <button type="submit">Add Specialisation</button>
    </form>
  );
};

export default SpecialisationForm;
