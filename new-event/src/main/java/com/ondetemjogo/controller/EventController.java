package com.ondetemjogo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ondetemjogo.business.EventService;
import com.ondetemjogo.dto.ErrorDTO;
import com.ondetemjogo.dto.EventDTO;
import com.ondetemjogo.util.DateUtil;

@RestController
@RequestMapping("/api/v1")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/event", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public void newEvent(@Valid @RequestBody EventDTO eventDTO) throws BindException {
		if (eventDTO.getDate().before(DateUtil.resetHour(new Date()))) {
			BeanPropertyBindingResult errors = new BeanPropertyBindingResult(eventDTO, "eventDTO");
			errors.rejectValue("date", null, "date cannot be in past");
			throw new BindException(errors);
		}
		
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public List<ErrorDTO> handleException(BindException ex, HttpServletRequest request) {
	    ArrayList<ErrorDTO> errors = new ArrayList<ErrorDTO>();
	    for (FieldError oe : ex.getFieldErrors()) {
	    	ErrorDTO error = new ErrorDTO();
	    	error.setField(oe.getField());
	    	error.setRejectedValue(oe.getRejectedValue());
	    	error.setError(oe.getDefaultMessage());
	    	errors.add(error);
	    }
		return errors;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public List<ErrorDTO> handleException(MethodArgumentNotValidException ex, HttpServletRequest request) {
	    ArrayList<ErrorDTO> errors = new ArrayList<ErrorDTO>();
	    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
	    	ErrorDTO error = new ErrorDTO();
	    	error.setField(fieldError.getField());
	    	error.setRejectedValue(fieldError.getRejectedValue());
	    	error.setError(fieldError.getDefaultMessage());
	    	errors.add(error);
	    }
		return errors;
	}
}
