package com.codegym.case_module_four.controller;


import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.repository.customer.ICustomerTypeRepository;
import com.codegym.case_module_four.service.customer.ICustomerService;
import com.codegym.case_module_four.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

//    @GetMapping
//    public String List(Model model){
//        List<Customer> customerList = iCustomerService.getAll();
//        model.addAttribute("customerList", customerList);
//        return "customer/list";
//    }


    @GetMapping
    public String ListPage(Model model, @RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           Principal principal) {


                Sort sort = Sort.by("name").ascending().and(Sort.by("id"));
                Page<Customer> customerList = iCustomerService.findAll(PageRequest.of(page, 3,sort));
                model.addAttribute("customerList", customerList);


        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "customer/list";
    }

    @GetMapping("/sort")
    public String SortPage(Model model,
                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                           Principal principal) {
        Sort sort = Sort.by("codeNumber").ascending();
        Page<Customer> customerList = iCustomerService.findAll(PageRequest.of(page, 2,sort));
        model.addAttribute("customerList", customerList);

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "customer/list";
    }



    @GetMapping("{id}/view")
    public String view(@PathVariable("id") Integer id, Model model,Principal principal) {
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer", customer);

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "customer/view";
    }

    @GetMapping("/create")
    public String create(Model model,Principal principal) {
        String[] genderList = {"Male", "Female"};
        model.addAttribute("customer", new Customer());
        model.addAttribute("genderList", genderList);
        model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "customer/create";
    }

    
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customer") Customer customer,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes,Principal principal) {

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        // dùng với cách implements Validator
        new Customer().validate(customer, bindingResult);


        if (bindingResult.hasErrors()) {
            String[] genderList = {"Male", "Female"};
            model.addAttribute("genderList", genderList);
            model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
            return "customer/create";
        }
        redirectAttributes.addFlashAttribute("message", "Create success");
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

//    @GetMapping("/delete")
//    public String showDelete(@RequestParam(name = "id") Integer id, Model model) {
//        model.addAttribute("customer", iCustomerService.findById(id));
//        return "customer/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
//        iCustomerService.remove(customer.getId());
//        redirectAttributes.addFlashAttribute("message", "Removed product successfully!");
//        return "redirect:/customer";
//    }

    @GetMapping("/delete")
    public String showDelete(@RequestParam(name = "id") Integer id,
                             Model model,RedirectAttributes redirectAttributes,Principal principal) {

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Removed  successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit_param")
    public String showEditParam(@RequestParam(name = "id") Integer id, Model model,Principal principal) {

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        model.addAttribute("customer", iCustomerService.findById(id));
        model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
        String[] genderList = {"Male", "Female"};
        model.addAttribute("genderList", genderList);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("customer") Customer customer,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes,Principal principal) throws Exception {

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customer", customer);
            model.addAttribute("customerTypeList", iCustomerTypeRepository.findAll());
            String[] genderList = {"Male", "Female"};
            model.addAttribute("genderList", genderList);
            return "customer/edit";
        }
//        if (customer == null){
//            throw new Exception();
//        }
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit success");
        return "redirect:/customer";
    }


    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name,
                         @RequestParam(name = "code") String code,
                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                         Model model,Principal principal) {

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        if (name != null ){
            if (code != null){
                model.addAttribute("customerList",iCustomerService.findByNameTwo(name,code));

                return "customer/search_list";
            }else {
                model.addAttribute("customerList",iCustomerService.findByCode(code));
                return "customer/search_list";
            }
        }else {
            model.addAttribute("customerList",iCustomerService.findByName(name));
            return "customer/search_list";
        }

    }
//
//    @ExceptionHandler(Exception.class)
//    public String handleException() {
//        return "/customer/exception";
//    }

}
