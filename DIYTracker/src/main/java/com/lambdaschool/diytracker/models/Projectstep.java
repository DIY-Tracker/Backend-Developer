//package com.lambdaschool.diytracker.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "projectsteps")
//public class Projectstep extends Auditable
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long stepid;
//
//    private String photourl;
//
//    @Column(nullable = false)
//    private String stepname;
//
//    private String stepdescription;
//
//    @ManyToOne
//    @JoinColumn(name = "projectid",
//            nullable = false)
//    @JsonIgnoreProperties("projectsteps")
//    private Project project;
//
//    public Projectstep()
//    {
//    }
//
//    public Projectstep(String photourl, String stepname, String stepdescription, Project project)
//    {
//        this.photourl = photourl;
//        this.stepname = stepname;
//        this.stepdescription = stepdescription;
//        this.project = project;
//    }
//
//    public long getStepid()
//    {
//        return stepid;
//    }
//
//    public void setStepid(long stepid)
//    {
//        this.stepid = stepid;
//    }
//
//    public String getPhotourl()
//    {
//        return photourl;
//    }
//
//    public void setPhotourl(String photourl)
//    {
//        this.photourl = photourl;
//    }
//
//    public String getStepname()
//    {
//        return stepname;
//    }
//
//    public void setStepname(String stepname)
//    {
//        this.stepname = stepname;
//    }
//
//    public String getStepdescription()
//    {
//        return stepdescription;
//    }
//
//    public void setStepdescription(String stepdescription)
//    {
//        this.stepdescription = stepdescription;
//    }
//
//    public Project getProject()
//    {
//        return project;
//    }
//
//    public void setProject(Project project)
//    {
//        this.project = project;
//    }
//}
