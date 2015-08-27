/**
 * 
 */
package net.combase.scale;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author "Till Freier"
 *
 */
public class ScannerScaleApplication
{


	public static void main(String[] args) throws Exception
	{
		Server server = new Server(8080);
		WebAppContext c = new WebAppContext();
		c.setServer(server);
		// c.setWar(ScannerScaleApplication.class.getClassLoader().getResource("/").toExternalForm());
		c.setClassLoader(new WebAppClassLoader(ScannerScaleApplication.class.getClassLoader(), c));
		c.setDescriptor(ScannerScaleApplication.class.getResource("web/WEB-INF/web.xml").toString());
		c.setResourceBase(ScannerScaleApplication.class.getResource("web").toString());
		server.setHandler(c);
		server.start();
		server.join();
	}
}