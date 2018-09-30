package com.fxtech.ldplatform.st.services;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.abstracts.services.BasePrintService;
import com.fxtech.ldplatform.st.mappers.STlddataMapper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service("STlddataService")
public class STlddataService extends BasePrintService {
	private static final String JASPER_JXML_PATH = "ld_kanban.jasper";
	private @Autowired STlddataMapper stlddataMapper;

	public Object find(Map<String, ?> params) {
		return stlddataMapper.find(params);
	}

	/**
	 * 打印报表信息
	 * 
	 * @param meta
	 * @param data
	 * @param param
	 * @param portrait
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object print(Map<String, ?> params) throws Exception {
		Date print_date = new Date();
		String pageNo = stlddataMapper.nextPageNo();

		Map parameters = new HashMap();
		parameters.put("printDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(print_date));
		parameters.put("pageNo", pageNo);
		JasperReport jasper = loadResource();

		// 保存打印记录
		stlddataMapper.save(pageNo, new ObjectMapper().writeValueAsString(params.get("datas")), print_date);

		return JasperFillManager.fillReport(jasper, parameters,
				new JRBeanCollectionDataSource((List) params.get("datas")));
	}

	/**
	 * @return 报表模板
	 */
	private static JasperReport loadResource() {
		InputStream in = null;
		JasperReport jr = null;

		try {
			// 加载模板文件
			in = STlddataService.class.getResourceAsStream(JASPER_JXML_PATH);
			// 通过模板来创建Jasper对象
			jr = (JasperReport) JRLoader.loadObject(in);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					in = null;
				}
			}
		}
		return jr;
	}
}
