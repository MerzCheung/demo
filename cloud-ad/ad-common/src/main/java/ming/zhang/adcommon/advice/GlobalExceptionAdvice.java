package ming.zhang.adcommon.advice;

import ming.zhang.adcommon.exception.AdException;
import ming.zhang.adcommon.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author merz
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest request, AdException ex) {
        CommonResponse<String> response = new CommonResponse<>(-1, "");
        response.setData(ex.getMessage());
        return response;
    }
}
