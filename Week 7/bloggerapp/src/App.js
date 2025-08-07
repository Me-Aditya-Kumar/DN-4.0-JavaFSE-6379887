import React, { Component } from "react";
import "./App.css";

// Book Details Component
function BookDetails(props) {
  const bookList = props.books.map((book) => (
    <div key={book.id}>
      <h3>{book.bname}</h3>
      <h4>{book.price}</h4>
    </div>
  ));
  return <div>{bookList}</div>;
}

// Blog Details Component
function BlogDetails(props) {
  return (
    <div>
      {props.blogs.map((blog, index) => (
        <div key={index}>
          <h2>{blog.title}</h2>
          <h4>{blog.author}</h4>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}

// Course Details Component
function CourseDetails(props) {
  return (
    <div>
      {props.courses.map((course, index) => (
        <div key={index}>
          <h2>{course.name}</h2>
          <h4>{course.date}</h4>
        </div>
      ))}
    </div>
  );
}

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showBooks: true,
      showBlogs: true,
      showCourses: true
    };
  }

  render() {
    // Books Data
    const books = [
      { id: 101, bname: "Master React", price: 670 },
      { id: 102, bname: "Deep Dive into Angular 11", price: 800 },
      { id: 103, bname: "Mongo Essentials", price: 450 }
    ];

    // Blogs Data
    const blogs = [
      { title: "React Learning", author: "Stephen Biz", content: "Welcome to learning React!" },
      { title: "Installation", author: "Schewzdenier", content: "You can install React from npm." }
    ];

    // Courses Data
    const courses = [
      { name: "Angular", date: "4/5/2021" },
      { name: "React", date: "6/3/2021" }
    ];

    return (
      <div className="App">
        {/* Course Details */}
        {this.state.showCourses && (
          <div className="mystyle1">
            <h1>Course Details</h1>
            <CourseDetails courses={courses} />
          </div>
        )}

        {/* Book Details */}
        {this.state.showBooks && (
          <div className="st2">
            <h1>Book Details</h1>
            <BookDetails books={books} />
          </div>
        )}

        {/* Blog Details */}
        {this.state.showBlogs && (
          <div className="v1">
            <h1>Blog Details</h1>
            <BlogDetails blogs={blogs} />
          </div>
        )}
      </div>
    );
  }
}

export default App;
