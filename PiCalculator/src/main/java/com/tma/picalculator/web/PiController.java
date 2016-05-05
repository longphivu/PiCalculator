package com.tma.picalculator.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tma.picalculator.domain.PiModel;
import com.tma.picalculator.service.PiCalculatorService;
import com.tma.picalculator.web.exception.PiCalculatorException;

@Controller
public class PiController {

	@Autowired
	PiCalculatorService calService;

	@RequestMapping(value = "/pi")
	public String getPi(Model model) throws Exception {
		model.addAttribute("piModel", new PiModel());
		return "getPi";
	}

	@RequestMapping(value = "/pi/cal.do", method = RequestMethod.GET)
	public String getPi(@Valid @ModelAttribute("piModel") PiModel piModel,
			BindingResult bindingResult, Model model) throws Exception {

		if (bindingResult.hasErrors()) {
			model.addAttribute("errMsg", "Error in input");
			return "getPi";
		} else {
			calService.getPi(piModel);
		}
		return "getPi";
	}

	/**
	 * Handles PiCalculatorException
	 * @param e Thrown exception while processing PI
	 * @return binds error message and return to error page
	 */
	@ExceptionHandler(PiCalculatorException.class)
	public ModelAndView handleGetPiException(PiCalculatorException ex) {
	    ModelMap model = new ModelMap();
	    model.put("errMsg", ex.getMessage());
	    return new ModelAndView("getPi", model);
	}
}
