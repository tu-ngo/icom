package com.nab.icommerce.dto

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.sql.Sql
import org.apache.commons.lang3.StringUtils

import javax.sql.DataSource
import java.nio.charset.StandardCharsets
import java.nio.file.Paths

class TestUtils {

    static String normalizeJsonString(String jsonString) {
        def jsonMap = new JsonSlurper().parseText(jsonString) as Map
        return JsonOutput.toJson(normalizeJsonMap(jsonMap))
    }

    static Map normalizeJsonMap(Map jsonMap) {
        return jsonMap.collectEntries(new TreeMap()) { key, value ->
            switch (value) {
                case Map: return [key, normalizeJsonMap(value as Map)]
                case List: return [key, normalizeJsonList(value as List)]
                default: return [key, value]
            }
        }
    }

    static Set normalizeJsonList(List jsonList) {
        return jsonList.collect(new ArrayList()) { value ->
            switch (value) {
                case Map: return normalizeJsonMap(value as Map)
                case List: return normalizeJsonList(value as List)
                default: return value
            }
        }.sort { it.toString() }.with { new LinkedHashSet(it) }
    }

    static String readFile(String... path) {
        return TestUtils
                .getResource(Paths.get(File.separator, path).toString())
                .getText(StandardCharsets.UTF_8.name())
    }

    static void cleanHsqlDatabase(DataSource dataSource) {
        // Dropping default PUBLIC schema in HSQL DB truncates schema, rather than removes it
        executeSql(dataSource, "DROP SCHEMA PUBLIC CASCADE")
    }

    static void executeSql(DataSource dataSource, String sqlStatements) {
        sqlStatements.split(";").toList()
                .findAll { StringUtils.isNotBlank(it) }
                .each { new Sql(dataSource).execute(it) }
    }
}
