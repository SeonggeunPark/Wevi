import { useState } from "react";

import { CORE_CONCEPTS } from "./data";
import Header from "./components/Header/Header";
import TabButton from "./components/TabButon";
import { EXAMPLES } from "./data.js";
import TopNavigationBar from "./components/TopNavigationBar/TopNavigationBar.jsx";
import BottomNavigationBar from "./components/BottomNavigationBar/BottomNavigationBar.jsx";

function CoreConcept({ image, title, description }) {
  return (
    <li>
      <img src={image} alt="" />
      <h3>{title}</h3>
      <p>{description}</p>
    </li>
  );
}

function App() {
  return (
    <div>
      <TopNavigationBar />
      <div className="text-center bg-blue-300 text-white py-10">
        <h1 className="text-4xl font-bold">Hello, Tailwind CSS!</h1>
        <p className="mt-4">Your setup is working perfectly!</p>
      </div>
      <BottomNavigationBar />
    </div>
  );
}

export default App;
