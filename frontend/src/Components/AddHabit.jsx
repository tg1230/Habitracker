import React from 'react'

class AddHabit extends React.Component {

    constructor() {
        super()
        this.state = {
            habit: ""
        }
    }

    mySubmitHandler = (event) => {
        event.preventDefault();
        alert("You are submitting " + this.state.habit);
        this.sampleFunc(this.state.habit);
      }
      myChangeHandler = (event) => {
        this.setState({habit: event.target.value});
      }

    async sampleFunc(toInput) {
        const response = await fetch("/api/HabitAdd", {
          method: "POST", 
          mode: "cors",
          cache: "no-cache", 
          credentials: "same-origin", 
          headers: {
            "Content-Type": "application/json"
            // 'Content-Type': 'application/x-www-form-urlencoded',
          },
          redirect: "follow", 
          referrerPolicy: "no-referrer", 
          body: JSON.stringify(toInput)  // body data type must match "Content-Type" header
        });
        let body = await response.json();
        console.log(body.id);
    }

    render() {
        return (
            <form onSubmit={this.mySubmitHandler}>
                <label>Habit: </label>
                <input type="text" onChange={this.myChangeHandler} contentEditable="true"></input>
                <input type="submit"/>
            </form>
            
        )
    }

};

export default AddHabit;