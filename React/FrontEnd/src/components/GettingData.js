import axios from "axios";
import { useEffect, useState } from "react";
import Moment from "moment";

const GettingData = () => {
  const [fetchedData, setFetchedData] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:4000")
      .then((resp) => {
        console.log(resp.data);
        setFetchedData(resp.data);
      })
      .catch((err) => console.log(err.message));
  }, []);

  const renderList = () => {
    return fetchedData.map((s) => {
      return (
        <tr key={s.rollno}>
          <td>{s.rollno}</td>
          <td>{s.studname}</td>
          <td>{s.course}</td>
          <td>{Moment(s.doa).format("DD-MM-YYYY")}</td>
          <td>{s.marks}</td>
          <td>{s.phoneno}</td>
        </tr>
      );
    });
  };

  return (
    <div>
      <table border={"2px"}>
        <tbody>
          <tr>
            <td>RollNo</td>
            <td>Student Name</td>
            <td>Course</td>
            <td>Date of Admission</td>
            <td>Marks</td>
            <td>Phone</td>
          </tr>
          {renderList()}
        </tbody>
      </table>
    </div>
  );
};

export default GettingData;
