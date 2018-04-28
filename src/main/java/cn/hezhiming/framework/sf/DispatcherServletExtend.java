package cn.hezhiming.framework.sf;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author henrypoter
 *
 */
public class DispatcherServletExtend extends DispatcherServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3211773861497927155L;

	@Override
	protected void doService(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.doService(request, response);
	}

	@Override
	protected void doDispatch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		super.doDispatch(request, response);
	}

	@Override
	protected void initFrameworkServlet() throws ServletException {
		// TODO Auto-generated method stub
		super.initFrameworkServlet();
		//全部bean
		Map<String, Object> beans =new HashMap<String, Object>();

		//获取基本Spring的bean
		beans = getAllBeans(this.getServletContext(), null);
		logger.error("spring容器里bean数量:"+beans.size());
		System.out.println("spring容器里bean数量:"+beans.size());
	}
	
	public static Map<String/*beanName*/, Object/*bean*/> getAllBeans(ServletContext servletContext, PrintStream info)
	{
		Map<String, Object> beans =new HashMap<String, Object>();
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames)
		{
			try
			{
				Object bean = applicationContext.getBean(beanName);
				if(bean!=null)
				{
					beans.put(beanName, bean);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				//info.println("Exception when spring gets bean of name: "+beanName);
			}
		}
		return beans;
	}

}
