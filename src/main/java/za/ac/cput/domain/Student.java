package za.ac.cput.domain;

import java.util.List;

/* Student.java
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
   Modified: 28 March 2025
*/
public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Session> sessions;
    private List<Review> reviews;

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.sessions = builder.sessions;
        this.reviews = builder.reviews;
    }

    public String getStudentId() { return studentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public List<Session> getSessions() { return sessions; }
    public List<Review> getReviews() { return reviews; }


    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", sessions=" + sessions +
                ", reviews=" + reviews +
                '}';
    }

    public static class Builder {
        private String studentId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private List<Session> sessions;
        private List<Review> reviews;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }


        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setSessions(List<Session> sessions) {
            this.sessions = sessions;
            return this;
        }

        public Builder setReviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.firstName = student.firstName;
            this.lastName = student.lastName;
            this.email = student.email;
            this.password = student.password;
            this.sessions = student.sessions;
            this.reviews = student.reviews;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
