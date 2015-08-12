/*
 * Power by www.xiaoi.com
 */
package com.zokee.vender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zokee.base.BaseController;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 21, 2015 1:24:58 PM
 * @version 1.0
 */
@Controller
@RequestMapping("/vender")
public class VenderController extends BaseController {

	@RequestMapping("/view")
	public String view(){
		return "vender/view";
	}
}
