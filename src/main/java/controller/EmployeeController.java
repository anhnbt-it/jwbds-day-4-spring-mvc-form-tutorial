package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "employee/info";
    }
}
