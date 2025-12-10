package com.sct.demo.config;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.stream.Collectors;

import org.hibernate.boot.model.naming.ImplicitConstraintNameSource;
import org.hibernate.boot.model.naming.ImplicitForeignKeyNameSource;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;

/**
 * 最小化改动：仅覆盖字符串生成逻辑，保留父类其他所有行为
 */
public class HibernateImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

    @Override
    protected String generateConstraintNameString(ImplicitConstraintNameSource source) {
        // 1. 确定前缀 (使用父类方法但转小写: FK -> fk)
        String prefix = constraintNamePrefix(source.kind()).toLowerCase();

        // 2. 获取表名
        String tableName = stripQuotes(source.getTableName().getText());

        // 3. 获取字段名列表并拼接
        String columns = source.getColumnNames().stream()
                .map(id -> stripQuotes(id.getText()))
                .collect(Collectors.joining("_"));

        // 特殊处理外键：如果没有列名（JPA默认），使用引用表名
        if (source instanceof ImplicitForeignKeyNameSource && columns.isEmpty()) {
            columns = stripQuotes(((ImplicitForeignKeyNameSource) source).getReferencedTableName().getText());
        }

        // 4. 拼接最终字符串 (可以在这里把连续下划线替换成单下划线)
        String rawName = (prefix + "_" + tableName + "_" + columns).replace("__", "_");

        // 5. 安全截断 (63字符限制 + MD5后缀)
        return truncateValidly(rawName);
    }

    private String truncateValidly(String name) {
        if (name.length() <= 63) {
            return name;
        }
        // 简单截断+Hash逻辑，保证唯一
        String hash = md5Hex(name).substring(0, 6);
        return name.substring(0, 63 - 7) + "_" + hash;
    }

    private String stripQuotes(String name) {
        return name == null ? "" : name.replace("\"", "").replace("`", "");
    }

    private String md5Hex(String input) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(String.format("%02x", digest[i]));
            }
            return sb.toString();
        } catch (Exception e) {
            // 极低概率的回退方案：取绝对值后再转 hex
            return Integer.toHexString(Math.abs(input.hashCode()));
        }
    }

}
