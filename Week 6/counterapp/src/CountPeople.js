import React from 'react';

class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0,
      c: 0 // Not used but included to match your screenshot
    };
  }

  updateEntry() {
    this.setState((prevState, props) => {
      return { entrycount: prevState.entrycount + 1 };
    });
  }

  updateExit() {
    this.setState((prevState, props) => {
      return { exitcount: prevState.exitcount + 1 };
    });
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '100px' }}>
        <button
          onClick={() => this.updateEntry()}
          style={{
            backgroundColor: 'lightgreen',
            padding: '5px 10px',
            marginRight: '30px',
            fontSize: '16px'
          }}
        >
          Login
        </button>
        <span style={{ marginRight: '30px' }}>
          {this.state.entrycount} People Entered!!!
        </span>

        <button
          onClick={() => this.updateExit()}
          style={{
            backgroundColor: 'lightgreen',
            padding: '5px 10px',
            marginRight: '10px',
            fontSize: '16px'
          }}
        >
          Exit
        </button>
        <span>{this.state.exitcount} People Left!!!</span>
      </div>
    );
  }
}

export default CountPeople;
