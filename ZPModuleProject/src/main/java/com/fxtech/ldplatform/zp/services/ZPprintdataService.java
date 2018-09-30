package com.fxtech.ldplatform.zp.services;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fxtech.ldplatform.api.abstracts.services.BasePrintService;
import com.fxtech.ldplatform.zp.mappers.ZPprintdataMapper;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service("ZPprintdataService")
public class ZPprintdataService extends BasePrintService {
	private static final String JASPER_JXML_PATH = "barcode.jasper";

	private @Autowired ZPprintdataMapper mapper;

	public List<Map<String, ?>> find(Map<String, ?> params) {
		return mapper.find(params);
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
		List<Map<String, ?>> datas = find(params);

		return JasperFillManager.fillReport(loadResource(),  new HashMap(),
				datas.size() > 0 ? new JRBeanCollectionDataSource(datas) : new JREmptyDataSource());
	}

	/**
	 * @return 报表模板
	 */
	private static JasperReport loadResource() {
		InputStream in = null;
		JasperReport jr = null;

		try {
			// 加载模板文件
			in = ZPprintdataService.class.getResourceAsStream(JASPER_JXML_PATH);
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
