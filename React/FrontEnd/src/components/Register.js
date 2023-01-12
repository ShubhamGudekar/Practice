import axios from "axios";
import { useEffect, useRef, useState } from "react";

const Register = () => {
  const [prnObj, setPRNObj] = useState({ prn: "", password: "", reEnterPassword: "" });

  return (
    <div>
      <form>
        <table style={{ margin: "auto" }}>
          <tbody>
            <tr>
              <td colSpan={2}>
                <h1>Student Registration</h1>
              </td>
            </tr>
            <tr>
              <td>PRN :</td>
              <td>
                <input type="text" name="prn" value={prnObj.prn} onChange={(e) => setPRNObj({ ...prnObj, prn: e.target.value })}></input>
              </td>
            </tr>
            <tr>
              <td>Password :</td>
              <td>
                <input type="password" name="password" value={prnObj.password} onChange={(e) => setPRNObj({ ...prnObj, password: e.target.value })}></input>
              </td>
            </tr>
            <tr>
              <td>ReEnter Password :</td>
              <td>
                <input type="password" name="reEnterPassword" value={prnObj.reEnterPassword} onChange={(e) => setPRNObj({ ...prnObj, reEnterPassword: e.target.value })}></input>
              </td>
            </tr>
            <tr>
              <td colSpan="2">
                <button
                  type="button"
                  onClick={(e) => {
                    axios.post("http://localhost:4000", prnObj).then(console.log("Data Send")).catch(console.log("Data not send"));
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

export default Register;
