package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewSelectedWallet_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_currencySymbol;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_g_forEach_varStatus_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_g_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_currencySymbol = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_g_forEach_varStatus_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_g_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_currencySymbol.release();
    _jspx_tagPool_g_forEach_varStatus_var_items.release();
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed.release();
    _jspx_tagPool_g_if_test.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/general.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/home2.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/viewselectedwallet.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"fontawesome-free-5.15.4-web/css/all.min.css\" />\n");
      out.write("        <title>View Selected Wallet | CryptoWebWallet</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page-container\">\n");
      out.write("            \n");
      out.write("            <nav class=\"menu-bar\">\n");
      out.write("                ");
      if (_jspx_meth_g_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                \n");
      out.write("                <div class=\"secondary-div\">\n");
      out.write("                    <a id=\"add-wallet\" href=\"addWallet.jsp\">Add Wallet</a>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"overview\">\n");
      out.write("                <div class=\"content-container\">\n");
      out.write("                    ");
      if (_jspx_meth_g_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class='action-container'>\n");
      out.write("                <form class='action-form' method='POST' action='send-receive'>\n");
      out.write("                    <button id='send-tokens' class=\"action-button\" name='send-receive' value='sendTokens'>\n");
      out.write("                        <span class='icon'><i class=\"fas fa-plus\"></i></span>\n");
      out.write("                        <span class='text'>Send</span>\n");
      out.write("                    </button>\n");
      out.write("                    <button id='receive-tokens' class=\"action-button\" name='send-receive' value='receiveTokens'>\n");
      out.write("                        <span class='icon'><i class=\"fas fa-minus\"></i></span>\n");
      out.write("                        <span class='text'>Receive</span>\n");
      out.write("                    </button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <div class=\"transactions\">\n");
      out.write("                <h4>Transactions</h4>\n");
      out.write("                ");
      if (_jspx_meth_g_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <form action=\"logout\" method=\"POST\" class=\"logout-form\">\n");
      out.write("                <input id=\"logout-button\" type=\"submit\" value=\"Logout\" />\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("                                \n");
      out.write("        <script src=\"fontawesome-free-5.15.4-web/js/all.min.js\"></script>\n");
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

  private boolean _jspx_meth_g_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  g:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_g_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_g_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_g_if_0.setPageContext(_jspx_page_context);
    _jspx_th_g_if_0.setParent(null);
    _jspx_th_g_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty currentAddress}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_g_if_0 = _jspx_th_g_if_0.doStartTag();
    if (_jspx_eval_g_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"primary-div\">\n");
        out.write("                        <a href=\"remove-address\">\n");
        out.write("                            <h1><i class=\"fas fa-angle-left\"></i> Back</h1>\n");
        out.write("                        </a>\n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_g_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_g_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_0);
      return true;
    }
    _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_0);
    return false;
  }

  private boolean _jspx_meth_g_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  g:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_g_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_g_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_g_if_1.setPageContext(_jspx_page_context);
    _jspx_th_g_if_1.setParent(null);
    _jspx_th_g_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty currentAddress}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_g_if_1 = _jspx_th_g_if_1.doStartTag();
    if (_jspx_eval_g_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                        <span class=\"address\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                            \n");
        out.write("                        <div class=\"wallet-balance\">\n");
        out.write("                            <div class='img-container center'>\n");
        out.write("                                <img src='");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${tokenSelected.imagePath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("' />\n");
        out.write("                            </div>\n");
        out.write("                            <span class=\"balance1 center\">\n");
        out.write("                                ");
        if (_jspx_meth_fmt_formatNumber_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_g_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentAddress.parentChain.nativeToken.symbol}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                            </span>\n");
        out.write("                            <span class=\"balance2 center\">\n");
        out.write("                                ");
        if (_jspx_meth_fmt_formatNumber_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_g_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                            </span>\n");
        out.write("                        </div>\n");
        out.write("                    ");
        int evalDoAfterBody = _jspx_th_g_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_g_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_1);
      return true;
    }
    _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_1);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_0(javax.servlet.jsp.tagext.JspTag _jspx_th_g_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_0.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_g_if_1);
    _jspx_th_fmt_formatNumber_0.setMaxFractionDigits(5);
    _jspx_th_fmt_formatNumber_0.setMinFractionDigits(2);
    _jspx_th_fmt_formatNumber_0.setType("number");
    _jspx_th_fmt_formatNumber_0.setGroupingUsed(true);
    _jspx_th_fmt_formatNumber_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalAddressBalanceInNT}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_0 = _jspx_th_fmt_formatNumber_0.doStartTag();
    if (_jspx_eval_fmt_formatNumber_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_fmt_formatNumber_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_fmt_formatNumber_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_fmt_formatNumber_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_fmt_formatNumber_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_fmt_formatNumber_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_fmt_formatNumber_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed.reuse(_jspx_th_fmt_formatNumber_0);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed.reuse(_jspx_th_fmt_formatNumber_0);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_1(javax.servlet.jsp.tagext.JspTag _jspx_th_g_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_currencySymbol.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_1.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_g_if_1);
    _jspx_th_fmt_formatNumber_1.setCurrencySymbol("$");
    _jspx_th_fmt_formatNumber_1.setMaxFractionDigits(3);
    _jspx_th_fmt_formatNumber_1.setMinFractionDigits(2);
    _jspx_th_fmt_formatNumber_1.setType("currency");
    _jspx_th_fmt_formatNumber_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalAddressBalanceInUSD}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_1 = _jspx_th_fmt_formatNumber_1.doStartTag();
    if (_jspx_eval_fmt_formatNumber_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_fmt_formatNumber_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_fmt_formatNumber_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_fmt_formatNumber_1.doInitBody();
      }
      do {
        out.write("    \n");
        out.write("                                ");
        int evalDoAfterBody = _jspx_th_fmt_formatNumber_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_fmt_formatNumber_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
    }
    if (_jspx_th_fmt_formatNumber_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_currencySymbol.reuse(_jspx_th_fmt_formatNumber_1);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_currencySymbol.reuse(_jspx_th_fmt_formatNumber_1);
    return false;
  }

  private boolean _jspx_meth_g_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  g:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_g_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_g_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_g_if_2.setPageContext(_jspx_page_context);
    _jspx_th_g_if_2.setParent(null);
    _jspx_th_g_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty transactions}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_g_if_2 = _jspx_th_g_if_2.doStartTag();
    if (_jspx_eval_g_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"transactions-container\">\n");
        out.write("                        ");
        if (_jspx_meth_g_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_g_if_2, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_g_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_g_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_2);
      return true;
    }
    _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_2);
    return false;
  }

  private boolean _jspx_meth_g_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_g_if_2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  g:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_g_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_g_forEach_varStatus_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_g_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_g_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_g_if_2);
    _jspx_th_g_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transactions}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_g_forEach_0.setVar("transaction");
    _jspx_th_g_forEach_0.setVarStatus("eachTransaction");
    int[] _jspx_push_body_count_g_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_g_forEach_0 = _jspx_th_g_forEach_0.doStartTag();
      if (_jspx_eval_g_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <form method=\"POST\" action=\"view-transaction\" class=\"transactions-form\">\n");
          out.write("                                <button class=\"transaction-button\">\n");
          out.write("                                    ");
          if (_jspx_meth_g_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_g_forEach_0, _jspx_page_context, _jspx_push_body_count_g_forEach_0))
            return true;
          out.write("\n");
          out.write("                                    ");
          if (_jspx_meth_g_if_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_g_forEach_0, _jspx_page_context, _jspx_push_body_count_g_forEach_0))
            return true;
          out.write("\n");
          out.write("\n");
          out.write("                                        ");
          if (_jspx_meth_fmt_formatNumber_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_g_forEach_0, _jspx_page_context, _jspx_push_body_count_g_forEach_0))
            return true;
          out.write("\n");
          out.write("                                </button>\n");
          out.write("                            </form>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_g_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_g_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_g_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_g_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_g_forEach_0.doFinally();
      _jspx_tagPool_g_forEach_varStatus_var_items.reuse(_jspx_th_g_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_g_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_g_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_g_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  g:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_g_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_g_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_g_if_3.setPageContext(_jspx_page_context);
    _jspx_th_g_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_g_forEach_0);
    _jspx_th_g_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.from.address == currentAddress.address}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_g_if_3 = _jspx_th_g_if_3.doStartTag();
    if (_jspx_eval_g_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <div class=\"primary\">\n");
        out.write("                                            <span class='to-address'>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.to}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                            <span class='transaction-date'>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                        </div>\n");
        out.write("                                        <div class=\"secondary\">\n");
        out.write("                                            <span class='to-amount'>-");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.amountTransferred}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>    \n");
        out.write("                                        </div>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_g_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_g_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_3);
      return true;
    }
    _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_3);
    return false;
  }

  private boolean _jspx_meth_g_if_4(javax.servlet.jsp.tagext.JspTag _jspx_th_g_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_g_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  g:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_g_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_g_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_g_if_4.setPageContext(_jspx_page_context);
    _jspx_th_g_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_g_forEach_0);
    _jspx_th_g_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.to.address == currentAddress.address}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_g_if_4 = _jspx_th_g_if_4.doStartTag();
    if (_jspx_eval_g_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <div class=\"primary\">\n");
        out.write("                                            <span class='from-address'>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.from}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                            <span class='transaction-date'>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.date}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>\n");
        out.write("                                        </div>\n");
        out.write("                                        <div class=\"secondary\">\n");
        out.write("                                            <span class='from-amount'>+");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${transaction.amountTransferred}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>    \n");
        out.write("                                        </div>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_g_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_g_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_4);
      return true;
    }
    _jspx_tagPool_g_if_test.reuse(_jspx_th_g_if_4);
    return false;
  }

  private boolean _jspx_meth_fmt_formatNumber_2(javax.servlet.jsp.tagext.JspTag _jspx_th_g_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_g_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatNumber
    org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag _jspx_th_fmt_formatNumber_2 = (org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag) _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed.get(org.apache.taglibs.standard.tag.rt.fmt.FormatNumberTag.class);
    _jspx_th_fmt_formatNumber_2.setPageContext(_jspx_page_context);
    _jspx_th_fmt_formatNumber_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_g_forEach_0);
    _jspx_th_fmt_formatNumber_2.setMaxFractionDigits(7);
    _jspx_th_fmt_formatNumber_2.setMinFractionDigits(2);
    _jspx_th_fmt_formatNumber_2.setType("number");
    _jspx_th_fmt_formatNumber_2.setGroupingUsed(true);
    _jspx_th_fmt_formatNumber_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allValues[eachToken.index]}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_fmt_formatNumber_2 = _jspx_th_fmt_formatNumber_2.doStartTag();
    if (_jspx_eval_fmt_formatNumber_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_fmt_formatNumber_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_push_body_count_g_forEach_0[0]++;
        _jspx_th_fmt_formatNumber_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_fmt_formatNumber_2.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_fmt_formatNumber_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_fmt_formatNumber_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
        _jspx_push_body_count_g_forEach_0[0]--;
    }
    if (_jspx_th_fmt_formatNumber_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed.reuse(_jspx_th_fmt_formatNumber_2);
      return true;
    }
    _jspx_tagPool_fmt_formatNumber_value_type_minFractionDigits_maxFractionDigits_groupingUsed.reuse(_jspx_th_fmt_formatNumber_2);
    return false;
  }
}
