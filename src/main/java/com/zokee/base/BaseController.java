/*
 * Power by www.xiaoi.com
 */
package com.zokee.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Mar 11, 2015 9:50:15 AM
 * @version 1.0
 */
public class BaseController {
	
	/**
	 * 输出json
	 * @param response
	 * @param json
	 */
	public void writeJson(HttpServletResponse response, Object json){
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
