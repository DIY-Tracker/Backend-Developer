//package com.lambdaschool.diytracker.services;
//
//import com.lambdaschool.diytracker.exceptions.ResourceNotFoundException;
//import com.lambdaschool.diytracker.models.Projectstep;
//import com.lambdaschool.diytracker.repository.ProjectstepRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProjectstepServiceImpl implements ProjectstepService
//{
//    @Autowired
//    private ProjectstepRepository projectsteprepos;
//
//    @Override
//    public Projectstep findProjectstepById(long id)
//    {
//        return projectsteprepos.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Project Step with id " + id + " Not Found!"));
//    }
//
//    @Override
//    public void delete(long id)
//    {
//        if (projectsteprepos.findById(id).isPresent())
//        {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if (projectsteprepos.findById(id).get().getProject().getUsername().equalsIgnoreCase(authentication.getName()))
//
//            {
//                projectsteprepos.deleteById(id);
//            } else
//            {
//                throw new ResourceNotFoundException(authentication.getName() + " not authorized to make change");
//            }
//        } else
//        {
//            throw new ResourceNotFoundException("Useremail with id " + id + " Not Found!");
//        }
//
//    }
//
//    @Override
//    public Projectstep save(Projectstep projectstep)
//    {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (projectstep.getProject().getUsername().equalsIgnoreCase(authentication.getName()))
//        {
//            return projectsteprepos.save(projectstep);
//        } else
//        {
//            throw new ResourceNotFoundException((authentication.getName() + "not authorized to make change"));
//        }
//    }
//
//    @Override
//    public Projectstep update(Projectstep projectstep, long id)
//    {
//        Authentication authentication = SecurityContextHolder.getContext()
//                .getAuthentication();
//
//        Projectstep currentStep = projectsteprepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project Step with id " + id + " Not Found!"));
//
//
//            if (projectsteprepos.findById(id).get().getProject().getUsername().equalsIgnoreCase(authentication.getName()))
//            {
//                if (projectstep.getPhotourl()!= null)
//                {
//                    currentStep.setPhotourl(projectstep.getPhotourl());
//                }
//
//                if (projectstep.getStepname() != null)
//                {
//                    currentStep.setStepname(projectstep.getStepname());
//                }
//
//                if (projectstep.getStepdescription() != null)
//                {
//                    currentStep.setStepdescription(projectstep.getStepdescription());
//                }
//
//            return projectsteprepos.save(currentStep);
//        } else
//        {
//            throw new ResourceNotFoundException(id + " Not current user");
//        }
//    }
//}
