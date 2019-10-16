package com.zoengsihou.mall;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义注释生成器
 * @author zoengsihou
 */

public class CommentGenerator extends DefaultCommentGenerator {

    /**
     * 给model类添加注释
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        String remarks = introspectedTable.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            StringBuilder sb = new StringBuilder();
            sb.append("@ApiModel(value = \"");
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            List<String> remarksList = Arrays.asList(remarkLines);
            String remark = String.join(",", remarksList);
            sb.append(remark);
            sb.append("\")");
            topLevelClass.addJavaDocLine(sb.toString());
        }
    }

    /**
     * 给字段添加注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        if (StringUtility.stringHasValue(remarks)) {
            // 将注释中的双引号转化为单引号
            if (remarks.contains("\"")) {
                remarks = remarks.replace("\"", "'");
            }
            // 在model类的每个变量上添加swagger注解
            field.addJavaDocLine("@ApiModelProperty(value = \"" + remarks + "\")");
        }
    }

    /**
     * 在model的类文件中导入swagger注解类
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        // 排除Mapper接口和Example类
        if (!compilationUnit.isJavaInterface() && !compilationUnit.getType().getFullyQualifiedName().contains("Example")) {
            compilationUnit.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.ApiModelProperty"));
            compilationUnit.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.ApiModel"));
        }
    }

}
