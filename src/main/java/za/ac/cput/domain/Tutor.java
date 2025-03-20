package za.ac.cput.domain;

/* Employee.java
Tutor model class
Author: Ross Barth (222410817)
Date: 20 March 2025
*/

public class Tutor {
    private String identityNumber;
    private String firstName;
    private String lastName;
    private String email;

    public Tutor() {

    }

    private Tutor (Builder builder) {
        this.identityNumber = builder.identityNumber;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
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

    @Override
    public String toString() {
        return "Tutor{" +
                "identityNumber='" + identityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class Builder {
        private String identityNumber;
        private String firstName;
        private String lastName;
        private String email;

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
        public Builder copy(Tutor tutor) {
            this.setIdentityNumber(tutor.identityNumber);
            this.setFirstName(tutor.firstName);
            this.setLastName(tutor.lastName);
            this.setEmail(tutor.email);
            return this;
        }
        public Tutor build() {
            return new Tutor(this);
        }
    }

}
