package by.bsu.hachaton.controllers;

import by.bsu.hachaton.DTO.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class MainPageController {

    @GetMapping(value = "/page")
    public String showMainPage(Model model) {
//        List<Request> requests = new ArrayList<>();//stub; remove with service's method
//        Request request = new Request("RequestA", "somePhotoURL", 27.55, 54.0, "lorem ipsum", 1.0, "underWork");
//        requests.add(request);
//        model.addAttribute("requests", requests);
        return "page";
    }
}
