package util;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;

public class HTMLUtil {
	public static void sendMsg(JspWriter out, String msg) throws IOException {
		out.print("<script> alert('" + msg + "') </script>");
	}
	
	public static void sendBackMsg(JspWriter out, String msg) throws IOException {
		out.print("<script> history.back(); alert('" + msg + "') </script>");
	}
}
