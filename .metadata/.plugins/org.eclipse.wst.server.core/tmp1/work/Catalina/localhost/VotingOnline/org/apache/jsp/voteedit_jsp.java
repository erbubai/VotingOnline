/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2019-12-21 07:22:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class voteedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>VotingOnline</title>\r\n");
      out.write("    <meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi\" />\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/font.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/xadmin.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"./lib/layui/layui.js\" charset=\"utf-8\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"./js/xadmin.js\"></script>\r\n");
      out.write("    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://cdn.staticfile.org/html5shiv/r29/html5.min.js\"></script>\r\n");
      out.write("      <script src=\"https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	String title=request.getParameter("title");
    title=new String(title.getBytes("ISO-8859-1"),"UTF-8");
	
	String name=request.getParameter("name");
	name=new String(name.getBytes("ISO-8859-1"),"UTF-8");	

      out.write("\r\n");
      out.write("    <div class=\"x-body\">\r\n");
      out.write("        <form class=\"layui-form\" action=\"VoteEditServlet\" method=\"post\">\r\n");
      out.write("        <div class=\"layui-form-item\">\r\n");
      out.write("              <label for=\"L_id\" class=\"layui-form-label\">\r\n");
      out.write("                  <span class=\"x-red\">*</span>序号</label>\r\n");
      out.write("              <div class=\"layui-input-inline\">\r\n");
      out.write("                  <input type=\"text\" id=\"L_id\" name=\"id\" disabled=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" lay-verify=\"id\"\r\n");
      out.write("                  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"layui-form-item\">\r\n");
      out.write("              <label for=\"L_title\" class=\"layui-form-label\">\r\n");
      out.write("                  <span class=\"x-red\">*</span>投票主题</label>\r\n");
      out.write("              <div class=\"layui-input-inline\">\r\n");
      out.write("                  <input type=\"text\" id=\"L_title\" name=\"title\" required=\"\" value=\"");
      out.print(title);
      out.write("\" lay-verify=\"title\"\r\n");
      out.write("                  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"layui-form-item\">\r\n");
      out.write("              <label for=\"L_name\" class=\"layui-form-label\">\r\n");
      out.write("                  <span class=\"x-red\">*</span>作者\r\n");
      out.write("              </label>\r\n");
      out.write("              <div class=\"layui-input-inline\">\r\n");
      out.write("                  <input type=\"text\" id=\"L_name\" name=\"name\" required=\"\" value=\"");
      out.print(name);
      out.write("\" lay-verify=\"name\"\r\n");
      out.write("                  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"layui-form-item\">\r\n");
      out.write("              <label for=\"L_number\" class=\"layui-form-label\">\r\n");
      out.write("                  <span class=\"x-red\">*</span>目前投票数\r\n");
      out.write("              </label>\r\n");
      out.write("              <div class=\"layui-input-inline\">\r\n");
      out.write("                  <input type=\"text\" id=\"L_number\" name=\"number\" disabled=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.number}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" lay-verify=\"number\"\r\n");
      out.write("                  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"layui-form-item\">\r\n");
      out.write("              <label for=\"L_time\" class=\"layui-form-label\">\r\n");
      out.write("                  <span class=\"x-red\">*</span>发布时间\r\n");
      out.write("              </label>\r\n");
      out.write("              <div class=\"layui-input-inline\">\r\n");
      out.write("                  <input type=\"text\" id=\"L_time\" name=\"time\" disabled=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${param.time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" lay-verify=\"time\"\r\n");
      out.write("                  autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"layui-form-item\">\r\n");
      out.write("              <label for=\"L_time\" class=\"layui-form-label\">\r\n");
      out.write("              </label>\r\n");
      out.write("              <button  class=\"layui-btn\" type=\"button\" onclick=\"save()\">修改</button>\r\n");
      out.write("          </div>\r\n");
      out.write("       </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script>\r\n");
      out.write("\tfunction save(){\r\n");
      out.write("\t\tvar $id=$('#L_id').val();\r\n");
      out.write("\t\tvar $title=$('#L_title').val();\r\n");
      out.write("\t\tvar $name=$('#L_name').val();\r\n");
      out.write("\t\tif($title == \"\")\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\talert(\"请输入新的投票主题!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t    else if($name == \"\")\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\talert(\"请输入新的作者!\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\t$.post(\r\n");
      out.write("\t\t\t\"/VotingOnline/VoteEditServlet\",\r\n");
      out.write("\t\t\t\"id=\"+$id+\"&title=\"+$title+\"&name=\"+$name,\r\n");
      out.write("\t\t\tfunction(result){\r\n");
      out.write("\t\t\t\tif(result=='success')\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\talert(\"修改成功!\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\tif(result=='error')\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\talert(\"投票主题重复!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\t\"text\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
