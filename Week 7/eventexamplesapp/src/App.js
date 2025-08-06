import React from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
    };
    this.increment = this.increment.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.incrementAndGreet = this.incrementAndGreet.bind(this);
  }

  increment() {
    this.setState((prevState) => ({
      count: prevState.count + 1,
    }));
  }

  decrement = () => {
    this.setState((prevState) => ({
      count: prevState.count - 1,
    }));
  };

  sayHello() {
    alert('Hello! This is a static message.');
  }

  incrementAndGreet() {
    this.increment();
    this.sayHello();
  }

  sayWelcome(message) {
    alert(message);
  }

  handleClick = (e) => {
    alert('I was clicked');
  };

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h2>Event Handling Example</h2>
        <p>Counter: {this.state.count}</p>
        <button onClick={this.incrementAndGreet}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
        <br /><br />

        <button onClick={() => this.sayWelcome('Welcome!')}>
          Say Welcome
        </button>
        <br /><br />

        <button onClick={this.handleClick}>
          Synthetic Event - OnPress
        </button>
        <br /><br />

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
