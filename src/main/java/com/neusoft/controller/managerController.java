package com.neusoft.controller;

import com.neusoft.bean.Manager;
import com.neusoft.dao.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.security.PrivateKey;
import java.util.List;
import java.util.Scanner;

@Controller
@RequestMapping("test")
public class managerController {
    @Autowired
   private ManagerMapper mapper;

    @RequestMapping("cao")
    @ResponseBody

    //根据id查找
    public String findByid() throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入ID：");
        int a=scanner.nextInt();
        Manager manager=mapper.selectByPrimaryKey(a);
       Field field[]= manager.getClass().getDeclaredFields();
       StringBuffer buff=new StringBuffer();
       for(int i=0;i<field.length;i++){
           field[i].setAccessible(true);
           buff.append(field[i].getName()+":"+field[i].get(manager)+"  ");
       }

  System.out.println(buff);
        return "test";
    }
//根据id删除
    public void deleteBYID(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入ID：");
        int a=scanner.nextInt();
        int rows=mapper.deleteByPrimaryKey(a);
        System.out.println(rows);

    }
    //查询所有
    public void findAll() throws Exception{
        List<Manager> list=mapper.selectAll();
        for (Manager manager:list
             ) {
            Field field[]= manager.getClass().getDeclaredFields();
            StringBuffer buff=new StringBuffer();
            for(int i=0;i<field.length;i++){
                field[i].setAccessible(true);
                buff.append(field[i].getName()+":"+field[i].get(manager)+"  ");
            }
            System.out.println(buff);
        }
    }




    public static void main(String[] args) throws  Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext-spring.xml");
        managerController managerController=ac.getBean(managerController.class);
        managerController.findAll();
    }
}
