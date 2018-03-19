package controller;

import model.Lift;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CalculatorService;

import java.util.List;

@RestController
class CalculatorController {

    private CalculatorService service;

    @Autowired
    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void create(@RequestBody List<Lift> lifts) {
        Preconditions.checkNotNull(lifts);
        service.calculateWilksScore(lifts);
    }

}


