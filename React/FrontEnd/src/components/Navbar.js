import { NavLink } from "react-router-dom";
import "./navbar.css";

const Navbar = () => {
  return (
    <nav className="navbar">
      <NavLink to={"/"}>Home</NavLink>
      <NavLink to={"/Aboutus"}>About Us</NavLink>
      <NavLink to={"/Login"}>Login</NavLink>
      <NavLink to={"/Register"}>Register</NavLink>
    </nav>
  );
};

export default Navbar;
