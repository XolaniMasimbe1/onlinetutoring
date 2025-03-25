package za.ac.cput.domain;

/* Employee.java
Tutor model class
Author: Xolani Masimbe (222410817)
Date: 20 March 2025
*/

public class Tutor {
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String subject;

    public Tutor() {

    }

    private Tutor (Builder builder) {
        this.identityNumber = builder.identityNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.subject = builder.subject;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public static class Builder {
        private String identityNumber;
        private String firstName;
        private String lastName;
        private String email;
        private String subject;

        public Builder setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
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
        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }
        public Builder copy(Tutor tutor) {
            this.setIdentityNumber(tutor.identityNumber);
            this.setFirstName(tutor.firstName);
            this.setLastName(tutor.lastName);
            this.setEmail(tutor.email);
            this.setSubject(tutor.subject);
            return this;
        }
        public Tutor build() {
            return new Tutor(this);
        }
    }

}
