import React from 'react';
import './App.css';


function LoginButton({ onClick }) {

  return (<div>
  <h1>Please Signup</h1>
  <button onClick={onClick}>Login</button>
  </div>);
}

function LogoutButton(props) {
  return (<div>
    <h1>Welcome Back!</h1>
    <button onClick={props.onClick}>Logout</button>

  </div>);
}

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLoginClick = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogoutClick = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    const { isLoggedIn } = this.state;

        let button = isLoggedIn
      ? <LogoutButton onClick={this.handleLogoutClick} />
      : <LoginButton onClick={this.handleLoginClick} />;

    return (
      <div className="App">
        {button}
      </div>
    );
  }
}

export default App;
