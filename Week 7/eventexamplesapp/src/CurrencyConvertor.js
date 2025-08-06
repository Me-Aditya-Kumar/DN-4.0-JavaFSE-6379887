import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euros: '',
    };
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = () => {
    const conversionRate = 0.011;
    const euros = (parseFloat(this.state.rupees) * conversionRate).toFixed(2);
    this.setState({ euros });
  };

  render() {
    return (
      <div style={{ marginTop: '30px' }}>
        <h3 style={{ color: 'green' }}>Currency Converter</h3>

        <div style={{ marginBottom: '10px' }}>
          <label>Amount:</label>
          <input
            type="number"
            value={this.state.rupees}
            onChange={this.handleChange}
            style={{ marginLeft: '10px' }}
          />
        </div>

        <div style={{ marginBottom: '10px' }}>
          <label>Currency:</label>
          <input
            type="text"
            value="Euro"
            readOnly
            style={{ marginLeft: '10px' }}
          />
        </div>

        <button onClick={this.handleSubmit}>Submit</button>

        {this.state.euros && (
          <div style={{ marginTop: '15px', color: 'green' }}>
            Converted Amount: €{this.state.euros}
          </div>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
