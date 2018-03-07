//package com.gome.meidian.sessionshare.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.gome.meidian.account.shiro.EncryptUtils;
//import com.gome.meidian.common.exception.ServiceException;
//import com.gome.meidian.companyapi.service.CompanyUpdateService;
//import com.gome.meidian.companyapi.vo.UserVo;
//import com.gome.meidian.restfulcommon.reponse.ResponseJson;
//
//
//@RestController
//@RequestMapping("/register/v1")
//public class RegisterController {
//
//	@RequestMapping(value = "/addUser", method=RequestMethod.GET)
//	public ResponseJson addUser(@RequestParam("accountName") String accountName, @RequestParam("password") String password) throws ServiceException{
//		String salt = EncryptUtils.randomSalt();
//		String pwd = EncryptUtils.encode(password, salt);
//		
//		UserVo userVo = new UserVo();
//		userVo.setAccountName(accountName);
//		userVo.setPassword(pwd);
//		userVo.setSalt(salt);
//		companyUpdateService.add(userVo);
//		
//		ResponseJson responseJson = new ResponseJson();
//		return responseJson;
//	}
//}
