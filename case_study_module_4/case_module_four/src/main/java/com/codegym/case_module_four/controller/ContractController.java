package com.codegym.case_module_four.controller;


import com.codegym.case_module_four.model.contract.Contract;
import com.codegym.case_module_four.model.service.Services;
import com.codegym.case_module_four.service.contract.IAttachServiceService;
import com.codegym.case_module_four.service.contract.IContractDetailService;
import com.codegym.case_module_four.service.contract.IContractService;
import com.codegym.case_module_four.service.customer.ICustomerService;
import com.codegym.case_module_four.service.employee.IEmployeeService;
import com.codegym.case_module_four.service.service.IRentalTypeService;
import com.codegym.case_module_four.service.service.IServiceService;
import com.codegym.case_module_four.service.service.IServiceTypeService;
import com.codegym.case_module_four.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachServiceService iAttachServiceService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IServiceService iServiceService;

    @GetMapping
    public String List(Model model,  Principal principal){
        List<Contract> contractList = iContractService.getAll();
        model.addAttribute("contractList", contractList);

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "contract/list";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model,Principal principal) {
        Contract contract = iContractService.findById(id);
        model.addAttribute("contract", contract);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "contract/view";
    }

    @GetMapping("/create")
    public String create(Model model,Principal principal) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("customerList",iCustomerService.getAll());
        model.addAttribute("employeeList",iEmployeeService.getAll());
        model.addAttribute("servicesList",iServiceService.getAll());

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "contract/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("contract") Contract contract,
                       BindingResult bindingResult,Model model,
                       RedirectAttributes redirectAttributes,Principal principal) {

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        new Contract().validate(contract,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customerList",iCustomerService.getAll());
            model.addAttribute("employeeList",iEmployeeService.getAll());
            model.addAttribute("servicesList",iServiceService.getAll());
            return "contract/create";

        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iContractService.save(contract);
        return "redirect:/contract";
    }

    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable(name = "id") Integer id, Model model,Principal principal) {

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        model.addAttribute("contract", iContractService.findById(id));
        return "contract/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("contract") Contract contract,
                         RedirectAttributes redirectAttributes,Model model,Principal principal) {

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        iContractService.remove(contract.getId());
        redirectAttributes.addFlashAttribute("message", "Removed  successfully!");
        return "redirect:/contract";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model,Principal principal) {
        model.addAttribute("contract", iContractService.findById(id));
        model.addAttribute("customerList",iCustomerService.getAll());
        model.addAttribute("employeeList",iEmployeeService.getAll());
        model.addAttribute("servicesList",iServiceService.getAll());

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);


        return "contract/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("contract") Contract contract,BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes,Principal principal) {
        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);


        if (bindingResult.hasErrors()){
            model.addAttribute("customerList",iCustomerService.getAll());
            model.addAttribute("employeeList",iEmployeeService.getAll());
            model.addAttribute("servicesList",iServiceService.getAll());
            return "contract/edit";

        }
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/contract";
    }

}
