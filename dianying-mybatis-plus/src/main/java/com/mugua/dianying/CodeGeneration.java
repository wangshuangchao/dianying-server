package com.mugua.dianying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 
 * @ClassName: CodeGeneration
 * @Description: 代码生成器
 * @author cheng
 * @date 2018年1月25日 下午2:55:14
 */
public class CodeGeneration {

	/**
	 * 
	 * @Title: main
	 * @Description: 生成
	 * @param args
	 */
	public static void main(String[] args) {
		// 用来获取mybatis-plus.properties文件的配置信息
		final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");
		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(rb.getString("OutputDir"));
		gc.setOutputDir("C://Users//28695//Desktop//java");
		gc.setFileOverride(true);
		gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		gc.setAuthor(rb.getString("author"));// 作者

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setControllerName("%sController");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		/*
		 * dsc.setTypeConvert(new MySqlTypeConvert(){ // 自定义数据库表字段类型转换【可选】
		 * 
		 * @Override public DbColumnType processTypeConvert(String fieldType) {
		 * System.out.println("转换类型：" + fieldType); return
		 * super.processTypeConvert(fieldType); } });
		 */

		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName(rb.getString("mysql.driver"));
		dsc.setUrl(rb.getString("mysql.url"));
		dsc.setUsername(rb.getString("mysql.username"));
		dsc.setPassword(rb.getString("mysql.password"));
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();

		// strategy.setCapitalMode(true);// 全局大写命名
	    //strategy.setTablePrefix(new String[] { "sys_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setInclude(new String[] { "board",
				"board_extend_type",
				"board_log",
				"client_user",
				"extend_type",
				"extend_type_log",
				"extend_type_val",
				" jurisdiction",
				"role",
				"role_jurisdiction",
				"role_log",
				"slice",
				"slice_log",
				"sysoperator",
				"sysoperator_log",
				"sysoperators_role",
				"user_log",
				"val_scope",
				"val_scope_log",
				"video_file",
				"video_file_log",
				"video_info",
				"video_info_board",
				"video_info_log"}); // 需要生成的表
		// strategy.setExclude(new String[]{"test"});// 排除生成的表
		strategy.setEntityLombokModel(true);// lombok类型的bean
		strategy.setSuperServiceClass(null);
		strategy.setSuperServiceImplClass(null);
		strategy.setSuperMapperClass(null);

		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		// pc.setModuleName("tbldept");//模块名称，单独生成模块时使用！！！！！！！！！！！
		pc.setParent(rb.getString("parent"));
		pc.setController("controller");
		pc.setService("service");
		pc.setServiceImpl("service.Impl");
		pc.setMapper("mapper");
		pc.setEntity("entity");
		pc.setXml("xml");
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-rb");
				this.setMap(map);
			}
		};

		// 调整 xml 生成目录演示
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				return rb.getString("OutputDirXml") + "/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
			}
		});
		cfg.setFileOutConfigList(focList);
		
		mpg.setCfg(cfg);
		// 关闭默认 xml 生成，调整生成 至 根目录
		TemplateConfig tc = new TemplateConfig();
		tc.setXml(null);
		mpg.setTemplate(tc);

		// 执行生成
		mpg.execute();

	}

}
