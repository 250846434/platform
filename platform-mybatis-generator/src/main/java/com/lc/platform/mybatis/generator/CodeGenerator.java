package com.lc.platform.mybatis.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	public static String scanner(String tip) {
//		Scanner scanner = new Scanner(System.in);
//		StringBuilder help = new StringBuilder();
//		help.append("请输入" + tip + "：");
//		System.out.println(help.toString());
//		if (scanner.hasNext()) {
//			String ipt = scanner.next();
//			if (StringUtils.isNotEmpty(ipt)) {
////				scanner.close();
//				return ipt;
//			}
//		}
////		scanner.close();
//		throw new MybatisPlusException("请输入正确的" + tip + "！");
		if("模块名".equals(tip)) {
			return "login";
		}else if("表名".equals(tip)) {
			return "sys_user";
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");//当前工程路径
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor("lc");
//		gc.setOpen(true);
		gc.setEnableCache(true);
		gc.setFileOverride(true);
		gc.setEntityName("%s");
		gc.setMapperName("%sDao");
		gc.setXmlName("%sDao");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setControllerName("%sController");
//		gc.setSwagger2(true);
		gc.setBaseResultMap(true);
//		gc.setActiveRecord(true);
		gc.setDateType(DateType.ONLY_DATE);
		gc.setBaseColumnList(true);
		gc.setIdType(IdType.AUTO);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://localhost:3306/ck?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8");
		// dsc.setSchemaName("public");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("Admin@123User");
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(scanner("模块名"));
		pc.setParent("com.lc.platform.web");
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		List<FileOutConfig> focList = new ArrayList<>();
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"
						+ tableInfo.getEntityName() + "Dao" + StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
		mpg.setTemplate(new TemplateConfig().setXml(null));

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperEntityClass("com.lc.platform.mybatis.base.BaseEntity");
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(false);
		strategy.setSuperControllerClass("com.lc.platform.mybatis.base.BaseController");
		strategy.setInclude(scanner("表名"));
		strategy.setSuperEntityColumns("id","create_date","create_user","update_date","update_user","delete_flag","sys_version","remark");
//		strategy.setControllerMappingHyphenStyle(true);
//		strategy.setTablePrefix(pc.getModuleName() + "_");
		strategy.entityTableFieldAnnotationEnable(true);
		strategy.setLogicDeleteFieldName("delete_flag");
		strategy.setVersionFieldName("sys_version");
		List<TableFill> tableFillList= new ArrayList<>();
		tableFillList.add(new TableFill("create_date",FieldFill.INSERT));
		tableFillList.add(new TableFill("create_user",FieldFill.INSERT));
		tableFillList.add(new TableFill("update_date",FieldFill.INSERT_UPDATE));
		tableFillList.add(new TableFill("update_user",FieldFill.INSERT_UPDATE));
		strategy.setTableFillList(tableFillList);
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
}
