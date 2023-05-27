package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_remove_var_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_remove_var_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_remove_var_nobody.release();
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/general.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/home.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/feedback.css\" />\n");
      out.write("        <title>Login | CryptoWebWallet</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            .form-field {\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            label {\n");
      out.write("                margin: 30px 0 10px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .link {\n");
      out.write("                margin-top: 2vh;\n");
      out.write("                display: block;\n");
      out.write("                margin: 40px 0;\n");
      out.write("                padding: 10px 0;\n");
      out.write("                width: 100%;\n");
      out.write("                text-decoration: none;\n");
      out.write("                text-align: center;\n");
      out.write("                font-size: 1rem;\n");
      out.write("                background-color: #fff;\n");
      out.write("                color: #000;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 45px;\n");
      out.write("                box-shadow: 0 0 3px 3px rgba(0, 0, 0, .5);\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: .2s all linear;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input:not(input[type=\"submit\"]){\n");
      out.write("                padding: 10px 10px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                border: 1px solid #222;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .sign-up-container {\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: column;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: space-around;\n");
      out.write("                margin-top: 15vh;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #login {\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                margin-top: 2vh;\n");
      out.write("                padding: 10px 0;\n");
      out.write("                width: 40%;\n");
      out.write("                font-size: .9rem;\n");
      out.write("                transition: .2s all linear;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            #login:hover,\n");
      out.write("            .link:hover {\n");
      out.write("                background-color: #2c62fd;\n");
      out.write("                color: #fff;\n");
      out.write("                box-shadow: 0 0 3px 3px #2c62fd;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page-container\">\n");
      out.write("            <h1>Login</h1>\n");
      out.write("            \n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    \n");
      out.write("           <div class=\"welcome-div\">\n");
      out.write("                <div class=\"links-container\">\n");
      out.write("                    <form method=\"POST\" action=\"login\">\n");
      out.write("                        <div class=\"form-field\">\n");
      out.write("                            <label for=\"name\">Username</label>\n");
      out.write("                            <input id=\"name\" type=\"text\" name=\"username\" placeholder=\"Enter your username\" />\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-field\">\n");
      out.write("                            <label for=\"password\">Password</label>\n");
      out.write("                            <input id=\"password\" type=\"password\" name=\"password\" placeholder=\"Enter your password\" />\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <input class=\"link\" type=\"submit\" value=\"Login\" />\n");
      out.write("                    </form>\n");
      out.write("                    <div class='sign-up-container'>\n");
      out.write("                        <span>Don't have an account?</span>\n");
      out.write("                        <a href=\"signup.jsp\" id=\"login\">Sign up</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("                    \n");
      out.write("        <script>\n");
      out.write("            const cancelButton = document.querySelector(\"button#cancel-button\");\n");
      out.write("            if(cancelButton !== null)\n");
      out.write("            {\n");
      out.write("                cancelButton.onclick = () => {\n");
      out.write("                    document.querySelector(\"div.feedback\").style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty feedback}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                <div class=\"feedback ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${feedback.type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">\n");
        out.write("                    <span class=\"content\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${feedback.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                    <button id=\"cancel-button\">X</button>\n");
        out.write("                </div>\n");
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_remove_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_remove_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:remove
    org.apache.taglibs.standard.tag.common.core.RemoveTag _jspx_th_c_remove_0 = (org.apache.taglibs.standard.tag.common.core.RemoveTag) _jspx_tagPool_c_remove_var_nobody.get(org.apache.taglibs.standard.tag.common.core.RemoveTag.class);
    _jspx_th_c_remove_0.setPageContext(_jspx_page_context);
    _jspx_th_c_remove_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_remove_0.setVar("feedback");
    int _jspx_eval_c_remove_0 = _jspx_th_c_remove_0.doStartTag();
    if (_jspx_th_c_remove_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
      return true;
    }
    _jspx_tagPool_c_remove_var_nobody.reuse(_jspx_th_c_remove_0);
    return false;
  }
}
