package za.ac.cput.domain;

import java.util.Objects;

/* Student.java
   Student model class
   Author: Anda Matomela (222578912)
   Date: 22 March 2025
*/
public class Student {
    private final String studentID;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    private Student(Builder builder) {
        this.studentID = builder.studentID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getStudentID() { return studentID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public static class Builder {
        private String studentID;
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
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

        public Student build() {
            return new Student(this);
        }
    }
}
