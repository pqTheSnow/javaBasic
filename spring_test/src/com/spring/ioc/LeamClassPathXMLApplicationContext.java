package com.spring.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import javax.lang.model.element.Element;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PQ on 2016/6/30.
 */
public class LeamClassPathXMLApplicationContext {
    private List<Definition> beanDefines = new ArrayList<Definition>();
    private Map<String, Object> sigletons = new HashMap<String, Object>();

    public LeamClassPathXMLApplicationContext(String fileName) {
        this.readXML(fileName);
        this.instanceBeans();
        this.injectObject();
    }

    /**
     * 为bean对象的属性注入值
     */
    private void injectObject() {
        for (Definition beanDefinition : beanDefines){
            Object bean = sigletons.get(beanDefinition.getId());
            if (bean != null){
                try {
                    PropertyDescriptor[] ps = Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();
                    for(ProsDefinition propertyDefinition : beanDefinition.getProperties()){
                        for (PropertyDescriptor properdesc : ps) {
                            if (propertyDefinition.getName().equals(properdesc.getName())) {
                                Method setter = properdesc.getWriteMethod();//获取属性的setter方法
                                if (setter != null){
                                    Object value = sigletons.get(propertyDefinition.getRef());
                                    setter.setAccessible(true);
                                    setter.invoke(bean, value);//把引用对象注入到属性
                                }
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 完成bean的实例化
     */
    private void instanceBeans() {
        for (Definition beanDefinition : beanDefines){
            try {
                if (beanDefinition.getClassName() != null && !"".equals(beanDefinition.getClassName().trim())){
                    sigletons.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).newInstance());
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取xml配置文件
     * @param fileName
     */
    private void readXML(String fileName) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            URL xmlpath = this.getClass().getClassLoader().getResource(fileName);
            document = saxReader.read(xmlpath);
            Map<String, String> nsMap = new HashMap<String, String>();
            nsMap.put("ns", "http://www.springframework.org/schema/beans");//加入命名空间
            XPath xsub = document.createXPath("//ns:beans/ns:bean");//创建beans/bean查询路径
            xsub.setNamespaceURIs(nsMap);// 设置命名空间
            List<Element> beans = xsub.selectNodes(document);//获取文档下所有bean节点
            for (Element element : beans) {
                //String id = element.
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
