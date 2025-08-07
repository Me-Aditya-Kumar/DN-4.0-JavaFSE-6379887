import React from "react";

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: "",
      complaint: "",
      NumberHolder: Math.floor(Math.random() * 100)
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  handleSubmit(event) {
    const msg =
      "Thanks " +
      this.state.ename +
      "\nYour Complaint was Submitted.\nTransaction ID is: " +
      this.state.NumberHolder;
    alert(msg);
    event.preventDefault();
  }

  render() {
    return (
      <div>
        <h1 style={{ color: "red", textAlign: "center" }}>
          Register your complaints here!!!
        </h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name: </label>
            <input
              type="text"
              name="ename"
              value={this.state.ename}
              onChange={this.handleChange}
            />
          </div>
          <br />
          <div>
            <label>Complaint: </label>
            <textarea
              name="complaint"
              value={this.state.complaint}
              onChange={this.handleChange}
            />
          </div>
          <br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;
