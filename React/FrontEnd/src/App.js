import logo from "./logo.svg";
import "./App.css";
import { Route, Routes } from "react-router-dom";
import Welcome from "./components/Welcome";
import Aboutus from "./components/Aboutus";
import Navbar from "./components/Navbar";
import GettingData from "./components/GettingData";
import Login from "./components/Login";
import Register from "./components/Register";

function App() {
  return (
    <div>
      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<Welcome></Welcome>}></Route>
        <Route path="/Aboutus" element={<Aboutus></Aboutus>}></Route>
        <Route path="/AllStudents" element={<GettingData></GettingData>}></Route>
        <Route path="/Login" element={<Login></Login>}></Route>
        <Route path="/Register" element={<Register></Register>}></Route>
      </Routes>
    </div>
  );
}

export default App;
