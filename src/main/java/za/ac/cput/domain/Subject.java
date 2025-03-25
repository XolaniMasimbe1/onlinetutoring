package za.ac.cput.domain;

public class Subject {

    private final String subjectId;
    private final String name;
    private final String description;
    private final String gradeLevel;

    private Subject(Builder builder) {
        this.subjectId = builder.subjectId;
        this.name = builder.name;
        this.description = builder.description;
        this.gradeLevel = builder.gradeLevel;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                '}';
    }

    public static class Builder {
        private String subjectId;
        private String name;
        private String description;
        private String gradeLevel;

        public Builder setSubjectId(String subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setGradeLevel(String gradeLevel) {
            this.gradeLevel = gradeLevel;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }
}
/* OnlineTutoring.java
Subject model class
Author: Siphosenkosi Mbala (221140700)
Date: 23 March 2025
*/
