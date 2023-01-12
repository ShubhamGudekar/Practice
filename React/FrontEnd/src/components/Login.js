import axios from "axios";
import { useEffect, useRef, useState } from "react";

const Login = () => {
  const [prnObj, setPRNObj] = useState({ prn: "", password: "", reEnterPassword: "" });
  const [errFlag, setErrFlag] = useState("false");

  const handleChange = (e) => {
    let { name, value } = e.target;
    setPRNObj({ ...prnObj, [name]: value });
  };

  return (
    <div>
      <form>
        <table style={{ margin: "auto" }}>
          <tbody>
            <tr>
              <td colSpan={2}>
                <h1>Student Login</h1>
              </td>
            </tr>
            <tr>
              <td>PRN :</td>
              <td>
                <input type="text" name="prn" value={prnObj.prn} onChange={handleChange}></input>
              </td>
            </tr>
            <tr>
              <td>Password :</td>
              <td>
                <input type="password" name="password" value={prnObj.password} onChange={handleChange}></input>
              </td>
              {errFlag == true ? "<td>Password not matching</td>" : ""}
            </tr>
            <tr>
              <td>ReEnter Password :</td>
              <td>
                <input type="password" name="reEnterPassword" value={prnObj.reEnterPassword} onChange={handleChange}></input>
              </td>
              <td>{setErrFlag == "true" ? "Password Not Matching" : ""}</td>
            </tr>
            <tr>
              <td colSpan="2">
                <button
                  onClick={(e) => {
                    e.preventDefault();
                    if (prnObj.password === prnObj.reEnterPassword) {
                      console.log(prnObj);
                      axios.post("http://localhost:4000", prnObj);
                    } else console.log("password not matching");
                  }}
                >
                  Register
                </button>
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
  );
};

export default Login;
