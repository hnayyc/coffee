package com.hnayyc.coffee.ioc.dao;

import com.hnayyc.coffee.ioc.annotation.Column;
import com.hnayyc.coffee.ioc.annotation.Table;

import java.lang.reflect.Field;

public class BaseDao<T> {
    //最终目标：insert into user (NAME,password) VALUES('cai','123456');

    public String save(T entity) throws IllegalArgumentException, IllegalAccessException {
        //sql用于存放最终返回的sql语句
        StringBuilder sql = new StringBuilder("insert into ");
        //tableName用于存放sql语句中表名部分
        StringBuilder tableName;
        //columnName用于存放sql语句的字段部分
        StringBuilder columnName = new StringBuilder("(");
        //values用于存放sql语句中的赋值部分
        StringBuilder values = new StringBuilder("(");
        //获取对象user的class对象
        Class clazz = entity.getClass();
        //判断该User类是否有@Table注解
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if(isTable) {
            //获取User类@Table注解的值value，该值我们定义为User表的表名称
            Table t = (Table) clazz.getAnnotation(Table.class);
            tableName = new StringBuilder(t.value());
            //拼接表名
            sql.append(tableName+" ");
            //获取user对象的属性列表
            Field[] fieldList = clazz.getDeclaredFields();
            //遍历属性列表，分别拿出属性列表中被@Column注解的属性，并获取属性的值
            for(int i=0;i<fieldList.length;i++){
                Field f =  fieldList[i];
                boolean isColumn = f.isAnnotationPresent(Column.class);
                if(!isColumn){
                    continue;
                }
                Column column = f.getAnnotation(Column.class);
                f.setAccessible(true);
                Object columnValue = f.get(entity);
                if(i==fieldList.length-1){
                    columnName.append(column.value()+") VALUES ");
                    values.append("'"+columnValue+"')");
                    sql.append(columnName);
                    sql.append(values);
                    continue;
                }
                columnName.append(column.value()+", ");
                values.append("'"+columnValue+"',");
            }

            // boolean isColumn = clazz.isAnnotationPresent(annotationClass);
        }
        return sql.toString();
    }
}
