package kr.footcoder.receipt.controller;

import kr.footcoder.receipt.domain.SignupParam;
import kr.footcoder.receipt.enumclass.ErrorCode;
import kr.footcoder.receipt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping(value = "/hello")
    public String hello() {

        return "hello world";
    }


    /**
     * 회원 가입
     */
    @PostMapping(value = "/sign-up")
    public ModelMap signupUser(@RequestBody SignupParam signupParam) {

        if(!userService.signupUser(signupParam)){
            return error(ErrorCode.ERR0002);
        }

        return success();
    }

}
