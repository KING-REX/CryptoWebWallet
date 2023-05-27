package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sendTokens_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/general.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/home.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/feedback.css\" />\n");
      out.write("        <title>Send Tokens | CryptoWebWallet</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            .action-form {\n");
      out.write("                padding: 20px 5px 10px;\n");
      out.write("                border: 2px solid #000;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .info-div {\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .info-div button {\n");
      out.write("                display: flex;\n");
      out.write("                flex-direction: row;\n");
      out.write("                align-items: center;\n");
      out.write("                padding: 10px;\n");
      out.write("                width: 100%;\n");
      out.write("                background-color: #fff;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                border: 1px solid #000;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .info-div button span {\n");
      out.write("                color: #000;\n");
      out.write("                font-weight: bold;\n");
      out.write("                font-size: 1rem;\n");
      out.write("                letter-spacing: .2rem;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .img-container {\n");
      out.write("                margin-right: 15px;\n");
      out.write("                height: 22px;\n");
      out.write("                width: 22px;\n");
      out.write("                border: 1px solid #222;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                padding: 0;\n");
      out.write("                background-color: #000;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .img-container img {\n");
      out.write("                width: 100%;\n");
      out.write("                border-radius: 60px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=\"text\"] {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 10px;\n");
      out.write("                border: 1px solid #000;\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=\"submit\"] {\n");
      out.write("                margin-top: 30px;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 35px;\n");
      out.write("                \n");
      out.write("                color: #fff;\n");
      out.write("                background-color: #2c62fd;\n");
      out.write("                \n");
      out.write("                font-weight: bold;\n");
      out.write("                \n");
      out.write("                border: 1px solid #000;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                \n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            input[type=\"submit\"]:disabled {\n");
      out.write("                background-color: #bbbdc2;\n");
      out.write("                cursor: auto;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page-container\">\n");
      out.write("            <h1><i class=\"fas fa-angle-left\"></i>Transfer</h1>  \n");
      out.write("            \n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            \n");
      out.write("            ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("                        \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            const cancelButton = document.querySelector(\"button#cancel-button\");\n");
      out.write("            if(cancelButton !== null)\n");
      out.write("            {\n");
      out.write("                cancelButton.onclick = () => {\n");
      out.write("                    document.querySelector(\"div.feedback\").style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            let isValidAddress = false;\n");
      out.write("            let isValidAmount = false;\n");
      out.write("            \n");
      out.write("            const receivingAccount = document.getElementById(\"receiving-account\");\n");
      out.write("            const amountInput = document.getElementById(\"amount-input\");\n");
      out.write("            \n");
      out.write("            const submit = document.getElementById(\"submit-input\");\n");
      out.write("            \n");
      out.write("            if(receivingAccount !== null)\n");
      out.write("            {\n");
      out.write("                receivingAccount.oninput = () => {\n");
      out.write("                    const input = document.getElementById(\"address-format\");\n");
      out.write("                    console.log(\"Regex: \" + input.value);\n");
      out.write("                    let regex = new RegExp(input.value);\n");
      out.write("\n");
      out.write("                    if(receivingAccount.value.match(regex))\n");
      out.write("                        isValidAddress = true;\n");
      out.write("                    \n");
      out.write("                    if(isValidAddress && isValidAmount)\n");
      out.write("                        submit.disabled = false;\n");
      out.write("                    else\n");
      out.write("                        submit.disabled = true;\n");
      out.write("                }\n");
      out.write("            }    \n");
      out.write("            \n");
      out.write("            if(amountInput !== null)\n");
      out.write("            {\n");
      out.write("                amountInput.oninput = () => {\n");
      out.write("                    if(!isNaN(amountInput.value) && amountInput.value.length !== 0)\n");
      out.write("                        isValidAmount = true;\n");
      out.write("                    \n");
      out.write("                    if(isValidAddress && isValidAmount)\n");
      out.write("                        submit.disabled = false;\n");
      out.write("                    else\n");
      out.write("                        submit.disabled = true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty currentAddress}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <form method=\"POST\" action=\"send-tokens\" class=\"action-form\">\n");
        out.write("                        <div class=\"info-div\">\n");
        out.write("                            <h3>Transfer account</h3>\n");
        out.write("                            <input disabled name=\"transferAccount\" type=\"text\" value='");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("' />\n");
        out.write("                        </div>\n");
        out.write("                        <div class=\"info-div\">\n");
        out.write("                            <h3>Receiving account</h3>\n");
        out.write("                            <input hidden id='address-format' value='");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tokenSelected.parentChain.chain.addressFormat}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("' />\n");
        out.write("                            <input id='receiving-account' name=\"receivingAccount\" type=\"text\" />\n");
        out.write("                        </div>\n");
        out.write("                        <div class=\"info-div\">\n");
        out.write("                            <h3>Token transferred</h3>\n");
        out.write("                            <button disabled name='tokenTransferred'>\n");
        out.write("                                <div class='img-container'>\n");
        out.write("                                    <img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tokenSelected.imagePath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" />\n");
        out.write("                                </div>\n");
        out.write("                                <span>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tokenSelected.symbol}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                            </button>\n");
        out.write("                        </div>\n");
        out.write("                        <div class=\"info-div\">\n");
        out.write("                            <h3>Balance</h3>\n");
        out.write("                            <input id='amount-input' name=\"amount\" type=\"text\" placeholder=\"0.00\" />\n");
        out.write("                        </div>\n");
        out.write("                        \n");
        out.write("\n");
        out.write("                        <input id='submit-input' disabled type=\"submit\" value=\"Send\" />\n");
        out.write("                    </form>\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
