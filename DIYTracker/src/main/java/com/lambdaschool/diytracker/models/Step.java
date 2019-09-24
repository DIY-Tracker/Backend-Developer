package com.lambdaschool.diytracker.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "steps")
public class Step extends Auditable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long stepId;

        @Column(nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long stepNumber;

        @Column(nullable = false)
        private String stepName;

        @Column(nullable = false)
        private String stepDescription;

        @ManyToOne
        @JoinColumn(name = "projectid",
                nullable = false)
        @JsonIgnoreProperties("steps")
        private Project project;

    public Step() {
    }

    public Step(String stepName, String stepDescription, Project project) {
        this.stepName = stepName;
        this.stepDescription = stepDescription;
        this.project = project;
    }

    public long getStepId() {
        return stepId;
    }

    public void setStepId(long stepId) {
        this.stepId = stepId;
    }

    public long getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(long stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Step{" +
                "stepId=" + stepId +
                ", stepName='" + stepName + '\'' +
                ", project=" + project +
                '}';
    }
}


