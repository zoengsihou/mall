package com.zoengsihou.mall;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * MBG生成类
 * @author zoengsihou
 */

public class Generator {
    public static void main(String[] args) throws Exception {
        // MBG配置文件路径
        String fileName = "X:\\IdeaProjects\\mall\\mall-mbg\\src\\main\\resources\\generatorConfig.xml";
        File configFile = new File(fileName);
        // MBG执行过程中的警告信息
        List<String> warnings = new ArrayList<String>();
        // 生成的文件已存在时,覆盖原文件
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        // 执行生成代码
        myBatisGenerator.generate(null);
        // 输出警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
