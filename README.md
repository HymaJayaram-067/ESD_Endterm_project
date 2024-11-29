# ESD_Endterm_project
course specialization crud operations

PROBLEM STATEMENT
2.1 2.1 Course Specialisation CRUD
Allow the employee of admin department to create, read, update and delete course specialisation(Theory & Systems, Data Science etc). On selecting a specialisation display all the courses registered under it.

Features
Authentication: Login functionality for employee.
 Update and retrieve specialization andcourse  details.

SQL Scripts
Creation:create_academicerp.sql
Insertion:insert_academicerp.sql

### Create Tables:
- **Method**: POST
- **URL**: http://localhost:8080/api/load-tables
- **Body**: None

---

### Create Specialisations:
- **Method**: POST
- **URL**: http://localhost:8080/api/specialisations/createUpdateSpecialisation
- **Body**:
{
  "code": "CS101",
  "name": "Computer Science 101",
  "description": "Introduction to Computer Science",
  "year": 2024,
  "creditsRequired": 120
}

---

### Update Specialisations:
- **Method**: POST
- **URL**: http://localhost:8080/api/specialisations/createUpdateSpecialisation
- **Body**:
{
  "specialisationId": 3,
  "code": "CS102",
  "name": "Computer Science 102",
  "description": "Introduction to Computer Science",
  "year": 2024,
  "creditsRequired": 120
}

---

### Get All Specialisations:
- **Method**: GET
- **URL**: http://localhost:8080/api/specialisations/findAllSpecialisations
- **Body**: None

---



### Get Specialisation by ID:
- **Method**: GET
- **URL**: http://localhost:8080/api/specialisations/{id}
- **Body**: None

---

### Delete Specialisation by ID:
- **Method**: DELETE
- **URL**: http://localhost:8080/api/specialisations/{id}
- **Body**: None

---

### Add a Course to Specialisation:
- **Method**: POST
- **URL**: http://localhost:8080/api/specialisations/{specialisationId}/courses/{courseId}
- **Body**: None

---

### Get Courses by Specialisation ID:
- **Method**: GET
- **URL**: http://localhost:8080/api/specialisations/{id}/courses
- **Body**: None

---

### Create or Update Specialisation with Courses:
- **Method**: POST
- **URL**: http://localhost:8080/api/specialisations/createUpdateSpecialisationWithCourses
- **Body**:
{
  "code": "CS101",
  "name": "Computer Science",
  "description": "A specialisation in Computer Science",
  "courses": [
    {
      "courseCode": "CS201",
      "courseName": "Data Structures",
      "description": "An advanced course in Data Structures"
    },
    {
      "courseCode": "CS202",
      "courseName": "Algorithms",
      "description": "An advanced course in Algorithms"
    }
  ]
}

---

### Create or Update Multiple Specialisations:
- **Method**: POST
- **URL**: http://localhost:8080/api/specialisations/createUpdateSpecialisations
- **Body**:
[
  {
    "code": "CS101",
    "name": "Computer Science",
    "description": "A specialisation in Computer Science"
  },
  {
    "code": "IT101",
    "name": "Information Technology",
    "description": "A specialisation in Information Technology"
  }
]

---

### Create or Update Course:
- **Method**: POST
- **URL**: http://localhost:8080/api/courses/createUpdateCourse
- **Body**:
{
  "courseCode": "CS201",
  "courseName": "Data Structures",
  "description": "An advanced course in Data Structures"
}

---

### Create or Update Multiple Courses:
- **Method**: POST
- **URL**: http://localhost:8080/api/courses/createUpdateCourses
- **Body**:
[
  {
    "courseCode": "CS201",
    "courseName": "Data Structures",
    "description": "An advanced course in Data Structures"
  },
  {
    "courseCode": "CS202",
    "courseName": "Algorithms",
    "description": "An advanced course in Algorithms"
  }
]

---

### Delete Course by ID:
- **Method**: DELETE
- **URL**: http://localhost:8080/api/specialisations/{specialisationId}/courses/{courseId}
- **Body**: None

---

### Get Course by ID:
- **Method**: GET
- **URL**: http://localhost:8080/api/courses/{id}
- **Body**: None
