package com.example.demo.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Import correct Model interface
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.LeaveBalanceDTO;
import com.example.demo.dto.LeaveDTO;
import com.example.demo.models.Employees;
import com.example.demo.models.Leaves;
import com.example.demo.repos.EmployeeRepo;
import com.example.demo.service.EmployeeServiceImpl;
import com.example.demo.service.LeavesServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class LeaveManagementControllers {
	
	@Autowired
	private  EmployeeServiceImpl employeeServiceImpl ;
	
	@Autowired
	private AuthenticationManager authenticationManager;


    @Autowired
    private LeavesServiceImpl leaveService; // Assuming you have a service layer

    @GetMapping("/leaveRequest")
    public String showLeaveRequestForm(Model model) {
        model.addAttribute("leave", new LeaveDTO()); // Prepare a new LeaveDTO object for the form
        return "views/leavemanagement/LeaveRequestForm"; // Assuming a view named leaveRequestForm exists
    }

    @PostMapping("/submitLeaveRequest")
    public String submitLeave(@ModelAttribute("leave") LeaveDTO leaveDTO, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String authenticatedEmployeeId = auth.getName(); // Assuming authenticated user's username is the employeeId
        
        try {
            leaveService.addLeaves(authenticatedEmployeeId, leaveDTO);
            model.addAttribute("success", "Leave added successfully");
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
        } catch (Exception e) {
            model.addAttribute("error", "Error adding leave: " + e.getMessage());
        }

        return "views/leavemanagement/LeaveRequestForm";
    }

    @GetMapping("/pending")
    @PreAuthorize("hasRole('HR') or hasRole('ADMIN')")
    public String viewPendingLeaves(Model model) {
        List<LeaveDTO> pendingLeaves = leaveService.getPendingLeaves();
        model.addAttribute("pendingLeaves", pendingLeaves);
        return "views/leavemanagement/pendingLeaves";
    }

    @PostMapping("/approve/{employeeId}")
    @PreAuthorize("hasRole('HR') or hasRole('ADMIN')")
    public String approveLeave(@PathVariable("employeeId") String employeeId, 
                               @RequestParam("leaveId") Integer leaveId) {
        if (leaveId == null) {
            System.out.println("leaveId is null!");
        } else {
            System.out.println("Approving leave for Employee ID: " + employeeId + ", Leave ID: " + leaveId);
        }
        leaveService.approveLeave(leaveId);
        return "redirect:/pending";
    }

    @PostMapping("/deny/{employeeId}")
    @PreAuthorize("hasRole('HR') or hasRole('ADMIN')")
    public String denyLeave(@PathVariable("employeeId") String employeeId, 
                            @RequestParam("leaveId") Integer leaveId, 
                            @RequestParam("denyReason") String denyReason) {
        if (leaveId == null) {
            System.out.println("leaveId is null!");
        } else {
            System.out.println("Denying leave for Employee ID: " + employeeId + ", Leave ID: " + leaveId + ", Reason: " + denyReason);
        }
        leaveService.denyLeave(leaveId, denyReason);
        return "redirect:/pending";
    }

    
    
    
    @GetMapping("/myleaves")
    public String viewMyLeaves(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String employeeId = ((UserDetails) auth.getPrincipal()).getUsername();
        
        List<LeaveDTO> myLeaves = leaveService.getMyLeaves(employeeId);
        model.addAttribute("myLeaves", myLeaves);
        
        return "views/leavemanagement/MyLeaves";
    }

    @GetMapping("/balance")
    public String viewLeaveBalance(Model model) {
        // Get the authenticated user's details
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String employeeId = ((UserDetails) auth.getPrincipal()).getUsername();

        // Fetch the leave balance for the employee
        LeaveBalanceDTO leaveBalance = leaveService.getLeaveBalance(employeeId);
        
        model.addAttribute("leaveBalance", leaveBalance);

        // Return the view name
        return "views/leavemanagement/MyLeaveBalance";
    }
    
    
    
    @GetMapping("/employees/on-leave")
    @PreAuthorize("hasRole('HR') or hasRole('ADMIN')")
    public String viewAbsentEmployees(Model model) {
        List<LeaveDTO> employees = leaveService.employeeOnleave();
        model.addAttribute("employees", employees);
        return "views/leaveMangement/employeesonLeaveToday";
    }
    
    @GetMapping("/deleteLeave/{leaveId}")
    public String deleteLeave(@PathVariable Integer leaveId) {
        leaveService.deleteLeave(leaveId);
        return "redirect:/myleaves";
    }

}
