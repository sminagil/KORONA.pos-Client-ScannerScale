/**
 * 
 */
package net.combase.scale;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author "Till Freier"
 *
 */
public class KoronaShellConnector implements ScanCodeHandler
{

	public void handle(String code)
	{
		try
		{
			final Socket soc = new Socket("localhost", 9000);
			final OutputStream os = soc.getOutputStream();

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

			char[] charArray = code.toCharArray();
			for (char c : charArray)
			{
				if (c >= '0' && c <= '9')
				{
					int macro = c - '0' + 48;
					System.out.println("run macro " + macro);
					bw.write("runMacro(\"" + macro + "\");");
				}
			}
			bw.write("runMacro(\"" + 1031 + "\");");

			bw.flush();
			bw.close();
			soc.close();
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
