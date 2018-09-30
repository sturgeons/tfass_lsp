import java.applet.Applet;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author Ajaxfan
 */
public class BaseApplet extends Applet {
	private static final long serialVersionUID = 3007717280460840364L;

	/** 请求地址格式定义 */
	private static final String URL_BASE = "/printService/%s?meta=%s&data=%s&params=%s";

	/** 编码格式 */
	private static final String ENCODING = "UTF-8";

	/**
	 * 报表打印服务
	 * 
	 * @param serviceName
	 *            要调用的服务名称
	 * @param meta
	 *            待打印表格的头信息
	 * @param data
	 *            待打印表格的数据
	 * @param params
	 *            附加参数信息
	 */
	public void printReport(String serviceName, String meta, String data, String params) {
		try {
			URL url = new URL(getCodeBase(),
					String.format(URL_BASE, serviceName, encode(meta), encode(data), encode(params)));
			
			System.out.println("fxtech: "+ url);
			JasperPrint jr = (JasperPrint) JRLoader.loadObject(url);
			
			System.out.println(jr);

			printAction(jr);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "打印执行失败，更多信息请查看运行日志");
			e.printStackTrace();
		}
	}

	/**
	 * 字符串编码
	 * 
	 * @param content
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected String encode(String content) throws UnsupportedEncodingException {
		return URLEncoder.encode(content == null || content.trim().length() == 0 ? "{}" : content, ENCODING);
	}

	/**
	 * 报表打印
	 * 
	 * @param jasperPrint
	 *            报表对象
	 */
	protected void printAction(JasperPrint jasperPrint) throws Exception {
		JasperPrintManager.printReport(jasperPrint, false);
	}
}
