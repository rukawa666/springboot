package com.steven.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-01 23:50
 *
 * 将配置文件中配置的每一个属性的值，映射到这个组件
 * @ConfigurationProperties:告诉springboot将本类中的所有属性和配置文件中的相关配置进行绑定
 *      prefix = "person":配置文件中哪个下面的属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能给容器提供@ConfigurationProperties功能
 *
 * @Component:将普通的pojo实例化到spring容器中
 *
 * @Value:value="字面量/${key}从环境变量、配置文件中获取值/#{SpEl}"
 *
 * @ConfigurationProperties和@Value的区别
 * 功能           @ConfigurationProperties         @Value
 * 松散绑定        批量注入配置文件中的属性           一个个指定
 * SpEl           不支持                           支持
 * JSR303校验     支持                             不支持
 * 复杂类型的封装  支持                             不支持
 *
 * @Validated:开启JSR303校验
 * @PropertySource(value= {"classpath:person.properties"}):加载指定的配置文件
 * @ImportResource:导入spring的配置文件，让配置文件里面的内容生效
 *   必须标注在一个配置类上
 */
@PropertySource(value= {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class Person {

//    @Value("${person.last-name}")
//    @Email
    private String lastName;
//    @Value("#{11 * 2}")
    private Integer age;
//    @Value("true")
    private Boolean boss;
    private Date birth;

//    @Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }
}
