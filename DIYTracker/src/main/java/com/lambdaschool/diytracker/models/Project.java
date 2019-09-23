package com.lambdaschool.diytracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project extends Auditable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    @Column(nullable = false)
    private String projectName;

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties("projects")
    private User user;

    public Project() {
    }

    public Project(String projectName, User user) {
        this.projectName = projectName;
        this.user = user;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", user=" + user +
                '}';
    }
}