package com.innercircle.command.config.http;

import com.innercircle.common.config.http.BaseExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackages = {
		"com.innercircle.command.interfaces"
})
public class GeneralExceptionHandler extends BaseExceptionHandler {

}
