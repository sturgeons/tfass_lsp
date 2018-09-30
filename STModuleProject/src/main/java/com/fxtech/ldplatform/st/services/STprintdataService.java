package com.fxtech.ldplatform.st.services;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxtech.ldplatform.api.abstracts.services.BasePrintService;
import com.fxtech.ldplatform.api.entities.Header;
import com.fxtech.ldplatform.st.mappers.STprintdataMapper;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service("STprintdataService")
public class STprintdataService extends BasePrintService {
	private static final String JASPER_JXML_PATH = "ld_kanban.jasper";
	private @Autowired STprintdataMapper stprintdataMapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return stprintdataMapper.find(params);
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
		Map parameters = new HashMap();
		parameters.put("printDate", (String) params.get("PRINT_DATE"));
		parameters.put("pageNo", (String) params.get("PAGENO"));
		JasperReport jasper = loadResource();

		List<Header> datas = new ObjectMapper().readValue((String) params.get("DATAS"), List.class);

		return JasperFillManager.fillReport(jasper, parameters, new JRBeanCollectionDataSource(datas));
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
