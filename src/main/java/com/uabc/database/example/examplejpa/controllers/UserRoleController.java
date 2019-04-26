package com.uabc.database.example.examplejpa.controllers;

import com.uabc.database.example.examplejpa.constant.ViewConstant;
import com.uabc.database.example.examplejpa.model.UserRoleModel;
import com.uabc.database.example.examplejpa.services.UserRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userRoles")
public class UserRoleController {

    @Autowired
    @Qualifier("userRoleServiceImpl")
    private UserRoleService userRoleService;

    private static final Log log = LogFactory.getLog(UserRoleController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/userRoles/showUserRoles";
    }
    @GetMapping("/userRoleForm")
    public String redirectUserRoleForm(Model model, @RequestParam(name = "id", required = false) int id) {
        UserRoleModel userRoleModel = new UserRoleModel();
        if (id != 0)
            userRoleModel = userRoleService.findUserRoleByIdModel(id);
        model.addAttribute("userRoleModel",userRoleModel);
        return ViewConstant.USERROLE_FORM;
    }

    @PostMapping("/adduserrole")
    public String addUserRole(@ModelAttribute(name = "userRoleModel") UserRoleModel userRoleModel, Model model) {
        log.info("Method: addUserRole() -- Params: "+ userRoleModel.toString());
        if(userRoleService.addUserRole(userRoleModel) != null)
            model.addAttribute("result",1);
        else
            model.addAttribute("result",0);
        return "redirect:/userRoles/showUserRoles";
    }

    @GetMapping("/showUserRoles")
    public ModelAndView showUserRoles() {
        ModelAndView mav = new ModelAndView(ViewConstant.USERROLES);
        mav.addObject("userRoles",userRoleService.listAllUserRoles());
        return mav;
    }

    @GetMapping("/removeUserRole")
    public ModelAndView removeUserRole(@RequestParam(name = "id", required = true)int id) {
        userRoleService.removeUserRole(id);
        return showUserRoles();
    }
}
